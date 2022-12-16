/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinecarrentalsystem;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Admin extends User {
    private FileHandling fh;
    private ActivityLog a;
    
    public Admin(){
        fh = new FileHandling();
        a = new ActivityLog();
    }

    
    //login function
    public Boolean login(String username,String password){
        boolean found = false;
        String activity = "failed login";
        // 0 is the initial admin ID
        String adminID = "0";
        ArrayList<String> file = new ArrayList<String>();
        file = fh.readFile("admin.txt");
      
            for(String line : file){
            String[] detail = line.split(";");
            
            if (detail[1].equals(username) && detail[2].equals(password))
            {
                adminID = detail[0];
                found = true;
                activity = "successful login";
                break;
            }
        }
        
        if (found){
            JOptionPane.showMessageDialog(null, "Login Success! Welcome back, "+username+"!");
            a.addActivityLog( "Admin",adminID, username, activity);
        }else{
            a.addActivityLog( "Admin",adminID, username, activity);
        }
        return found;
    }

    
    
}
