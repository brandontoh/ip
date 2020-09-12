package task;

import exception.DukeException;

public class Event extends Task {
    private static final String DELIMITER = "/ at";

    public Event(String description) {
        super(description);
    }

    public String getTypeOfTask() {
        return "E";
    }

    public String getFormattedDescription() {
        String[] slicedDescription = description.split(DELIMITER);
        try {
            String what = slicedDescription[0];
            String when = slicedDescription[1].trim();
            when = "at: " + when;
            return what + "(" + when + ")";
        } catch (IndexOutOfBoundsException e) {
            //System.out.println("Please include \"/ at\"");
            return "INVALID";
        }
    }
}
