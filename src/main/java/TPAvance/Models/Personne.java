package TPAvance.Models;

public class Personne {

    private String nom;
    private String prenom;
    private AdressesPostale adressePostale;


     public Personne(String nom, String prenom, AdressesPostale adressePostale) {
        this.nom = nom;
        this.prenom = prenom;
        this.adressePostale = adressePostale;
    }

    public Personne() {
    }

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    // Getters and setters for nom
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getters and setters for prenom
    public String getPrenom() {
        return prenom;
    }

    public String getFullname(){
         return this.nom.toUpperCase() + " " + this.prenom;
    }



    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return this.adressePostale.toString();}

    // Getters and setters for adressePostale
    public String getAdressePostale() {
        return adressePostale.getFullAddress();
    }

    public void setAdressePostale(AdressesPostale adressePostale) {
        this.adressePostale = adressePostale;
    }
}