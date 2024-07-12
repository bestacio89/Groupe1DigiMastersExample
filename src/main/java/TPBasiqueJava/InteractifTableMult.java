package TPBasiqueJava;

import java.util.Scanner;

public class InteractifTableMult {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nb = 0;

        // Boucle pour demander un nombre à l'utilisateur
        while (true) {
            System.out.print("Veuillez entrer un nombre entre 1 et 10: ");
            nb = scanner.nextInt();

            if (nb >= 1 && nb <= 10) {
                break;  // Si le nombre est compris entre 1 et 10, sortir de la boucle
            } else {
                System.out.println("Le nombre doit être compris entre 1 et 10. Veuillez réessayer.");
            }
        }

        // Afficher la table de multiplication du nombre
        System.out.println("Table de " + nb + " :");
        for (int i = 1; i <= 10; i++) {
            System.out.println(nb + " * " + i + " = " + (nb * i));
        }

        scanner.close(); // Fermer le scanner
    }
}
