
package ds.assg.pkg2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Afifah Abdul Halim
 */
public class TestFile {
    
    static Queue waitingList = new Queue(10);            
    static String[] confirmedList = new String[1];
    static String user = "";   // not login yet
    
    public static void main(String[] args) throws FileNotFoundException {
        
        System.out.println("***Welcome to Flight Ticketing System***");
        System.out.println("\nDo you have an account? Please enter 'yes' or 'no'.");
        
        Scanner s = new Scanner(System.in);
        Passenger newPassenger = new Passenger();
        
        //dummy Passenger data to test
        newPassenger.addLast("Drew", "123", "28", "0111112343", "KL");
        //newPassenger.addLast("Lydia", "456", "21", "0134342167", "KL");
        
        String ans = s.nextLine();
        //String user = "";   // not login yet
        if (ans.equalsIgnoreCase("yes")) {  //already hv an acc, login
            System.out.println("Enter your credentials:");
            System.out.print("Name: ");
            String name1 = s.nextLine();
            System.out.print("Passport no.: ");
            String passport1 = s.nextLine();
            
            //fetch Node from Passenger here to access the data
            //newPassenger.getPassengerInformation(newPassenger, passport1);
            
            //add a method to compare whether the credentials are available in the list. (use contains())
            if (newPassenger.contains(passport1)) {
                // set the current USER who is using the system
                user = passport1;    // USER ID
            }
            else {
                System.out.println("User not found.");
            }
            
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
            }
            else if (choice == 2) {
                //call book ticket method here
                System.out.println("Which date would u like to fly? enter a date with format dd/mm/yyyy");
                String date = s.next();
                bookTicket(date);
                System.out.println("Tadaa!!");
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
                //exit the system here
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
    
    public static void bookTicket(String date) throws FileNotFoundException {
        
        File flightFile = new File("C:\\Users\\Afifah Abdul Halim\\OneDrive - Universiti Malaya\\Documents\\NetBeansProjects\\DS assg 2022\\src\\ds\\assg\\pkg2022\\FlightFile.txt");  //put location of Flight txt file here
        Scanner s1 = new Scanner(flightFile);
        s1.nextLine();
        String flightText = "";
        while(s1.hasNextLine()) {
            flightText += s1.nextLine(); //read every line in txt file and append it in a String
        }
        
        int n = 0;
        
        for (int i = 0; i < flightText.length(); i++) {     //traverse the Flight txt file,
            String[] newtext = flightText.split(",");   
            
            for (int j = 2; j < newtext.length; j++) {      //get the date at index j in Flight txt file)
                
                if (newtext[j].equals(date)) {
                    //j+1 is to get the status of flight
                    if (newtext[j+1].equals(false)) {         //flight chosen is available, flight status = false
                        n += 1;
                        String[] temp = new String[n];
                        System.arraycopy(confirmedList, 0, temp, 0, n); //copy array to increase the size of confirmedList
                        confirmedList = temp;
                        confirmedList[n] = user;
                        System.out.println("You have successfully book the ticket!");
                    }
                    else {                                  //flight chosen is not available, had been booked, flight status = true
                        waitingList.enqueue(user);
                        System.out.println("Sorry your chosen flight is not available. You are now in the waiting list.");
                    }
                }
                
            }
        }
        
    }
    
}
