package transport.core;

import java.time.LocalDate;
import java.time.Period;

/**
 * Représente une carte personnelle de transport avec différentes réductions
 * selon le profil de l'usager (junior, senior, solidarité, partenaire)
 */
public class CartePersonnelle extends TitreTransport {
  protected String Nom;
  protected String prenom;
  protected Typecarte type;

  // Getters
  public String getNom() {
      return Nom;
  }
  
  public String getPrenom() {
      return prenom;
  }
  
  public Typecarte getType() {
      return type;
  }
  
  // Setters
  public void setNom(String nom) {
      Nom = nom;
  }
  
  public void setPrenom(String prenom) {
      this.prenom = prenom;
  }
  
  public void setType(Typecarte type) {
      this.type = type;
  }

  /**
   * Constructeur prenant en paramètre une personne
   * @param usager La personne pour qui créer la carte
   * @throws ReductionImpossibleException Si aucune réduction n'est applicable
   */
  public CartePersonnelle(Personne usager) throws ReductionImpossibleException {
    this.Nom = usager.nom;
    this.prenom = usager.prenom;
    calculateReduction(usager);
    // Bug: ligne suivante à supprimer car elle fait échouer la création systématiquement
    // throw new ReductionImpossibleException();
  }

  /**
   * Calcule la réduction applicable selon le profil de l'usager
   * @param usager La personne pour qui calculer la réduction
   * @throws ReductionImpossibleException Si aucune réduction n'est applicable
   */
  public void calculateReduction(Personne usager) throws ReductionImpossibleException {
    if (usager.getHandicap() == true) {
      this.prix = 5000 * 0.5;
      this.type = Typecarte.SOLIDARITÉ;
      return;
    }
    
    if (usager instanceof Employe) {
      this.prix = 5000 * 0.6;
      this.type = Typecarte.PARTENAIRE;
      return;
    }
    
    if (Period.between(usager.getdateNaissance(), LocalDate.now()).getYears() <= 25) {
      this.prix = 5000 * 0.7;
      this.type = Typecarte.JUNIOR;
      return;
    }

    if (Period.between(usager.getdateNaissance(), LocalDate.now()).getYears() >= 65) {
      this.prix = 5000 * 0.75;
      this.type = Typecarte.SENIOR;
      return;
    }
    
    throw new ReductionImpossibleException();
  }
  
  /**
   * Vérifie si la carte est valide à la date actuelle
   * @param dateAchat Date d'achat de la carte
   * @return true si la carte est valide
   * @throws TitreNonValideException Si la carte n'est plus valide
   */
  public boolean estValide(LocalDate dateAchat) throws TitreNonValideException {
    if (Period.between(dateAchat, LocalDate.now()).getYears() < 1) {
      return true;
    } else {
      throw new TitreNonValideException();
    }
  }
}