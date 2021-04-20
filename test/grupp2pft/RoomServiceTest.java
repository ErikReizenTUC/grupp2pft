/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp2pft;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Group 2
 */
public class RoomServiceTest {
    
    public RoomServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Setup class");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Tear down class");
    }
    
    @Before
    public void setUp() {
        System.out.println("Setup");
    }
    
    @After
    public void tearDown() {
        System.out.println("Tear down");
    }

   

    /**
     * Test of RoomServiceItemPrice method, of class RoomService.
     */
    @Test
    public void testRoomServiceItemPrice() {
        System.out.println("RoomServiceItemPrice");
        //Creating a new instance of RoomService
        //Customer used Coke
        RoomService drinkServiceCoke = new RoomService("Coke", 20);
        int number = 2;
        int expResult = 40;
        int result = drinkServiceCoke.RoomServiceItemPrice(number);
        //Test for if expected result and actual result are equal
        assertEquals(expResult, result);

        //Creating a new instance of RoomService
        //Customer used Pepsi
        RoomService drinkServicePepsi = new RoomService("Pepsi", 15);
        number = 4;
        expResult = 80;
        result = drinkServicePepsi.RoomServiceItemPrice(number);
        //Test for if expected result and actual result are not equal
        assertNotEquals(expResult, result);

        //Creating a new instance of RoomService
        //Customer used Fanta
        RoomService drinkServiceFanta = new RoomService("Fanta", 18);
        number = 2;
        expResult = 36;
        result = drinkServiceFanta.RoomServiceItemPrice(number);
        //Test for if expected result and actual result are equal
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of IsProductListEmpty method, of class RoomService.
     */
    @Test
    public void testIsProductListEmpty() {
        System.out.println("IsProductListEmpty");
        //checks for empty list
        assertTrue(RoomService.IsProductListEmpty());
        
        //creates objects so list has items
        RoomService.productList.add(new RoomService("Coke", 20));
        RoomService.productList.add(new RoomService("Pepsi", 15));
        RoomService.productList.add(new RoomService("Fanta", 18));
        
        //checks for list with items
        assertFalse(RoomService.IsProductListEmpty());
        
    }
    
    /**
     * Test of DisplayProducts method, of class RoomService.
     */
    @Test
    public void testDisplayProducts(){
        System.out.println("DisplayProducts");
        
        //creates objects for use in test
        RoomService.productList.add(new RoomService("Coke", 20));
        RoomService.productList.add(new RoomService("Pepsi", 15));
        RoomService.productList.add(new RoomService("Fanta", 18));
        
        //expects that the result should be equal to the size of the arraylist
        int expResult = RoomService.productList.size();
        int Result = RoomService.DisplayProducts();
        
        //checks whether the size of the list matches return value from method
        assertEquals(expResult, Result);
        
        //expects that the result should be equal to the size of the arraylist + 1
        expResult = RoomService.productList.size() + 1;
        Result = RoomService.DisplayProducts();
        
        //checks if the two values do not match
        assertNotEquals(expResult, Result);
    }
    
    //for a method that is currently not in use
     /*
    @Test
    public void testCountValue(){
        System.out.println("Count Value Test");
        int testSum = RoomService.CountValue(3, 18);
        assertEquals(54, testSum);
    }
    */
}
