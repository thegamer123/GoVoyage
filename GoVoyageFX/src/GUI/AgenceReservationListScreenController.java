/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Interface.DeleteInterface;
import entite.AgenceReservationFullModel;
import entite.Vol;
import entite.VolReservation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import service.CellAgenceOffer;
import service.CellAgenceReservation;
import service.ServiceVol;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class AgenceReservationListScreenController implements Initializable, DeleteInterface {

    @FXML
    private ListView<AgenceReservationFullModel> lsitViewHotel;
    ServiceVol service = new ServiceVol();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        System.out.println(AgenceHomeScreenController.idAgence);
        bindListView();
    }

    private void bindListView() {
        ObservableList<AgenceReservationFullModel> listR = FXCollections.observableArrayList(service.readAllReservationByAgenceId(String.valueOf(LoginController.result.getId_user()), String.valueOf(AgenceOfferDetailScreenController.currentVol.getId_vol())));
        lsitViewHotel.setItems(listR);
        lsitViewHotel.setCellFactory((ListView<AgenceReservationFullModel> lv) -> new CellAgenceReservation(this));
    }

    @Override
    public void Supprimer(String id) {

        System.out.println(id);
        boolean result = service.deleteReservation(Integer.valueOf(id));
        if (result) {
            TrayNotification tn = new TrayNotification("Réservation", "Réservation annuler avec succèes", NotificationType.SUCCESS);
            tn.showAndWait();
            bindListView();

        } else {
            showAlert("Erreur dans l'opération");
        }

    }

    private void showAlert(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, text, ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
    }

}
