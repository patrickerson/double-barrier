package config;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Config {

    public static final int vectorLen = (int) Math.pow(10,6);
    public static final int maxRandom = (int) Math.pow(10,7);
    public static List<String> filenames = new ArrayList<String>();
    public static int[] fileGenId = {0};
    public static int[] fileGenIdRando = {0};

    public static Semaphore barrierIn = new Semaphore(0);
    public static Semaphore barrierOut = new Semaphore(1);
    public static Semaphore mutex = new Semaphore(1);
    public static Semaphore signal = new Semaphore(0);
    public static Integer counter = 0;
}
