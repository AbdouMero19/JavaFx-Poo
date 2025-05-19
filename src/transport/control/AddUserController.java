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
    private ComboBox<String> handicapeSelect;
    @FXML
    private ComboBox<String> roleSelect;
    @FXML
    private ComboBox<String> jobSelect;
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
    private Button exitBTN;


    @FXML
    public void initialize() {
        // Populate the ComboBox
        handicapeSelect.getItems().addAll(
                "True","False"
        );
        roleSelect.getItems().addAll("Passenger", "Employee");
        jobSelect.getItems().addAll("AGENT", "CONDUCTEUR");
        jobSelect.setManaged(false);
        employeeID.setManaged(false);
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
    private void toggleVisibility(ActionEvent event) {
        if (roleSelect.getValue().equals("Employee")) {
            employeeID.setVisible(true);
            employeeID.setManaged(true);
            jobSelect.setVisible(true);
            jobSelect.setManaged(true);
        } else {
            employeeID.setVisible(false);
            employeeID.setManaged(false);
            jobSelect.setVisible(false);
            jobSelect.setManaged(false);
        }
    }

    @FXML
    private void addUser(ActionEvent event)  {
        String firstNameText = firstName.getText();
        String lastNameText = lastName.getText();
        boolean handicape = true;
        if (handicapeSelect.getValue().equals("False")) {
            handicape = false;
        } else {
            handicape = true;
        }
        String role = roleSelect.getValue();
        String job = jobSelect.getValue();
        LocalDate dateOfBirth = birthday.getValue();
        String employeeIDText = employeeID.getText();

        if (firstNameText.isEmpty() || lastNameText.isEmpty()
                || (!role.equals("Passenger") && !role.equals("Employee"))
                || dateOfBirth == null || (role.equals("Employee") && (employeeIDText.isEmpty() || job.isEmpty()))){
                System.out.println("Erreur");
        }
        TypeFonction typeFonction = null;
        if (role.equals("Employee")) {
            if (job.equals("AGENT")) {
                typeFonction = TypeFonction.AGENT;
            } else if (job.equals("CONDUCTEUR")) {
                typeFonction = TypeFonction.CONDUCTEUR;
            }
        }
        Personne user = null;

        if (role.equals("Passenger")) {
            user = new Usager(firstNameText, lastNameText, dateOfBirth, handicape);
            Data.addPassenger((Usager) user);
        System.out.println("User added " + user.getNom() + " " + user.getPrenom());
        if (Data.paasengerExists(((Usager) user).getUserID())){
            System.out.println("User already exists");
        } else {
            System.out.println("User added");
        }

        } else {
            user = new Employe(firstNameText, lastNameText, dateOfBirth, handicape, employeeIDText, typeFonction);
            Data.addEmployee((Employe) user);
            System.out.println("User added " + user.getNom() + " " + user.getPrenom());
            if (Data.employeeExists(((Employe) user).getId())){
                System.out.println("User already exists");
            } else {
                System.out.println("User added");
            }
        }



    }
}
