package transport.core;


/**
 * Exception levée lorsqu'un titre de transport n'est plus valide
 */
public class TitreNonValideException extends Exception {
    
    public TitreNonValideException() {
        super("Ce titre de transport n'est plus valide");
    }
    
    public TitreNonValideException(String message) {
        super(message);
    }
}