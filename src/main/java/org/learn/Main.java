package org.learn;


import org.learn.controller.Controller;
import org.learn.controller.GridInitializer;
import org.learn.model.Grid;

public class Main {
    public static void main(String[] args) {
        Grid grid = GridInitializer.generateRandomGrid();
        Controller controller = new Controller(grid);
        controller.startGame();
    }
}