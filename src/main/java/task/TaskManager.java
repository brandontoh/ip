package task;

import java.util.ArrayList;
import java.util.Arrays;

public class TaskManager {
    static protected Task[] taskList;
    static protected int taskCount;
    protected Task task;

    public TaskManager() {
        taskList = new Task[100];
        taskCount = 0;
    }

    public Task[] getList() {
        return taskList;
    }

    public static int getTaskCount() {
        return taskCount;
    }

    public Task getTask(int index) {
        return taskList[index];
    }

    public void addToList(Task task) {
        taskList[taskCount] = task;
        taskCount++;
        System.out.println("Got it. I've added this task:");
    }

    public void markAsCompleted(int index) {
        Task task = taskList[index];
        task.markAsCompleted();
    }

    public Task createTask(Command instruction, String description) {
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

    public void deleteFromList(int index) {
        ArrayList<Task> tempList = new ArrayList<Task>(Arrays.asList(taskList));
        if (index <= 0 || index > taskCount) {
            System.out.println("Invalid task number");
        } else {
            tempList.remove(index - 1);
            taskList = tempList.toArray(new Task[100]);
            taskCount--;
        }
    }
}
