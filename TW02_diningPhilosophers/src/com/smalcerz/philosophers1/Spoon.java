package com.smalcerz.philosophers1;

public class Spoon {

	private boolean taken = false;
	private int id;
	
	public Spoon(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public synchronized void putDown() {
		this.taken = false;
	}
	
	public synchronized boolean take() {
		int counter = 0;//counter of tries
		int waitUntil = RandomNumber.getRandomInt(10) + 5;//how many tries before giving up
		while(taken) {
			try {
				Thread.sleep(RandomNumber.getRandomInt(75) + 25);
				
				counter ++;
				
				if(counter > waitUntil) {
					return false;//if after couple tries couldnt get spoon then quit
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.taken = true;
		return true;
	}
	
	public synchronized boolean iAvaliable() {
		return !this.taken;
	}
}
