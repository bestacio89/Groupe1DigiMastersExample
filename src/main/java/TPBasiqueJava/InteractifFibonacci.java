package TPBasiqueJava;

import java.util.Scanner;

public class InteractifFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Demande à l'utilisateur d'entrer un nombre entre 1 et 46
        System.out.print("Entrez un nombre entre 1 et 46 pour calculer le nombre de Fibonacci : ");
        int n = scanner.nextInt();

        // Vérifie que le nombre est entre 1 et 46
        if (n < 1 || n > 46) {
            System.out.println("Nombre invalide. Veuillez entrer un nombre entre 1 et 46.");
        } else {
            // Calcule et affiche le nombre de Fibonacci pour le rang n
            long nombreFibonacci = fibonacci(n);
            System.out.println("Le nombre de Fibonacci au rang " + n + " est : " + nombreFibonacci);
        }

        scanner.close();
    }

    // Méthode récursive pour calculer le nombre de Fibonacci
    public static long fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Entrée invalide : le rang Fibonacci ne peut pas être négatif.");
        }
        if (n <= 1) {
            return n;
        }

        // Appel récursif à fibonacciRecursive avec les valeurs initiales
        return fibonacciRecursive(0, 1, n - 1);
    }

    // Méthode récursive privée pour calculer Fibonacci
    private static long fibonacciRecursive(int fib1, int fib2, int n) {
        if (n == 0) {
            return fib2; // Renvoie Fibonacci(n)
        }

        int fibonacciNumber = fib1 + fib2;

        // Vérifie si fibonacciNumber dépasse la limite int
        if (fibonacciNumber < 0) {
            throw new ArithmeticException("Le nombre de Fibonacci dépasse la limite int.");
        }

        // Appel récursif avec les nouvelles valeurs
        return fibonacciRecursive(fib2, fibonacciNumber, n - 1);
    }
}
