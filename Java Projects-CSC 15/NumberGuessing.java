import java.util.*;
/* This simple program is a number guessing game that was an introduction to the while statement, creating a random number, and creating global variables. */
public class NumberGuessing { 
    public static final int MIN = 500;
    public static final int MAX = 600;
    public static void main (String[] args){
        Scanner kb = new Scanner(System.in);
        menu();
        run(kb);
    }
    public static void menu() {
        System.out.println("Hi my name is Oliver your computer");
        System.out.println("I want to play a guessing game with you");
        System.out.println("I will think of a number between 500 and 600 values");
        System.out.println("and will allow you to guess until you get it");
        System.out.println("For each guess, I will tell you lower or higher until you guess correctly.");
    }
    public static void run(Scanner kb){
        Random rand = new Random(); 
        String decision = "yes";

        while(decision.equals("yes")){
            int randomNumber = rand.nextInt(MAX - MIN) + MIN;
            int result = playGame(kb, randomNumber);
            System.out.println("You guessed correctly in " + result + " tries");
            kb.nextLine();
            System.out.println("Would you like to play again? Please type yes or no: ");
            decision = kb.nextLine();
        }

    }
    public static int playGame(Scanner kb, int randomNumber){
        int totalGuesses = 0; 
        int userGuess = 0; 
        
        while(userGuess != randomNumber){
            System.out.println("Please entire a number between " + MIN + " and " + MAX + ":");
            userGuess = kb.nextInt();
            if (userGuess < randomNumber){
                System.out.println("Higher");
            }
            else if(userGuess > randomNumber){
                System.out.println("Lower");
            }
            else {
                System.out.println("Winner!");
            }
            totalGuesses++; 
        }
        return totalGuesses;
    }
}