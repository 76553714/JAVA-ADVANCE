package com.lab;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.util.Random;
//JAVAFX LAB4Q1 Final version
// Runnable to print a specific character
class MYprintchar implements Runnable {
    private char charToPrint;
    private int times;
    private TextArea text;
    public MYprintchar(char c, int t, TextArea textArea) {charToPrint = c;times = t;text = textArea;}
    public void run() {
        for (int i = 0; i < times; i++) 
        {
            final int finalI = i; // To use in lambda expression
            Platform.runLater(() -> {text.appendText(String.valueOf(charToPrint));});
        }
    }
}
// Runnable to print numbers
class MYPrintNum implements Runnable {
    private int lastNum;    // Variable to store the last number to be printed
    private TextArea text;  // TextArea where the numbers will be printed
    // Constructor to initialize the last number and the TextArea
    public MYPrintNum(int n, TextArea textArea) {lastNum = n;text = textArea;}
    @Override
    public void run() {
        for (int i = 1; i <= lastNum; i++) {
            final int finalI = i; // To use in lambda expression

            // RunLater is used to update JavaFX UI components from a non-JavaFX thread
            Platform.runLater(() -> {
                // Append the current number to the TextArea with a space
                text.appendText(" " + finalI);
            });
        }
    }
}
// Runnable to print a specified string
class MYPrintString implements Runnable {
    private String stringToPrint;
    private int times;
    private TextArea text;

    public MYPrintString(String s, int t, TextArea textArea) {stringToPrint = s;times = t;text = textArea;}
    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            Platform.runLater(() -> {
                text.appendText(stringToPrint);
            });
        }
    }
}
// Runnable to print random numbers
class MYPrintRandomNumber implements Runnable {
    private int times;
    private TextArea text;
    public MYPrintRandomNumber(int t, TextArea textArea) {times = t;text = textArea;}

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < times; i++) {
            final int finalI = i; // To use in lambda expression
            Platform.runLater(() -> {
                int randomNumber = random.nextInt(50) + 1;
                String formatNumber = "<" + randomNumber + ">";
                text.appendText(formatNumber);
            });
        }
    }
}
public class lab4q1 extends Application {
    public static void main(String[] args) {launch(args);}//launch
    @Override
    public void start(Stage primaryStage) { //main thread
        // Create a TextArea for output
        TextArea textArea = new TextArea();
        textArea.setEditable(false); //user can not edit this, read only
        textArea.setWrapText(true); // Auto change line

        // Create instances of Runnables for different printing tasks
        Runnable printA = new MYprintchar('a', 100, textArea);
        Runnable printB = new MYprintchar('b', 100, textArea);
        Runnable print100 = new MYPrintNum(100, textArea);
        Runnable printString = new MYPrintString("HiUPM", 5, textArea);
        Runnable printRandomNumber = new MYPrintRandomNumber(10, textArea);

        // Create a Scene with the TextArea
        Scene scene = new Scene(textArea, 700, 600);

        // Set up the primaryStage
        primaryStage.setTitle("Lab4Q1 JOY");
        primaryStage.setScene(scene);
        primaryStage.show();
        // Create  threads for different printing tasks
        Thread thread1 = new Thread(printA);Thread thread2 = new Thread(printB);Thread thread3 = new Thread(print100);Thread thread4 = new Thread(printString);Thread thread5 = new Thread(printRandomNumber);
        //start all 5 threads
        thread1.start();thread2.start();thread3.start();thread4.start();thread5.start();
    }
}
