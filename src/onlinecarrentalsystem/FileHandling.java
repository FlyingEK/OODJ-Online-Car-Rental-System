/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinecarrentalsystem;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class FileHandling {

    public FileHandling()
    {
    }
    
    public void test()
    {
        System.out.println("test");
    }
            
    public ArrayList readFile(String filename)
    {
        ArrayList<String> file = new ArrayList<String>();
        try
        {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            
            while(line !=null)
            {
                file.add(line);
                line = br.readLine();
            }
            br.close();
            System.out.println(file);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        return file;
    }
    
    public void writeFile(String filename,ArrayList array)
    {
        try
        {
            File f = new File(filename);
            if(!f.exists())
            {
                f.createNewFile();
                FileWriter fw = new FileWriter(filename);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                for (int i =0;i<array.size();i++)
                {
                    pw.write((String) array.get(i));
                    pw.println(array.get(i));
                }
                
            }else
            {
                FileWriter fw = new FileWriter(filename);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                for (int i =0;i<array.size();i++)
                {
                    pw.write((String) array.get(i));
                    pw.println(array.get(i));
                }
            } 
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
    
    
    //public ArrayList searchRecord(String filename,int id)
    //{
        
    //}
    
    public void modifyRecord(String filename,ArrayList array)
    {
        
    }
    
    public void deleteRecord(String filename,int id)
    {
        
    }
}
