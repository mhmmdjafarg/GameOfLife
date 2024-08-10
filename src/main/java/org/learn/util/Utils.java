package org.learn.util;

import org.learn.model.Cell;
import org.learn.model.Grid;

public class Utils {

    public static int countAliveNeighbors(Grid grid, int row, int col) {
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

    public static boolean isShouldLive(Cell cell, int aliveNeighbours) {
        return cell.isAlive() ? (aliveNeighbours == 2 || aliveNeighbours == 3) : (aliveNeighbours == 3);
    }

    public static boolean isGridEmpty(Grid grid) {
        for (Cell[] cell : grid.getCells()) {
            for (Cell value : cell) {
                if (value.isAlive()) {
                    return false;
                }
            }
        }
        return true;
    }
}
