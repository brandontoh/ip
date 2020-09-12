package task;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TaskManager {
    static protected ArrayList<Task> taskList;
    static protected Task task;

    public TaskManager() {
        taskList = new ArrayList<Task>();
    }

    public static int getTaskCount() {
        return taskList.size();
    }

    public Task getTask(int index) {
        return taskList.get(index);
    }

    public void addToList(Task task) {
        taskList.add(task);

        System.out.println("Got it. I've added this task:");
    }

    public void markAsCompleted(int index) {
        Task task = taskList.get(index);
        task.markAsCompleted();
    }

    public static Task createTask(Command instruction, String description) {
        switch (instruction) {
        case TODO:
            task = new ToDo(description);
            break;
        case DEADLINE:
            task = new Deadline(description);
            break;
        case EVENT:
            task = new Event(description);
            break;
        default:
            task = new Task(description);
            break;
        }
        return task;
    }

    public void deleteFromList(int index) throws IOException {
        if (index <= 0 || index > getTaskCount()) {
            System.out.println("Invalid task number");
        } else {
            taskList.remove(index - 1);
        }
    }

    public static void saveFile() throws IOException {
        FileWriter fw = new FileWriter("src/main/java/data/duke.txt");
        for (Task t : taskList) {
            fw.write(t.getTypeOfTask() + " | " + t.getStatusIcon() + " | " + t.description + System.lineSeparator());
        }
        fw.close();
    }

    public static void loadSavedFile() throws IOException {
        File f = new File("src/main/java/data/duke.txt");
        f.createNewFile();
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String[] inputFromFile = s.nextLine().split(" \\| ");
            String taskType = inputFromFile[0];
            System.out.println(taskType);
            String completionStatus = inputFromFile[1];
            System.out.println(completionStatus);
            String description = inputFromFile[2];
            System.out.println(description);
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
            taskToBeAdded.isDone = completionStatus.equals("\u2713");
            taskList.add(taskToBeAdded);
        }
    }
}
