package task;

public class Deadline extends Task {
    private static final String DELIMITER = "/ by";

    public Deadline(String description) {
        super(description);
    }

    public String getTypeOfTask() {
        return "D";
    }

    public String getFormattedDescription() {
        String[] slicedDescription = description.split(DELIMITER);
        try {
            String what = slicedDescription[0];
            String when = slicedDescription[1].trim();
            when = "by: " + when;
            return what + "(" + when + ")";
        } catch (IndexOutOfBoundsException e) {
            //System.out.println("Please include \"" + DELIMITER + "\"");
            return "INVALID";
        }
    }
}
