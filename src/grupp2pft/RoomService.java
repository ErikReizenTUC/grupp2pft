package grupp2pft;

import java.util.ArrayList;

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
}
