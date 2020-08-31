public class TaskList {
    protected Task[] list;
    protected int taskCount;

    public TaskList() {
        list = new Task[100];
        taskCount = 0;
    }

    public Task[] getList() {
        return list;
    }

    public int getTaskCount() {
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
}
