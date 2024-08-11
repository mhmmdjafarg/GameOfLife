package org.learn.ui;

import org.learn.model.Cell;
import org.learn.model.Grid;

public class GameRenderer implements Display{
    @Override
    public void printConsole(Grid grid, int stateCounter) {
        try {
            System.out.print("\033\143");
            System.out.flush();
            printGrid(grid);
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.printf("Exception %s\n", e.getMessage());
        }
    }

    private void printCell(Cell cell) {
        System.out.print(cell.isAlive() ? "⬛" : "⬜");
    }

    public void printGrid(Grid grid) {
        for (Cell[] cell : grid.getCells()) {
            for (Cell value : cell) {
                printCell(value);
            }
            System.out.println();
        }
    }
}
