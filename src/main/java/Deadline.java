public class Deadline extends Task {
    public Deadline(String description) {
        super(description);
    }

    public String getTypeOfTask() {
        return "D";
    }
}
