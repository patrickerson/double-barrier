package Worker;

import config.Config;

import java.util.concurrent.Semaphore;

public class Worker extends Thread{
    WorkerController controller;
    Semaphore mutex;
    Semaphore barrierIn;
    Semaphore barrierOut;

    public Worker(){

        controller = new WorkerController();
        mutex = Config.mutex;
        barrierIn = Config.barrierIn;
        barrierOut = Config.barrierOut;
    }



    @Override
    public void run() {
        try {
            mutex.acquire();
            controller.setRandomNumbers();
            Config.counter++;
            if (Config.counter == 4){
                barrierOut.acquire();
                barrierIn.release();
            }

            mutex.release();
            barrierIn.acquire();
            barrierIn.release();
            mutex.acquire();
            controller.setSortedNumbers();
            Config.counter--;
            if(Config.counter==0){
                barrierIn.acquire();
                barrierOut.release();
            }
            mutex.release();
            barrierOut.acquire();
            barrierIn.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
