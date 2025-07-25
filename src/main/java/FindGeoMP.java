import org.biojava.nbio.structure.*;
import org.biojava.nbio.structure.io.PDBFileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


public class FindGeoMP {


    Integer nlig, matnum, mrsnum, nper;
    String matnam, mrsnam, mchain;
    double[] xmetal;
    double[][] xm;
    double[][] xmrot;
    double[] dist;
    int[] atnum;
    String[] atnam;
    String[] rsnam;
    String[] chain;
    int[] rsnum;
    int[][] per;
    double[] best;
    double[][] q;
    double[][] xf;
    double[][] dxm;
    double[][] dxp;
    double[] rmsdpl;

    Integer maxlig, maxper;
    Double rmsd;
    String findGeoInput;

    String outputFolder;

    String geoBest;

    String tagBest;

    Double rmsdBest;

    public FindGeoMP(String findGeoInput, String outputFolder) {
        this.findGeoInput = findGeoInput;
        this.outputFolder = outputFolder;
        this.geoBest = "irr";
        this.tagBest = "Irregular";
        this.rmsdBest = 99.999;
        this.maxlig = 9;
        this.maxper = 362880;
        this.xmetal = new double[3];
        this.xm = new double[maxlig][3];
        this.xmrot = new double[maxlig][3];
        this.dist = new double[maxlig];
        this.atnum = new int[maxlig];
        this.atnam = new String[maxlig];
        this.rsnam = new String[maxlig];
        this.chain = new String[maxlig];
        this.rsnum = new int[maxlig];
        this.per = new int[maxper][maxlig];
        this.best = new double[5];
        this.q = new double[4][4];
        this.xf = new double[maxlig][3];
        this.dxm = new double[maxlig][3];
        this.dxp = new double[maxlig][3];
        this.rmsdpl = new double[maxlig];
        this.nlig = -1;
        this.matnum = 0;
        this.mrsnum = 0;
        this.nper = 0;
        this.matnam = null;
        this.mrsnam = null;
        this.mchain = null;
    }

    public void startCalculation() throws IOException, StructureException {


        //System.out.println(args.length + " "+ findgeoInput);
        readInput(findGeoInput);
        if (isEmptyStringArray(atnam)) {
            printLine();
            System.out.println("Unable to parse input file.");
            printLine();
            System.exit(-1);
        }
        rearrangingInputStructure();
        calcBestResult();
    }

    private boolean isEmptyStringArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                return false;
            }
        }
        return true;
    }

    private  void readInput(String findGeoInput)  {

        if (!fileExists(findGeoInput)) {
            printLine();
            System.out.println("Input file: " + findGeoInput + " not found!");
            printLine();
            System.exit(-1);
        }

       /* PDBFileReader pdbreader = new PDBFileReader();
        Structure structure = null;
        try {
            structure = StructureIO.getStructure(findGeoInput);

        } catch (StructureException e) {
            printLine();
            System.out.println(findGeoInput + " not found!");
            printLine();
            System.exit(-1);
        } catch (Exception e) {
            printLine();
            System.out.println(e);
            printLine();
            System.exit(-1);
        }
        nlig = -1;
        for (Chain c : structure.getChains()) {

            System.out.println("Chain " + c.getName() + " details:");
            System.out.println("Atom ligands: " + c.getAtomGroups());
            for (Group g : c.getAtomGroups()) {
                for (Atom a : g.getAtoms()) {
                    nlig++;
                    if (nlig > maxlig) {
                        printLine();
                        System.out.println("!!! Maximum number of ligands exceeded !!!");
                        printLine();
                        System.exit(-1);
                    }
                    //System.out.println(nlig);
                    //System.out.println(g.getAtom(0).getPDBserial());
                    if (nlig == 0) {
                        matnum = a.getPDBserial();
                        matnam = a.getName();
                        mrsnam = g.getPDBName();
                        mchain = g.getChain().getName();
                        mrsnum = g.getResidueNumber().getSeqNum();
                        xmetal[0] = a.getX();
                        xmetal[1] = a.getY();
                        xmetal[2] = a.getZ();

                    } else {
                        atnum[nlig - 1] = a.getPDBserial();
                        atnam[nlig - 1] = a.getName();
                        rsnam[nlig - 1] = g.getPDBName();
                        chain[nlig - 1] = g.getChain().getName();
                        rsnum[nlig - 1] = g.getResidueNumber().getSeqNum();
                        xm[nlig - 1][0] = a.getX();
                        xm[nlig - 1][1] = a.getY();
                        xm[nlig - 1][2] = a.getZ();
                    }
                }
            }
        }*/

        //myPDBFileReader pdbFileReader = new myPDBFileReader();
        //List<PDBStructure> structure = pdbFileReader.readPDBFile(findGeoInput);
        myCIFFileReader cifFileReader = new myCIFFileReader();
        List<CIFStructure> structure = cifFileReader.readCIFFile(findGeoInput);
        nlig = -1;
        for(CIFStructure s: structure) {
            nlig++;
            if (nlig > maxlig) {
                printLine();
                System.out.println("!!! Maximum number of ligands exceeded !!!");
                printLine();
                System.exit(-1);
            }
            if (nlig == 0) {
                matnum = s.getAtomNumber();
                matnam = s.getAtomName();
                mrsnam = s.getResidueName();
                mchain = s.getChain();
                mrsnum = s.getResidueNumber();
                xmetal[0] = s.getXCoordinate();
                xmetal[1] = s.getYCoordinate();
                xmetal[2] = s.getZCoordinate();

            } else {
                atnum[nlig - 1] = s.getAtomNumber();
                atnam[nlig - 1] = s.getAtomName();
                rsnam[nlig - 1] = s.getResidueName();
                chain[nlig - 1] = s.getChain();
                rsnum[nlig - 1] = s.getResidueNumber();
                xm[nlig - 1][0] = s.getXCoordinate();
                xm[nlig - 1][1] = s.getYCoordinate();
                xm[nlig - 1][2] = s.getZCoordinate();
            }
        }

    }

    private void rearrangingInputStructure() {
        System.out.println("Rearranging the input structure...");
        for (int k = 0; k < nlig; k++) {
            for (int i = 0; i < 3; i++) {
                xm[k][i] = xm[k][i] - xmetal[i];
            }
        }

        for (int k = 0; k < nlig; k++) {
            dist[k] = Math.sqrt(Math.pow(xm[k][0], 2) + Math.pow(xm[k][1], 2) + Math.pow(xm[k][2], 2));
            for (int i = 0; i < 3; i++) {
                xm[k][i] = 3. * xm[k][i] / dist[k];
            }
        }

        System.out.println("Input structure rearranged.");
    }

    private void calcBestResult() {

        if (nlig < 1 || nlig > maxlig) {
            Formatter output;

            try {
                output = new Formatter(outputFolder + "findgeo.out");

                //System.out.println("nlig: " + nlig);

                output.format("------------------------------------------------------------------------------------------------\n");
                output.format("Coordination number: %d                                                                    \n", nlig);
                output.format("Geometries tested               | Tag                | RMSD                                     \n");
                output.format("------------------------------------------------------------------------------------------------\n");
                output.format("                                | n/a                | n/a                                      \n");
                output.close();

            } catch (FileNotFoundException e) {
                System.out.println(e);
                System.exit(-1);
            }
            System.exit(-1);
        }

        HashMap<String, double[][][]> geometries = new LinkedHashMap<>();

        Constants constants = new Constants();

        HashMap<String, List<Double>> distortedIrregular = constants.getDistortedIrregular();

        HashMap<String, String> geometryNames = constants.getGeometryNames();


        //System.out.println("nlig " + nlig);
        if (nlig == 2) {
            nper = 2;
            generatePermutations();

            GenerateGeometryTemplate ggt = new GenerateGeometryTemplate(per, nper);
            geometries.put("lin", ggt.linGeometryTemplate());
            geometries.put("trv", ggt.trvGeometryTemplate());

        } else if (nlig == 3) {
            /**************************************************************
             *   Three ligands --> 6 permutations
             **************************************************************/
            nper = 6;

            generatePermutations();

            GenerateGeometryTemplate ggt = new GenerateGeometryTemplate(per, nper);
            geometries.put("tri", ggt.triGeometryTemplate());
            geometries.put("tev", ggt.tevGeometryTemplate());
            geometries.put("spv", ggt.spvGeometryTemplate());


        } else if (nlig == 4) {

            /**************************************************************
             *   Four ligands --> 24 permutations
             **************************************************************/
            nper = 24;

            generatePermutations();

            GenerateGeometryTemplate ggt = new GenerateGeometryTemplate(per, nper);

            geometries.put("tet", ggt.tetGeometryTemplate());
            geometries.put("spl", ggt.splGeometryTemplate());
            geometries.put("bva", ggt.bvaGeometryTemplate());
            geometries.put("bvp", ggt.bvpGeometryTemplate());
            geometries.put("pyv", ggt.pyvGeometryTemplate());

        } else if (nlig == 5) {

            /**************************************************************
             *   Five ligands --> 120 permutations
             **************************************************************/
            nper = 120;

            generatePermutations();

            GenerateGeometryTemplate ggt = new GenerateGeometryTemplate(per, nper);

            geometries.put("spy", ggt.spyGeometryTemplate());
            geometries.put("tbp", ggt.tbpGeometryTemplate());
            geometries.put("tpv", ggt.tpvGeometryTemplate());


        } else if (nlig == 6) {

            /**************************************************************
             *   Six ligands --> 720 permutations
             **************************************************************/
            nper = 720;

            generatePermutations();

            GenerateGeometryTemplate ggt = new GenerateGeometryTemplate(per, nper);

            geometries.put("oct", ggt.octGeometryTemplate());
            geometries.put("tpr", ggt.tprGeometryTemplate());
            geometries.put("pva", ggt.pvaGeometryTemplate());
            geometries.put("pvp", ggt.pvpGeometryTemplate());
            geometries.put("cof", ggt.cofGeometryTemplate());
            geometries.put("con", ggt.conGeometryTemplate());
            geometries.put("ctf", ggt.ctfGeometryTemplate());
            geometries.put("ctn", ggt.ctnGeometryTemplate());

        } else if (nlig == 7) {

            /**************************************************************
             *   Seven ligands --> 5040 permutations
             **************************************************************/

            nper = 5040;

            generatePermutations();

            GenerateGeometryTemplate ggt = new GenerateGeometryTemplate(per, nper);

            geometries.put("pbp", ggt.pbpGeometryTemplate());
            geometries.put("coc", ggt.cocGeometryTemplate());
            geometries.put("ctp", ggt.ctpGeometryTemplate());
            geometries.put("hva", ggt.hvaGeometryTemplate());
            geometries.put("hvp", ggt.hvpGeometryTemplate());
            geometries.put("cuv", ggt.cuvGeometryTemplate());
            geometries.put("sav", ggt.savGeometryTemplate());


        } else if (nlig == 8) {
            /**************************************************************
             *   Eight ligands --> 40320 permutations
             **************************************************************/

            nper = 40320;

            generatePermutations();

            GenerateGeometryTemplate ggt = new GenerateGeometryTemplate(per, nper);

            geometries.put("hbp", ggt.hbpGeometryTemplate());
            geometries.put("cub", ggt.cubGeometryTemplate());
            geometries.put("sqa", ggt.sqaGeometryTemplate());
            geometries.put("boc", ggt.bocGeometryTemplate());
            geometries.put("bts", ggt.btsGeometryTemplate());
            geometries.put("btt", ggt.bttGeometryTemplate());

        } else if (nlig == 9) {

            /**************************************************************
             *   Nine ligands --> 362880 permutations
             **************************************************************/

            nper = 362880;
            generatePermutations();

            GenerateGeometryTemplate ggt = new GenerateGeometryTemplate(per, nper);

            geometries.put("ttp", ggt.ttpGeometryTemplate());
            geometries.put("csa", ggt.csaGeometryTemplate());
        }
        try {
            doCalculation(geometries, distortedIrregular, geometryNames);
        } catch (FileNotFoundException e) {
            System.out.println(e);
            System.exit(-1);
        }

    }

    private void doCalculation(HashMap<String, double[][][]> geometries, HashMap<String, List<Double>> distortedIrregular, HashMap<String, String> geometryNames) throws FileNotFoundException {
        /****************************************************************
         *  Initialization of the best result among all the permutations
         *  The five components of best represent:
         *     1 - 4 : eigenvector
         *     5 : eigenvalue
         *     Ibest : index of the best permutation
         ****************************************************************/


        Formatter output;
        output = new Formatter(outputFolder + "findgeo.out");

        String line = "------------------------------------------------------------------------------------------------\n";
        output.format(line);
        output.format("Coordination number: %d                                                                    \n", nlig);
        output.format(line);
        output.format("Geometries tested                                                            |      Tag|    RMSD\n");
        output.format(line);


        for (Map.Entry<String, double[][][]> geometry : geometries.entrySet()) {
            String tag = "Irregular";

            for (int i = 0; i < 5; i++) {
                best[i] = 99999.;
            }

            int ibest = 0;

            /**************************************************************
             *   Cycle over the permutations
             **************************************************************/
            for (int n = 0; n < nper; n++) {
                //System.out.println("Permutation number: " + n);
                for (int k = 0; k < nlig; k++) {
                    for (int i = 0; i < 3; i++) {
                        xf[k][i] = geometry.getValue()[n][k][i];
                    }
                }

                qMatrixConstruction();

                /**************************************************************
                 * Check: print out the initial q matrix
                 **************************************************************/
                /*System.out.println("Print initial q matrix");
                for (int i = 0; i < 4; i++) {
                    System.out.println(q[i][0] + " " + q[i][1] + " " + q[i][2] + " " + q[i][3]);
                }*/


                /**************************************************************
                 * Orthogonalization by Jacobi rotation = solution of EV problem
                 **************************************************************/
                //System.out.println("q lenght: " + q.length);


                /*BIJJacobi jacobi = new BIJJacobi(q, true);
                try {
                    jacobi.compute();
                } catch (Exception e) {
                    printLine();
                    System.out.println(e);
                    printLine();
                    System.exit(-1);
                }
                jacobi.sort();

               */

                NMJacobi solver = new NMJacobi(q);
                solver.jacobiEigenvalueDecomposition();
                solver.sortEigenvaluesAndEigenvectors();

               // AnotherJacobi anotherJacobi = new AnotherJacobi();
               // AnotherJacobi.EigenResult eigenResult = anotherJacobi.jacobiEigenvalueDecomposition(q, q.length);


                //if (jacobi.eigenvalues[3] < best[4] && jacobi.eigenvalues[3] >= 0) {
                if (solver.getEigenvalues()[3] < best[4]) {
                //if (eigenResult.getEigenvalues()[3] < best[4]) {

                    for (int i = 0; i < 4; i++) {
                        //best[i] = jacobi.eigenvectors[i][3];
                        best[i] = solver.getEigenvectors()[i][3];
                        //best[i] = eigenResult.getEigenvectors()[i][3];
                    }
                    //best[4] = jacobi.eigenvalues[3];
                    best[4] = solver.getEigenvalues()[3];
                    //best[4] = eigenResult.getEigenvalues()[3];
                    ibest = n;
                }
            }

            rmsd = Math.sqrt(Math.abs(best[4] / nlig));
            //System.out.println(rmsd);
            if (rmsd <= distortedIrregular.get(geometry.getKey()).get(0)) {
                tag = "Regular";
            } else if (rmsd > distortedIrregular.get(geometry.getKey()).get(0) && rmsd <= distortedIrregular.get(geometry.getKey()).get(1)) {
                tag = "Distorted";
            }


            if (!tag.equals("Irregular")) {
                //System.out.println("tag: " + tag + " rmsd: " + rmsd + " rmsdBest: " + rmsdBest);
                //System.out.println(rmsd < rmsdBest);
                if (rmsd < rmsdBest) {
                    rmsdBest = rmsd;
                    geoBest = geometry.getKey();
                    tagBest = tag;
                }
            }


            System.out.printf("Best RMSD for %s geometry: %1.3f tag: %s\n", geometry.getKey(), rmsd, tag);

            double[][] t = calcRotationMatrix(best);
            siteRotation(t);
            calcRmsdPerLigand(geometry.getValue(), ibest);
            writeGeometryOutputFile(geometry.getKey(), geometry.getValue(), ibest, geometryNames);
            writePDBOutputFile(geometry.getKey(), geometry.getValue(), ibest);
            writeOriginalPDBOutputFile(geometry.getKey(), geometry.getValue(), ibest);

            // Write findgeo.out body
            output.format("%3s - %-71s|%9s|%8.3f\n", geometry.getKey(), geometryNames.get(geometry.getKey()), tag, rmsd);
        }
        printLine();
        System.out.printf("Best Geometry: %s  with RMSD: %1.3f tag: %s\n", geoBest, rmsdBest, tagBest);
        printLine();
        output.format(line);
        output.format("Best geometry of the site: %3s (%7s)\n", geometryNames.get(geoBest), tagBest);
        output.format(line);
        output.close();
    }

    public static boolean isDiagonallyDominant(double[][] matrix) {
        int numRows = matrix.length;
        if (numRows == 0) {
            return false; // La matrice è vuota
        }
        int numCols = matrix[0].length;

        for (int i = 0; i < numRows; i++) {
            double diagonalValue = Math.abs(matrix[i][i]);
            double rowSum = 0.0;
            for (int j = 0; j < numCols; j++) {
                if (j != i) {
                    rowSum += Math.abs(matrix[i][j]);
                }
            }
            if (diagonalValue <= rowSum) {
                return false; // La matrice non è diagonalmente dominante
            }
        }
        return true; // La matrice è diagonalmente dominante
    }
    public static double[][] makeDiagonallyDominant(double[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        for (int i = 0; i < numRows; i++) {
            double diagonalValue = Math.abs(matrix[i][i]);
            double rowSum = 0.0;
            for (int j = 0; j < numCols; j++) {
                if (j != i) {
                    rowSum += Math.abs(matrix[i][j]);
                }
            }

            if (diagonalValue <= rowSum) {
                // Modifica l'elemento diagonale in modo da renderlo maggiore della somma degli altri elementi
                matrix[i][i] = rowSum + 1.0;
            }
        }

        return matrix;
    }

    private  void qMatrixConstruction() {
        /*******************************************************************
         Create coordinate differences delta x plus (dxp) and minus (dxm)
         ********************************************************************/
        for (int k = 0; k < nlig; k++) {
            for (int j = 0; j < 3; j++) {
                dxm[k][j] = xm[k][j] - xf[k][j];
                dxp[k][j] = xm[k][j] + xf[k][j];
            }
        }

        /**************************************************************
         *  Fill upper triangle of (symmetric) quaternion matrix
         **************************************************************/
        //System.out.println("Filling quaternion matrix...");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                q[i][j] = 0.;
            }
        }

        for (int k = 0; k < nlig; k++) {
            /**************************************************************
             * Diagonals are sums of squared cyclic coordinate differences
             **************************************************************/
            q[0][0] = q[0][0] + Math.pow(dxm[k][0], 2) + Math.pow(dxm[k][1], 2) + Math.pow(dxm[k][2], 2);
            q[1][1] = q[1][1] + Math.pow(dxp[k][1], 2) + Math.pow(dxp[k][2], 2) + Math.pow(dxm[k][0], 2);
            q[2][2] = q[2][2] + Math.pow(dxp[k][0], 2) + Math.pow(dxp[k][2], 2) + Math.pow(dxm[k][1], 2);
            q[3][3] = q[3][3] + Math.pow(dxp[k][0], 2) + Math.pow(dxp[k][1], 2) + Math.pow(dxm[k][2], 2);


            /**************************************************************
             * Cross differences
             **************************************************************/
            q[0][1] = q[0][1] + dxp[k][1] * dxm[k][2] - dxm[k][1] * dxp[k][2];
            q[0][2] = q[0][2] + dxm[k][0] * dxp[k][2] - dxp[k][0] * dxm[k][2];
            q[0][3] = q[0][3] + dxp[k][0] * dxm[k][1] - dxm[k][0] * dxp[k][1];
            q[1][2] = q[1][2] + dxm[k][0] * dxm[k][1] - dxp[k][0] * dxp[k][1];
            q[1][3] = q[1][3] + dxm[k][0] * dxm[k][2] - dxp[k][0] * dxp[k][2];
            q[2][3] = q[2][3] + dxm[k][1] * dxm[k][2] - dxp[k][1] * dxp[k][2];
        }

        /**************************************************************
         *  Fill the rest by transposing it onto itself
         **************************************************************/
        q[1][0] = q[0][1];
        q[2][0] = q[0][2];
        q[3][0] = q[0][3];
        q[2][1] = q[1][2];
        q[3][1] = q[1][3];
        q[3][2] = q[2][3];
    }

    public void writeGeometryOutputFile(String geomName, double[][][] geometry, int ibest, HashMap<String, String> geometryNames) {
        try {
            Formatter output;
            output = new Formatter(outputFolder + geomName + ".out");
            String line = "-----------------------------------------------\n";
            output.format(line);
            output.format("Coordinates of template with ideal %s geometry\n", geomName);
            output.format(line);
            output.format("   0.000   0.000   0.000\n");
            for (int k = 0; k < nlig; k++) {
                for (int i = 0; i < 3; i++) {
                    output.format("%8.3f", geometry[ibest][k][i]);
                }
                output.format("\n");
            }
            output.format("\n%s", line);
            output.format("Coordinates of the fitted metal site and RMSD\n");
            output.format(line);
            output.format("   0.000   0.000   0.000   0.000\n");
            for (int k = 0; k < nlig; k++) {
                for (int i = 0; i < 3; i++) {
                    output.format("%8.3f", xmrot[k][i]);
                }
                output.format("%8.3f\n", rmsdpl[k]);
            }
            output.format("\n--------------------\n");
            output.format("Total RMSD: %8.3f\n", rmsd);
            output.format("--------------------\n");
            output.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
            System.exit(-1);
        }
    }

    private void writePDBOutputFile(String geomName, double[][][] geometry, int ibest) {
        try {
            Formatter output;
            output = new Formatter(outputFolder + geomName + ".pdb");
            output.format("%6s%5d %4s %3s  %4d    %8.3f%8.3f%8.3f\n", "ATOM  ", 1, " M  ", geomName.toUpperCase(), 1, 0., 0., 0.);
            for (int k = 0; k < nlig; k++) {
                output.format("%6s%5d %4s %3s  %4d    ", "ATOM  ", k + 2, " L  ", geomName.toUpperCase(), 1);
                for (int i = 0; i < 3; i++) {
                    output.format("%8.3f", geometry[ibest][k][i]);
                }
                output.format("\n");
            }
            output.format("TER\n");
            output.format("%6s%5d %4s %3s %s%4d    %8.3f%8.3f%8.3f\n", "ATOM  ", matnum, matnam, mrsnam, mchain, mrsnum, 0., 0., 0.);
            for (int k = 0; k < nlig; k++) {
                output.format("%6s%5d %4s %3s %s%4d    ", "ATOM  ", atnum[k], atnam[k], rsnam[k], chain[k], rsnum[k]);
                for (int i = 0; i < 3; i++) {
                    output.format("%8.3f", xmrot[k][i]);
                }
                output.format("\n");
            }
            output.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
            System.exit(-1);
        }
    }

    private void writeOriginalPDBOutputFile(String geomName, double[][][] geometry, int ibest) {
        double[][] xmrotd = new double[maxlig][3];
        for (int k = 0; k < nlig; k++) {
            for (int i = 0; i < 3; i++) {
                xmrotd[k][i] = xmrot[k][i] * dist[k] / 3.;
            }
        }
        try {
            Formatter output;
            output = new Formatter(outputFolder + geomName + "_orig.pdb");
            output.format("%6s%5d %4s %3s  %4d    %8.3f%8.3f%8.3f\n", "ATOM  ", 1, " M  ", geomName.toUpperCase(), 1, 0., 0., 0.);
            for (int k = 0; k < nlig; k++) {
                output.format("%6s%5d %4s %3s  %4d    ", "ATOM  ", k + 2, " L  ", geomName.toUpperCase(), 1);
                for (int i = 0; i < 3; i++) {
                    output.format("%8.3f", geometry[ibest][k][i]);
                }
                output.format("\n");
            }
            output.format("TER\n");
            output.format("%6s%5d %4s %3s %s%4d    %8.3f%8.3f%8.3f\n", "ATOM  ", matnum, matnam, mrsnam, mchain, mrsnum, 0., 0., 0.);
            for (int k = 0; k < nlig; k++) {
                output.format("%6s%5d %4s %3s %s%4d    ", "ATOM  ", atnum[k], atnam[k], rsnam[k], chain[k], rsnum[k]);
                for (int i = 0; i < 3; i++) {
                    output.format("%8.3f", xmrotd[k][i]);
                }
                output.format("\n");
            }
            output.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    private double[][] calcRotationMatrix(double[] best) {
        double[][] t = new double[3][3];
        t[0][0] = Math.pow(best[0], 2) + Math.pow(best[1], 2) - Math.pow(best[2], 2) - Math.pow(best[3], 2);
        t[1][0] = 2 * (best[1] * best[2] + best[0] * best[3]);
        t[2][0] = 2 * (best[1] * best[3] - best[0] * best[2]);
        t[0][1] = 2 * (best[1] * best[2] - best[0] * best[3]);
        t[1][1] = Math.pow(best[0], 2) + Math.pow(best[2], 2) - Math.pow(best[1], 2) - Math.pow(best[3], 2);
        t[2][1] = 2 * (best[2] * best[3] + best[0] * best[1]);
        t[0][2] = 2 * (best[1] * best[3] + best[0] * best[2]);
        t[1][2] = 2 * (best[2] * best[3] - best[0] * best[1]);
        t[2][2] = Math.pow(best[0], 2) + Math.pow(best[3], 2) - Math.pow(best[1], 2) - Math.pow(best[2], 2);

        return t;
    }

    private void siteRotation(double[][] t) {

        for (int k = 0; k < nlig; k++) {
            for (int i = 0; i < 3; i++) {
                xmrot[k][i] = 0.;
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    xmrot[k][i] = xmrot[k][i] + t[i][j] * xm[k][j];
                }
            }
        }
    }

    private void calcRmsdPerLigand(double[][][] geometry, int ibest) {
        for (int k = 0; k < nlig; k++) {
            rmsdpl[k] = 0.;
            for (int i = 0; i < 3; i++) {
                rmsdpl[k] = rmsdpl[k] + Math.pow(xmrot[k][i] - geometry[ibest][k][i], 2);
            }
            rmsdpl[k] = Math.sqrt(rmsdpl[k]);
        }
    }

    private void generatePermutations() {
        int[] pernow = new int[nlig];

        for (int i = 0; i < nlig; i++) {
            pernow[i] = i;

        }
        //System.out.println(pernow.length);
        List<List<Integer>> permute = permute(pernow);
        /*System.out.println("Permutations of array :");
        System.out.println("=========================================");
        for (List<Integer> perm : permute) {
            System.out.println(perm);
        }*/
        for (int i = 0; i < permute.size(); i++) {
            for (int x = 0; x < permute.get(i).size(); x++) {
                per[i][x] = permute.get(i).get(x);
            }
        }
    }

    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        permuteHelper(list, new ArrayList<>(), arr);
        return list;
    }

    private void permuteHelper(List<List<Integer>> list, List<Integer> resultList, int[] arr) {

        // Base case
        if (resultList.size() == arr.length) {
            list.add(new ArrayList<>(resultList));
        } else {
            for (int i = 0; i < arr.length; i++) {

                if (resultList.contains(arr[i])) {
                    // If element already exists in the list then skip
                    continue;
                }
                // Choose element
                resultList.add(arr[i]);
                // Explore
                permuteHelper(list, resultList, arr);
                // Unchoose element
                resultList.remove(resultList.size() - 1);
            }
        }
    }


    /**
     * Check if a file or directory exists
     *
     * @param filename the path to check
     * @return true if file/directory exists or false if not
     */
    public Boolean fileExists(String filename) {
        File f = new File(filename);
        if (!f.exists()) {
            return false;
        }
        return true;
    }

    private void printLine() {
        for (int i = 0; i < 61; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
