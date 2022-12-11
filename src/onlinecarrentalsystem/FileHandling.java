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
            
    public ArrayList<String> readFile(String filename)
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
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        return file;
    }
    
    public String incrementID(String filename)
    {   
        int ID = 0;
        try(BufferedReader b = new BufferedReader (new FileReader(filename))){
            String line = b.readLine();
            while (line != null){
                if (line.split(";")[0] != ""){
                    ID = Integer.parseInt(line.split(";")[0].trim().substring(1));
                }
                line = b.readLine();
            }
            b.close();
            ID = ID +1;
        }
        catch (IOException ex){
            JOptionPane.showMessageDialog(null, "Error occurs while reading the file.");
        }
        return ID+"";
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
    
    
    public String[] searchRecord(String filename,String id)
    {
        boolean found = false;
        String[] result = {};
        try{
            File f = new File(filename);
            FileReader fr = new FileReader(f);
            BufferedReader br =  new BufferedReader(fr);
            
            
            String line = br.readLine();
            while (line!=null)
            {
                String[] inFile = line.split(";");
                
                if (inFile[0].equals(id))
                {
                    found = true;
                    result = inFile;
                    break;
                }
                line = br.readLine();
            }
            br.close();
            
        }catch(IOException e){
            System.out.println(e);
        }
        return result;
    }
    
    public void modifyRecord(String filename,ArrayList<String> array)
    {
        ArrayList<String> fileData = new ArrayList<String>();
        boolean modified = false;
        try{
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        
        String line = br.readLine();
        while (line != null)
        {
            String[] data = line.split(";");
            if(data[0].equals(array.get(0)))
            {
                String combineArray = String.join(";", array);
                fileData.add(combineArray);
                modified = true;
            }
            else
            {
                fileData.add(line);
            }
            
            line = br.readLine();
        }
        br.close();
        
        File f = new File(filename);

        FileWriter fw = new FileWriter(filename);
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
            JOptionPane.showMessageDialog(null, "Record Updated");
        }
        else{
            JOptionPane.showMessageDialog(null, "Failed to update record!","Error Message",JOptionPane.ERROR_MESSAGE);
        }
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
                writer.flush();
                writer.close();
                
                //delete old file
                file.delete();
                //System.out.print(file.getCanonicalFile());
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
    
    
    public void setCurrentCustomer(String custID){
        try
        {
            File f = new File("section.txt");

            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(custID);
            bw.flush();
            bw.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
    
    public String getCurrentCustomer(){
        String custID = null;
        try
        {
            FileReader fr = new FileReader("section.txt");
            BufferedReader br = new BufferedReader(fr);
            custID = br.readLine();
            br.close();
            
            //if no id in then jump to login
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        return custID;
    }
}
