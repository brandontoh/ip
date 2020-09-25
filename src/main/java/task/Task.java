package task;

import text.MessagePrinter;

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

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getTypeOfTask() {
        return "NIL";
    }

    public String getFormattedDescription(){
        return this.description;
    }

    public String getDescription() {
        return this.description;
    }

    public void markAsCompleted() {
        this.isDone = true;
        MessagePrinter.printMarkTaskAsDoneMessage(this);
    }
}