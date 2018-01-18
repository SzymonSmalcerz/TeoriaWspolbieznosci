package com.smalcerz.philosophers1;

public class Philosopher extends Thread{
	
	private int id;
	private Spoon rightSpoon;
	private Spoon leftSpoon;
	private int howManyTimesHeAte = 0;
	
	public Philosopher(int id, Spoon leftSpoon, Spoon rightSpoon) {
		this.id = id;
		this.rightSpoon = rightSpoon;
		this.leftSpoon = leftSpoon;
	}
	
	public void run() {
		
		while(!Timer.getInstance().hasEnded()) {
			try {
				//System.out.println("Philosopher " + this.id + " is thinking. ");
				sleep(RandomNumber.getRandomInt(200) + 200);
				boolean takenLeftSpoon = this.leftSpoon.take();
				if(takenLeftSpoon) {
//					System.out.println("Philosopher " + this.id + " took " + this.leftSpoon.getId() + " spoon");
					boolean takenRightSpoon = this.rightSpoon.take();
					if(takenRightSpoon) {
//						System.out.println("Philosopher " + this.id + " took " + this.rightSpoon.getId() + " spoon");
						howManyTimesHeAte+=1;
						//System.out.println("Philosopher " + this.id + " is eating " + this.howManyTimesHeAte + " time");
						 
						sleep(RandomNumber.getRandomInt(150) + 25);
						this.leftSpoon.putDown();
						this.rightSpoon.putDown();
					}else {
//						System.out.println("Philosopher " + this.id + " putted down " + this.leftSpoon.getId() + " spoon");
						
						this.leftSpoon.putDown();
					}
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
