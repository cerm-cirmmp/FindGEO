public class GenerateGeometryTemplate {
    Integer maxlig = 9, maxper = 362880;
    int[][] per = new int[maxper][maxlig];
    Integer nper;
    Double pi = 3.141592653589793;
    public GenerateGeometryTemplate(int[][] per, Integer nper) {
        this.per = per;
        this.nper = nper;
    }

    public double[][][] linGeometryTemplate() {
        System.out.println("Reading templates with lin geometry...");
        double[][][] lin = new double[2][2][3];
        for(int i=0; i< nper; i++) {
            lin[i][per[i][0]][0] = 0.;
            lin[i][per[i][0]][1] = 0.;
            lin[i][per[i][0]][2] = 3.;
            lin[i][per[i][1]][0] = 0.;
            lin[i][per[i][1]][1] = 0.;
            lin[i][per[i][1]][2] = -3.;
        }
        return lin;
    }

    public double[][][] trvGeometryTemplate() {
        System.out.println("Reading templates with trv geometry...");
        double[][][] trv = new double[2][2][3];
        for(int i=0; i< nper; i++) {
            trv[i][per[i][0]][0] = 0.;
            trv[i][per[i][0]][1] = 0.;
            trv[i][per[i][0]][2] = 3.;
            trv[i][per[i][1]][0] = 0.;
            trv[i][per[i][1]][1] = -1.5*Math.sqrt(3.);
            trv[i][per[i][1]][2] = -1.5;
        }
        return trv;
    }
    
    public double[][][] triGeometryTemplate() {
        System.out.println("Reading templates with tri geometry...");
        double[][][] tri = new double[6][3][3];
        for(int i=0; i< nper; i++) {
            tri[i][per[i][0]][0] = 0.;
            tri[i][per[i][0]][1] = 0.;
            tri[i][per[i][0]][2] = 3.;
            tri[i][per[i][1]][0] = 0.;
            tri[i][per[i][1]][1] = -1.5*Math.sqrt(3.);
            tri[i][per[i][1]][2] = -1.5;
            tri[i][per[i][2]][0] = 0.;
            tri[i][per[i][2]][1] = 1.5*Math.sqrt(3.);
            tri[i][per[i][2]][2] = -1.5;
        }
        return tri;
    }

    public double[][][] tevGeometryTemplate() {
        System.out.println("Reading templates with tev geometry...");
        double[][][] tev = new double[6][3][3];
        for(int i=0;i<nper;i++) {
            tev[i][per[i][0]][0] = Math.sqrt(3.);
            tev[i][per[i][0]][1] = Math.sqrt(3.);
            tev[i][per[i][0]][2] = Math.sqrt(3.);
            tev[i][per[i][1]][0] = -Math.sqrt(3.);
            tev[i][per[i][1]][1] = -Math.sqrt(3.);
            tev[i][per[i][1]][2] = Math.sqrt(3.);
            tev[i][per[i][2]][0] = Math.sqrt(3.);
            tev[i][per[i][2]][1] = -Math.sqrt(3.);
            tev[i][per[i][2]][2] = -Math.sqrt(3.);
        }
        return tev;
    }

    public double[][][] spvGeometryTemplate() {
        System.out.println("Reading templates with spv geometry...");
        double[][][] spv = new double[6][3][3];
        for(int i=0;i<nper;i++) {
            spv[i][per[i][0]][0] = 0.;
            spv[i][per[i][0]][1] = 0.;
            spv[i][per[i][0]][2] = 3.;
            spv[i][per[i][1]][0] = 0.;
            spv[i][per[i][1]][1] = 3.;
            spv[i][per[i][1]][2] = 0.;
            spv[i][per[i][2]][0] = 0.;
            spv[i][per[i][2]][1] = 0.;
            spv[i][per[i][2]][2] = -3.0;
        }
        return spv;
    }
    
    public double[][][] tetGeometryTemplate() {
        System.out.println("Reading templates with tet geometry...");
        double[][][] tet = new double[24][4][3];
        for (int i = 0; i < nper; i++) {
            tet[i][per[i][0]][0] = Math.sqrt(3.);
            tet[i][per[i][0]][1] = Math.sqrt(3.);
            tet[i][per[i][0]][2] = Math.sqrt(3.);
            tet[i][per[i][1]][0] = -Math.sqrt(3.);
            tet[i][per[i][1]][1] = -Math.sqrt(3.);
            tet[i][per[i][1]][2] = Math.sqrt(3.);
            tet[i][per[i][2]][0] = Math.sqrt(3.);
            tet[i][per[i][2]][1] = -Math.sqrt(3.);
            tet[i][per[i][2]][2] = -Math.sqrt(3.);
            tet[i][per[i][3]][0] = -Math.sqrt(3.);
            tet[i][per[i][3]][1] = Math.sqrt(3.);
            tet[i][per[i][3]][2] = -Math.sqrt(3.);
        }
        return tet;
    }

    public double[][][] splGeometryTemplate() {
        System.out.println("Reading templates with spl geometry...");
        double[][][] spl = new double[24][4][3];
        for (int i = 0; i < nper; i++) {
            spl[i][per[i][0]][0] = 0.;
            spl[i][per[i][0]][1] = 0.;
            spl[i][per[i][0]][2] = 3.;
            spl[i][per[i][1]][0] = 0.;
            spl[i][per[i][1]][1] = 3.;
            spl[i][per[i][1]][2] = 0.;
            spl[i][per[i][2]][0] = 0.;
            spl[i][per[i][2]][1] = 0.;
            spl[i][per[i][2]][2] = -3.0;
            spl[i][per[i][3]][0] = 0.;
            spl[i][per[i][3]][1] = -3.;
            spl[i][per[i][3]][2] = 0.;
        }
        return spl;
    }

    public double[][][] bvaGeometryTemplate() {
        System.out.println("Reading templates with bva geometry...");
        double[][][] bva = new double[24][4][3];
        for (int i = 0; i < nper; i++) {
            bva[i][per[i][0]][0] = 0.;
            bva[i][per[i][0]][1] = 0.;
            bva[i][per[i][0]][2] = 3.;
            bva[i][per[i][1]][0] = 0.;
            bva[i][per[i][1]][1] = -1.5 * Math.sqrt(3.);
            bva[i][per[i][1]][2] = -1.5;
            bva[i][per[i][2]][0] = 3.;
            bva[i][per[i][2]][1] = 0.;
            bva[i][per[i][2]][2] = 0.;
            bva[i][per[i][3]][0] = 0.;
            bva[i][per[i][3]][1] = 1.5 * Math.sqrt(3.);
            bva[i][per[i][3]][2] = -1.5;
        }
        return bva;
    }

    public double[][][] bvpGeometryTemplate() {
        System.out.println("Reading templates with bvp geometry...");
        double[][][] bvp = new double[24][4][3];
        for (int i = 0; i < nper; i++) {
            bvp[i][per[i][0]][0] = 0.;
            bvp[i][per[i][0]][1] = 0.;
            bvp[i][per[i][0]][2] = 3.;
            bvp[i][per[i][1]][0] = 0.;
            bvp[i][per[i][1]][1] = -1.5 * Math.sqrt(3.);
            bvp[i][per[i][1]][2] = -1.5;
            bvp[i][per[i][2]][0] = 3.;
            bvp[i][per[i][2]][1] = 0.;
            bvp[i][per[i][2]][2] = 0.;
            bvp[i][per[i][3]][0] = -3.;
            bvp[i][per[i][3]][1] = 0.;
            bvp[i][per[i][3]][2] = 0.;
        }
        return bvp;
    }

    public double[][][] pyvGeometryTemplate() {
        System.out.println("Reading templates with pyv geometry...");
        double[][][] pyv = new double[24][4][3];
        for (int i = 0; i < nper; i++) {
            pyv[i][per[i][0]][0] = 0.;
            pyv[i][per[i][0]][1] = 0.;
            pyv[i][per[i][0]][2] = 3.;
            pyv[i][per[i][1]][0] = 0.;
            pyv[i][per[i][1]][1] = -3.;
            pyv[i][per[i][1]][2] = 0.;
            pyv[i][per[i][2]][0] = 3.;
            pyv[i][per[i][2]][1] = 0.;
            pyv[i][per[i][2]][2] = 0.;
            pyv[i][per[i][3]][0] = 0.;
            pyv[i][per[i][3]][1] = 3.;
            pyv[i][per[i][3]][2] = 0.;
        }
        return pyv;
    }
    
    public double[][][] spyGeometryTemplate() {
        System.out.println("Reading templates with spy geometry...");
        double[][][] spy = new double[120][5][3];
        for (int i = 0; i < nper; i++) {
            spy[i][per[i][0]][0] = 0.;
            spy[i][per[i][0]][1] = 0.;
            spy[i][per[i][0]][2] = 3.;
            spy[i][per[i][1]][0] = 0.;
            spy[i][per[i][1]][1] = -3.;
            spy[i][per[i][1]][2] = 0.;
            spy[i][per[i][2]][0] = 3.;
            spy[i][per[i][2]][1] = 0.;
            spy[i][per[i][2]][2] = 0.;
            spy[i][per[i][3]][0] = 0.;
            spy[i][per[i][3]][1] = 3.;
            spy[i][per[i][3]][2] = 0.;
            spy[i][per[i][4]][0] = -3.;
            spy[i][per[i][4]][1] = 0.;
            spy[i][per[i][4]][2] = 0.;
        }
        return spy;
    }

    public double[][][] tbpGeometryTemplate() {
        System.out.println("Reading templates with tbp geometry...");
        double[][][] tbp = new double[120][5][3];
        for (int i = 0; i < nper; i++) {
            tbp[i][per[i][0]][0] = 0.;
            tbp[i][per[i][0]][1] = 0.;
            tbp[i][per[i][0]][2] = 3.;
            tbp[i][per[i][1]][0] = 0.;
            tbp[i][per[i][1]][1] = -1.5*Math.sqrt(3.);
            tbp[i][per[i][1]][2] = -1.5;
            tbp[i][per[i][2]][0] = 3.;
            tbp[i][per[i][2]][1] = 0.;
            tbp[i][per[i][2]][2] = 0.;
            tbp[i][per[i][3]][0] = 0.;
            tbp[i][per[i][3]][1] = 1.5*Math.sqrt(3.);
            tbp[i][per[i][3]][2] = -1.5;
            tbp[i][per[i][4]][0] = -3.;
            tbp[i][per[i][4]][1] = 0.;
            tbp[i][per[i][4]][2] = 0.;
        }
        return tbp;
    }

    public double[][][] tpvGeometryTemplate() {
        System.out.println("Reading templates with tpv geometry...");
        double[][][] tpv = new double[120][5][3];
        for (int i = 0; i < nper; i++) {
            tpv[i][per[i][0]][0] = -3.*Math.sqrt(21.)/7.;
            tpv[i][per[i][0]][1] = 0.;
            tpv[i][per[i][0]][2] = 6.*Math.sqrt(7.)/7;
            tpv[i][per[i][1]][0] = -3.*Math.sqrt(21.)/7.;
            tpv[i][per[i][1]][1] = 3.*Math.sqrt(21.)/7.;
            tpv[i][per[i][1]][2] = -3.*Math.sqrt(7.)/7.;
            tpv[i][per[i][2]][0] = -3.*Math.sqrt(21.)/7.;
            tpv[i][per[i][2]][1] = -3.*Math.sqrt(21.)/7.;
            tpv[i][per[i][2]][2] = -3.*Math.sqrt(7.)/7.;
            tpv[i][per[i][3]][0] = 3.*Math.sqrt(21.)/7.;
            tpv[i][per[i][3]][1] = 0.;
            tpv[i][per[i][3]][2] = 6.*Math.sqrt(7.)/7.;
            tpv[i][per[i][4]][0] = 3.*Math.sqrt(21.)/7.;
            tpv[i][per[i][4]][1] = 3.*Math.sqrt(21.)/7.;
            tpv[i][per[i][4]][2] = -3.*Math.sqrt(7.)/7.;
        }
        return tpv;
    }
    
    public double[][][] octGeometryTemplate() {
        System.out.println("Reading templates with oct geometry...");
        double[][][] oct = new double[720][6][3];
        for (int i = 0; i < nper; i++) {
            oct[i][per[i][0]][0] = 0.;
            oct[i][per[i][0]][1] = 0.;
            oct[i][per[i][0]][2] = 3.;
            oct[i][per[i][1]][0] = 0.;
            oct[i][per[i][1]][1] = -3.;
            oct[i][per[i][1]][2] = 0.;
            oct[i][per[i][2]][0] = 3.;
            oct[i][per[i][2]][1] = 0.;
            oct[i][per[i][2]][2] = 0.;
            oct[i][per[i][3]][0] = 0.;
            oct[i][per[i][3]][1] = 3.;
            oct[i][per[i][3]][2] = 0.;
            oct[i][per[i][4]][0] = -3.;
            oct[i][per[i][4]][1] = 0.;
            oct[i][per[i][4]][2] = 0.;
            oct[i][per[i][5]][0] = 0.;
            oct[i][per[i][5]][1] = 0.;
            oct[i][per[i][5]][2] = -3.;
        }
        return oct;
    }

    public double[][][] tprGeometryTemplate() {
        System.out.println("Reading templates with tpr geometry...");
        double[][][] tpr = new double[720][6][3];
        for (int i = 0; i < nper; i++) {
            tpr[i][per[i][0]][0] = -3.*Math.sqrt(21.)/7.;
            tpr[i][per[i][0]][1] = 0.;
            tpr[i][per[i][0]][2] = 6.*Math.sqrt(7.)/7;
            tpr[i][per[i][1]][0] = -3.*Math.sqrt(21.)/7.;
            tpr[i][per[i][1]][1] = 3.*Math.sqrt(21.)/7.;
            tpr[i][per[i][1]][2] = -3.*Math.sqrt(7.)/7.;
            tpr[i][per[i][2]][0] = -3.*Math.sqrt(21.)/7.;
            tpr[i][per[i][2]][1] = -3.*Math.sqrt(21.)/7.;
            tpr[i][per[i][2]][2] = -3.*Math.sqrt(7.)/7.;
            tpr[i][per[i][3]][0] = 3.*Math.sqrt(21.)/7.;
            tpr[i][per[i][3]][1] = 0.;
            tpr[i][per[i][3]][2] = 6.*Math.sqrt(7.)/7.;
            tpr[i][per[i][4]][0] = 3.*Math.sqrt(21.)/7.;
            tpr[i][per[i][4]][1] = 3.*Math.sqrt(21.)/7.;
            tpr[i][per[i][4]][2] = -3.*Math.sqrt(7.)/7.;
            tpr[i][per[i][5]][0] = 3.*Math.sqrt(21.)/7.;
            tpr[i][per[i][5]][1] = -3.*Math.sqrt(21.)/7.;
            tpr[i][per[i][5]][2] = -3.*Math.sqrt(7.)/7.;
        }
        return tpr;
    }

    public double[][][] pvaGeometryTemplate() {
        System.out.println("Reading templates with pva geometry...");
        double[][][] pva = new double[720][6][3];
        for (int i = 0; i < nper; i++) {
            pva[i][per[i][0]][0] = 0.;
            pva[i][per[i][0]][1] = 0.;
            pva[i][per[i][0]][2] = 3.;
            pva[i][per[i][1]][0] = 0.;
            pva[i][per[i][1]][1] = -3 * Math.cos(pi/10.);
            pva[i][per[i][1]][2] = 3 * Math.sin(pi/10.);
            pva[i][per[i][2]][0] = 0.;
            pva[i][per[i][2]][1] = -3 * Math.sin(pi/5.);
            pva[i][per[i][2]][2] = -3 * Math.cos(pi/5.);
            pva[i][per[i][3]][0] = 0.;
            pva[i][per[i][3]][1] = 3 * Math.sin(pi/5.);
            pva[i][per[i][3]][2] = -3 * Math.cos(pi/5.);
            pva[i][per[i][4]][0] = 0.;
            pva[i][per[i][4]][1] = 3 * Math.cos(pi/10.);
            pva[i][per[i][4]][2] = 3 * Math.sin(pi/10.);
            pva[i][per[i][5]][0] = 3.;
            pva[i][per[i][5]][1] = 0.;
            pva[i][per[i][5]][2] = 0.;
        }
        return pva;
    }

    public double[][][] pvpGeometryTemplate() {
        System.out.println("Reading templates with pvp geometry...");
        double[][][] pvp = new double[720][6][3];
        for (int i = 0; i < nper; i++) {
            pvp[i][per[i][0]][0] = 0.;
            pvp[i][per[i][0]][1] = 0.;
            pvp[i][per[i][0]][2] = 3.;
            pvp[i][per[i][1]][0] = 0.;
            pvp[i][per[i][1]][1] = -3 * Math.cos(pi/10.);
            pvp[i][per[i][1]][2] = 3 * Math.sin(pi/10.);
            pvp[i][per[i][2]][0] = 0.;
            pvp[i][per[i][2]][1] = -3 * Math.sin(pi/5.);
            pvp[i][per[i][2]][2] = -3 * Math.cos(pi/5.);
            pvp[i][per[i][3]][0] = 0.;
            pvp[i][per[i][3]][1] = 3 * Math.sin(pi/5.);
            pvp[i][per[i][3]][2] = -3 * Math.cos(pi/5.);
            pvp[i][per[i][4]][0] = 3.;
            pvp[i][per[i][4]][1] = 0.;
            pvp[i][per[i][4]][2] = 0.;
            pvp[i][per[i][5]][0] = -3.;
            pvp[i][per[i][5]][1] = 0.;
            pvp[i][per[i][5]][2] = 0.;
        }
        return pvp;
    }

    public double[][][] cofGeometryTemplate() {
        System.out.println("Reading templates with cof geometry...");
        double[][][] cof = new double[720][6][3];
        for (int i = 0; i < nper; i++) {
            cof[i][per[i][0]][0] = 0.;
            cof[i][per[i][0]][1] = -3.;
            cof[i][per[i][0]][2] = 0.;
            cof[i][per[i][1]][0] = 3.;
            cof[i][per[i][1]][1] = 0.;
            cof[i][per[i][1]][2] = 0.;
            cof[i][per[i][2]][0] = 0.;
            cof[i][per[i][2]][1] = 3.;
            cof[i][per[i][2]][2] = 0.;
            cof[i][per[i][3]][0] = -3.;
            cof[i][per[i][3]][1] = 0.;
            cof[i][per[i][3]][2] = 0.;
            cof[i][per[i][4]][0] = 0.;
            cof[i][per[i][4]][1] = 0.;
            cof[i][per[i][4]][2] = -3.;
            cof[i][per[i][5]][0] = Math.sqrt(3.);
            cof[i][per[i][5]][1] = Math.sqrt(3.);
            cof[i][per[i][5]][2] = Math.sqrt(3.);
        }
        return cof;
    }

    public double[][][] conGeometryTemplate() {
        System.out.println("Reading templates with con geometry...");
        double[][][] con = new double[720][6][3];
        for (int i = 0; i < nper; i++) {
            con[i][per[i][0]][0] = 0.;
            con[i][per[i][0]][1] = 0.;
            con[i][per[i][0]][2] = 3.;
            con[i][per[i][1]][0] = 0.;
            con[i][per[i][1]][1] = -3.;
            con[i][per[i][1]][2] = 0.;
            con[i][per[i][2]][0] = 3.;
            con[i][per[i][2]][1] = 0.;
            con[i][per[i][2]][2] = 0.;
            con[i][per[i][3]][0] = 0.;
            con[i][per[i][3]][1] = 3.;
            con[i][per[i][3]][2] = 0.;
            con[i][per[i][4]][0] = -3.;
            con[i][per[i][4]][1] = 0.;
            con[i][per[i][4]][2] = 0.;
            con[i][per[i][5]][0] = Math.sqrt(3.);
            con[i][per[i][5]][1] = Math.sqrt(3.);
            con[i][per[i][5]][2] = Math.sqrt(3.);
        }
        return con;
    }

    public double[][][] ctfGeometryTemplate() {
        System.out.println("Reading templates with ctf geometry...");
        double[][][] ctf = new double[720][6][3];
        for (int i = 0; i < nper; i++) {
            ctf[i][per[i][0]][0] = -3.*Math.sqrt(21.)/7.;
            ctf[i][per[i][0]][1] = 0.;
            ctf[i][per[i][0]][2] = 6.*Math.sqrt(7.)/7.;
            ctf[i][per[i][1]][0] = -3.*Math.sqrt(21.)/7.;
            ctf[i][per[i][1]][1] = 3.*Math.sqrt(21.)/7.;
            ctf[i][per[i][1]][2] = -3.*Math.sqrt(7.)/7.;
            ctf[i][per[i][2]][0] = -3.*Math.sqrt(21.)/7.;
            ctf[i][per[i][2]][1] = -3.*Math.sqrt(21.)/7.;
            ctf[i][per[i][2]][2] = -3.*Math.sqrt(7.)/7.;
            ctf[i][per[i][3]][0] = 3.*Math.sqrt(21.)/7.;
            ctf[i][per[i][3]][1] = 0.;
            ctf[i][per[i][3]][2] = 6.*Math.sqrt(7.)/7.;
            ctf[i][per[i][4]][0] = 3.*Math.sqrt(21.)/7.;
            ctf[i][per[i][4]][1] = 3.*Math.sqrt(21.)/7.;
            ctf[i][per[i][4]][2] = -3.*Math.sqrt(7.)/7.;
            ctf[i][per[i][5]][0] = 0.;
            ctf[i][per[i][5]][1] = 0.;
            ctf[i][per[i][5]][2] = -3.;
        }
        return ctf;
    }

    public double[][][] ctnGeometryTemplate() {
        System.out.println("Reading templates with ctn geometry...");
        double[][][] ctn = new double[720][6][3];
        for (int i = 0; i < nper; i++) {
            ctn[i][per[i][0]][0] = -3.*Math.sqrt(21.)/7.;
            ctn[i][per[i][0]][1] = 3.*Math.sqrt(21.)/7.;
            ctn[i][per[i][0]][2] = -3.*Math.sqrt(7.)/7.;
            ctn[i][per[i][1]][0] = -3.*Math.sqrt(21.)/7.;
            ctn[i][per[i][1]][1] = -3.*Math.sqrt(21.)/7.;
            ctn[i][per[i][1]][2] = -3.*Math.sqrt(7.)/7.;
            ctn[i][per[i][2]][0] = 3.*Math.sqrt(21.)/7.;
            ctn[i][per[i][2]][1] = 0.;
            ctn[i][per[i][2]][2] = 6.*Math.sqrt(7.)/7.;
            ctn[i][per[i][3]][0] = 3.*Math.sqrt(21.)/7.;
            ctn[i][per[i][3]][1] = 3.*Math.sqrt(21.)/7.;
            ctn[i][per[i][3]][2] = -3.*Math.sqrt(7.)/7.;
            ctn[i][per[i][4]][0] = 3.*Math.sqrt(21.)/7.;
            ctn[i][per[i][4]][1] = -3.*Math.sqrt(21.)/7.;
            ctn[i][per[i][4]][2] = -3.*Math.sqrt(7.)/7.;
            ctn[i][per[i][5]][0] = 0.;
            ctn[i][per[i][5]][1] = 0.;
            ctn[i][per[i][5]][2] = -3.;
        }
        return ctn;
    }

    public double[][][] pbpGeometryTemplate() {
        System.out.println("Reading templates with pbp geometry...");
        double[][][] pbp = new double[5040][7][3];
        for (int i = 0; i < nper; i++) {
            pbp[i][per[i][0]][0] = 0.;
            pbp[i][per[i][0]][1] = 0.;
            pbp[i][per[i][0]][2] = 3.;
            pbp[i][per[i][1]][0] = 0.;
            pbp[i][per[i][1]][1] = -3 * Math.cos(pi/10.);
            pbp[i][per[i][1]][2] = 3 * Math.sin(pi/10.);
            pbp[i][per[i][2]][0] = 0.;
            pbp[i][per[i][2]][1] = -3 * Math.sin(pi/5.);
            pbp[i][per[i][2]][2] = -3 * Math.cos(pi/5.);
            pbp[i][per[i][3]][0] = 0.;
            pbp[i][per[i][3]][1] = 3 * Math.sin(pi/5.);
            pbp[i][per[i][3]][2] = -3 * Math.cos(pi/5.);
            pbp[i][per[i][4]][0] = 0.;
            pbp[i][per[i][4]][1] = 3 * Math.cos(pi/10.);
            pbp[i][per[i][4]][2] = 3 * Math.sin(pi/10.);
            pbp[i][per[i][5]][0] = 3.;
            pbp[i][per[i][5]][1] = 0.;
            pbp[i][per[i][5]][2] = 0.;
            pbp[i][per[i][6]][0] = -3.;
            pbp[i][per[i][6]][1] = 0.;
            pbp[i][per[i][6]][2] = 0.;
        }
        return pbp;
    }

    public double[][][] cocGeometryTemplate() {
        System.out.println("Reading templates with coc geometry...");
        double[][][] coc = new double[5040][7][5];
        for (int i = 0; i < nper; i++) {
            coc[i][per[i][0]][0] = 0.;
            coc[i][per[i][0]][1] = 0.;
            coc[i][per[i][0]][2] = 3.;
            coc[i][per[i][1]][0] = 0.;
            coc[i][per[i][1]][1] = -3.;
            coc[i][per[i][1]][2] = 0.;
            coc[i][per[i][2]][0] = 3.;
            coc[i][per[i][2]][1] = 0.;
            coc[i][per[i][2]][2] = 0.;
            coc[i][per[i][3]][0] = 0.;
            coc[i][per[i][3]][1] = 3.;
            coc[i][per[i][3]][2] = 0.;
            coc[i][per[i][4]][0] = -3.;
            coc[i][per[i][4]][1] = 0.;
            coc[i][per[i][4]][2] = 0.;
            coc[i][per[i][5]][0] = 0.;
            coc[i][per[i][5]][1] = 0.;
            coc[i][per[i][5]][2] = -3.;
            coc[i][per[i][6]][0] = Math.sqrt(3.);
            coc[i][per[i][6]][1] = Math.sqrt(3.);
            coc[i][per[i][6]][2] = Math.sqrt(3.);
        }
        return coc;
    }

    public double[][][] ctpGeometryTemplate() {
        System.out.println("Reading templates with ctp geometry...");
        double[][][] ctp = new double[5040][7][3];
        for (int i = 0; i < nper; i++) {
            ctp[i][per[i][0]][0] = -3.*Math.sqrt(21.)/7.;
            ctp[i][per[i][0]][1] = 0.;
            ctp[i][per[i][0]][2] = 6.*Math.sqrt(7.)/7.;
            ctp[i][per[i][1]][0] = -3.*Math.sqrt(21.)/7.;
            ctp[i][per[i][1]][1] = 3.*Math.sqrt(21.)/7.;
            ctp[i][per[i][1]][2] = -3.*Math.sqrt(7.)/7.;
            ctp[i][per[i][2]][0] = -3.*Math.sqrt(21.)/7.;
            ctp[i][per[i][2]][1] = -3.*Math.sqrt(21.)/7.;
            ctp[i][per[i][2]][2] = -3.*Math.sqrt(7.)/7.;
            ctp[i][per[i][3]][0] = 3.*Math.sqrt(21.)/7.;
            ctp[i][per[i][3]][1] = 0.;
            ctp[i][per[i][3]][2] = 6.*Math.sqrt(7.)/7.;
            ctp[i][per[i][4]][0] = 3.*Math.sqrt(21.)/7.;
            ctp[i][per[i][4]][1] = 3.*Math.sqrt(21.)/7.;
            ctp[i][per[i][4]][2] = -3.*Math.sqrt(7.)/7.;
            ctp[i][per[i][5]][0] = 3.*Math.sqrt(21.)/7.;
            ctp[i][per[i][5]][1] = -3.*Math.sqrt(21.)/7.;
            ctp[i][per[i][5]][2] = -3.*Math.sqrt(7.)/7.;
            ctp[i][per[i][6]][0] = 0.;
            ctp[i][per[i][6]][1] = 0.;
            ctp[i][per[i][6]][2] = -3.;
        }
        return ctp;
    }

    public double[][][] hvaGeometryTemplate() {
        System.out.println("Reading templates with hva geometry...");
        double[][][] hva = new double[5040][7][3];
        for (int i = 0; i < nper; i++) {
            hva[i][per[i][0]][0] = 0.;
            hva[i][per[i][0]][1] = 0.;
            hva[i][per[i][0]][2] = 3.;
            hva[i][per[i][1]][0] = 0.;
            hva[i][per[i][1]][1] = -1.5*Math.sqrt(3.);
            hva[i][per[i][1]][2] = 1.5;
            hva[i][per[i][2]][0] = 0.;
            hva[i][per[i][2]][1] = -1.5*Math.sqrt(3.) ;
            hva[i][per[i][2]][2] = -1.5;
            hva[i][per[i][3]][0] = 0.;
            hva[i][per[i][3]][1] = 0.;
            hva[i][per[i][3]][2] = -3.;
            hva[i][per[i][4]][0] = 0.;
            hva[i][per[i][4]][1] = 1.5*Math.sqrt(3.);
            hva[i][per[i][4]][2] = -1.5;
            hva[i][per[i][5]][0] = 0.;
            hva[i][per[i][5]][1] = 1.5*Math.sqrt(3.);
            hva[i][per[i][5]][2] = 1.5;
            hva[i][per[i][6]][0] = 3.;
            hva[i][per[i][6]][1] = 0.;
            hva[i][per[i][6]][2] = 0.;
        }
        return hva;
    }

    public double[][][] hvpGeometryTemplate() {
        System.out.println("Reading templates with hvp geometry...");
        double[][][] hvp = new double[5040][7][3];
        for (int i = 0; i < nper; i++) {
            hvp[i][per[i][0]][0] = 0.;
            hvp[i][per[i][0]][1] = 0.;
            hvp[i][per[i][0]][2] = 3.;
            hvp[i][per[i][1]][0] = 0.;
            hvp[i][per[i][1]][1] = -1.5*Math.sqrt(3.);
            hvp[i][per[i][1]][2] = 1.5;
            hvp[i][per[i][2]][0] = 0.;
            hvp[i][per[i][2]][1] = -1.5*Math.sqrt(3.) ;
            hvp[i][per[i][2]][2] = -1.5;
            hvp[i][per[i][3]][0] = 0.;
            hvp[i][per[i][3]][1] = 0.;
            hvp[i][per[i][3]][2] = -3.;
            hvp[i][per[i][4]][0] = 0.;
            hvp[i][per[i][4]][1] = 1.5*Math.sqrt(3.);
            hvp[i][per[i][4]][2] = -1.5;
            hvp[i][per[i][5]][0] = 3.;
            hvp[i][per[i][5]][1] = 0.;
            hvp[i][per[i][5]][2] = 0.;
            hvp[i][per[i][6]][0] = -3.;
            hvp[i][per[i][6]][1] = 0.;
            hvp[i][per[i][6]][2] = 0.;
        }
        return hvp;
    }

    public double[][][] cuvGeometryTemplate() {
        System.out.println("Reading templates with cuv geometry...");
        double[][][] cuv = new double[5040][7][3];
        for (int i = 0; i < nper; i++) {
            cuv[i][per[i][0]][0] = -Math.sqrt(3.);
            cuv[i][per[i][0]][1] = -Math.sqrt(3.);
            cuv[i][per[i][0]][2] = Math.sqrt(3.);
            cuv[i][per[i][1]][0] = -Math.sqrt(3.);
            cuv[i][per[i][1]][1] = Math.sqrt(3.);
            cuv[i][per[i][1]][2] = Math.sqrt(3.);
            cuv[i][per[i][2]][0] = Math.sqrt(3.);
            cuv[i][per[i][2]][1] = -Math.sqrt(3.);
            cuv[i][per[i][2]][2] = Math.sqrt(3.);
            cuv[i][per[i][3]][0] = Math.sqrt(3.);
            cuv[i][per[i][3]][1] = Math.sqrt(3.);
            cuv[i][per[i][3]][2] = Math.sqrt(3.);
            cuv[i][per[i][4]][0] = -Math.sqrt(3.);
            cuv[i][per[i][4]][1] = -Math.sqrt(3.);
            cuv[i][per[i][4]][2] = -Math.sqrt(3.);
            cuv[i][per[i][5]][0] = -Math.sqrt(3.);
            cuv[i][per[i][5]][1] = Math.sqrt(3.);
            cuv[i][per[i][5]][2] = -Math.sqrt(3.);
            cuv[i][per[i][6]][0] = Math.sqrt(3.);
            cuv[i][per[i][6]][1] = -Math.sqrt(3.);
            cuv[i][per[i][6]][2] = -Math.sqrt(3.);
        }
        return cuv;
    }

    public double[][][] savGeometryTemplate() {
        System.out.println("Reading templates with sav geometry...");
        double[][][] sav = new double[5040][7][3];
        for (int i = 0; i < nper; i++) {
            sav[i][per[i][0]][0] = -Math.sqrt(6.);
            sav[i][per[i][0]][1] = 0.;
            sav[i][per[i][0]][2] = Math.sqrt(3.);
            sav[i][per[i][1]][0] = 0.;
            sav[i][per[i][1]][1] = -Math.sqrt(6.);
            sav[i][per[i][1]][2] = Math.sqrt(3.);
            sav[i][per[i][2]][0] = 0.;
            sav[i][per[i][2]][1] = Math.sqrt(6.);
            sav[i][per[i][2]][2] = Math.sqrt(3.);
            sav[i][per[i][3]][0] = Math.sqrt(6.);
            sav[i][per[i][3]][1] = 0.;
            sav[i][per[i][3]][2] = Math.sqrt(3.);
            sav[i][per[i][4]][0] = -Math.sqrt(3.);
            sav[i][per[i][4]][1] = -Math.sqrt(3.);
            sav[i][per[i][4]][2] = -Math.sqrt(3.);
            sav[i][per[i][5]][0] = -Math.sqrt(3.);
            sav[i][per[i][5]][1] = Math.sqrt(3.);
            sav[i][per[i][5]][2] = -Math.sqrt(3.);
            sav[i][per[i][6]][0] = Math.sqrt(3.);
            sav[i][per[i][6]][1] = -Math.sqrt(3.);
            sav[i][per[i][6]][2] = -Math.sqrt(3.);
        }
        return sav;
    }

    public double[][][] hbpGeometryTemplate() {
        System.out.println("Reading templates with hbp geometry...");
        double[][][] hbp = new double[40320][8][3];
        for (int i = 0; i < nper; i++) {
            hbp[i][per[i][0]][0] = 0.;
            hbp[i][per[i][0]][1] = 0.;
            hbp[i][per[i][0]][2] = 3.;
            hbp[i][per[i][1]][0] = 0.;
            hbp[i][per[i][1]][1] = -1.5*Math.sqrt(3.);
            hbp[i][per[i][1]][2] = 1.5;
            hbp[i][per[i][2]][0] = 0.;
            hbp[i][per[i][2]][1] = -1.5*Math.sqrt(3.) ;
            hbp[i][per[i][2]][2] = -1.5;
            hbp[i][per[i][3]][0] = 0.;
            hbp[i][per[i][3]][1] = 0.;
            hbp[i][per[i][3]][2] = -3.;
            hbp[i][per[i][4]][0] = 0.;
            hbp[i][per[i][4]][1] = 1.5*Math.sqrt(3.);
            hbp[i][per[i][4]][2] = -1.5;
            hbp[i][per[i][5]][0] = 0.;
            hbp[i][per[i][5]][1] = 1.5*Math.sqrt(3.);
            hbp[i][per[i][5]][2] = 1.5;
            hbp[i][per[i][6]][0] = 3.;
            hbp[i][per[i][6]][1] = 0.;
            hbp[i][per[i][6]][2] = 0.;
            hbp[i][per[i][7]][0] = -3.;
            hbp[i][per[i][7]][1] = 0.;
            hbp[i][per[i][7]][2] = 0.;
        }
        return hbp;
    }

    public double[][][] cubGeometryTemplate() {
        System.out.println("Reading templates with cub geometry...");
        double[][][] cub = new double[40320][8][3];
        for (int i = 0; i < nper; i++) {
            cub[i][per[i][0]][0] = -Math.sqrt(3.);
            cub[i][per[i][0]][1] = -Math.sqrt(3.);
            cub[i][per[i][0]][2] = Math.sqrt(3.);
            cub[i][per[i][1]][0] = -Math.sqrt(3.);
            cub[i][per[i][1]][1] = Math.sqrt(3.);
            cub[i][per[i][1]][2] = Math.sqrt(3.);
            cub[i][per[i][2]][0] = Math.sqrt(3.);
            cub[i][per[i][2]][1] = -Math.sqrt(3.);
            cub[i][per[i][2]][2] = Math.sqrt(3.);
            cub[i][per[i][3]][0] = Math.sqrt(3.);
            cub[i][per[i][3]][1] = Math.sqrt(3.);
            cub[i][per[i][3]][2] = Math.sqrt(3.);
            cub[i][per[i][4]][0] = -Math.sqrt(3.);
            cub[i][per[i][4]][1] = -Math.sqrt(3.);
            cub[i][per[i][4]][2] = -Math.sqrt(3.);
            cub[i][per[i][5]][0] = -Math.sqrt(3.);
            cub[i][per[i][5]][1] = Math.sqrt(3.);
            cub[i][per[i][5]][2] = -Math.sqrt(3.);
            cub[i][per[i][6]][0] = Math.sqrt(3.);
            cub[i][per[i][6]][1] = -Math.sqrt(3.);
            cub[i][per[i][6]][2] = -Math.sqrt(3.);
            cub[i][per[i][7]][0] = Math.sqrt(3.);
            cub[i][per[i][7]][1] = Math.sqrt(3.);
            cub[i][per[i][7]][2] = -Math.sqrt(3.);
        }
        return cub;
    }

    public double[][][] sqaGeometryTemplate() {
        System.out.println("Reading templates with sqa geometry...");
        double[][][] sqa = new double[40320][8][3];
        for (int i = 0; i < nper; i++) {
            sqa[i][per[i][0]][0] = -Math.sqrt(6.);
            sqa[i][per[i][0]][1] = 0.;
            sqa[i][per[i][0]][2] = Math.sqrt(3.);
            sqa[i][per[i][1]][0] = 0.;
            sqa[i][per[i][1]][1] = -Math.sqrt(6.);
            sqa[i][per[i][1]][2] = Math.sqrt(3.);
            sqa[i][per[i][2]][0] =0.;
            sqa[i][per[i][2]][1] = Math.sqrt(6.);
            sqa[i][per[i][2]][2] = Math.sqrt(3.);
            sqa[i][per[i][3]][0] = Math.sqrt(6.);
            sqa[i][per[i][3]][1] = 0.;
            sqa[i][per[i][3]][2] = Math.sqrt(3.);
            sqa[i][per[i][4]][0] = -Math.sqrt(3.);
            sqa[i][per[i][4]][1] = -Math.sqrt(3.);
            sqa[i][per[i][4]][2] = -Math.sqrt(3.);
            sqa[i][per[i][5]][0] = -Math.sqrt(3.);
            sqa[i][per[i][5]][1] = Math.sqrt(3.);
            sqa[i][per[i][5]][2] = -Math.sqrt(3.);
            sqa[i][per[i][6]][0] = Math.sqrt(3.);
            sqa[i][per[i][6]][1] = -Math.sqrt(3.);
            sqa[i][per[i][6]][2] = -Math.sqrt(3.);
            sqa[i][per[i][7]][0] = Math.sqrt(3.);
            sqa[i][per[i][7]][1] = Math.sqrt(3.);
            sqa[i][per[i][7]][2] = -Math.sqrt(3.);
        }
        return sqa;
    }

    public double[][][] bocGeometryTemplate() {
        System.out.println("Reading templates with boc geometry...");
        double[][][] boc = new double[40320][8][3];
        for (int i = 0; i < nper; i++) {
            boc[i][per[i][0]][0] = 0.;
            boc[i][per[i][0]][1] = 0.;
            boc[i][per[i][0]][2] = 3.;
            boc[i][per[i][1]][0] = 0.;
            boc[i][per[i][1]][1] = -3.;
            boc[i][per[i][1]][2] = 0.;
            boc[i][per[i][2]][0] = 3.;
            boc[i][per[i][2]][1] = 0.;
            boc[i][per[i][2]][2] = 0.;
            boc[i][per[i][3]][0] = 0.;
            boc[i][per[i][3]][1] = 3.;
            boc[i][per[i][3]][2] = 0.;
            boc[i][per[i][4]][0] = -3.;
            boc[i][per[i][4]][1] = 0.;
            boc[i][per[i][4]][2] = 0.;
            boc[i][per[i][5]][0] = 0.;
            boc[i][per[i][5]][1] = 0.;
            boc[i][per[i][5]][2] = -3.;
            boc[i][per[i][6]][0] = Math.sqrt(3.);
            boc[i][per[i][6]][1] = Math.sqrt(3.);
            boc[i][per[i][6]][2] = Math.sqrt(3.);
            boc[i][per[i][7]][0] = -Math.sqrt(3.);
            boc[i][per[i][7]][1] = -Math.sqrt(3.);
            boc[i][per[i][7]][2] = -Math.sqrt(3.);
        }
        return boc;
    }

    public double[][][] btsGeometryTemplate() {
        System.out.println("Reading templates with bts geometry...");
        double[][][] bts = new double[40320][8][3];
        for (int i = 0; i < nper; i++) {
            bts[i][per[i][0]][0] = -3.*Math.sqrt(21.)/7.;
            bts[i][per[i][0]][1] = 0.;
            bts[i][per[i][0]][2] = 6.*Math.sqrt(7.)/7;
            bts[i][per[i][1]][0] = -3.*Math.sqrt(21.)/7.;
            bts[i][per[i][1]][1] = 3.*Math.sqrt(21.)/7.;
            bts[i][per[i][1]][2] = -3.*Math.sqrt(7.)/7.;
            bts[i][per[i][2]][0] = -3.*Math.sqrt(21.)/7.;
            bts[i][per[i][2]][1] = -3.*Math.sqrt(21.)/7.;
            bts[i][per[i][2]][2] = -3.*Math.sqrt(7.)/7.;
            bts[i][per[i][3]][0] = 3.*Math.sqrt(21.)/7.;
            bts[i][per[i][3]][1] = 0.;
            bts[i][per[i][3]][2] = 6.*Math.sqrt(7.)/7.;
            bts[i][per[i][4]][0] = 3.*Math.sqrt(21.)/7.;
            bts[i][per[i][4]][1] = 3.*Math.sqrt(21.)/7.;
            bts[i][per[i][4]][2] = -3.*Math.sqrt(7.)/7.;
            bts[i][per[i][5]][0] = 3.*Math.sqrt(21.)/7.;
            bts[i][per[i][5]][1] = -3.*Math.sqrt(21.)/7.;
            bts[i][per[i][5]][2] = -3.*Math.sqrt(7.)/7.;
            bts[i][per[i][6]][0] = 0.;
            bts[i][per[i][6]][1] = 0.;
            bts[i][per[i][6]][2] = -3.;
            bts[i][per[i][7]][0] = 0.;
            bts[i][per[i][7]][1] = 3.*Math.sqrt(3.)/2.;
            bts[i][per[i][7]][2] = 1.5;
        }
        return bts;
    }

    public double[][][] bttGeometryTemplate() {
        System.out.println("Reading templates with btt geometry...");
        double[][][] btt = new double[40320][8][3];
        for (int i = 0; i < nper; i++) {
            btt[i][per[i][0]][0] = -3.*Math.sqrt(21.)/7.;
            btt[i][per[i][0]][1] = 0.;
            btt[i][per[i][0]][2] = 6.*Math.sqrt(7.)/7;
            btt[i][per[i][1]][0] = -3.*Math.sqrt(21.)/7.;
            btt[i][per[i][1]][1] = 3.*Math.sqrt(21.)/7.;
            btt[i][per[i][1]][2] = -3.*Math.sqrt(7.)/7.;
            btt[i][per[i][2]][0] = -3.*Math.sqrt(21.)/7.;
            btt[i][per[i][2]][1] = -3.*Math.sqrt(21.)/7.;
            btt[i][per[i][2]][2] = -3.*Math.sqrt(7.)/7.;
            btt[i][per[i][3]][0] = 3.*Math.sqrt(21.)/7.;
            btt[i][per[i][3]][1] = 0.;
            btt[i][per[i][3]][2] = 6.*Math.sqrt(7.)/7.;
            btt[i][per[i][4]][0] = 3.*Math.sqrt(21.)/7.;
            btt[i][per[i][4]][1] = 3.*Math.sqrt(21.)/7.;
            btt[i][per[i][4]][2] = -3.*Math.sqrt(7.)/7.;
            btt[i][per[i][5]][0] = 3.*Math.sqrt(21.)/7.;
            btt[i][per[i][5]][1] = -3.*Math.sqrt(21.)/7.;
            btt[i][per[i][5]][2] = -3.*Math.sqrt(7.)/7.;
            btt[i][per[i][6]][0] = -3.;
            btt[i][per[i][6]][1] = 0.;
            btt[i][per[i][6]][2] = 0.;
            btt[i][per[i][7]][0] = 3.;
            btt[i][per[i][7]][1] = 0.;
            btt[i][per[i][7]][2] = 0.;
        }
        return btt;
    }

    public double[][][] ttpGeometryTemplate() {
        System.out.println("Reading templates with ttp geometry...");
        double[][][] ttp = new double[362880][9][3];
        for (int i = 0; i < nper; i++) {
            ttp[i][per[i][0]][0] = -3.*Math.sqrt(21.)/7.;
            ttp[i][per[i][0]][1] = 0.;
            ttp[i][per[i][0]][2] = 6.*Math.sqrt(7.)/7;
            ttp[i][per[i][1]][0] = -3.*Math.sqrt(21.)/7.;
            ttp[i][per[i][1]][1] = 3.*Math.sqrt(21.)/7.;
            ttp[i][per[i][1]][2] = -3.*Math.sqrt(7.)/7.;
            ttp[i][per[i][2]][0] = -3.*Math.sqrt(21.)/7.;
            ttp[i][per[i][2]][1] = -3.*Math.sqrt(21.)/7.;
            ttp[i][per[i][2]][2] = -3.*Math.sqrt(7.)/7.;
            ttp[i][per[i][3]][0] = 3.*Math.sqrt(21.)/7.;
            ttp[i][per[i][3]][1] = 0.;
            ttp[i][per[i][3]][2] = 6.*Math.sqrt(7.)/7.;
            ttp[i][per[i][4]][0] = 3.*Math.sqrt(21.)/7.;
            ttp[i][per[i][4]][1] = 3.*Math.sqrt(21.)/7.;
            ttp[i][per[i][4]][2] = -3.*Math.sqrt(7.)/7.;
            ttp[i][per[i][5]][0] = 3.*Math.sqrt(21.)/7.;
            ttp[i][per[i][5]][1] = -3.*Math.sqrt(21.)/7.;
            ttp[i][per[i][5]][2] = -3.*Math.sqrt(7.)/7.;
            ttp[i][per[i][6]][0] = 0.;
            ttp[i][per[i][6]][1] = 0.;
            ttp[i][per[i][6]][2] = -3.;
            ttp[i][per[i][7]][0] = 0.;
            ttp[i][per[i][7]][1] = 3.*Math.sqrt(3.)/2.;
            ttp[i][per[i][7]][2] = 1.5;
            ttp[i][per[i][8]][0] = 0.;
            ttp[i][per[i][8]][1] = -3.*Math.sqrt(3.)/2.;
            ttp[i][per[i][8]][2] = 1.5;
        }
        return ttp;
    }

    public double[][][] csaGeometryTemplate() {
        System.out.println("Reading templates with csa geometry...");
        double[][][] csa = new double[362880][9][3];
        for (int i = 0; i < nper; i++) {
            csa[i][per[i][0]][0] = -Math.sqrt(6.);
            csa[i][per[i][0]][1] = 0.;
            csa[i][per[i][0]][2] = Math.sqrt(3.);
            csa[i][per[i][1]][0] = 0.;
            csa[i][per[i][1]][1] = -Math.sqrt(6.);
            csa[i][per[i][1]][2] = Math.sqrt(3.);
            csa[i][per[i][2]][0] = 0.;
            csa[i][per[i][2]][1] = Math.sqrt(6.);
            csa[i][per[i][2]][2] = Math.sqrt(3.);
            csa[i][per[i][3]][0] = Math.sqrt(6.);
            csa[i][per[i][3]][1] = 0.;
            csa[i][per[i][3]][2] = Math.sqrt(3.);
            csa[i][per[i][4]][0] = -Math.sqrt(3.);
            csa[i][per[i][4]][1] = -Math.sqrt(3.);
            csa[i][per[i][4]][2] = -Math.sqrt(3.);
            csa[i][per[i][5]][0] = -Math.sqrt(3.);
            csa[i][per[i][5]][1] = Math.sqrt(3.);
            csa[i][per[i][5]][2] = -Math.sqrt(3.);
            csa[i][per[i][6]][0] = Math.sqrt(3.);
            csa[i][per[i][6]][1] = -Math.sqrt(3.);
            csa[i][per[i][6]][2] = -Math.sqrt(3.);
            csa[i][per[i][7]][0] = Math.sqrt(3.);
            csa[i][per[i][7]][1] = Math.sqrt(3.);
            csa[i][per[i][7]][2] = -Math.sqrt(3.);
            csa[i][per[i][8]][0] = 0.;
            csa[i][per[i][8]][1] = 0.;
            csa[i][per[i][8]][2] = 3.;
        }
        return csa;
    }

}
