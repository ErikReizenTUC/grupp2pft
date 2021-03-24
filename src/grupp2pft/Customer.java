/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp2pft;

import static grupp2pft.HotelMain.CheckOut;
import java.util.ArrayList;
import java.util.Scanner;
import static grupp2pft.HotelMain.BookRoom;

/**
 *
 * @author Group 2
 */
public class Customer {
    //Scanner object
    static Scanner scan = new Scanner(System.in);
    
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
    
    static void CustomerMenu() {
        boolean ExitCustomer = false;
            //While loop for come back to select diffrent choice
            while(ExitCustomer == false) { 
                System.out.println("-----------------------------");
                System.out.println("1: See available rooms");
                System.out.println("2: Book room");
                System.out.println("3: Check out");
                System.out.println("4: Return to main menu");
                System.out.println("-----------------------------");
                System.out.print("Make selection: ");

                //try catch for customer menu input
                try {
                   int value = scan.nextInt(); 

                    //Create SwitchCase for customer choice  
                    switch(value){
                        case 1:
                         //Show the list of available room by using hotelroom class
                         //call DisplayRoomsCustomer method in the HotelRoom class.
                           HotelRoom.DisplayAvailableRooms();                        
                           break;
                        case 2:
                            //Call Bookroom method
                            BookRoom();
                            break;
                        case 3:
                            //Call Checkout method
                            CheckOut();
                            break;
                        case 4:
                            System.out.println("Returning to main menu");
                            System.out.println("-----------------------------");
                            //Resetting variable to exit from cutomer menu
                            ExitCustomer = true;
                            break;
                        default:
                            //handling if user input does not match menu options
                            System.out.println("Input did not match menu options");
                            System.out.println("-----------------------------");
                            break;                        
                    }
                }
                catch (Exception InputMismatchException) {
                    //handling if user input is not a number
                    System.out.println("Please enter a number");
                    System.out.println("-----------------------------");


                    //Cleaning scanner
                    scan.next();

                }

            }
                
                
        }
    }
    

