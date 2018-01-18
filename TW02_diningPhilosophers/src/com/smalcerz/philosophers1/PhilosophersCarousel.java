package com.smalcerz.philosophers1;

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
