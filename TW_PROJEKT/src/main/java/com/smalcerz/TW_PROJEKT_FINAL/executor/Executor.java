package com.smalcerz.TW_PROJEKT_FINAL.executor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import com.smalcerz.TW_PROJEKT_.helpers.MatrixReader;
import com.smalcerz.TW_PROJEKT_FINAL.FoatClass;
import com.smalcerz.TW_PROJEKT_FINAL.production.P_gettingFinalValue;
import com.smalcerz.TW_PROJEKT_FINAL.production.P_substraction;

public class Executor {
	
	private int n;
	private FoatClass f;
	BufferedWriter writer;
	
	private double [][] matrix;
	
	@SuppressWarnings("deprecation")
	public Executor() {
		
		this.matrix = MatrixReader.getMatrix();
		this.n = this.matrix.length;
		try {
			//only temporary for diffrent file names
			Date date = new Date();
			
			String dateString = Integer.toString(date.getYear())  + "." + Integer.toString(date.getMonth()) 
			+ "." + Integer.toString(date.getDay()) + "." +
			Integer.toString(date.getHours()) + "." + date.getMinutes() + "." + date.getSeconds();
			
			File file = new File("/home/szymcio/eclipse-workspace/TW_PROJEKT/src/com/smalcerz/" + dateString +".txt");
			this.writer = new BufferedWriter(new FileWriter(file));
			writer.write("Macierz : " + this.n + " x " + this.n);
			writer.newLine(); 
//			this.writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("results.txt"), "utf-8"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.f = new FoatClass(writer);
		this.execute();
	}
	
	
	
	private void execute(){
		System.out.println("EXECUTE \n\n");
		
		for(int i=0;i<n;i++) {
			
			
			
			if(matrix[i][i] == 0) {
				
				int indexOfFirstRow = i;
				int indexOfSecondRow = i;
				
				for(int j=i+1;j<n;j++) {
					
					if(matrix[j][i] != 0) { 
						indexOfSecondRow = j;
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
		
		MatrixReader.printMatrix(matrix);
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("END OF EXECUTION\n\n");
	}
}
