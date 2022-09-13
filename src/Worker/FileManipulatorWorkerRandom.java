package Worker;



import FileManipulator.FileManipulator;
import config.Config;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class FileManipulatorWorkerRandom extends FileManipulator {




    FileManipulatorWorkerRandom(){
        setDirectory("random");
    }


    int[] readFile(){
        return super.readFile(filename);
    }
    public void generateFile() {
        filename = directory + Config.fileGenIdRando[0] + extension;
        Random random = new Random();
        int[] randomNumbers = new int[Config.vectorLen];
        // It's possible remove this for and make the writer directly in file, but we will lose readily
        for (int i = 0; i < Config.vectorLen; i++) {
            randomNumbers[i] = random.nextInt(Config.maxRandom);
        }
        writeFile(filename, randomNumbers);
        Config.fileGenIdRando[0]++;
    }


}
