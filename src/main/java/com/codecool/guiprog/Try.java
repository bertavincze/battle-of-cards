package com.codecool.guiprog;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Try extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Óvodáskártya");
        Pane root = new Pane();

        primaryStage.setScene(new Scene(root, 500, 450));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
