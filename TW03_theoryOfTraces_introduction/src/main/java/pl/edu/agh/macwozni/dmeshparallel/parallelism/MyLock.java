package pl.edu.agh.macwozni.dmeshparallel.parallelism;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLock { //just binary semaphore

    private boolean blocked = false;

    public synchronized void lock() {
        blocked = true;
    }

    public synchronized void unlock() {
        blocked = false;
        notifyAll();
    }

    public synchronized void pass() {
        while (blocked) {
            try {
            	System.out.println("waiting!!");
                wait();
                
            } catch (InterruptedException ex) {
                Logger.getLogger(MyLock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
