package ConwayLife;

import ConwayLife.Models.ConwayLifeGame;

import java.util.Scanner;

public class ConwayGameMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter grid height (default 20): ");
        int height = scanner.nextInt();
        if (height <= 0) {
            height = 20; // Set default if invalid input
            System.out.println("Invalid height. Using default grid size (20x20).");
        }

        System.out.println("Enter grid width (default 20): ");
        int width = scanner.nextInt();
        if (width <= 0) {
            width = 20;
            System.out.println("Invalid width. Using default grid size (20x20).");
        }


        System.out.println("Enter alive probability (0.0 - 1.0): ");
        double aliveProbability = scanner.nextDouble();
        if (aliveProbability < 0.0 || aliveProbability > 1.0) {
            aliveProbability = 0.5; // Set default if invalid input
            System.out.println("Invalid alive probability. Using default (0.5).");
        }

        // Create a ConwayLifeGame instance with alive probability
        ConwayLifeGame game = new ConwayLifeGame(height, width, aliveProbability);

        // Start the game
        game.startGame();

       }
}
