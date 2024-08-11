package org.learn.model;

import org.learn.ui.Display;

public class Grid implements Display {
    private final Cell[][] cells;

    private final int aliveCells;
    private final int emptyCells;

    public Grid(Cell[][] cells) {
        this.cells = cells;
        this.aliveCells = countAliveCells();
        this.emptyCells = getHeight() * getWidth() - aliveCells;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int getAliveCells() {
        return aliveCells;
    }

    public int getEmptyCells() {
        return emptyCells;
    }

    public int getWidth() {
        return cells.length;
    }

    public int getHeight() {
        return cells[0].length;
    }

    private int countAliveCells() {
        int aliveCount = 0;
        for (Cell[] cell : cells)
            for (Cell value : cell) {
                if (value.isAlive()) {
                    aliveCount++;
                }
            }
        return aliveCount;
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
