package task;

import java.util.ArrayList;

public class TaskManager {
    static protected ArrayList<Task> taskList;
    protected Task task;

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
        if (index <= 0 || index > getTaskCount()) {
            System.out.println("Invalid task number");
        } else {
            taskList.remove(index - 1);
        }
    }
}
