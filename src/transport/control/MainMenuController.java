package transport.control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;
import javafx.scene.Node;
import javafx.event.ActionEvent;


public class MainMenuController {

    public Button UserManagementBTN;
    public Button FareManagementBTN;
    public Button ComplaintsManagementBTN;
    public Button exitButton;



    @FXML
    private void navigateUserManagement (ActionEvent event) {
        try {
            Parent AddUserRoot = FXMLLoader.load(getClass().getResource("/transport/ui/UserManagement.fxml"));
            Scene secondScene = new Scene(AddUserRoot);

            // Get the stage from the event
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.setScene(secondScene);
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void navigate (ActionEvent event) {
        try {
            Parent AddUserRoot = FXMLLoader.load(getClass().getResource("/transport/ui/FareManagment.fxml"));
            Scene secondScene = new Scene(AddUserRoot);

            // Get the stage from the event
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.setScene(secondScene);
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}