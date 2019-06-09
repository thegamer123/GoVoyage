/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class MenuConsultationController implements Initializable {

    @FXML
    private ImageView img_govoyage;
    @FXML
    private RadioButton butHotel;
    @FXML
    private RadioButton butFlights;
    @FXML
    private ToggleGroup mygroup;
    @FXML
    private Button butSearch;
    @FXML
    private Button ButDeals;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    private void navigation(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MenuConsultation.fxml"));
        Scene scene = new Scene(root);
//          Image image = new Image("/image/govoyage.jpg");
//     img_govoyage.setImage(image);
        Scene currentScene = img_govoyage.getScene();
        Stage primStage = (Stage) currentScene.getWindow();
        primStage.setScene(scene);
    }

    @FXML
    public void Appel(ActionEvent event) throws IOException {
        if (butHotel.isSelected()) {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/ConsultationHotel.fxml"));
            Scene scene = new Scene(root);
            //Scene currentScene = butSearch.getScene();
            // Stage primStage = (Stage) currentScene.getWindow();
            //primStage.setScene(scene);

            Stage primStage = new Stage();
            primStage.setScene(scene);
            primStage.show();

        } else if (butFlights.isSelected()) {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/ConsultationVol.fxml"));
            Scene scene = new Scene(root);
            //Scene currentScene = butSearch.getScene();
            //Stage primStage = (Stage) currentScene.getWindow();
            //primStage.setScene(scene);

            Stage primStage = new Stage();
            primStage.setScene(scene);
            primStage.show();

        }
    }

    @FXML
    private void nav(ActionEvent event) throws IOException {
        Parent root;
        if (butFlights.isSelected()) {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/ClientVolOffersScreen.fxml"));
        } else {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/HotelOfferListScreen.fxml"));
        }

        Scene scene = new Scene(root);
//          Image image = new Image("/image/govoyage.jpg");
//     img_govoyage.setImage(image);
        // Scene currentScene = ButDeals.getScene();
        // Stage primStage = (Stage) currentScene.getWindow();
        // primStage.setScene(scene);
        Stage primStage = new Stage();
        primStage.setScene(scene);
        primStage.show();
    }

}
