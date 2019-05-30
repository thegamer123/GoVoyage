/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Agence;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.ServiceUser;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AgenceHomeScreenController implements Initializable {

    @FXML
    private TextField hotelNameTF;
    private static String agenceName;
    private static int idAgence;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/login.fxml"));
        Scene scene = new Scene(root);
        Scene currentScene = hotelNameTF.getScene();
        Stage primStage = (Stage) currentScene.getWindow();
        primStage.setScene(scene);
    }

    @FXML
    private void myOffers(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/ConsultationVol.fxml"));
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root);
        //AddAgenceOfferController controller = loader.getController();
        //controller.setUserId(idAgence);
        Scene currentScene = hotelNameTF.getScene();
        Stage primStage = (Stage) currentScene.getWindow();
        primStage.setScene(scene);
    }

    @FXML
    private void addVol(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/AddAgenceOffer.fxml"));
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root);
        AddAgenceOfferController controller = loader.getController();
        controller.setUserId(idAgence);
        Scene currentScene = hotelNameTF.getScene();
        Stage primStage = (Stage) currentScene.getWindow();
        primStage.setScene(scene);
    }

    public void setUser(User user) {

        Agence agence = new ServiceUser().getAgenceData(user.getId_user());
        agenceName = agence.getNom_agence();
        idAgence = agence.getId_agence();
        hotelNameTF.setText(agenceName);

    }

}
