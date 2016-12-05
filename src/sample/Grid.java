package sample;


import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class Grid {

    Cell[][] cells = new Cell[10][10];

    public GridPane createGrid() {
        GridPane root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            //init alive cells

            createField(root);

            //
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }

    public void createField(GridPane pane) {

        int length = 10;
        for (int i = 0; i < length; i++) { // column
            for (int j = 0; j < length; j++) { // row
                // Create a new rectangle in each Iteration
                cells[i][j] = new Cell(99,99,Color.WHITE);
                cells[i][j].setFill(Color.WHITE);
                pane.setRowIndex(cells[i][j], j);
                pane.setColumnIndex(cells[i][j], i);//length-1-i);
                pane.getChildren().add(cells[i][j]);
            }
        }
      /*  cells[0][0].setFill(Color.RED);
        for (int j = 0; j < length-1; j++) {
            if (cells[0][j + 1].getFill() == Color.WHITE  ) {
                addCell(0, j+1);
                removeCell(0, j);
            }
        }
        */
    }

    public void removeCell(int column,int row) {
        this.cells[column][row].setFill(Color.WHITE);
    }

    public void addCell( int column, int row) {
        this.cells[column][row].setFill(Color.RED);
    }
}
