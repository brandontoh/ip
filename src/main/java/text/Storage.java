package text;

import exception.DukeException;
import task.Deadline;
import task.Event;
import task.Task;
import task.ToDo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private static String filePath;
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Saves tasks in taskList to a file
     *
     * @param taskList List of tasks added by user
     * @throws IOException If file cannot be found
     */
    public void saveFile(ArrayList<Task> taskList) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        for (Task t : taskList) {
            fw.write(t.getTypeOfTask() + " | " + t.getStatusIcon() + " | " + t.getDescription() + System.lineSeparator());
        }
        fw.close();
    }

    /**
     * Loads the tasks from a file to taskList
     *
     * @return List of tasks loaded from the file
     * @throws IOException If file cannot be found
     * @throws DukeException If scanner is unable to scan the file provided
     */
    public ArrayList<Task> loadSavedFile() throws IOException, DukeException {
        ArrayList<Task> taskList = new ArrayList<Task>();
        File f = new File(filePath);
        if (!f.exists()) {
            throw new DukeException();
        }
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String[] inputFromFile = s.nextLine().split(" \\| ");
            String taskType = inputFromFile[0];
            String completionStatus = inputFromFile[1];
            String description = inputFromFile[2];
            Task taskToBeAdded;
            switch(taskType) {
            case "T":
                taskToBeAdded = new ToDo(description);
                break;
            case "D":
                taskToBeAdded = new Deadline(description);
                break;
            case "E":
                taskToBeAdded = new Event(description);
                break;
            default:
                taskToBeAdded = new Task(description);
            }
            if (completionStatus.equals("\u2713")) {
                taskToBeAdded.setDone(true);
            }
            taskList.add(taskToBeAdded);
        }
        return taskList;
    }

    public static String getFilePath() {
        return filePath;
    }
}
