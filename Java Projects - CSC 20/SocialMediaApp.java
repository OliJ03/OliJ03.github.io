import java.util.ArrayList;
import java.util.Scanner;

public class SocialMediaApp {

}
    
    class User implements Comparable<User>{
        private String firstname;
        private String lastname;
        private String username; 
        private boolean followBack;

        public User(String firstname, String lastname, String username, boolean followBack){
            this.firstname = firstname;
            this.lastname = lastname;
            this.username = username; 
            this.followBack = followBack;
        }

        public String getFirst(){
            return firstname;
        }

        public String getLast(){
            return lastname;
        }

        public Boolean getFollow(){
            return followBack;
        }

        public String getUsername(){
            return username;
        }

        public void setFirst(String newFirst){
            this.firstname = newFirst;
        }

        public void setLast(String newLast){
            this.lastname = newLast;
        }

        public void setUsername(String newUsername){
            this.username = newUsername;
        }

        public String toString(){
            String s = "TreUser name: " + username; 
      s = s + "\nName: " + firstname; 
      s = s + "\nLast Name: " + lastname;
      String a = ""; 
      if(followBack == true) { 
         a = "You follow back this person"; 
         }
      if(followBack == false) {
         a = "You are not following this person"; 
         }
      s = s + " " + "\"" + a;
      return s;     
        }

        public void follow(){
            followBack = true;
        }

        public void unfollow(){
            followBack = false;
        }

        public boolean equals(User other){
            return this.firstname.equalsIgnoreCase(other.firstname) && this.lastname.equalsIgnoreCase(other.lastname) ;
        }

        
        public int compareTo(User other){
                User u = (User) other;
                return this.username.compareTo(u.username);
        }
    }
    
    class SocialMedia{
        private ArrayList<User> app;

        public SocialMedia(){
           app = new ArrayList<User>();
        }

        public void followBack(String firstname, String lastname){
            String s = firstname + " " + lastname; 
            for (int i = 0; i <app.size(); i++){
                String s1 = app.get(i).getFirst() + " " + app.get(i).getLast();
                if(s.equalsIgnoreCase(s1)){
                    app.get(i).follow();
                }
            }
        }

        public boolean follow (String firstname,String lastname, String username, boolean followBack){
            User t = new User(firstname, lastname, username, followBack);
            boolean b = search(firstname, lastname);
            boolean follow = false;

            if(b) {
                return false;
            }
            else if(app.size() == 0){
                app.add(t);
                follow = true;
            }
            for(int i = 0; i < app.size(); i++)
            {
                if(t.compareTo(app.get(i)) < 0)
                {
                    app.add(i, t); 
                    follow = true;
                    break;
                    }
                }
                if(!follow)
                { 
                    app.add(t); 
                    follow = true;
                }
                return follow;            
            
        }

        public boolean remove (String firstname, String lastname){
            for(int i = 0; i < app.size(); i++){
                if(firstname.equals(app.get(i).getFirst()) && lastname.equals(app.get(i).getLast())){
                    app.remove(i);
                    return true;
                }
            }
            return false;
        }

        public boolean search (String firstname, String lastname){
            for(int i = 0; i < app.size(); i++){
                if(firstname.equals(app.get(i).getFirst()) && lastname.equals(app.get(i).getLast())){
                    return true;
                }
            }
            return false;
        }

        public ArrayList<User> getList(){
            return app;
        }

        public int followerCounts() {
            return app.size();
        }

        public int followingCounts(){
            int c = 0; 
            for(int i = 0; i < app.size(); i++){
                if(app.get(i).getFollow() == true){
                    c++;
                }
            }
            return c;
        }

        public String toString(){
            String s = "";
            for (int i= 0; i < app.size(); i++) {  
                s = s + app.get(i).toString() + "\n";
                s = s + "*********************************************************************************\n";
                }
                return s;
             }
    }
    class SocialMediaDriver{
        public static void main(String[] args) {
            System.out.println("test");
            SocialMedia myInsta = new SocialMedia();
            /*Adding followers to your list*/
            /*the boolean field indicates whether you want to follow them back*/
            myInsta.follow("Matthew", "Philips", "MatPhil", true);
            myInsta.follow("Gary", "Kane", "GKane", false);
            myInsta.follow("Robert", "Kenny", "RKenny", true);
            myInsta.follow("Bill", "Fitch", "BillF",true);
            myInsta.follow("Trevor", "Schlulz", "TrevorS", false);
            /*Displaying your followers*/
            System.out.println("Your followers informations\n");
            System.out.println(myInsta);
            /*Unfollowing a user*/
            System.out.println("Removing Robert Kenny from your followers list");
            myInsta.remove("Robert", "Kenny");
            /*Displaying the list*/
            System.out.println("List of followers after removing Robert Kenny");
            System.out.println(myInsta);
            /*adding a new follower*/
            System.out.println("Adding Elon Musk to your list of followers");
            myInsta.follow("Elon", "Musk", "ElonM", true);
            /*Dipslying the followers*/
            System.out.println("List of your followers:");
            System.out.println(myInsta);
            /*Searching for a follower*/
            System.out.println("Searching for Stonewall Jackson(StonW) in your followers list");
            if(myInsta.search("Jackson", "Stonewall") == false) {
            System.out.println("Stonewall Jackson is not in your list of followers");
            System.out.println("\n***************************");
            System.out.println("You are following " + myInsta.followerCounts() + "people");
            System.out.println("You have " + myInsta.followingCounts() + "followers");
            System.out.println(myInsta);
            Scanner kb = new Scanner(System.in);
            System.out.println("Enter the first and last name from the list bellow that you want to follow back: ");
            String first =kb.next();
            String last = kb.next();
            myInsta.followBack(first ,last);
            System.out.println(myInsta);
            kb.close();
            }
        }
    }
