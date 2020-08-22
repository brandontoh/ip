import java.util.Scanner;
import java.util.Arrays;

public class Duke {
    public static void main(String[] args) {
        Task[] tasks = new Task[100];
        int taskCount = 0;

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        dottedLine();
        System.out.println(logo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");

        while (true) {
            dottedLine();
            System.out.println("Please enter a task:");

            Scanner input = new Scanner(System.in);
            String line = input.nextLine();

            if (line.toLowerCase().equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (line.toLowerCase().equals("list")) {
                listTasks(Arrays.copyOf(tasks, taskCount));
            } else if (line.toLowerCase().contains("done")) {
                tasks[Integer.parseInt(line.split(" ")[1]) - 1].markAsCompleted();
            } else {
                System.out.println("Added " + line + " to list");
                tasks[taskCount]= new Task(line);
                taskCount++;
            }
        }
    }

    public static void dottedLine() {
        System.out.println("____________________________________________________________");
    }

    public static void listTasks(Task[] tasks) {
        int count = 1;

        System.out.println("Here are the tasks in your list");
        for (Task task : tasks) {
            System.out.println(count + ". " + "[" + task.getStatusIcon() + "] " + task.description);
            count++;
        }
    }
}
