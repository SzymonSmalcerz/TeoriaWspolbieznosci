package com.smalcerz.executor;

import java.io.BufferedWriter;
import java.io.IOException;

import com.smalcerz.FoatClass;
import com.smalcerz.helpers.FileHandler;
import com.smalcerz.helpers.MatrixReader;
import com.smalcerz.production.P_gettingFinalValue;
import com.smalcerz.production.P_substraction;

public class Executor {
	
	private int n;
	private FoatClass f;
	
	
	private BufferedWriter writer;
	
	private MatrixReader matrixReader;
	
	private double [][] matrix;
	
	public Executor() throws IOException, InterruptedException {
		
		this.matrixReader = MatrixReader.getInstance();
		this.matrix = this.matrixReader.getMatrix();
		
		this.n = this.matrix.length; 
		
		this.writer = FileHandler.getInstance().getWriter();
		writer.write("Macierz : " + this.n + " x " + this.n);
		writer.newLine(); 
		
		this.f = new FoatClass(writer);
		this.execute();
	}
	
	
	
	private void execute() throws IOException, InterruptedException{
		System.out.println("EXECUTE \n\n");
		
		for(int i=0;i<n;i++) {
			
			
			
			if(matrix[i][i] == 0) {
				
				int indexOfFirstRow = i;
				int indexOfSecondRow = i;
				
				for(int j=i+1;j<n;j++) {
					
					if(matrix[j][i] != 0) { 
						indexOfSecondRow = j;
						continue;
					}
					
					if(j==n-1) {
						throw new Error("MATRIX WITHOUT SOLUTION");
					}
				}
				
				double [] tempArrayForFirstRow = matrix[indexOfFirstRow];
				double [] tempArrayForSecondRow = matrix[indexOfSecondRow];
				
				for(int k=0; k<n;k++) {
					matrix[indexOfFirstRow][k] = tempArrayForSecondRow[k];
					matrix[indexOfSecondRow][k] = tempArrayForFirstRow[k];
				}
			}
			
			
			for(int j=0;j<n;j++) {
				
				if(j==i) {
					continue;
				}else {
					
					if(matrix[j][i] != 0) {
						f.push(new P_substraction(matrix, i, j));
					}
				}
				
			}

			f.execute();
			
		}
		
		
		for(int i=0;i<n;i++) {
			f.push(new P_gettingFinalValue(matrix, i));
		}
		f.execute();
		
		

		
		System.out.println("\n\tWYLICZONA MACIERZ : \n\n");
		this.writer.write("\n\tWYLICZONA MACIERZ : \n\n");
		this.matrixReader.printMatrix(matrix);
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("END OF EXECUTION\n\n");
	}
}
