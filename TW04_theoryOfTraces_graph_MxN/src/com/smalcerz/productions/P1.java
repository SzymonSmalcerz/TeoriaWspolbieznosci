package com.smalcerz.productions;

import com.smalcerz.vertex.Vertex;

public class P1  extends Production {
	
	private Vertex node;
	private int whichFloataClass;
	
	public P1(Vertex node, int whichFloataClass) {
		this.node = node;
		this.whichFloataClass = whichFloataClass;
	}
	
	@Override
	public void run()  {
		
		this.node.lock();
		
		if(this.node.getRight() != null) {
			throw new Error("Something wrond with P1.run()");
		}
		this.node.setRight(new Vertex(this.node, null, null, null,this.whichFloataClass));
		
		this.node.unLock();
		
	}

}
