package com.smalcerz.TW_PROJEKT_FINAL.production;

public class P_substraction  extends Production {
	
	
	private double [][] matrix;
	private int indexOfSubstractionRow;
	private int indexOfSubstractedRow;
	private double divider;
	
	
	
	public P_substraction(double[][] matrix, int indexOfSubstractionRow,
			int indexOfSubstractedRow) {
		super();
		this.matrix = matrix;
		this.indexOfSubstractionRow = indexOfSubstractionRow;
		this.indexOfSubstractedRow = indexOfSubstractedRow;
		this.divider = matrix[indexOfSubstractionRow][indexOfSubstractionRow] / matrix[indexOfSubstractedRow][indexOfSubstractionRow];
	}
 


	@Override
	public void run()  {
		
		double [] tempArray = new double[matrix[0].length];
		
		for(int i=0;i<tempArray.length;i++) {
			tempArray[i] = matrix[indexOfSubstractionRow][i]/divider;
		}
		
		for(int i=0;i<tempArray.length;i++) {
			matrix[indexOfSubstractedRow][i] -= tempArray[i];
		}
		
	}

}
