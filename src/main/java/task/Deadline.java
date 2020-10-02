package task;

import exception.DukeException;
import userRelated.InputParser;

public class Deadline extends Task {
    private static final String DELIMITER = "/";

    public Deadline(String description) throws DukeException {
        super(description);
        this.description = InputParser.getFormattedDescription(description, DELIMITER);;
    }

    public String getTypeOfTask() {
        return "D";
    }
}
