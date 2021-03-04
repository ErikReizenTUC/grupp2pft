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

import java.util.ArrayList;

/**
 *
 * @author Grupp 2
 */
public class HotelMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
             //This Scanner object can be used for diffrent cases
        Scanner scan = new Scanner(System.in);
       
        //Create SwitchCase for particular person choice
        System.out.println("Enter your choice: ");
        System.out.println("1. Customer");
        System.out.println("2. Receptionstaff");
        System.out.println("3. Hotelstaff");
                     
        int choice = scan.nextInt();
       
        switch(choice){
             //Customer can check room availability, booking room and prepayment option are available
            case 1:
                //Create SwitchCase for customer choice                               
                System.out.println("Choose 1: check availability, 2: Checkin, 3: Checkout");
                int value = scan.nextInt();
               
               
                switch(value){
                    case 1:
                     //Show the list of available room by using hotelroom class
                       
                        //Create command here from hotelroom
                        break;
                    case 2:
                        //copy command from case 1 to show available room
                        System.out.println("Enter room number");
                        int number = scan.nextInt();
                        //change the status of room for entered room number
                        System.out.println("You have booked the room. Congratulation!");
                        break;
                    case 3:
                        System.out.println("Enter room number which you want to checkout");
                        int t = scan.nextInt();
                        //change the status of room for entered room number
                        System.out.println("You have succesfully checked out");
                        break;
                    default:
                        System.out.println("Try Again");
                        break;
                }
                break;
    
    //calls the Rooms method in the HotelRoom class.
    
                        HotelRoom.Rooms();

    }

    
}
