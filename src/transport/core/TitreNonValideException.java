package transport.core;

public class TitreNonValideException extends Exception {
   
    
    public String getMessage (){
        return "Ticket numéro 1 expiré - valable uniquement le : 2025-04-22";
    }
}
