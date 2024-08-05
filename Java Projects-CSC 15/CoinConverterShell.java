public class CoinConverterShell {
    /* This simple program converts the total number of pennies inputted to dollars, quarters, dimes, nickels, and the remaining pennies.
     * This program was an introduction to simple equations and could have been developed easier by using a global variable to input the resulting value of each equation. */
    public static void main(String[] args){
        description();
        convert();
    }
    public static void description(){

        System.out.println("Welcome to the Coin Converter\nTell me the number of pennies you have,");
        System.out.println("I will tell you the number of dollar bills, quarters, dimes, nickels and pennies");
    }
    public static void convert() {
        int pennies = 6789;
        System.out.println(pennies + " pennies are equal to:\n");
        int dollars = pennies / 100; 
        System.out.println(dollars + " dollar(s)");
        int quarters = (pennies - dollars * 100)/25;
        System.out.println(quarters + " quarter(s)");
        int dimes = (pennies - (dollars * 100) - (quarters*25))/10;
        System.out.println(dimes + " dime(s)");
        int nickels = (pennies - (dollars * 100) - (quarters*25) - (dimes * 10))/5;
        System.out.println(nickels + " nickel(s)");
        int penny = (pennies - (dollars * 100) - (quarters*25) - (dimes * 10) - (nickels * 5))/1;
        System.out.println(penny + " penny(s)");
        
    }
}