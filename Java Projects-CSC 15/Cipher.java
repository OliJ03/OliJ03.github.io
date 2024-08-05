import java.util.*;
public class Cipher { 
    /* This simple program acts as a CaeserCipher and shifts an inputted phrase by a selected amount of letters. This app integrated the use of if-else and for loop statements 
     * in order to create a loop that shifts the desired statement the desired amount of letters over to create a secret code. */
    public static void main(String[] args){ 
        Scanner kb = new Scanner(System.in);
        go(kb);
    }
    public static void go(Scanner kb){ 
        System.out.println("How many times would you like to use the app? ");
        int appNumber = kb.nextInt(); 

        for(int i = 1; i <= appNumber; i++){ 
            menu(); 
            kb.nextLine();
            String word = kb.nextLine(); 
            char choice = word.charAt(0);

            if(choice == 'e'){
                System.out.println("please enter a message: ");
                String message = kb.nextLine();
                System.out.println("please enter a key: ");
                int key = kb.nextInt();
                String output = encrypt(message, key);
                System.out.println(output);
            }

            else if (choice == 'd'){
                System.out.println("please enter a message: ");
                String message = kb.nextLine();
                System.out.println("please enter a key: ");
                int key1 = kb.nextInt();
                String output1 = decrypt(message, key1);
                System.out.println(output1);
            }
            else {
                System.out.println("invalid choice ");
            }
        }

    }
    public static void menu(){
      System.out.println("          ********             "); 
      System.out.println("Enter e to encrypt your message"); 
      System.out.println("Enter d to decrypt your message"); 
      System.out.println("          ********             "); 
    }
    public static String encrypt (String message, int key){
        message = message.toUpperCase();
        String encrypted = "";
        for (int i = 0; i < message.length(); i++){ 
            char letter = message.charAt(i);
            if(letter >= 'A' && letter <= 'Z'){
                letter += key;
            
                if (letter > 'Z'){
                letter -= 26;

                }
            }
            else { 
                letter+=26;
            }
            encrypted += letter;
        }
        return encrypted;
    }
    public static String decrypt (String message, int key){ 
        message = message.toUpperCase();
        String decrypted = "";
        for (int i = 0; i < message.length(); i++){
            char letter = message.charAt(i);
            if(letter == ':'){
                decrypted += " ";
                continue;
            }
                if(letter >= 'A' && letter <= 'Z'){
                letter -= key;
            }
                if(letter < 'A'){
                int difference = 'A' - letter;
                letter = (char)('Z' - difference + 1);
            }
            else if (letter > 'Z'){
                int difference = 'Z' - letter;
                letter = (char)('A' + difference + 1);
            }
            decrypted += letter;
        }
        return decrypted;
    }
    
}