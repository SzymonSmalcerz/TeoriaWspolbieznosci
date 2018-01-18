package com.smalcerz.productions;

import com.smalcerz.vertex.Vertex;

public class P5  extends Production {
	
	private Vertex leftNode;
	private Vertex rightNode;
	@SuppressWarnings("unused")
	private int whichFloataClass;
	
	
	public P5(Vertex leftNode, Vertex rightNode, int whichFloataClass) {
		this.leftNode = leftNode;
		this.rightNode = rightNode;
		this.whichFloataClass = whichFloataClass;
	}
	
	@Override
	public void run()  {
		
		new TempThread(leftNode, rightNode) {
			public void run() {
				this.node.lock();
				
				if(this.node.getRight() != null && this.node.getRight().getHeight() != this.node.getHeight()) {
					while(this.node.getRight().getHeight() != this.node.getHeight()) {
						//wait
					}
				}else {
					this.node.setRight(this.addNode);
				}
				
				
				
				this.node.unLock();
			}
		}.start();
		
		new TempThread(rightNode, leftNode) {
			public void run() {
				this.node.lock();
				if(this.node.getLeft() != null && this.node.getLeft().getHeight() != this.node.getHeight()) {
					while(this.node.getRight().getHeight() != this.node.getHeight()) {
						//wait
					}
				}else {
					this.node.setLeft(this.addNode);
				}
				this.node.unLock();
			}
		}.start();
		
		
	}
	
	private class TempThread extends Thread{
		Vertex node;
		Vertex addNode;
		
		public TempThread(Vertex node, Vertex addNode) {
			this.node = node;
			this.addNode = addNode;
		}
	}
}