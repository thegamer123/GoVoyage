/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.reservationHotel;

import GUI.HotelDetailOfferClientScreenController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import service.ReservationHotelService;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class TarifScreenController implements Initializable {

    @FXML
    private TextField tarif;
    @FXML
    private TextField chmF;
    @FXML
    private TextField jourF;
    @FXML
    private Button btn_confirmer;
    @FXML
    private TextField chmF1;
    private int adultePrice;
    private double enfantPrice;
    @FXML
    private Button btn_confirmer1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tarif.setText(HotelDetailOfferClientScreenController.currentOffer.getPrix());
        chmF.setText(String.valueOf(FirstStepReservationHotelController.reservation.getEnfant_hotel_reservation()));
        chmF1.setText(String.valueOf(FirstStepReservationHotelController.reservation.getAdulte_hotel_reservation()));
        jourF.setText(String.valueOf(FirstStepReservationHotelController.reservation.getNuit_hotel_reservation()));
        adultePrice = FirstStepReservationHotelController.reservation.getAdulte_hotel_reservation() * Integer.parseInt(HotelDetailOfferClientScreenController.currentOffer.getPrix());
        enfantPrice = FirstStepReservationHotelController.reservation.getEnfant_hotel_reservation() * 0.5 * Integer.parseInt(HotelDetailOfferClientScreenController.currentOffer.getPrix());
        tarif.setText(String.valueOf(adultePrice + enfantPrice));

    }

    @FXML
    private void confirmer(ActionEvent event) {

        ReservationHotelService service = new ReservationHotelService();
        boolean result = false;
        result = service.addReservation(FirstStepReservationHotelController.reservation);

        if (result) {
            closeScreen();
        } else {
            showAlert("Erreur dans l'opération");
        }

    }

    private void showAlert(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, text, ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
    }

    @FXML
    private void annuler(ActionEvent event) {
        closeScreen();
    }

    void closeScreen() {
        TrayNotification tn = new TrayNotification("Réservation", "Réservation envoyée avec succèes", NotificationType.SUCCESS);
        tn.showAndWait();
        Stage stage = (Stage) chmF1.getScene().getWindow();
        stage.close();
    }

}
