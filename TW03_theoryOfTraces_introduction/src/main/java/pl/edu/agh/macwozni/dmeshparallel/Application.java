package pl.edu.agh.macwozni.dmeshparallel;

import pl.edu.agh.macwozni.dmeshparallel.parallelism.ConcurentBlockRunner;
import pl.edu.agh.macwozni.dmeshparallel.parallelism.SerialBlockRunner;

class Application {

    public static void main(String args[]) {

        Executor3 e = new Executor3(new ConcurentBlockRunner());
        e.start();
    }
}
