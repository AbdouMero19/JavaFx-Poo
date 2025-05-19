package transport.core;

import java.time.*;

// Classe abstraite Personne
abstract public class Personne {
    protected  String nom;
    protected  String prenom;
    protected  LocalDate dateNaissance;
    protected  boolean handicap;
        
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setHandicap(boolean Handicap) {
        this.handicap = Handicap;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public LocalDate getdateNaissance() {
        return dateNaissance;
    }

    public boolean getHandicap() {
        return handicap;
    }


    


}

