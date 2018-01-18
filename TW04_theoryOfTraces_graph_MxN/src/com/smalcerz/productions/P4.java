package com.smalcerz.productions;

import com.smalcerz.vertex.Vertex;

public class P4  extends Production {
	
	private Vertex node;
	private int whichFloataClass;
	
	public P4(Vertex node, int whichFloataClass) {
		this.node = node;
		this.whichFloataClass = whichFloataClass;
	}
	
	@Override
	public void run()  {
		
		this.node.lock();
		
		if(this.node.getDown() != null) {
			throw new Error("Something wrond with P1.run()");
		}
		this.node.setDown(new Vertex(null, null, this.node, null,this.whichFloataClass));
		
		this.node.unLock();
		
	}

}