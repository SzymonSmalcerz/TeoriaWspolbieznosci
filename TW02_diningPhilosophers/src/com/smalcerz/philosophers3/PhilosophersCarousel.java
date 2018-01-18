package com.smalcerz.philosophers3;

import com.smalcerz.philosophers1.Timer;

public class PhilosophersCarousel {

	private Philosopher[] philosophers;
	private Spoon[] spoons;
	
	public PhilosophersCarousel(int numberOfPhilosophers, int numberOfSecondToWorkWith) {
		Timer.getInstance().initialize(numberOfSecondToWorkWith);
		this.spoons = new Spoon[numberOfPhilosophers];
		this.philosophers = new Philosopher[numberOfPhilosophers];
		
		for(int i =0 ;i < numberOfPhilosophers; i++) {
			spoons[i] = new Spoon(i + 1);
		};
		
		for(int i =0 ;i < numberOfPhilosophers; i++) {
//			System.out.println((i+1)%(numberOfPhilosophers));
			philosophers[i] = new Philosopher(i+1, spoons[i], spoons[(i+1)%(numberOfPhilosophers)]);
		};
	}
	
	public void init() {
		for(int i =0;i<philosophers.length;i++) {
			philosophers[i].start();
		}
	}
	
	public Philosopher[] getPhilosophers() {
		return philosophers;
	}
}
