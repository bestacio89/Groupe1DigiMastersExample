package TPAvance.Main;

import TPAvance.Models.AdressesPostale;

public class AdrespostaleTest {
    public static void main(String[] args) {

        // Create two instances of AdressesPostale using the parameterless constructor
        AdressesPostale adresse1 = new AdressesPostale();
        AdressesPostale adresse2 = new AdressesPostale();

        // Set information for the first address
        adresse1.setNumeroDerue(123);
        adresse1.setLibelleDeRue("Main Street");
        adresse1.setVille("Anytown");
        adresse1.setCodePostale("12345");

        // Create two instances of AdressesPostale using the parameterized constructor
        AdressesPostale adresse3 = new AdressesPostale(456, "Elm Street", "Springfield", "54321");
        AdressesPostale adresse4 = new AdressesPostale(789, "Maple Avenue", "Smalltown", "67890");

        // Print the full address for addresses created using the parameterless constructor
        System.out.println("Adresse 1:");
        System.out.println("  Full Address: " + adresse1.getFullAddress());

        System.out.println("\nAdresse 2:");
        System.out.println("  Full Address: " + adresse2.getFullAddress());

        // Print the full address for addresses created using the parameterized constructor
        System.out.println("\nAdresse 3:");
        System.out.println("  Full Address: " + adresse3.getFullAddress());

        System.out.println("\nAdresse 4:");
        System.out.println("  Full Address: " + adresse4.getFullAddress());
    }
}
