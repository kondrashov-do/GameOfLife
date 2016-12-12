package sample;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class Main extends Application {
    public static final int LENGTH = 10;

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Hello Game Of Life");
        Grid myGrid = new Grid();
        primaryStage.setScene(new Scene(myGrid.createGrid(), 1000, 1000));
        //assign neighbours
        myGrid.assignNeighbours();
        //initial state of the field

        myGrid.cells[2][1].makeAlive();//[column] [row]
        myGrid.cells[2][2].makeAlive();//[column] [row]
        myGrid.cells[2][3].makeAlive();//[column] [row]

        myGrid.cells[5][4].makeAlive();//[column] [row]
        myGrid.cells[5][5].makeAlive();//[column] [row]
        myGrid.cells[5][6].makeAlive();//[column] [row]
       // myGrid.cells[4][5].makeAlive();//[column] [row]
       // myGrid.cells[6][5].makeAlive();//[column] [row]

        primaryStage.show();

        Task updateFieldTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                while (true) {
                    for (int i = 1; i < LENGTH-1; i++) {
                        for (int j = 1; j < LENGTH-1; j++) {
                            myGrid.cells[j][i].checkNextGenerationState();
                        }
                    }

                    for (int i = 1; i < LENGTH-1; i++) {
                        for (int j = 1; j < LENGTH-1; j++) {
                            myGrid.cells[j][i].activateNextGenerationState();
                        }
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
        Thread rulesThread = new Thread(updateFieldTask);
        rulesThread.setName("Apply Game of Life Rules");
        rulesThread.setDaemon(true);
        rulesThread.start();

    }




    public static void main(String[] args) {
        launch(args);


    }
}
