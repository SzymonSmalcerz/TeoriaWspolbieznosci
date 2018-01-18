package com.smalcerz;



public class KonWyscigowyL extends Thread{
	
    
	private String imie;
	private int ileRazyPodnioslSemafor = 0;
	private SemaphoreL semaphoreL;
	
	public KonWyscigowyL(String imie,SemaphoreL semaphoreL) {
		this.semaphoreL = semaphoreL;
		this.imie = imie;
	}

	@Override
	public void run() {
	    while(true){
	        
	        
	        try {
	        	semaphoreL.P();
		        System.out.println(imie + " rozpoczyna swoj wyscig");
				Thread.sleep(500);
				ileRazyPodnioslSemafor+=1;
				System.out.println(imie + " konczy swoj wyscig, to byl " + ileRazyPodnioslSemafor + "ty wyscig tego konia");
				semaphoreL.V();
				Thread.sleep((long) Math.floor(Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}
}