package com.smalcerz.philosophers1;

public class Timer {
	
	private static Timer timer = new Timer();
	private long endTime = 0;
	private Timer() {};
	
	public void initialize(int numOfSec) {
		this.endTime = System.currentTimeMillis() + (numOfSec * 1000);
	}
	
	public boolean hasEnded() {
		return System.currentTimeMillis() > this.endTime;
	}
	public static Timer getInstance() {
		return timer;
	}
}
