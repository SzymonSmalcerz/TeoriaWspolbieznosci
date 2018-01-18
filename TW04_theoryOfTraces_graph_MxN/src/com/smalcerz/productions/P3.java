package com.smalcerz.productions;

import com.smalcerz.vertex.Vertex;

public class P3  extends Production {
	
	private Vertex node;
	private int whichFloataClass;
	
	public P3(Vertex node, int whichFloataClass) {
		this.node = node;
		this.whichFloataClass = whichFloataClass;
	}
	
	@Override
	public void run()  {
		
		this.node.lock();
		
		if(this.node.getUp() != null) {
			throw new Error("Something wrond with P1.run()");
		}
		this.node.setUp(new Vertex(null, null, null, this.node,this.whichFloataClass));
		
		this.node.unLock();
		
	}

}