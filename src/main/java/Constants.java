import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Constants {

    private HashMap<String, List<Double>> distortedIrregular = new HashMap<>();
    private HashMap<String, String> geometryNames = new HashMap<>();
    private void setDistortedIrregular() {

        distortedIrregular.put("boc", Arrays.asList(0.357, 0.631));
        distortedIrregular.put("bts", Arrays.asList(0.309, 0.770));
        distortedIrregular.put("btt", Arrays.asList(0.544, 0.797));
        distortedIrregular.put("bva", Arrays.asList(0.440, 0.980));
        distortedIrregular.put("bvp", Arrays.asList(0.277, 0.650));
        distortedIrregular.put("coc", Arrays.asList(0.382, 0.784));
        distortedIrregular.put("cof", Arrays.asList(0.432, 0.607));
        distortedIrregular.put("con", Arrays.asList(0.525, 0.837));
        distortedIrregular.put("csa", Arrays.asList(0.292, 0.292));
        distortedIrregular.put("ctf", Arrays.asList(0.429, 0.646));
        distortedIrregular.put("ctn", Arrays.asList(0.428, 0.748));
        distortedIrregular.put("ctp", Arrays.asList(0.326, 0.769));
        distortedIrregular.put("cub", Arrays.asList(0.357, 0.746));
        distortedIrregular.put("cuv", Arrays.asList(0.382, 0.566));
        distortedIrregular.put("hbp", Arrays.asList(0.440, 0.757));
        distortedIrregular.put("hva", Arrays.asList(0.470, 0.826));
        distortedIrregular.put("hvp", Arrays.asList(0.348, 0.734));
        distortedIrregular.put("lin", Arrays.asList(0.777, 0.777));
        distortedIrregular.put("oct", Arrays.asList(0.427, 0.890));
        distortedIrregular.put("pbp", Arrays.asList(0.373, 0.826));
        distortedIrregular.put("pva", Arrays.asList(0.429, 0.890));
        distortedIrregular.put("pvp", Arrays.asList(0.427, 0.745));
        distortedIrregular.put("pyv", Arrays.asList(0.277, 0.812));
        distortedIrregular.put("sav", Arrays.asList(0.326, 0.655));
        distortedIrregular.put("spl", Arrays.asList(0.549, 0.980));
        distortedIrregular.put("spv", Arrays.asList(0.634, 0.742));
        distortedIrregular.put("spy", Arrays.asList(0.491, 0.604));
        distortedIrregular.put("sqa", Arrays.asList(0.309, 0.797));
        distortedIrregular.put("tbp", Arrays.asList(0.491, 0.551));
        distortedIrregular.put("tet", Arrays.asList(0.440, 0.909));
        distortedIrregular.put("tev", Arrays.asList(0.508, 0.742));
        distortedIrregular.put("tpr", Arrays.asList(0.499, 0.748));
        distortedIrregular.put("tpv", Arrays.asList(0.551, 0.604));
        distortedIrregular.put("tri", Arrays.asList(0.508, 0.634));
        distortedIrregular.put("trv", Arrays.asList(0.777, 0.777));
        distortedIrregular.put("ttp", Arrays.asList(0.292, 0.292));

    }

    public HashMap<String, List<Double>> getDistortedIrregular() {
        setDistortedIrregular();
        return distortedIrregular;
    }

    private void setGeometryNames() {
        geometryNames.put("boc", "OCTAHEDRAL, TRANS-BICAPPED");
        geometryNames.put("bts", "TRIGONAL PRISM, SQUARE-FACE BICAPPED");
        geometryNames.put("btt", "TRIGONAL PRISM, TRIANGULAR-FACE BICAPPED");
        geometryNames.put("bva", "TRIGONAL BIPYRAMID WITH A VACANCY (AXIAL)");
        geometryNames.put("bvp", "TRIGONAL BIPYRAMID WITH A VACANCY (EQUATORIAL)");
        geometryNames.put("coc", "OCTAHEDRON FACE MONOCAPPED");
        geometryNames.put("cof", "OCTAHEDRON FACE MONOCAPPED WITH A VACANCY (CAPPED FACE)");
        geometryNames.put("con", "OCTAHEDRON FACE MONOCAPPED WITH A VACANCY (NON-CAPPED FACE");
        geometryNames.put("csa", "SQUARE ANTIPRISM, SQUARE-FACE MONOCAPPED");
        geometryNames.put("ctf", "TRIGONAL PRISM, SQUARE-FACE MONOCAPPED WITH A VACANCY (CAPPED FACE)");
        geometryNames.put("ctn", "TRIGONAL PRISM, SQUARE-FACE MONOCAPPED WITH A VACANCY (NON-CAPPED EDGE)");
        geometryNames.put("ctp", "TRIGONAL PRISM, SQUARE-FACE MONOCAPPED");
        geometryNames.put("cub", "CUBE");
        geometryNames.put("cuv", "CUBE WITH A VACANCY");
        geometryNames.put("hbp", "HEXAGONAL BIPYRAMID");
        geometryNames.put("hva", "HEXAGONAL BIPYRAMID WITH A VACANCY (AXIAL)");
        geometryNames.put("hvp", "HEXAGONAL BIPYRAMID WITH A VACANCY (EQUATORIAL)");
        geometryNames.put("lin", "LINEAR");
        geometryNames.put("oct", "OCTAHEDRON");
        geometryNames.put("pbp", "PENTAGONAL BIPYRAMID");
        geometryNames.put("pva", "PENTAGONAL BIPYRAMID WITH A VACANCY (AXIAL)");
        geometryNames.put("pvp", "PENTAGONAL BIPYRAMID WITH A VACANCY (EQUATORIAL)");
        geometryNames.put("pyv", "SQUARE PYRAMID WITH A VACANCY (EQUATORIAL)");
        geometryNames.put("sav", "SQUARE ANTIPRISM WITH A VACANCY");
        geometryNames.put("spl", "SQUARE PLANE");
        geometryNames.put("spy", "SQUARE PYRAMID");
        geometryNames.put("sqa", "SQUARE ANTIPRISM");
        geometryNames.put("spv", "SQUARE PLANE WITH A VACANCY");
        geometryNames.put("tbp", "TRIGONAL BIPYRAMID");
        geometryNames.put("tet", "TETRAHEDRON");
        geometryNames.put("tev", "TETRAHEDRON WITH A VACANCY");
        geometryNames.put("tpr", "TRIGONAL PRISM");
        geometryNames.put("tpv", "TRIGONAL PRISM WITH A VACANCY");
        geometryNames.put("tri", "TRIGONAL PLANE");
        geometryNames.put("trv", "TRIGONAL PLANE WITH A VACANCY");
        geometryNames.put("ttp", "TRIGONAL PRISM, SQUARE-FACE TRICAPPED");

    }

    public HashMap<String, String> getGeometryNames() {
        setGeometryNames();
        return geometryNames;
    }
}
