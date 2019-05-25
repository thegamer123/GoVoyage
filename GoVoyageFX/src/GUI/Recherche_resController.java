/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.HotelOffer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class Recherche_resController implements Initializable {

    @FXML
    private TextField rechercheF;
    @FXML
    private DatePicker dt1;
    @FXML
    private DatePicker dt2;
    @FXML
    private TextField nbtotalF;
    @FXML
    private ComboBox<String> cb_enf;
    @FXML
    private ComboBox<String> cb_ad;
    @FXML
    private ImageView nextIV;
    @FXML
    private ImageView backIV;
    private String path = "file:///C:/Users/Lenovo/Desktop/Bob/Esprit 1ere/GoVoyage/GoVoyage/GoVoyageFX/png/";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nextIV.setImage(new Image(path + "next.png"));
        backIV.setImage(new Image(path + "next.png"));
    }

    @FXML
    private void next(MouseEvent event) {
    }

    @FXML
    private void back(MouseEvent event) {
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

}
