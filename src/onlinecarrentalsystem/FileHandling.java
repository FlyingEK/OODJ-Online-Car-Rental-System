/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinecarrentalsystem;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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

            FileWriter fw = new FileWriter(filename,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            for (int i =0;i<array.size();i++)
            {

                pw.println(array.get(i));
            }
            pw.flush();
            pw.close();
 
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
    
    
    public ArrayList searchRecord(String filename,int id)
    {
        try{
            File f = new File(filename);
            FileReader fr = new FileReader(f);
            BufferedReader br =  new BufferedReader(fr);
            
            String line = br.readLine();
            while (line!=null)
            {
                System.out.println(line);
                String[] inFile = line.split(";");
                
                if (Integer.parseInt(inFile[0]) == id)
                {
                    found = true;
                }
            }
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    public void modifyRecord(String filename,ArrayList array)
    {
        
    }
    
    public void delete(String filename, String removeID){
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
