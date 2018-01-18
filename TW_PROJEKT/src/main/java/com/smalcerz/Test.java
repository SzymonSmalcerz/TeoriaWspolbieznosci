package com.smalcerz;

public class Test {
	public static void main(String[] args) {
		
		
		
		//printRounded(-24000.123, 23123.1233, 10);
		printFloats(-24000.123, 23123.1233, 10);
	}
	
	
	public static void printRounded(double min, double max, int n) {
		System.out.println(n);
		for(int i=0;i<n + 1;i++) {
			for(int j=0;j<n;j++) {
				if(j == (n-1)) {
					System.out.print(Math.round(Math.random() * (max-min) + min));
				}else {
					System.out.print(Math.round(Math.random() * (max-min) + min) + " ");
				}
			}
			
			if(i!= n) {
				System.out.println();
			}
		}
	}
	
	public static void printFloats(double min, double max, int n) {
		System.out.println(n);
		for(int i=0;i<n + 1;i++) {
			for(int j=0;j<n;j++) {
				if(j == (n-1)) {
					System.out.print(Math.random() * (max-min) + min);
				}else {
					System.out.print(Math.random() * (max-min) + min + " ");
				}
			}
			
			if(i!= n) {
				System.out.println();
			}
		}
	}
	
}
