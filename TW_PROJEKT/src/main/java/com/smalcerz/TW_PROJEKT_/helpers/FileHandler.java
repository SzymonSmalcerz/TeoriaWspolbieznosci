package com.smalcerz.TW_PROJEKT_.helpers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

public class FileHandler {
	
	
	private static FileHandler instance = null;
	
	private BufferedWriter writer;

	@SuppressWarnings("deprecation")
	private FileHandler() {
		BufferedWriter writer;
		try {
			
			
			Date date = new Date();
			
			String dateString = Integer.toString(date.getYear())  + "." + Integer.toString(date.getMonth()) 
			+ "." + Integer.toString(date.getDay()) + "." +
			Integer.toString(date.getHours()) + "." + date.getMinutes() + "." + date.getSeconds();
			
			File file = new File("./results/" + dateString +".txt");
			writer = new BufferedWriter(new FileWriter(file));
			this.writer = writer;
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public BufferedWriter getWriter() {
		
		return this.writer;
		
	}
	
	
	public static synchronized FileHandler getInstance() {
		
		if(instance == null) {
			instance = new FileHandler();
		}
		return instance;
		
	}
}
