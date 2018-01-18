package com.smalcerz.productions;

import com.smalcerz.vertex.Vertex;

public class P6  extends Production {
	
	private Vertex upNode;
	private Vertex downNode;
	private int whichFloataClass;
	
	public P6(Vertex upNode, Vertex downNode, int whichFloataClass) {
		this.upNode = upNode;
		this.downNode = downNode;
		this.whichFloataClass = whichFloataClass;
	}
	
	@Override
	public void run()  {
		
		new TempThread(upNode, downNode) {
			public void run() {
				this.node.lock();
				
				if(this.node.getDown() != null) {
					throw new Error("Something wrond with P6a.run()" + whichFloataClass);
				}
				this.node.setDown(this.addNode);
				
				this.node.unLock();
			}
		}.start();
		
		new TempThread(downNode, upNode) {
			public void run() {
				this.node.lock();
				
				if(this.node.getUp() != null) {
					throw new Error("Something wrond with P6b.run()" + whichFloataClass);
				}
				this.node.setUp(this.addNode);
				
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