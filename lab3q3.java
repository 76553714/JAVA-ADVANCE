package com.lab;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.Random;

public class lab3q3 extends Application 
{
//JAVAFX LAB3Q3
    private static final int MAX_CIRCLES = 5;
    private int clickedCircles = 0;
    private long startTime = 0;
    private Random random = new Random();

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 600, 400);
        primaryStage.setTitle("Circle Game");
        primaryStage.setScene(scene);

        // give the 
        pane.setOnMouseClicked(this::handleMouseClick);

        primaryStage.show();

        // record start time 记录开始的时间
        startTime = System.currentTimeMillis();

        // 创建一个初始的圆，添加到面板中
        Circle circle = createCircle();
        pane.getChildren().add(circle);
        // add new circle per sec
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> addCircle(pane)));
        timeline.setCycleCount(MAX_CIRCLES);
        timeline.setOnFinished(event -> showGameOver(pane));
        timeline.play();
    }

    private void handleMouseClick(MouseEvent event) 
    {
        Circle clickedCircle = (Circle) event.getTarget();
        Pane pane = (Pane) clickedCircle.getParent();
        pane.getChildren().remove(clickedCircle); // remove the circle after click移除点击过的圆
        clickedCircles++;
    }

    private void showGameOver(Pane pane) {
        long elapsedTime = System.currentTimeMillis() - startTime;
        Label gameOverLabel = new Label("Game Over! Elapsed Time: " + elapsedTime + " milliseconds");
        gameOverLabel.setLayoutX(10);
        gameOverLabel.setLayoutY(10);
        pane.getChildren().clear(); // 清除所有圆圈
        pane.getChildren().add(gameOverLabel);
    }

    private Circle createCircle() {
        Circle circle = new Circle(30, Color.BLUE);
        circle.relocate(random.nextInt(570), random.nextInt(370));
        return circle;
    }

    private void addCircle(Pane pane) {
        if (clickedCircles < MAX_CIRCLES) {
            Circle newCircle = createCircle();
            newCircle.setOnMouseClicked(this::handleMouseClick);
            pane.getChildren().add(newCircle);
        }
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}
