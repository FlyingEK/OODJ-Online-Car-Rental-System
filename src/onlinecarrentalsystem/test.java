/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinecarrentalsystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class test {
    public static void main(String[] args) {
        // TODO code application logic here
       ArrayList<String> cus = new ArrayList<String>();
        cus.add("1;Volvo;password");
        
        FileHandling fh = new FileHandling();
        fh.writeFile("customer.txt",cus);
        fh.readFile("customer.txt");
        System.out.print(cus);
//        System.out.println(fh.readFile("customer.txt"));
//        //fh.writeFile("test.txt",cus);
//        File f = new File("customer.txt");
//        try{
//        FileWriter fw = new FileWriter(f);
//        BufferedWriter bw = new BufferedWriter(fw);
//        PrintWriter pw = new PrintWriter(bw);
//        for (int i =0;i<cus.size();i++)
//        {
//            pw.println(cus.get(i));
//        }
//        pw.flush();
//        pw.close();
//        }catch(IOException e){
//            System.out.println(e);
//        }
    } 
}
