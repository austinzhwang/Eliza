import java.util.Scanner;

public class IntermediateEliza {

    public static void main (String []args) {

        Scanner in = new Scanner(System.in);

        String userInput = "";

        System.out.print("Good day. What is your problem? ");

        while (!userInput.equalsIgnoreCase("Q")
                || !userInput.equalsIgnoreCase("I am feeling great")) {
            System.out.print("Enter your response here or Q to quit: ");
            userInput = in.nextLine();
            if (userInput.equalsIgnoreCase("Q")
                    || userInput.equalsIgnoreCase("I am feeling great")) {
                break;
            }

            String [] elizaArray = userInput.split(" ");
            for (int i = 0; i < elizaArray.length; i++) {
                if (elizaArray[i].equalsIgnoreCase("my")) {
                    elizaArray[i] = "your";
                } else if (elizaArray[i].equalsIgnoreCase("i")) {
                    elizaArray[i] = "you";
                }
            }
            for (String s : elizaArray) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
