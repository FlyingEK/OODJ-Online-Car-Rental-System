/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinecarrentalsystem;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author User
 */
public class Report {
    private FileHandling fh;
    private Booking booking;
    private Car car;
    
    public Report(){
        fh = new FileHandling();
        booking = new Booking();
        car = new Car();
    }
    
    public String totalBooking(){
        String count;
        ArrayList<String> bookRecord = new ArrayList<String>(booking.readBooking());
        count = Integer.toString(bookRecord.size());
        return count;
    }
    
    public String totalBookingCustomer(){
        int count = 0;
        ArrayList<String> bookRecord = new ArrayList<String>(booking.readBooking());
        Set<String> set = new HashSet<String>();
        
        for(String line:bookRecord){
            String[] detail = line.split(";");
            if (set.add(detail[2])){
                count ++;
            }
            
        }
        return Integer.toString(count);
    }
    
}
