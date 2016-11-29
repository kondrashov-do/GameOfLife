package sample;


import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class Controller {

    Rectangle[][] rectangles = new Rectangle[10][10];

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
                rectangles[i][j] = new Rectangle(99,99,Color.WHITE);
                rectangles[i][j].setFill(Color.WHITE);
                pane.setRowIndex(rectangles[i][j], j);
                pane.setColumnIndex(rectangles[i][j], length-1-i);
                pane.getChildren().add(rectangles[i][j]);
            }
        }
      /*  rectangles[0][0].setFill(Color.RED);
        for (int j = 0; j < length-1; j++) {
            if (rectangles[0][j + 1].getFill() == Color.WHITE  ) {
                addCell(0, j+1);
                removeCell(0, j);
            }
        }
        */
    }

    public void removeCell(int row, int column) {
        rectangles[column][row].setFill(Color.WHITE);
    }

    public void addCell(int row, int column) {
        rectangles[column][row].setFill(Color.RED);
    }
}
