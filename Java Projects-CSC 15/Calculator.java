import java.util.*;
public class Calculator {
    /* This simple app acts as a caclculator and was an introduction to the if-else statement as well as the Math utility. On top of this, user inputs were 
     * required to turn int values to String and vice versa in order for the calculator to work properly. */
    public static void main(String[] args){
        run();

    }

    public static void menu(){
        System.out.println("To do addition enter +");
        System.out.println("To do multiplication enter *");
        System.out.println("To do subtraction enter -");
        System.out.println("To do exponent enter ^");
        System.out.println("To do division enter /");
        System.out.println("To do modulus enter %");
        System.out.println("**********************************");
    }

    public static int calculate(int operand1, int operand2, String operation){
        switch(operation){
            case "*": return operand1 * operand2;
            case "+": return operand1 + operand2;
            case "-": return operand1 - operand2;
            case "/": return operand1 / operand2;
            case "%": return operand1 % operand2;
            case "^": return (int)Math.pow(operand1, operand2);

        }
        return 0;
    }

    public static String convertOperand(int opr){
        if(opr==0){
            return "zero";
        }
        else if (opr == 1){
            return "one";
        }
        else if (opr == 2){
            return "two";
        }
        else if (opr == 3){
            return "three";
        }
        else if (opr == 4){
            return "four";
        }
        else if (opr == 5){
            return "five";
        }
        else if (opr== 6){
            return "six";
        }
        else if (opr == 7){
            return "seven";
        }
        else if (opr == 8){
            return "eight";
        }
        else {
            return "nine";
        }
    }

    public static String convertOperation(String operation){
        if(operation.equals("+")){
            return "plus";
        }
        else if(operation.equals("*")){
            return "multiply";
        }
        else if(operation.equals("-")){
            return "minus";
        }
        else if(operation.equals("^")){
            return "exponent";
        }
        else if(operation.equals("/")){
            return "divide";
        }
        else {
            return "modulus";
        }
    }
    public static void run(){
        Scanner kb = new Scanner(System.in);
        System.out.print("How many time would you like to run the program? ");
        int runNumber = kb.nextInt();
        kb.nextLine();
        for(int i = 1; i <= runNumber; i++){
            menu();
            System.out.print("Enter your operation: ");
            String operation = kb.nextLine();
            System.out.print("Enter a number between 0-9: ");
            int operand1 = kb.nextInt();
            System.out.print("Enter a number between 0-9: ");
            int operand2 = kb.nextInt();
            System.out.println();
            System.out.println(convertOperand(operand1) + " " + convertOperation(operation) + " " + convertOperand(operand2) + 
            " is " + calculate(operand1, operand2, operation));
            System.out.println("**********************************");
            kb.nextLine();


        }
    }

}