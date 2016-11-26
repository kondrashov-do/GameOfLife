package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{


       // root.getChildren().remove(cellName);

        primaryStage.setTitle("Hello Game Of Life");
        Controller myController = new Controller();
        primaryStage.setScene(new Scene(myController.createGrid(), 1000, 1000));
        primaryStage.show();
        myController.rectangles[0][0].setFill(Color.RED);
        for (int j = 0; j < 10-1; j++) {
            if (myController.rectangles[0][j + 1].getFill() == Color.WHITE  ) {
                myController.addCell(0, j+1);
                myController.removeCell(0, j);
            }
            Thread.sleep(1500);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
