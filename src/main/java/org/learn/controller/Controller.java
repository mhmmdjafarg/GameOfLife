package org.learn.controller;

import org.learn.model.Cell;
import org.learn.model.CellState;
import org.learn.model.Grid;
import org.learn.util.Utils;

public class Controller implements GameUI {
    private final Grid grid;
    private int stateCounter = 1;

    public Controller(Grid grid) {
        this.grid = grid;
        stateCounter = 1;
    }

    public void startGame() {
        while (!Utils.isGridEmpty(this.grid)) {
            printConsole();
            nextState();
        }
        printConsole();
        stateCounter = 1;
    }

    private void nextState() {
        Cell[][] nextCells = new Cell[grid.getCells().length][grid.getCells()[0].length];
        int rowSize = grid.getCells().length;
        int colSize = grid.getCells()[0].length;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                int aliveNeighbours = Utils.countAliveNeighbors(this.grid, i, j);
                boolean isShouldAlive = Utils.isShouldLive(grid.getCells()[i][j], aliveNeighbours);
                nextCells[i][j] = isShouldAlive ? new Cell(CellState.ALIVE) : new Cell(CellState.EMPTY);
            }
        }
        this.grid.setCells(nextCells);
        stateCounter++;
    }

    @Override
    public void printConsole() {
        System.out.printf("State number %d: \n", stateCounter);
        this.grid.printConsole();
        System.out.println();
        System.out.println("------------------------------");
    }
}
