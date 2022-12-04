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

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }
    
    public Payment(String paymentID){
        this.paymentID = paymentID;
        fh = new FileHandling();
    }
    
    public String newPaymentID(){
        String newPaymentID = fh.incrementID("payment.txt");
        return "P"+newPaymentID;
    }
    
    public ArrayList readPayment(){
        ArrayList<String> paymentArray = fh.readFile("payment.txt");
        return paymentArray;
    }
    
    public void addPayment(ArrayList paymentArray){
        fh.writeFile("payment.txt", paymentArray);
    }
    
    public Boolean searchPayment(){
        String[] carArray = fh.searchRecord("payment.txt", paymentID);
        Boolean found = true;
        if (carArray.length == 0){
            found = false;
        } else{
            
        }
        return found;
    }

    public void deletePayment(){
        fh.delete("payment.txt", paymentID);
    }

}
