package TPBasiqueJava;

import java.util.Scanner;

public class InteractifTantque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nb = 0;

        // Boucle Tant Que pour demander un nombre à l'utilisateur
        while (true) {
            System.out.print("Veuillez entrer un nombre entre 1 et 10: ");
            nb = scanner.nextInt();

            if (nb >= 1 && nb <= 10) {
                break;  // Si le nombre est compris entre 1 et 10, sortir de la boucle
            } else {
                System.out.println("Le nombre doit être compris entre 1 et 10. Veuillez réessayer.");
            }
        }

        // Afficher le nombre valide
        System.out.println("Vous avez entré le nombre: " + nb);
        scanner.close(); // Fermer le scanner
    }
}
