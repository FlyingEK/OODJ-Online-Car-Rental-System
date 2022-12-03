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
public class User {
    protected String ID, username, password;
    
    public User(String userType){
       //tak tau buat mcm not working
       ArrayList<String> user = new ArrayList<String>();
       if (userType.toLowerCase().equals("admin")){
           FileHandling fh = new FileHandling(); 
           user = fh.readFile("admin.txt");
       } else if (userType.toLowerCase().equals("customer")) {
           FileHandling fh = new FileHandling(); 
           user = fh.readFile("customer.txt");
       }
       //else/ if not exist display error?
        String[] splitUser = user.get(0).split(";");
        ID = splitUser[0];
        username = splitUser[1];
        password = splitUser[2];
    }
    
    public static Boolean login(){
    }
    
}
