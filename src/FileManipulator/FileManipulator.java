package FileManipulator;

import config.Config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public abstract class FileManipulator {

    public String filename;
    public String directory;
    public static String extension = ".txt";


    public void setDirectory(String directory) {
        this.directory = directory + "/";
    }

    public void setFilename(String filename) {
        this.filename = directory + filename + extension;
    }

    public void writeFile(String filename, int[] numbers){
        try {
            PrintWriter write = new PrintWriter(filename);
            for (int number:
                 numbers) {
                write.println(number);
            }
            write.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public int[] readFile(String filename){
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
