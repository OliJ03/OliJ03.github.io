import java.util.Scanner;
public class Stock {
    /* This simple program allows a user to determine their total profit from stock purchases. Through the use of several user inputs, I calculate the
     * commission, total purchase price of the stock and total sold price of the stock to determine the user's end profit. */
    public static void main(String[] args){
         Scanner kb = new Scanner(System.in);
         description();
         run(kb);
    }
    public static double profit (double purchaseAmount, double sellAmount, double buyComission, double sellComission){
        double profit = sellAmount - purchaseAmount - sellComission - buyComission; 
        return profit;
    }
    public static double getComission(double price, double rate){
        double getComission = (price * rate)/100;
        return getComission;
    }
    public static double getTotal(double price, double count){
        double getTotal = price * count; 
        return getTotal;
    }
    public static void stars (){
        for (int i = 0; i <= 100; i++){
            System.out.print("*");
        }
        System.out.println();
    }
    public static void description() {
        System.out.println("Welcome to the stock calculator");
        System.out.println("This app calculates the amount of the profit that you can make when buying and selling some stocks");
        System.out.println("when you buy or sell stock you need to pay a comission");
        System.out.println("Answer a few questions then you will see the profit you made");
    }
    public static void run (Scanner kb){

        stars();
        System.out.println("Enter the number of the customers using this app-->");
        int customers = kb.nextInt();
        kb.nextLine();
        for(int i = 1; i <= customers; i++){
            System.out.println("Enter the name of the stock-->");
            String stockName = kb.nextLine();
            System.out.println("Enter the number of the stocks purchased-->");
            double count = kb.nextInt();
            System.out.println("Enter the purchase price per stock-->");
            double purchaseAmount = kb.nextInt();
            System.out.println("Enter the current price of the stock-->");
            double sellAmount = kb.nextInt();
            System.out.println("Enter the comission rate-->");
            double rate = kb.nextInt();
            kb.nextLine();
        

            double buyPrice = getTotal(purchaseAmount, count);
            double sellPrice = getTotal(sellAmount, count);
            double buyComission = getComission(buyPrice, rate);
            double sellComission = getComission(sellPrice, rate);
            double profit = profit(buyPrice, sellPrice, buyComission, sellComission);


            stars();
            System.out.println("Here is the information about your transaction");
            System.out.println("Stock: " + stockName);
            System.out.println("Number of stocks bought: " + count);
            System.out.println("Purchase price per stock: " + purchaseAmount);
            System.out.println("Total commission paid when buying the stock: " + buyComission);
            System.out.println("Selling price of the stock: " + sellAmount);
            System.out.println("Total commission paid when selling the stock: " + sellComission);
            System.out.println("The profit you made buying and then selling this stock: " + profit);
            stars();
            System.out.println("Come back soon!");
        }    
        

    }

}