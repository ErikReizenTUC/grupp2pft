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
public class HotelRoom {
    //variables For HotelRooms
    public int roomNumber;
    public int NumberOfBeds;
    public int roomPrice;
    public boolean occupied;
    public boolean PaidInAdvance;
    public String occupiedBy;
    public boolean unavailable;
    public static boolean allRoomsOccupied;



    //constructor for hotelroom
    public HotelRoom(int roomNumber, int NumberOfBeds,int roomPrice, boolean occupied, boolean PaidInAdvance, String occupiedBy){
        this.roomNumber = roomNumber;
        this.NumberOfBeds = NumberOfBeds;
        this.roomPrice = roomPrice;
        this.occupied = occupied;
        this.PaidInAdvance = PaidInAdvance;
        this.occupiedBy = occupiedBy;
        this.unavailable = false;
    }


    //Creates an ArrayList of the rooms.
    static ArrayList<HotelRoom> roomList = new ArrayList<>();
        
        
    //New method to DisplayRooms for the ReceptionStaff.
    public static void DisplayAllRooms(){
        //Handling if room is empty
        if (HotelRoom.roomList.isEmpty()) {
            System.out.println("There are no rooms to display");
            System.out.println("-----------------------------");
        }
        else {
            for (int i = 0; i < HotelRoom.roomList.size(); i++){

                // prints the Hotelroom with the name of the customer occupying the room.
                if (HotelRoom.roomList.get(i).occupied == true) {
                    System.out.println("Room " + HotelRoom.roomList.get(i).roomNumber +
                                   ", Beds: " + HotelRoom.roomList.get(i).NumberOfBeds +
                                   ", Price:" + HotelRoom.roomList.get(i).roomPrice +"kr"+
                                   ", Occupied by: " + HotelRoom.roomList.get(i).occupiedBy);
                } 
                //prints the HotelRoom as unavailable
                else if (HotelRoom.roomList.get(i).unavailable == true)
                {
                    System.out.println("Room " + HotelRoom.roomList.get(i).roomNumber +
                                   ", Beds: " + HotelRoom.roomList.get(i).NumberOfBeds +
                                   ", Price:" + HotelRoom.roomList.get(i).roomPrice +"kr"+
                                   ", Room unavailable.");
                }
                // prints the Hotelroom without a name for the customer occupying the room.
                else {
                    System.out.println("Room " + HotelRoom.roomList.get(i).roomNumber +
                                   ", Beds: " + HotelRoom.roomList.get(i).NumberOfBeds +
                                   ", Price:" + HotelRoom.roomList.get(i).roomPrice +"kr"+
                                   ", Available!");
                }

            }
        }      
    }

    //New method to DisplayRooms for the Customer.
    public static void DisplayAvailableRooms(){
        //Handling if room is empty
        if (HotelRoom.roomList.isEmpty() || AllRoomsOccupied() == true) {
            System.out.println("Apologies, there are no available rooms");
        }
        else {
            //printing only available rooms
            for (int i = 0; i < HotelRoom.roomList.size(); i++){
                if (HotelRoom.roomList.get(i).occupied == false
                        && HotelRoom.roomList.get(i).unavailable == false){
                    System.out.println("Room " + HotelRoom.roomList.get(i).roomNumber +
                                   ", Beds: " + HotelRoom.roomList.get(i).NumberOfBeds +
                                   ", Price:" + HotelRoom.roomList.get(i).roomPrice +"kr"+
                                   ", Available!");
                }
            }
        }

    }
    //checking if all rooms are occupied
    public static boolean AllRoomsOccupied() {
        //count checking how many rooms are occupied
        int count = 0;
        //loop adding 1 to count for every occupied room
        for (int i = 0; i < HotelRoom.roomList.size(); i++) {
            if (HotelRoom.roomList.get(i).occupied == true) {
                count++;
            }
        }
        //comparing count to the number of rooms. if they are equal, all rooms are occupied
        if (count == HotelRoom.roomList.size()) {
            return allRoomsOccupied = true;
        }
        else return allRoomsOccupied = false;
        
    }
        
}
