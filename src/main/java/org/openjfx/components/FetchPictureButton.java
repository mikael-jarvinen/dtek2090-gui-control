package org.openjfx.components;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// Renders a button, when clicked fetches a random picture from the internet and displays it.

public class FetchPictureButton extends VBox {

    private Button fetchButton;
    private ImageView imageView;

    public FetchPictureButton() {
        fetchButton = new Button("Fetch Picture");
        imageView = new ImageView();

        fetchButton.setOnAction(event -> fetchPicture());

        HBox buttonBox = new HBox(fetchButton);

        buttonBox.setAlignment(javafx.geometry.Pos.CENTER);
        buttonBox.setPadding(new Insets(50, 10, 20, 10));

        HBox imageViewBox = new HBox(imageView);
        imageViewBox.setAlignment(javafx.geometry.Pos.CENTER);

        // Render the button and the ImageView both centered horizontally.
        this.getChildren().addAll(buttonBox, imageViewBox);
    }

    // Fetches a random picture from the internet asynchronously in a new thread to avoid the UI from freezing.
    // The picture is displayed in the ImageView when it is fetched.
    private void fetchPicture() {
        new Thread(() -> {
            try {
                URL url = new URL("https://random.imagecdn.app/500/150");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();

                if (connection.getResponseCode() == 200) {
                    InputStream inputStream = connection.getInputStream();
                    Image image = new Image(inputStream);
                    Platform.runLater(() -> imageView.setImage(image));
                } else {
                    System.out.println("Failed to fetch picture: " + connection.getResponseCode());
                }

                connection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}