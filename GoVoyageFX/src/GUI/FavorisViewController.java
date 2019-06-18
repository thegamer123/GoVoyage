/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Favoris;
import entite.HotelOffer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.controlsfx.control.Notifications;
import service.FavorisService;
import service.HotelOfferService;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class FavorisViewController implements Initializable {

    @FXML
    private Label nomOffreLabel;
    @FXML
    private Button deleteButton;
    @FXML
    private AnchorPane globalAnchorPane;
    private Favoris favoris;
    FavorisService favorisService = new FavorisService();
    HotelOfferService hotelOfferService = new HotelOfferService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        favorisService = new FavorisService();

    }

    public void setFavoris(Favoris favoris) {
        this.favoris = favoris;
    }

    public void setFavorisInTemplate() {
        HotelOffer hotelOffer = hotelOfferService.findHotelOffer(favoris.getId_offre());
        nomOffreLabel.setText(hotelOffer.getTitre_offre_hotel());
    }

    @FXML
    private void supprimerFavorisAction(ActionEvent event) {
        favorisService.supprimerFavoris(favoris);
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("ConsulterFavorisView.fxml"));
            ((Button) event.getSource()).getScene().setRoot(pane);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        delete_Favoris();
    }
    private  void delete_Favoris(){
                Notifications.create()
                .title("**Notification**")
                .text(" Favoris Deleted!")
                .darkStyle()
                .position(Pos.BOTTOM_RIGHT)
                .showInformation();
    }

}
