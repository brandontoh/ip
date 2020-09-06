public class TaskManager {
    static protected Task[] list;
    static protected int taskCount;
    protected Task task;

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

    public void addToList(Task task) {
        list[taskCount] = task;
        taskCount++;
        System.out.println("Got it. I've added this task:");
    }

    public void markAsCompleted(int index) {
        Task task = list[index];
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
}
