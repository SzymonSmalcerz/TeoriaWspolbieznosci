package com.smalcerz.TW05vol2.zadanieDomowe.ludziki;

public abstract class Person extends Thread{
	
	private int id;
	
	public Person(int id) {
		this.id = id;
	}
	
	public long getId() {
		return this.id;
	}
	
	public abstract void run();
	
}
