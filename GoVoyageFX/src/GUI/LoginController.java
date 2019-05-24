/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.User;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import service.ServiceUser;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class LoginController implements Initializable {

    @FXML
    private TextField loginTF;
    @FXML
    private PasswordField passTF;
    public static int id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void login(ActionEvent event) throws IOException {
        ServiceUser service = new ServiceUser();
        User result = null;
        if (validateData()) {
            result = service.loginUser(loginTF.getText(), passTF.getText());
            if (result != null) {

                if (result.getIs_admin_user() == 1) {
                    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/AdminHomeScreen.fxml"));
                    Scene scene = new Scene(root);
                    Scene currentScene = loginTF.getScene();
                    Stage primStage = (Stage) currentScene.getWindow();
                    primStage.setScene(scene);

                } else {
                    if (result.getIs_hotel() == 1) {
                        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/HotelHomeScreen.fxml"));
                        Parent root = (Parent) loader.load();
                        Scene scene = new Scene(root);
                        HotelHomeScreenController controller = loader.getController();
                        controller.setUser(result);
                        Scene currentScene = loginTF.getScene();
                        Stage primStage = (Stage) currentScene.getWindow();
                        primStage.setScene(scene);

                    } else if (result.getIs_agency() == 1) {

                        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/AgenceHomeScreen.fxml"));
                        Parent root = (Parent) loader.load();
                        Scene scene = new Scene(root);
                        AgenceHomeScreenController controller = loader.getController();
                        controller.setUser(result);
                        Scene currentScene = loginTF.getScene();
                        Stage primStage = (Stage) currentScene.getWindow();
                        primStage.setScene(scene);
                        
                    } else if (result.getIs_client() == 1) {
                        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/MenuConsultation.fxml"));
                        Scene scene = new Scene(root);
                        Scene currentScene = loginTF.getScene();
                        Stage primStage = (Stage) currentScene.getWindow();
                        primStage.setScene(scene);

                    }
                }
            } else {
                showAlert("Problème de connexion");
            }
        }

    }

    private boolean validateData() {

        if (loginTF.getText().equals((""))) {
            showAlert("le champ login est obligatoire");
            return false;
        } else if (passTF.getText().equals((""))) {
            showAlert("le champ mot de passe est obligatoire");
            return false;
        }

        return true;
    }

    private void showAlert(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, text, ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
    }

    @FXML
    private void signup(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/AjouterUser.fxml"));
        Scene scene = new Scene(root);
        Scene currentScene = loginTF.getScene();
        Stage primStage = (Stage) currentScene.getWindow();
        primStage.setScene(scene);

    }

}
