package org.learn.ui;

import org.learn.model.Cell;
import org.learn.model.CellState;
import org.learn.model.Grid;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {
    private static final int PADDING = 1;

    public static Grid loadGrid(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        String line;
        int width = 0;
        int height = 0;

        // Determine grid dimensions
        while ((line = reader.readLine()) != null) {
            width = line.length();
            height++;
        }
        reader.close();

        // Calculate new dimensions with padding
        int paddedWidth = width + 2 * PADDING;
        int paddedHeight = height + 2 * PADDING;
        Grid grid = new Grid(paddedHeight, paddedWidth);

        // Read the file again to populate the grid
        reader = new BufferedReader(new FileReader(filename));
        int row = PADDING;
        while ((line = reader.readLine()) != null) {
            for (int col = 0; col < line.length(); col++) {
                CellState state = line.charAt(col) == '#' ? CellState.ALIVE : CellState.EMPTY;
                grid.setCell(row, col+PADDING, new Cell(state));
            }
            row++;
        }
        reader.close();

        return grid;
    }
}
