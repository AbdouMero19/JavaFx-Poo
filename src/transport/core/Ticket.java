package transport.core;
import java.time.*;

public class Ticket extends TitreTransport {

    public Ticket() {
        this.dateAchat = LocalDate.now();
        TitreTransport.id = TitreTransport.id + 1;
        this.prix=50;

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
