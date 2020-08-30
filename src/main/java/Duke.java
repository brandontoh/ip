import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Duke {
    private static final Task[] tasks = new Task[100];
    private static int taskCount = 0;
    private static String command;
    private static String description;
    private static final  ArrayList<String> twoPartCommands = new ArrayList<String>(Arrays.asList("done", "todo", "deadline", "event"));
    private static final ArrayList<String> onePartCommands = new ArrayList<String>(Arrays.asList("list", "bye"));

    public static void main(String[] args) {

        welcomeMessage();

        while (true) {
            System.out.println("____________________________________________________________");
            System.out.println("Please enter a task:");

            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();

            splitInput(userInput);

            switch (command) {
            case "bye":
                exitMessage();
                break;
            case "list":
                listTasks(Arrays.copyOf(tasks, taskCount));
                break;
            case "done":
                tasks[Integer.parseInt(description) - 1].markAsCompleted();
                break;
            case "todo":
                addTodo(description);
                break;
            case "deadline":
                addDeadline(description);
                break;
            case "event":
                addEvent(description);
                break;
            default:
                addDefault(description);
                break;
            }

            if (command.equals("list") || command.equals("done")) {
                continue;
            }
            listSingleTask(taskCount - 1);
            printNoOfTasks();
        }
    }

    public static void listTasks(Task[] tasks) {
        int count = 1;

        System.out.println("Here are the tasks in your list");
        for (Task task : tasks) {
            System.out.println(count + ". [" + task.getTypeOfTask() + "][" + task.getStatusIcon() + "] " + task.getFormattedDescription());
            count++;
        }
    }

    public static void exitMessage() {
        System.out.println("Bye. Hope to see you again soon!");
        System.exit(0);
    }

    public static void addTodo(String description) {
        tasks[taskCount] = new ToDo(description);
        taskCount++;
        System.out.println("Got it. I've added this task:");
    }

    public static void addDeadline(String description) {
        tasks[taskCount] = new Deadline(description);
        taskCount++;
        System.out.println("Got it. I've added this task:");
    }

    public static void addEvent(String description) {
        tasks[taskCount] = new Event(description);
        taskCount++;
        System.out.println("Got it. I've added this task:");
    }

    public static void addDefault(String description) {
        tasks[taskCount] = new Task(description);
        taskCount++;
        System.out.println("Added " + description + " to list");
    }

    public static void listSingleTask(int index) {
        Task task = tasks[index];
        System.out.println(index + 1 + ". [" + task.getTypeOfTask() + "][" + task.getStatusIcon() + "] " + task.getFormattedDescription());
    }

    public static void printNoOfTasks() {
        System.out.println("Now you have " + taskCount + " tasks in the list.");
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

    public static void splitInput(String input) {
        String[] slicedInput = input.split(" ", 2);
        if (twoPartCommands.contains(slicedInput[0]) && input.contains(" ")) {
            command = slicedInput[0];
            description = slicedInput[1];
        } else if (onePartCommands.contains(input)) {
            command = input;
            description = "";
        } else {
            command = "";
            description = input;
        }
    }
}