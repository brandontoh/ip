package userRelated;

import exception.DukeException;
import task.Instruction;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class InputParser {
    private static Instruction instruction;

    public static String getFormattedDescription(String description, String delimiter) {
        String[] slicedDescription = description.split(delimiter);
        String conciseDescription = slicedDescription[0];
        String[] prepositionCombinedWithDate = slicedDescription[1].trim().split(" ", 2);
        String preposition = prepositionCombinedWithDate[0];
        String unformattedDate = prepositionCombinedWithDate[1];
        Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
        Matcher matcher = pattern.matcher(unformattedDate);
        if (!matcher.find()) {
            return conciseDescription + " (" + preposition + unformattedDate + ")";
        }
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd yyyy");
            LocalDate ld = LocalDate.parse(matcher.group(0));
            String formattedDate = dtf.format(ld);
            System.out.println(formattedDate);
            return conciseDescription + " (" + preposition + formattedDate + ")";
        } catch (DateTimeException d) {
            return conciseDescription + " (" + preposition + "UNKNOWN" + ")";
        }
    }

    public static String splitInput(String input, Instruction instruction) throws DukeException {
        String[] slicedInput = input.split(" ", 2);
        String description;
        if (instruction.isOnePartInstruction()) {
            description = "";
        } else if (instruction.isTwoPartInstruction()) {
            try {
                description = slicedInput[1];
            } catch (IndexOutOfBoundsException e) {
                throw new DukeException();
            }
        } else {
            description = input;
        }
        return description;
    }

    public static Instruction setInstructionEnumType(String input) throws DukeException {
        String[] slicedInput = input.split(" ");

        switch(slicedInput[0]) {
        case "list":
            instruction = Instruction.LIST;
            break;
        case "bye":
            instruction = Instruction.BYE;
            break;
        case "done":
            instruction = Instruction.DONE;
            break;
        case "todo":
            instruction = Instruction.TODO;
            break;
        case "deadline":
            instruction = Instruction.DEADLINE;
            break;
        case "event":
            instruction = Instruction.EVENT;
            break;
        case "delete":
            instruction = Instruction.DELETE;
            break;
        default:
            throw new DukeException();
        }
        return instruction;
    }

    public static Instruction getInstruction() {
        return instruction;
    }
}
