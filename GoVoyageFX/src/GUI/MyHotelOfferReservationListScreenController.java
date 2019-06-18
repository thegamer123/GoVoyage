/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.CellHotelOffer;
import entite.CellHotelReservation;
import entite.HotelOffer;
import entite.HotelReservation;
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
import service.ReservationHotelService;
import service.ServiceHotel;


public class MyHotelOfferReservationListScreenController implements Initializable {

    @FXML
    private ListView<HotelReservation> lsitViewHotel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ReservationHotelService service = new ReservationHotelService();
        System.out.println(HotelHomeScreenController.idHotel);
        ObservableList<HotelReservation> listR = FXCollections.observableArrayList(service.readAllOffersByHotelId(String.valueOf(HotelOfferDetailScreenController.offerId)));

        lsitViewHotel.setItems(listR);
        lsitViewHotel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               
            }
        });
        lsitViewHotel.setCellFactory(new javafx.util.Callback<ListView<HotelReservation>, ListCell<HotelReservation>>() {

            public ListCell<HotelReservation> call(ListView<HotelReservation> lv) {
                return new CellHotelReservation();
            }
        });
        
    }

}
