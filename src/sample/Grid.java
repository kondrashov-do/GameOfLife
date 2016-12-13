package sample;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import java.io.IOException;

public class Grid {
    public static final int LENGTH = 100;

    int getLength() {
        return this.LENGTH;
    }

    Cell[][] cells = new Cell[LENGTH][LENGTH];

    public GridPane createField() {
        GridPane root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            //init alive cells
            create(root);
            // assignNeighbours();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }

    private void create(GridPane pane) {
        for (int i = 0; i < LENGTH; i++) { // column
            for (int j = 0; j < LENGTH; j++) { // row
                // Create a new rectangle in each Iteration
                cells[i][j] = new Cell(9,9,Color.WHITE);
                cells[i][j].setFill(Color.WHITE);
                pane.setRowIndex(cells[i][j], j);
                pane.setColumnIndex(cells[i][j], i);
                pane.getChildren().add(cells[i][j]);
            }
        }
        assignNeighbours();
    }

    public void init() {
        //initial state of the field
        cells[2][1].makeAlive();//[column] [row]
        cells[2][2].makeAlive();//[column] [row]
        cells[2][3].makeAlive();//[column] [row]

        cells[5][4].makeAlive();//[column] [row]
        cells[5][5].makeAlive();//[column] [row]
        cells[5][6].makeAlive();//[column] [row]
    }

    private void assignNeighbours() {
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

}
