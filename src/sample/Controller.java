package sample;


import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sun.text.resources.cldr.ia.FormatData_ia;

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
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return root;
    }

    public void createField(GridPane pane) throws InterruptedException {

        int length = 10;
        for (int i = 0; i < length; i++) { // row
            for (int j = 0; j < length; j++) { // column
                // Create a new rectangle in each Iteration
                rectangles[i][j] = new Rectangle(99,99,Color.WHITE);
                rectangles[i][j].setFill(Color.WHITE);
                pane.setRowIndex(rectangles[i][j], i);
                pane.setColumnIndex(rectangles[i][j], j);
                pane.getChildren().add(rectangles[i][j]);
            }
        }
        rectangles[0][0].setFill(Color.RED);
        for (int j = 0; j < length-1; j++) {
            if (rectangles[0][j + 1].getFill() == Color.WHITE  ) {
                rectangles[0][j + 1].setFill(Color.RED);
                rectangles[0][j].setFill(Color.WHITE);
            }

        }


    }

    public void removeCell(GridPane pane, int column, int row) {
        Rectangle rectangle = new Rectangle(99,99,Color.WHITE);

        pane.setColumnIndex(rectangle, column);
        pane.setRowIndex(rectangle, row);
        pane.getChildren().add(rectangle);
    }

    public void addCell(GridPane pane, int column, int row) {
        Rectangle rectangle = new Rectangle(99,99,Color.BLACK);
        pane.setColumnIndex(rectangle, column);
        pane.setRowIndex(rectangle, row);
        pane.getChildren().add(rectangle);
    }
}
