import java.util.Scanner;
class Story {
    /* This simple program was an introduction to for loops and user inptus in order to create a story similar to an adlibs story. */
    public static void main(String[] args){ 
        Scanner kb = new Scanner(System.in);
        System.out.println("How many stories would you like to create? ");
        int totalStories = kb.nextInt();
        kb.nextLine();
        for(int i = 1; i <= totalStories; i++){
            story(kb);
        }
    }
    public static void story(Scanner kb){
        //questions for story:
        System.out.println("Please input a name: ");
            String name = kb.nextLine();
        System.out.println("Please input an adjective: ");
            String adjective = kb.nextLine();
        System.out.println("Please input a verb: ");
            String verb = kb.nextLine();
        System.out.println("Please input a number: ");
            int favoriteNumber = kb.nextInt();
        System.out.println("Please input a number: ");
            double sqrtNumber = kb.nextDouble();
            kb.nextLine();
        System.out.println("Please input an address: ");
            String address = kb.nextLine();
        System.out.println("Please input a car manufacturer/model: ");
            String car = kb.nextLine();
        System.out.println("Please input an ethnicity: ");
            String ethnicity = kb.nextLine();
        System.out.println("Please input a food: ");
            String food = kb.nextLine();
        System.out.println("Please input number of family members: ");
            int familyNumber = kb.nextInt();
        System.out.println("Please input the square footage of a house: ");
            int sqftNumber = kb.nextInt();
            kb.nextLine();


        //story:
        System.out.println("Hello my name is " + name + " my name is " + name.length() + " letters long and looks like this in uppercase " + name.toUpperCase() + ". I have an extremely " + adjective + " face and love to " + verb + " in my free time."); 
        System.out.println("My favorite number is " + favoriteNumber + ". My second favorite number is the square root of " + sqrtNumber + ". Which is: " + Math.sqrt(sqrtNumber));
        System.out.println("I live at " + address + " and I drive a " + car + ".");
        System.out.println("My ethnicity is " + ethnicity + ". We celebrate lots and eat " + food + ".");
        System.out.println("Lastly, I have " + familyNumber + " family members and we live in a " + sqftNumber + " sqft house.");
    }
}