package org.learn.model;

import org.learn.controller.GameUI;

public class Cell implements GameUI {
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
