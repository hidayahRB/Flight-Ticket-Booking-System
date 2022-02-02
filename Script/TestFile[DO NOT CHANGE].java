import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
/**
 *
 * @author Hidayah
 */
public class TestFile {

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        
        Scanner s = new Scanner(System.in);
        // CREATE PASSENGER OBJECT
        Passenger newPassenger = new Passenger();
        
        // LOAD DATA FROM PASSENGER LIST
        readPassengerList(newPassenger);
        
        // LOAD DATA OF FLIGHT DESTINATION
        Flight flight = new Flight();
        flight.addLast("Moscow", "2022/01/05");
        flight.addLast("London", "2022/01/06");
        flight.addLast("Paris", "2022/01/08");
        flight.addLast("Berlin", "2022/01/09");
        flight.addLast("NewYork", "2022/01/21");
        
        // START OUR FLIGHT BOOKING SYSTEM
        System.out.println("***Welcome to Flight Ticketing System***");
        System.out.println("\nDo you have an account? Please enter 'yes' or 'no'.");
        String userName = null;
        String userPass = null;
        String ans = s.nextLine();
        
        // IF USER HAS AN ACCOUNT
        if (ans.equalsIgnoreCase("yes")) {  //already hv an acc, login
            System.out.println("Enter your credentials:");
            System.out.print("Name: ");
            String name1 = s.nextLine();
            System.out.print("Passport no.: ");
            String passport1 = s.nextLine();

            //add a method to compare whether the credentials are available in the list. (use contains())
            if (newPassenger.contains(passport1)) {
                // set the current USER who is using the system
                userName = name1;    // USER ID
                userPass = passport1;
                //System.out.println(user);
            }
            else {
                System.out.println("User not found.");
            }
            
        }    
        else {  // ADD NEW PASSENGER IN PassengerList.txt
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
            
            updatePassengerList(newPassenger, name, passport, age, phone, address);
            
            // set the current USER who is using the system
            userName = name; 
            userPass = passport;
        }
        
        // SET CURRENT USER
        NodePassenger currentUser = newPassenger.getPassenger(userPass);
        //System.out.println(currentUser);
        
        System.out.println("\nWelcome back " + currentUser.getName());
      
        boolean operating = true;
        while (operating) {   
            
            System.out.println("\nWhat do you want to do? Please enter your choice");
            System.out.println("\n1. Search for flight");
            System.out.println("2. Book a ticket");
            System.out.println("3. Edit ticket information");
            System.out.println("4. View ticket status");
            System.out.println("5. Cancel a ticket");
            System.out.println("6. Exit");
            System.out.print("Your choice: ");
            
            int choice = s.nextInt();
            
            if (choice == 1) {
                //call search fligth method here
                searchFlight(flight);
            }
            else if (choice == 2) {
                //call book ticket method here
            }
            else if (choice == 3) {
                //call edit ticket information method here
                updateDetails(newPassenger, currentUser);
            }
            else if (choice == 4) {
                //call view ticket status method here
            }
            else if (choice == 5) {
                //call cancel ticket method here
            }
            else if (choice == 6) {
                //exit the system here
                operating = false;
            }
        }
        
        System.out.println("\n***Thank yoou for using Flight Ticketing System!***");
    }
    
    // add default passenger list before running the program
    private static void readPassengerList(Passenger newPassenger) {
        // read the file
        try{
            Scanner in = new Scanner(new FileInputStream("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\FlightBokingSystem\\src\\flightbokingsystem\\PassengerList.txt"));
            while(in.hasNextLine()){
                // add passenger into list
                String str = in.nextLine();     // read a line
                String[] store = str.split(";");// split the line and store in array
                newPassenger.addLast(store[0], store[1], store[2], store[3], store[4]);
            }in.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }
    
    private static void updatePassengerList(Passenger newPassenger, String name, String passport, String age, String phone, String address) {
        try (FileWriter f = new FileWriter("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\FlightBokingSystem\\src\\flightbokingsystem\\PassengerList.txt", true); 
                BufferedWriter b = new BufferedWriter(f); 
                PrintWriter p = new PrintWriter(b);) { 
            p.println(name + ";" + passport + ";" + age + ";" + phone + ";" + address); 
        } catch (IOException i) { 
            i.printStackTrace(); 
        }
        
        //add a new Node to Passenger here with all the details above
        newPassenger.addLast(name, passport, age, phone, address);
    }
    
    private static void searchFlight(Flight flight) throws ParseException {
        Scanner input = new Scanner(System.in);
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
        Flight resultlist = new Flight(); // linkedlist to save the result of the search
        NodeFlight currNode = flight.getHead();//  head pointing at the first node of the where flight data is stored
        while(currNode != null){ 
            Date date;
                    
            date = sdf.parse((String) currNode.getfDate());
            long millis;
            millis = date.getTime();
            if ((millis1<millis) && (millis<millis2)){             
                resultlist.addLast(currNode.fName, currNode.fDate);  // adding to resultlist the member that is between start date and end date
            }               
            currNode = currNode.nextNode; 
        }
        Flight.printList(resultlist);  //print the search flight result 
    }
    
    private static void updateDetails(Passenger newPassenger, NodePassenger cUser) {
        Scanner s = new Scanner(System.in);
        System.out.println("\n-----Personal Information-----\n");
        System.out.println(cUser);
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
                newPassenger.setNewName(cUser.getPassport(), name);
            }else
            if (choice == 2) {
                System.out.print("New passport number: ");
                String passport = s.next();
                newPassenger.setNewPassport(cUser.getPassport(), passport);
            }else
            if (choice == 3) {
                System.out.print("New age: ");
                String age = s.next();
                newPassenger.setNewAge(cUser.getPassport(), age);
            }else
            if (choice == 4) {
                System.out.print("New phone number: ");
                String phone = s.next();
                newPassenger.setNewPhone(cUser.getPassport(), phone);
            }else
            if (choice == 5) {
                System.out.print("New home address: ");
                String add = s.nextLine();
                newPassenger.setNewAdd(cUser.getPassport(), add);
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
        System.out.println(cUser);
        System.out.println("--------------------------------------");
    }

}
