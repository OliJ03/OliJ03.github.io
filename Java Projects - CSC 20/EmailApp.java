import java.util.*;

public class EmailApp {
}
    class Document{

        private String content;

        public Document(String text){
            this.content = text; 
        }

        public String getContent(){
            return content; 
        }

        public void setContent(String newContent){
            content = newContent;
        }

        public String toString(){
            String s = "Content: " + content;
            return s;
        }

        public int getContentLength(){
            return content.length();
        }

        public boolean contains(String keyword){
            if(content.contains(keyword)){
                return true;
            }
            else {
                return false;
            }
        }

        public boolean equals(Document other){
            //compares current instance of the Document object to the next instance.
            if(this.content.equalsIgnoreCase(other.content)){
                return true;
            }
            else {
                return false;
            }
        }
    }

    class Email extends Document{

        private String sender; 
        private String recipient; 
        private Date date; 
        private String subject; 
        private String cc; 
        private boolean isSent; 

        public Email(String text, String sender, String recipient, String subject, String cc){
            super(text);
            this.sender = sender;
            this.recipient = recipient;
            this.subject = subject; 
            this.cc = cc; 
            date = new Date();
        }

        public void send(){
            isSent = true;
        }

        //getters
        public boolean getSent(){
            return isSent;
        }
        public String getSender(){ 
            return sender;
        }
        public String getRecipient(){ 
            return recipient; 
        }
        public String getSubject(){
            return subject; 
        }
        public String getCC(){
            return cc; 
        }
        public Date getDate(){
            return date;
        }

        //setters 
        public void setSenders(String s){
            if(isSent == false){
               this.sender = s; 
            }
            else {
                System.out.println("This email has been sent and cannot be modified");
            }
        }

        public void setRecipient(String r){
            if(isSent == false){
                this.recipient = r; 
            }
            else {
                System.out.println("This email has been sent and cannot be modified");
            }
        }
        public void setSubject(String su){
            if(isSent == false){
                this.subject = su; 
            }
            else {
                System.out.println("This email has been sent and cannot be modified");
            }
        }
        public void setCC(String c){
            if(isSent == false){
                this.cc = c; 
            }
            else {
                System.out.println("This email has been sent and cannot be modified");
            }
        }

        public String toString(){
            String s = "Sender: " + sender;
            s = s + "\nRecipient: " + recipient;
            s = s + "\nCC: " + cc;
            s = s + "\nSubject: " + subject;
            s = s + "\nDate: " + date;
            s = s + "\n" + super.toString();
            return s;
        }

        public void modifyContent(String s){
            if(isSent == false){
                super.setContent(s);
            }
            else {
                System.out.println("This email has been sent and cannot be modified");
            }
        }

        public Email forward(String rec, String sender, String cc){
            Email f = new Email(this.getContent(),sender, rec, this.subject, cc);
            f.date = new Date();
            f.isSent = true; 
            return f;
        }    
    }
    class EmailDriver { 
        public static void main(String[] args){ 
            Email e1 = new Email("Hello everyone, we will have a meeting tomorrow at 10", "Gita Faroughi","Alex","Meeting","");
            //sending the email
            e1.send();
            //disply the details about the email
            System.out.println(e1);
            System.out.println("\n\n");

            //searching the email for the email for the word tomorrow
            boolean b = e1.contains("tomorrow");
            if(b){
                System.out.println("The word tomorrow was found in the email");
            }
            else{
                System.out.println("The word tomorrow was not found in the email");
            }

            //displaying just the content of the email
            System.out.println("\nThe content of this email is: " + e1.getContent());
            System.out.println();
            //modifying the content of the email
            e1.modifyContent("bye");
            //changing the recipient of the e1 email
            e1.setRecipient("Jose@yahoo.com,Mary@gmail.com");
            System.out.println();
            //forwarding the email
            Email forward = e1.forward("Alex", "Gita" ,"Maria");
            System.out.println();
            //printing the forwarded email
            System.out.println("forwarded message\n"+ forward);
            System.out.println();
            //display the length of the text in the email
            System.out.println("The number of the letters in the email is: " +
            e1.getContentLength());

            Email e2 = new Email("Hello y'all, we have a party tomorrow at 6pm", "Oliver Jezildzic","John","Party","");

            e2.send();
            //disply the details about the email
            System.out.println(e2);
            System.out.println("\n\n");

            //searching the email for the email for the word tomorrow
            boolean c = e2.contains("tomorrow");
            if(c){
                System.out.println("The word tomorrow was found in the email");
            }
            else{
                System.out.println("The word tomorrow was not found in the email");
            }

            //displaying just the content of the email
            System.out.println("\nThe content of this email is: " + e2.getContent());
            System.out.println();
            //modifying the content of the email
            e2.modifyContent("bye");
            //changing the recipient of the e2 email
            e2.setRecipient("Jose@yahoo.com,Mary@gmail.com");
            System.out.println();
            //forwarding the email
            Email forward1 = e2.forward("Alex", "Gita" ,"Maria");
            System.out.println();
            //printing the forwarded email
            System.out.println("forwarded message\n"+ forward1);
            System.out.println();
            //display the length of the text in the email
            System.out.println("The number of the letters in the email is: " +
            e2.getContentLength());
        }
    }