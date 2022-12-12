/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinecarrentalsystem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
/**
 *
 * @author User
 */
public class Report {
    private FileHandling fh;
    private Booking booking;
    private Car car;
    private Payment pay;
    
    public Report(){
        fh = new FileHandling();
        booking = new Booking();
        car = new Car();
        pay = new Payment();
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
    
    public String highestBooking(){
        ArrayList<String> bookRecord = new ArrayList<String>(booking.readBooking());
        ArrayList<String> cust = new ArrayList<String>();
        
        for(String line:bookRecord){
            String[] detail = line.split(";");
            cust.add(detail[2]);
        }
        
        String customer 
        = cust.stream()
            .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
            .entrySet()
            .stream()
            .max(Comparator.comparing(Map.Entry::getValue))
            .get()
            .getKey();
        
        return customer;
    }
    
    public String averageDate(){
        int gap;
        int days = 0;
        int count= 0;
        int average;
        
        DateTimeFormatter dateForm = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        ArrayList<String> bookRecord = new ArrayList<String>(booking.readBooking());
        
        for(String line:bookRecord){
            String[] detail = line.split(";");
            LocalDate dateOut = LocalDate.parse(detail[3], dateForm);
            LocalDate dateReturn = LocalDate.parse(detail[4], dateForm);
            long daysBetween = ChronoUnit.DAYS.between(dateOut, dateReturn);
            gap = Math.toIntExact(daysBetween);
            days = days + gap;
            count++;
        }
        average = days/count;
        return Integer.toString(average);
    }
    
    public String rejectedBooking(){
        int count = 0;
        ArrayList<String> bookRecord = new ArrayList<String>(booking.readBooking());
        
        for(String line:bookRecord){
            String[] detail = line.split(";");
            if (detail[5].equals("rejected")){
                count ++;
            }
            
        }
        return Integer.toString(count);
    }
    
    public Map<String, Long> carRatio(){
        ArrayList<String> bookRecord = new ArrayList<String>(booking.readBooking());
        ArrayList<String> car = new ArrayList<String>();
        
        for(String line:bookRecord){
            String[] detail = line.split(";");
            car.add(detail[1]);
        }
        Map<String, Long> ratio = 
        car.stream().collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        
        return ratio;
    }
    
    //total payment
    public String totalPayment(){
        String count;
        ArrayList<String> payRecord = new ArrayList<String>(pay.readPayment());
        count = Integer.toString(payRecord.size());
        return count;
    }
    
    //total customer
    public String totalPayCustomer(){
        int count = 0;
        
        ArrayList<String> payRecord = new ArrayList<String>(pay.readPayment());
        Set<String> set = new HashSet<String>();
        
        for(String line:payRecord){
            String[] detail = line.split(";");
            booking.setBookingID(detail[1]);
            if(booking.searchBooking()){
                String cust = booking.getCustomerID();
                if (set.add(cust)){
                    count ++;
                }
            }
        }
        return Integer.toString(count);
    }
    
    //highest paying customer
    public String[] highestPayData(){
         int count = 0;
        
        ArrayList<String> payRecord = new ArrayList<String>(pay.readPayment());
        Set<String> set = new HashSet<String>();
        
        for(String line:payRecord){
            String[] detail = line.split(";");
            booking.setBookingID(detail[1]);
            if(booking.searchBooking()){
                String cust = booking.getCustomerID();
                if (set.add(cust)){
                    count ++;
                }
            }
        }
        
        ArrayList<String> bookRecord = new ArrayList<String>(booking.readBooking());
        ArrayList<Double> payment = new ArrayList<Double>();
        
        for (String cus : set){
            double amount = 0;
            for(String line : bookRecord){
                String[] bookDetail = line.split(";");
                if (cus.equals(bookDetail[2])){
                    for(String line1:payRecord){
                        String[] payDetail = line1.split(";");
                        if(payDetail[1].equals(bookDetail[0])){
                            amount += Double.parseDouble(payDetail[2]);
                        }
                    }
                } 
            }
            payment.add(amount);
        }
        
        double maxPay = Collections.max(payment);
        
        int maxCustIndex = payment.indexOf(maxPay); 
        String[] custList = set.toArray(new String[set.size()]);
        String customer = custList[maxCustIndex];
        
        String[] highestData = {customer,String.valueOf(maxPay)};
        
        return highestData;
    }
    
    
    //Average Payment
    
    
    
    //highest paid car
    
    //highest paying month
}
