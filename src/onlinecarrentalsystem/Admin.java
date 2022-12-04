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
    
    public Admin(){
        fh = new FileHandling();
    }
    
    //login funstion
    public Boolean login(String username,String password){
        
        boolean found = false;
        ArrayList<String> file = new ArrayList<String>();
        file = fh.readFile("customer.txt");
        
        for(String line : file){
            String[] detail = line.split(";");
            
            if (detail[1].equals(username) && detail[2].equals(password))
            {
                found = true;
                currentCustomer = detail[0];
                break;
            }
        }
        if (found){
            JOptionPane.showMessageDialog(null, "Login Success! Welcome to our car rental system!");
        }else{
            JOptionPane.showMessageDialog(null, "Login failed, please try again.","Error Message",JOptionPane.ERROR_MESSAGE);
        }
        return found;
    }

    
    
}
