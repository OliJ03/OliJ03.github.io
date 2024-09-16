import java.util.*;
public class StackLastName
{
}
interface myStack
{
   public void push(String s);
   public String peek();
   public boolean isEmpty();
   public String pop();
}
class  Stack implements myStack //must implement the myStack interface
{
   private ArrayList<String> list; 
   int top = 0;
      public Stack(){
         list = new ArrayList<String>();
         top = 0;
      }
      public String peek(){
         if(!isEmpty()){
            return list.get(top-1);
         }
         return null;
      }
      public String pop(){
         if(!isEmpty()){
            top--;
            String o = list.get(top);
            list.remove(top);
            return o;
         }
         return null;
      }
      public boolean isEmpty(){
         return list.size() == 0;
      }
      public void push(String s){
         list.add(s);
         top++;
      }
      public String toString(){
         return list.toString();
      }
}

class Expression
{
   private String exp;  // instance variable
      public Expression(String e){
         exp = e;
      }
      public String getPostfix(){            
         String pfix = "";
         Stack s = new Stack();
         StringTokenizer st = new StringTokenizer(exp, " ");
         while(st.hasMoreTokens()){
            String token = st.nextToken();
            if(token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-")){
               int a = precedence(token);
               if(a == 3){
                  while(!s.isEmpty() && precedence(s.peek()) >= 3){
                     pfix += s.pop() + " ";
                  }
               }
               else if(a == 2){
                  while(!s.isEmpty() && precedence(s.peek()) >= 2){
                     pfix += s.pop() + " ";
                  }
               }
               s.push(token);
            }
            else
               pfix += token + " ";
         }
         while(!s.isEmpty()){
            pfix += s.pop() + " ";
         }
         return pfix;
      }
      private static int precedence(String opr){
         if(opr.equals("*") || opr.equals("/")){
            return 3;
         }
         else if (opr.equals("+") || opr.equals("-")){
            return 2;
         }
         return 0;
      }
      public int evalPostfix(){
         String post = this.getPostfix();
         Stack s = new Stack();
         int result = 0;
         StringTokenizer st = new StringTokenizer(post, " ");
         while(st.hasMoreTokens()){
            String token = st.nextToken();
            if(!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")){
               s.push(token);
            }
            else{
               
               int num1 = Integer.parseInt(s.pop());
               int num2 = Integer.parseInt(s.pop());
               result = calculate(num1, num2, token);
               s.push("" + result + "");
            }
         }
         return Integer.parseInt(s.pop());
      }
      private int calculate(int num1, int num2, String opr){
         if(opr.equals("*")){
            return num1 * num2;
         }
         else if (opr.equals("/")){
            return num2 / num1;
         }
         else if(opr.equals("+")){
            return num1 + num2;
         }
         else if(opr.equals("-")){
            return num2 - num1;
         }
         return 0;
      }
}
class ExpDrive
{
  public static void main(String[] args)
  {
     
    // String s = "5 - 2";
     ArrayList <String> exp = new ArrayList<String>();
     exp.add("2 + 3 + 7 * 4 - 2 / 3");
     exp.add("3 - 4 / 2 + 6 * 3");
     exp.add("5 * 6 - 8 + 2 * 10");
     exp.add("4 + 8 * 3 - 2 / 34");
     exp.add("6 - 3 + 6 / 2 * 4 - 8");
     for(int i = 0; i < exp.size(); i++)
     {
     
        Expression e1 = new Expression(exp.get(i));
        String post = e1.getPostfix();
        int result = e1.evalPostfix();
        System.out.println("Infix: "+ exp.get(i) + ",  postfix: " + post + " = " + result);
     }

}
}
/*
Write your own driver to test your code
this driver should be similar to the one 
I provided but must be your own expressions
*/
class MyExpDrive
{
   public static void main(String[] args)
   {
   }
}