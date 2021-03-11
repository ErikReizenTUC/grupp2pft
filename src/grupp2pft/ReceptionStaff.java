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
    
    Scanner RecInput = new Scanner (System.in);
    
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
    
    
        
    //list of receptionists
    //static int [] recID = {1,2,3,4,5,6,7,8,9};
    


    //main menu for receptionist user 
    //this could be defined and modified on demand
    public void MainMenuRec(){
            System.out.println("1. Check-in");
            System.out.println("2. Check-out");
            System.out.println("3. Check for available rooms");
            System.out.println("4. Create a new available room");
            System.out.println("5. Delete a room");
            System.out.println("6. Back to main menu");
    }
    
    //1st sub menu for receptionist
    public void SubMneuRec (){
        System.out.println("Access Authorized");
        System.out.println("-------------------------------");
        System.out.println("Choose one of the following: \n");
        System.out.println("--------------------------------");
    }
    
    public void AddRoom (){
        
        
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
    public void DelRoom (){
        
        System.out.println("Here is a list of rooms: \n");
        HotelRoom.DisplayRooms();
        System.out.println("-----------------------------");
        System.out.println("Room number: ");
        //get the user's input
        int delRoomNumber = RecInput.nextInt();
        
        for (int i = 1; i < HotelRoom.roomList.size(); i++){
            
            if (delRoomNumber == HotelRoom.roomList.get(i).roomNumber){
                HotelRoom.roomList.remove(delRoomNumber);
                System.out.println("The room number " + delRoomNumber + " is deleted");
            } else { 
            System.out.println("The room number you entered is invalid");
            }
            
        }
        /*
        for (delRoomNumber = 0; delRoomNumber < HotelRoom.roomList.size(); delRoomNumber++)
        
            if (HotelRoom.roomList.contains(delRoomNumber)){
                HotelRoom.roomList.remove(delRoomNumber);
                System.out.println("The room number " + delRoomNumber + " is deleted");
            } else { 
            System.out.println("The room number you entered is invalid");
            }
        //boolean finns = HotelRoom.roomList.contains(oldRoomNumber);
        
       // if (!finns)
         //   System.out.println("The room number you entered is invalid");
        //else 
          //  HotelRoom.roomList.remove(oldRoomNumber);
            //System.out.println("The room is to be deleted");
            

        //find the exact index of the asked room number
        //int delRoom = HotelRoom.roomList.indexOf(oldRoomNumber);
        // an if statement to check if the room number exists
          //  if (delRoom == -1)
            //    System.out.println("The room number yu entered is invalid");
            //else
              //  HotelRoom.roomList.remove(delRoom);
                //System.out.println("The room is to be deleted");
            */
    
    }
    //an arraylist to save the data for receptionist users
    static ArrayList<ReceptionStaff> recStaff = new ArrayList<>();
    
    //a method for greeting any registered receptionist 
    public void GreetingsRec (){
        for (int i = 0; i < ReceptionStaff.recStaff.size(); i++){
            if (ReceptionStaff.recStaff.get(i).iD == 1)
                System.out.println("Welcome " + ReceptionStaff.recStaff.get(i).firstName +
                        " " + ReceptionStaff.recStaff.get(i).lastName);
            else if (ReceptionStaff.recStaff.get(i).iD == 3)
                System.out.println("Welcome " + ReceptionStaff.recStaff.get(i).firstName +
                        " " + ReceptionStaff.recStaff.get(i).lastName);
            else if (ReceptionStaff.recStaff.get(i).iD == 7)
                System.out.println("Welcome " + ReceptionStaff.recStaff.get(i).firstName +
                        " " + ReceptionStaff.recStaff.get(i).lastName);
            else 
                System.out.println("User not found");
        }
            
        
    }
    
        
    public void Access (){
        //ask the receptionist to verify its user ID for further access
        
        boolean exit = false;
        do{
        
            System.out.println("Please enter your work ID: ");
            int recID = RecInput.nextInt();
            GreetingsRec();        
        //if statement for euther accessing  the main menu or being redirected to the user 
        //selection menu
          
        if (recID > 0 && recID < 10){
            
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

                    //for (int i = 0; i < HotelRoom.roomList.size();i++) 
        	      //{ 		      
	          //System.out.println(HotelRoom.roomList.get(i)); 		
                    //  }
                    break;
                    
                    
                case 4:
                    AddRoom();
                    break;
                    
                case 5:
                    DelRoom();
                    break;
                    
                    
                case 6:
                    break;
                
            
            }
        }
            else { 
                    
            System.out.println("Access Denied \nPlease try again");
            SubMneuRec();
            
        }
        
    }while(!exit);
}
}