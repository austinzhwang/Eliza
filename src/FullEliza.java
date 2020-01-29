import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class FullEliza {
    public static void main (String [] args) {

        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        ArrayList<String> userRespList = new ArrayList<>();
        ArrayList<String> respList = new ArrayList<>();

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

        String start = "Good day. What is your problem? ";
        System.out.println(start);


        String userInput = "";
        String [] elizaArray;
        boolean replaced = false;

        while (true) {
            String response = "Enter your response here or enter Q to quit: ";
            System.out.print(response);
            userInput = in.nextLine();
            userRespList.add(userInput);
            // program ends if user enters either q or i am feeling great
            if (userInput.equalsIgnoreCase("Q")
                    || userInput.equalsIgnoreCase("I am feeling great")) {
                break;
            }
            // splits the string by spaces and adds them to the array
            elizaArray = userInput.split(" ");
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
                }
            }
            // if a word is replaced prepend a random qualifier
            if (replaced) {
                int r = rand.nextInt(qualifiers.length);
                System.out.print(qualifiers[r] + " ");
                for (String s : elizaArray) {
                    respList.add(s);
                    System.out.print(s + " ");
                }
                replaced = false;
                System.out.println();
                // otherwise output a random hedge
            } else {
                int r = rand.nextInt(hedges.length);
                respList.add(hedges[r]);
                System.out.print(hedges[r]);
                System.out.println();
            }
        }



        in.close();
    }

}
