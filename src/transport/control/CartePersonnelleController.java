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

    public javafx.scene.control.Label resultLabel;
    public javafx.scene.control.TextField id;
    public javafx.scene.control.Label price;
    @FXML
    private ComboBox<String> userTypeComboBox;
    @FXML
    private ComboBox<String> paymentSelect;

    @FXML
    public void initialize() {
        // Populate the ComboBox
        userTypeComboBox.getItems().addAll(
                "Passenger","Employee"
        );
        paymentSelect.getItems().addAll(
                "Cash","Dahabia","BaridiMob"
        );
        resultLabel.setVisible(false);
        resultLabel.setManaged(false);
    }

    @FXML
    private void returnToMainMenu(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/transport/ui/FareManagment.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void achterCarte (){

        if (id.getText().trim().isEmpty() || userTypeComboBox.getValue().equals("")){
            System.out.println("Erreur : Missing information");
            resultLabel.setText("Missing information");
            resultLabel.setTextFill(javafx.scene.paint.Color.RED);
            resultLabel.setVisible(true);
            resultLabel.setManaged(true);
            return;
        }
    if (userTypeComboBox.getValue().equals("Passenger")){
        int userID;
        try {
            userID = Integer.parseInt(id.getText().trim());
        } catch (NumberFormatException e) {

            resultLabel.setText("Passengers ID must be a number");
            resultLabel.setTextFill(javafx.scene.paint.Color.RED);
            resultLabel.setVisible(true);
            resultLabel.setManaged(true);
            return;
        }
        if(!Data.paasengerExists(userID)){
            resultLabel.setText("User does not exist");
            resultLabel.setTextFill(javafx.scene.paint.Color.RED);
            resultLabel.setVisible(true);
            resultLabel.setManaged(true);
            return;
        }
        try {
            Usager user = Data.getPassenger(userID);
            TitreTransport titre = new CartePersonnelle(user);
            GestionDeDonne.ajouterTitre(titre);
            price.setText(String.valueOf(titre.getPrix()));
        } catch ( ReductionImpossibleException e) {
            System.out.println("User not eligible for a reduction");
            resultLabel.setText("User not eligible for a reduction");
            resultLabel.setTextFill(javafx.scene.paint.Color.RED);
            resultLabel.setVisible(true);
            resultLabel.setManaged(true);
            return;
        }
    } else if (userTypeComboBox.getValue().equals("Employee")) {
        String employeeID = id.getText().trim();
        if (!Data.employeeExists(employeeID)){
            System.out.println("Erreur : employee does not exist");
            resultLabel.setText("Employee does not exist");
            resultLabel.setTextFill(javafx.scene.paint.Color.RED);
            resultLabel.setVisible(true);
            resultLabel.setManaged(true);
            return;
        }
        try {
            Employe user = Data.getEmployee(employeeID);
            TitreTransport titre = new CartePersonnelle(user);
            GestionDeDonne.ajouterTitre(titre);
            price.setText(String.valueOf(titre.getPrix()));
        } catch (ReductionImpossibleException e) {
            System.out.println("User not eligible for a reduction");
            resultLabel.setText("User not eligible for a reduction");
            resultLabel.setTextFill(javafx.scene.paint.Color.RED);
            resultLabel.setVisible(true);
            resultLabel.setManaged(true);
            return;
        }
    }

    System.out.println("Fare created succssfully");
        resultLabel.setText("Fare created succssfully");
        resultLabel.setTextFill(javafx.scene.paint.Color.GREEN);
        resultLabel.setVisible(true);
        resultLabel.setManaged(true);


    }

    }


