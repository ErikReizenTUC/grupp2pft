/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp2pft;

/**
 *
 * @author Group 2
 */
public class Customer {
    //variable to hold the sum of all the services used by customer
    //might be outside scope?
    public int totalCost = 0;
    
    //see all available rooms
    public void SeeRoomOptions() {
        /* will probably have to be connected to the switch case?
        Something like:
        for (int i = 0; i < roomList.size(); i++) {
            System.out.println((i + 1) + ". " + roomList.get(i).roominfo);
        }
        input = scan.nextInt();
        roomList.get(input).CheckIn();
        */    
    }
    
    // checking in, getting the option of paying in advance or not.
    public void CheckIn() {
        
    }
    
    //pay in advance for the room - might just have this in CheckIn() method
    public void PayInAdvance() {
        //this might be redundant unless the customer has a certain amount of money to spend?
    }
    
    //checking out, selecting various extra options
    public void CheckOut() {
        /* will have to be connected to the switch case
        totalCost += room.price;
        totalCost += spa.price;
        totalCost += resturant.price;
        totalCost += minibar.price;
        */
    }
}
