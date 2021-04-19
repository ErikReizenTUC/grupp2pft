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
    public static int RoomServiceCharge(){
        
        return charge;
    }
    
    //menu used for items in RoomSerivceCharge method 
    public static void RoomServiceChargeMenu() {

        boolean chargeLoop = true;
        while (chargeLoop) {

            System.out.println("Please confirm if you have used extra items during your stay: ");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int chargeMenu = RService.nextInt();

            switch (chargeMenu) {

                case 1:
                    DisplayProducts();
                    ItemsMenu();
                    break;

                case 2:
                    chargeLoop = false;
                    break;
                default:
                    System.out.println("Please enter a valid selection");
            }
        } 

    }
    //a method for showing list of products and a subsequent calculation of the value
    protected static void ItemsMenu(){
        boolean itemsMenuExit = false;
        System.out.println("Please select the items used during your stay: ");
        ItemsCount();
        
        if (itemsMenuExit = false){
        ItemsCount();
        }else {
            System.out.println("Did you use any more items");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int itemsMenuAnswer = RService.nextInt();
            switch(itemsMenuAnswer){
                case 1:
                    ItemsCount();
                        break;
                case 2:
                    itemsMenuExit = true;
                        break;
                        default:System.out.println("Please select a correct option");
            }
        }
    }
    
    //a method for asking the name of products and the quantity
    protected static void ItemsCount(){
        
        boolean itemExist = true;
        
        for (int i = 0; i < productList.size();i++){
        
        //print out the list of product names
        System.out.println(productList.get(i).productName);
        //asking for the quantity of products used    
        System.out.println("Quantity: ");
            int count = RService.nextInt();
        
        if (itemExist = true){
            System.out.println(CountValue(count, productList.get(i).productPrice) + " kr is added to your bill");}
        
        else{
            itemExist = false;
            System.out.println("The product could not be found");
            }
        }
    }
    
    // a method for calculating the value
    protected static int CountValue(int quantity, int value){
        int sum = quantity*value;
        return sum;
    }
}
