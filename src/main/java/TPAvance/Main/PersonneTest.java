package TPAvance.Main;

import TPAvance.Models.AdressesPostale;
import TPAvance.Models.Personne;

public class PersonneTest {
    public static void main(String[] args) {

        // Create two instances of Personne
        Personne personne1 = new Personne();
        Personne personne2 = new Personne();

        // Set information for the first person
        personne1.setNom("Doe");
        personne1.setPrenom("John");

        // Create an AdressesPostale object for personne1
        AdressesPostale adresse1 = new AdressesPostale();
        adresse1.setNumeroDerue(123);
        adresse1.setLibelleDeRue("Main Street");
        adresse1.setVille("Anytown");
        adresse1.setCodePostale("12345");
        personne1.setAdressePostale(adresse1);

        // Set information for the second person
        personne2.setNom("Smith");
        personne2.setPrenom("Jane");

        // Create an AdressesPostale object for personne2
        AdressesPostale adresse2 = new AdressesPostale();
        adresse2.setNumeroDerue(456);
        adresse2.setLibelleDeRue("Elm Street");
        adresse2.setVille("Springfield");
        adresse2.setCodePostale("54321");
        personne2.setAdressePostale(adresse2);

        // Print the information for both people (optional)
        System.out.println("Personne 1:");
        System.out.println("  Nom: " + personne1.getNom());
        System.out.println("  Prénom: " + personne1.getPrenom());
        System.out.println("  Adresse:");
        System.out.println("    Numéro de rue: " + personne1.getAdressePostale().getNumeroDerue());
        System.out.println("    Libellé de rue: " + personne1.getAdressePostale().getLibelleDeRue());
        System.out.println("    Ville: " + personne1.getAdressePostale().getVille());
        System.out.println("    Code postal: " + personne1.getAdressePostale().getCodePostale());

        System.out.println("\nPersonne 2:");
        System.out.println("  Nom: " + personne2.getNom());
        System.out.println("  Prénom: " + personne2.getPrenom());
        System.out.println("  Adresse:");
        System.out.println("    Numéro de rue: " + personne2.getAdressePostale().getNumeroDerue());
        System.out.println("    Libellé de rue: " + personne2.getAdressePostale().getLibelleDeRue());
        System.out.println("    Ville: " + personne2.getAdressePostale().getVille());
        System.out.println("    Code postal: " + personne2.getAdressePostale().getCodePostale());
    }
}
