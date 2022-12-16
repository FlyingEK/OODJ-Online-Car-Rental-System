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
    private String paymentID, bookingID, amount, date;
    private FileHandling fh;
    
    public Payment(){
        paymentID = null;
        bookingID = null;
        amount = null;
        date =null;
        fh = new FileHandling();
    }
    
    public Payment(String paymentID){
        this.paymentID = paymentID;
        fh = new FileHandling();
        searchPayment();
    }
    
    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
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

    public String getPaymentID() {
        return paymentID;
    }

    public String getBookingID() {
        return bookingID;
    }
    
    public Boolean searchPayment(){
        String[] paymentArray = fh.searchRecord("payment.txt", paymentID);
        Boolean found = true;
        if (paymentArray.length == 0){
            found = false;
        } else{
            paymentID = paymentArray[0];
            bookingID = paymentArray[1];
            amount = paymentArray[2];
            date = paymentArray[3];
        }
        return found;
    }

    public String getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public void deletePayment(){
        fh.delete("payment.txt", paymentID);
    }

}
