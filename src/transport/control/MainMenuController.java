package transport.control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;

public class MainMenuController {

    @FXML private Button fareMediaButton;
    @FXML private Button validateFareButton;
    @FXML private Button complaintsButton;
    @FXML private Button exitButton;

    @FXML
    private void initialize() {
        // Button actions
        fareMediaButton.setOnAction(e -> loadScene("ManageFareMedia.fxml", "Manage Fare Media"));
        validateFareButton.setOnAction(e -> loadScene("ValidateFare.fxml", "Validate Fare"));
        complaintsButton.setOnAction(e -> loadScene("ManageComplaints.fxml", "Manage Complaints"));
        exitButton.setOnAction(e -> System.exit(0));
    }

    private void loadScene(String fxmlFile, String title) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/transport/ui/" + fxmlFile));
            Stage stage = (Stage) fareMediaButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}