import java.util.Scanner;

/**
 *
 * @author Afifah
 * Updated by Hidayah
 */
public class TestFile {
        
    public static void main(String[] args) {

        System.out.println("***Welcome to Flight Ticketing System***");
        System.out.println("\nDo you have an account? Please enter 'yes' or 'no'.");
        
        Scanner s = new Scanner(System.in);
        Passenger newPassenger = new Passenger();
        
        String ans = s.nextLine();
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
           
        }
        
        System.out.println("\nWelcome back " + newPassenger.getPassengerName());
        System.out.println("\nWhat do you want to do? Please enter your choice between 1 - 6.");
        System.out.println("\n1. Search for flight");
        System.out.println("2. Book a ticket");
        System.out.println("3. Edit ticket information");
        System.out.println("4. View ticket status");
        System.out.println("5. Cancel a ticket");
        System.out.println("6. Exit");
        
        int choice = s.nextInt();
        
        while (choice != 6) {   //after calling each method, ask for user input of choice again (choice = s.nextInt())
            if (choice == 1) {
            //call search fligth method here
            choice = s.nextInt();
            }
            else if (choice == 2) {
            //call book ticket method here
            choice = s.nextInt();
            }
            else if (choice == 3) {
            //call edit ticket information method here
            choice = s.nextInt();
            }
            else if (choice == 4) {
            //call view ticket status method here
            choice = s.nextInt();
            }
            else if (choice == 5) {
            //call cancel ticket method here
            choice = s.nextInt();
            }
        }
        
        System.out.println("\n***Thank yoou for using Flight Ticketing System!***");
       
    }
    
}
