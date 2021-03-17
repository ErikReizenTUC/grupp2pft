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
public class ReceptionStaff  {
    
    
    //Denna klass är just nu överflödig, vi avvaktar med kod här och skriver 
    // i HotelStaff-classen istället!
    
    static Scanner RecInput = new Scanner (System.in);
    
    //an instance of Customer class for checkin method
    //Customer checkIn = new Customer();
    
    //attributes for the receptionist
    public String firstName;
    public String lastName;
    public int iD;
    public boolean exit;
    public char recMenuVal;
    
    //contructor
    public ReceptionStaff (String firstName, String lastName, int iD) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.iD = iD;
    }
    
    
        
    


    //main menu for receptionist user 
    //this could be defined and modified on demand
    private static void MainMenuRec(){
            System.out.println("1. Check-in");
            System.out.println("2. Check-out");
            System.out.println("3. Check for available rooms");
            System.out.println("4. Create a new available room");
            System.out.println("5. Delete a room");
            System.out.println("6. Back to main menu");
    }
    
    //1st sub menu for receptionist
    private static void SubMneuRec (){
        System.out.println("Choose one of the following: \n");
        System.out.println("--------------------------------");
    }
    //a method for creating a new available room
    private static void AddRoom (){
        
        
        System.out.println("Room number: ");
        int newRoomNumber = RecInput.nextInt();
        System.out.println("Number of beds: ");
        int newNumberBeds = RecInput.nextInt();
        System.out.println("Room price: ");
        int newRoomPrice = RecInput.nextInt();
        System.out.println("Initials: ");
        String newName = RecInput.next();
        HotelRoom.roomList.add(new HotelRoom(newRoomNumber, newNumberBeds, newRoomPrice, false, true, newName));
        System.out.println("Room added");
    }
    
    //a method to search for a given room in the list and remove it 
    private static void DelRoom (){
        
        System.out.println("Here is a list of rooms: \n");
        //call the method for showing a list of all rooms
        HotelRoom.DisplayRooms();
        System.out.println("-----------------------------");
        System.out.println("Room number: ");
        //get the user's input
        int delRoomNumber = RecInput.nextInt();
        //loop through the room list to find whether the room number matches one of the rooms
        //and delete the one asked by the user
        boolean roomNumberExist = false;
        for (int i = 1; i < HotelRoom.roomList.size(); i++){
            
            if (delRoomNumber == HotelRoom.roomList.get(i).roomNumber){
                roomNumberExist = true;
                HotelRoom.roomList.remove(i);
                System.out.println("The room number " + delRoomNumber + " is deleted");
            } 
            
        }
        if(roomNumberExist == false) {
                
            System.out.println("The room number you entered is invalid");
        }
        roomNumberExist = false;
    }
   //this is the main method for accessing the receptionists options     
    public static void RecAccess (){
        
        boolean exit = false;
        //a do-while loop for performing different menus and exiting using the boolean
        do{
                
            //asking the receptionist to enter 
                System.out.println("First Name: ");
                String recFName = RecInput.next();
                System.out.println("Last Name: ");
                String recLName = RecInput.next();
                System.out.println("Work ID: ");
                int recId = RecInput.nextInt();
                
                //saving the users input
                ReceptionStaff receptionist = new ReceptionStaff(recFName, recLName, recId);
                
                   
        //if statement for euther accessing  the main menu or being redirected to the user 
        //selection menu
          
        if (recId > 0 && recId < 10){
        
            System.out.println("Access Authorized");
            System.out.println("-------------------------------");
        
            System.out.println("Welcome " + receptionist.firstName + " " + receptionist.lastName);
            System.out.println("------------------------------------------------ \n");
            
            SubMneuRec();
            MainMenuRec();
            int recVal = RecInput.nextInt();
            
            //a switch case to perform differnt tasks related to a receptionist
            switch(recVal){
                case 1:
                       HotelMain.CheckIn();
                    break;
                    
                case 2:
                        HotelMain.CheckOut();
                    break;
                    
                case 3:
                        HotelRoom.DisplayRooms();
                    break;
                    
                case 4:
                        AddRoom();
                    break;
                    
                case 5:
                        DelRoom();
                    break;
                    
                case 6:
                        exit = true;
                    break;
                
            
            }
        }
            else { 
                    
            System.out.println("Access Denied \nPlease try again");
            SubMneuRec();
            
        }
        
    }while(!exit);
}

    public static void Cleaning() {  
        
        System.out.println("The room has been cleaned!");
  
    }
}
