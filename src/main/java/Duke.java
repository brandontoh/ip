import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        dottedLine();
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
            } else {
                System.out.println(line);
            }

            dottedLine();
        }
    }

    public static void dottedLine() {
        System.out.println("____________________________________________________________");
    }
}
