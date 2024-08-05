import java.util.Scanner;
public class TriviaGame {
    /* This project is an introduction to arrays, passing array parameters through methods, while also implementing my learning of while loops, if-else statements
     * and for loops. I was also introduced to creating a global variable. 
     */
    public static final int SIZE = 5; 
    public static void main(String[] args){ 
        run();
    
    }

    public static void run(){
        Scanner kb = new Scanner(System.in);
        String[] questions = new String[SIZE];
        String[] answers = new String[SIZE];
        int[] values = new int[SIZE];

        initalize(questions, answers, values);

        boolean more = true; 
        while(more){
            int score = play(questions, answers, values, kb);
            System.out.println("Here is the score " + score);
            System.out.println("Would you like to play again? ");
            String result = kb.nextLine(); 

            if(result.equals("yes")){
                more = true; 
            }
            else {
                more = false; 
            }
        }
    }

    public static void initalize (String[] question, String[] answers, int[] values){
        question[0] = "What year was the Emancipation Proclamation issued?";
        answers[0]= "1863";
        values[0] = 1;

        question[1] = "What year was Barack Obama elected to the US presidency?";
        answers[1]= "2008";
        values[1] = 1;

        question[2] = "How many bones are in the human body?";
        answers[2]= "206";
        values[2] = 2;

        question[3] = "What is the largest desert in the world?";
        answers[3]= "antarctica";
        values[3] = 3;

        question[4] = "What is the square root of 25?";
        answers[4]= "5";
        values[4] = 4;
    }

    public static int play(String[] questions, String[] answers, int[] values, Scanner kb){
        int score = 0; 
        for(int i = 0; i < SIZE; i ++){
            System.out.println();
            System.out.println("Question " + (i+1));
            System.out.println(questions[i]);
            String answer = kb.nextLine();
            answer = answer.toLowerCase();
            if(answer.equals(answers[i])){
                score = score + values[i];
                System.out.println("Correct!");
                System.out.println("Score: " + score);
            }
            else if(answer != answers[i]) {
                System.out.println("Incorrect!");
                System.out.println(answers[i]);
            }
        }
        return score;
    }


}
