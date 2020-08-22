public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        if (isDone) {
            return "\u2713";
        } else {
            return "\u2718";
        }
    }

    public void markAsCompleted() {
        if (!isDone) {
            System.out.println("Nice! I've marked this task as done:");
            System.out.println("[" + getStatusIcon() + "] " + description);
            this.isDone = true;
        } else {
            System.out.println("What!?!?! I've already marked this task as done:");
            System.out.println("[" + getStatusIcon() + "] " + description);
        }

    }
}
