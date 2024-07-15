package Fr.Diginamic.Banque.Entities;

public class Compte {

    public Compte(double solde, String numDeCompte) {
        Solde = solde;
        NumDeCompte = numDeCompte;
    }

    private String NumDeCompte;
    private double Solde;

    public String getNumDeCompte()
    {
        return NumDeCompte;
    }

    public void setNumDeCompte(String numDeCompte) {
        NumDeCompte = numDeCompte;
    }

    public void setSolde(double solde) {
        Solde = solde;
    }

    public String getSolde() {
        return "Votre solde sur le compte " + NumDeCompte+ " est de: "  + Solde;
    }

    void Retrait(double montant) {
        double soldeFinal  = this.Solde - montant;
        setSolde(soldeFinal);
    }
}
