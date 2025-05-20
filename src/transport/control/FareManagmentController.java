package transport.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import transport.core.GestionDeDonne;
import transport.core.Ticket;
import transport.core.TitreTransport;


import java.io.IOException;

public class FareManagmentController {
    public javafx.scene.control.Label resultLabel;

    public void initialize() {
        resultLabel.setVisible(false);
        resultLabel.setManaged(false);
    }

    @FXML
    private void navigateCartePersonnelle(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/transport/ui/Carte__personnel_ui.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void navigate3(ActionEvent actionEvent) {
        try {
            Parent AddUserRoot = FXMLLoader.load(getClass().getResource("/transport/ui/History.fxml"));
            Scene secondScene = new Scene(AddUserRoot , 800 , 600);

            // Get the stage from the event
            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.setScene(secondScene);
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void acheterTicketSimple(ActionEvent t) {
        try {
            TitreTransport ticket = new Ticket();
            GestionDeDonne.ajouterTitre(ticket);
        resultLabel.setText("Ticket created succssfully");
        resultLabel.setTextFill(javafx.scene.paint.Color.GREEN);
        resultLabel.setVisible(true);
        resultLabel.setManaged(true);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("erreur creating ticket");
            resultLabel.setText("Error creating ticket");
            resultLabel.setTextFill(Color.RED);
            resultLabel.setVisible(true);
            resultLabel.setManaged(true);
        }
    }

    @FXML
    private void returnToMainMenu(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/transport/ui/MainMenu.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void navigateToValidate(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/transport/ui/Validate.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
