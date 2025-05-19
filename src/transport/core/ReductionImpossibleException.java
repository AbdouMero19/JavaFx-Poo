package transport.core;
public class ReductionImpossibleException extends Exception  {
    public String getMessage (){
       return " Vous n'avez droit aucune réduction."; 
    }
}
