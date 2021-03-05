/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp2pft;

import java.util.ArrayList;

/**
 *
 * @author stefa
 */
public class HotelRoom{
    //variables
        public int roomNumber;
        public int NumberOfBeds;
        public int roomPrice;
        public boolean occupied;
        public boolean PaidInAdvance;




        //Creates new method for hotelroom
        public HotelRoom(int roomNumber, int NumberOfBeds,int roomPrice, boolean occupied, boolean PaidInAdvance){
            
        //constructor
        this.roomNumber = roomNumber;
        this.NumberOfBeds = NumberOfBeds;
        this.roomPrice = roomPrice;
        this.occupied = occupied;
        this.PaidInAdvance = PaidInAdvance;
        }

                
        //Creates an ArrayList of the rooms.
        static ArrayList roomList = new ArrayList();
        
        
    //New method to DsiplayRooms.
    public static void DisplayRooms(){
        for (Object i: roomList){
            System.out.println(HotelRoom.roomList.get((int) i));
            
        }
        
    }

        
        
}
