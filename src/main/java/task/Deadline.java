package task;

import userRelated.InputParser;

public class Deadline extends Task {
    private static final String DELIMITER = "/";

    public Deadline(String description) {
        super(description);
    }

    public String getTypeOfTask() {
        return "D";
    }

    public String getFormattedDescription() {
        return InputParser.getFormattedDescription(description, DELIMITER);
    }
}
