package org.openjfx;

import org.openjfx.components.Clock;
import org.openjfx.components.FetchPictureButton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox vBox = new VBox(
            new Clock(),
            new StackPane(new FetchPictureButton())
        );

        var scene = new Scene(vBox, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}