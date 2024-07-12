package Entites;


public class AdressesPostale {

        private int numeroDerue; // Encapsulation with private fields
        private String libelleDeRue;
        private String ville;
        private String codePostale;

        // Getters
        public int getNumeroDerue() {
            return numeroDerue;
        }

        public void setNumeroDerue(int numeroDerue) {
            this.numeroDerue = numeroDerue;
        }

        public String getLibelleDeRue() {
            return libelleDeRue;
        }

        public void setLibelleDeRue(String libelleDeRue) {
            this.libelleDeRue = libelleDeRue;
        }

        public String getVille() {
            return ville;
        }

        public void setVille(String ville) {
            this.ville = ville;
        }

        public String getCodePostale() {
            return codePostale;
        }

        public void setCodePostale(String codePostale) {
            this.codePostale = codePostale;
        }
}
