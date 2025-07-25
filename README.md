# FindGEO

**FindGeo** is a tool for determining the coordination geometry of metals in
biological macromolecules (or in small complexes) with known structure.

At present, information on metal coordination geometry can be retrieved
only by exploring the primary literature, which however sometimes contains
an improper or incorrect description of the geometry, and often lacks it
altogether. Therefore, the use of FindGeo will benefit scientists by: (1)
minimizing errors in the assignment of geometries, (2) promoting a uniform
terminology and classification of geometries and thus (3) providing a
reliable basis for structure–function relationship studies where
coordination geometry is a relevant parameter.

---

## Usage

To use **FindGeo** you must have Java version 17 or greater.

Many Linux/Mac systems already have a version of Java installed. Check the installed version by running: 

```bash
java -version
```

If the installed version is lower than version 17, you can still install version 17 as several versions can safely co-exist.
In that case, you can download the compressed tar file from [https://adoptium.net/temurin/releases/](https://adoptium.net/temurin/releases/) site and unpack it in any folder, e.g. /opt and run **FindGeo** with:

```bash
/opt/<java-version>/bin/java -jar FindGeo-1.1.jar
```

Running FindGeo without options will show a help with the various options available

```
usage: findgeo
 -e,--excluded_donors <arg>   Chemical symbols of the atoms (separated by
                              commas) excluded from metal ligands. Default
                              is C and H.
 -f,--format <arg>            Local file format (i.e. cif or pdb).
 -i,--input <arg>             Local PDB/mmCIF local file.
 -m,--metal <arg>             Chemical symbol of the metal of interest.
                              Default is all metals.
 -o,--overwrite               Overwrite existing files and directories.
 -p,--pdb <arg>               Local input PDB file or PDB code of input
                              PDB file to be downloaded from the web.
 -t,--threshold <arg>         Coordination distance threshold. Default is
                              2.8 A.
 -w,--workdir <arg>           Directory where to find or download the
                              input PDB file and to write outputs. Default
                              is ./
```

An example of use is

```bash
/opt/<java-version>/bin/java -jar FindGeo-1.1.jar -p 12ca.pdb
```
