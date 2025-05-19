package transport.core;

import java.time.*;
// Classe Employé

public class Employe extends Personne {
    protected String id ;
    protected TypeFonction typeFonction ; 

    public String getId() {
        return id;
    }

    public TypeFonction getTypeFonction() {
        return typeFonction;
    }

    public void setTypeFonction(TypeFonction typeFonction) {
        this.typeFonction = typeFonction;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Employe (String prenom , String nom , LocalDate dateNaissance , boolean handicap , String id , TypeFonction type) {
        this.prenom = prenom;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.handicap = handicap;
        this.id = id;
        this.typeFonction = type;

    }
}