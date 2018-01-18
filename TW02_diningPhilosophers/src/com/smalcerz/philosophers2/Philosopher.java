package com.smalcerz.philosophers2;

import com.smalcerz.philosophers1.RandomNumber;
import com.smalcerz.philosophers1.Timer;

public class Philosopher extends Thread{
	
	private int id;
	private Spoon lowerIndexSpoon;
	private Spoon higherIndexSpoon;
	private int howManyTimesHeAte = 0;
	
	public Philosopher(int id, Spoon leftSpoon, Spoon rightSpoon) {
		this.id = id;
		if(leftSpoon.getId() > rightSpoon.getId()) {
			this.higherIndexSpoon = leftSpoon;
			this.lowerIndexSpoon = rightSpoon;
		}else {
			this.higherIndexSpoon = rightSpoon;
			this.lowerIndexSpoon = leftSpoon;
		}
	}
	
	public void run() {
		
		while(!Timer.getInstance().hasEnded()) {
			try {
				//System.out.println("Philosopher " + this.id + " is thinking. ");
				sleep(RandomNumber.getRandomInt(200) + 200);
				this.lowerIndexSpoon.take();
				this.higherIndexSpoon.take();
				
				howManyTimesHeAte+=1;
				//System.out.println("Philosopher " + this.id + " is eating " + this.howManyTimesHeAte + " time");
						 
				sleep(RandomNumber.getRandomInt(150) + 25);
				this.lowerIndexSpoon.putDown();
				this.higherIndexSpoon.putDown();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public long getId() {
		return this.id;
	}
	
	public int getHowManyTimesHeAte() {
		return howManyTimesHeAte;
	}
	
}
