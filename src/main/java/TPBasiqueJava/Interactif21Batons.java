package TPBasiqueJava;

import java.util.Scanner;

public class Interactif21Batons {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int batons = 21;
        System.out.println("Bienvenue dans le jeu des 21 Bâtons!");

        while (batons > 0) {
            // Tour du joueur
            System.out.println("Bâtons restants : " + batons);
            int choixJoueur = demanderChoixJoueur(batons);
            batons -= choixJoueur;

            if (batons <= 0) {
                System.out.println("Vous avez pris le dernier bâton. Vous avez perdu!");
                break;
            }

            // Tour de l'ordinateur
            int choixOrdinateur = choisirNombreAleatoire();
            System.out.println("L'ordinateur prend " + choixOrdinateur + " bâton(s).");
            batons -= choixOrdinateur;

            if (batons <= 0) {
                System.out.println("L'ordinateur a pris le dernier bâton. Vous avez gagné!");
                break;
            }
        }

        scanner.close();
    }

    // Méthode pour demander le choix du joueur et valider l'entrée
    public static int demanderChoixJoueur(int batonsRestants) {
        Scanner scanner = new Scanner(System.in);
        int choix = 0;
        boolean choixValide = false;

        while (!choixValide) {
            System.out.print("Combien de bâtons voulez-vous retirer (1, 2 ou 3) ? ");
            choix = scanner.nextInt();

            if (choix >= 1 && choix <= 3 && choix <= batonsRestants) {
                choixValide = true;
            } else {
                System.out.println("Choix invalide. Veuillez entrer 1, 2 ou 3, en respectant le nombre de bâtons restants.");
            }
        }

        return choix;
    }

    // Méthode pour que l'ordinateur choisisse un nombre aléatoire de bâtons à retirer
    public static int choisirNombreAleatoire() {
        return (int) (Math.random() * 3) + 1; // Génère un nombre aléatoire entre 1 et 3 inclusivement
    }
}
