package com.lab;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
//CSC3104 LAB2q1 
//Version 2 does not change the core functionality, just adds comments
public class lab2q1 extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CSC3104 LAB2:Advance BMI Calculator"); //title name

        VBox layout = new VBox(8);
        layout.setPadding(new Insets(8)); 

        Label nameLabel = new Label("Enter Your Name Here:");
        TextField nameField = new TextField();

        Label weightLabel = new Label("Enter Your Weight Here(Kg)");
        TextField weightField = new TextField();

        Label heightLabel = new Label("Enter Your Height Here(m)");
        TextField heightField = new TextField();

        Button calculateButton = new Button("Calculate The BMI"); 

        Label resultLabel = new Label("Welcome to use");

        calculateButton.setOnAction//when button click
        (e -> {
            String name = nameField.getText();
            String weightText = weightField.getText(); //get the content of weight textfield
            String heightText = heightField.getText();
        
            try {
                double weight = Double.parseDouble(weightText); //get the value of weight and height
                double height = Double.parseDouble(heightText);
        
                double bmi = weight / (height * height);
                String advice = ""; //initial the 'advice'
                //not only the result will be shown, but also the color will also be changed according the result
                weightField.setStyle("-fx-text-fill: black;");heightField.setStyle("-fx-text-fill: black;");
                if (bmi<16) {advice = " seriously underweight!!!";resultLabel.setStyle("-fx-text-fill: red;");}
                else if (bmi<18) {advice = " underweight!!";resultLabel.setStyle("-fx-text-fill: orange;");}
                else if (bmi<24) {advice = " normal weight!";resultLabel.setStyle("-fx-text-fill: green;");}
                else if (bmi<29) {advice = " overweight!!";resultLabel.setStyle("-fx-text-fill: orange;");}
                else if (bmi<35) {advice = " seriously overweight!!!";resultLabel.setStyle("-fx-text-fill: purple;");}
                else if (bmi>=35){advice = " gravely overweight!!!!";resultLabel.setStyle("-fx-text-fill: red;");}
                else if (Double.parseDouble(weightText)<=0){weightField.setStyle("-fx-text-fill: red;");advice="incorrect weight!";}
                else if (Double.parseDouble(heightText)<=0){heightField.setStyle("-fx-text-fill: red;");advice="incorrect height!";}
                else advice = "Error:Invalid data for human being!";


                resultLabel.setText(name + "'s BMI: " + String.format("%.2f", bmi)+advice);
                } //show the result text

            catch (NumberFormatException ex){resultLabel.setText("Error:Invalid input!Please input correctly");}
        });//if error, show

        layout.getChildren().addAll(
            nameLabel, nameField,
            weightLabel, weightField,
            heightLabel, heightField,
            calculateButton,
            resultLabel
        );

        Scene scene = new Scene(layout, 275, 240);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {launch(args);}

}
