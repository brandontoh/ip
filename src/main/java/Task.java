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

    public String getTypeOfTask() {
        return "NIL";
    }

    public String getFormattedDescription(){
        if (description.contains("/")) {
            String[] slicedDescription = description.split("/", 2);
            String what = slicedDescription[0];
            String when = slicedDescription[1].trim();
            String[] slicedWhen = when.split(" ", 2);
            when = slicedWhen[0] + ": " + slicedWhen[1];
            return what + "(" + when + ")";
        }
        return this.description;
    }

    public void markAsCompleted() {
        if (!isDone) {
            this.isDone = true;
            System.out.println("Nice! I've marked this task as done:");
        } else {
            System.out.println("What!?!?! I've already marked this task as done:");
        }
        System.out.println("[" + getTypeOfTask() + "][" + getStatusIcon() + "] " + getFormattedDescription());
    }
}
