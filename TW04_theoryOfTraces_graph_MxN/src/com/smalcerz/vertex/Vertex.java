package com.smalcerz.vertex;

import com.smalcerz.BinarySemaphore;

public class Vertex {
	private Vertex left;
	private Vertex right;
	private Vertex up;
	private Vertex down;
	private BinarySemaphore lock = new BinarySemaphore();
	private int whichFloataClass;
	
	public Vertex(Vertex left, Vertex right, Vertex up, Vertex down, int whichFloataClass) {
		super();
		this.left = left;
		this.right = right;
		this.up = up;
		this.down = down;
		this.whichFloataClass = whichFloataClass;
	}
	
	public int getLabel() {
		return this.whichFloataClass;
	}
	
	public int getHeight() {
		Vertex temp = this;
		while(temp.getUp()!=null) {
			temp = temp.getUp();
		}
		
		int height = 1;
		
		while(temp.getDown() != null) {
			temp = temp.getDown();
			height+=1;
		}
		
		return height;
		
	}
	
	public int getWidth() {
		Vertex temp = this;
		while(temp.getLeft()!=null) {
			temp = temp.getLeft();
		}
		
		int width = 1;
		
		while(temp.getRight() != null) {
			temp = temp.getRight();
			width+=1;
		}
		
		return width;
		
	}
	
	
	public void lock() {
		this.lock.decrement();
	}
	
	public void unLock() {
		this.lock.increment();
	}
	
	public Vertex getMaxAtTopElement() {
		Vertex temp = this;
		while(temp.getUp() != null) {
			temp = temp.getUp();
		}
		return temp;
	}
	
	public Vertex getMaxAtDownElement() {
		Vertex temp = this;
		while(temp.getDown() != null) {
			temp = temp.getDown();
		}
		return temp;
	}
	
	public Vertex getMaxAtLeftElement() {
		Vertex temp = this;
		while(temp.getLeft() != null) {
			temp = temp.getLeft();
		}
		return temp;
	}
	
	public Vertex getMaxAtRightElement() {
		Vertex temp = this;
		while(temp.getRight() != null) {
			temp = temp.getRight();
		}
		return temp;
	}
	
	public Vertex getLeft() {
		return left;
	}
	public void setLeft(Vertex left) {
		this.left = left;
	}
	public Vertex getRight() {
		return right;
	}
	public void setRight(Vertex right) {
		this.right = right;
	}
	public Vertex getUp() {
		return up;
	}
	public void setUp(Vertex up) {
		this.up = up;
	}
	public Vertex getDown() {
		return down;
	}
	public void setDown(Vertex down) {
		this.down = down;
	}
	
	
}
