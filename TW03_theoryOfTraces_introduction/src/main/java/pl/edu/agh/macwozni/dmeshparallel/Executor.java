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

public class Executor extends Thread {
    
    private final BlockRunner runner;
    
    public Executor(BlockRunner _runner){
        this.runner = _runner;
    }

    @Override
    public void run() {

    	PDrawer drawer = new GraphDrawer();
        Vertex s = new Vertex(null, null, "S");
        //first floata class
        P1 p1 = new P1(s, drawer);
        this.runner.addThread(p1);
        this.runner.startAll();

        //second floata class
        P3 p3 = new P3(p1.getObj().getRight(), drawer);
        P5 p5A = new P5(p1.getObj(), drawer);
        this.runner.addThread(p3);
        this.runner.addThread(p5A);
        this.runner.startAll();

        //third floata class

        P4 p4 = new P4(p3.getObj(), drawer);
        P3 p31 = new P3(p3.getObj().getRight(), drawer);
        this.runner.addThread(p4);
        this.runner.addThread(p31);
        this.runner.startAll();

        //fourth floata class

        P5 p5B = new P5(p31.getObj().getRight(), drawer);
        P6 p64 = new P6(p31.getObj(), drawer);
        P4 p41 = new P4(p4.getObj(), drawer);
        P6 p6 = new P6(p4.getObj().getRight(), drawer);
        this.runner.addThread(p5B);
        this.runner.addThread(p64);
        this.runner.addThread(p41);
        this.runner.addThread(p6);
        this.runner.startAll();

        //fifth floata class
        P4 p42 = new P4(p41.getObj(), drawer);
        P6 p63 = new P6(p41.getObj().getRight(), drawer);
        this.runner.addThread(p42);
        this.runner.addThread(p63);
        this.runner.startAll();

        //sixth floata class
        P6 p61 = new P6(p42.getObj(), drawer);
        P6 p62 = new P6(p42.getObj().getRight(), drawer);
        this.runner.addThread(p61);
        this.runner.addThread(p62);
        this.runner.startAll();

        System.out.println("done");
        drawer.draw(p62.getObj());

    }
}
