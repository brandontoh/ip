package task;

import userRelated.InputParser;

public class Event extends Task {
    private static final String DELIMITER = "/";

    public Event(String description) {
        super(description);
    }

    public String getTypeOfTask() {
        return "E";
    }

    public String getFormattedDescription() {
        return InputParser.getFormattedDescription(description, DELIMITER);
    }
}
