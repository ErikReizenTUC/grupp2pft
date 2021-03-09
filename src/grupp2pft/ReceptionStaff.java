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
    Customer checkIn = new Customer();
    
    //attributes for the receptionist
    public String firstName;
    public String lastName;
    public int iD;
    public boolean exit;
    
    //contructor
    public ReceptionStaff (String firstName, String lastName, int iD) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.iD = iD;
    }
    //main menu for receptionist user 
    //this could be defined and modified on demand
    public void MainMenuRec(){
            System.out.println("[a] Check for available rooms");
            System.out.println("[b] Create a new available room");
            System.out.println("[c] Mark a room unavailable");
            System.out.println("[d] Delete a room");
            System.out.println("[e] Find customer info");
            System.out.println("[f] Checkin");
            System.out.println("[g] Add extra");
            System.out.println("[h] Checkout bill");
            System.out.println("[i] Back to main menu");
    }
    
    //1st sub menu for receptionist
    public void SubMneuRec (){
        System.out.println("Access Authorized");
        System.out.println("-------------------------------");
        System.out.println("Choose one of the following: \n");
        System.out.println("--------------------------------");
    }
    //an arraylist to save the data for receptionist users
    static ArrayList<ReceptionStaff> recStaff = new ArrayList<>();
    
        
    public void Access (){
        //ask the receptionist to verify its user ID for further access
        
        boolean exit = false;
        do{
        
            System.out.println("Please enter your work ID: ");
            int recID = RecInput.nextInt();
                    
        //if statement for euther accessing  the main menu or being redirected to the user 
        //selection menu
          
        if (recID > 0 && recID < 10){
            
            SubMneuRec();
            MainMenuRec();
            int recVal = RecInput.nextInt();
            
            //a switch case to perform differnt tasks related to a receptionist
            switch(recVal){
                case 1:
                    for (int i = 0; i < HotelRoom.roomList.size();i++) 
        	      { 		      
	          System.out.println(HotelRoom.roomList.get(i)); 		
                      }   
                    break;
                    
                case 2:
                    System.out.println("Room number: ");
                    int newRoomNumber = RecInput.nextInt();
                    System.out.println("Number of beds: ");
                    int newNumberBeds = RecInput.nextInt();
                    System.out.println("Room price: ");
                    int newRoomPrice = RecInput.nextInt();
                    System.out.println("Name: ");
                    String newName = RecInput.next();
                    HotelRoom.roomList.add(new HotelRoom(newRoomNumber, newNumberBeds, newRoomPrice, false, true, newName));
                    break;
                case 3:
                    
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
            
            
            }
        }
            else { 
                    
            System.out.println("Access Denied");
            exit = true;
            
        }
        
    }while(!exit);
}
}