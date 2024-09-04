import java.util.Random;
import java.util.*;

public class MatchingGame {
    public static void main(String[] args){ 
        Scanner kb = new Scanner(System.in);
        Random rand = new Random();
        String answer = "";
        while(!answer.equalsIgnoreCase("q")) {
            description();
            System.out.println();
            System.out.print("What is your name? ");
            String name = kb.nextLine();
            System.out.println("Hello " + name + " lets start playing!");
            System.out.println();
            play(rand, kb);
            System.out.println();
            System.out.println("Hit enter to let another person play or enter Q to quit the program ");
            System.out.println();
            answer = kb.nextLine();
        }
        System.out.println("Thanks for playing!");
    }
    public static int getRandNum (Random rand){
        int x = rand.nextInt(9) + 1;
        return x;
    }

    public static int match(int n1, int n2, int n3){ 
        int result = 0;
        if(n1 == n2 && n2 == n3 && n1 == n3){
            result = 3;
        }
        else if(n1 == n2 || n2 == n3 || n1 == n3){
            result = 2;
        }
        else {
            result = 1;
        }
        return result;

    }

    public static void description(){
        System.out.println("*********************************************************************************************");
        System.out.println("* Welcome to the number matching game. I will generate three random numbers for you. if two *");
        System.out.println("* of the numbers match you win 100, if you get three matching numbders you win 300 dollars  *");
        System.out.println("*********************************************************************************************");
    }

    public static void play (Random rand, Scanner kb){
        int total = 0; 
        String answer = "";
        int n1 = 0, n2 = 0, n3 = 0;
        while (!answer.equalsIgnoreCase("q")){
            n1 = getRandNum(rand);
            n2 = getRandNum(rand);
            n3 = getRandNum(rand);
            System.out.println("Your numbers are: " + n1 + " " + n2 + " " + n3);
            int match = match(n1, n2, n3);
            if (match == 2){
                total = total + 100;
                System.out.println("You got two matches, you won 100 dollars!");
            }
            else if (match == 3){
                total = total + 300; 
                System.out.println("You got three matches, you won 300 dollars!");
            }
            else {
                System.out.println("You got no matches.");
            }
                System.out.println();
                System.out.println("Hit enter to continue or press q/Q to quit ");
                answer = kb.nextLine().trim();
        }
        System.out.println("Total amount you won: " + total);
        System.out.println("");
    }

}
