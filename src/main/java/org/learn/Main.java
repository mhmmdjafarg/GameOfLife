package org.learn;


import org.learn.controller.Controller;
import org.learn.controller.GameService;
import org.learn.util.GridInitializer;
import org.learn.model.Grid;
import org.learn.ui.GameRenderer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GameService gameService = new GameService();
        GameRenderer gameRenderer = new GameRenderer();
        Grid grid = GridInitializer.generateRandomGrid();
        Controller controller = new Controller(grid, gameService, gameRenderer);
        controller.startGame();
    }
}