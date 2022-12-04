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
public class Booking {
    private String bookingID, carID, customerID, outDate, returnDate;
    private FileHandling fh;
    private Customer cust;
    
    public Booking(){
        this.bookingID = null;
        fh = new FileHandling();
    }
    
    public Booking(String bookingID){
        this.bookingID = bookingID;
        fh = new FileHandling();
        searchBooking();
    }
    
    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }
    public ArrayList readBooking(){
        ArrayList<String> bookingArray = fh.readFile("booking.txt");
        return bookingArray;
    }
    
    public void addBooking(ArrayList bookingArray){
        fh.writeFile("booking.txt", bookingArray);
    }
    
    public Boolean searchBooking(){
        String[] bookingArray = fh.searchRecord("booking.txt", bookingID);
        Boolean found = true;
        if (bookingArray.length == 0){
            found = false;
        } else{
            bookingID = bookingArray[0];
            carID = bookingArray[1];
            customerID = bookingArray[2];
            outDate = bookingArray[3];
            returnDate = bookingArray[4];
        }
        return found;
    }

    public String getCarID() {
        return carID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getOutDate() {
        return outDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public Customer getCust() {
        return cust;
    }
    
     public void modifyBooking(ArrayList<String> bookingArray){
        fh.modifyRecord("booking.txt",bookingArray);
    }

    public void deleteBooking(){
        fh.delete("booking.txt", bookingID);
    }
    
    public void checkBookingHistory(){
        String custID = cust.getCurrentCustomer();
        
        ArrayList<String> booking = new ArrayList<String>();
        booking = fh.readFile("booking.txt");
        
        for (line )
    }
}
