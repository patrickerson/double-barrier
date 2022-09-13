import Combinator1.Combinator;
import Combinator1.CombinatorController;
import Combinator1.CombinatorModel;
import Worker.Worker;
import Worker.WorkerController;
import config.Config;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Main {


    public static void main(String[] args){
        Worker worker1 = new Worker();
        Worker worker2 = new Worker();
        Worker worker3 = new Worker();
        Worker worker4 = new Worker();

        Combinator combinator = new Combinator();

        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

        combinator.start();

        try {
            worker1.join();
            worker2.join();
            worker3.join();
            worker4.join();

            combinator.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


//        System.out.println("file id: " + Config.fileGenId[0]);
//        System.out.println(Config.filenames.toString());
//        CombinatorController combinator = new CombinatorController();
//        combinator.mergeFile();

    }


}
