package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell  extends Rectangle {

    Cell[] neighbours = new Cell[8];
    boolean alive = false;
    boolean aliveInNextGeneration = false;
    int positionX = 0;
    int positionY = 0;

    public Cell(int i, int j, Color c) {
        super(i, j, c);

    }

    boolean isAlive() {
        return this.alive;
    }
    void makeAlive() {
        this.alive = true;
        super.setFill(Color.RED);
    }

    void activateNextGenerationState() {
        this.alive = this.aliveInNextGeneration;
    if (this.alive) {
        super.setFill(Color.RED);
    }
        else {
        super.setFill(Color.WHITE);
    }

    }

    void checkNextGenerationState() {
        int amountOfAliveNeighbours = 0;
        for (int i = 0; i < neighbours.length; i++) {
            if (neighbours[i].isAlive()) {
                amountOfAliveNeighbours = amountOfAliveNeighbours + 1;
            }
        }
        if (this.isAlive() && amountOfAliveNeighbours < 2) {
            this.aliveInNextGeneration = false;
        }
        else if(this.isAlive() && amountOfAliveNeighbours < 4 && amountOfAliveNeighbours > 1) {
            this.aliveInNextGeneration = true;
        }
        else if(this.isAlive() && amountOfAliveNeighbours > 3) {
            this.aliveInNextGeneration = false;
        }
        else if(!this.isAlive() && amountOfAliveNeighbours == 3) {
            this.aliveInNextGeneration = true;
        }
    }


}
