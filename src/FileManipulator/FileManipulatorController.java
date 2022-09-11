package FileManipulator;



import config.Config;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class FileManipulatorController {

    static final String directory = "files/";
    String filename;
    public FileManipulatorController(){
        this.filename = directory + Config.fileGenId[0];
        Config.fileGenId[0]++;
    }

    void generateFile() {
        FileWriter file = null;
        Random random = new Random();
        try {
            file = new FileWriter(filename);
            for (int i = 0; i < Config.vectorLen; i++) {
                file.write(random.nextInt(Config.maxRandom));
            }
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int[] readFile(){
        int[] numbers = new int[Config.vectorLen];
        try {
            List<String> file = Files.readAllLines(Paths.get(filename));
            for (int i = 0; i < Config.vectorLen; i++) {
                numbers[i] = Integer.parseInt(file.get(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return numbers;
    }
}
