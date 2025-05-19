package transport.core;
import java.time.*;
// Classe Usager

import java.time.LocalDate;



public class Usager extends Personne {
    static int id ;

    public Usager (String prenom , String nom , LocalDate dateNaissance , boolean handicap ) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.handicap = handicap;
        Usager.id = Usager.id + 1 ;
    }

    public static int getId() {
        return id;
    }

}