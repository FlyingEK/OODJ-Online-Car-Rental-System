/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinecarrentalsystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class ActivityLog {
    
    public void addActivityLog(String role, String ID, String username, String activity){
        //get current datetime
        LocalDateTime dtNow = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        ArrayList<String> log = new ArrayList<String>();
        log.add(dtNow.format(dtf)+";"+role+";"+ID+";"+username+";"+activity);
        //write into file
        FileHandling fh = new FileHandling(); 
        fh.writeFile("activityLog.txt",log);
    }
}
