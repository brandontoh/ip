package task;

public class ToDo extends Task {
    public ToDo(String description) {
        super(description);
    }

    public String getTypeOfTask() {
        return "T";
    }
}
