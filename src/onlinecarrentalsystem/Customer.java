/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinecarrentalsystem;

import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Customer extends User{
    protected String customerID;
    private String customerUsername,customerName,customerPassword,
            customerAddress,customerEmail,customerContact,customerIC,
            currentCustomer;
    private FileHandling fh;
    private ActivityLog a;
    
    
    public Customer(){
        this.customerID = null;
        fh = new FileHandling();
        a = new ActivityLog();
    }
    
    public Customer(String customerID){
        this.customerID = customerID;
        fh = new FileHandling();
        a = new ActivityLog();
    }
    
    //getter
    public String getCustomerID() {return customerID;}
    
    public String getCustomerUsername() {return customerUsername;}
    
    public String getCustomerName(){return customerName;}
    
    public String getCustomerPassword(){return customerPassword;}
    
    public String getCustomerAddress(){return customerAddress;}
    
    public String getCustomerEmail(){return customerEmail;}
    
    public String getCustomerContact(){return customerContact;}
    
    public String getCustomerIC(){return customerIC;}
    
    public String getCurrentCustomer(){return currentCustomer;}
    
    //setter
    public void setCustomerID(String customerID) {this.customerID = customerID;}
    
    public void setCustomerUsername(String customerUsername) {this.customerUsername = customerUsername;}
    
    public void setCustomerName(String customerName) {this.customerName = customerName;}
    
    public void setCustomerPassword(String customerPassword) {this.customerPassword = customerPassword;}
    
    public void setCustomerAddress(String customerAddress) {this.customerAddress = customerAddress;}
    
    public void setCustomerEmail(String customerEmail) {this.customerEmail = customerEmail;}
    
    public void setCustomerContact(String customerContact) {this.customerContact = customerContact;}
    
    public void setCustomerIC(String customerIC) {this.customerIC = customerIC;}
    
    //login funstion
    public Boolean login(String username,String password){
        
        String customerID = "";
        boolean found = false;
        String activity = "failed login";
        
        ArrayList<String> file = new ArrayList<String>();
        file = fh.readFile("customer.txt");
        
        for(String line : file){
            String[] detail = line.split(";");
            
            if (detail[1].equals(username) && detail[2].equals(password))
            {
                found = true;
                customerID = detail[0];
                fh.setCurrentCustomer(detail[0]);
                activity = "successful login";
                break;
            }
        } 
        if (found){
            JOptionPane.showMessageDialog(null, "Login Success! Welcome to our car rental system!");
            a.addActivityLog( "Customer", customerID, username, activity);
        }else{
            JOptionPane.showMessageDialog(null, "Login failed, please try again.","Error Message",JOptionPane.ERROR_MESSAGE);
            a.addActivityLog( "Customer", customerID, username, activity);
        }
        return found;
    }
    
    public Boolean Register(String[] customerDetail){

        boolean registered = false;
        
        String joinDetail = String.join(";", customerDetail);
        String newCustomerID ="M" + fh.incrementID("customer.txt");
        joinDetail = newCustomerID + ";" + joinDetail;
        
        ArrayList<String> newCustomer = new ArrayList<String>();
        newCustomer.add(joinDetail);
        
        fh.writeFile("customer.txt", newCustomer);
        
        if(fh.searchRecord("customer.txt",newCustomerID)[0].equals(newCustomerID)){
            registered = true;
            JOptionPane.showMessageDialog(null, "Register Success! Please login to access the system.");
        }else{
            JOptionPane.showMessageDialog(null, "Register Failed, please try again.","Error Message",JOptionPane.ERROR_MESSAGE);
        }
    
        return registered;
    }
    
    public void logout(){
        fh.setCurrentCustomer(null);
        // jump to starting page
    }
            
}


