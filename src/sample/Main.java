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
        Grid myGrid = new Grid();
        primaryStage.setScene(new Scene(myGrid.createGrid(), 1000, 1000));
        myGrid.cells[0][0].setFill(Color.BLUE);//[column] [row]
        primaryStage.show();
        //implimentaion of the rule


        Task updateFieldTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                //SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                while (true) {
                    //updateMessage(sdf.format(new Date()));

                    for (int j = 0; j < 10 - 1; j++) {
                        if (myGrid.cells[j+1][0].getFill() == Color.WHITE) {
                            myGrid.removeCell(j, 0);
                            myGrid.addCell(j+1,0);
                        }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        break;
                    }
                }
                    return null;
                }
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
