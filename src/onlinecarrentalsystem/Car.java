/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinecarrentalsystem;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Car {
    private String carID;
    public FileHandling fh;
    
    public Car(){
        this.carID = null;
        FileHandling fh = new FileHandling();
    }
    
    public Car(String carID){
        this.carID = carID;
        FileHandling fh = new FileHandling();
    }
    
    public ArrayList readCar(){
        ArrayList<String> carArray = fh.readFile("car.txt");
        return carArray;
    }
    
    public String newCarID(){
        String newCarID = fh.incrementID("car.txt");
        return newCarID;
    }
    
    public void addCar(ArrayList carArray){
        fh.writeFile("car.txt", carArray);
    }
    
    public ArrayList searchCar(){
        ArrayList<String> carArray = fh.searchRecord("car.txt", carID);
        return carArray;
    }

    public void deleteCar(){
        fh.delete("car.txt", carID);
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }
    
    
}
