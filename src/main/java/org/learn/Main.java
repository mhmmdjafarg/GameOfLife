package org.learn;


import org.learn.controller.Controller;
import org.learn.controller.GameService;
import org.learn.model.Grid;
import org.learn.ui.FileIO;
import org.learn.ui.GameRenderer;
import org.learn.util.GridInitializer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GameService gameService = new GameService();
        GameRenderer gameRenderer = new GameRenderer();
//        Grid grid = GridInitializer.generateRandomGrid();
        Grid grid = FileIO.loadGrid("/Users/muhammad.gundari/Documents/learn/GameOfLife/src/main/java/org/learn/ui/input1.txt");
        Controller controller = new Controller(grid, gameService, gameRenderer);
        controller.startGame();
    }
}