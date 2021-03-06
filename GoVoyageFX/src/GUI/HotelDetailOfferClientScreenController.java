/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.HotelOfferDetailScreenController.hotelName;
import static GUI.HotelOfferDetailScreenController.offerId;
import GUI.reservationHotel.FirstStepReservationHotelController;
import entite.HotelOffer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public static HotelOffer currentOffer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Reserver(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/reservationHotel/firstStepReservationHotel.fxml"));
        Parent root = (Parent) loader.load();
        FirstStepReservationHotelController controller = loader.getController();
        controller.setHotelOfferData(currentOffer);
        System.out.println(root);
        Scene scene = new Scene(root);
        Stage primStage = new Stage();
        primStage.setScene(scene);
        primStage.show();
    }

    @FXML
    private void Reclamation(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/Reclamation/HelloReclamation.fxml"));
        Scene scene = new Scene(root);
        Scene currentScene = reclamationbBT.getScene();
        Stage primStage = new Stage();
        primStage.setScene(scene);
        primStage.show();
    }

    @FXML
    private void Commentaire(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/commentaire/ListCommentaireView.fxml"));
        Scene scene = new Scene(root);
        Scene currentScene = reclamationbBT.getScene();
        Stage primStage = new Stage();
        primStage.setScene(scene);
        primStage.show();
    }

    public void setHotelOfferData(HotelOffer offer) {
        currentOffer = offer;
        offerId = offer.getId_offre_hotel();
        hotelName = offer.getTitre_offre_hotel();
        titleTF.setText(hotelName);
        desriptionTA.setText(offer.getDescription_offre_hotel());
        startDateTF.setText("Date Début : " + offer.getDate_debut_dispo());
        dateEndTF.setText("Date Fin : " + offer.getDate_fin_dispo());
        priceTF.setText("Prix : " + offer.getPrix());
        Image picture = new Image(Utility.path + offer.getPhoto_offre_hotel());
        profilePictureIV.setImage(picture);
    }

    private void closeScreen() {
        Stage stage = (Stage) titleTF.getScene().getWindow();
        stage.close();
    }

}
