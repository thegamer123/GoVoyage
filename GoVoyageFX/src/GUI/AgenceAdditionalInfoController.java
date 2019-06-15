/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Agence;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import service.ServiceAgence;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AgenceAdditionalInfoController implements Initializable {

    @FXML
    private TextField nameTF;
    @FXML
    private TextField adrTF;
    private static int userId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void submitBtn(ActionEvent event) throws IOException {

        ServiceAgence service = new ServiceAgence();
        int result = -1;
        if (validateData()) {
            result = service.addAgence(new Agence(0, nameTF.getText(), userId, adrTF.getText()));
            if (result > -1) {
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/AgenceHomeScreen.fxml"));
                Scene scene = new Scene(root);
                Scene currentScene = nameTF.getScene();
                Stage primStage = (Stage) currentScene.getWindow();
                primStage.setScene(scene);
            } else {
                showAlert("Problème de connexion");
            }
        }
    }

    private boolean validateData() {

        if (nameTF.getText().equals((""))) {
            showAlert("le champ Nom est obligatoire");
            return false;
        } else if (adrTF.getText().equals((""))) {
            showAlert("le champ Adresse est obligatoire");
            return false;
        }

        return true;
    }

    private void showAlert(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, text, ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
    }

    public void setIdUser(int id) {
        userId = id;
    }
    



}
