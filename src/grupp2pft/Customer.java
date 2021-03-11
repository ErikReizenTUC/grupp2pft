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
 * @author Group 2
 */
public class Customer {
    //attributes for customers
    public String firstName;
    public String lastName;
    
    //constructor
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    //arraylist for customer objects
    static ArrayList<Customer> customerList = new ArrayList<>();
}
