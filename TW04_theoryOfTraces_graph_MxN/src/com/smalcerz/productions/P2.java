package com.smalcerz.productions;

import com.smalcerz.vertex.Vertex;

public class P2  extends Production {
	
	private Vertex node;
	private int whichFloataClass;
	
	public P2(Vertex node, int whichFloataClass) {
		this.node = node;
		this.whichFloataClass = whichFloataClass;
	}
	
	@Override
	public void run()  {
		
		this.node.lock();
		
		if(this.node.getLeft() != null) {
			throw new Error("Something wrond with P1.run()");
		}
		this.node.setLeft(new Vertex(null, this.node, null, null,this.whichFloataClass));
		
		this.node.unLock();
		
	}

}