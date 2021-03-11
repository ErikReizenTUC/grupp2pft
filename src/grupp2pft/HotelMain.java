/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 /*
Gruppmedlemmar i grupp 2!
Stefan Levstad
Erik Reizenstein
Pooja Bansal
Marcus Ahlgren
Ali Esmaeeli
 */
 

package grupp2pft;

import java.util.Scanner;

/**
 *
 * @author Grupp 2
 */



public class HotelMain {

    /**
     * @param args the command line arguments
     */
    
    //This Scanner object can be used for diffrent cases
              static Scanner scan = new Scanner(System.in);
    
    //Creating a first menu method so it can be called in other classes
    public static void FirstMenu()
    {
        System.out.println("Enter your choice: ");
        System.out.println("1. Log in as Customer");
        System.out.println("2. Log in as Receptionstaff"); 
        System.out.println("3. Exit from the program!");
        System.out.println("----------------------------------");
    }
    
    //Checking in, getting the option of paying in advance or not.
    public static void CheckIn() {
               
        boolean CheckInComplete = false;
        while(CheckInComplete == false) {
       
        //Show room list before checkin
        //Customer can choose room number from the list
        HotelRoom.DisplayRoomsCustomer();
        
        //Enter room number which you want to checkin
        System.out.print("Enter room number: ");
        int number = scan.nextInt();
        boolean roomExists = false;
        //Create For loop to change the status of room for entered room number
        for (int i = 0; i < HotelRoom.roomList.size(); i++) {
            //If entered room number is right. Checkin possible
            if (number == HotelRoom.roomList.get(i).roomNumber && HotelRoom.roomList.get(i).occupied == false) {
                roomExists = true;
                System.out.println("Thank you for choosing this hotel.");
                System.out.println("You will now create a user profile for booking.");

                //Creating new customer with user input for attributes
                System.out.print("Please enter your first name: ");
                //Getting first name from user
                String userFirstName = scan.next();
                
                
                System.out.print("Please enter your last name: ");
                //Getting last name from user
                String userLastName = scan.next();
                
                //creating actual customer and adding to list with user input as arguments
                Customer.customerList.add(new Customer(userFirstName, userLastName));

                System.out.println("Hello " + userFirstName + " " + userLastName);
                System.out.println("Do you wish to pay in advance?");
                System.out.println("1. Yes, I will pay now.");
                System.out.println("2. No, I will pay later.");
                System.out.print("Make selection: ");

                //customer makes a choice whether to pay in advance or not
                number = scan.nextInt();
                if (number == 1) {
                    HotelRoom.roomList.get(i).PaidInAdvance = true;
                }
                //setting room as occupied
                HotelRoom.roomList.get(i).occupied = true;
                HotelRoom.roomList.get(i).occupiedBy = userFirstName + " " + userLastName;
            }
        }
            if(roomExists == false){
              System.out.println("----------------------------------"); 
              System.out.println("Please, enter correct room number!");
              System.out.println("----------------------------------"); 
             }
            else {
            //Checkin completed and message is shown to customer
            System.out.println("Checkin completed. Welcome to the Hotel!");
            System.out.println("----------------------------------------");
            System.out.println("Do you want to checkin more? 1: Yes, 2: No");
            int CheckinAgain = scan.nextInt();
            if(CheckinAgain == 1)
            CheckInComplete = false;
            else {
            //Resetting value for successful checkin
            CheckInComplete = true;

            //Resetting values for Indexvalue and roomExists
            roomExists = false;
        }   
    } 
        }  
    }
    
    //Checking out
    public static void CheckOut() {
        System.out.print("Enter your first name: ");
        //user inputs first and last name
        String userChoice = scan.next();
        String userName = userChoice;
        System.out.print("Enter your last name: ");
        userChoice = scan.next();
        userName += " " + userChoice;

        //Using indexPosition to track the index of the room user will checkout from
        //Using roomExists to see whether user entered a valid room
        boolean roomExists = false;
        for (int i = 0; i < HotelRoom.roomList.size(); i++) {
            if (userName.equals(HotelRoom.roomList.get(i).occupiedBy)) {
                roomExists = true;
                HotelRoom.roomList.get(i).occupied = false;
                HotelRoom.roomList.get(i).occupiedBy = "";    
                if (HotelRoom.roomList.get(i).PaidInAdvance == true) {

                    System.out.println("Room already paid, please come again!"); 
                } 
                else {
                    System.out.println("We have deducted " + HotelRoom.roomList.get(i).roomPrice + " from your credit card, please come again!");
                } 
                System.out.println("You have succesfully checked out");
                System.out.println("----------------------------------");
                }
        }
        //Checking if user entered an invalid room
        if (roomExists == false) {
            System.out.println("Invalid input.");
            System.out.println("----------------------------------");
        }
        else {
            //Resetting and roomExists variable
            roomExists = false;        
        }

    }
    
    public static void main(String[] args) {

    //Instanciate HotelRoom objects
    HotelRoom.roomList.add(new HotelRoom(1, 4, 500, true, true, "Adam Bertilsson"));
    HotelRoom.roomList.add(new HotelRoom(2, 3, 600, false, false, "  "));                
    HotelRoom.roomList.add(new HotelRoom(3, 2, 700, true, false, "Erik Fredriksson"));
    HotelRoom.roomList.add(new HotelRoom(4, 2, 800, false, false, "  "));                   
    HotelRoom.roomList.add(new HotelRoom(5, 1, 900, false, false, "  "));                   


    
    ReceptionStaff.recStaff.add(new ReceptionStaff("Hanna", "Persson", 1));
    ReceptionStaff.recStaff.add(new ReceptionStaff("Pernilla", "Svärd", 2));
    ReceptionStaff.recStaff.add(new ReceptionStaff("Syd", "Natani", 3));

    
    
    //While loop for repetation of FirstMenu method
    boolean Exit = false;
     while(Exit ==false) {
     
        //call the first menu
        FirstMenu();
        int choice = scan.nextInt();
              
        //Create SwitchCase for log in as perticular person choice      
        switch(choice){
             //Customer can check room availability, booking room and prepayment option are available
            case 1:                                            
                boolean ExitCustomer = false;
                //While loop for come back to select diffrent choice
                while(ExitCustomer == false) { 
                System.out.println("----------------------------------");
                System.out.println("1: check availability, 2: Checkin, 3: Checkout, 4: Exit");
                System.out.print("Make selection: ");
                int value = scan.nextInt();
                //Create SwitchCase for customer choice  
                switch(value){
                    case 1:
                     //Show the list of available room by using hotelroom class
                     //call DisplayRoomsCustomer method in the HotelRoom class.
                       HotelRoom.DisplayRoomsCustomer();                        
                       break;
                    case 2:
                        //Call Checkin method
                        CheckIn();
                        break;
                    case 3:
                        //Call Checkout method
                        CheckOut();
                        break;
                    case 4:
                        System.out.println("Exit from customer menu");
                        System.out.println("----------------------------------");
                        //Resetting variable to exit from cutomer menu
                        ExitCustomer = true;
                        break;
                    default:
                        System.out.println("Try Again");
                        System.out.println("----------------------------------");
                        break;                        
                }
               }
        break;
        
            case 2:
                
                //call acess from receptionsit staff
                System.out.println("First Name: ");
                String recFName = scan.next();
                System.out.println("Last Name: ");
                String recLName = scan.next();
                System.out.println("Work ID: ");
                int recId = scan.nextInt();

                ReceptionStaff receptionist = new ReceptionStaff(recLName, recLName, recId);
                
                receptionist.RecAccess();
                break;
                
            case 3:
                System.out.println("Exit from the program!");
                //Resetting variable to exit from Firstmenu
                Exit = true;
                break;

            default:
                System.out.println("Somthing went wrong, please try again.");
                break;
        }    }
    }

    }          

    
    
