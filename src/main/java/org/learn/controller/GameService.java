package org.learn.controller;

import org.learn.model.Cell;
import org.learn.model.CellState;
import org.learn.model.Grid;

public class GameService {
    private int countAliveNeighbors(Grid grid, int row, int col) {
        int aliveNeighbors = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int r = row + i;
                int c = col + j;
                if (r >= 0 && r < grid.getCells().length && c >= 0 && c < grid.getCells()[0].length) {
                    if (grid.getCells()[r][c].isAlive()) {
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

    public boolean isGridEmpty(Grid grid) {
        for (Cell[] cell : grid.getCells()) {
            for (Cell value : cell) {
                if (value.isAlive()) {
                    return false;
                }
            }
        }
        return true;
    }

    public Grid nextState(Grid grid) {
        Cell[][] nextCells = new Cell[grid.getWidth()][grid.getHeight()];
        int rowSize = grid.getWidth();
        int colSize = grid.getHeight();
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                int aliveNeighbours = countAliveNeighbors(grid, i, j);
                boolean isShouldAlive = isShouldLive(grid.getCells()[i][j], aliveNeighbours);
                nextCells[i][j] = isShouldAlive ? new Cell(CellState.ALIVE) : new Cell(CellState.EMPTY);
            }
        }
        return new Grid(nextCells);
    }
}
