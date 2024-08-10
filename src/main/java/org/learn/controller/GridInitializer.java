package org.learn.controller;

import org.learn.model.Cell;
import org.learn.model.CellState;
import org.learn.model.Grid;

import java.util.Random;

public class GridInitializer {
    private static final int GRID_SIZE = 5;

    public static Grid generateRandomGrid() {
        Cell[][] cells = new Cell[GRID_SIZE][GRID_SIZE];
        Random random = new Random();

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                // Randomly set the cell to be ALIVE or DEAD
                boolean isAlive = random.nextBoolean();
                cells[i][j] = new Cell(isAlive ? CellState.ALIVE : CellState.EMPTY);
            }
        }
        return new Grid(cells);
    }
}
