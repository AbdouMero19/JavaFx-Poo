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

public class UserManagementController {

    public Button AddUserBTN;





    @FXML
    private void test(){
        System.out.println("test");
    }

    @FXML
    private void addUser(ActionEvent event) throws IOException {
        try {
            Parent AddUserRoot = FXMLLoader.load(getClass().getResource("/transport/ui/AddUsers.fxml"));
            Scene secondScene = new Scene(AddUserRoot , 800 , 600);

            // Get the stage from the event
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.setScene(secondScene);
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

