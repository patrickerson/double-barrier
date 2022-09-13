package Worker;

import FileManipulator.FileManipulator;
import config.Config;

public class FileManipulatorWorkerSorted extends FileManipulator {

    public FileManipulatorWorkerSorted(){
        setDirectory("sorted");
    }

    public void setFilename(){
        super.setFilename(String.valueOf(Config.fileGenId[0]));
        addFileToList();
    }
    private void addFileToList(){
        Config.filenames.add(filename);
        Config.fileGenId[0]++;
    }

    public void writeFile(int[] numbers) {
        super.writeFile(filename, numbers);
    }
}
