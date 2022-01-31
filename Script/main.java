/*@author Afifah
 * Updated by Hidayah
 * Updated by Hanii
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FlightSystem {
     public static void main(String[] args) throws ParseException {
      
        LinkedList list = new LinkedList();
       //creating objects with flight info 
        Flight f1 = new Flight("Moscow", "2022/01/05"); 
        Flight f2 = new Flight("London", "2022/01/06");
        Flight f3 = new Flight("Paris", "2022/01/08");
        Flight f4 = new Flight("Berlin", "2022/01/09");
        Flight f5 = new Flight("NewYork", "2022/01/21");
        
       //inserting flight objects to custom linked list
       list.insert(list,f1);
       list.insert(list,f2);
       list.insert(list,f3);
       list.insert(list,f4);
       list.insert(list,f5);
       
       //creating onjects with ticket info
        Ticket tk1 = new Ticket(1,"david","2022/01/05",200,3);
        Ticket tk2 = new Ticket(2,"jackson","2022/01/08",200,1);
        Queue queue=new Queue(2);//creating instance of custom class Queue with size of tickets
        queue.enqueue(tk1);//adding ticket object to custom queue
        queue.enqueue(tk2);
        Scanner input = new Scanner(System.in);
        boolean operating = true;
        
        System.out.println("***Welcome to Flight Ticketing System***");
        System.out.println("\nDo you have an account? Please enter 'yes' or 'no'.");
        
        Scanner s = new Scanner(System.in);
        Passenger newPassenger = new Passenger();
        
        String ans = s.nextLine();
        String user = "";   // not login yet
        if (ans.equalsIgnoreCase("yes")) {  //already hv an acc, login
            System.out.println("Enter your credentials:");
            System.out.print("Name: ");
            String name1 = s.nextLine();
            System.out.print("Passport no.: ");
            String passport1 = s.nextLine();
            
            //fetch Node from Passenger here to access the data
            //add a method to compare whether the credentials are available in the list. (use contains())
        }
        else {//no acc yet, enter details
            System.out.println("Please complete the questions below:");
            System.out.print("Name: ");
            String name = s.nextLine();
            System.out.print("Passport no.: ");
            String passport = s.nextLine();
            System.out.print("Age: ");
            String age = s.nextLine();
            System.out.print("Phone no.: ");
            String phone = s.nextLine();
            System.out.print("Adress: ");
            String address = s.nextLine();
            
            //add a new Node to Passenger here with all the details above
            newPassenger.addLast(name, passport, age, phone, address);
            // set the current USER who is using the system
            user = passport;    // USER ID
        }
        
        System.out.println("\nWelcome back " + newPassenger.getPassengerName());
        
        while (operating) {  
            
            System.out.println("\nWhat do you want to do? Please enter your choice between 1 - 6.");
            System.out.println("\n1. Search for flight");
            System.out.println("2. Book a ticket");
            System.out.println("3. Edit ticket information");
            System.out.println("4. View ticket status");
            System.out.println("5. Cancel a ticket");
            System.out.println("6. Exit");
            System.out.print("Your choice: ");
        
            int choice = s.nextInt();
        
        
//        while (operating) {  
//            
//            System.out.println("\nWhat do you want to do? Please enter your choice between 1 - 6.");
//            System.out.println("\n1. Search for flight");
//            System.out.println("2. Book a ticket");
//            System.out.println("3. Edit ticket information");
//            System.out.println("4. View ticket status");
//            System.out.println("5. Cancel a ticket");
//            System.out.println("6. Exit");
//            System.out.print("Your choice: ");
//        
//            int choice = s.nextInt();
        
        if(choice==1)
        {
           System.out.println("Please enter any week of choice.");
          System.out.println("Please enter start date in [yyyy/mm/dd]."); 
              
         String fromdate = input.nextLine();  //geting the inputed start date by user
                
                SimpleDateFormat sdf;
                sdf = new SimpleDateFormat("yyyy/MM/dd"); // creating SimpleDateFormat object
                Date fdate;
                fdate = sdf.parse(fromdate); // getting start Date from the inputed value by user
               long millis1;
               millis1 = fdate.getTime();  //getting millisecond from the start Date from the inputed value by user
                System.out.println("Please enter end date in [yyyy/mm/dd].");
                String todate = input.nextLine();  //geting the inputed end date by user
                Date tdate;
                tdate = sdf.parse(todate);  // getting end Date from the inputed value by user
                long millis2;
               millis2 = tdate.getTime();  //getting millisecond from the end Date from the inputed value by user
                LinkedList<Flight> resultlist = new LinkedList<Flight>(); // linkedlist to save the result of the search
                  LinkedList.Node currNode = list.head;//  head pointing at the first node of the where flight data is stored
               while(currNode != null){ 
                    Date date;
                    
                    date = sdf.parse(currNode.data.getfDate());
                    long millis;
                    millis = date.getTime();
                   if ((millis1<millis) && (millis<millis2)){             
                        resultlist.insert(resultlist,currNode.data);  // adding to resultlist the member that is between start date and end date
                           
               }
                   currNode = currNode.nextNode; 
                }
               LinkedList.printList(resultlist);  //print the search flight result 
             
        }
        
            else if (choice == 2) {
                //call book ticket method here
            }
            else if (choice == 3) {
                //call edit ticket information method here
                updateDetails(newPassenger, user);
            }
            else if (choice == 4) {
                //call view ticket status method here
            }
            else if (choice == 5) {
                queue.dequeue();// removing ticket from custom queue
                queue.printQueue();// print remaining queue
            }
            else if (choice == 6) {
                //exit the system when enter 6 
                operating = false;
            }
        }
        
        System.out.println("\n***Thank yoou for using Flight Ticketing System!***");
       
    }
        
    private static void updateDetails(Passenger newPassenger, String user) {
        Scanner s = new Scanner(System.in);
        System.out.println("-----Personal Information-----");
        System.out.println(newPassenger.toString());
        System.out.println("------------------------------");
        System.out.println("\n1. Update name");
        System.out.println("2. Update passport number");
        System.out.println("3. Update age");
        System.out.println("4. Update phone number");
        System.out.println("5. Update home address");
        System.out.println("6. Save details");
        
        int choice = s.nextInt();
        boolean ans = true;
        while(ans){
            
            if (choice == 1) {
                System.out.print("New name: ");
                String name = s.next();
                name += s.nextLine();
                newPassenger.setNewName(user, name);
            }else
            if (choice == 2) {
                System.out.print("New passport number: ");
                String passport = s.next();
                newPassenger.setNewPassport(user, passport);
            }else
            if (choice == 3) {
                System.out.print("New age: ");
                String age = s.next();
                newPassenger.setNewAge(user, age);
            }else
            if (choice == 4) {
                System.out.print("New phone number: ");
                String phone = s.next();
                newPassenger.setNewPhone(user, phone);
            }else
            if (choice == 5) {
                System.out.print("New home address: ");
                String add = s.nextLine();
                newPassenger.setNewAdd(user, add);
            }else{
                //exit the system when enter 6 
                System.out.println("Exit Update Details...");
                ans = false;
                break;
            }
            System.out.print("Choose next action: ");
            choice = s.nextInt();
            
        }// end of while loop
        System.out.println("Details have updated successfully...");
        System.out.println("-----Updated Personal Information-----");
        System.out.println(newPassenger.toString());
        System.out.println("--------------------------------------");
    }
    
}
