CrystalsToCAD
=============

Deprecated in favor of https://github.com/albinoBandicoot/CrystalsToCad

.mol2 to .scad converter

I have made a simple script to convert a .mol2 file into an editable .scad file. It is all run through the command line.  You will need Openscad in order to edit the .scad file(http://www.openscad.org/).

TODO:
Add radii for more elements.
Add color for the F5 rendering.
Add ball and stick model option
Add vibrational model option
Create a simple GUI!

Instructions:

You have to have java installed on your computer, most OS's already do, but if not, googling should find a simple walkthrough


1. In the command line, go to the directory in which the Converter.java is stored, which could be like this:

cd /Downloads/CrystalsToCAD/Converter.java



2. Then compile the script:

javac Converter.java

3. Then run the script.  It takes the filename, but if the file is not in the same directory as the Converter.java, then you must include the path, such as /Downloads/Crystals/CRETAL01.mol2 rather than just CRETAL01.mol2:

java Converter filetoconvert.mol2 optional_name_of_output_file.scad

Once you see:

Yourfile.scad had been created.

You can then open up the .scad file in Openscad.

