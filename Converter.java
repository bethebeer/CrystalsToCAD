import java.io.*;
import java.util.*;

/**
 * 
 */

/**
 * @author bethebeer
 *
 */


public class untitled{

    /**
     * @param args
     * @throws FileNotFoundException 
     */

    //2 dimensional array, should store all atoms
	public static ArrayList<ArrayList<String>> wholemolecule = new ArrayList<ArrayList<String>>();
	public static boolean xz = true;



    public static void main(String[] args) throws FileNotFoundException {
	// TODO Auto-generated method stub
    
    String filename = null;
    String infilename = null;
    String atomtype = null;


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
		scadfile.println("resH=16; //resolution of Hydrogen atoms");
		scadfile.println("resO=25; //resolution of Oxygen atoms");
		scadfile.println("res=20; //resolution of all other atoms");
		scadfile.println("");
		scadfile.println("");
		scadfile.println("//van der Waals Radii from:");
		scadfile.println("//2013DaltonTrans Alvarez A Cartography of the vdW Territories");
		scadfile.println("//http://pubs.rsc.org/en/content/articlehtml/2013/dt/c3dt50599e");
		scadfile.println("rH=1.20;");
		scadfile.println("rHe=1.43;");
		scadfile.println("rLi=2.12;");
		scadfile.println("rBe=1.98;");
		scadfile.println("rB=1.91;");
		scadfile.println("rC=1.77;");
		scadfile.println("rN=1.66;");
		scadfile.println("rO=1.50;");
		scadfile.println("rF=1.46;");
		scadfile.println("rNe=1.58;");
		scadfile.println("rNa=2.50;");
		scadfile.println("rMg=2.51;");
		scadfile.println("rAl=2.25;");
		scadfile.println("rSi=2.19;");
		scadfile.println("rP=1.90;");
		scadfile.println("rS=1.89;");
		scadfile.println("rCl=1.82;");
		scadfile.println("rAr=1.83;");
		scadfile.println("rK=2.73;");
		scadfile.println("rCa=2.62;");
		scadfile.println("rSc=2.58;");
		scadfile.println("rTi=2.46;");
		scadfile.println("rV=2.42;");
		scadfile.println("rCr=2.45;");
		scadfile.println("rMn=2.45;");
		scadfile.println("rFe=2.44;");
		scadfile.println("rCo=2.40;");
		scadfile.println("rNi=2.40;");
		scadfile.println("rCu=2.38;");
		scadfile.println("rZn=2.39;");
		scadfile.println("rGa=2.32;");
		scadfile.println("rGe=2.29;");
		scadfile.println("rAs=1.88;");
		scadfile.println("rSe=1.82;");
		scadfile.println("rBr=1.86;");
		scadfile.println("rKr=2.25;");
		scadfile.println("rRb=3.21;");
		scadfile.println("rSr=2.84;");
		scadfile.println("rY=2.75;");
		scadfile.println("rZr=2.52;");
		scadfile.println("rNb=2.56;");
		scadfile.println("rMo=2.45;");
		scadfile.println("rTc=2.44;");
		scadfile.println("rRu=2.46;");
		scadfile.println("rRh=2.44;");
		scadfile.println("rPd=2.15;");
		scadfile.println("rAg=2.53;");
		scadfile.println("rCd=2.49;");
		scadfile.println("rIn=2.43;");
		scadfile.println("rSn=2.42;");
		scadfile.println("rSb=2.47;");
		scadfile.println("rTe=1.99;");
		scadfile.println("rI=2.04;");
		scadfile.println("rXe=2.06;");
		scadfile.println("rCs=3.48;");
		scadfile.println("rBa=3.03;");
		scadfile.println("rLa=2.98;");
		scadfile.println("rCe=2.88;");
		scadfile.println("rPr=2.92;");
		scadfile.println("rNd=2.95;");
		scadfile.println("rSm=2.90;");
		scadfile.println("rEu=2.87;");
		scadfile.println("rGd=2.83;");
		scadfile.println("rTb=2.79;");
		scadfile.println("rDy=2.87;");
		scadfile.println("rHo=2.81;");
		scadfile.println("rEr=2.83;");
		scadfile.println("rTm=2.79;");
		scadfile.println("rYb=2.80;");
		scadfile.println("rLu=2.74;");
		scadfile.println("rHf=2.63;");
		scadfile.println("rTa=2.53;");
		scadfile.println("rW=2.57;");
		scadfile.println("rRe=2.49;");
		scadfile.println("rOs=2.48;");
		scadfile.println("rIr=2.41;");
		scadfile.println("rPt=2.29;");
		scadfile.println("rAu=2.32;");
		scadfile.println("rHg=2.45;");
		scadfile.println("rTl=2.47;");
		scadfile.println("rPb=2.60;");
		scadfile.println("rBi=2.54;");
		scadfile.println("rAc=2.8;");
		scadfile.println("rTh=2.93;");
		scadfile.println("rPa=2.88;");
		scadfile.println("rU=2.71;");
		scadfile.println("rNp=2.82;");
		scadfile.println("rPu=2.81;");
		scadfile.println("rAm=2.83;");
		scadfile.println("rCm=3.05;");
		scadfile.println("rBk=3.4;");
		scadfile.println("rCf=3.05;");
		scadfile.println("rEs=2.7;");

		scadfile.println("");
		scadfile.println("");
		scadfile.println("");
		//MAKE SURE YOU CLOSE THIS UNION LATER, with another bracket!!
		scadfile.println("union(){");

/*
** now i will call the modules that will turn the 
** mol2 file into arrays that will become the scad file
*/
		int height = mol2(inputFile);

//writing the rest of the file from the 2 dimensional
//array list, wholemolecule
		for(int i = 0; i<height; i++){
			if(oneletterelement(get(i,5))){
				if(get(i,1).substring(0,1).equals("H") || get(i,1).substring(0,1).equals("C") || get(i,1).substring(0,1).equals("O")){
					scadfile.println("translate(["+get(i,2)+","+get(i,3)+","+get(i,4)+"])sphere(r=r"+get(i,1).substring(0,1) +", $fn=res"+get(i,1).substring(0,1) +");");
				}
				else{
					scadfile.println("translate(["+get(i,2)+","+get(i,3)+","+get(i,4)+"])sphere(r=r"+get(i,1).substring(0,1) +", $fn=res);");	
				}
			}
			else{
				
				scadfile.println("translate(["+get(i,2)+","+get(i,3)+","+get(i,4)+"])sphere(r=r"+get(i,1).substring(0,2) +", $fn=res);");
			}
		}
		scadfile.println("}");
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

	public static boolean oneletterelement(String elementnum){
		if(elementnum.length()<2){
			xz=true;
		}
		if(elementnum.length()==2 && elementnum.matches(".*\\d.*")!=true){
			xz=false;
		}
		if(elementnum.length()>1 && elementnum.contains(".") && elementnum.indexOf(".")!=1 ){
			xz=true;
		}

		return xz;
		
	}

}
	






