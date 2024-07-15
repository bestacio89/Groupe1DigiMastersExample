package ConwayLife.Models;
public class Cell {

    private boolean alive;
    private int x; // Optional: X-coordinate within the grid
    private int y; // Optional: Y-coordinate within the grid
    private int age; // Optional: Tracks the number of generations the cell has been alive

    public Cell() {
        this.alive = false;
        this.age = 0;
    }

    public Cell(boolean alive) {
        this.alive = alive;
        this.age = 0;
    }

    public Cell(boolean alive, int x, int y) { // Constructor with coordinates
        this.alive = alive;
        this.x = x;
        this.y = y;
        this.age = 0;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    // Optional getters and setters for coordinates
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Optional methods for age tracking
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void incrementAge() {
        age++;
    }
}
