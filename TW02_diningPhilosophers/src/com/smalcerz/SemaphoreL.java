package com.smalcerz;

import java.util.ArrayList;

public class SemaphoreL {

	ArrayList<BinarySemaphore> binarySemaphores = new ArrayList<>();
	public SemaphoreL(int number) throws Exception
	{
		if(number < 0 ) throw new Exception("number of semaphores must be greater than 0");
		if(number > 100 ) throw new Exception("number of semaphores must be smaller or equal 100");
		
		for(int i=0;i<number;i++) {
			this.binarySemaphores.add(new BinarySemaphore());
		}
	}
	
	public synchronized void V() {
		boolean foundAvaliable = false;
		
		
		while(!foundAvaliable) {
			
			for(int i=0;i<binarySemaphores.size();i++) {
				if(!binarySemaphores.get(i).isAvailable()) {
					foundAvaliable = true;
					binarySemaphores.get(i).increment();
				}
			}
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		this.notifyAll();
		
	}
	
	public synchronized void P() {
		
		boolean foundAvaliable = false;
		while(!foundAvaliable){
			
			for(int i=0;i<binarySemaphores.size();i++) {
				if(binarySemaphores.get(i).isAvailable()) {
					foundAvaliable = true;
					binarySemaphores.get(i).decrement();
				}
			}
		
		
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        

        

        this.notifyAll();
	}
	
	
}
