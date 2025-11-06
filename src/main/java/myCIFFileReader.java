import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class myCIFFileReader {

    public List<CIFStructure> readCIFFile(String filePath) {

        List<CIFStructure> structures = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if(line.startsWith("#") || line.startsWith("_") || line.startsWith("loop_")) {
                    continue;
                }
                CIFStructure cif_structure = new CIFStructure();
                String[] structure = line.split(" ");
                cif_structure.setRecordName(structure[0]);
                cif_structure.setAtomNumber(Integer.parseInt(structure[1]));
                cif_structure.setType_symbol(structure[2]);
                cif_structure.setAtomName(structure[3]);
                cif_structure.setLabel_alt_id(structure[4]);
                cif_structure.setResidueName(structure[5]);
                cif_structure.setAuth_asym_id(structure[6]);
                cif_structure.setLabel_entity_id(Integer.parseInt(structure[7]));
                cif_structure.setAuth_seq_id(Integer.parseInt(structure[8]));
                cif_structure.setPdbx_PDB_ins_code(structure[9]);
                cif_structure.setXCoordinate(Double.parseDouble(structure[10]));
                cif_structure.setYCoordinate(Double.parseDouble(structure[11]));
                cif_structure.setZCoordinate(Double.parseDouble(structure[12]));
                cif_structure.setOccupancy(Float.parseFloat(structure[13]));
                cif_structure.setB_iso_or_equiv(Double.parseDouble(structure[14]));
                //cif_structure.setPdbx_formal_charge(structure[15]);
                cif_structure.setResidueNumber(Integer.parseInt(structure[15]));
                cif_structure.setAuth_comp_id(structure[16]);
                cif_structure.setChain(structure[17]);
                cif_structure.setAuth_atom_id(structure[18]);
                cif_structure.setPdbx_PDB_model_num(Integer.parseInt(structure[19]));

                structures.add(cif_structure);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return structures;
    }

}
