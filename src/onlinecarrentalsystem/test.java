/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinecarrentalsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class test {
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<String> cus = new ArrayList<String>();
        //cus.add("1;Luna;password");
        cus.add("3");
        cus.add("Zli");
        cus.add("1231");
        
        String[] customerDetail = new String[] {"NaNa","9987","John Alian","012-712-2213",
        "gg@gmail.com","011223011123","6 Jalan Kluang, Sugai Besi, Kuala Lumpur"};
        
        FileHandling fh = new FileHandling();
        //fh.writeFile("customer.txt",cus);
        //fh.readFile("customer.txt");
        //fh.searchRecord("customer.txt","1");
        //fh.modifyRecord("customer.txt", cus);
        
        Customer cust = new Customer();
        //cust.login("Violin", "7891");
        //cust.Register(customerDetail);
        
        Booking book = new Booking();
        System.out.println(book.checkCurrentBooking());

    } 
}
