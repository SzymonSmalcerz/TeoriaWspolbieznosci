package com.smalcerz;


public class BinarySemaphore{
    
    private int resource = 1;

    

    public synchronized void increment(){
        while(isAvailable()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        resource += 1;

        this.notifyAll();
    }

    public synchronized void decrement(){
        while(!isAvailable()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        resource -= 1;

        

        this.notifyAll();
    }

    public synchronized boolean isAvailable(){
        return this.resource == 1 ? true : false;
    }

    public synchronized void report(){
        System.out.println("Resource value: " + resource);
    }
}
