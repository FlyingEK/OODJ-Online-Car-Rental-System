/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinecarrentalsystem;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Payment {
    private String paymentID;
    private FileHandling fh;
    
    public Payment(){
        this.paymentID = null;
        fh = new FileHandling();
    }
    
    public Payment(String paymentID){
        this.paymentID = paymentID;
        fh = new FileHandling();
    }
    
    public ArrayList readPayment(){
        ArrayList<String> paymentArray = fh.readFile("payment.txt");
        return paymentArray;
    }
    
    public void addPayment(ArrayList paymentArray){
        fh.writeFile("payment.txt", paymentArray);
    }
    
    public String[] searchPayment(){
        String[] paymentArray = fh.searchRecord("payment.txt", paymentID);
        return paymentArray;
    }

    public void deletePayment(){
        fh.delete("payment.txt", paymentID);
    }

}
