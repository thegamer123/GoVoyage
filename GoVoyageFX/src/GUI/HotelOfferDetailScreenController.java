/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.HotelOffer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import service.ServiceHotel;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class HotelOfferDetailScreenController implements Initializable {

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

    private String path = "file:///C:/Users/Lenovo/Desktop/GoVoyageFX/png/";
    @FXML
    private TextField priceTF;
    public static int offerId;
    public static String hotelName;
    @FXML
    private Button reclamationbBT;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        titleTF.setText(hotelName);
    }

    @FXML
    private void supprimer(ActionEvent event) {
        ServiceHotel service = new ServiceHotel();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Supprimer l'offre");
        alert.setContentText("Confirmer?");
        ButtonType okButton = ButtonType.YES;
        ButtonType noButton = ButtonType.NO;
        ButtonType cancelButton = new ButtonType("YesNo", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(okButton, noButton);
        alert.showAndWait().ifPresent(new Consumer<ButtonType>() {
            @Override
            public void accept(ButtonType type) {
                if (type == ButtonType.YES) {
                    service.deleteOffer(offerId);
                    closeScreen();
                } else if (type == ButtonType.NO) {
                } else {
                    alert.close();
                }
            }
        });

    }

    @FXML
    private void listerReservation(ActionEvent event) {
    }

    @FXML
    private void Commentaire(ActionEvent event) {
    }

    public void setHotelOfferData(HotelOffer offer) {
        offerId = offer.getId_offre_hotel();
        hotelName = offer.getTitre_offre_hotel();
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

    @FXML
    private void AddRec(ActionEvent event) throws IOException
    {Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/Reclamation/HelloReclamation.fxml"));
        Scene scene = new Scene(root);
        Scene currentScene = reclamationbBT.getScene();
        Stage primStage = (Stage) currentScene.getWindow();
        primStage.setScene(scene);
    }

}
