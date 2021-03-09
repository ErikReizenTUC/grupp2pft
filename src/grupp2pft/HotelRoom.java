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
    //variables For HotelRooms
        public int roomNumber;
        public int NumberOfBeds;
        public int roomPrice;
        public boolean occupied;
        public boolean PaidInAdvance;
        public String occupiedBy;



        //constructor for hotelroom
        public HotelRoom(int roomNumber, int NumberOfBeds,int roomPrice, boolean occupied, boolean PaidInAdvance, String occupiedBy){
            
        this.roomNumber = roomNumber;
        this.NumberOfBeds = NumberOfBeds;
        this.roomPrice = roomPrice;
        this.occupied = occupied;
        this.PaidInAdvance = PaidInAdvance;
        this.occupiedBy = occupiedBy;
        }

                
        //Creates an ArrayList of the rooms.
        static ArrayList<HotelRoom> roomList = new ArrayList<>();
        
        
    //New method to DisplayRooms for the ReceptionStaff.
    public static void DisplayRooms(){
            
        for (int i = 0; i < HotelRoom.roomList.size(); i++){
           
            // prints the Hotelroom with the name of the customer occupying the room.
            if (HotelRoom.roomList.get(i).occupied == true) {
                System.out.println("Room " + HotelRoom.roomList.get(i).roomNumber +
                               ", Beds: " + HotelRoom.roomList.get(i).NumberOfBeds +
                               ", Price:" + HotelRoom.roomList.get(i).roomPrice +"kr"+
                               ", Occupied by: " + HotelRoom.roomList.get(i).occupiedBy);
            } 
            // prints the Hotelroom without a name for the customer occupying the room.
            else {
                System.out.println("Room " + HotelRoom.roomList.get(i).roomNumber +
                               ", Beds: " + HotelRoom.roomList.get(i).NumberOfBeds +
                               ", Price:" + HotelRoom.roomList.get(i).roomPrice +"kr"+
                               ", Avaiable!");
            }
                
        }
        
    }

        //New method to DisplayRooms for the Customer.
    public static void DisplayRoomsCustomer(){
        
        for (int i = 0; i < HotelRoom.roomList.size(); i++){
            System.out.println("Room " + HotelRoom.roomList.get(i).roomNumber +
                               ", Beds: " + HotelRoom.roomList.get(i).NumberOfBeds +
                               ", Price:" + HotelRoom.roomList.get(i).roomPrice +"kr"+
                               ", Avaiable!");
        }
    }
        
}
