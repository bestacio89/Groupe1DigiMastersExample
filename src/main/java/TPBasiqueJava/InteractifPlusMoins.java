package TPBasiqueJava;

import java.util.Random;
import java.util.Scanner;

public class InteractifPlusMoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int nombreMystere = random.nextInt(100) + 1;
        int essais = 0;
        int proposition = 0;

        System.out.println("Bienvenue au jeu du Plus ou Moins ! Devinez le nombre entre 1 et 100.");

        while (proposition != nombreMystere) {
            System.out.print("Votre proposition: ");
            proposition = scanner.nextInt();
            essais++;

            if (proposition < nombreMystere) {
                System.out.println("C'est plus !");
            } else if (proposition > nombreMystere) {
                System.out.println("C'est moins !");
            } else {
                System.out.println("Bravo, vous avez trouvé en " + essais + " coups !");
            }
        }

        scanner.close(); // Fermer le scanner
    }
}
