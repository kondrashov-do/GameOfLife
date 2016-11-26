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
        }
        return root;
    }

    public void createField(GridPane pane) {

        int length = 10;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                // Create a new rectangle in each Iteration
                rectangles[i][j] = new Rectangle(99,99,Color.WHITE);
                pane.setColumnIndex(rectangles[i][j], i);
                pane.setRowIndex(rectangles[i][j], j);
                pane.getChildren().add(rectangles[i][j]);
            }
        }
        addCell(pane, 0,0);
        //for (int j = 0; j < length; j++) {
        //    if (pane.getChildren().) {

        //    }
        //}


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
