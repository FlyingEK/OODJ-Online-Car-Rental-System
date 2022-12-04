/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jp_resortroombookingsystem;
import java.io.*;
import javax.swing.*;
/**
 *
 * @author User
 */
public class AutoIncrementID {
    String file;
    int ID;

    void setData(String filename)
    {
        file = filename;
    }

    int getdata()
    {   
        ID = 0;
        try(BufferedReader b = new BufferedReader (new FileReader(file))){
            String line = b.readLine();
            while (line != null){
                if (line.split(";")[0] != ""){
                    ID = Integer.parseInt(line.split(";")[0].trim());
                }
                line = b.readLine();
            }
            b.close();
            ID = ID +1;
        }
        catch (IOException ex){
            JOptionPane.showMessageDialog(null, "Error occurs while reading the file.");
        }
        return ID;
    }

}
