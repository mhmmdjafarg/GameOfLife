package org.learn.util;

import org.learn.model.Cell;
import org.learn.model.CellState;
import org.learn.model.Grid;

import java.util.Random;

public class GridInitializer {
    private static final int GRID_SIZE = 10;
    private static final int PADDING = 1;

    public static Grid generateRandomGrid() {
        Grid grid = new Grid(GRID_SIZE + 2 * PADDING, GRID_SIZE + 2 * PADDING);
        Random random = new Random();

        for (int i = PADDING; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                // Randomly set the cell to be ALIVE or DEAD
                boolean isAlive = random.nextBoolean();
                Cell cell = new Cell(isAlive ? CellState.ALIVE : CellState.EMPTY);
                grid.setCell(i, j + PADDING, cell);
            }
        }
        return grid;
    }
}
