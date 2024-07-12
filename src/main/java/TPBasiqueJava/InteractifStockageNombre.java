package TPBasiqueJava;

import java.util.Scanner;

public class InteractifStockageNombre {
    private static final int INITIAL_CAPACITY = 5;
    private int[] tableau = new int[INITIAL_CAPACITY];
    private int taille = 0;

    public static void main(String[] args) {
        InteractifStockageNombre interactif = new InteractifStockageNombre();
        interactif.menu();
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int choix = 0;

        while (choix != 3) {
            System.out.println("\nMenu :");
            System.out.println("1. Ajouter un nombre");
            System.out.println("2. Afficher les nombres existants");
            System.out.println("3. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    ajouterNombre(scanner);
                    break;
                case 2:
                    afficherNombres();
                    break;
                case 3:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
                    break;
            }
        }

        scanner.close();
    }

    public void ajouterNombre(Scanner scanner) {
        if (taille == tableau.length) {
            agrandirTableau();
        }

        System.out.print("Entrez un nombre à ajouter : ");
        int nombre = scanner.nextInt();
        tableau[taille] = nombre;
        taille++;
        System.out.println("Nombre ajouté avec succès !");
    }

    public void afficherNombres() {
        if (taille == 0) {
            System.out.println("Aucun nombre à afficher. Le tableau est vide.");
            return;
        }

        System.out.println("\nListe des nombres existants :");
        for (int i = 0; i < taille; i++) {
            System.out.println(tableau[i]);
        }
    }

    private void agrandirTableau() {
        int newCapacity = tableau.length * 2;
        int[] newArray = new int[newCapacity];

        for (int i = 0; i < tableau.length; i++) {
            newArray[i] = tableau[i];
        }

        tableau = newArray;
        System.out.println("Le tableau a été agrandi. Nouvelle capacité : " + newCapacity);
    }
}
