package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{

        GridPane root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Text cellName = new Text("Cell"); // [Column] [Row]
        root.add(cellName, 0, 0);
        root.getChildren().remove(cellName);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
