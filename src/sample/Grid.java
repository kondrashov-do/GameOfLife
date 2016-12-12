package sample;


import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.io.IOException;

public class Grid {
    public static final int LENGTH = 10;

    Cell[][] cells = new Cell[LENGTH][LENGTH];

    public GridPane createGrid() {
        GridPane root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            //init alive cells
            createField(root);
            // assignNeighbours();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }

    private void createField(GridPane pane) {
       // int length = 10;
        for (int i = 0; i < LENGTH; i++) { // column
            for (int j = 0; j < LENGTH; j++) { // row
                // Create a new rectangle in each Iteration
                cells[i][j] = new Cell(99,99,Color.WHITE);
                cells[i][j].setFill(Color.WHITE);
                pane.setRowIndex(cells[i][j], j);
                pane.setColumnIndex(cells[i][j], i);
                pane.getChildren().add(cells[i][j]);
            }
        }
    }

    public void assignNeighbours() {
        for (int i = 1; i < LENGTH - 1; i++) {
            for (int j = 1; j < LENGTH - 1; j++) {
                cells[j][i].neighbours[0] = cells[j-1][i-1];
                cells[j][i].neighbours[1] = cells[j][i-1];
                cells[j][i].neighbours[2] = cells[j+1][i-1];
                cells[j][i].neighbours[3] = cells[j+1][i];
                cells[j][i].neighbours[4] = cells[j+1][i+1];
                cells[j][i].neighbours[5] = cells[j][i+1];
                cells[j][i].neighbours[6] = cells[j-1][i+1];
                cells[j][i].neighbours[7] = cells[j-1][i];
            }
        }
    }

    public void activateFutureGeneration(GridPane pane) {
        for (int i = 0; i < LENGTH; i++) { // column
            for (int j = 0; j < LENGTH; j++) { // row
                cells[j][i].checkNextGenerationState();
            }
        }

        for (int i = 0; i < LENGTH; i++) { // column
            for (int j = 0; j < LENGTH; j++) { // row
                cells[j][i].activateNextGenerationState();
            }
        }
    }

}
