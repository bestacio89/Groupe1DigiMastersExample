package Fr.Diginamic.Banque.Entities;

public class Credit extends Operation {


    private Compte compte;
      public Credit(Compte compte) {
          this.compte = compte;
    }

    @Override
    public String getType() {
        return "Deposit";

    }

     public void Depot(double montant) {
        double soldeFinal  = compte.getSolde() + montant;
        System.out.println("Vous venez de recevoir un depot");
        compte.setSolde(soldeFinal);
     }
}
