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
        System.out.println("---------------");       
    }
    
    //Checking in, getting the option of paying in advance or not.
    //Using HotelRoom object as parameter
    public static void CheckIn(HotelRoom room) {
        System.out.println("Thank you for choosing this hotel.");
        System.out.println("You will now create a user profile for booking.");
        
        //creating new customer with user input for attributes
        System.out.print("Please enter your first name: ");
        //scanner takes user input
        String userInput = scan.next();
        //Getting first name from user
        String userFirstName = userInput;
        
        System.out.print("Please enter your last name: ");
        userInput = scan.next();
        //getting last name from user
        String userLastName = userInput;
        
        //creating actual customer and adding to list with user input as arguments
        Customer.customerList.add(new Customer(userFirstName, userLastName));
        
        System.out.println("Hello " + userFirstName + " " + userLastName);
        System.out.println("Do you wish to pay in advance?");
        System.out.println("1. Yes, I will pay now.");
        System.out.println("2. No, I will pay later.");
        System.out.print("Make selection: ");
        //customer makes a choice whether to pay in advance or not
        int userChoice = scan.nextInt();
        if (userChoice == 1) {
            room.PaidInAdvance = true;
           
        }
        
        //setting room as occupied
        room.occupied = true;
        room.occupiedBy = userFirstName + " " + userLastName;
        
        
    }   
    
    //checking out, selecting various extra options
    public static void CheckOut() {        
        System.out.println("Enter room number which you want to checkout: ");
       
        int userChoice = scan.nextInt();
        int indexPosition = -1;
        for (int i = 0; i < HotelRoom.roomList.size(); i++) {
            if (userChoice == HotelRoom.roomList.get(i).roomNumber  && HotelRoom.roomList.get(i).occupied == true) {
            indexPosition = i; 
        }
    } 
            if (indexPosition == -1) {
                System.out.println("Invalid input.");
            }
            else {
                    HotelRoom.roomList.get(indexPosition).occupied = false;
                HotelRoom.roomList.get(indexPosition).occupiedBy = "";    
            
                if (HotelRoom.roomList.get(indexPosition).PaidInAdvance == true) {
                    
                    System.out.println("Room already paid, please come again!"); 
                    } 
                else {
                    System.out.println("We have deducted " + HotelRoom.roomList.get(indexPosition).roomPrice + " your creditt card, please come again!");
                } 
                    System.out.println("You have succesfully checked out");
            }
    }
    
    public static void main(String[] args) {

        //Instanciate HotelRoom objects
     HotelRoom.roomList.add(new HotelRoom(1, 4, 500, true, true, "Adam Bertilsson"));
     HotelRoom.roomList.add(new HotelRoom(2, 3, 600, false, false, "  "));                 //Ceaser Davidsson
     HotelRoom.roomList.add(new HotelRoom(3, 2, 700, true, false, "Erik Fredriksson"));
     HotelRoom.roomList.add(new HotelRoom(4, 2, 800, false, false, "  "));                   //Gustaf Haraldsson  
     HotelRoom.roomList.add(new HotelRoom(5, 1, 900, false, false, "  "));                   //Ivar Jacobsson
                   
        //call the first menu
        FirstMenu();
        int choice = scan.nextInt();
                 
    
        //Create SwitchCase for particular person choice       
        switch(choice){
             //Customer can check room availability, booking room and prepayment option are available
            case 1:
                //Create SwitchCase for customer choice                               
                System.out.println("Choose 1: check availability, 2: Checkin, 3: Checkout");
                int value = scan.nextInt();
               
                    switch(value){
                    case 1:
                     //Show the list of available room by using hotelroom class
                     //calls the Rooms method in the HotelRoom class.
                       HotelRoom.DisplayRoomsCustomer();                        
                       break;
                    case 2:
                        //Show room list before checkin
                        //Customer can choose room number from the list
                        
                        HotelRoom.DisplayRoomsCustomer();
                        //Enter room number which you want to checkin
                        System.out.println("Enter room number: ");
                        int number = scan.nextInt();
                        int Indexvalue = -1;
                        //Create For loop to change the status of room for entered room number
                        for (int i = 0; i < HotelRoom.roomList.size(); i++) {
                            //If entered room number is right. Checkin possible
                            if (number == HotelRoom.roomList.get(i).roomNumber) {
                             
                                CheckIn(HotelRoom.roomList.get(i));
                                System.out.println("You have booked the room. Congratulation!");
                                Indexvalue = i;
                            }
                        }
                        if(Indexvalue == -1){
                        System.out.println("Please, enter correct room number!");
                        }
                        break;
                    case 3:
                        //Call Checkout method
                        CheckOut();
                        break;
                    default:
                        System.out.println("Try Again");
                        break;                        
                }
                break;
            case 2:
                //call acess from receptionsit staff
                System.out.println("First Name: ");
                String recFName = scan.next();
                System.out.println("Last Name: ");
                String recLName = scan.next();
                System.out.println("ID: ");
                int recId = scan.nextInt();
                
                ReceptionStaff receptionist = new ReceptionStaff(recFName, recLName, recId);
                receptionist.Access();
                break;
                
            default:
                break;
        }    
                

    }
    
}
