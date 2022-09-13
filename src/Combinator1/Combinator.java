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

        while (true){
            try {
                signal.acquire();
                mutex.acquire();

                controller.mergeFile();
                mutex.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
