package transport.control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;
import javafx.scene.Node;
import javafx.event.ActionEvent;

public class AddUserController {

    @FXML
    private ComboBox<Boolean> handicapeSelect;
    @FXML
    private ComboBox<String> roleSelect;

    @FXML
    public void initialize() {
        // Populate the ComboBox
        handicapeSelect.getItems().addAll(
                true , false
        );
        roleSelect.getItems().addAll("Passenger", "Employee");
    }
}
