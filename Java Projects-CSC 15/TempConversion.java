public class TempConversion { 
    /* This was a simple project to help learn about simple mathematical equations and for loops. The app is useful for converting Farenheit to Celsius.*/
    public static void main(String[] args){
        description();
        CentiToFar();
    }
    public static void description(){
        star();
        System.out.println("\nWelcome to the Temp converter app");
        System.out.println("This app provides the temperatures in both centigrade and Farenheit");
        star();
        System.out.println();
        System.out.println();
    }
    
    public static void CentiToFar(){
        System.out.println("Centigrade \t Farenheit");
        
        for(int i = 0; i <=45; i++){
            System.out.println();
            System.out.print(i);
            double ftemp = (9.0/5 * i + 32);
            System.out.print("\t\t " + (int)ftemp);
        }
    }

    public static void star(){
        for (int i = 0; i <= 100; i++){
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i <= 100; i++){
            System.out.print("*");
        }
    }
}