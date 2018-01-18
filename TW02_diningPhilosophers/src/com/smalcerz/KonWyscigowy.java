package com.smalcerz;



public class KonWyscigowy extends Thread{
	
    
	private String imie;
	private int ileRazyPodnioslSemafor = 0;
	
	public KonWyscigowy(String imie) {
		this.imie = imie;
	}

	@Override
	public void run() {
	    while(true){
	        
	        
	        try {
	        	Semaphore.getInstance().decrement();
		        System.out.println(imie + " rozpoczyna swoj wyscig");
				Thread.sleep(500);
				ileRazyPodnioslSemafor+=1;
				System.out.println(imie + " konczy swoj wyscig, to byl " + ileRazyPodnioslSemafor + "ty wyscig tego konia");
				Semaphore.getInstance().increment();
				Thread.sleep((long) Math.floor(Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}
}