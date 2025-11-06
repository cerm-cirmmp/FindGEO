import org.apache.commons.cli.*;
import org.apache.commons.io.output.NullPrintStream;
import org.biojava.nbio.structure.*;
import org.biojava.nbio.structure.align.util.AtomCache;
import org.biojava.nbio.structure.io.StructureFiletype;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static java.lang.System.exit;

public class FindGeo {

        private static List<String> metalList = Arrays.asList(
                "LI", "BE", "NA", "MG", "AL", "K", "CA", "SC", "TI", "V", "CR", "MN",
                "FE", "CO", "NI", "CU", "ZN", "GA", "GE", "RB", "SR", "Y", "ZR", "NB",
                "MO", "TC", "RU", "RH", "PD", "AG", "CD", "IN", "SN", "SB", "CS", "BA",
                "LA", "CE", "PR", "ND", "PM", "SM", "EU", "GD", "TB", "DY", "HO", "ER",
                "TM", "YB", "LU", "HF", "TA", "W", "RE", "OS", "IR", "PT", "AU", "HG",
                "TL", "PB", "BI", "PO", "FR", "RA", "AC", "TH", "PA", "U", "NP", "PU",
                "AM", "CM", "BK", "CF", "ES", "FM", "MD", "NO", "LR", "RF", "DB", "SG",
                "AS");

        private static final String FILENAME = "findgeo.input";

        private static String pdbFile = null;

        private static String localPdbFileType = null;
        private static Double threshold = 2.8;
        private static String workdir = "." + File.separator;
        private static String metal = null;
        private static List<String> notDonors = Arrays.asList("H", "C");
        private static List<String> notMetals = new ArrayList<>();
        private static String key = null;

        private static final String delimiter = File.separator;
        public static void main(String[] args) throws IOException, StructureException {

            // To avoid WARN messages from BioJava
            System.setErr(new NullPrintStream());

            parseArgumentLine(args);

            printLine();
            System.out.println("Input parameters");
            printLine();
            System.out.println("PDB: " + pdbFile);
            System.out.println("Threshold: " + threshold);
            System.out.println("Metal: " + metal);
            System.out.println("Workdir: " + workdir);
            System.out.println("Donors excluded: " + notDonors.toString());
            System.out.println("Metals excluded: " + notMetals.toString());
            printLine();


            List<Chain> chains = null;
            Structure structure = null;
            try {

                AtomCache cache = new AtomCache();
                cache.setPath(workdir);
                cache.setFiletype(StructureFiletype.CIF);
                if(localPdbFileType != null) {
                    if (localPdbFileType.equals("pdb")) {
                        cache.setFiletype(StructureFiletype.PDB);
                    }
                }
                StructureIO.setAtomCache(cache);
                //PDBFileReader pdbreader = new PDBFileReader();
                //pdbreader.setFetchBehavior(LocalPDBDirectory.FetchBehavior.FETCH_FILES);

                structure = StructureIO.getStructure(pdbFile);

                //System.out.println(StructureTools.getNrAtoms(structure));

                chains = structure.getChains();

            } catch (Exception e){
                printLine();
                System.out.println(e);
                printLine();
                exit(-1);
            }

            // Find metals
            List<Atom> metals = findMetal(chains);

            if (!metals.isEmpty()) {
                String altLoc = "";
                String out = "";
                HashMap<String, List<Atom>> ligands = findLigand(metals, chains);
                //BufferedWriter bw = new BufferedWriter(new FileWriter(workdir + "/FindGeo.summary" ));
                for (Atom m : metals) {
                    key = m.getName()+"_"+m.getPDBserial();
                    printLine();
                    if(!m.getAltLoc().toString().equals(" ")) {
                        altLoc = "_" + m.getAltLoc().toString();
                    }
                    out = m.getElement()+"_"+m.getGroup().getResidueNumber()+"_"+altLoc+"_"+m.getPDBserial()+"_"+m.getGroup().getChain().getId();
                    System.out.println(out +" --> " +
                            ligands.get(key).size()+" ligands found");

                    if (ligands.get(key).size() >= 2 && ligands.get(key).size() <= 9) {
                        System.out.println("Determining coordination geometry...");
                        // Create findgeo.input
                        createFindgeoCIFInput(structure, out, m, ligands.get(key));
                        //createFindgeoInput(out, m, ligands.get(key));

                        // Execute findgeo
                        //System.out.println(workdir + " " + out + File.separator);
                        String findgeoInput = workdir + delimiter + out + File.separator + FILENAME;
                        printLine();
                        FindGeoMP findGeoMP = new FindGeoMP(findgeoInput, workdir+delimiter+out+delimiter);
                        findGeoMP.startCalculation();
                        //String geoFound = executeFindGeo(out);
                        //bw.write(out + ": " + geoFound + "\n");
                    } else if (ligands.get(key).size() < 2) {
                        System.out.println("!!! Too few donor atoms identified.\n!!! At least 2 donor atoms must be present.");
                    } else {
                        System.out.println("!!! Too many donor atoms identified.\n!!! The maximum allowed coordination number is 9.");
                    }
                }
                //bw.close();
                printLine();
            }
            //printLine();
            //System.out.println("You can find a summary in "+workdir+"/FindGeo.summary");
            //printLine();
            System.out.println("If you entered a PDB code, you can find\n" +
                    "the downloaded mmCIF file in: \n" +
                    workdir + delimiter + "data/structures/divided/mmCIF/??\n" +
                    "where ?? change based on the PDB name.");
            printLine();
            System.out.println("Done");
        }


        /**
         * Find ligands for each metal
         *
         * @param metals    list of metals
         * @param chains    list of chains
         * @return  hm        an HashMap with for each atom (key) there are a list of legands (value)
         */
        private static HashMap findLigand(List<Atom> metals, List<Chain> chains) {

            HashMap<String, List<Atom>> hm = new HashMap<String, List<Atom>>();
            for (Atom m : metals) {
                key = m.getName()+"_"+m.getPDBserial();
                List<Atom> ligands = new ArrayList<Atom>();
                for (Chain c : chains) {
                    for (Group g : c.getAtomGroups()) {
                        for (Atom a : g.getAtoms()) {
                            double x = m.getX() - a.getX();
                            double y = m.getY() - a.getY();
                            double z = m.getZ() - a.getZ();
                            double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
                            if (distance < threshold && !a.getName().equals(m.getName()) && !notDonors.contains(a.getElement().toString().toUpperCase()) && !metalList.contains(a.getElement().toString().toUpperCase())) {
                                //System.out.println(a);
                                ligands.add(a);
                            }
                        }
                        hm.put(key, ligands);
                    }
                }

                if (hm.get(key).isEmpty()) {
                    System.out.printf("No ligands found for metal %s %s (try to change distance threshold (-t) or excluded donors (-e))\n", m.getName(), m.getPDBserial());
                }
            }
            return hm;
        }

        /**
         * Find metals in all chains
         *
         * @param chains   Chains list
         * @return metals   a list of metals
         */
        private static List<Atom> findMetal(List<Chain> chains) {
            List<Atom> metals = new ArrayList<Atom>();
            for (Chain c : chains) {
                for (Group g : c.getAtomGroups(GroupType.HETATM)) {
                    for (Atom a : g.getAtoms()) {
                        if (metalList.contains(a.getElement().toString().toUpperCase()) && !notMetals.contains(a.getElement().toString().toUpperCase())) {
                            //System.out.println(a);
                            metals.add(a);

                        }
                    }
                }
            }

            return metals;
        }


        /**
         * Create the findgeo.input file
         *
         * @param out           the filename format
         * @param metal         Atom object
         * @param ligands       list of ligands for each atom
         */
        private static void createFindgeoInput(String out, Atom metal, List<Atom> ligands) {
            try {

                File outDir = new File(workdir + delimiter + out);
                createDir(outDir);

                BufferedWriter bw = new BufferedWriter(new FileWriter(workdir + delimiter + out + delimiter + FILENAME));

                /*String line = metal.toPDB();
                System.out.println("Chain: " + line.substring(21,22));
                bw.write(line.substring(0, 21) + "A" + line.substring(22, line.length()));*/
                bw.write(metal.toPDB());
                for (Atom l : ligands) {
                    /*line = l.toPDB();
                    bw.write(line.substring(0, 21) + "A" + line.substring(22, line.length()));*/
                    bw.write(l.toPDB());
                }

                bw.close();

            } catch (IOException e) {

                e.printStackTrace();

            }
        }


    private static void createFindgeoCIFInput(Structure structure, String out, Atom metal, List<Atom> ligands) {
        try {

            String header = """
#
loop_
_atom_site.group_PDB
_atom_site.id
_atom_site.type_symbol
_atom_site.label_atom_id
_atom_site.label_alt_id
_atom_site.label_comp_id
_atom_site.label_asym_id
_atom_site.label_entity_id
_atom_site.label_seq_id
_atom_site.pdbx_PDB_ins_code
_atom_site.Cartn_x
_atom_site.Cartn_y
_atom_site.Cartn_z
_atom_site.occupancy
_atom_site.B_iso_or_equiv
_atom_site.auth_seq_id
_atom_site.auth_comp_id
_atom_site.auth_asym_id
_atom_site.auth_atom_id
_atom_site.pdbx_PDB_model_num
                   """;

            File outDir = new File(workdir + delimiter + out);
            createDir(outDir);

            BufferedWriter bw = new BufferedWriter(new FileWriter(workdir + delimiter + out + delimiter + FILENAME));

                /*String line = metal.toPDB();
                System.out.println("Chain: " + line.substring(21,22));
                bw.write(line.substring(0, 21) + "A" + line.substring(22, line.length()));*/

            bw.write(header);
            List<String> str = Arrays.asList(structure.toMMCIF().split("\n"));

            for(String s: str) {
                if(s.startsWith("ATOM") || s.startsWith("HETATM")) {
                    //System.out.println(s);
                    String pdbSerial = s.split(" ")[1];
                    if(pdbSerial.equals(String.valueOf(metal.getPDBserial()))) {
                       /* String[] fields = s.split(" ");
                        for(String f: fields) {
                            bw.write(f + "\t");
                        }*/
                        bw.write(s + "\n");
                    }
                }
            }
            //bw.write(metal.toPDB());



            for (Atom l : ligands) {
                    /*line = l.toPDB();
                    bw.write(line.substring(0, 21) + "A" + line.substring(22, line.length()));*/
                for(String s: str) {
                    if(s.startsWith("ATOM") || s.startsWith("HETATM")) {
                        String pdbSerial =s.split(" ")[1];
                        if(pdbSerial.equals(String.valueOf(l.getPDBserial()))) {
                            bw.write(s + "\n");
                        }
                    }
                }
                //bw.write(l.toPDB());
            }

            bw.close();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

        /**
         * Parse line arguments, perform some checks and sets the following variables:
         * pdbFile: contains the PDB filename or the PDB code
         * threshold: the coordination distance threshold
         * overwrite: if TRUE overwrite existing files and directories
         * workdir: directory where to find or download the input PDB file and to write outputs
         * metal: chemical symbol of the metal of interest.
         * notDonors: string list containing the chemical symbols of the atoms excluded from metal ligands
         * notMetals: string list containing the metal symbols excluded from the analysis.
         *
         * @param args  arguments list from command line
         */
        private static void parseArgumentLine(String[] args) {

            Options opt = new Options();
            opt.addOption("p", "pdb", true, "Local input PDB file or PDB code of input PDB file to be downloaded from the web.");
            opt.addOption("i", "input", true, "Local PDB/mmCIF local file.");
            opt.addOption("f", "format", true, "Local file format (i.e. cif or pdb).");
            opt.addOption("e", "excluded-donors", true, "Chemical symbols of the atoms (separated by commas) excluded from metal ligands. Default is C and H.");
            opt.addOption("x", "excluded-metals", true, "Metal symbols (separated by commas) excluded from the analysis.");
            opt.addOption("t", "threshold", true, "Coordination distance threshold. Default is 2.8 A.");
            opt.addOption("o", "overwrite", false, "Overwrite existing files and directories.");
            opt.addOption("m", "metal", true, "Chemical symbol of the metal of interest. Default is all metals.");
            opt.addOption("w", "workdir", true, "Directory where to find or download the input PDB file and to write outputs. Default is ./");

            CommandLineParser parser = new DefaultParser();

            HelpFormatter formatter = new HelpFormatter();

            try {
                CommandLine cmd = parser.parse(opt, args);

                if (!cmd.hasOption("p") && !cmd.hasOption("i")) {
                    throw new ParseException("A local PDB/mmCIF file or a PDB code is required.");
                }

                if (cmd.hasOption("p") && cmd.hasOption("i")) {
                    throw new ParseException("Input must be either a local PDB/mmCIF file or a PDB code, not both.");
                }

                if (cmd.hasOption("i") && !cmd.hasOption("f")) {
                    throw new ParseException("You have to specify the structure file format (i.e. cif or pdb).");
                }

                if (cmd.hasOption("i")) {
                    pdbFile = cmd.getOptionValue("i");
                }

                if (cmd.hasOption("f")) {
                    localPdbFileType = cmd.getOptionValue("f");
                    if(!localPdbFileType.equals("cif") && !localPdbFileType.equals("pdb")) {
                        throw new ParseException("You have to specify the structure file format (i.e. cif or pdb).");
                    }
                }

                if (cmd.hasOption("p")) {
                    pdbFile = cmd.getOptionValue("p");
                }

                if (cmd.hasOption("t")) {
                    String tshold = cmd.getOptionValue("t");
                    try {
                        threshold = Double.parseDouble(tshold);
                    } catch (Exception e) {
                        throw new ParseException("Invalid threshold. This must be a number.");
                    }
                }

                if (cmd.hasOption("w")) {
                    workdir = cmd.getOptionValue("w");
                    File path = new File(workdir);
                    if (fileExists(workdir) && !cmd.hasOption("o")) {
                        throw new ParseException(workdir + " is an existing directory... Remove/rename it or use the -o option");
                    } else if (fileExists(workdir) && cmd.hasOption("o")) {
                        deleteDirectory(path);
                    }
                    createDir(path);
                }

                if (cmd.hasOption("m")) {
                    metal = cmd.getOptionValue("m").toUpperCase();
                    if (!metalList.contains(metal)) {
                        throw new ParseException(metal + " invalid metal.");
                    }
                    metalList = Arrays.asList(metal);
                }

                if (cmd.hasOption("e")) {
                    try {
                        notDonors = Arrays.asList(cmd.getOptionValue("e").replace(" ", "").split(","));
                    } catch (Exception e) {
                        throw new ParseException("Unexpected exception: " + e);
                    }
                }

                if (cmd.hasOption("x")) {
                    try {
                        notMetals = Arrays.asList(cmd.getOptionValue("x").replace(" ", "").split(","));
                        notMetals.replaceAll(String::toUpperCase);
                    } catch (Exception e) {
                        throw new ParseException("Unexpected exception: " + e);
                    }
                }

            } catch (ParseException exp) {
                printLine();
                System.out.println("Unexpected exception: " + exp.getMessage());
                printLine();
                formatter.printHelp("findgeo", opt);
                exit(-1);
            }
        }

        /**
         * Create a directory
         * @param path  the diretory to create
         */
        public static void createDir(File path) {
            path.mkdir();
        }

        /**
         * Check if a file or directory exists
         * @param filename  the path to check
         * @return  true if file/directory exists or false if not
         */
        public static Boolean fileExists(String filename) {
            File f = new File(filename);
            if (!f.exists()) {
                return false;
            }
            return true;
        }

        /**
         * remove a directory
         *
         * @param path  the directory to remove
         * @return      true if directory is removed
         */
        public static boolean deleteDirectory(File path) {
            if (path.exists()) {
                File[] files = path.listFiles();
                for (int i = 0; i < files.length; i++) {
                    if (files[i].isDirectory()) {
                        deleteDirectory(files[i]);
                    } else {
                        files[i].delete();
                    }
                }
            }
            return (path.delete());
        }

        private static void printLine() {
            for (int i=0; i<61; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

