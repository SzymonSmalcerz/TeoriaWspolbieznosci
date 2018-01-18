package com.smalcerz;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.smalcerz.production.Production;



 

public class FoatClass {
	
	public ArrayList<Production> productions = new ArrayList<Production>();
	private int whichFoataClass = 0;
	private BufferedWriter writer;
	
	public FoatClass(BufferedWriter writer) {
		this.writer = writer;
	}
	 
	public void push(Production production) {
		this.productions.add(production);
	}
	
	public void execute() throws IOException, InterruptedException {
		
		if(this.productions.size() < 1) {
			return;
		}
		
		this.whichFoataClass += 1;
		
		writer.write(this.whichFoataClass + " foata class:");
		writer.newLine();
		
		writer.write("	 | ");
		Iterator<Production> iter = productions.iterator();
		
		while(iter.hasNext()) {
			
			Production p =iter.next();
			
			
			writer.write(p.getClass().getSimpleName() + " | ");
			
			p.start();
			
		}
		
		
		iter = productions.iterator();
        while (iter.hasNext()) {
            
                Production p = iter.next();
                p.join();
        }
        
		writer.newLine();
		productions.clear();
	}
}
