import java.util.Scanner;

public class Duke {
    private static String command;
    private static String description;
    private static Task task;
    private static boolean isTask;
    private static boolean isCommand;
    private static final TaskList list = new TaskList();


    public static void main(String[] args) {

        welcomeMessage();

        while (true) {
            String userInput = askForInput();
            checkTypeOfInstruction(userInput);
            splitInput(userInput);

            if (isCommand) {
                executeCommand();
            } else if (isTask) {
                createTask();
                list.addToList(task);
            }

            if (command.equals("list") || command.equals("done")) {
                continue;
            }
            printSingleTask(list.getTaskCount()-1);
            printNoOfTasks();
        }
    }

    public static void welcomeMessage() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("____________________________________________________________");
        System.out.println(logo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }

    private static String askForInput() {
        System.out.println("____________________________________________________________");
        System.out.println("Please enter a task:");

        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        return userInput;
    }

    public static void checkTypeOfInstruction(String input) {
        isCommand = false;
        isTask = false;
        String[] slicedInput = input.split(" ", 2);
        switch(slicedInput[0]) {
            case "list":
            case "bye":
            case "done":
                isCommand = true;
                break;
            default:
                isTask = true;
                break;
        }
    }

    public static void splitInput(String input) {
        String[] slicedInput = input.split(" ", 2);
        switch(slicedInput[0]) {
        case "list":
        case "bye":
            command = slicedInput[0];
            description = "";
            break;
        case "done":
        case "todo":
        case "deadline":
        case "event":
            command = slicedInput[0];
            description = slicedInput[1];
            break;
        default:
            command = "";
            description = input;
            break;
        }
    }

    public static void executeCommand() {
        switch (command) {
        case "bye":
            exitMessage();
            break;
        case "list":
            printList();
            break;
        case "done":
            list.markAsCompleted(Integer.parseInt(description)-1);
            break;
        default:
            System.exit(1);
        }
    }

    public static void createTask() {
        switch (command) {
        case "todo":
            task = new ToDo(description);
            break;
        case "deadline":
            task = new Deadline(description);
            break;
        case "event":
            task = new Event(description);
            break;
        default:
            task = new Task(description);
            break;
        }
    }

    public static void printSingleTask(int index) {
        String typeOfTask = list.getTask(index).getTypeOfTask();
        String statusIcon =  list.getTask(index).getStatusIcon();
        String description = list.getTask(index).getFormattedDescription();
        System.out.println(index + 1 + ". [" + typeOfTask + "][" + statusIcon + "] " + description);
    }

    public static void printNoOfTasks() {
        System.out.println("Now you have " + list.getTaskCount() + " tasks in the list.");
    }

    public static void exitMessage() {
        System.out.println("Bye. Hope to see you again soon!");
        System.exit(0);
    }

    public static void printList() {
        System.out.println("Here are the tasks in your list");
        for (int i = 0; i < list.getTaskCount(); i++) {
            printSingleTask(i);
        }
    }
}