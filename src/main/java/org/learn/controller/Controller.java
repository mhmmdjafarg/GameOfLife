package org.learn.controller;

import org.learn.model.Grid;
import org.learn.ui.Display;

public class Controller {
    private Grid grid;
    private final Display display;
    private final GameService gameService;

    private int stateCounter = 1;
    private boolean isStart;

    public Controller(Grid grid, GameService gameService, Display display) {
        this.grid = grid;
        this.gameService = gameService;
        this.display = display;
        this.isStart = true;
    }

    public void startGame() {
        while (!grid.isGridEmpty() && isStart) {
            display.printConsole(grid, stateCounter);
            grid = gameService.nextState(grid);
            stateCounter++;
        }
        display.printConsole(grid, stateCounter);
    }

    public void stopAndResetGame() {
        isStart = false;
        stateCounter = 1;
    }
}
