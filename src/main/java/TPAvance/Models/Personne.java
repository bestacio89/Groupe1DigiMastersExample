package TPAvance.Models;

public class Personne {

    private String nom;
    private String prenom;
    private AdressesPostale adressePostale;

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

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // Getters and setters for adressePostale
    public AdressesPostale getAdressePostale() {
        return adressePostale;
    }

    public void setAdressePostale(AdressesPostale adressePostale) {
        this.adressePostale = adressePostale;
    }
}