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
    //variables
        private int roomNumber;
        private int NumberOfBeds;
        private int roomPrice;
        private boolean occupied;
    
    public static void DisplayRooms(){
        Scanner scan = new Scanner(System.in);
        

        String newRoom;
        
        //Creates an ArrayList of the rooms.
        ArrayList roomList = new ArrayList();
        roomList.add("Room 1");
        roomList.add("Room 2");
        roomList.add("Room 3");
        roomList.add("Room 4");
        roomList.add("Room 5");
        //Prints out the list of avaiable rooms.
        System.out.println("Avaiable rooms: " + roomList);
        
        
        //Lets the user create a new room and prints the list again.
        System.out.println("Set number for the new room: ");
        newRoom = scan.nextLine();
        roomList.add(newRoom);
        System.out.println("Avaiable rooms: " + roomList);
        
    }

}
