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
    private String bookingID;
    private FileHandling fh;
    private Customer cust;
    
    public Booking(){
        this.bookingID = null;
        fh = new FileHandling();
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }
    
    public Booking(String bookingID){
        this.bookingID = bookingID;
        fh = new FileHandling();
    }
    
    public ArrayList readBooking(){
        ArrayList<String> bookingArray = fh.readFile("booking.txt");
        return bookingArray;
    }
    
    public void addBooking(ArrayList bookingArray){
        fh.writeFile("booking.txt", bookingArray);
    }
    
    public String[] searchBooking(){
        String[] bookingArray = fh.searchRecord("booking.txt", bookingID);
        return bookingArray;
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
