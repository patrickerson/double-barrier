package Worker;

import FileManipulator.FileManipulatorController;

import java.util.Arrays;

public class WorkerController {
    WorkerModel workerModel;

    public WorkerController(){
        workerModel = new WorkerModel();
        setNumbers();
    }

    int[] getNumberFromFile(){
        FileManipulatorController fileManipulatorController;
        fileManipulatorController = new FileManipulatorController();
        return fileManipulatorController.readFile();

    }

    void setNumbers(){
        int[] numbers = getNumberFromFile();
        Arrays.sort(numbers);
        workerModel.setNumbers(numbers);
    }
}
