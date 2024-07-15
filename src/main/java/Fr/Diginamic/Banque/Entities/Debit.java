package Fr.Diginamic.Banque.Entities;
import Fr.Diginamic.Banque.Entities.Compte;
public class Debit extends Operation {
    private Compte compte;

    @Override
    public String getType() {
        return "Extract";

    }

        void Retrait(double montant) {
        double soldeFinal  = compte.getSolde() - montant;
        compte.setSolde(soldeFinal);
    }
}
