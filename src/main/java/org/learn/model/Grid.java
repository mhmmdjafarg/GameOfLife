package org.learn.model;

import org.learn.controller.GameUI;

public class Grid implements GameUI {
    private Cell[][] cells;

    public Grid(Cell[][] cells) {
        this.cells = cells;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    @Override
    public void printConsole() {
        for (Cell[] cell : cells) {
            for (Cell value : cell) {
                value.printConsole();
            }
            System.out.println();
        }
    }
}
