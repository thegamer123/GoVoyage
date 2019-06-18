/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Interface.IRefreshList;
import entite.Vol;
import entite.VolReservation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import service.ServiceVol;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;


public class ClientVolOfferDetailScreenController implements Initializable {

    @FXML
    private ImageView profilePictureIV;
    @FXML
    private TextField originTF;
    @FXML
    private TextField destinatonTF;
    @FXML
    private TextField depTF;
    @FXML
    private Button reclamationbBT;
    @FXML
    private TextField dateArrTF;
    @FXML
    private TextField heureDepDP;
    @FXML
    private TextField heureArrDep;
    @FXML
    private TextField nbEscaleTF;
    @FXML
    private TextField priceTF;
    public static Vol currentVol;
    public static IRefreshList callback;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void showAlert(String text) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION, text, ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
    }

    @FXML
    private void reclamation(ActionEvent event) {
    }

    @FXML
    private void commentaire(ActionEvent event) {
    }

    public void setAgenceOffer(Vol vol, IRefreshList mCallback) {

        currentVol = vol;
        callback = mCallback;
        originTF.setText("De: " + currentVol.getOrigine());
        destinatonTF.setText("A: " + currentVol.getDestination());
        depTF.setText("Date départ: " + currentVol.getDepart());
        dateArrTF.setText("Date arrivée: " + currentVol.getArrivee());
        heureDepDP.setText(currentVol.getDepart());
        heureDepDP.setText(currentVol.getHeureDepart());
        heureArrDep.setText(currentVol.getHeureArrive());
        nbEscaleTF.setText(String.valueOf(currentVol.getNb_escale()));
        priceTF.setText(currentVol.getPrix());
        Image img = new Image(Utility.path + "Vol.png");
        profilePictureIV.setImage(img);
    }

    @FXML
    private void supprimer(ActionEvent event) {
    }

    @FXML
    private void Reserver(ActionEvent event) {
        ServiceVol service = new ServiceVol();
        VolReservation reservation = new VolReservation(0,
                LoginController.result.getId_user(),
                currentVol.getId_vol(),
                currentVol.getDepart(),
                currentVol.getArrivee(),
                currentVol.getHeureDepart(),
                currentVol.getHeureArrive()
        );

        int result = service.addReservationVol(reservation);

        if (result != -1) {

            closeScreen();

        } else {
            showAlert("Erreur dans l'opération");
        }
    }

    private void closeScreen() {
        TrayNotification tn = new TrayNotification("Réservation", "Votre Réservation a été ajouté avec succèes", NotificationType.SUCCESS);
        tn.showAndWait();
        Stage stage = (Stage) priceTF.getScene().getWindow();
        stage.close();
    }

}
