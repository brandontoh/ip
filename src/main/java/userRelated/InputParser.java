package userRelated;

import exception.DukeException;
import task.Instruction;

public class InputParser {
    private static Instruction instruction;

    public static String getFormattedDescription(String description, String delimiter) {
        String[] slicedDescription = description.split(delimiter);
        String conciseDescription = slicedDescription[0];
        String[] prepositionCombinedWithDate = slicedDescription[1].trim().split(" ", 2);
        String preposition = prepositionCombinedWithDate[0];
        String date = prepositionCombinedWithDate[1];
        return conciseDescription + " (" + preposition + date + ")";
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
