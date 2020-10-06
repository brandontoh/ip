package task;

import exception.DukeException;
import userRelated.InputParser;

public class Event extends Task {
    private static final String DELIMITER = "/";

    public Event(String description) throws DukeException {
        super(description);
        if (description.contains("(at:") || description.contains("(by:")) {
            this.description = description;
        } else {
            this.description = InputParser.getFormattedDescription(description, DELIMITER);
        }
    }

    public String getTypeOfTask() {
        return "E";
    }
}
