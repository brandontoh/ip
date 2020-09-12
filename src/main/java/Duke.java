import exception.DukeException;
import task.Command;
import task.Task;
import task.TaskManager;
import text.ErrorMessage;
import text.Print;

import java.util.Scanner;

public class Duke {
    private static Command instruction;
    private static String description;
    private static final TaskManager taskManager = new TaskManager();


    public static void main(String[] args) {

        Print.printWelcomeMessage();

        while (true) {
            String userInput = askForInput();
            try {
                checkTypeOfInstruction(userInput);
            } catch (DukeException e) {
                ErrorMessage.checkTypeOutOfBoundsException();
                continue;
            }
            try {
                splitInput(userInput);
            } catch (DukeException e) {
                ErrorMessage.splitInputOutOfBoundsException();
                continue;
            }

            if (instruction.isCommand()) {
                executeCommand();
            } else if (instruction.isTask()) {
                Task task = taskManager.createTask(instruction, description);
                taskManager.addToList(task);
            }

            if (instruction == Command.LIST || instruction == Command.DONE) {
                continue;
            }
            Print.printSingleTask(taskManager, TaskManager.getTaskCount()-1);
            Print.printNoOfTasks(taskManager);
        }
    }


    private static String askForInput() {
        System.out.println("____________________________________________________________");
        System.out.println("Please enter a task:");

        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        return userInput;
    }

    public static void checkTypeOfInstruction(String input) throws DukeException {
        String[] slicedInput = input.split(" ");

        switch(slicedInput[0]) {
        case "list":
            instruction = Command.LIST;
            break;
        case "bye":
            instruction = Command.BYE;
            break;
        case "done":
            instruction = Command.DONE;
            break;
        case "todo":
            instruction = Command.TODO;
            break;
        case "deadline":
            instruction = Command.DEADLINE;
            break;
        case "event":
            instruction = Command.EVENT;
            break;
        default:
            throw new DukeException();
        }
    }

    public static void splitInput(String input) throws DukeException {
        String[] slicedInput = input.split(" ", 2);

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
    }

    public static void executeCommand() {
        switch (instruction) {
        case BYE:
            Print.printExitMessage();
            break;
        case LIST:
            Print.printList(taskManager);
            break;
        case DONE:
            try {
                taskManager.markAsCompleted(Integer.parseInt(description) - 1);
            } catch (NullPointerException e) {
                ErrorMessage.executeCommandNullException(description);
            } catch (NumberFormatException e) {
                ErrorMessage.executeCommandNumberFormatException(description);
            }
            break;
        default:
            ErrorMessage.unexpectedError();
            System.exit(1);
        }
    }
}