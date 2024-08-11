package org.learn.controller;

import org.learn.model.Cell;
import org.learn.model.CellState;
import org.learn.model.Grid;

public class GameService {
    private int countAliveNeighbors(Grid grid, int currX, int currY) {
        int aliveNeighbors = 0;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0) continue;
                int actualX = currX + x;
                int actualY = currY + y;
                if (actualX >= 0 && actualX < grid.getWidth() && actualY >= 0 && actualY < grid.getHeight()) {
                    if (grid.getCells()[actualX][actualY].isAlive()) {
                        aliveNeighbors++;
                    }
                }
            }
        }
        return aliveNeighbors;
    }

    private boolean isShouldLive(Cell cell, int aliveNeighbours) {
        return cell.isAlive() ? (aliveNeighbours == 2 || aliveNeighbours == 3) : (aliveNeighbours == 3);
    }

    public Grid nextState(Grid grid) {
        Cell[][] nextCells = new Cell[grid.getWidth()][grid.getHeight()];
        int rowSize = grid.getWidth();
        int colSize = grid.getHeight();
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                int aliveNeighbours = countAliveNeighbors(grid, row, col);
                boolean isShouldAlive = isShouldLive(grid.getCells()[row][col], aliveNeighbours);
                nextCells[row][col] = isShouldAlive ? new Cell(CellState.ALIVE) : new Cell(CellState.EMPTY);
            }
        }
        return new Grid(nextCells);
    }
}
