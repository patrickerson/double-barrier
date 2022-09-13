package Worker;


import java.util.Arrays;

public class WorkerController {
    WorkerModel workerModel;
    FileManipulatorWorkerRandom fileRandom;
    FileManipulatorWorkerSorted fileSorted;

    public WorkerController(){
        workerModel = new WorkerModel();
        fileRandom = new FileManipulatorWorkerRandom();
        fileSorted = new FileManipulatorWorkerSorted();
        setRandomNumbers();
    }

    int[] getNumberFromFile(){
        return fileRandom.readFile();
    }

    void setRandomNumbers(){
        fileRandom.generateFile();
        int[] numbers = getNumberFromFile();
        workerModel.setNumbers(numbers);
    }

    void setSortedNumbers(){
        int[] randomNumbers = workerModel.getNumbers();
        Arrays.sort(randomNumbers);
        workerModel.setNumbers(randomNumbers);
        int[] sortedNumbers = workerModel.getNumbers();
        fileSorted.setFilename();
        fileSorted.writeFile(sortedNumbers);
    }
    WorkerModel getModel(){
        return workerModel;
    }


}
