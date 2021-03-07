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
public class ReceptionStaff {
    
    
    //Denna klass är just nu överflödig, vi avvaktar med kod här och skriver 
    // i HotelStaff-classen istället!
    
    Scanner RecInput = new Scanner (System.in);
    
    //attributes for the receptionist
    public String firstName;
    public String lastName;
    public int iD;
    
    //contructor
    public void Receptionist (String firstName, String lastName, int iD) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.iD = iD;
    }
    
    public void MainMenuRec(){
            System.out.println("[a] Check for available rooms");
            System.out.println("[b] Create a new available room");
            System.out.println("[c] Mark a room unavailable");
            System.out.println("[d] Delete a room");
            System.out.println("[e] Find customer info");
            System.out.println("[f] Checkout bill");
    }
    //an arraylist to save the data for receptionist users
    static ArrayList<ReceptionStaff> recStaff = new ArrayList<>();
    
        
    public void AddRoom (HotelRoom room){
        //ask the receptionist to verify its user ID for further access
        System.out.println("Please enter your work ID: ");
        int recID = RecInput.nextInt();
        
        // a conditional sentence to give access to the right staff
        if (recID < 10 && recID != 0 ){
            System.out.println("Access Authorized");
            System.out.println("-------------------------------");
            System.out.println("Choose one of the following: \n");
            System.out.println("--------------------------------");
            MainMenuRec();
        
        
        } else {
            System.out.println("Access Denied");
            
        }
        
    }
}
