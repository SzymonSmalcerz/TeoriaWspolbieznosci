package com.smalcerz.TW05vol2.zadanieDomowe.helpers;

public class Random {

	
	public static int getRandom(int min, int max) {
		
		if(min>max) {
			return 0;
		}
		
		return (int) (Math.random() * (max - min) + min);
		
	}
}
