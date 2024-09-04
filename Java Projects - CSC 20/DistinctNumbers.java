import java.util.*;
public class DistinctNumbers {
    public static void main (String[] args){
        int[] num = getInput();
        display(num);
        

    }

    public static Boolean found(int[] num, int n){
        for(int i = 0; i < num.length; i++) { 
            if(n == num[i]){
                return true; 
            }
        }
        return false;
    }

    public static int[] getInput(){
        System.out.println("Welcome to the distinct numbers");
        System.out.println("I will remove the repeated numbers and display the numbers you just entered");
        int[] num = new int [10];
        Scanner kb = new Scanner(System.in);
        int input = 0; 
        for(int i = 0; i < num.length; i ++){
            System.out.print("Enter a number: ");
            int number = kb.nextInt();
            boolean result = found(num, number);
            if(result == false){
                num[input] = number;
                input++;
            }
            else if (result == true) { 
                i--;
            }
        }
        kb.close();
        return num;
    }

    public static void display (int[] num){
        System.out.println("I filtered out all the repeated numbers you entered and kept only one copy of each number");
        System.out.println("Here is the list of your numbers");
        for(int i = 0; i < num.length - 1; i++){ 
            System.out.print(num[i] + ", ");
        }
        System.out.println(num[num.length-1] + "}");
    }


}
