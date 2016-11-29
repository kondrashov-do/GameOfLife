package sample;

import javafx.application.Application;
import javafx.concurrent.Task;
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
        //implimentaion of the rule


        Task updateFieldTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                //SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                while (true) {
                    //updateMessage(sdf.format(new Date()));
                    myController.rectangles[0][0].setFill(Color.RED);
                    for (int j = 0; j < 10-1; j++) {
                        if (myController.rectangles[j+1][0].getFill() == Color.WHITE  ) {
                            myController.addCell(0, j+1);
                            myController.removeCell(0, j);
                        }
                        // Thread.sleep(1500);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        break;
                    }
                }
                return null;
            }
        };
        //dynamicTimeDisplayLabel2.textProperty().bind(updateFieldTask.messageProperty());
        Thread rulesThread = new Thread(updateFieldTask);
        rulesThread.setName("Apply Game of Life Rules");
        rulesThread.setDaemon(true);
        rulesThread.start();

    }




    public static void main(String[] args) {
        launch(args);


    }
}
