/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.HotelOfferDetailScreenController.offerId;
import Interface.IRefreshList;
import entite.Vol;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import service.ServiceAgence;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AgenceOfferDetailScreenController implements Initializable {

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

    }

    @FXML
    private void supprimer(ActionEvent event) {

        ServiceAgence service = new ServiceAgence();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Supprimer l'offre");
        alert.setContentText("Confirmer?");
        ButtonType okButton = ButtonType.YES;
        ButtonType noButton = ButtonType.NO;
        ButtonType cancelButton = new ButtonType("YesNo", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(okButton, noButton);
        alert.showAndWait().ifPresent((ButtonType type) -> {
            if (type == ButtonType.YES) {
                boolean result = service.deleteOffer(currentVol.getId_vol());
                if (result) {
                    callback.refreshListOnBack();
                    closeScreen();
                }

            } else if (type == ButtonType.NO) {
            } else {
                alert.close();
            }
        });
    }

    private void closeScreen() {
        Stage stage = (Stage) heureDepDP.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void reservation(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/AgenceReservationListScreen.fxml"));
        Scene scene = new Scene(root);
        Stage primStage = new Stage();
        primStage.setScene(scene);
        primStage.show();
    }

    @FXML
    private void reclamation(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/Reclamation/HelloReclamation.fxml"));
        Scene scene = new Scene(root);
        Scene currentScene = reclamationbBT.getScene();
        Stage primStage = new Stage();
        primStage.setScene(scene);
        primStage.show();
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

}
