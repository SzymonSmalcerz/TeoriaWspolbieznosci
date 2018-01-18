package com.smalcerz.TW05vol2.zadanieDomowe.ludziki;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FifoOfPeople {
	
	private Lock beginningLock = new ReentrantLock();//guardian when we want to put somethin into the fifo
	
	private Lock endLock = new ReentrantLock();//guardian when we want to get something from fifo
	Condition notFull = endLock.newCondition();//when length of fifo >= 0 we cant get anything (just in case, should never happen)
	
	
	//@@@ GUARDIANS @@@@
	
	//they have implemented "run" method although they should never use it (in case it is used, tou will se which guardian used it by calling sysout)
	
		//always first element in fifo
		private Node guardianAtBeggining;
		
		//always the last element in fifo
		private Node guardianAtEnd;
	
	//@@@ END OF GUARDIANS @@@@
		
		
		
	public FifoOfPeople() {
		
		this.guardianAtBeggining = new Node(new Person(-1) {
			
			@Override
			public void run() {
				System.out.println("guardian beginning");
				
			}
		}, null);
		
		this.guardianAtEnd = new Node(new Person(-2) {
			
			@Override
			public void run() {
				System.out.println("guardian end");
				
			}
		}, null);
		
		this.guardianAtEnd.setLeftNode(this.guardianAtBeggining);
		this.guardianAtBeggining.setRightNode(this.guardianAtEnd);
	}
	
	
	public void putElement(Person person) {
		this.beginningLock.lock();
		
		Node newNode = new Node(person, this.guardianAtBeggining);
		newNode.setRightNode(this.guardianAtBeggining.getRightNode());
		this.guardianAtBeggining.setRightNode(newNode);
		
		this.endLock.lock();
		this.notFull.signal();
		this.endLock.unlock();
		
		this.beginningLock.unlock();
	}
	
	public Person getElement() {
		this.endLock.lock();
		
	
		if(this.guardianAtEnd.getLeftNode().equals(this.guardianAtBeggining)) {
			try {
				this.notFull.await();//czekamy az cos wrzucimy do fifo
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Node lastNode = this.guardianAtEnd.getLeftNode();
		
		this.guardianAtEnd.setLeftNode(lastNode.getLeftNode());
		lastNode.setRightNode(this.guardianAtEnd);
		
		
		
		this.endLock.unlock();
		return lastNode.getPerson();
	}
	
	
	
	
}
