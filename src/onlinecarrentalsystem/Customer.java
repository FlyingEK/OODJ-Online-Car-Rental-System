/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinecarrentalsystem;

/**
 *
 * @author User
 */
public class Customer extends User{
    protected String customerID;
    private String customerUsername,customerName,customerPassword,
            customerAddress,customerEmail,customerContact,customerIC;
    
    
    public Customer(){
        User u = new User("username");
    }
}


