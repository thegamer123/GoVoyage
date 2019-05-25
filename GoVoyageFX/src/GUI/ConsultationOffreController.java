/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.CellHotelOffer;
import entite.HotelOffer;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.ServiceHotel;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ConsultationOffreController implements Initializable {

    @FXML
    private ImageView image;
    @FXML
    private ListView<HotelOffer> lsitViewHotel;

    @FXML

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ServiceHotel service = new ServiceHotel();
        ObservableList<HotelOffer> listR = FXCollections.observableArrayList(service.readAllOffers());
        /* for (HotelOffer h : listR) {
            HotelOffer r = new HotelOffer();
            int id_hotel = h.getId_hotel();
            String nom_hotel = h.getTitre_offre_hotel();
            String description = h.getDescription_offre_hotel();
            System.out.println("nom_hotel = " + nom_hotel);
            String img = h.getPhoto_offre_hotel();
            System.out.println("img = " + img);
            String prix = h.getPrix();

            r.setId_hotel(id_hotel);
            r.setTitre_offre_hotel(nom_hotel);
            r.setPhoto_offre_hotel(img);
            r.setDescription_offre_hotel(description);
            r.setPrix(prix);
            listR.add(r);

        }*/
        lsitViewHotel.setItems(listR);
        lsitViewHotel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("clicked on " + lsitViewHotel.getSelectionModel().getSelectedItem());
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/HotelDetailOfferClientScreen.fxml"));
                Parent root = null;
                try {
                    root = (Parent) loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(ConsultationOffreController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Scene scene = new Scene(root);
                HotelDetailOfferClientScreenController controller = loader.getController();
                controller.setHotelOfferData(lsitViewHotel.getSelectionModel().getSelectedItem());
                Stage primStage = new Stage();
                primStage.setScene(scene);
                primStage.show();
            }
        });
        lsitViewHotel.setCellFactory(new javafx.util.Callback<ListView<HotelOffer>, ListCell<HotelOffer>>() {

            public ListCell<HotelOffer> call(ListView<HotelOffer> lv) {
                return new CellHotelOffer();
            }
        });
    }

}
