package TPAvance.Main;

import TPAvance.Models.AdressesPostale;
import TPAvance.Models.Personne;

public class PersonneTest {
    public static void main(String[] args) {

        // Example 1: Using parameterized constructor
        System.out.println("Example 1: Using parameterized constructor");
        String adresseComplete = "10 Maple Street, Newville, 98765";
        Personne personneComplete = new Personne("Lee", "Michael", new AdressesPostale(10,
                "Maple Street", "Newville", "98675"  ));

        System.out.println("  Nom: " + personneComplete.getNom());
        System.out.println("  Prénom: " + personneComplete.getPrenom());
        System.out.println("  Adresse: " + personneComplete.getAdressePostale());

        System.out.println("\nExample 2: Using parameterized constructor");
        System.out.println("  Creating Personne object...");
        String adresseIncomplete = "22 Oak Avenue, Anytown";
        Personne personneEmpty = new Personne("Brown", "Jessica", new AdressesPostale(22, "Oak Avenue",
                "Anytown", "35658"));

        System.out.println("  Personne information:");
        System.out.println("    Fullname: " + personneEmpty.getFullname());
        System.out.println("    Adresse: " + personneEmpty.getAdressePostale());
    }
}
