import java.util.Scanner;

/**
 * Simple interactive chat-bot program.
 * @author Austin Wang
 *
 */

public class SimpleEliza {

    public static void main (String []args) {

        Scanner in = new Scanner(System.in);

        String userInput = "";

        do {
            System.out.print("Good day. What is your problem? Enter your response here or Q to quit: ");
            userInput = in.nextLine();
            if (userInput.equalsIgnoreCase("Q")
                    || userInput.equalsIgnoreCase("I am feeling great")) {
                break;
            }
            System.out.println(userInput);
        } while (!userInput.equalsIgnoreCase("Q")
                || !userInput.equalsIgnoreCase("I am feeling great"));
    }
}
