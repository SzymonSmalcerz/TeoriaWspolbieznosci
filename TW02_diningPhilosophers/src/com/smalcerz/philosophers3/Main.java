package com.smalcerz.philosophers3;

public class Main {
	public static void main(String[] args) {
		PhilosophersCarousel pc = new PhilosophersCarousel(5,10);
		pc.init();
		Philosopher[] ph = pc.getPhilosophers();
		
		for(int i = 0 ; i < ph.length ;i ++ ) {
			try {
				ph[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(int i = 0; i< ph.length ; i++) {
			System.out.println("Philosopher " + ph[i].getId() + " ate " + ph[i].getHowManyTimesHeAte() + " times");
		}
		
	}
}