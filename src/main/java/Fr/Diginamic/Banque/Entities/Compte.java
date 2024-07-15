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


    public void setSolde(double solde) {
        Solde = solde;
    }

    public String PrintSolde() {
        return "Votre solde sur le compte " + NumDeCompte+ " est de: "  + Solde;
    }

     public double getSolde(){
        return Solde;
     }



}
