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
    private String carID, model, plateNo, seat,color,year,price;
    private FileHandling fh;

    public String getCarID() {
        return carID;
    }

    public String getModel() {
        return model;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public String getSeat() {
        return seat;
    }

    public String getColor() {
        return color;
    }

    public String getYear() {
        return year;
    }

    public String getPrice() {
        return price;
    }
    
    public Car(){
        this.carID = null;
        fh = new FileHandling();
    }
    
    public Car(String carID){
        this.carID = carID;
        fh = new FileHandling();
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
    
    public Boolean searchCar(){
        String[] carArray = fh.searchRecord("car.txt", carID);
        Boolean found = true;
        if (carArray.length == 0){
            found = false;
        } else{
            carID = carArray[0];
            model = carArray[1];
            plateNo = carArray[2];
            seat = carArray[3];
            color = carArray[4];
            year = carArray[5];
            price = carArray[6];
        }
        return found;
    }

    public void deleteCar(){
        fh.delete("car.txt", carID);
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }
    
    
}