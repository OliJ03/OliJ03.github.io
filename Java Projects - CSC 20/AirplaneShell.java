import java.util.Scanner;

public class AirplaneShell {

}
    class Person{ 
        private String name; 
        private String lastname; 
        private String ticketID;
    
        public Person(String name, String lastname, String ticketID){
            this.name = name; 
            this.lastname = lastname;
            this.ticketID = ticketID;
        }

        public void setFirst(String name){
            this.name = name;
        }

        public void setLast(String lastname){
            this.lastname = lastname;
        }

        public void setTicketID(String ticketID){
            this.ticketID = ticketID;
        }

        public String getFirst(){
            return name;
        }

        public String getLast(){
            return lastname;
        }

        public String getTicketID(){
            return ticketID;
        }

        public String toString(){
            String s = "Name: " + name;
            s = s + "\nLast Name: " + lastname;
            s = s + "\nTicket ID: " + ticketID;
            return s;
        }

        public boolean equals(Object o){
            //if o is of type Person, continue
            if(o instanceof Person){
                //allows the typecasting of object o to the Person class
                Person p = (Person) o; 
                //compare based on first name, if same compare last names
                return this.name == p.name && this.lastname == p.lastname;
            }
            else {
                return false;
            }
        }
    }
    class Passenger extends Person{
        private int seatNumber; 
        private String classType;

        public Passenger(String name, String lastname, String ticketID, int seatNumber, String classType){
            super(name, lastname, ticketID);
            this.seatNumber = seatNumber;
            this.classType = classType;
        }

        public void setSeatNumber(int seatNumber){
            this.seatNumber = seatNumber;
        }

        public void setClass(String classType){
            this.classType = classType;
        }

        public String getClassType(){
            return classType;
        }

        public int getSeatNumber(){
            return seatNumber; 
        }

        public String toString(){
            String s = super.toString();
            s = s + "\nSeat Number: " + seatNumber;
            s = s + "\nClass: " + classType;
            s = s + "\n";
            return s;
        }

    }

    interface list {
        public boolean add(Object o);
        public Object search(Object o);
        public boolean delete(Object o);
        public void printLast();
        public void takeOff();
    }

    class Airplane implements list {
        private static int count = 0;
        private Passenger[] passenger = new Passenger[10];
        private boolean takenOff = false; 
        private int planeNum;

        public Airplane (int planeNum){
            this.planeNum = planeNum;
        }

        public static int getCount(){
            return count++;
        }

        public int getPlaneNumber(){
            return planeNum;
        }

        public void setPlaneNumber(int planeNum){
            this.planeNum = planeNum;
        }

        public String toString(){
            String s = "";
            //loop for the amount of passengers on the plane
            for(int i = 0; i < passenger.length; i++){
                //if passengers, continue
                if(passenger[i]!= null){
                    //print passenger information
                    s += passenger[i].toString() + "\n";
                }
            }
            return s;
        }

        public boolean add(Object o){
            //if not taken off, continue
            if(takenOff == false){
                //if object is of type Passenger
                if(o instanceof Passenger){
                    //typecast object to passenger type
                    Passenger p = (Passenger) o;
                    //adding passenger to array and object passenger p
                    passenger[count] = p;
                    //increase plane count by 1
                    count++;
                    //passenger successfully added
                    return true;

                }
            }
            //passenger not added
            return false;
        }

        public Object search(Object o){
            //check if boolean b is equal to object o in type String
            boolean b = o instanceof String; 
            //if b is not string; return null
            if(!b){
                return null;
            }
            //if boolean b is of type string, typecast object o to String
            String name = (String) o;
            //loop through the total amount of passengers
            for(int i = 0; i < passenger.length; i++){
                //if passenger not null and passenger has last name, return the information of the passenger
                if(passenger[i]!= null && passenger[i].getLast().equalsIgnoreCase(name)){
                    return passenger[i];
                }
            }
            return null;
        }

        public boolean delete(Object o){
            //similar functionality of the search function
            boolean b = o instanceof String; 
            if(!b){
                return false;
            }
            String name = (String) o;
            for(int i = 0; i < passenger.length; i++){
                if(passenger[i]!= null && passenger[i].getLast().equalsIgnoreCase(name)){
                    //sets passenger info in array at current position to null
                    passenger[i] = null;
                    //removes one from passenger count
                    count--;
                    //confirms passenger was removed
                    return true;
                }
            }
            //passenger was not removed
            return false;
        }
        public void printLast(){
            for(int i = 0; i < count; i++){
                System.out.println(passenger[i].getLast());
            }
        }
        //the plane has taken off
        public void takeOff(){
            takenOff = true;
            System.out.println("This plane has already taken off, passengers cannot board the plane.\n"); 
        }
        
    }
    class AirplaneDriver {
        public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        Airplane plane = new Airplane(20394);

        Passenger p1 = new Passenger("Bobby", "Smith", "123456789", 1, "First class");
        Passenger p2 = new Passenger("Johnny", "Apple", "987654321", 8,
        "Business class");
        Passenger p3 = new Passenger("Tom", "Jerry", "567123489", 32, "Economy class");
        Passenger p4 = new Passenger("Candy", "Cruz", "982134567", 15, "Premium Economy class");
        Passenger p5 = new Passenger("Kaloti", "Aaron", "762134589", 5, "First class");
        plane.add(p1);
        plane.add(p2);
        plane.add(p3);
        plane.add(p4);
        plane.takeOff();
        plane.add(p5);
        System.out.println("Here is the list of the passengers in this plane");
        System.out.println(plane + "\n");
        System.out.println("Testing the printLast method to display the last names");
        plane.printLast(); //prints the last name of the passenger sin the train
        System.out.println();
        System.out.println("Testing the static method getCount");
        System.out.println("This plane has " + plane.getCount() + "Passengers\n");
        System.out.print("Enter the last name of the passenger: ");
        String lastName = in.nextLine();
        System.out.println(plane.search(lastName));
        System.out.println();
        System.out.println("Testing the delete method");
        System.out.print("Enter the last name of the passenger: ");
        String last = in.nextLine();
        plane.delete(last);
        System.out.println("Passenger " + last + " has been removed from the list\n");
        System.out.println("Here is the updated list");
        System.out.println(plane);
        in.close();
        }
    }
