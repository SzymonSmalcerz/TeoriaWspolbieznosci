package com.smalcerz.philosophers3;

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
				
				
					if(this.lowerIndexSpoon.getOwnerId() != this.id) {
						this.lowerIndexSpoon.take();
						this.lowerIndexSpoon.setOwnerId(this.id);
					}

					if(this.higherIndexSpoon.getOwnerId() != this.id) {
						this.higherIndexSpoon.take();
						this.higherIndexSpoon.setOwnerId(this.id);
					}
				
					if(this.lowerIndexSpoon.neighbourWantASpoon()) {
						this.lowerIndexSpoon.putDown();
					}
					
					if(this.higherIndexSpoon.neighbourWantASpoon()) {
						this.higherIndexSpoon.putDown();
					}
				
				if(lowerIndexSpoon.getOwnerId() == this.id && this.higherIndexSpoon.getOwnerId() == this.id) {
					howManyTimesHeAte+=1;
					//System.out.println("Philosopher " + this.id + " is eating " + this.howManyTimesHeAte + " time");
					
					this.lowerIndexSpoon.getDirty();
					this.higherIndexSpoon.getDirty();
					
					sleep(RandomNumber.getRandomInt(150) + 25);
					if(this.lowerIndexSpoon.neighbourWantASpoon()) {
						this.lowerIndexSpoon.cleanSpoon();
					}
					if(this.higherIndexSpoon.neighbourWantASpoon()) {
						this.higherIndexSpoon.cleanSpoon();
					}
					this.lowerIndexSpoon.putDown();
					this.higherIndexSpoon.putDown();
				}
				
				

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
