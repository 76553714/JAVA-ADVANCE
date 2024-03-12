package com.lab;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
//CSC3104 LAB1q2
public class lab1q2 extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CSC3104 LAB1:BMI Calculator");

        VBox layout = new VBox(8);
        layout.setPadding(new Insets(8)); 

        Label nameLabel = new Label("Enter Your Name Here:");
        TextField nameField = new TextField();

        Label weightLabel = new Label("Enter Your Weight Here(Kg)");
        TextField weightField = new TextField();

        Label heightLabel = new Label("Enter Your Height Here(m)");
        TextField heightField = new TextField();

        Button calculateButton = new Button("Calculate The BMI");

        Label resultLabel = new Label("");

        calculateButton.setOnAction(e -> {
            String name = nameField.getText();
            String weightText = weightField.getText();
            String heightText = heightField.getText();
        
            try {
                double weight = Double.parseDouble(weightText);
                double height = Double.parseDouble(heightText);
        
                double bmi = weight / (height * height);
                resultLabel.setText(name + "'s BMI: " + String.format("%.2f", bmi));
                } 
            catch (NumberFormatException ex)
                {
                resultLabel.setText("Error:Invalid input!Please input correctly");
                }
        });

        layout.getChildren().addAll(
            nameLabel, nameField,
            weightLabel, weightField,
            heightLabel, heightField,
            calculateButton,
            resultLabel
        );

        Scene scene = new Scene(layout, 275, 333);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {launch(args);}
}
