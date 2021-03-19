/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp2pft;


import java.util.Scanner;

/**
 *
 * @author stefa
 */
public class ReceptionStaff  {
    
    
    static Scanner RecInput = new Scanner (System.in);
    
    
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
    
    
    //No arraylist for receptionstaff as we never need to call an object from the class  
    


    //main menu for receptionist user 
    private static void MainMenuRec(){
        System.out.println("Choose one of the following:");
        System.out.println("-----------------------------");
        System.out.println("1. Check-in");
        System.out.println("2. Check-out");
        System.out.println("3. Check for available rooms");
        System.out.println("4. Create a new available room");
        System.out.println("5. Delete a room");
        System.out.println("6. Back to main menu");
        System.out.println("-----------------------------");
    }
    
    //a method for creating a new available room
    private static void AddRoom (){
        boolean addRoomLoop = true;
        //loop for addroom process
        while (addRoomLoop) {
            //try/catch for adding room
            try {
                //user inputs room number
                System.out.print("Room number: ");
                boolean roomNumberDuplicate = false;
                int newRoomNumber = RecInput.nextInt();
                //loop checks if roomnumber matches already existing room numbers
                for (int i = 0; i < HotelRoom.roomList.size(); i++) {
                    if (newRoomNumber == HotelRoom.roomList.get(i).roomNumber) {
                        roomNumberDuplicate = true;
                    }
                }
                //if room number already exists, asks user for new input
                if (roomNumberDuplicate) {
                    System.out.println("Room number must be unique, try again!");
                    System.out.println("-----------------------------");
                }
                else {
                    System.out.print("Number of beds: ");
                    int newNumberBeds = RecInput.nextInt();

                    System.out.print("Room price: ");
                    int newRoomPrice = RecInput.nextInt();
                    
                    //new  HotelRoom object is created
                    HotelRoom.roomList.add(new HotelRoom(newRoomNumber, newNumberBeds, newRoomPrice, false, true, ""));
                    System.out.println("Room added");
                    
                    //breaking loop to exit addroom
                    addRoomLoop = false;
                }
                    
            }
            catch (Exception InputMismatchException) {
                //handling if user input is not integer
                System.out.println("Please enter a number");
                System.out.println("-----------------------------");

                //cleaning scanner
                RecInput.next();
            } 
        }

            
    }
    
    //a method to search for a given room in the list and remove it 
    private static void DelRoom (){
        boolean DelRoomLoop = true;
        //loop for delete room process
        while (DelRoomLoop) {
            //checking if there are rooms to delete
            if (HotelRoom.roomList.isEmpty() || HotelRoom.AllRoomsOccupied() == true) {
                System.out.println("Apologies, there are no available rooms!");
                DelRoomLoop = false;
            } 
            else {
                System.out.println("Here is a list of rooms:");
                //call the method for showing a list of all rooms
                HotelRoom.DisplayRooms();
                System.out.println("-----------------------------");
                System.out.print("Room number: ");
                //try/catch for delete room input
                try {
                    //get the user's input
                    int delRoomNumber = RecInput.nextInt();
                    //loop through the room list to find whether the room number matches one of the rooms
                    //and delete the one asked by the user
                    boolean roomNumberExist = false;
                    for (int i = 0; i < HotelRoom.roomList.size(); i++){

                        if (delRoomNumber == HotelRoom.roomList.get(i).roomNumber && HotelRoom.roomList.get(i).occupied == false){
                            roomNumberExist = true;
                            //room is deleted
                            HotelRoom.roomList.remove(i);
                            System.out.println("The room number " + delRoomNumber + " is deleted");
                            System.out.println("-----------------------------");
                            //breaking loop to exit process
                            DelRoomLoop = false;
                        } 

                    }
                    if(roomNumberExist == false) {
                        //handling if user inputs incorrect room number
                        System.out.println("The room number you entered is invalid");
                        System.out.println("-----------------------------");
                    }
                }
                catch (Exception InputMismatchException) {
                    //handling if user input is not integer
                    System.out.println("Please enter a number");
                    System.out.println("-----------------------------");

                    //Cleaning scanner
                    RecInput.next();
                }
            }
        }
        
        
        
    }
   //this is the main method for accessing the receptionists options     
    public static void RecAccess (){
        
        boolean exit = false;
        
        //try/catch for user input
        try {
            //asking the receptionist to enter first name 
            System.out.print("First Name: ");
            //checking that input is only letters, english only
            while (!RecInput.hasNext("[A-Za-z]+")) {
                System.out.println("Invalid input!");
                System.out.print("First Name: ");
                RecInput.next();
            }
            String recFName = RecInput.next();
            
            //user inputs last name
            System.out.print("Last Name: ");
            //chgecking that input is only letters, english only
            while (!RecInput.hasNext("[A-Za-z]+")) {
                System.out.println("Invalid input!");
                System.out.print("Last Name: ");
                RecInput.next();
            }
            //asking user to input work id, has to be between 1 and 9 to be authorized
            String recLName = RecInput.next();
            System.out.print("Work ID: ");
            int recId = RecInput.nextInt();

            //saving the users input, creating new receptionstaff object
            ReceptionStaff receptionist = new ReceptionStaff(recFName, recLName, recId);

            //a do-while loop for performing different menus and exiting using the boolean
            do{         

                //if statement for either accessing  the main menu or being redirected to the user 
                //selection menu
                if (recId > 0 && recId < 10){
                    
                    System.out.println("-----------------------------");
                    System.out.println("Access Authorized");
                    System.out.println("-----------------------------");

                    System.out.println("Welcome " + receptionist.firstName + " " + receptionist.lastName);
                    System.out.println("-----------------------------");
                    
                    //calling method to display menu options to user
                    MainMenuRec();
                    //try/catch for switch case input
                    try {
                        System.out.print("Make selection: ");
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
                                    System.out.println("Returning to main menu");
                                    System.out.println("-----------------------------");
                                    exit = true;
                                break;
                            
                            default:
                                System.out.println("Input does not match menu options");
                                break;

                        }
                    }
                    catch (Exception InputMismatchException) {
                        //handling if input is not integer
                        System.out.println("Please enter a number");
                        System.out.println("-----------------------------");
                        
                        //Cleaning scanner
                        RecInput.next();
                    }

                }
                //if id is not valid, asking user for new input
                else { 
                    System.out.println("Access Denied \nPlease try again");
                    System.out.println("-----------------------------");
                    exit = true;
                }

            }while(!exit);
        }
        catch (Exception InputMismatchException) {
            //handling if input is not integer
            System.out.println("Please enter a number");
            System.out.println("-----------------------------");
            
            //Cleaning scanner
            RecInput.next();
        }

    }
    
    //calling after checkout is completed
    public static void Cleaning() {  
        
        System.out.println("The room has been cleaned!");
  
    }
}
