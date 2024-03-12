package com.lab;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.util.Duration;
import javafx.scene.media.Media;
import java.io.File;
//CSC3104 LAB3q1 
//Add at least 2 animations into suitable new or existing nodes,
//example:• Blinking the title• Add exercise video

public class lab3q1v2 extends Application {
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
        Blinking(resultLabel);

        calculateButton.setOnAction//when button click
        (e -> {
            String name = nameField.getText();
            String weightText = weightField.getText(); //get the content of weight textfield
            String heightText = heightField.getText();
            try {
                double weight = Double.parseDouble(weightText); //get weight and height
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

        MediaPlayer mediaPlayer = createMediaPlayer();//go to create media method
        MediaView mediaView = new MediaView(mediaPlayer);
        
        // set media size
        mediaView.setFitWidth(480);mediaView.setFitHeight(480);

        layout.getChildren().addAll
        (//add elements to the layout
            nameLabel, nameField,
            weightLabel, weightField,
            heightLabel, heightField,
            calculateButton,
            resultLabel,
            mediaView
        );

        Scene scene = new Scene(layout, 500, 700);
        primaryStage.setScene(scene);primaryStage.show();
    }

    private MediaPlayer createMediaPlayer() 
    {
        // get the video file path
        String videoPath = "E:\\SRC\\JAVAFX\\cgt.mp4";File file = new File(videoPath);

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
    
    private void Blinking(Label label) //Blink method
    {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0), new KeyValue(label.opacityProperty(), 1.0)),
                new KeyFrame(Duration.seconds(1), new KeyValue(label.opacityProperty(), 0.0))        );
        timeline.setCycleCount(Timeline.INDEFINITE);//always blink
        timeline.play();
    }
        
    public static void main(String[] args) {launch(args);}

}
