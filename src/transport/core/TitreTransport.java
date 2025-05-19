package transport.core;
import java.time.*;


// Classe abstraite pour les titres de transport
abstract public class TitreTransport {
       
    protected  static int id;
    protected LocalDate dateAchat;
    protected double prix;
    

    // getters 
    

    public LocalDate getDateAchat() {
        return dateAchat;
    }

    public double getPrix() {
        return prix;
    }

    //setters
    public void setDateAchat(LocalDate dateAchat) {
        this.dateAchat = dateAchat;
    }
    public void setId(int id) {
        TitreTransport.id = id;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }

    abstract  public boolean  estValide (LocalDate dateAchat) throws TitreNonValideException ;
    
}