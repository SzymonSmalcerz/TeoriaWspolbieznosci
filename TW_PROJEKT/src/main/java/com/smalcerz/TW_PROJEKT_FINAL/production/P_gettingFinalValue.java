package com.smalcerz.TW_PROJEKT_FINAL.production;

public class P_gettingFinalValue extends Production{
	
	private double [][] matrix;
	private int indexOfRow;
	
	public P_gettingFinalValue(double[][] matrix, int indexOfRow) {
		super();
		this.matrix = matrix;
		this.indexOfRow = indexOfRow;
	}
	
	
	@Override
	public void run() {
		
		int n = matrix[0].length;
		
		
		double divider;
		for(int i=0;i<n;i++) {
			if(matrix[indexOfRow][i] != 0) {
				divider = matrix[indexOfRow][i];
				matrix[indexOfRow][n-1] /= divider; //FINAL RESULT
				matrix[indexOfRow][i] = 1.0;
				return;
			}
		}
	}
	
	
}
