package com.smalcerz.TW05vol2.zadanieDomowe.main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;

import org.math.plot.Plot3DPanel;

import com.smalcerz.TW05vol2.zadanieDomowe.ludziki.Person;
import com.smalcerz.TW05vol2.zadanieDomowe.ludziki.Reader;
import com.smalcerz.TW05vol2.zadanieDomowe.ludziki.Writer;

public class Main {
	
	public static void main(String[] args) {
		
		int n = 10;
		double[] x_numberOfWriters = new double[n];
		double[] y_numberOfReaders = new double[n];
		double[] z_time = new double[n];
		
		Main.libraryFunction(n, x_numberOfWriters, y_numberOfReaders, z_time);
		Main.draw(x_numberOfWriters, y_numberOfReaders, z_time, "usual number of readers and writers");

		Main.libraryFunctionMoreReaders(n, x_numberOfWriters, y_numberOfReaders, z_time);
		Main.draw(x_numberOfWriters, y_numberOfReaders, z_time, "3x more readers than usual");
		
		Main.libraryFunctionMoreWriters(n, x_numberOfWriters, y_numberOfReaders, z_time);
		Main.draw(x_numberOfWriters, y_numberOfReaders, z_time, "2x more writers than usual");
	        		 
	        
		
		
		
	}
	
	
	public static void draw(double[] x_numberOfWriters, double[] y_numberOfReaders, double[] z_time, String nameOfPlot) {
		// create your PlotPanel (you can use it as a JPanel)
        
        Plot3DPanel plot3d = new Plot3DPanel();
        
        
        		 
        		  // add a line plot to the PlotPanel
        plot3d.addScatterPlot(nameOfPlot,Color.RED, x_numberOfWriters, y_numberOfReaders, z_time);
        plot3d.addLinePlot(nameOfPlot, x_numberOfWriters, y_numberOfReaders, z_time);
        plot3d.addBarPlot(nameOfPlot, Color.PINK, x_numberOfWriters, y_numberOfReaders, z_time);
        //plot3d.addLinePlot("lol", x_numberOfWriters, y_numberOfReaders, z_time);
        		 
        		  // put the PlotPanel in a JFrame, as a JPanel
        JFrame frame = new JFrame(nameOfPlot);
        frame.setContentPane(plot3d);
        frame.setVisible(true);
	}
	

	public static void libraryFunction(int n,double[] x_numberOfWriters, double[] y_numberOfReaders, double[] z_time) {
		
		int numberOfThreads = 10;
		int numbOfWriters = 0;
		int numOfReaders = 0;
		int currentIndex = 0;
		ArrayList<Person> people = new ArrayList<Person>();
		double startTime, endTime;
		
		while(currentIndex+1 <= n) {
			
			startTime = System.currentTimeMillis();
			
			for(int i=0;i<numberOfThreads;i++) {
				if(i%10 == 0) {
					numbOfWriters += 1;
					people.add(new Writer(i));
				}else {
					numOfReaders+=1;
					people.add(new Reader(i));
				}
			}
			//start tasks
					
			
			Iterator<Person> iPeople = people.iterator();
			while(iPeople.hasNext()) {
				iPeople.next().start();
			}
			
			//join threads
			try {
				
				Iterator<Person> iPeople2 = people.iterator();
				while(iPeople2.hasNext()) {
					
					iPeople2.next().join();
					
				}
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			endTime = System.currentTimeMillis();
			
			x_numberOfWriters[currentIndex] = numbOfWriters	;
			y_numberOfReaders[currentIndex] = numOfReaders;
			z_time[currentIndex] = (endTime - startTime)/1000;
			numOfReaders = 0;
			numbOfWriters = 0;
			System.out.println("Task for " + numberOfThreads + " threads has ended, " + (n-1-currentIndex) + " tasks has left");
			numberOfThreads+=10;
			people.clear();
			currentIndex+=1;
			
		}

		System.out.println("library function with up to 300 readers (\"usual number\") and 10 times less writers (also \"usual number\") has finised\n");
		
	}
	
	public static void libraryFunctionMoreWriters(int n,double[] x_numberOfWriters, double[] y_numberOfReaders, double[] z_time) {
		
		int numberOfThreads = 10;
		int numbOfWriters = 0;
		int numOfReaders = 0;
		int currentIndex = 0;
		ArrayList<Person> people = new ArrayList<Person>();
		double startTime, endTime;
		
		while(currentIndex+1 <= n) {
			
			startTime = System.currentTimeMillis();
			
			for(int i=0;i<numberOfThreads;i++) {
				if(i%5 == 0) {
					numbOfWriters += 1;
					people.add(new Writer(i));
				}else {
					numOfReaders+=1;
					people.add(new Reader(i));
				}
			}
			//start tasks
					
			
			Iterator<Person> iPeople = people.iterator();
			while(iPeople.hasNext()) {
				iPeople.next().start();
			}
			
			//join threads
			try {
				
				Iterator<Person> iPeople2 = people.iterator();
				while(iPeople2.hasNext()) {
					
					iPeople2.next().join();
					
				}
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			endTime = System.currentTimeMillis();
			
			x_numberOfWriters[currentIndex] = numbOfWriters	;
			y_numberOfReaders[currentIndex] = numOfReaders;
			z_time[currentIndex] = (endTime - startTime)/1000;
			numOfReaders = 0;
			numbOfWriters = 0;
			System.out.println("Task for " + numberOfThreads + " threads has ended, " + (n-1-currentIndex) + " tasks has left");
			numberOfThreads+=10;
			people.clear();
			currentIndex+=1;
			
		}
		
		System.out.println("Libary function with 2x more writers than usual (readers the same numer as usual) has finised\n");
	}
	
	public static void libraryFunctionMoreAndMoreReadersButTheSameNumOfWriters(int n,double[] x_numberOfWriters, double[] y_numberOfReaders, double[] z_time) {
		
		int numberOfThreads = 30;
		int numbOfWriters = 0;
		int numOfReaders = 0;
		int currentIndex = 0;
		ArrayList<Person> people = new ArrayList<Person>();
		double startTime, endTime;
		
		while(currentIndex+1 <= n) {
			
			startTime = System.currentTimeMillis();
			
			for(int i=0;i<numberOfThreads;i++) {
				if(i%30 == 0) {
					numbOfWriters += 1;
					people.add(new Writer(i));
				}else {
					numOfReaders+=1;
					people.add(new Reader(i));
				}
			}
			//start tasks
					
			
			Iterator<Person> iPeople = people.iterator();
			while(iPeople.hasNext()) {
				iPeople.next().start();
			}
			
			//join threads
			try {
				
				Iterator<Person> iPeople2 = people.iterator();
				while(iPeople2.hasNext()) {
					
					iPeople2.next().join();
					
				}
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			endTime = System.currentTimeMillis();
			
			x_numberOfWriters[currentIndex] = numbOfWriters	;
			y_numberOfReaders[currentIndex] = numOfReaders;
			z_time[currentIndex] = (endTime - startTime)/1000;
			numOfReaders = 0;
			numbOfWriters = 0;
			System.out.println("Task for " + numberOfThreads + " threads has ended, " + (n-1-currentIndex) + " tasks has left");
			numberOfThreads+=30;
			people.clear();
			currentIndex+=1;
			
		}
		
		System.out.println("library function with 3x more than normal readers (writers the same number as usual) has finished\n");
		
	}
	
	
	

	public static void libraryFunctionMoreReaders(int n,double[] x_numberOfWriters, double[] y_numberOfReaders, double[] z_time) {
		
		int numberOfThreads = 30;
		int numbOfWriters = 0;
		int numOfReaders = 0;
		int currentIndex = 0;
		ArrayList<Person> people = new ArrayList<Person>();
		double startTime, endTime;
		
		while(currentIndex+1 <= n) {
			
			startTime = System.currentTimeMillis();
			
			for(int i=0;i<numberOfThreads;i++) {
				if(i%30 == 0) {
					numbOfWriters += 1;
					people.add(new Writer(i));
				}else {
					numOfReaders+=1;
					people.add(new Reader(i));
				}
			}
			//start tasks
					
			
			Iterator<Person> iPeople = people.iterator();
			while(iPeople.hasNext()) {
				iPeople.next().start();
			}
			
			//join threads
			try {
				
				Iterator<Person> iPeople2 = people.iterator();
				while(iPeople2.hasNext()) {
					
					iPeople2.next().join();
					
				}
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			endTime = System.currentTimeMillis();
			
			x_numberOfWriters[currentIndex] = numbOfWriters	;
			y_numberOfReaders[currentIndex] = numOfReaders;
			z_time[currentIndex] = (endTime - startTime)/1000;
			numOfReaders = 0;
			numbOfWriters = 0;
			System.out.println("Task for " + numberOfThreads + " threads has ended, " + (n-1-currentIndex) + " tasks has left");
			numberOfThreads+=30;
			people.clear();
			currentIndex+=1;
			
		}
		
		System.out.println("library function with 3x more than normal readers (writers the same number as usual) has finished\n");
		
	}
	
}
