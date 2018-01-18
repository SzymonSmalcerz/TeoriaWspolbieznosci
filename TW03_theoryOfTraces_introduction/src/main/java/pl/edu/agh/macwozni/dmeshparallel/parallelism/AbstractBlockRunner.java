package pl.edu.agh.macwozni.dmeshparallel.parallelism;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.edu.agh.macwozni.dmeshparallel.production.IProduction;

public abstract class AbstractBlockRunner implements BlockRunner {

    private final AbstractQueue<IProduction> list = new ConcurrentLinkedQueue<IProduction>();
    private int whichFloatClass = 0;
    //starts all threads
    @Override
    public void startAll() {
        Iterator<IProduction> iter = list.iterator();
        while (iter.hasNext()) {
            IProduction p = iter.next();
            this.runOne(p);
        }
        wakeAll();
        iter = list.iterator();
        while (iter.hasNext()) {
            try {
                IProduction p = iter.next();
                p.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(AbstractBlockRunner.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        list.clear();
        this.whichFloatClass+=1;
        System.out.println("\n\twatki klasy " + this.whichFloatClass + " floaty zakonczyly swoje dzialanie");
        System.out.println("_____________________________________________________________");
    }

    //adds a thread to poll
    @Override
    public void addThread(IProduction _pThread) {
        list.add(_pThread);
    }

    //starts one thread
    abstract void runOne(IProduction _pOne);

    //wakes all threads
    abstract void wakeAll();
}
