/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp2pft;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Group 2
 */
public class Customer {
    Scanner scan = new Scanner(System.in);
    //attributes for customers
    public String firstName;
    public String lastName;
    
    //constructor
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    //arraylist for customer objects
    static ArrayList<Customer> customerList = new ArrayList<>();
    
    
    //checking in, getting the option of paying in advance or not.
    //using HotelRoom object as parameter
    public void CheckIn(HotelRoom room) {
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
    public void CheckOut() {
        System.out.println("Which room did you stay in?");
        
        HotelRoom.DisplayRooms();
        
        int userChoice = scan.nextInt();
        if (userChoice == 1); {
        
    } 
            
        
        
        
        
        
        
        System.out.println("We hope you have enjoyed your stay!");
        
    }
}
