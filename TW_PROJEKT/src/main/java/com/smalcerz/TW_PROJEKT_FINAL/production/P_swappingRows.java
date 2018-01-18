package com.smalcerz.TW_PROJEKT_FINAL.production;

public class P_swappingRows extends Production{
	
	private double [][] matrix;
	private int indexOfFirstRow;
	private int indexOfSecondRow;
	
	public P_swappingRows(double[][] matrix, int indexOfFirstRow, int indexOfSecondRow) {
		super();
		this.matrix = matrix;
		this.indexOfFirstRow = indexOfFirstRow;
		this.indexOfSecondRow = indexOfSecondRow;
	}
	
	
	@Override
	public void run() {
		
		double [] tempArrayForFirstRow = this.matrix[indexOfFirstRow];
		double [] tempArrayForSecondRow = this.matrix[indexOfSecondRow];
		
		int n = matrix[0].length;
		
		for(int i=0; i<n;i++) {
			matrix[indexOfFirstRow][i] = tempArrayForSecondRow[i];
			matrix[indexOfSecondRow][i] = tempArrayForFirstRow[i];
		}
		
		
	}
	
	
	
}
