package com.lab;
import java.io.File;
import javafx.animation.FadeTransition;
import javafx.application.Application;import javafx.scene.Scene;
import javafx.scene.control.Button;import javafx.scene.control.Label;
import javafx.scene.control.TextField;import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

//CSC3104 LAB3Q2 
public class lab3q2v2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CSC3104 lab3Q2");
        // Create a vertical layout for the main window with spacing and padding
        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new javafx.geometry.Insets(11));
        // Create an HBox for entering the unit code
        HBox codeHBox = new HBox(10);
        Label codeLabel = new Label("Unit Code:");
        TextField codeTextField = new TextField();
        codeHBox.getChildren().addAll(codeLabel, codeTextField);
        // Create an HBox for displaying the unit name (initially set to not editable)
        HBox nameHBox = new HBox(10);
        Label nameLabel = new Label("Unit Name:");
        TextField nameTextField = new TextField();
        nameHBox.getChildren().addAll(nameLabel, nameTextField);
        nameTextField.setEditable(false);

        // Create an HBox for displaying the unit price (initially set to not editable)
        HBox priceLayout = new HBox(10);
        Label priceLabel = new Label("Unit Per Price:");
        TextField priceField = new TextField();
        priceLayout.getChildren().addAll(priceLabel, priceField);
        priceField.setEditable(false);

        // Create an HBox for entering the quantity
        HBox quantityLayout = new HBox(10);
        Label quantityLabel = new Label("Quantity:");
        TextField quantityField = new TextField();
        quantityLayout.getChildren().addAll(quantityLabel, quantityField);
        
        //create a media player here
        MediaPlayer mediaPlayer = createMediaPlayer();//go to create media method
        MediaView mediaView = new MediaView(mediaPlayer);
        
        // set media size
        mediaView.setFitWidth(360);mediaView.setFitHeight(360);

        // Create an vertical Box for the calculate button and displaying the result with video
        VBox finalvbox = new VBox(50);
        Button calculateButton = new Button("Calculate Total Price");
        Label resultLabel = new Label();
        
        
        finalvbox.getChildren().addAll(calculateButton, resultLabel, mediaView);

        // Define the action to be taken when the calculate button is clicked
        calculateButton.setOnAction(e -> {
            try {
                // Check the entered unit code and set corresponding values
                if (codeTextField.getText().equals("A")) {
                    resultLabel.setStyle("-fx-text-fill: green;");
                    priceField.setText("1");
                    nameTextField.setText("Apple");
                } else if (codeTextField.getText().equals("B")) {
                    resultLabel.setStyle("-fx-text-fill: pink;");
                    priceField.setText("2");
                    nameTextField.setText("BALL");
                } else {
                    resultLabel.setStyle("-fx-text-fill: red;");
                    priceField.setText("ERROR! ITEM NOT FOUND!");
                }
                double unitPrice = Double.parseDouble(priceField.getText());
                int quantity = Integer.parseInt(quantityField.getText());

                double totalSale = unitPrice * quantity; // Calculate the total price
                resultLabel.setStyle("-fx-text-fill: green;");
                double discount = 0.0;
                if (totalSale >= 1000)
                    discount = 0.05;
                else if (totalSale >= 10000)//set discount
                    discount = 0.1;
                else if (totalSale >= 15000)
                    discount = 0.2;
                else if (totalSale >= 20000)
                    discount = 0.3;
                else
                    discount = 0;
                resultLabel.setText("Total Sale: ￥" + String.format("%.2f", totalSale)
                        + "\n discount:" + String.format("%.2f", discount)
                        + "\n Final price(after discount): \n ￥" + String.format("%.2f", totalSale - totalSale * discount));
                if (quantity < 0) {
                    resultLabel.setStyle("-fx-text-fill: red;");
                    resultLabel.setText("Error: \nPlease enter the quantity correctly!");
                    discount = 0;
                }
            } 
            catch (NumberFormatException ex) //for error
            {
                resultLabel.setStyle("-fx-text-fill: red;");
                resultLabel.setText("Error: \nPlease enter correctly!");
            }
        });
        FadeTransition ft = new FadeTransition(Duration.millis(500), resultLabel);
        // Blinking label Function
        ft.setFromValue(1.0); ft.setToValue(0.2);
        ft.setCycleCount(FadeTransition.INDEFINITE);//unstoppable play
        ft.setAutoReverse(true);ft.play();//LOOP

        
        // Add all the HBox layouts to the main layout
        mainLayout.getChildren().addAll(codeHBox, nameHBox, priceLayout, quantityLayout, finalvbox);

        // Create a scene with the main layout and set the window dimensions
        Scene scene = new Scene(mainLayout, 375, 625);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private MediaPlayer createMediaPlayer()
    {
        // get the fruit video file path
        String videoPath = "E:\\SRC\\JAVAFX\\f.mp4";File file = new File(videoPath);
        if (file.exists()) 
        {
            // create a media
            Media media = new Media(file.toURI().toString());
            // create media player
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            //Looping play
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.play();
            return mediaPlayer;
        }
        else{System.out.println("Video file not found.");return null;}
    }
    public static void main(String[] args) 
    {
        launch(args);
    }
}
