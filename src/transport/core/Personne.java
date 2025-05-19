package transport.core;

import java.time.LocalDate;

public class Personne {
    public String nom;
    public String prenom;
    public LocalDate dateNaissance;
    public boolean handicap;
    
    /**
     * Constructeur sans argument (par défaut)
     */
    public Personne() {
        this.nom = "";
        this.prenom = "";
        this.dateNaissance = LocalDate.now().minusYears(30); // Par défaut, 30 ans
        this.handicap = false;
    }
    
    /**
     * Constructeur avec tous les paramètres
     */
    public Personne(String nom, String prenom, LocalDate dateNaissance, boolean handicap) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.handicap = handicap;
    }
    
    public LocalDate getdateNaissance() {
        return dateNaissance;
    }
    
    public boolean getHandicap() {
        return handicap;
    }
    
    /**
     * Définit le nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * Définit le prénom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    /**
     * Définit la date de naissance
     */
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    
    /**
     * Définit le statut de handicap
     */
    public void setHandicap(boolean handicap) {
        this.handicap = handicap;
    }
}