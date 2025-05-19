package transport.control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

import javafx.scene.Node;
import javafx.event.ActionEvent;
import transport.core.*;

public class AddUserController {

    @FXML
    private ComboBox<Boolean> handicapeSelect;
    @FXML
    private ComboBox<String> roleSelect;
    @FXML
    private ComboBox<TypeFonction> jobSelect;
    @FXML
    private Button AddUserBTN;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private DatePicker birthday;
    @FXML
    private TextField employeeID;

    @FXML
    public void initialize() {
        // Populate the ComboBox
        handicapeSelect.getItems().addAll(
                true , false
        );
        roleSelect.getItems().addAll("Passenger", "Employee");
        jobSelect.getItems().addAll(TypeFonction.AGENT, TypeFonction.CONDUCTEUR);
    }

    @FXML
    private void toggleVisibility(ActionEvent event) {
        if (roleSelect.getValue().equals("Employee")) {
            employeeID.setVisible(true);
            employeeID.setManaged(true);
        } else {
            employeeID.setVisible(false);
            employeeID.setManaged(false);
        }
    }

    @FXML
    private void addUser(ActionEvent event)  {
        String firstNameText = firstName.getText();
        String lastNameText = lastName.getText();
        //boolean handicape = handicapeSelect.getValue();
        String role = roleSelect.getValue();
        TypeFonction job = jobSelect.getValue();
        LocalDate dateOfBirth = birthday.getValue();
        String employeeIDText = employeeID.getText();

        if (firstNameText.isEmpty() || lastNameText.isEmpty()
                || (!role.equals("Passenger") && !role.equals("Employee"))
                || dateOfBirth == null){
                System.out.println("Erreur");
        }

        Personne user = null;

        if (role.equals("Passenger")) {
            user = new Usager(firstNameText, lastNameText, dateOfBirth, false);
            Data.addPassenger((Usager) user);
        System.out.println("User added " + user.getNom() + " " + user.getPrenom());
        if (Data.paasengerExists(((Usager) user).getUserID())){
            System.out.println("User already exists");
        } else {
            System.out.println("User added");
        }

        } else {
            user = new Employe(firstNameText, lastNameText, dateOfBirth, false, employeeIDText, job);
            Data.addEmployee((Employe) user);
        }



    }
}
