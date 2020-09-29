import exception.DukeException;
import task.Instruction;
import task.Task;
import task.TaskManager;
import text.ErrorMessage;
import text.MessagePrinter;
import text.Storage;
import userRelated.InputParser;
import userRelated.Ui;

import java.io.IOException;

public class Duke {
    private static Instruction instruction;
    private static String description;
    private TaskManager taskManager;
    private Storage storage;
    private Ui ui;

    public Duke(String filePath) throws IOException {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            taskManager = new TaskManager(storage.loadSavedFile());
        } catch (DukeException e) {
            ui.showLoadingError();
            taskManager = new TaskManager();
        }
    }

    /**
     * Asks for user input, parse the input, executes the commands then finally saves the tasks into a file
     *
     * @throws IOException If the path to save the file cannot be found
     */
    public void run() throws IOException {
        while (true) {
            String userInput = ui.askForInput();

            try {
                instruction = InputParser.setInstructionEnumType(userInput);
            } catch (DukeException e) {
                ErrorMessage.checkTypeOutOfBoundsException();
                continue;
            }

            try {
                description = InputParser.splitInput(userInput, instruction);
            } catch (DukeException e) {
                ErrorMessage.splitInputOutOfBoundsException();
                continue;
            }

            if (instruction.isCommand()) {
                taskManager.executeCommand(description);
            } else if (instruction.isTask()) {
                Task task = TaskManager.createTask(instruction, description);
                taskManager.addToList(task);
            }

            storage.saveFile(taskManager.getTaskList());

            if (instruction == Instruction.LIST || instruction == Instruction.DONE || instruction == Instruction.DELETE
                    || instruction == Instruction.FIND) {
                continue;
            }

            MessagePrinter.printSingleTask(taskManager, TaskManager.getTaskCount() - 1);
            MessagePrinter.printNoOfTasks(taskManager);
        }
    }

    public static void main(String[] args) throws IOException {
        new Duke("data/duke.txt").run();
    }
}