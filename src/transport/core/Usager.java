package transport.core;

import java.time.*;
// Classe Usager

public class Usager extends Personne {

    static int id=0 ;
    private int userID;


    public Usager (String prenom , String nom , LocalDate dateNaissance , boolean handicap ) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.handicap = handicap;
        Usager.id = Usager.id + 1 ;
        this.userID = id;
    }

    public static int getId() {
        return id;
    }

    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
  
}