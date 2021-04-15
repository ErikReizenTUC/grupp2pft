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
        RoomService drinkServiceCoke =new RoomService("Coke", 20);
        int number = 2;
        int expResult = 40;
        int result = drinkServiceCoke.RoomServiceItemPrice(number);
        //Test for if expected result and actual result are equal
        assertEquals(expResult, result);
        
        //Creating a new instance of RoomService
        //Customer used Pepsi
        RoomService drinkServicePepsi =new RoomService("Pepsi", 15);
        number = 4;
        expResult = 80;
        result = drinkServicePepsi.RoomServiceItemPrice(number);
        //Test for if expected result and actual result are not equal
        assertNotEquals(expResult, result);
        
        //Creating a new instance of RoomService
        //Customer used Fanta
        RoomService drinkServiceFanta =new RoomService("Fanta", 18);
        number = 2;
        expResult = 36;
        result = drinkServiceFanta.RoomServiceItemPrice(number);
        //Test for if expected result and actual result are equal
        assertEquals(expResult, result);
        
    }
    
}
