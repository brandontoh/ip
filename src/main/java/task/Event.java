package task;

import exception.DukeException;
import userRelated.InputParser;

public class Event extends Task {
    private static final String DELIMITER = "/";

    public Event(String description) throws DukeException {
        super(description);
        this.description = InputParser.getFormattedDescription(description, DELIMITER);;
    }

    public String getTypeOfTask() {
        return "E";
    }
}
