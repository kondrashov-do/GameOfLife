package sample;


import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class Controller {

     public GridPane createGrid()
     {
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

     public void createKillCell(GridPane pane)
     {
         Text cellName = new Text("Cell"); // [Column] [Row]
         Text cellName2 = new Text("Cell");
         pane.add(cellName, 0, 0);
         pane.add(cellName2, 0, 8);
     }

}
