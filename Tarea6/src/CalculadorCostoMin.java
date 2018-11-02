import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.naming.StringRefAddr;

public class CalculadorCostoMin {

	/**
	 * Main method for the numbers sorter example. It requires three parameters:
	 * args[0]: Input file with numbers to sort. It must be a text file with one number per line
	 * args[1]: Output file to save the sorted numbers
	 * args[2]: (Optional) Algorithm used to sort the numbers. It can be Bubble, Merge or Quick.
	 * If not provided, the default algorithm implemented in the static method sort of the class
	 * java.util.Arrays is used
	 * @param args Array with the arguments described above 
	 * @throws Exception if the input file does not exist or it can not be read
	 * @throws Exception If the algorithm is not implmented
	 */
	public static void main(String[] args) throws Exception {
		//Read parameters
		String inFilename = args[0];
		String outFilename = args[1];
		String algorithm = null;
		if(args.length>2) algorithm = args[2];
		
		//Read input file
		List<Integer> numbersList = new ArrayList<>();
		String [] numeros = args[0].split("\t");
		int lines = 0;
		String[] partes;
		try (FileReader reader = new FileReader(inFilename);
			 BufferedReader in = new BufferedReader(reader)) { 
			String line = in.readLine();
			partes = line.split("\t");
			for (int i=0;line != null;i++) {
				try {
					lines++;
				} catch (Exception e) {
					System.err.println("Can not read number from line "+i+" content: "+line);
					e.printStackTrace();
				}
				line = in.readLine();
			}
		}
		int[][] matriz = new int[lines][partes.length];
		
		try (FileReader reader = new FileReader(inFilename);
				 BufferedReader in = new BufferedReader(reader)) { 
				String line = in.readLine();
				partes = line.split("\t");
				for (int i=0;line != null;i++) {
					try {
						for (int j = 0; j < partes.length; j++) {
							matriz[i][j]=Integer.parseInt(partes[j]);
						}
					} catch (Exception e) {
						System.err.println("Can not read number from line "+i+" content: "+line);
						e.printStackTrace();
					}
					line = in.readLine();
				}
			}
		
		for (int i = 0; i < matriz.length; i++) {
		    for (int j = 0; j < matriz[i].length; j++) {
		        System.out.print(matriz[i][j] + " ");
		    }
		    System.out.println();
		}
		
		String algorithmClassName = CalculadorCostoMin.class.getPackage().getName()+"."+args[1];
		CaminosCostoMinimo calculator = (CaminosCostoMinimo)Class.forName(algorithmClassName).newInstance();
		calculator.calculateMinimumCost(matriz);
		
	}
}
