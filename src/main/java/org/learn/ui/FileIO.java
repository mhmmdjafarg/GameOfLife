package org.learn.ui;

import org.learn.model.Cell;
import org.learn.model.CellState;
import org.learn.model.Grid;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {
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

        Grid grid = new Grid(height, width);

        // Read the file again to populate the grid
        reader = new BufferedReader(new FileReader(filename));
        int row = 0;
        while ((line = reader.readLine()) != null) {
            for (int col = 0; col < line.length(); col++) {
                CellState state = line.charAt(col) == '#' ? CellState.ALIVE : CellState.EMPTY;
                grid.setCell(row, col, new Cell(state));
            }
            row++;
        }
        reader.close();

        return grid;
    }
}
