package org.learn.ui;

import org.learn.model.Grid;

public class GameRenderer {

    public void renderConsole(Grid grid, int currentStateNumber) {
        System.out.println("======================== START OF STATE ========================");
        System.out.printf("State number: %d\n", currentStateNumber);
        System.out.printf("Alive cells: %d\n", grid.getAliveCells());
        System.out.printf("Empty cells: %d\n", grid.getEmptyCells());
        grid.printConsole();
        System.out.println("========================= END OF STATE =========================");
    }
}
