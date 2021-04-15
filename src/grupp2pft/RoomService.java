package grupp2pft;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Neetesh
 */
public class RoomService {
    //Attributes
    public String productName;
    public int productPrice;
    
    public RoomService(String productName, int productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }
    
    public static void StockRoomService(){
    }
    
    public int RoomServiceItemPrice(int number){
        return this.productPrice * number;             
    }
    
    
}
