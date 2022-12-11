/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinecarrentalsystem;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.scene.AmbientLight;
import javafx.scene.shape.Sphere;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author User
 */
public class Pie_Chart extends Application {
        @Override
        
        
        public void start(Stage primaryStage) throws Exception{
            int i = 0;
            Report rp = new Report();
            
            int count = rp.carRatio().size();
            PieChart.Data data[] = new PieChart.Data[count];
            
            primaryStage.setTitle("Car Rented Ratio");
           
            for (Map.Entry<String, Long> e : rp.carRatio().entrySet()){
                data[i] = new PieChart.Data(e.getKey(),e.getValue());
                i++;
            }
            
            ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(data);
            PieChart pie = new PieChart(pieData);
            
            
            Group root = new Group(pie);
            Scene scene = new Scene(root, 600, 400);
            primaryStage.setTitle("Pie Chart");
            primaryStage.setScene(scene);
            primaryStage.show();
            
            pie.setTitle("Car Rented Ratio");
            
    }
    
    public static void main(String[] args){
        launch(args);
    }
}
