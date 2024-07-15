package Fr.Diginamic.Banque; // Assuming a Test package for this class

import Fr.Diginamic.Banque.Entities.Compte;

public class Main {

    public static void main(String[] args) {
        // Initializing account number and balance
        String numCompte = "123456";
        double solde = 1000.00;

        // Create a Compte object
        Compte compte = new Compte(solde, numCompte);

        // Display account details
        System.out.println(compte.getSolde());
        System.out.println(compte);

    }
}