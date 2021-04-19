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
    public static int RoomServiceCharge() {

        return charge;
    }

    //menu used for items in RoomSerivceCharge method 
    public static int RoomServiceChargeMenu() {
        int totalPrice = 0;
        boolean chargeLoop = true;
        while (chargeLoop) {

            System.out.println("Please confirm if you have used extra items during your stay: ");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Make selection: ");
            int chargeMenu = RService.nextInt();
            System.out.println("-----------------------------");

            switch (chargeMenu) {

                case 1:
                    boolean selectionLoop = true;
                    while (selectionLoop) {
                        System.out.println("The options are: ");
                        DisplayProducts();
                        System.out.print("Please enter the product used: ");
                        int productUsed = RService.nextInt();

                        if (productUsed > productList.size() || productUsed <= 0) {
                            System.out.println("The product could not be found");
                            continue;
                        } else {
                            System.out.print("Quantity: ");
                            int quantity = RService.nextInt();
                            totalPrice += productList.get(productUsed -1).RoomServiceItemPrice(quantity);
                            System.out.println("Thank you. Your total bill for room service is currently " + totalPrice + " kr.");
                        }
                        boolean moreItemsLoop = true;
                        while (moreItemsLoop) {
                            System.out.println("Did you use any more items");
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            System.out.print("Make selection: ");
                            int moreItemsChoice = RService.nextInt();
                            if (moreItemsChoice == 1) {
                                moreItemsLoop = false;
                            }
                            else if (moreItemsChoice == 2) {
                                System.out.println("Okay, thank you!");
                                System.out.println("-----------------------------");
                                selectionLoop = false;
                                moreItemsLoop = false;
                                //return totalPrice;
                                
                            }
                            else {
                                System.out.println("Please choose from menu options.");
                            }
                        }   
                    }
                    chargeLoop = false;
                    break;
                case 2:
                    System.out.println("Okay, thank you!");
                    System.out.println("-----------------------------");
                    //return totalPrice;
                    //chargeLoop = false;
                    //break;
                default:
                    System.out.println("Please enter a valid selection.");
                    break;
            }
        }
        return totalPrice;
    }

    //a method for showing list of products and a subsequent calculation of the value
    protected static void ItemsMenu() {
        boolean itemsMenuExit = false;
        System.out.println("Please select the items used during your stay: ");
        ItemsCount();

        if (itemsMenuExit = false) {
            ItemsCount();
        } else {
            System.out.println("Did you use any more items");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int itemsMenuAnswer = RService.nextInt();
            switch (itemsMenuAnswer) {
                case 1:
                    ItemsCount();
                    break;
                case 2:
                    itemsMenuExit = true;
                    break;
                default:
                    System.out.println("Please select a correct option");
            }
        }
    }

    //a method for asking the name of products and the quantity
    protected static void ItemsCount() {

        boolean itemExist = true;

        DisplayProducts();
        System.out.println("Please enter the product used: ");
        int productUsed = RService.nextInt();

        if (productUsed > productList.size() || productUsed <= 0) {
            System.out.println("The product could not be found");
            itemExist = false;
        } else {
            System.out.print("Quantity: ");
            int count = RService.nextInt();
            System.out.println(CountValue(count, productList.get(productUsed -1).productPrice) + " kr is added to your bill");
        }
    }

    // a method for calculating the value
    protected static int CountValue(int quantity, int value) {
        int sum = quantity * value;
        return sum;
    }

}
