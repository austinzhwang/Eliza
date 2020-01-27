import java.util.Scanner;
import java.util.Random;

public class FullEliza {
    public static void main (String [] args) {

        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        // Array of hedges
        String [] hedges =
                {"Please tell me more",
                        "Many of my patients tell me the same thing",
                        "It is getting late, maybe we had better quit"};

        // Array of qualifiers
        String [] qualifiers =
                {"Why do you say that?",
                        "You seem to think that",
                        "So you are concerned that"};

        System.out.print("Good day. What is your problem? ");

        String userInput = "";
        boolean replaced = false;

        while (!userInput.equalsIgnoreCase("Q")
                || !userInput.equalsIgnoreCase("I am feeling great")) {
            System.out.print("Enter your response here or Q to quit: ");
            userInput = in.nextLine();
            // program ends if user enters either q or i am feeling great
            if (userInput.equalsIgnoreCase("Q")
                    || userInput.equalsIgnoreCase("I am feeling great")) {
                break;
            }
            // splits the string by spaces and adds them to the array
            String [] elizaArray = userInput.split(" ");
            for (int i = 0; i < elizaArray.length; i++) {
                //Replacing words with specified replacements
                if (elizaArray[i].equalsIgnoreCase("i")) {
                    elizaArray[i] = "you";
                    replaced = true;
                } else if (elizaArray[i].equalsIgnoreCase("me")) {
                    elizaArray[i] = "you";
                    replaced = true;
                } else if (elizaArray[i].equalsIgnoreCase("my")) {
                    elizaArray[i] = "your";
                    replaced = true;
                } else if (elizaArray[i].equalsIgnoreCase("am")) {
                    elizaArray[i] = "are";
                    replaced = true;
                } else {
                    replaced = false;
                }
            }
            // if a word is replaced prepend a random qualifier and output it
            if (replaced == true) {
                int r = rand.nextInt(elizaArray.length);
                System.out.print(qualifiers[r] + " ");
                for (int i = 0; i < elizaArray.length; i++) {
                    System.out.print(elizaArray[i] + " ");
                }
                // otherwise output a random hedge
            } else {
                int r = rand.nextInt(hedges.length);
                System.out.print(hedges[r]);
            }
            System.out.println();
        }

        in.close();
    }

}
