package org.learn.model;

import org.learn.ui.Display;

public class Cell implements Display {
    private final CellState state;

    public Cell(CellState state) {
        this.state = state;
    }

    public boolean isAlive() {
        return this.state == CellState.ALIVE;
    }

    @Override
    public void printConsole() {
        System.out.print(isAlive() ? "⬜ " : "⬛ ");
    }
}
