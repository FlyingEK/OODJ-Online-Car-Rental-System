/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jp_resortroombookingsystem;
import javax.swing.*;
import java.io.*;


/**
 *
 * @author User
 */
public class NormalMethod extends javax.swing.JFrame{
  
    void delete(String filename, String removeID){
        File file = new File(filename);
        File temp = new File("temp.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            try (PrintWriter writer = new PrintWriter(new BufferedWriter (new FileWriter (temp))))
            {
                String line;
                while((line = reader.readLine()) != null) {
                    if(line.split(";")[0].equals(removeID)) {
                        continue;
                    }
                    writer.println(line);  
                }
                reader.close();
                writer.close();
                
                //delete old file
                file.delete();
                boolean successful = temp.renameTo(file);
                if (successful){
                    JOptionPane.showMessageDialog(null, "Record deleted succesfully!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Failed to delete record!","Error Message",JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(IOException ioe)
            {
                ioe.printStackTrace();
            }
        }
        catch(IOException ioe)
        {
             ioe.printStackTrace();
        }
     }
}

