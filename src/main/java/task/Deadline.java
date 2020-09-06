package task;

public class Deadline extends Task {
    private static final String DELIMINATOR = "/ by";

    public Deadline(String description) {
        super(description);
    }

    public String getTypeOfTask() {
        return "D";
    }

    public String getFormattedDescription() {
        String[] slicedDescription = description.split(DELIMINATOR);
        String what = slicedDescription[0];
        String when = slicedDescription[1].trim();
        String[] slicedWhen = when.split(" ");
        when = slicedWhen[0] + ": " + slicedWhen[1];
        return what + "(" + when + ")";
    }
}
