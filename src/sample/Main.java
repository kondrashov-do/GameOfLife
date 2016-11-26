package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{


       // root.getChildren().remove(cellName);

        primaryStage.setTitle("Hello Game Of Life");
        primaryStage.setScene(new Scene(new Controller().createGrid(), 1000, 1000));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
