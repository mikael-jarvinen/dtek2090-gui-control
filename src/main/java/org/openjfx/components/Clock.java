package org.openjfx.components;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// displays the current time in a label, updated every 100 milliseconds.
public class Clock extends StackPane {

    private Label timeLabel;
    private DateTimeFormatter timeFormatter;

    public Clock() {
        timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        timeLabel = new Label();
        timeLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        this.setAlignment(Pos.CENTER);
        this.getChildren().add(timeLabel);

        // Start the clock
        startClock();
    }

    private void startClock() {
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.millis(100), event -> updateTime())
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void updateTime() {
        String currentTime = LocalTime.now().format(timeFormatter);
        timeLabel.setText(currentTime);
    }
}