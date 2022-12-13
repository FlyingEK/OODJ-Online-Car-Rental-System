/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinecarrentalsystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Booking {
    private String bookingID, carID, customerID, outDate, returnDate, status;
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
    
    public String newBookingID(){
        String newBookingID = fh.incrementID("booking.txt");
        return "B"+newBookingID;
    }
    
    public ArrayList<String> readBooking(){
        ArrayList<String> bookingArray = fh.readFile("booking.txt");
        return bookingArray;
    }
    
    public void addBooking(ArrayList<String> bookingArray){
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
            status = bookingArray[5];
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
    
    public String getStatus(){
        return status;
    }
    
     public void modifyBooking(ArrayList<String> bookingArray){
        fh.modifyRecord("booking.txt",bookingArray);
    }

    public void deleteBooking(){
        fh.delete("booking.txt", bookingID);
    }
    
    public ArrayList<String> checkBookingHistory(){
        String custID = fh.getCurrentCustomer();
        
        ArrayList<String> booking = new ArrayList<String>();
        booking = fh.readFile("booking.txt");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        ArrayList<String> customerBooking = new ArrayList<String>();
        for (String line : booking){
            String[] detail = line.split(";");
            
            if (detail[2].equals(custID))
            {
                try {
                    Date today = dateFormat.parse(dateFormat.format(new Date()));
                    Date dateOut = dateFormat.parse(detail[4]);
                    if (dateOut.compareTo(today) < 0){
                        customerBooking.add(line);
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return customerBooking;
    }
    
    public ArrayList<String> checkCurrentBooking(){
        String custID = fh.getCurrentCustomer();
        
        ArrayList<String> booking = new ArrayList<String>();
        booking = fh.readFile("booking.txt");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        ArrayList<String> customerBooking = new ArrayList<String>();
        for (String line : booking){
            String[] detail = line.split(";");
            
            if (detail[2].equals(custID))
            {
                try {
                    Date today = dateFormat.parse(dateFormat.format(new Date()));
                    Date dateOut = dateFormat.parse(detail[4]);
                    if (dateOut.compareTo(today) > 0){
                        customerBooking.add(line);
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return customerBooking;
    }
    
    public boolean checkCarAvailability(String carID,Date dateOut, Date dateReturn){
        boolean available = false;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date bDateOut;
        Date bDateReturn;
        Date today;
        try {
            today = dateFormat.parse(dateFormat.format(new Date()));
            
            if(dateOut.equals(today) || dateOut.after(today)){
                ArrayList<String> booking = new ArrayList<String>(readBooking());
                for (String line:booking){
                    String[] bookingDetail = line.split(";");

                    if (carID.equals(bookingDetail[1])){
                        if(!bookingDetail[5].equals("rejected")){
                            try {
                                bDateOut = dateFormat.parse(bookingDetail[3]);
                                bDateReturn = dateFormat.parse(bookingDetail[4]);
                                if ((dateOut.before(bDateOut) && dateReturn.before(bDateOut)) || (dateOut.after(bDateReturn) && dateReturn.after(bDateReturn))){
                                    available = true;
                                }else{
                                    available = false;
                                    break;
                                }
                            } catch (ParseException ex) {
                                Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }else{
                        available = true;
                    }
                }
            }else{
                available = false;
            }
        } catch (ParseException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
        return available;
    }
    
    //admin 
    public boolean checkCarAvailability(Date dateOut, String carID){
        boolean available = true;
        ArrayList<String> book = readBooking();
        Date d1 = null;
        Date d2 = null;
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        for (String bookRec: book){
            try{
                d1 = df.parse(bookRec.split(";")[3]);
                d2 = df.parse(bookRec.split(";")[4]);
                if((bookRec.split(";")[1].equals(carID))&&(!bookRec.split(";")[5].equals("rejected"))){
                    if ((dateOut.equals(d1) ||dateOut.equals(d2))||(dateOut.after(d1) && dateOut.before(d2))){
                        available = false;
                    }
                }
            
            }catch(ParseException pe){
                pe.printStackTrace();
            }
        } 
        return available;
    }
    
    public boolean checkCarAvailability(String carID,Date dateOut){
        boolean available = false;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date bDateOut;
        Date bDateReturn;
        Date today;
        
        try {
            today = dateFormat.parse(dateFormat.format(new Date()));
            
            if(dateOut.equals(today) || dateOut.after(today)){
                ArrayList<String> booking = new ArrayList<String>(readBooking());
                for (String line:booking){
                    String[] bookingDetail = line.split(";");

                    if (carID.equals(bookingDetail[1])){
                        if(!bookingDetail[5].equals("rejected")){
                            try {
                                bDateOut = dateFormat.parse(bookingDetail[3]);
                                bDateReturn = dateFormat.parse(bookingDetail[4]);
                                if ((dateOut.before(bDateOut)  || dateOut.after(bDateReturn)) && !dateOut.equals(bDateReturn) ){
                                    available = true;
                                }
                                else{
                                    available = false;
                                    break;
                                }
                            } catch (ParseException ex) {
                                Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        
                    }else{
                        available = true;
                    }
                }
            }else{
                available = false;
            }
        } catch (ParseException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return available;
    }
    
    public boolean checkCarAvailability(String bookID, String carID,Date dateOut, Date dateReturn){
        boolean available = false;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date bDateOut;
        Date bDateReturn;
        Date today;
        try {
            today = dateFormat.parse(dateFormat.format(new Date()));
            
            if(dateOut.equals(today) || dateOut.after(today)){
                ArrayList<String> booking = new ArrayList<String>(readBooking());
                for (String line:booking){
                    String[] bookingDetail = line.split(";");

                    if (carID.equals(bookingDetail[1])){
                        if(!bookID.equals(bookingDetail[0])){
                            if(!bookingDetail[5].equals("rejected")){
                                try {
                                    bDateOut = dateFormat.parse(bookingDetail[3]);
                                    bDateReturn = dateFormat.parse(bookingDetail[4]);
                                    if ((dateOut.before(bDateOut) && dateReturn.before(bDateOut)) || (dateOut.after(bDateReturn) && dateReturn.after(bDateReturn))){
                                        available = true;
                                    }else{
                                        available = false;
                                        break;
                                    }
                                } catch (ParseException ex) {
                                    Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }else{
                        available = true;
                    }
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
        return available;
    }
    
    public boolean checkCarAvailability(String bookID, String carID,Date dateOut){
        boolean available = false;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date bDateOut;
        Date bDateReturn;
        Date today;
        
        try {
            today = dateFormat.parse(dateFormat.format(new Date()));
            
            if(dateOut.equals(today) || dateOut.after(today)){
                ArrayList<String> booking = new ArrayList<String>(readBooking());
                for (String line:booking){
                    String[] bookingDetail = line.split(";");

                    if (carID.equals(bookingDetail[1])){
                        if(!bookID.equals(bookingDetail[0])){
                            if(!bookingDetail[5].equals("rejected")){
                                try {
                                    bDateOut = dateFormat.parse(bookingDetail[3]);
                                    bDateReturn = dateFormat.parse(bookingDetail[4]);
                                    if ((dateOut.before(bDateOut)  || dateOut.after(bDateReturn)) && !dateOut.equals(bDateReturn) ){
                                        available = true;
                                    }
                                    else{
                                        available = false;
                                        break;
                                    }
                                } catch (ParseException ex) {
                                    Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
                                } 
                            }
                        }
                    }else{
                        available = true;
                    }
                }
            }else{
                available = false;
            }
        } catch (ParseException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return available;
    }
}
