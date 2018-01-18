package com.smalcerz.TW05vol2.zadanieDomowe.ludziki;

import com.smalcerz.TW05vol2.zadanieDomowe.library.Library;

public class Writer extends Person {

	public Writer(int id) {
		super(id);
	}

	public void doSomethingInLibrary() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		
		try {
			Library.getInstanceOfLibrary().startWriterTask(this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//after work is done writer goes back to queque
		//Library.getInstanceOfLibrary().getFifo().putElement(this);
		
	}

}
