package com.smalcerz.TW_PROJEKT_.helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MatrixReader {
	
	public static double[][] getMatrix(){
		
		String line = "";
		String fileName = "/home/szymcio/eclipse-workspace/TW_PROJEKT_FINAL/src/main/java/com/smalcerz/TW_PROJEKT_FINAL/asd.txt";
		double matrix[][] = null;
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            @SuppressWarnings("resource")
			BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            
            String firstLine = bufferedReader.readLine();
            if(firstLine.length() > 1) {
            	throw new Exception("bad format of input");
            }
            int n = Integer.parseInt(firstLine);
            
            matrix = new double[n][n+1];
            
            int index = 0;
            while(index != n) {
            	
            	line = bufferedReader.readLine();
            	double arrayTemp[] = getDoubleArray(line);
            	if(arrayTemp.length != n) {
            		throw new Exception("Bad format of input");
            	}
            	for(int i=0;i<n;i++) {
            		matrix[index][i] = arrayTemp[i];
            	}
            	index += 1;
            }   
            
            line = bufferedReader.readLine();
            double arrayWsp[] = getDoubleArray(line);
            for(int i=0;i<n;i++) {
        		matrix[i][n] = arrayWsp[i];
        	}
            // Always close files.
            bufferedReader.close(); 
            
            
            
        }
		catch(NumberFormatException e) {
			System.out.println(e);
		}
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this:  
            // ex.printStackTrace();
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printMatrix(matrix);
		return matrix;
	}
	
	private static double[] getDoubleArray(String strLine) {
	    double[] a;
	    String[] split = strLine.split(" "); //split the line at the ',' and ')' characters
	    a = new double[split.length];
	    for(int i = 0; i < a.length; i++){
	        a[i] = Double.parseDouble(split[i]); //get the double value of the String
	    }
	    
	    
	    return a;
	}
	
	
	public static void printMatrix(double[][] matrix) {
		
		System.out.println("\n\tWCZYTANA MACIERZ : \n\n");
		
		for(int w=0;w<matrix.length;w++) {
			System.out.print("\t");
			for(int k=0;k<matrix[0].length;k++) {
				if(k!=matrix[0].length -1 ) {
					System.out.print(matrix[w][k] + " ");
				}
				else {
					System.out.print("| " + matrix[w][k]);
				}
			}
			System.out.println();
		}
	}
}
