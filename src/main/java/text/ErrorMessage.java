package text;

import task.TaskManager;

/**
 * Prints out the error messages that appeared in the project
 */
public class ErrorMessage {
    public static void unexpectedError() {
        System.out.println("Something unexpected occurred ... Exiting ... ");
    }

    public static void executeCommandNullException(String enteredTaskNum) {
        System.out.println("Invalid task number: " + enteredTaskNum);
        System.out.println("Current total tasks: " + TaskManager.getTaskCount());
    }

    public static void executeCommandNumberFormatException(String description) {
        System.out.println("Invalid task number: " + description +"\nThis is NOT a number");
    }

    public static void checkTypeOutOfBoundsException() {
        System.out.println("\u2639 OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

    public static void splitInputOutOfBoundsException() {
        System.out.println("\u2639 OOPS!!! The description of a todo cannot be empty.");
    }

    public static void uiLoadingError() {
        System.out.println("File cannot be loaded, creating new task list ...");
    }
}
