package Combinator1;

import config.Config;

import java.util.concurrent.Semaphore;

public class Combinator extends Thread {

    CombinatorController controller;
    Semaphore mutex;
    Semaphore signal;

    public Combinator(){

        controller = new CombinatorController();
        signal = Config.signal;
        mutex = Config.mutex;
    }

    @Override
    public void run() {
        int count = 0;
        while (count<Config.n){
            count++;
            try {
                signal.acquire();
                mutex.acquire();
                controller.setOrders();
                mutex.release();

                controller.mergeFile();

                System.out.print("\rprocessing: " + count + "/" + Config.n);




            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
