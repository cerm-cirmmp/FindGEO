public class PDBStructure {
    /**
     * Handler for ATOM.
     * Record Format:
     *
     * <pre>
     * ATOM      1  N   ASP A  15     110.964  24.941  59.191  1.00 83.44           N
     *
     * COLUMNS        DATA TYPE       FIELD         DEFINITION
     * ---------------------------------------------------------------------------------
     * 1 -  6        Record name     "ATOM  "
     * 7 - 11        Integer         serial        Atom serial number.
     * 13 - 16        Atom            name          Atom name.
     * 17             Character       altLoc        Alternate location indicator.
     * 18 - 20        Residue name    resName       Residue name.
     * 22             Character       chainID       Chain identifier.
     * 23 - 26        Integer         resSeq        Residue sequence number.
     * 27             AChar           iCode         Code for insertion of residues.
     * 31 - 38        Real(8.3)       x             Orthogonal coordinates for X in Angstroms.
     * 39 - 46        Real(8.3)       y             Orthogonal coordinates for Y in Angstroms.
     * 47 - 54        Real(8.3)       z             Orthogonal coordinates for Z in Angstroms.
     * 55 - 60        Real(6.2)       occupancy     Occupancy.
     * 61 - 66        Real(6.2)       tempFactor    Temperature factor.
     * 73 - 76        LString(4)      segID         Segment identifier, left-justified.
     * 77 - 78        LString(2)      element       Element symbol, right-justified.
     * 79 - 80        LString(2)      charge        Charge on the atom.
     * </pre>
     */

    private String recordName;
    private int atomNumber;
    private String atomName;
    private String residueName;
    private String chain;
    private int residueNumber;
    private double xCoordinate;
    private double yCoordinate;
    private double zCoordinate;

    public String getAtomName() {
        return atomName;
    }

    public void setAtomName(String atomName) {
        this.atomName = atomName;
    }

    public String getResidueName() {
        return residueName;
    }

    public void setResidueName(String residueName) {
        this.residueName = residueName;
    }

    public int getResidueNumber() {
        return residueNumber;
    }

    public void setResidueNumber(int residueNumber) {
        this.residueNumber = residueNumber;
    }

    public double getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public double getZCoordinate() {
        return zCoordinate;
    }

    public void setZCoordinate(double zCoordinate) {
        this.zCoordinate = zCoordinate;
    }

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName;
    }

    public int getAtomNumber() {
        return atomNumber;
    }

    public void setAtomNumber(int atomNumber) {
        this.atomNumber = atomNumber;
    }

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }
}

