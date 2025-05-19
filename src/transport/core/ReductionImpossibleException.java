package transport.core;


/**
 * Exception levée lorsqu'aucune réduction n'est applicable
 */
public class ReductionImpossibleException extends Exception {
    
    public ReductionImpossibleException() {
        super("Aucune réduction n'est applicable pour cet usager");
    }
    
    public ReductionImpossibleException(String message) {
        super(message);
    }
}