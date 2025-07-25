import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class myPDBFileReader {

    public List<PDBStructure> readPDBFile(String filePath) {

        List<PDBStructure> structures = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                PDBStructure structure = new PDBStructure();
                structure.setRecordName(line.substring(0, 6).trim());
                structure.setAtomNumber(Integer.parseInt(line.substring(7, 11).trim()));
                structure.setAtomName(line.substring(12,16).trim());
                structure.setResidueName(line.substring(17, 20).trim());
                structure.setChain(line.substring(21,22));
                structure.setResidueNumber(Integer.parseInt(line.substring(22, 26).trim()));
                structure.setXCoordinate(Double.parseDouble(line.substring(30, 38).trim()));
                structure.setYCoordinate(Double.parseDouble(line.substring(38, 46).trim()));
                structure.setZCoordinate(Double.parseDouble(line.substring(46, 54).trim()));
                structures.add(structure);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return structures;
    }

}
