package transport.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import transport.core.GestionDeDonne;
import transport.core.TitreNonValideException;
import transport.core.TitreTransport;

import java.io.IOException;
import java.time.LocalDate;

public class validateController {

    @FXML
    public javafx.scene.control.TextField idTitre;
    @FXML
    public javafx.scene.control.Label resultLabel;

    @FXML
    private void verify(){
        try {
            int id = Integer.parseInt(idTitre.getText());
            if (GestionDeDonne.titreExists(id)) {
                TitreTransport titre = GestionDeDonne.getTitreParId(id);
                if (titre.estValide(LocalDate.now())){
                    resultLabel.setText("The fare valide");
                    resultLabel.setVisible(true);
                }else {
                    resultLabel.setText("The fare is invalide");
                    resultLabel.setVisible(true);

                }
            } else {
                resultLabel.setText("The fare does not exist");
                resultLabel.setVisible(true);

            }
        } catch (TitreNonValideException e) {
            resultLabel.setText("The fare is invalide");
            resultLabel.setVisible(true);


        }

        catch (NumberFormatException e) {
            resultLabel.setText("The fare is invalide ");
            resultLabel.setVisible(true);

        }
    }


    @FXML
    private void returnToFareManagement(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/transport/ui/FareManagment.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
