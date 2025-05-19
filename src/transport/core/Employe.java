package transport.core;


import java.time.LocalDate;

/**
 * Représente un employé d'une entreprise partenaire
 */
public class Employe extends Personne {
    private String entreprise;
    private String matricule;
    
    /**
     * Constructeur
     * @param nom Nom de l'employé
     * @param prenom Prénom de l'employé
     * @param dateNaissance Date de naissance
     * @param handicap Indique si l'employé est en situation de handicap
     * @param entreprise Nom de l'entreprise
     * @param matricule Numéro de matricule
     */
    public Employe(String nom, String prenom, LocalDate dateNaissance, boolean handicap,
                   String entreprise, String matricule) {
        super(nom, prenom, dateNaissance, handicap);
        this.entreprise = entreprise;
        this.matricule = matricule;
    }
    
    /**
     * Obtient le nom de l'entreprise
     * @return Le nom de l'entreprise
     */
    public String getEntreprise() {
        return entreprise;
    }
    
    /**
     * Obtient le matricule de l'employé
     * @return Le matricule
     */
    public String getMatricule() {
        return matricule;
    }
}