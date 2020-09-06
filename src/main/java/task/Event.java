package task;

public class Event extends Task {
    public Event(String description) {
        super(description);
    }

    public String getTypeOfTask() {
        return "E";
    }

    public String getFormattedDescription() {
        if (description.contains("/ at")) {
            String[] slicedDescription = description.split("/ at", 2);
            String what = slicedDescription[0];
            String when = slicedDescription[1].trim();
            String[] slicedWhen = when.split(" ", 2);
            when = slicedWhen[0] + ": " + slicedWhen[1];
            return what + "(" + when + ")";
        }
        return this.description;
    }
}
