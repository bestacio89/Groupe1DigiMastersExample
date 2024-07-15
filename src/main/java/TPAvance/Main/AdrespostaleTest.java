package TPAvance.Main;

import TPAvance.Models.AdressesPostale;

public class AdrespostaleTest {
    public static void main(String[] args) {

        // Create two instances of AdressesPostale
        AdressesPostale adresse1 = new AdressesPostale();
        AdressesPostale adresse2 = new AdressesPostale();

        // Set information for the first address
        adresse1.setNumeroDerue(123);
        adresse1.setLibelleDeRue("Main Street");
        adresse1.setVille("Anytown");
        adresse1.setCodePostale("12345");

        // Set information for the second address
        adresse2.setNumeroDerue(456);
        adresse2.setLibelleDeRue("Elm Street");
        adresse2.setVille("Springfield");
        adresse2.setCodePostale("54321");

        // Print the information for both addresses (optional)
        System.out.println("Adresse 1:");
        System.out.println("  Numéro de rue: " + adresse1.getNumeroDerue());
        System.out.println("  Libellé de rue: " + adresse1.getLibelleDeRue());
        System.out.println("  Ville: " + adresse1.getVille());
        System.out.println("  Code postal: " + adresse1.getCodePostale());

        System.out.println("\nAdresse 2:");
        System.out.println("  Numéro de rue: " + adresse2.getNumeroDerue());
        System.out.println("  Libellé de rue: " + adresse2.getLibelleDeRue());
        System.out.println("  Ville: " + adresse2.getVille());
        System.out.println("  Code postal: " + adresse2.getCodePostale());
    }
}
