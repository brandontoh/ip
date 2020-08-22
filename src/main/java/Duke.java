import java.util.Scanner;
import java.util.Arrays;

public class Duke {
    public static void main(String[] args) {
        String[] commands = new String[100];
        int commandCount = 0;

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        dottedLine();
        System.out.println(logo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        dottedLine();

        while (true) {
            System.out.println("Please enter a command:");

            Scanner input = new Scanner(System.in);
            String line = input.nextLine();

            if (line.toLowerCase().equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (line.toLowerCase().equals("list")){
                listCommands(Arrays.copyOf(commands, commandCount));
            } else {
                System.out.println(line);
                storeCommands(commands, line, commandCount);
                commandCount++;
            }

            dottedLine();
        }
    }

    public static void dottedLine() {
        System.out.println("____________________________________________________________");
    }

    public static void storeCommands(String[] commands, String command, int commandCount) {
        commands[commandCount] = commandCount + 1 + ". " + command;
    }

    public static void listCommands(String[] commands) {
        for (String command : commands) {
            System.out.println(command);
        }
    }
}
