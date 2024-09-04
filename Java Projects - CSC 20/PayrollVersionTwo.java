public class PayrollVersionTwo {
}
    class Payroll{
        private String name; 
        private String id; 
        private double hoursWorked; 
        private double hourlyRate;

        public Payroll(String n, String i, double rate, double hours){
            name = n; 
            id = i;
            hoursWorked = hours; 
            hourlyRate = rate; 
        }

        //getter methods

        public String getName(){
            return name; 
        }

        public String getId(){
            return id;
        }

        public double getHourlyRate(){
            return hourlyRate;
        }

        public double getHoursWorked(){
            return hoursWorked;
        }

        //setter methods

        public void setName(String newName){
            name = newName; 
        }

        public void setId(String newId){
            id = newId;
        }

        public void setHourlyRate(double newhourlyRate){
            hourlyRate = newhourlyRate;
        }

        public void setHoursWorked(double newhoursWorked){
            hoursWorked = newhoursWorked;
        }

        public double getPay(){
            double pay = hourlyRate * hoursWorked;
            return pay;
        }

        public String toString(){
            String s = "Name: " + name; 
            s = s + "\nID: " + id; 
            s = s + "\nHours Worked: " + hoursWorked;
            s = s + "\nHourly Rate: " + hourlyRate;
            return s;
        }

    }
    class PayrollDriver{
        public static void main(String[] args){
            System.out.println("Creating payroll objects");
            Payroll p1 = new Payroll("Alex Martinez" ,"123456", 25, 20);
            Payroll p2 = new Payroll("Ali Santos" ,"986747", 125, 45);
            Payroll p3 = new Payroll(" Jose Busta" ,"45678", 55, 30);
            Payroll p4 = new Payroll("Oliver J", "50002", 14, 50);
            Payroll p5 = new Payroll("John Smith", "50002", 17, 35);

            System.out.println("testing the toString method");
            System.out.println("List of the employees");
            System.out.println(p1);
            System.out.println("Salary is : " + p1.getPay()); //calling the getPay method
            System.out.println("\n*******************");
            System.out.println(p2);
            System.out.println("Salary is : "+ p2.getPay());
            System.out.println("\n*******************");
            System.out.println(p3);
            System.out.println("Salary is : "+ p3.getPay());
            System.out.println("\n*******************");
            System.out.println(p4);
            System.out.println("Salary is : "+ p4.getPay());
            System.out.println("\n*******************");
            System.out.println(p5);
            System.out.println("Salary is : "+ p5.getPay());
            System.out.println("\n*******************");
            System.out.println("\nTesting the setter methods");
            System.out.println();

            System.out.println("The hourly pay of " + p1.getName() + " is being chnaged");
            p1.setHoursWorked(80); // changing the hours worked for the object p1
            System.out.println(p1);
            System.out.println("Salary is : "+ p1.getPay());
            System.out.println();

            System.out.println("The hourly pay of " + p4.getName() + " is being chnaged");
            p4.setHoursWorked(60); // changing the hours worked for the object p1
            System.out.println(p4);
            System.out.println("Salary is : "+ p4.getPay());
            System.out.println();

            System.out.println("The hourly pay of " + p5.getName() + " is being chnaged");
            p5.setHoursWorked(75); // changing the hours worked for the object p1
            System.out.println(p5);
            System.out.println("Salary is : "+ p5.getPay());
            System.out.println();
        }
    }

