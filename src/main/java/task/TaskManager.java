package task;

import exception.DukeException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TaskManager {
    static protected Task[] list;
    static protected int taskCount;
    static protected Task task;

    public TaskManager() {
        list = new Task[100];
        taskCount = 0;
    }

    public Task[] getList() {
        return list;
    }

    public static int getTaskCount() {
        return taskCount;
    }

    public Task getTask(int index) {
        return list[index];
    }

    public void addToList(Task task) throws IOException {
        list[taskCount] = task;
        taskCount++;
        System.out.println("Got it. I've added this task:");
    }

    public void markAsCompleted(int index) {
        Task task = list[index];
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

    public static void saveFile() throws IOException {
        FileWriter fw = new FileWriter("src/main/java/data/duke.txt");
        for (int i=0; i<taskCount; i++) {
            fw.write(list[i].getTypeOfTask() + " | " + list[i].getStatusIcon() + " | " + list[i].description +
                    System.lineSeparator());
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
            list[taskCount] = taskToBeAdded;
            taskCount++;
        }
    }
}
