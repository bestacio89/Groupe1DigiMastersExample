package ConwayLife;

import java.util.Random;
import java.util.Scanner; // Added for user input

public class ConwayLifeGame {

    private final Grid grid;
    private final Random random;
    private int generations = 0;
    private double aliveProb;

    public ConwayLifeGame(int height, int width, double aliveProbability) {
        this.grid = new Grid(height, width);
        this.random = new Random();
        initializeRandomCells(aliveProbability);
        aliveProb = aliveProbability;
    }

    private void initializeRandomCells(double aliveProbability) {
        for (int i = 0; i < grid.getHeight(); i++) {
            for (int j = 0; j < grid.getWidth(); j++) {
                grid.setCell(i, j, random.nextDouble() < aliveProbability);
            }
        }
    }
    private void setGrid(String pattern) {
        String[] lines = pattern.split("\n");
        int patternHeight = lines.length;
        int patternWidth = lines[0].length();

        // Ensure pattern fits within grid boundaries
        if (patternHeight > grid.getHeight() || patternWidth > grid.getWidth()) {
            throw new IllegalArgumentException("Oscillator pattern too large for grid.");
        }

        for (int i = 0; i < patternHeight; i++) {
            for (int j = 0; j < patternWidth; j++) {
                grid.setCell(i, j, lines[i].charAt(j) == '*'); // Set alive based on 'X' character
            }
        }
    }
    private void printGrid(Grid grid) {
        for (int i = 0; i < grid.getHeight(); i++) {
            for (int j = 0; j < grid.getWidth(); j++) {
                System.out.print(grid.getCell(i, j).isAlive() ? '*' : '-'); // 'X' for alive, '-' for dead
            }
            System.out.println(); // Newline after each row
        }
    }

    public void setCell(int i, int j, boolean alive) {
        if (isValidCell(i, j)) {
            grid.setCell(i, j, alive);
        }
    }

    public Cell getCell(int i, int j) {
        return isValidCell(i, j) ? grid.getCell(i, j) : null;
    }

    private boolean isValidCell(int i, int j) {
        return i >= 0 && i < grid.getHeight() && j >= 0 && j < grid.getWidth();
    }

    public int getNeighbours(int i, int j) {
        int neighbours = 0;
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                // Skip the current cell
                if (di == 0 && dj == 0) {
                    continue;
                }
                int newI = (i + di + grid.getHeight()) % grid.getHeight();
                int newJ = (j + dj + grid.getWidth()) % grid.getWidth();
                neighbours += grid.getCell(newI, newJ) != null && grid.getCell(newI, j).isAlive() ? 1 : 0;
            }
        }
        return neighbours;
    }

    public void evolve() {
        Grid newGrid = new Grid(grid.getHeight(), grid.getWidth()); // Consider using a builder pattern here
        for (int i = 0; i < grid.getHeight(); i++) {
            for (int j = 0; j < grid.getWidth(); j++) {
                int neighbours = getNeighbours(i, j);
                Cell cell = grid.getCell(i, j);
                if (cell.isAlive()) {
                    // A living cell survives if it has 2 or 3 neighbors
                    newGrid.setCell(i, j, neighbours == 2 || neighbours == 3);
                } else {
                    // A dead cell comes alive if it has exactly 3 neighbors
                    newGrid.setCell(i, j, neighbours == 3);
                }
            }
        }
        // Update the grid with the new generation
        grid.copyGrid(newGrid);
        generations++;
    }

    public Grid getGrid() {
        return grid;
    }

    public String startGame() {
        Scanner scanner = new Scanner(System.in);


        // User Input for Initialization Type
        System.out.println("Choose initialization type (1: Random, 2: User-defined Oscillator, 3: Predefined Oscillator, 4: Spaceship): ");
        int choice = scanner.nextInt();

        String initializationType = ""; // String to store initialization type for return
        switch (choice) {
            case 1:
                // Random initialization
                initializeRandomCells(aliveProb);
                initializationType = "Random Initialization";
                break;
            case 2:
                // User-defined oscillator
                String[] pattern = getUserInputForOscillator(scanner);
                if (pattern != null) {
                    setOscillator(pattern);
                    initializationType = "User-defined Oscillator";
                } else {
                    System.out.println("Empty oscillator pattern provided. Defaulting to random initialization.");
                    initializeRandomCells(aliveProb);
                    initializationType = "Random Initialization (Empty Oscillator)";
                }
                break;
            case 3:
                if (isSpaceshipLibraryAvailable()) { // Optional check for SpaceshipLibrary
                    System.out.println("Spaceship library not available. Defaulting to random initialization.");
                    initializeRandomCells(aliveProb);
                    initializationType = "Random Initialization (Oscillator Library Missing)";
                } else {
                    setGrid(chooseRandomPattern(OscillatorLibrary.oscillators, aliveProb));
                    initializationType = "Predefined Oscillator (Random)";
                }
                break;
            case 4:
                String randomSpaceship = getRandomSpaceship();
                if (randomSpaceship != null) {
                    setGrid(randomSpaceship);
                    initializationType = "Spaceship (Random)";
                } else {
                    System.out.println("Spaceship library not available. Defaulting to random initialization.");
                    initializeRandomCells(aliveProb);
                    initializationType = "Random Initialization (Spaceship Library Missing)";
                }
                break;
            default:
                System.out.println("Invalid choice. Defaulting to random initialization.");
                initializeRandomCells(aliveProb);
                initializationType = "Random Initialization (Invalid Choice)";
        }

        // Game loop (modified to run until user exits)
        while (true) {
            System.out.println("\nGeneration: " + generations);
            printGrid(grid); // Assuming you have a printGrid method to visualize the grid
            evolve();

            System.out.println("\nPress Enter to continue, or 'q' to quit: ");
            String userChoice = scanner.nextLine();
            if (userChoice.equalsIgnoreCase("q")) {
                break;
            }

            try {
                Thread.sleep(500); // Pause between generations (adjust as needed)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return initializationType; // Return the chosen initialization type
    }



    private String[] getUserInputForOscillator(Scanner scanner) {
        System.out.println("Enter the oscillator pattern (lines separated by newline): ");
        StringBuilder patternBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break; // Stop reading at an empty line
            }
            patternBuilder.append(line).append("\n");
        }
        return patternBuilder.toString().trim().isEmpty() ? null : patternBuilder.toString().split("\n");
    }
    private String getRandomOscillator() { // New method for random oscillator
        return getRandomPattern(OscillatorLibrary.oscillators);
    }

    private String getRandomSpaceship() { // New method for random spaceship (if library available)
        if (isSpaceshipLibraryAvailable()) {
            return getRandomPattern(SpaceshipLibrary.spaceships);
        } else {
            return null; // Indicate spaceship library not available (optional)
        }
    }

    private boolean isOscillatorLibraryAvailable() { // Optional method to check for SpaceshipLibrary
        try {
            Class.forName("OscillatorLibrary"); // Attempt to find the class
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private boolean isSpaceshipLibraryAvailable() { // Optional method to check for SpaceshipLibrary
        try {
            Class.forName("SpaceshipLibrary"); // Attempt to find the class
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
    private String chooseRandomPattern(String[] library, double aliveProbability) {
        String chosenPattern = getRandomPattern(library); // Get a random pattern string
        StringBuilder newPattern = new StringBuilder();

        for (char c : chosenPattern.toCharArray()) {
            if (c == '*') { // Alive cell in the pattern
                newPattern.append(Math.random() < aliveProbability ? '*' : '-'); // Replace with alive/dead based on probability
            } else {
                newPattern.append(c); // Keep non-alive characters (spaces or borders)
            }
        }


        return newPattern.toString();
    }

    private String getRandomPattern(String[] library) {
        int randomIndex = random.nextInt(library.length);
        return library[randomIndex];
    }

    private void setOscillator(String[] pattern) {
        int patternHeight = pattern.length;
        int patternWidth = 0;
        for (String line : pattern) {
            patternWidth = Math.max(patternWidth, line.length()); // Find the maximum line length
        }

        // Check if pattern dimensions fit within the grid
        if (patternHeight > grid.getHeight() || patternWidth > grid.getWidth()) {
            System.out.println("Oscillator pattern too large for the grid. Defaulting to random initialization.");
            return;
        }

        // Set cells based on the pattern
        int offsetY = (grid.getHeight() - patternHeight) / 2;
        int offsetX = (grid.getWidth() - patternWidth) / 2;

        for (int i = 0; i < patternHeight; i++) {
            String line = pattern[i];
            for (int j = 0; j < line.length(); j++) {
                char cellChar = line.charAt(j);
                boolean alive = cellChar == 'X' || cellChar == 'x'; // Alive if 'X' or 'x'
                grid.setCell(offsetY + i, offsetX + j, alive);
            }
        }
    }
}