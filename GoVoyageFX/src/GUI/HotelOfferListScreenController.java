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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.ServiceHotel;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class HotelOfferListScreenController implements Initializable {

    @FXML
    private ListView<HotelOffer> lsitViewHotel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceHotel service = new ServiceHotel();
        System.out.println(HotelHomeScreenController.idHotel);
        ObservableList<HotelOffer> listR = FXCollections.observableArrayList(service.readAllOffersByHotelId(String.valueOf(HotelHomeScreenController.idHotel)));

        lsitViewHotel.setItems(listR);
        lsitViewHotel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("clicked on " + lsitViewHotel.getSelectionModel().getSelectedItem());
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/HotelOfferDetailScreen.fxml"));
                Parent root = null;
                try {
                    root = (Parent) loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(ConsultationOffreController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Scene scene = new Scene(root);
                HotelOfferDetailScreenController controller = loader.getController();
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
