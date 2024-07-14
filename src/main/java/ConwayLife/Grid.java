package ConwayLife;

public class Grid {
    private final Cell[][] cells;
    private final int height;
    private final int width;

    public Grid(int height, int width) {
        this.height = height;
        this.width = width;
        this.cells = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public void setCell(int i, int j, boolean alive) {
        if (isValidCell(i, j)) {
            cells[i][j].setAlive(alive);
        }
    }

    public Cell getCell(int i, int j) {
        return isValidCell(i, j) ? cells[i][j] : null;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    private boolean isValidCell(int i, int j) {
        return i >= 0 && i < height && j >= 0 && j < width;
    }

    // Added method to copy cell states from another Grid object
    public void copyGrid(Grid newGrid) {
        if (newGrid.getHeight() != height || newGrid.getWidth() != width) {
            throw new IllegalArgumentException("Grid dimensions must match");
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cells[i][j].setAlive(newGrid.getCell(i, j).isAlive());
            }
        }
    }
}
