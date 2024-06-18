package com.lab;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//CSC3104 LAB2Q2
//NAME:APPLE CODE:A PRICE:1$/per 
//NAME:BALL CODE:B PRICE:2$/per
public class lab1q3 extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CSC3104 lab1Q3");

        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new javafx.geometry.Insets(11));

        HBox codeHBox = new HBox(10);
        Label codeLabel = new Label("Unit Code:");
        TextField codeTextField = new TextField();
        codeHBox.getChildren().addAll(codeLabel, codeTextField);

        HBox nameHBox = new HBox(10);
        Label nameLabel = new Label("Unit Name:");
        TextField nameTextField = new TextField();
        nameHBox.getChildren().addAll(nameLabel, nameTextField);
        nameTextField.setEditable(false);

        HBox priceLayout = new HBox(10);
        Label priceLabel = new Label("Unit Per Price:");
        TextField priceField = new TextField();
        priceLayout.getChildren().addAll(priceLabel, priceField);
        priceField.setEditable(false);

        HBox quantityLayout = new HBox(10);
        Label quantityLabel = new Label("Quantity:");
        TextField quantityField = new TextField();
        quantityLayout.getChildren().addAll(quantityLabel, quantityField);

        HBox buttonLayout = new HBox(10);
        Button calculateButton = new Button("Calculate Total Price");
        Label resultLabel = new Label();
        buttonLayout.getChildren().addAll(calculateButton, resultLabel);

        calculateButton.setOnAction(e -> {
            try {
                if (codeTextField.getText().equals("A")){resultLabel.setStyle("-fx-text-fill: green;");priceField.setText("1");nameTextField.setText("Apple");}
                else if (codeTextField.getText().equals("B")){resultLabel.setStyle("-fx-text-fill: pink;");priceField.setText("2");nameTextField.setText("BALL");}
                else {resultLabel.setStyle("-fx-text-fill: red;");priceField.setText("ERROR! ITEM NOT FOUND!");}
                double unitPrice = Double.parseDouble(priceField.getText());
                int quantity = Integer.parseInt(quantityField.getText());

                double totalSale = unitPrice * quantity;
                resultLabel.setStyle("-fx-text-fill: green;");
                resultLabel.setText("Total Sale: ￥" + String.format("%.2f", totalSale));
            } catch (NumberFormatException ex) {
                resultLabel.setStyle("-fx-text-fill: red;");
                resultLabel.setText("Error: \nPlease enter correctly!");
            }
        });

        mainLayout.getChildren().addAll(codeHBox,nameHBox,priceLayout, quantityLayout, buttonLayout);

        Scene scene = new Scene(mainLayout, 330, 220);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
