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
 * @author Neetesh
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
        RoomService rs =new RoomService("Coke", 20);
        int number = 2;
        int expResult = 40;
        int result = rs.RoomServiceItemPrice(number);
        assertEquals(expResult, result);
        
        RoomService rs1 =new RoomService("Pepsi", 15);
        number = 4;
        expResult = 80;
        result = rs1.RoomServiceItemPrice(number);
        assertNotEquals(expResult, result);
        
        RoomService rs2 =new RoomService("Fanta", 18);
        number = 2;
        expResult = 40;
        result = rs2.RoomServiceItemPrice(number);
        assertNotEquals(expResult, result);
        
    }
    
}
