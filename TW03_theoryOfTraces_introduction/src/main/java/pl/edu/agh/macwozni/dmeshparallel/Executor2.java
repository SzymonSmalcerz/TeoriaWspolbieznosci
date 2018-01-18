package pl.edu.agh.macwozni.dmeshparallel;

import pl.edu.agh.macwozni.dmeshparallel.myProductions.P2;
import pl.edu.agh.macwozni.dmeshparallel.myProductions.P6;
import pl.edu.agh.macwozni.dmeshparallel.myProductions.P1;
import pl.edu.agh.macwozni.dmeshparallel.myProductions.P5;
import pl.edu.agh.macwozni.dmeshparallel.myProductions.P3;
import pl.edu.agh.macwozni.dmeshparallel.myProductions.P4;
import pl.edu.agh.macwozni.dmeshparallel.mesh.Vertex;
import pl.edu.agh.macwozni.dmeshparallel.mesh.GraphDrawer;
import pl.edu.agh.macwozni.dmeshparallel.parallelism.BlockRunner;
import pl.edu.agh.macwozni.dmeshparallel.production.PDrawer;

public class Executor2 extends Thread {

    private final BlockRunner runner;
    
    public Executor2(BlockRunner _runner){
        this.runner = _runner;
    }

    @Override
    public void run() {

    	PDrawer drawer = new GraphDrawer();
        //axiom // just first vertex "s" as in our notes
        Vertex s = new Vertex(null, null, "S");

        //p1 
        P1 p1 = new P1(s, drawer);
        this.runner.addThread(p1);

        //start threads
        this.runner.startAll();

        //p2,p3
        P2 p2 = new P2(p1.getObj(), drawer);
        P3 p3 = new P3(p1.getObj().getRight(), drawer);
        this.runner.addThread(p2);
        this.runner.addThread(p3);

        //start threads
        this.runner.startAll();

        //P4_1, P5a, P5b, P6_1
        P5 p5a = new P5(p2.getObj(), drawer);
        P4 p4_1 = new P4(p2.getObj().getRight(), drawer);
        P6 p6_1 = new P6(p3.getObj(), drawer);
        P5 p5b = new P5(p3.getObj().getRight(), drawer);
        this.runner.addThread(p5a);
        this.runner.addThread(p4_1);
        this.runner.addThread(p6_1);
        this.runner.addThread(p5b);
        
        //start threads
        this.runner.startAll();
        
        //P4_2, P4_3
        P4 p4_2 = new P4(p4_1.getObj(), drawer);
        P4 p4_3 = new P4(p4_1.getObj().getRight(), drawer);
        this.runner.addThread(p4_2);
        this.runner.addThread(p4_3);

        //start threads
        this.runner.startAll();
        
        //P4_4, P6_2, P6_3, P6_4
        P4 p4_4 = new P4(p4_2.getObj(), drawer);
        P6 p6_2 = new P6(p4_2.getObj().getRight(), drawer);
        P6 p6_3 = new P6(p4_3.getObj(), drawer);
        P6 p6_4 = new P6(p4_3.getObj().getRight(), drawer);
        this.runner.addThread(p4_4);
        this.runner.addThread(p6_2);
        this.runner.addThread(p6_3);
        this.runner.addThread(p6_4);

        //start threads
        this.runner.startAll();
        
        //P4_4, P6_2, P6_3, P6_4
        P6 p6_5 = new P6(p4_4.getObj(), drawer);
        P6 p6_6 = new P6(p4_4.getObj().getRight(), drawer);
        this.runner.addThread(p6_5);
        this.runner.addThread(p6_6);

        //start threads
        this.runner.startAll();

        //done
        System.out.println("done");
        drawer.draw(p1.getObj());

    }
}
