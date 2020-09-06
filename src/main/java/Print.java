public class Print {

    public static void printWelcomeMessage() {
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

    public static void printExitMessage() {
        System.out.println("Bye. Hope to see you again soon!");
        System.exit(0);
    }

    public static void printSingleTask(TaskManager list, int index) {
        String typeOfTask = list.getTask(index).getTypeOfTask();
        String statusIcon =  list.getTask(index).getStatusIcon();
        String description = list.getTask(index).getFormattedDescription();
        System.out.println(index + 1 + ". [" + typeOfTask + "][" + statusIcon + "] " + description);
    }

    public static void printNoOfTasks(TaskManager list) {
        System.out.println("Now you have " + TaskManager.getTaskCount() + " tasks in the list.");
    }

    public static void printList(TaskManager list) {
        System.out.println("Here are the tasks in your list");
        for (int i = 0; i < TaskManager.getTaskCount(); i++) {
            printSingleTask(list, i);
        }
    }
}

