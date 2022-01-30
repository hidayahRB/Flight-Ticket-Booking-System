package flight.system;

/**
 *
 * @author hanif
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;


import java.util.Date;
import java.util.Scanner;
public class SearchingFlight {

    /**
     * @param args the command line arguments
     */
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
       // while (operating) {  
            
           // System.out.println("\nWhat do you want to do? Please enter your choice between 1 - 3.");
          //  System.out.println("\n1. Search for flight");
         //   System.out.println("2. Cancel a ticket");
          //  System.out.println("3. Exit");
           // System.out.print("Your choice: ");
        
            //int choice = input.nextInt();
        
       // if(choice==1)
            
        //{
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
                   currNode = currNode.next; 
                }
               LinkedList.printList(resultlist);  //print the search flight result 
             
     //   }
        
      //  else if (choice==2)
       // {
        
queue.dequeue();// removing ticket from custom queue
        queue.printQueue();// print remaining queue
        
       
       // }
      //  else if (choice==3)
            
       // {
       
        //operating=false; // exit program
        
        }
        }
        
        
        
        
        
       
   
        
       
        
        
        
    

       
         
  
    

