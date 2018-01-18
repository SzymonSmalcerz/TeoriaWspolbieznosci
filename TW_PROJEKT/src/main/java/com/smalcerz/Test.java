package com.smalcerz;

public class Test {
	public static void main(String[] args) {
		
		int n = 10;
		for(int i=0;i<n + 1;i++) {
			for(int j=0;j<n;j++) {
				if(j == (n-1)) {
					System.out.print(Math.round(Math.random() * 899 + 100));
				}else {
					System.out.print(Math.round(Math.random() * 899 + 100) + " ");
				}
			}
			System.out.println();
		}
	}
	
	
}
