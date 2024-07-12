package TPBasiqueJava;

import java.util.Scanner;

public class InteractifSommeArithmetique {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez entrer un nombre: ");
        int nb = scanner.nextInt();
        int somme = 0;

        for (int i = 1; i <= nb; i++) {
            somme += i;
        }

        System.out.println("La somme de tous les entiers entre 1 et " + nb + " est : " + somme);
        scanner.close(); // Fermer le scanner
    }
}
