package com.smalcerz;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.smalcerz.productions.Production;





public class FoatClass {
	
	public ArrayList<Production> productions = new ArrayList<>();
	private int whichFoataClass = 0;
	private BufferedWriter writer;
	
	public FoatClass(BufferedWriter writer) {
		this.writer = writer;
	}
	
	public void push(Production production) {
		this.productions.add(production);
	}
	
	public void execute() {
		this.whichFoataClass += 1;
		try {
			writer.write(this.whichFoataClass + " foata class:");
			writer.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" foata class: " + this.whichFoataClass);
		Iterator<Production> iter = productions.iterator();
		
		while(iter.hasNext()) {
			Production p =iter.next();
			try {
				writer.write(p.getClass().getSimpleName() + " ");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			p.start();
		}
		
		
		iter = productions.iterator();
        while (iter.hasNext()) {
            try {
                Production p = iter.next();
                p.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(FoatClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println();
        try {
			writer.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		productions.clear();
	}
}
