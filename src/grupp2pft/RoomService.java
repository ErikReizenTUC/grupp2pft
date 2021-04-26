package grupp2pft;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Group 2
 */
public class RoomService {

    //Attributes
    public String productName;
    public int productPrice;
    static int charge;

    static Scanner RService = new Scanner(System.in);

    //Constructor
    public RoomService(String productName, int productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    //New method for prices of item which has been used as extra room service
    public int RoomServiceItemPrice(int number) {
        return this.productPrice * number;
    }

    //ArrayList with productObjects.
    static ArrayList<RoomService> productList = new ArrayList<>();

    //New method to display available products
    public static int DisplayProducts() {

        int count = 0;

        //printing All products
        for (int i = 0; i < RoomService.productList.size(); i++) {
            count++;
            System.out.println(count + ". " + RoomService.productList.get(i).productName + ", "
                    + RoomService.productList.get(i).productPrice + " kr.");
        }
        return count;
    }

    //method for counting the sum of extra items used in the room 
    public static boolean IsProductListEmpty() {
        boolean emptyList = true;
        if (productList.isEmpty()) return emptyList = true;
        else return !emptyList;
    }

    //menu used for items in RoomSerivceCharge method,
    //returns the total price of room service items used by customers
    public static int RoomServiceChargeMenu() {
        
        //variable used to store the total price of room service items
        int totalPrice = 0;
        
        //checking whether there are any items in stock
        if (IsProductListEmpty()) {
            System.out.println("Sorry, there are no items in stock right now.");
            System.out.println("-----------------------------");
        } else {
            
            boolean chargeLoop = true;
            //loop for user input for whether they have used extra items or not
            while (chargeLoop) {
                //try/catch for user input for whether items have been usedc or not
                try {
                    
                    //asking user whether they have used extra items or not
                    System.out.println("Please confirm if you have used extra items during your stay: ");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    System.out.print("Make selection: ");
                    int chargeMenu = RService.nextInt();
                    System.out.println("-----------------------------");

                    switch (chargeMenu) {
                        //if user has used extra items, they are asked to select products and quantity
                        case 1:
                            boolean selectionLoop = true;
                            
                            //loop for user selecting products and amount
                            while (selectionLoop) {
                                //try/catch for selecting products and amount
                                try {
                                    //prints the list of products to user
                                    System.out.println("The options are: ");
                                    DisplayProducts();
                                    //asks user which product they have used
                                    System.out.print("Please enter the product used: ");
                                    int productUsed = RService.nextInt();
                                    
                                    //checks whether the user input matches an item in the list
                                    if (productUsed > productList.size() || productUsed <= 0) {
                                        System.out.println("The product could not be found");
                                        continue;
                                    } else {
                                        boolean quantityLoop = true;
                                        
                                        while (quantityLoop) {
                                            try {
                                                //asks user to input the amount of a certain product they have used
                                                System.out.print("Quantity: ");
                                                int quantity = RService.nextInt();
                                                //calculates the price of the products used and adds it to the total price
                                                totalPrice += productList.get(productUsed - 1).RoomServiceItemPrice(quantity);
                                                System.out.println("Thank you. Your total bill for room service is currently "
                                                        + totalPrice + " kr.");
                                                quantityLoop = false;

                                            } catch (Exception InputMismatchException) {
                                                //handling if user input is not integer
                                                System.out.println("Please enter a number");
                                                System.out.println("-----------------------------");

                                                //Cleaning scanner
                                                RService.next();

                                            }
                                        }
                                    }
                                    boolean moreItemsLoop = true;

                                    //loop for whether more items were used
                                    while (moreItemsLoop) {
                                        //try/catch for whether more items were used
                                        try {
                                            //asks whether user used more items
                                            System.out.println("Did you use any more items?");
                                            System.out.println("1. Yes");
                                            System.out.println("2. No");
                                            System.out.print("Make selection: ");
                                            int moreItemsChoice = RService.nextInt();
                                            
                                            //if user used more items, breaks current loop and goes back to selectionLoop
                                            if (moreItemsChoice == 1) {
                                                moreItemsLoop = false;
                                            
                                            //if user did not use more items, breaks loops and goes back to checkout
                                            } else if (moreItemsChoice == 2) {
                                                System.out.println("Okay, thank you!");
                                                System.out.println("Your final roomservice bill is: " + totalPrice + " kr.");
                                                System.out.println("-----------------------------");
                                                selectionLoop = false;
                                                moreItemsLoop = false;
                                            
                                            //if user input is incorrect, asks for new input
                                            } else {
                                                System.out.println("Please choose from menu options.");
                                            }
                                        } catch (Exception InputMismatchException) {
                                            //handling if user input is not integer
                                            System.out.println("Please enter a number");
                                            System.out.println("-----------------------------");

                                            //Cleaning scanner
                                            RService.next();

                                        }
                                    }
                                } catch (Exception InputMismatchException) {
                                    //handling if user input is not integer
                                    System.out.println("Please enter a number");
                                    System.out.println("-----------------------------");

                                    //Cleaning scanner
                                    RService.next();

                                }
                            }
                            //once user has selected all the products breaks loop and returns to checkout
                            chargeLoop = false;
                            break;
                            
                        //if user has not used extra items, goes back to checkout, exits loop and goes back to checkout    
                        case 2:
                            System.out.println("Okay, thank you!");
                            System.out.println("-----------------------------");

                            chargeLoop = false;
                            break;
                        //if user enters incorrent number, asks them for new input
                        default:
                            System.out.println("Please enter a valid selection.");
                            break;
                    }
                } catch (Exception InputMismatchException) {
                    //handling if user input is not integer
                    System.out.println("Please enter a number");
                    System.out.println("-----------------------------");

                    //Cleaning scanner
                    RService.next();
                }
            }
        }
        //returns total price of room service once user has made all their choices
        return totalPrice;
    }
}
