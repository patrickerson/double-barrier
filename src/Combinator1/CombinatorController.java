package Combinator1;

import java.util.Arrays;

public class CombinatorController {

    protected CombinatorModel model;
    FileManipulatorCombinator fileManipulator;

    public CombinatorController(){
        model = new CombinatorModel();
        fileManipulator = new FileManipulatorCombinator();
    }

    public void setMatrix(){

        int[][] matrix = fileManipulator.getFiles();
        model.setMatrix(matrix);
    }

    void removeDuplicates(){

        for (int i = 0; i < 4; i++) {
            for (int number :
                    model.getMatrix()[i]) {
                model.addSet(number);
            }
        }
    }

    public void mergeFile(){
        setMatrix();
        fileManipulator.setFilename();
        removeDuplicates();
        Integer[] numbers = model.getMergedArray();
        Arrays.sort(numbers);
        fileManipulator.writeMergeFile(numbers);

    }


}
