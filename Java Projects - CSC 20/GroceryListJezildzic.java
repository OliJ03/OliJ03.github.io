public class GroceryListJezildzic {}
    class Item implements Comparable<Object>{
        private String food; 
        private double price; 
        private String expirationDate;

        public Item(String food, double price, String expirationDate){
            this.food = food; 
            this.price = price; 
            this.expirationDate = expirationDate;
        }

        public String getFood(){
            return food;
        }
        public double getPrice(){
            return price;
        }
        public String getexpirationDate(){
            return expirationDate;
        }

        public void setFood(String food){
            this.food = food;
        }
        public void setPrice(double price){
            this.price = price;
        }
        public void setExpirationDate(String expirationDate){
            this.expirationDate = expirationDate;
        }

        public boolean equals(Item other){
            return this.food.equals(other.food) && this.price==(other.price);
        }

        public int compareTo(Object o){
            Item i = (Item) o;
            return(this.food).compareTo(i.food);

        }

        public String toString(){
            String s = "";
            s = s + "Food: " + food; 
             s = s + "\nPrice: " + price; 
             s = s + "\nExpiration Date: " +expirationDate + "\n"; 
            return s;
        }
    }

    class ListNode {
        private Item item; 
        private ListNode next;

        public ListNode(){

        }

        public ListNode(Object o){
            if (o instanceof Item){
                Item i = (Item) o;
                this.item = i;
            }
        }

        public ListNode(Object o, ListNode next){
            if(o instanceof Item){
                Item i = (Item) o;
                item = i;
                this.next = next;
            }
        }

        public Item getItem(){
            return item;
        }

        public ListNode getNext(){
            return next;
        }
        
        public void setNext(ListNode n){
            this.next = n;
        }

    } 

    interface GList {
        public void add(String food, double price, String expDate);
        public void add(int index, String food, double price, String expDate);
        public int indexOf(String food);
        public void remove(String food);
        public int size();
        public String toString();
        public Item get(int position);
        public Item getMostExpensive();
    }

    class GroceryList implements GList {
        private ListNode head; 
        public static int size = 0; 

        public GroceryList(){
            head = null;
        }

        public void add(String food, double price, String expDate){
            Item i = new Item(food, price, expDate);
            ListNode curr = head;
            if(head == null){
                head = new ListNode(i);
                size++; 
                return;
            }
            ListNode n = new ListNode(i);
            while(curr.getNext()!=null){
                curr = curr.getNext();
            }
            curr.setNext(n);
            size++;

        }

        public void add(int index, String food, double price, String expDate){
            Item i = new Item(food, price, expDate);
            if(index > size){
                return;
            }
            if(index == 0){
                ListNode n = new ListNode(i);
                n.setNext(head);
                head = n; 
                size++;
                return;
            }
            ListNode curr = head; 
            int j = 0; 
            while(curr.getNext() != null && j < index-1){
                curr = curr.getNext();
                j++;
            }
            ListNode n = new ListNode(i);
            n.setNext(curr.getNext());
            curr.setNext(n);
            size++;
        }

        public int indexOf(String food){
            if(head == null){
                return -1;
            }
            if(food.equals(head.getItem().getFood())){
                return 0; 
            }
            ListNode curr = head;
            int index = 0; 
            while (curr!= null && index <= size) {
                if(curr.getItem().getFood().equals(food))
                    return index;
                curr = curr.getNext();
                index++;
            }
            return -1;
        }
        
        public void remove(String food){
            if(head == null){
                return; 
            }
            if(head.getItem().getFood().equals(food))
                head = head.getNext();
            ListNode pre = head;
            ListNode curr = head; 
            while (curr != null && !(curr.getItem().getFood().equals(food))){
                pre = curr; 
                curr = curr.getNext();
            }
            if(curr!= null && curr.getNext() == null && (curr.getItem().getFood().equals(food))){
                pre.setNext(null);
                size--;
                System.out.println("The last node is removed");
            }
            else if (curr == null) {
                System.out.println("song not found");
            }
            else{
                pre.setNext(curr.getNext());
                size--;
                System.out.println("A node in the middle is removed");
            }
        }

        public int size(){
            return size + 1; 
        }
        public String toString(){
            if(head == null) 
                return "";
            ListNode curr = head; 
            String s = "";
            while (curr != null){
                s = s + "Food: " + curr.getItem().getFood(); 
                s = s +"\nPrice: " + curr.getItem().getPrice(); 
                s = s + "\nExpiration Date: " + curr.getItem().getexpirationDate() + "\n\n";
      curr = curr.getNext();
            }
            return s;

        }

        public Item get(int pos){
            if(head == null)
                return null;
            if(pos > size)
                return null; 
            ListNode curr = head; 
            int index = 0; 
            while (curr != null && pos != index){
                index++; 
                curr = curr.getNext();
            }

            if (curr == null)
                return null; 
            return curr.getItem();
        }
        public Item getMostExpensive(){
            if(head == null)
                return null;
            ListNode curr = head; 
            Item mostexp = curr.getItem();
            while(curr != null){
                if(curr.getItem().getPrice() > mostexp.getPrice()){
                    mostexp = curr.getItem();
                }
                curr = curr.getNext();
            }
            return mostexp;
        }
    }


    class GroceryDriver {
        public static void main(String []args) {
            GroceryList list = new GroceryList();

            list.add("Bread", 5.99, "3/20/2022");
            list.add("Milk", 3.99, "2/1/2002");
            list.add("Chips", 2.99, "12/30/2025");
            list.add("Rice", 35.50, "8/15/2030");

            System.out.println("Here is the list of food items");
            System.out.println(list);
            System.out.println("Here is the most expensive item on the list");
            System.out.println(list.getMostExpensive());
            System.out.println("Removing Milk from the list and adding a new expensive item on the list in the 2nd node");
            list.remove("Milk");
            list.add(1, "Truffle", 800, "4/20/2050");
            System.out.println(list);
            System.out.println("Testing the mostExpensive method to see what is the most expensive item now");
            System.out.println(list.getMostExpensive());
            System.out.println("Testing the get method to get the item at the 3rd node");
            System.out.println(list.get(2));
            }           
    }