package transport.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javafx.stage.Stage;
import transport.core.CartePersonnelle;
import transport.core.Ticket;
import transport.core.TitreTransport;
import transport.core.GestionDeDonne;

public class history_ticket {
    @FXML
    private TableView<TitreTransport> titresTableView;
    
    @FXML
    private TableColumn<TitreTransport, Integer> idColumn;

    @FXML
    private TableColumn<TitreTransport, LocalDate> dateColumn;

    @FXML
    private TableColumn<TitreTransport, String> typeColumn;

    @FXML
    private TableColumn<TitreTransport, Double> prixColumn;
    
    @FXML
    public void initialize() {
        // Initialiser les colonnes

        idColumn.setCellValueFactory((cellData) ->{
            if (cellData.getValue() instanceof Ticket){
            return new SimpleIntegerProperty(((Ticket) cellData.getValue()).getId()).asObject();
        } else {
                return new SimpleIntegerProperty(((CartePersonnelle) cellData.getValue()).getId()).asObject();
            }
                });

        dateColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getDateAchat()));
        typeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getClass().getSimpleName()));
        prixColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrix()).asObject());

        
        // Charger les données
        afficherTitresParDate();
    }

    // Méthode pour ajouter des titres exemples
    private void ajouterTitresExemples(GestionDeDonne gestionDeDonne) {
        try {
            // Exemple générique - remplacez ceci par vos propres classes de titres
            // (cette implémentation dépendra de vos classes concrètes de TitreTransport)
            
            // Création du premier titre (aujourd'hui)
            TitreTransport titre1 = creerTitreExemple(1, LocalDate.now(), 15.50);
            gestionDeDonne.ajouterTitre(titre1);
            
            // Création du deuxième titre (hier)
            TitreTransport titre2 = creerTitreExemple(2, LocalDate.now().minusDays(1), 22.75);
            gestionDeDonne.ajouterTitre(titre2);
            
            // Création du troisième titre (semaine dernière)
            TitreTransport titre3 = creerTitreExemple(3, LocalDate.now().minusWeeks(1), 10.00);
            gestionDeDonne.ajouterTitre(titre3);
            
        } catch (Exception e) {
            System.out.println("Erreur lors de la création des exemples : " + e.getMessage());
        }
    }

    // Cette méthode doit être adaptée selon votre implémentation concrète de TitreTransport
    private TitreTransport creerTitreExemple(int id, LocalDate date, double prix) {
        // À adapter selon vos classes concrètes
        // Par exemple, si vous avez une classe TicketSimple qui étend TitreTransport :
        // TicketSimple ticket = new TicketSimple();
        // ticket.setId(id);
        // ticket.setDateAchat(date);
        // ticket.setPrix(prix);
        // return ticket;
        
        // Version générique (à adapter) :
        TitreTransport titre = new TitreTransport() {
            @Override
            public boolean estValide(LocalDate dateValidation) {
                return dateValidation.isEqual(this.dateAchat) || 
                       dateValidation.isBefore(this.dateAchat.plusDays(7));
            }
        };
        
        titre.setId(id);
        titre.setDateAchat(date);
        titre.setPrix(prix);
        
        return titre;
    }
    
    @FXML
    public void afficherTitresParDate() {
        if (titresTableView != null) {

            // Récupérer les titres triés par date décroissante depuis GestionDeDonne
            List<TitreTransport> titres = GestionDeDonne.getTitresParDateDecroissante();

            // Mettre à jour le TableView avec la liste triée
            titresTableView.setItems(FXCollections.observableArrayList(titres));

            // Afficher un message informatif
            System.out.println("Liste des titres affichée par date décroissante (les plus récents en premier)");
        } else {
            System.out.println("Impossible d'afficher les titres : tableau non initialisé");
        }
    }
    

    @FXML
    private void returnToFareManagement(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/transport/ui/FareManagment.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}