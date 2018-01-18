package com.smalcerz.TW05vol2.vertex;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Vertex {
	
	private Vertex next;
	private Object value;
	private Lock lock;
	@SuppressWarnings("unused")
	private Condition notLocked;
	
	public Vertex(Object value) {
		this(null,value);
	}
	
	public Vertex(Vertex next, Object value) {
		this.next = next;
		this.value = value;
		this.lock = new ReentrantLock();
		this.notLocked = this.lock.newCondition();
	}

	public void lock() {
		this.lock.lock();
	}
	
	public void unlock() {
		this.lock.unlock();
	}
	
	public Vertex getNext() {
		
		return this.next;
	}
	
	public Lock getLock() {
		return this.lock;
	}

	public void setNext(Vertex next) {
		this.next = next;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	public Vertex getLast() {
		Vertex temp = this;
		
		while(temp.getNext()!=null) {
			temp = temp.getNext();
		}
		
		return temp;
	}
	
	
}
