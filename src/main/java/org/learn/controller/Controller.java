package org.learn.controller;

import org.learn.model.Grid;
import org.learn.ui.GameRenderer;

import static java.lang.Thread.sleep;

public class Controller {
    private Grid grid;
    private final GameRenderer gameRenderer;
    private final GameService gameService;

    private int stateCounter = 1;
    private boolean isStart;

    public Controller(Grid grid, GameService gameService, GameRenderer gameRenderer) {
        this.grid = grid;
        this.gameService = gameService;
        this.gameRenderer = gameRenderer;
        this.isStart = true;
    }

    public void startGame() throws InterruptedException {
        while (!gameService.isGridEmpty(grid) && isStart) {
            gameRenderer.renderConsole(this.grid, stateCounter);
            grid = gameService.nextState(grid);
            stateCounter++;
            sleep(500);
        }
        gameRenderer.renderConsole(this.grid, stateCounter);
    }

    public void stopAndResetGame() {
        isStart = false;
        stateCounter = 1;
    }
}
