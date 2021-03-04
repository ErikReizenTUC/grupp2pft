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
 * @author stefa
 */
public class HotelRoom extends HotelMain{
    

    
    public static void Rooms(){
        Scanner scan = new Scanner(System.in);
        
        String newRoom;
        
        ArrayList roomList = new ArrayList();
  
        roomList.add("Room 1");
        roomList.add("Room 2");
        roomList.add("Room 3");
        roomList.add("Room 4");
        roomList.add("Room 5");
        
        System.out.println("Avaiable rooms: " + roomList);
        
        System.out.println("Name the new room: ");
        newRoom = scan.nextLine();
        roomList.add(newRoom);
        System.out.println("Avaiable rooms: " + roomList);
        
    }

}
