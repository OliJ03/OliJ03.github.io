import java.util.Scanner ;
import java.util.Random;
public class Ant {
    /* This simple program is a statistics game that was an introduction to the do-while statment. Essentially an ant is going up stairs and has a 50% chance 
     * to go up the step on each try. If the ant falls then the ant restarts at the bottom. The amount of stairs the ant needs to go up is determined by the user. */
    public static void main(String[] args){ 
        Scanner kb = new Scanner(System.in);
        Random rand = new Random();
        run(rand,kb);
    }
    public static int getHeight(Scanner kb){
        System.out.println("What is the height of the building as an integer? "); 
        
        while(!kb.hasNextInt()){
            kb.nextLine();
            System.out.println("What is the height of the building as an integer? ");
        }
        int height = kb.nextInt();
        kb.nextLine();
        return height;
    }

    public static int move(int height, Random rand){ 
        int distance = 0; 
        int fall = 0; 

        do{
            int fallChance = rand.nextInt(2);
            if(fallChance == 1){
                distance++;
            }
            if(fallChance == 0){
                distance = 0; 
                fall ++;
            }
        }while(distance!=height);

        return fall;
    }
    public static void run(Random rand, Scanner kb){
        boolean repeat = true; 
        while(repeat){
            int h = getHeight(kb);
            int distance = move(h,rand); 
            System.out.println("To climb up the building of height " + h + " steps the ant slipped " + distance + 
            " times");
            System.out.println("Would you like to run the program again? ");
            String answer = kb.nextLine();
            if (answer.equals("no")){
                repeat = false;
            }
            else{
                repeat = true;
            }
        }
    }
}
