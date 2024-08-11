package org.learn.model;

public class Grid {
    private final Cell[][] cells;

    public Grid(Cell[][] cells) {
        this.cells = cells;
    }

    public Grid(int height, int width) {
        this.cells = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cells[i][j] = new Cell(CellState.EMPTY);
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCell(int x, int y, Cell cell) {
        this.cells[x][y] = cell;
    }

    public int getWidth() {
        return cells.length;
    }

    public int getHeight() {
        return cells[0].length;
    }

    public boolean isGridEmpty() {
        for (Cell[] cell : this.cells) {
            for (Cell value : cell) {
                if (value.isAlive()) {
                    return false;
                }
            }
        }
        return true;
    }
}
