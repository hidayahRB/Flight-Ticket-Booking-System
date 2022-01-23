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
        
        boolean operating = true
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
            
            if (choice == 1) {
                //call search fligth method here
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
                //call cancel ticket method here
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
