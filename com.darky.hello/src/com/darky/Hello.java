package com.darky;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Hello extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {
        Button btn1 = new Button("Click me!");
        Label lbl1 = new Label("HELLOOOO WOOOORLD!!!!");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(lbl1, btn1);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.setAlignment(Pos.CENTER);

        btn1.setOnAction(e -> {
            Label lbl2 = new Label("You are a sheep!");

            StackPane layout2 = new StackPane();
            layout2.getChildren().addAll(lbl2);

            Scene scene2 = new Scene(layout2, 640, 480);
            window.setScene(scene2);
            window.show();
        });

        Scene scene = new Scene(layout, 640, 480);
        window.setScene(scene);
        window.setTitle("Hello World!");
        window.show();
    }
}
