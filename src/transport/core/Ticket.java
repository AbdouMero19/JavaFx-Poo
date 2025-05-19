package transport.core;

import java.time.*;

public class Ticket extends TitreTransport {
    protected int id;
    public Ticket() {
        this.dateAchat = LocalDate.now();
        TitreTransport.id = TitreTransport.id + 1;
        this.id = TitreTransport.id;
        this.prix=50;

    }

    public double  getPrix(){
return this.prix;
    }
    public int getId() {
        return id;
    }

    public boolean estValide (LocalDate date) throws TitreNonValideException {
     if ( dateAchat.isEqual(date)) {
        return true;
     }
     else{
        throw new TitreNonValideException();
     }
    }
}
