package sample;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class GameOfLife extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello Game Of Life");
        Grid myGrid = new Grid();
        primaryStage.setScene(new Scene(myGrid.createField(), 1000, 1000));
        //assign neighbours
        myGrid.initialize();
        primaryStage.show();

        Task updateFieldTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                while (true) {
                    for (int i = 1; i < myGrid.getLength()-1; i++) {
                        for (int j = 1; j < myGrid.getLength()-1; j++) {
                            myGrid.cells[j][i].checkNextGenerationState();
                        }
                    }
                    for (int i = 1; i < myGrid.getLength()-1; i++) {
                        for (int j = 1; j < myGrid.getLength()-1; j++) {
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
