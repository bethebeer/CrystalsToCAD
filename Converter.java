import java.io.*;
import java.util.*;

/**
 * 
 */

/**
 * @author ggerbush
 *
 */


public class untitled{

    /**
     * @param args
     * @throws FileNotFoundException 
     */

    //2 dimensional array, should store all atoms
	public static ArrayList<ArrayList<String>> wholemolecule = new ArrayList<ArrayList<String>>();



    public static void main(String[] args) throws FileNotFoundException {
	// TODO Auto-generated method stub
    
    String filename = null;
    String infilename = null;


	if(args[0].contains(".mol2")){
		File inputFile = new File(args[0]);
		
		infilename = args[0];
		infilename = infilename.substring(0,infilename.length()-5);

//starting the output file, it gets filled in the mol2() module
		if(args.length > 1){
		filename = args[1];
		}
		else{
		filename = infilename + ".scad";
		}
		if(filename.contains(".scad")!=true){
			filename = filename + ".scad";
		}
		PrintWriter scadfile = new PrintWriter(new File(filename));
		scadfile.println("SCALE=1;");
		scadfile.println("resC=30; //resolution of Carbon atoms");
		scadfile.println("resH=10; //resolution of Hydrogen atoms");
		scadfile.println("res=20; //resolution of all other atoms");
		scadfile.println("");
		scadfile.println("");
		scadfile.println("//  Nonbonded Contact Definition; van der Waals Radii from:");
		scadfile.println("//  http://isostar.ccdc.cam.ac.uk/help/IsoStar/isostar.3.44.html");
		scadfile.println("rH=1.20;");
		scadfile.println("rC=1.70;");
		scadfile.println("rN=1.55;");
		scadfile.println("rO=1.52;");
		scadfile.println("rF=1.47;");
		scadfile.println("rSi=2.10;");
		scadfile.println("rP=1.80;");
		scadfile.println("rS=1.80;");
		scadfile.println("rCl=1.75;");
		scadfile.println("rBr=1.85;");
		scadfile.println("rI=1.98;");

		scadfile.println("");
		scadfile.println("");
		scadfile.println("");

/*
** now i will call the modules that will turn the 
** mol2 file into arrays that will become the scad file
*/
		int height = mol2(inputFile);

//writing the rest of the file from the 2 dimensional
//array list, wholemolecule
		for(int i = 0; i<height; i++){
			if(get(i,1).substring(0,1)=="H" || get(i,1).substring(0,1)=="C"){
				scadfile.println("translate(["+get(i,2)+","+get(i,3)+","+get(i,4)+"])sphere(r=r"+get(i,1).substring(0,1) +", $fn=res"+get(i,1).substring(0,1)+");");
			}
			else{
				scadfile.println("translate(["+get(i,2)+","+get(i,3)+","+get(i,4)+"])sphere(r=r"+get(i,1).substring(0,1) +", $fn=res);");
			}
		}

//****CLOSE IT
		scadfile.close();
	}
		
	
	
	
/*
**debug
*/
	 System.out.println(filename + " has been created.");

	}



	public static int mol2(File inputFile) throws FileNotFoundException {
		Scanner in = new Scanner(inputFile);
		
		String findstart = in.nextLine();
		
		while(findstart.contains("ATOM")!=true){
				if(in.hasNextLine()){
					findstart = in.nextLine();
				}
				
		}
		
//the variables, roundnum and round, are made to keep track of 
//the lines; just another check to make sure the .mol2 format
//is appearing correctly
		int roundnum = 0;
		String currentline = in.nextLine();
		int debug=99;


		while(currentline.contains("BOND")!=true){
		
			roundnum++;
			Scanner current = new Scanner(currentline);
			debug = current.nextInt();
//			System.out.println(currentline);
//			System.out.println(currentline.length());
//
//			System.out.println(roundnum);
//			System.out.println(debug);

			if(debug!=roundnum){
				System.out.println("Something went wrong, you");
				System.out.println("might want to close the");
				System.out.println("program with CTRL + C");
			}
			String linnum = "" + roundnum;
			Add(linnum,roundnum-1);
			for(int i=1; i<9; i++){
				Add(current.next(),roundnum-1);
			}
			
			currentline = in.nextLine();
		}

//****CLOSE IT
		in.close();
		return roundnum;
	}


	/**
	 * Taken from: http://www.javaprogrammingforums.com/java-programming-tutorials/696-multi-dimension-arraylist-example.html
	 **Adds an item at the end of the specified row.
	 **This will guarantee that at least row rows exist.
	 **
	 */
	public static void Add(String data, int row){
		while(row >= getNumRows()){
			wholemolecule.add(new ArrayList<String>());
		}
		wholemolecule.get(row).add(data);
	}
 
	public static String get(int row, int col){
		return wholemolecule.get(row).get(col);
	}
	public static int getNumRows(){
		return wholemolecule.size();
	}
}
	





