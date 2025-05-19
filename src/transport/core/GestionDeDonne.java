package transport.core;

import java.io.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class GestionDeDonne  {


    private static Map<LocalDate, TitreTransport> titresParDate = new TreeMap<>(Comparator.comparing(LocalDate::toEpochDay));
    // Map pour accéder rapidement aux titres par ID
    private static Map<Integer, TitreTransport> titresParId = new HashMap<>();
    

    

    
    // Comparateur pour trier les titres par ID quand ils ont la même date
    private static class TitreComparator implements Comparator<TitreTransport>, Serializable {

        
        @Override
        public int compare(TitreTransport t1, TitreTransport t2) {
            if (t1.getId() == t2.getId()) return 0;
            return t1.getId() - t2.getId();
        }
    }


    public static void ajouterTitre(TitreTransport titre) {
        
        LocalDate dateAchat = titre.getDateAchat();

        titresParId.put(titre.getId(), titre);
        
        // Ajouter dans le TreeMap trié par date

            titresParDate.put(dateAchat, titre);
            }

    public static TitreTransport getTitreParId(int id) {
        return titresParId.get(id);
    }


    public static List<TitreTransport> getTitresParDateDecroissante() {
        List<TitreTransport> resultat = new ArrayList<>();

    for (TitreTransport titre : titresParId.values()) {
        resultat.add(titre);
    }
    
    // Trier la liste par date décroissante
    resultat.sort(Comparator.comparing(TitreTransport::getDateAchat));
    
    return resultat;
}
}