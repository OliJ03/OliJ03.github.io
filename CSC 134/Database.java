import java.sql.*;
import java.util.Scanner;
class Database{
public static void main(String[] args)throws Exception{
   DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
   Connection con=DriverManager.getConnection(
   "jdbc:oracle:thin:@sabzevi2.homeip.net:1521:orcl", "csus", "student");
   
   Statement st=con.createStatement();
   makeTables(st);
   Scanner kb = new Scanner(System.in); 
   while(true){
      menu(kb, st);
      }
   }
   
   public static void menu (Scanner kb, Statement st) throws SQLException{ 
      System.out.println("\nMENU: Please select option by typing 1-5\n1. Insert\n2. Delete\n3. Update\n4. View\n5. Quit"); 
      int decision = kb.nextInt(); 
      kb.nextLine();
       switch(decision){
         case 1: 
            insert(kb, st);
            break; 
         case 2: 
            delete(kb, st);
            break; 
         case 3: 
            update(kb, st);
            break; 
         case 4: 
            view(st); 
            break;
         case 5: 
            quit();
            break;
       }
   }
   public static void insert (Scanner kb, Statement st) throws SQLException{ 
      System.out.println("Which table would you like to insert into?\n1. Teacher\n2. Courses"); 
      int tableChoice = kb.nextInt();
      kb.nextLine(); 
      
      String tableName = (tableChoice == 1) ? "jezil_teacher" : "jezil_courses"; 
      String columns = (tableChoice == 1) ? "(jezil_teacherid, fname, lname)" : "(jezil_courseid, Course_Name, jezil_teacherid)";
      
      System.out.println("Enter values separated by comma: ");
      String values = kb.nextLine(); 
      
      values = values.replaceAll("\\b(\\w+)\\b", "'$1'");
      
      st.executeUpdate("INSERT INTO " + tableName + columns + " VALUES (" + values + ")");
      System.out.println("Record inserted successfully.");
   } 
   
   public static void delete(Scanner kb, Statement st) {
    try {
        System.out.println("Delete from which table?\n1. Teacher\n2. Courses");
        int tableChoice = kb.nextInt(), id;
        String tableName = (tableChoice == 1) ? "jezil_teacher" : "jezil_courses", column = (tableChoice == 1) ? "jezil_teacherid" : "jezil_courseid";
        
        System.out.print("Enter " + column + " to delete: ");
        id = kb.nextInt();

        ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM " + tableName + " WHERE " + column + " = " + id);
        if (rs.next() && rs.getInt(1) > 0) {
            st.executeUpdate("DELETE FROM " + tableName + " WHERE " + column + " = " + id);
            
            if (tableChoice == 2) {
                ResultSet teacherCountRs = st.executeQuery("SELECT COUNT(*) FROM jezil_courses WHERE jezil_teacherid = " + id);
                if (teacherCountRs.next() && teacherCountRs.getInt(1) == 0)
                    st.executeUpdate("DELETE FROM jezil_teacher WHERE jezil_teacherid = " + id); 
            }
            
            System.out.println(tableChoice == 2 ? "Record and corresponding parent teacher record deleted successfully." : "Record deleted successfully.");
        } 
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

      
   public static void update (Scanner kb, Statement st) throws SQLException{ 
      System.out.println("Which table would you like to update?\n1. Teacher\n2. Courses");
      int tableChoice =kb.nextInt();
      kb.nextLine();
      String tableName = (tableChoice == 1) ? "jezil_teacher" : "jezil_courses"; 
      String column = (tableChoice == 1) ? "jezil_teacherid" : "jezil_courseid";
      
      System.out.println("Enter " + column + " of the record to update: "); 
      int id = kb.nextInt(); 
      kb.nextLine();
      
      System.out.println("Enter the column name to update: ");
      String columnName = kb.nextLine(); 
      
      System.out.println("Enter new value"); 
      String newValue = kb.nextLine(); 
     
      newValue = newValue.replaceAll("\\b(\\w+)\\b", "'$1'");
      
      String updateQuery = "UPDATE " + tableName + " SET " + columnName + "=" + newValue + " WHERE " + column + " = " + id;
      int rowsUpdated = st.executeUpdate(updateQuery);
      
      if (rowsUpdated > 0) 
        System.out.println("Record updated successfully.");
      else 
        System.out.println("Record not found or update failed.");
   }
   
   public static void view (Statement st) throws SQLException{ 
      System.out.println("\nHere is the child table\n"); 
      
      ResultSet rs = st.executeQuery("SELECT Course_Name, fname FROM jezil_courses jc JOIN jezil_teacher jt ON jc.jezil_teacherid = jt.jezil_teacherid");

      
      while(rs.next()) {
         String jezil_courseName = rs.getString("Course_Name");
         String jezil_fName = rs.getString("fname");
         
         System.out.println( " Course Name: " + jezil_courseName + " Teacher name: " + jezil_fName);
         }
            
   } 
   public static void quit () { 
      System.out.println("Exiting Program"); 
      System.exit(0);
   }
   
   public static void makeTables(Statement st) throws SQLException { 
      try {
      st.executeQuery("drop table jezil_teacher cascade constraints");
      st.executeQuery("drop table jezil_courses");
      } 
   catch (SQLException s){ }
        st.executeQuery("create table jezil_teacher (jezil_teacherid number PRIMARY KEY, fname VARCHAR(20), lname VARCHAR(20))");
        st.executeQuery("create table jezil_courses (jezil_courseid number PRIMARY KEY, Course_Name VARCHAR(30), jezil_teacherid number REFERENCES jezil_teacher)");
        }
        
}
   
   


