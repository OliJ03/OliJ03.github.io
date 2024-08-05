public class PayrollShell {
    }
    /* This simple program uses Object Oriented Programming principles in order to reduce repetiveness, confusion, and runtime of the computer. 
     * This program was an introduction to the concepts of getters and setters as well as objects in order to create specific instances of employees. 
     * This program allows a user to input an employee id, name, pay rate per hour, and total hours work in order to calculate their pay.
     */
    class Payroll{
        private String nameEmployee; 
        private String idEmployee;
        private double hourlyRate;
        private double hoursWorked;
        
        public Payroll (String n, String i, double rate, double hours){
            nameEmployee = i;
            idEmployee = n; 
            hourlyRate = rate;
            hoursWorked = hours; 
        }

        public void setName(String newName){
            nameEmployee = newName;
        }
        public void setId(String newId){
            idEmployee = newId;
        }
        public void setHours(double newHours){
            hoursWorked = newHours;
        }
        public void setRate(double newHourlyRate){
            hourlyRate = newHourlyRate;
        }

        public String getId(){
            return idEmployee;
        }
        public String getName(){
            return nameEmployee;
        }
        public double getRate(){
            return hourlyRate;
        }
        public double getHoursWorked(){
            return hoursWorked;
        }
        public String toString(){
            String s = "Name : " + nameEmployee;
            s = s + "\nID = " + idEmployee;
            s = s + "\nHourly Rate = " + hourlyRate;
            s = s + "\nHours Worked = " + hoursWorked;
            return s;
        }
        public double pay() {
            double pay = hoursWorked * hourlyRate;
            return pay;
        }
    }

    class PayrollDriver{
        
        public static void main(String[] args)
        {
            Payroll p1 = new Payroll("1234","Alex",12,12);
            Payroll p2 = new Payroll("9807", "Nik",10,20);
            Payroll p3 = new Payroll("2345","Jose", 100, 20);
            
            System.out.println("Testing the toString method\n");
            System.out.println(p1);
            System.out.println("*******************");
            System.out.println(p2);
            System.out.println("*******************");
            System.out.println(p3);
            
            System.out.println("testing the getter methods and the pay method\n");
            System.out.println(p1.getName() + " is paid " + p1.pay());
            System.out.println(p2.getName() + " is paid " + p2.pay());
            System.out.println(p3.getName() + " is paid " + p3.pay());
            
            System.out.println("testing the setter methods\n");
            System.out.println("Setting the hours worked for Alex to 25");
            p1.setHours(25);
            p1.toString();
            System.out.println(p1);
            System.out.println();
            System.out.println(p1.getName() + " is now paid " + p1.pay());

            System.out.println("setting the hourly rate for Nik to 45");
            p2.setRate(45);
            p2.toString();
            System.out.println(p2);
            System.out.println(p2.getName() + " is now paid " + p2.pay());
        }
    }

