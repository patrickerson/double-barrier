package Worker;

import config.Config;

import java.util.concurrent.Semaphore;

public class Worker extends Thread{
    WorkerController controller;
    Semaphore mutex;
    Semaphore barrierIn;
    Semaphore barrierOut;
    Semaphore signal;

    public Worker(){

        controller = new WorkerController();
        mutex = Config.mutex;
        barrierIn = Config.barrierIn;
        barrierOut = Config.barrierOut;
        signal = Config.signal;
    }



    @Override
    public void run() {
        try {

           while(true){
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
               Config.counter--;

               controller.setSortedNumbers();
               controller.fileSorted.addFileToList();
               if(Config.counter==0){
                   barrierIn.acquire();
                   barrierOut.release();
                   signal.release();
               }



               mutex.release();
               barrierOut.acquire();
               barrierOut.release();
           }


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
