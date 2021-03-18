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
    public static void FirstMenu() {
        System.out.println("Hello, Welcome to the Hotel!");
        System.out.println("Enter your choice: ");
        System.out.println("1. Log in as Customer");
        System.out.println("2. Log in as Receptionstaff");
        System.out.println("3. Exit from the program!");
        System.out.println("-----------------------------");
    }

    //Checking in, getting the option of paying in advance or not.
    public static void CheckIn() {

        boolean CheckInComplete = false;
        //loop for entire checkin process
        while (CheckInComplete == false) {
            
            //Checking if rooms are available
            if (HotelRoom.roomList.isEmpty() || HotelRoom.AllRoomsOccupied() == true) {
                System.out.println("Apologies, there are no available rooms!");
                CheckInComplete = true;
            } 
            else {
                //Show room list before checkin
                //Customer can choose room number from the list
                HotelRoom.DisplayRoomsCustomer();
                //Enter room number which you want to checkin
                
                //try/catch for room number input
                try {
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
                            System.out.print("Enter the first name of the person checking in: ");
                            //checking that input is only letters, english only
                                while (!scan.hasNext("[A-Za-z]+")) {
                                    System.out.println("Invalid input!");
                                    System.out.print("Enter the first name of the person checking in: ");
                                    scan.next();
                                    }
                            //Getting first name from user
                            String userFirstName = scan.next();

                            System.out.print("Enter the last name of the person checking in: ");
                            //checking that input is only letters, english only
                            while (!scan.hasNext("[A-Za-z]+")) {
                                    System.out.println("Invalid input!");
                                    System.out.print("Enter the last name of the person checking in: ");
                                    scan.next();
                                    }    

                            //Getting last name from user
                            String userLastName = scan.next();

                            //creating actual customer and adding to list with user input as arguments
                            Customer.customerList.add(new Customer(userFirstName, userLastName));
                            System.out.println("Hello " + userFirstName + " " + userLastName);
                            boolean payLoop = false;
                            
                            //while loop for user payment, to make sure it happens even if user inputs string
                            while (payLoop == false) {
                                //try/catch for user payment
                                try {
                                    System.out.println("Do you wish to pay in advance?");
                                    System.out.println("1. Yes, I will pay now.");
                                    System.out.println("2. No, I will pay later.");
                                    System.out.print("Make selection: ");

                                    //customer makes a choice whether to pay in advance or not
                                    number = scan.nextInt();
                                    if (number == 1) {
                                        HotelRoom.roomList.get(i).PaidInAdvance = true;
                                        System.out.println("We have deducted " + HotelRoom.roomList.get(i).roomPrice + " from your credit card, Thank You!");
                                        payLoop = true;
                                    } 
                                    else if (number == 2) {
                                        System.out.println("Ok. You can pay at the time of checkout.");
                                        payLoop = true;
                                    } 
                                    //handling if user inputs number not matching menu options
                                    else {
                                        System.out.println("Please choose from available options");
                                    }
                                } 
                                catch (Exception InputMismatchException) {
                                    //handling if user input is not an integer
                                    System.out.println("Please enter a number");
                                    System.out.println("-----------------------------");

                                    //Cleaning scanner
                                    scan.next();
                                }

                            }
                            //setting room as occupied with user first and last name in occupiedBy attribute
                            HotelRoom.roomList.get(i).occupied = true;
                            HotelRoom.roomList.get(i).occupiedBy = userFirstName + " " + userLastName;
                        }
                    }
                    
                    //if no matching room is found in the for loop, loop restarts
                    //user has to input new room number
                    if (roomExists == false) {
                        System.out.println("Please enter a correct room number!");
                        System.out.println("-----------------------------");
                    } 
                    else {
                        //Checkin completed and message is shown to customer
                        System.out.println("Check in completed. Welcome to the Hotel!");
                        System.out.println("-----------------------------");
                        boolean CheckinMore = true;
                        //loop for whether user wants to check in more customers
                        while (CheckinMore == true) {
                            //try/catch for 'check in more' input
                            try {
                                System.out.println("Do you want to check in more customers?");
                                System.out.println("1: Yes");
                                System.out.println("2: No");
                                System.out.print("Make selection: ");
                                int CheckinAgain = scan.nextInt();
                                //if user wants to check in more
                                if (CheckinAgain == 1) {
                                    //loop for checkin is false so checkin process restarts
                                    CheckInComplete = false;
                                    //breaking loop for 'check in more' input
                                    CheckinMore = false;
                                } 
                                else if (CheckinAgain == 2) {
                                    System.out.println("Ok, Thanks!");
                                    //breaking loop for 'check in more' input
                                    CheckinMore = false;
                                    //breaking loop for check in, user is returned to menu
                                    CheckInComplete = true;
                                } 
                                else {
                                    //handling if user enters number not matching menu options
                                    System.out.println("Please choose from menu options.");
                                }
                            } 
                            catch (Exception InputMismatchException) {
                                //handling if user input is not integer
                                System.out.println("Please enter a number");
                                System.out.println("-----------------------------");

                                //Cleaning scanner
                                scan.next();
                            }
                        }
                    }
                } 
                catch (Exception InputMismatchException) {
                    //handling if user input is not integer
                    System.out.println("Please enter a number");
                    System.out.println("-----------------------------");

                    //Cleaning scanner
                    scan.next();

                }
            }

        }
    }
    
    //Checking out
    public static void CheckOut() {
        //try/catch for checkout, maybe unnecessary
        try {
            //user inputs first name
            System.out.print("Enter your first name: ");
            //checking that input is only letters, english only
                            while (!scan.hasNext("[A-Za-z]+")) {
                                    System.out.println("Invalid input!");
                                    System.out.print("Enter your first name: ");
                                    scan.next();
                                    }    

            String userChoice = scan.next();
            String userName = userChoice;
            
            //user inputs last name
            System.out.print("Enter your last name: ");
           //checking that input is only letters, english only
                            while (!scan.hasNext("[A-Za-z]+")) {
                                    System.out.println("Invalid input!");
                                    System.out.print("Enter your last name: ");
                                    scan.next();
                                    }  
            
            userChoice = scan.next();
            //userName is now Customer firstName + " " + lastName
            userName += " " + userChoice;

            //Using roomExists to see whether user entered a valid room
            boolean roomExists = false;
            //looping through all rooms checking if any are occupied by user
            for (int i = 0; i < HotelRoom.roomList.size(); i++) {
                if (userName.equals(HotelRoom.roomList.get(i).occupiedBy)) {
                    roomExists = true;
                    //resetting room
                    HotelRoom.roomList.get(i).occupied = false;
                    HotelRoom.roomList.get(i).occupiedBy = "";    
                    //handling user payment
                    if (HotelRoom.roomList.get(i).PaidInAdvance == true) {

                        System.out.println("Room already paid, please come again!"); 
                    } 
                    else {
                        System.out.println("We have deducted " + HotelRoom.roomList.get(i).roomPrice + " from your credit card, please come again!");
                    } 
                    System.out.println("You have succesfully checked out");
                    System.out.println("-----------------------------");
                    //cleaning room
                    ReceptionStaff.Cleaning();
                }
            }
            //Checking if user entered an invalid customer
            if (roomExists == false) {
                System.out.println("Invalid input.");
                System.out.println("-----------------------------");
            }

        }
        catch (Exception InputMismatchException) {
            //handling if user input is not integer
            System.out.println("Please enter a number");
            System.out.println("-----------------------------");


            //Cleaning scanner
            scan.next();

        } 
    }
    
    
    public static void main(String[] args) {

        //Instanciate HotelRoom objects
        HotelRoom.roomList.add(new HotelRoom(1, 4, 500, true, true, "Adam Bertilsson"));
        HotelRoom.roomList.add(new HotelRoom(2, 3, 600, false, false, "  "));                
        HotelRoom.roomList.add(new HotelRoom(3, 2, 700, true, false, "Erik Fredriksson"));
        HotelRoom.roomList.add(new HotelRoom(4, 2, 800, false, false, "  "));                   
        HotelRoom.roomList.add(new HotelRoom(5, 1, 900, false, false, "  "));                   

        //While loop for repetation of FirstMenu method
        boolean Exit = false;
        //while loop for main menu
        while(Exit ==false) {

            //call the first menu
            FirstMenu();
            //try/catch for main menu
            try {
                System.out.print("Make selection: ");
                int choice = scan.nextInt();

                //Create SwitchCase for log in as perticular person choice      
                switch(choice){
                    //Customer can check room availability, booking room and prepayment option are available
                    case 1:                                            
                        Customer.CustomerMenu();
                    break;

                    case 2:
                        //logging in as receptionist              
                        ReceptionStaff.RecAccess();
                        break;

                    case 3:
                        System.out.println("Exit from the program!");
                        //Resetting variable to exit from Firstmenu
                        Exit = true;
                        break;

                    default:
                        //handling if user inputs number not matching menu options
                        System.out.println("Your selection did not match menu options.");
                        System.out.println("-----------------------------");
                        break;
                }
            }
            catch (Exception InputMismatchException) {
                //handling if user input is not integer
                System.out.println("Please enter a number");
                System.out.println("-----------------------------");


                //Cleaning scanner
                scan.next();

            }
        }
    }
}          

    
    
