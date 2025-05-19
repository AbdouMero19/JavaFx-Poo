package transport.core;

import java.io.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

/**
 * Classe qui gère la persistance et le tri des titres de transport.
 * Les titres sont stockés par ordre décroissant de la date d'achat (le plus récent en premier).
 */
public class GestionDeDonne  {
    

    
    // TreeMap pour stocker les titres par date d'achat (ordre décroissant)
    private Map<LocalDate, TitreTransport> titresParDate = new TreeMap<>(Collections.reverseOrder());
    
    // Map pour accéder rapidement aux titres par ID
    private Map<Integer, TitreTransport> titresParId = new HashMap<>();
    

    

    
    // Comparateur pour trier les titres par ID quand ils ont la même date
    private static class TitreComparator implements Comparator<TitreTransport>, Serializable {

        
        @Override
        public int compare(TitreTransport t1, TitreTransport t2) {
            if (t1.getId() == t2.getId()) return 0;
            return t1.getId() - t2.getId();
        }
    }


    public void ajouterTitre(TitreTransport titre) {
        if (titre == null) return;
        
        LocalDate dateAchat = titre.getDateAchat();
        titresParId.put(titre.getId(), titre);
        
        // Ajouter dans le TreeMap trié par date



            titresParDate.put(dateAchat, titre);
            }
    /**
     * Récupère un titre par son ID
     * @param id L'ID du titre
     * @return Le titre ou null s'il n'existe pas
     */
    public TitreTransport getTitreParId(int id) {
        return titresParId.get(id);
    }

    /**
     * Récupère la liste de tous les titres triés par date d'achat (décroissant)
     * @return La liste des titres triés du plus récent au plus ancien
     */
    public List<TitreTransport> getTitresParDateDecroissante() {
        List<TitreTransport> resultat = new ArrayList<>();
    
    // Utiliser directement les valeurs de la Map titresParId qui contient tous les titres
    // sans se soucier de la structure de titresParDate
    for (TitreTransport titre : titresParId.values()) {
        resultat.add(titre);
    }
    
    // Trier la liste par date décroissante
    resultat.sort((t1, t2) -> t2.getDateAchat().compareTo(t1.getDateAchat()));
    
    return resultat;
}
}