/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.HotelOfferDetailScreenController.hotelName;
import static GUI.HotelOfferDetailScreenController.offerId;
import entite.HotelOffer;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class HotelDetailOfferClientScreenController implements Initializable {

    @FXML
    private ImageView profilePictureIV;
    @FXML
    private TextField titleTF;
    @FXML
    private TextArea desriptionTA;
    @FXML
    private TextField startDateTF;
    @FXML
    private TextField dateEndTF;
    @FXML
    private Button reclamationbBT;
    @FXML
    private TextField priceTF;
    private String path = "file:///C:/Users/Lenovo/Desktop/GoVoyageFX/png/";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Reserver(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/reservationHotel/firstStepReservationHotel.fxml"));
        Scene scene = new Scene(root);
        Scene currentScene = reclamationbBT.getScene();
        Stage primStage = (Stage) currentScene.getWindow();
        primStage.setScene(scene);
    }

    @FXML
    private void Reclamation(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/Reclamation/HelloReclamation.fxml"));
        Scene scene = new Scene(root);
        Scene currentScene = reclamationbBT.getScene();
        Stage primStage = (Stage) currentScene.getWindow();
        primStage.setScene(scene);
    }

    @FXML
    private void Commentaire(ActionEvent event) {
    }

    public void setHotelOfferData(HotelOffer offer) {
        offerId = offer.getId_offre_hotel();
        hotelName = offer.getTitre_offre_hotel();
        titleTF.setText(hotelName);
        desriptionTA.setText(offer.getDescription_offre_hotel());
        startDateTF.setText("Date Début : " + offer.getDate_debut_dispo());
        dateEndTF.setText("Date Fin : " + offer.getDate_fin_dispo());
        priceTF.setText("Prix : " + offer.getPrix());
        Image picture = new Image(path + offer.getPhoto_offre_hotel());
        profilePictureIV.setImage(picture);
    }

    private void closeScreen() {
        Stage stage = (Stage) titleTF.getScene().getWindow();
        stage.close();
    }

}
