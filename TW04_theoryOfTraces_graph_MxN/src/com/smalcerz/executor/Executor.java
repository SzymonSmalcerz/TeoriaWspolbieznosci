package com.smalcerz.executor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import com.smalcerz.FoatClass;
import com.smalcerz.productions.P1;
import com.smalcerz.productions.P2;
import com.smalcerz.productions.P3;
import com.smalcerz.productions.P4;
import com.smalcerz.productions.P5;
import com.smalcerz.vertex.Vertex;
import com.smalcerz.vertex.VertexDrawer;

public class Executor {
	
	private int n;//maxWidth
	private int m;//maxHeight
	private int currentWidth = 0;
	private int numberOfFloatClasses;
	private FoatClass f;
	BufferedWriter writer;
	
	@SuppressWarnings("deprecation")
	public Executor(int n, int m) {
		this.n = n;
		this.m = m;
		this.numberOfFloatClasses = (int) (Math.floor(n/2) + Math.floor(m/2) + 1);
		
		try {
			//only temporary for diffrent file names
			Date date = new Date();
			
			String dateString = Integer.toString(date.getYear())  + "." + Integer.toString(date.getMonth()) 
			+ "." + Integer.toString(date.getDay()) + "." +
			Integer.toString(date.getHours()) + "." + date.getMinutes() + "." + date.getSeconds();
			
			File file = new File("/home/szymcio/eclipse-workspace/TW04vol2/src/com/smalcerz/" + dateString +".txt");
			this.writer = new BufferedWriter(new FileWriter(file));
			writer.write("GRAF : " + this.n + "x" + this.m);
			writer.newLine();
//			this.writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("results.txt"), "utf-8"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.f = new FoatClass(writer);
		this.execute();
	}
	
	
	
	private void execute(){
		System.out.println("EXECUTE \n\n");
		//adding root Vertexes
		Vertex p0 = new Vertex(null, null, null, null, 0);
		this.currentWidth = 1;//rootVertexes.size() 
		
		@SuppressWarnings("unused")
		int numOdProductionsAccomplished = 0;
		
		Vertex currentNode;
		for(int i=0;i<this.numberOfFloatClasses -1 ;i++) {
			numOdProductionsAccomplished+=1;
			Vertex firstElement = p0.getMaxAtLeftElement();
			@SuppressWarnings("unused")
			Vertex lastElement = p0.getMaxAtRightElement();
			currentNode = firstElement;
			do {
				//vertically adding new productions
				if(currentNode.getHeight() < this.m) {
					f.push(new P3(currentNode.getMaxAtTopElement(),numOdProductionsAccomplished));
				}
				if(currentNode.getHeight() + 1 < this.m) {
					f.push(new P4(currentNode.getMaxAtDownElement(),numOdProductionsAccomplished));
				}
				
				currentNode = currentNode.getRight();
			}while(currentNode != null);
			
			
			
			//horizontally adding new productions
			if(this.currentWidth  < n) {
				this.currentWidth+=1;
				f.push(new P2(p0.getMaxAtLeftElement(),numOdProductionsAccomplished));
			}
			if(this.currentWidth < n) {
				this.currentWidth+=1;
				f.push(new P1(p0.getMaxAtRightElement(),numOdProductionsAccomplished));
			}
			f.execute();
		}
		//P5 na koncu
		Vertex left = p0.getMaxAtLeftElement();
		Vertex right = p0.getMaxAtLeftElement().getRight();
		Vertex lastElement = p0.getMaxAtRightElement();
		
		while(left!=lastElement && right!=null) {
			
			Vertex leftTemp = left.getMaxAtTopElement();
			Vertex rightTemp = right.getMaxAtTopElement();
			
			
			while(leftTemp!=null ) {
				
				f.push(new P5(leftTemp, rightTemp, numOdProductionsAccomplished));
				
				leftTemp = leftTemp.getDown();
				rightTemp = rightTemp.getDown();
			}
			
			
			left = left.getRight();
			right = right.getRight();
			
		}
		
		f.execute();
		
		
		
		
		VertexDrawer.draw(p0,writer);
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("END OF EXECUTION\n\n");
	}
}
