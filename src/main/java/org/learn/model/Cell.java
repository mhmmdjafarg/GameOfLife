package org.learn.model;

public class Cell {
    private final CellState state;

    public Cell(CellState state) {
        this.state = state;
    }

    public boolean isAlive() {
        return this.state == CellState.ALIVE;
    }
}
