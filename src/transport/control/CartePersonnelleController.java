package transport.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import transport.core.*;

import java.awt.*;
import java.time.LocalDate;

public class CartePersonnelleController {
    
    /**
     * Crée une carte personnelle pour un usager
     * @param usager La personne pour qui créer la carte
     * @return La carte personnelle créée
     * @throws ReductionImpossibleException Si aucune réduction n'est applicable
     */
    public CartePersonnelle creerCartePersonnelle(Personne usager) throws ReductionImpossibleException {
        try {
            // Correction du bug dans le constructeur de CartePersonnelle
            // Le constructeur actuel lance toujours une exception, nous devons donc
            // créer la carte et calculer la réduction manuellement
            CartePersonnelle carte = new CartePersonnelle(usager);
            carte.calculateReduction(usager);
            return carte;
        } catch (ReductionImpossibleException e) {
            throw new ReductionImpossibleException("Aucune réduction applicable pour cet usager");
        }
    }
    
    /**
     * Vérifie si une carte est valide
     * @param carte La carte à vérifier
     * @param dateAchat La date d'achat de la carte
     * @return true si la carte est valide
     * @throws TitreNonValideException Si la carte n'est pas valide
     */
    public boolean verifierValiditeCarte(CartePersonnelle carte, LocalDate dateAchat) throws TitreNonValideException {
        return carte.estValide(dateAchat);
    }
    
    /**
     * Obtient le type de réduction applicable pour un usager
     * @param usager La personne à évaluer
     * @return Le type de carte applicable ou null si aucune réduction n'est possible
     */


    /**
     * Calcule le prix d'une carte personnelle pour un usager
     * @param usager La personne pour qui calculer le prix
     * @return Le prix de la carte ou -1 si aucune réduction n'est applicable
     */
    @FXML
    private Button UserManagementBTN;
    @FXML
    private Ticket acheterTicketSimple(ActionEvent t) {
        // Prix de base d'un ticket simple en dinars algériens
        // Création du ticket
        Ticket ticket = new Ticket();
        System.out.println("5o dz"+ticket.getPrix());
        return ticket;
    }

}