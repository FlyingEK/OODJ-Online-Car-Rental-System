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
        cus.add("1");
        cus.add("Luna");
        cus.add("password");
        
        FileHandling fh = new FileHandling();
        //fh.writeFile("customer.txt",cus);
        //fh.readFile("customer.txt");
        //fh.searchRecord("customer.txt","1");
        //fh.modifyRecord("customer.txt", cus);
        ArrayList<String> fileData = new ArrayList<String>();
        boolean modified = false;
        try{
        FileReader fr = new FileReader("customer.txt");
        BufferedReader br = new BufferedReader(fr);
        
        String line = br.readLine();
        while (line != null)
        {
            String[] data = line.split(";");
            System.out.println(data[0]);
            System.out.println(cus.get(0));
            if(data[0].equals(cus.get(0)))
            {
                System.out.println("Enter");
                String combineArray = String.join(";", cus);
                fileData.add(combineArray);
                modified = true;
            }
            else
            {
                fileData.add(line);
            }
            
            line = br.readLine();
        }
        
        
        File f = new File("customer.txt");

        FileWriter fw = new FileWriter("customer.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        for (int i =0;i<fileData.size();i++)
        {
            pw.println(fileData.get(i));
        }
        pw.flush();
        pw.close();
        
        }catch(IOException e){
            System.out.println(e);
        }
        
        if(modified)
        {
            JOptionPane.showMessageDialog(null, "Record Edited");
        }
        else{
            JOptionPane.showMessageDialog(null, "Failed to edit record!","Error Message",JOptionPane.ERROR_MESSAGE);
        }
    } 
}
