package transport.control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;

public class MainMenuController {

    public Button UserManagementBTN;
    public Button FareManagementBTN;
    public Button ComplaintsManagementBTN;
    public Button exitButton;


    @FXML
    private void initialize() {
        // Button actions
        UserManagementBTN.setOnAction(e -> loadScene("UserManagement.fxml", "Manage Users"));
        FareManagementBTN.setOnAction(e -> loadScene("ValidateFare.fxml", "Manage Fares"));
        ComplaintsManagementBTN.setOnAction(e -> loadScene("ManageComplaints.fxml", "Manage Complaints"));
        exitButton.setOnAction(e -> System.exit(0));
    }

    private void loadScene(String fxmlFile, String title) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/transport/ui/" + fxmlFile));
            Stage stage = (Stage) UserManagementBTN.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}