package com.lab;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.*;

//CSC3104 LAB1Q1 
public class lab1q1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CSC3104 LAB1 ");

        GridPane gridPane = new GridPane();
        Random random = new Random();

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 6; col++) {
                TextField textField = new TextField();
                textField.setPrefWidth(50);textField.setPrefHeight(50); //set size
                textField.setStyle("-fx-alignment: center;"); // Center

                int randomNumber = random.nextInt(20) ; //give number 1 to 20

                textField.setText(String.valueOf(randomNumber));
                gridPane.add(textField, col, row);
            }
        }

        Scene scene = new Scene(gridPane, 250, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {launch(args);}
}
