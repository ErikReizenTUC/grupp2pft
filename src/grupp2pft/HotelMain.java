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
    public static void main(String[] args) {
           //Some comment from Pooja
             //This Scanner object can be used for diffrent cases
        Scanner scan = new Scanner(System.in);
       
    //Instanciate HotelRoom objects
        HotelRoom.roomList.add(new HotelRoom(1, 4, 500, true, false, "Adam Bertilsson"));
        HotelRoom.roomList.add(new HotelRoom(2, 3, 600, false, false, "Ceaser Davidsson"));
        HotelRoom.roomList.add(new HotelRoom(3, 2, 700, true, false, "Erik Fredriksson"));
        HotelRoom.roomList.add(new HotelRoom(4, 2, 800, false, false, "Gustaf Haraldsson"));
        HotelRoom.roomList.add(new HotelRoom(5, 1, 900, false, false, "Ivar Jacobsson"));
        
        
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
                     //calls the Rooms method in the HotelRoom class.
                       HotelRoom.DisplayRoomsCustomer();
                        //Create command here from hotelroom
                        break;
                    case 2:
                        //HotelRoom.DisplayRooms();
                        System.out.println("Enter room number");
                        int number = scan.nextInt();
                        //change the status of room for entered room number
                        for (int i = 0; i < HotelRoom.roomList.size(); i++)                     
                         {
                            if (number == HotelRoom.roomList.get(i).roomNumber) {

                             // Customer.CheckIn(HotelRoom.roomList.get(i));

                              //Customer.CheckIn(HotelRoom.roomList.get(i));

                            }
                        }
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
                
            case 3:
                break;
        }    


    }
    
}
