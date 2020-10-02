package text;

import exception.DukeException;
import task.Task;
import task.TaskManager;

/**
 * Prints out the messages that are used in the project
 */
public class MessagePrinter {

    public static void printWelcomeMessage() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("____________________________________________________________");
        System.out.println(logo);
        System.out.println("Hello! I'm Duke \u263A");
        System.out.println("What can I do for you?");
    }

    public static void printExitMessage() {
        System.out.println("Bye. Hope to see you again soon!");
        System.exit(0);
    }

    public static void printSingleTask(TaskManager list, int index) throws DukeException {
        String typeOfTask = list.getTask(index).getTypeOfTask();
        String statusIcon = list.getTask(index).getStatusIcon();
        String description = list.getTask(index).getDescription();
        System.out.println(index + 1 + ". [" + typeOfTask + "][" + statusIcon + "] " + description);
    }

    public static void printNoOfTasks(TaskManager list) {
        System.out.println("Now you have " + TaskManager.getTaskCount() + " tasks in the list.");
    }

    public static void printList(TaskManager list) throws DukeException {
        System.out.println("Here are the tasks in your list");
        for (int i = 0; i < TaskManager.getTaskCount(); i++) {
            printSingleTask(list, i);
        }
    }

    public static void printRemovedTaskMessage() {
        System.out.println("Noted. I've removed this task: ");
    }

    public static void printInvalidTaskCount() {
        System.out.println("Invalid task number");
    }

    public static void printAddedTaskMessage() {
        System.out.println("Got it. I've added this task:");
    }

    public static void askToEnterTaskMessage() {
        System.out.println("____________________________________________________________");
        System.out.println("Please enter a task:");
    }

    public static void printMarkTaskAsDoneMessage(Task task) throws DukeException {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("[" + task.getTypeOfTask() + "][" + task.getStatusIcon() + "] " + task.getDescription());
    }

    public static void printMatchedTaskMessage() {
        System.out.println("Here are the matching tasks in your list:");
    }
}

