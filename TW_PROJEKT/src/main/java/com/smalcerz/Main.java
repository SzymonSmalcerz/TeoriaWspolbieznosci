package com.smalcerz;

import java.io.IOException;

import com.smalcerz.executor.Executor;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			
			
			@SuppressWarnings("unused")
			Executor ex1 = new Executor();
			
			
		} catch (IOException e) { 
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
