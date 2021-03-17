/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp2pft;

import static grupp2pft.HotelMain.CheckIn;
import static grupp2pft.HotelMain.CheckOut;
import java.util.ArrayList;
import java.util.Scanner;

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
                System.out.println("2: Check in");
                System.out.println("3: Check out");
                System.out.println("4: Return to main menu");
                System.out.println("-----------------------------");
                System.out.print("Make selection: ");

                try {
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
                            System.out.println("Returning to main menu");
                            System.out.println("-----------------------------");
                            //Resetting variable to exit from cutomer menu
                            ExitCustomer = true;
                            break;
                        default:
                            System.out.println("Try Again");
                            System.out.println("-----------------------------");
                            break;                        
                    }
                }
                catch (Exception InputMismatchException) {
                    System.out.println("Please enter a number");
                    System.out.println("-----------------------------");


                    //Cleaning scanner
                    scan.next();

                }

            }
                
                
        }
    }
    

