package transport.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import transport.core.*;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;


public class CartePersonnelleController {


    public javafx.scene.control.TextField id;
    public javafx.scene.control.Label price;
    @FXML
    private ComboBox<String> userTypeComboBox;

    @FXML
    public void initialize() {
        // Populate the ComboBox
        userTypeComboBox.getItems().addAll(
                "Passenger","Employee"
        );
    }

    @FXML
    private void returnToMainMenu(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/transport/ui/MainMenu.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void achterCarte (){

        if (id.getText().trim().isEmpty() || userTypeComboBox.getValue().equals("")){
            System.out.println("Erreur : Missing information");
        }
    if (userTypeComboBox.getValue().equals("Passenger")){
        int userID;
        try {
            userID = Integer.parseInt(id.getText().trim());
        } catch (NumberFormatException e) {
            System.out.println("Erreur");
            return;
        }
        if(!Data.paasengerExists(userID)){
            System.out.println("Erreur : User does not exist");
            return;
        }
        try {
            Usager user = Data.getPassenger(userID);
            TitreTransport titre = new CartePersonnelle(user);
            GestionDeDonne.ajouterTitre(titre);
            price.setText(String.valueOf(titre.getPrix()));
        } catch ( ReductionImpossibleException e) {
            System.out.println("User not eligible for a reduction");
            return;
        }
    } else if (userTypeComboBox.getValue().equals("Employee")) {
        String employeeID = id.getText().trim();
        if (!Data.employeeExists(employeeID)){
            System.out.println("Erreur : employee does not exist");
            return;
        }
        try {
            Employe user = Data.getEmployee(employeeID);
            TitreTransport titre = new CartePersonnelle(user);
            GestionDeDonne.ajouterTitre(titre);
            price.setText(String.valueOf(titre.getPrix()));
        } catch (ReductionImpossibleException e) {
            System.out.println("User not eligible for a reduction");
            return;
        }
    }

    System.out.println("Fare created succssfully");


    }

    }


