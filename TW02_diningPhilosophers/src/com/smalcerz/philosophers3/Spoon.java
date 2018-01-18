package com.smalcerz.philosophers3;

public class Spoon {
	
	public static enum STAN {
		dirty, clean
	}

	private boolean taken;
	private boolean neighbourWantASpoon;
	private int id;
	private STAN stan;
	private int ownerID;
	
	public Spoon(int id) {
		this.taken = false;
		this.neighbourWantASpoon = false;
		this.id = id;
		this.stan = STAN.dirty;
	}
	
	
	public synchronized void putDown() {
		notify();
		this.taken = false;
	}
	
	
	
	public synchronized void take() {
		
		
		
		
		while(this.taken) {
			this.neighbourWantASpoon = true;
			try {
				wait();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.taken = true;
	}
	
	public synchronized int getId() {
		return this.id;
	}
	
	public synchronized int getOwnerId() {
		return this.ownerID;
	}
	
	public synchronized void setOwnerId(int id) {
		this.ownerID = id;
	}
	
	
	public synchronized STAN getStan() {
		return this.stan;
		
	}
	
	public void cleanSpoon() {
		this.stan = STAN.clean;
	}
	
	public void getDirty() {
		this.stan = STAN.dirty;
	}
	
	public boolean neighbourWantASpoon() {
		return this.neighbourWantASpoon;
	}
	public void setNeighbourWantASpoon() {
		this.neighbourWantASpoon = false;
	}
	
	public synchronized boolean iAvaliable() {
		return !this.taken;
	}
}