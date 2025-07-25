public class CIFStructure {
    /**
     * _atom_site.group_PDB -> recordName
     * _atom_site.id -> atomNumber
     * _atom_site.type_symbol
     * _atom_site.label_atom_id -> atomName
     * _atom_site.label_alt_id
     * _atom_site.label_comp_id  -> residueName
     * _atom_site.label_asym_id
     * _atom_site.label_entity_id
     * _atom_site.label_seq_id -> residueNumber
     * _atom_site.pdbx_PDB_ins_code
     * _atom_site.Cartn_x -> xCoordinate
     * _atom_site.Cartn_y -> yCoordinate
     * _atom_site.Cartn_z -> zCoordinate
     * _atom_site.occupancy
     * _atom_site.B_iso_or_equiv
     * _atom_site.pdbx_formal_charge -> not reported by BioJava structure.toMMCIF()
     * _atom_site.auth_seq_id
     * _atom_site.auth_comp_id
     * _atom_site.auth_asym_id -> chain
     * _atom_site.auth_atom_id
     * _atom_site.pdbx_PDB_model_num

     */

    private String recordName;
    private int atomNumber;
    private String type_symbol;
    private String atomName;
    private String label_alt_id;
    private String residueName;
    private String chain;
    private int label_entity_id;
    private int residueNumber;
    private String pdbx_PDB_ins_code;
    private double xCoordinate;
    private double yCoordinate;
    private double zCoordinate;
    private float occupancy;
    private double B_iso_or_equiv;
    private String pdbx_formal_charge;
    private int auth_seq_id;
    private String auth_comp_id;
    private String auth_asym_id;
    private String auth_atom_id;
    private int pdbx_PDB_model_num;

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

    public String getType_symbol() {
        return type_symbol;
    }

    public void setType_symbol(String type_symbol) {
        this.type_symbol = type_symbol;
    }

    public String getAtomName() {
        return atomName;
    }

    public void setAtomName(String atomName) {
        this.atomName = atomName;
    }

    public String getLabel_alt_id() {
        return label_alt_id;
    }

    public void setLabel_alt_id(String label_alt_id) {
        this.label_alt_id = label_alt_id;
    }

    public String getResidueName() {
        return residueName;
    }

    public void setResidueName(String residueName) {
        this.residueName = residueName;
    }

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public int getLabel_entity_id() {
        return label_entity_id;
    }

    public void setLabel_entity_id(int label_entity_id) {
        this.label_entity_id = label_entity_id;
    }

    public int getResidueNumber() {
        return residueNumber;
    }

    public void setResidueNumber(int residueNumber) {
        this.residueNumber = residueNumber;
    }

    public String getPdbx_PDB_ins_code() {
        return pdbx_PDB_ins_code;
    }

    public void setPdbx_PDB_ins_code(String pdbx_PDB_ins_code) {
        this.pdbx_PDB_ins_code = pdbx_PDB_ins_code;
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

    public float getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(float occupancy) {
        this.occupancy = occupancy;
    }

    public double getB_iso_or_equiv() {
        return B_iso_or_equiv;
    }

    public void setB_iso_or_equiv(double b_iso_or_equiv) {
        B_iso_or_equiv = b_iso_or_equiv;
    }

    public String getPdbx_formal_charge() {
        return pdbx_formal_charge;
    }

    public void setPdbx_formal_charge(String pdbx_formal_charge) {
        this.pdbx_formal_charge = pdbx_formal_charge;
    }

    public int getAuth_seq_id() {
        return auth_seq_id;
    }

    public void setAuth_seq_id(int auth_seq_id) {
        this.auth_seq_id = auth_seq_id;
    }

    public String getAuth_comp_id() {
        return auth_comp_id;
    }

    public void setAuth_comp_id(String auth_comp_id) {
        this.auth_comp_id = auth_comp_id;
    }

    public String getAuth_asym_id() {
        return auth_asym_id;
    }

    public void setAuth_asym_id(String auth_asym_id) {
        this.auth_asym_id = auth_asym_id;
    }

    public String getAuth_atom_id() {
        return auth_atom_id;
    }

    public void setAuth_atom_id(String auth_atom_id) {
        this.auth_atom_id = auth_atom_id;
    }

    public int getPdbx_PDB_model_num() {
        return pdbx_PDB_model_num;
    }

    public void setPdbx_PDB_model_num(int pdbx_PDB_model_num) {
        this.pdbx_PDB_model_num = pdbx_PDB_model_num;
    }
}

