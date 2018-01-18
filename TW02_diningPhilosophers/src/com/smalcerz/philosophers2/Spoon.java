package com.smalcerz.philosophers2;

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
		notify();
	}
	
	public synchronized void take() {
		
		while(taken) {
			try {
				wait();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.taken = true;
	}
	
	public synchronized boolean iAvaliable() {
		return !this.taken;
	}
}