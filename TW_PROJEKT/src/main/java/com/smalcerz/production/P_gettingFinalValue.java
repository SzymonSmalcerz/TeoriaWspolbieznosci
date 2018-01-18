package com.smalcerz.production;

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
		divider = matrix[indexOfRow][indexOfRow];
		matrix[indexOfRow][n-1] /= divider; //FINAL RESULT
		matrix[indexOfRow][indexOfRow] = 1.0;
		
		
		for(int i=0;i<n;i++) {
			if(Math.abs(matrix[indexOfRow][i]) < Math.pow(10, -10)) {
				matrix[indexOfRow][i] = 0;
			}
		}
		return;
			
		
		
		
	}
	
	
}
