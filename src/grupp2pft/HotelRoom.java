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
        public String occupiedBy;



        //constructor
        //Creates new method for hotelroom
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
        
        
    //New method to DsiplayRooms.
    public static void DisplayRooms(){
                //Instanciate HotelRoom bojects
        HotelRoom.roomList.add(new HotelRoom(1, 4, 500, true, false, "Adam Bertilsson"));
        HotelRoom.roomList.add(new HotelRoom(2, 3, 600, false, false, "Ceaser Davidsson"));
        HotelRoom.roomList.add(new HotelRoom(3, 2, 700, true, false, "Erik Fredriksson"));
        HotelRoom.roomList.add(new HotelRoom(4, 2, 800, false, false, "Gustaf Haraldsson"));
        HotelRoom.roomList.add(new HotelRoom(5, 1, 900, false, false, "Ivar Jacobsson"));
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

        
        
}
