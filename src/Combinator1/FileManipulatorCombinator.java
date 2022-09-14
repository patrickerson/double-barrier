package Combinator1;

import FileManipulator.FileManipulator;
import config.Config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileManipulatorCombinator extends FileManipulator {


    int fileGenId;

    FileManipulatorCombinator(){
        setDirectory("merges");
    }

    public void setFileGenId(int fileGenId) {
        this.fileGenId = fileGenId;
    }

    public void setFilename() {
        StringBuilder mergeName = new StringBuilder();
        for (int i = 4; i > 0; i--) {
            Config.mergedFilenames.remove(Config.mergedFilenames.size()-1);
            mergeName.append(fileGenId - i);
        }

        setFilename(mergeName.toString());

    }

    public int[][] getFiles(){
        int[][] matrixNumbers = new int[4][Config.vectorLen];

        for (int i = 0; i < 4; i++) {
            String t = Config.mergedFilenames.get(i);

            matrixNumbers[i] = readFile(t);
        }
        return matrixNumbers;
    }


    public void writeMergeFile(Integer[] mergedNumbers){
        try {
            PrintWriter mergeFile = new PrintWriter(filename);
            for (Integer number:
                 mergedNumbers) {

                mergeFile.println(number.intValue());
            }
            mergeFile.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
