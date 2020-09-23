package userRelated;

import text.ErrorMessage;
import text.MessagePrinter;

import java.util.Scanner;

public class Ui {
    public Ui(){
        MessagePrinter.printWelcomeMessage();
    }

    public String askForInput() {
        MessagePrinter.askToEnterTaskMessage();

        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        return userInput;
    }

    public void showLoadingError() {
        ErrorMessage.uiLoadingError();
    }
}
