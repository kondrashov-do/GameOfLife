package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell  extends Rectangle {

    public Cell(int i, int j, Color c) {
        super(i, j, c);

    }

    Cell[] neighbours = new Cell[8];

    boolean alive = false;
    boolean aliveInNextGeneration = false;
    int positionX = 0;
    int positionY = 0;

    boolean isAlive() {
        return this.alive;
    }

    void makeAlive(boolean alive) {
        this.alive = alive;
    }

    void makeAliveInNextGeneration() {

        int amountOfAliveNeghbours = 0;
        for (int i = 0; i < neighbours.length; i++) {
            if (neighbours[i].isAlive()) {
                amountOfAliveNeghbours += 1;
            }
        }
        if ((this.isAlive() && (amountOfAliveNeghbours == 2 || amountOfAliveNeghbours == 3)) || !this.isAlive() && amountOfAliveNeghbours == 3) {
            this.aliveInNextGeneration = true;
        }
        else {
            this.aliveInNextGeneration = false;
        }
    }


}
