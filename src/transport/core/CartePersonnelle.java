package transport.core;
import java.time.*;


public class CartePersonnelle extends TitreTransport {
  protected String Nom;
  protected String prenom;
  protected Typecarte type;

  //getters
  public String getNom() {
      return Nom;
  }
  public String getPrenom() {
      return prenom;
  }
  public Typecarte getType() {
      return type;
  }
  //setters
  public void setNom(String nom) {
      Nom = nom;
  }
  public void setPrenom(String prenom) {
      this.prenom = prenom;
  }
  public void setType(Typecarte type) {
      this.type = type;
  }

  //constructor 
  public CartePersonnelle(Personne usager) throws ReductionImpossibleException {
      try {
          this.Nom = usager.nom;
          this.prenom = usager.prenom;
          this.dateAchat = LocalDate.now();
          calculateReduction(usager);
      } catch (Exception e) {
   throw new ReductionImpossibleException();

      }
   }

  public void  calculateReduction(Personne usager) throws ReductionImpossibleException{
   if (usager.getHandicap()==true){
    this.prix=5000*0.5;
    this.type=Typecarte.SOLIDARITÉ;

    return ;
    
  }
 if (usager instanceof Employe){
    this.prix=5000*0.6;
    this.type=Typecarte.PARTENAIRE;
    return;
 }
 if (Period.between(LocalDate.now(),usager.getdateNaissance()).getYears()<=25) {
 this.prix=5000*0.7;
 this.type=Typecarte.JUNIOR;
 return;

 }

 if (Period.between(LocalDate.now(), usager.getdateNaissance()).getYears() >= 65) {
     this.prix = 5000 * 0.75;
     this.type = Typecarte.SENIOR;
     return;

 }
 throw new ReductionImpossibleException();

  }
  
  public boolean  estValide (LocalDate dateAchat) throws TitreNonValideException {
    if (Period.between( LocalDate.now(),dateAchat.plusYears(1)).getYears() <= 1  ) {
        return true;
     }
     else{
        throw new TitreNonValideException();
     }
  }

}
