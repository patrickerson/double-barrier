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




    FileManipulatorCombinator(){
        setDirectory("merges");
    }

    public void setFilename() {
        StringBuilder mergeName = new StringBuilder();
        for (int i = 4; i > 0; i--) {
            Config.filenames.remove(Config.filenames.size()-1);
            mergeName.append(Config.fileGenId[0] - i);
        }

        setFilename(mergeName.toString());

    }

    public int[][] getFiles(){
        int[][] matrixNumbers = new int[4][Config.vectorLen];

        for (int i = 0; i < 4; i++) {
            System.out.println(Config.filenames.toString());
            String t = Config.filenames.get(i);

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
