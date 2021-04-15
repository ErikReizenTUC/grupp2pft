package grupp2pft;

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
    public int RoomServiceItemPrice(int number){
        return this.productPrice * number;             
    }
    
    
}
