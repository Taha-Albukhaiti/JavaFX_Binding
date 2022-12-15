package com.example.javafx_testing;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import javax.crypto.Cipher;
import java.io.IOException;
import java.util.Map;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Slider slider = new Slider(10, 100, 40);
        Circle circle = new Circle();
        circle.radiusProperty().bind(slider.valueProperty());
        TextField radius = new TextField();
        radius.textProperty().bind(slider.valueProperty().asString("%.2f"));
        TextField area = new TextField();
        area.textProperty().bind(
                slider.valueProperty().
                        multiply(slider.valueProperty()).
                        multiply(Math.PI).
                        asString("%.2f"));

        Node[] nodes = {slider, new Label("Radius:"), radius,
                new Label("Fläsche:"), area, circle };
        stage.setScene(new Scene(new VBox(4, nodes), 300, 400));
        stage.show();
        /*
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

         */
    }

    public static void main(String[] args) {
        launch();
    }
}