package sample;


import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.w3c.dom.css.Rect;

import java.io.IOException;
import java.util.Random;

public class Controller {

    public GridPane createGrid() {
        GridPane root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            //init alive cells

            createKillCell(root);

            //
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }

    public void createKillCell(GridPane pane) {

        int length = 10;
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < 10; x++) {


                // Create a new TextField in each Iteration
                Rectangle tf = new Rectangle(99,99,Color.WHITE);

                // Iterate the Index using the loops
                pane.setRowIndex(tf, y);
                pane.setColumnIndex(tf, x);
                pane.getChildren().add(tf);
            }
        }

        Rectangle tf = new Rectangle(99,99,Color.BLACK);
        pane.setRowIndex(tf, 1);
        pane.setColumnIndex(tf, 1);
        pane.getChildren().add(tf);

        tf = new Rectangle(99,99,Color.WHITE);
        pane.setRowIndex(tf, 1);
        pane.setColumnIndex(tf, 1);
        pane.getChildren().add(tf);


    }

}
