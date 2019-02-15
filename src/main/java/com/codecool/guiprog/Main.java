package com.codecool.guiprog;


import com.codecool.cmdprog.Table;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));

        stage.setTitle("Óvodáskártya");
        stage.setScene(new Scene(root, 750, 500));
        stage.show();
    }

    public void handleButtonAction(ActionEvent actionEvent) {
        new Table().newGame();

    }
}
