package task;

import text.ErrorMessage;
import text.MessagePrinter;
import text.Storage;
import userRelated.InputParser;

import java.io.File;
import java.util.ArrayList;
import java.io.IOException;

public class TaskManager {
    private static ArrayList<Task> taskList;

    public TaskManager() throws IOException {
        String filePath = Storage.getFilePath();
        String[] directoryAndFileNames = filePath.split("/");
        String fileName = directoryAndFileNames[directoryAndFileNames.length -1];
        String directoryName = filePath.substring(0, filePath.length() - fileName.length() - 1);
        File d = new File(directoryName);
        d.mkdir();
        File f = new File(fileName);
        f.createNewFile();
        taskList = new ArrayList<Task>();
    }

    public TaskManager(ArrayList<Task> taskList) {
        TaskManager.taskList = taskList;
    }

    public static int getTaskCount() {
        return taskList.size();
    }

    public Task getTask(int index) {
        return taskList.get(index);
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void addToList(Task task) {
        taskList.add(task);
        MessagePrinter.printAddedTaskMessage();
    }

    public void markAsCompleted(int index) {
        Task task = taskList.get(index);
        task.markAsCompleted();
    }

    /**
     * Returns a Task which is upcasted from either Todo, Deadline or Event
     *
     * @param instruction Type of instruction (Todo, Deadline or Event)
     * @param description User description of the task
     * @return task Task created based on instruction type
     */
    public static Task createTask(Instruction instruction, String description) {
        Task task;
        switch (instruction) {
        case TODO:
            task = new ToDo(description);
            break;
        case DEADLINE:
            task = new Deadline(description);
            break;
        case EVENT:
            task = new Event(description);
            break;
        default:
            task = new Task(description);
            break;
        }
        return task;
    }

    /**
     * Deletes a task from taskList
     *
     * @param index Index of the task to be removed based on taskList
     */
    public void deleteFromList(int index) {
        if (index <= 0 || index > getTaskCount()) {
            MessagePrinter.printInvalidTaskCount();
        } else {
            taskList.remove(index - 1);
        }
    }

    /**
     * Executes the action according to type of instruction
     *
     * @param description User description of the action
     */
    public void executeCommand(String description) {
        switch (InputParser.getInstruction()) {
        case BYE:
            MessagePrinter.printExitMessage();
            break;
        case LIST:
            MessagePrinter.printList(this);
            break;
        case DONE:
            try {
                this.markAsCompleted(Integer.parseInt(description) - 1);
            } catch (NullPointerException e) {
                ErrorMessage.executeCommandNullException(description);
            } catch (NumberFormatException e) {
                ErrorMessage.executeCommandNumberFormatException(description);
            }
            break;
        case DELETE:
            MessagePrinter.printRemovedTaskMessage();
            MessagePrinter.printSingleTask(this, Integer.parseInt(description) - 1);
            this.deleteFromList(Integer.parseInt(description));
            MessagePrinter.printNoOfTasks(this);
            break;
        case FIND:
            System.out.println("Here are the matching tasks in your list:");
            for(int i=0; i<taskList.size(); i++) {
                if (taskList.get(i).getFormattedDescription().contains(description)) {
                    MessagePrinter.printSingleTask(this, i);
                }
            }
            break;
        default:
            ErrorMessage.unexpectedError();
            System.exit(1);
        }
    }
}
