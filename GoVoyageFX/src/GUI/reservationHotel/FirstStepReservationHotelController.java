/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.reservationHotel;

import GUI.HotelDetailOfferClientScreenController;
import GUI.LoginController;
import GUI.Utility;
import entite.HotelOffer;
import entite.HotelReservation;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import static java.util.concurrent.TimeUnit.DAYS;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FirstStepReservationHotelController implements Initializable {

    @FXML
    private TextField rechercheF;

    @FXML
    private TextField nbtotalF;
    @FXML
    private ComboBox<Integer> cb_enf;
    @FXML
    private ComboBox<Integer> cb_ad;
    @FXML
    private ImageView nextIV;
    @FXML
    private ImageView backIV;
    
    ObservableList<Integer> options
            = FXCollections.observableArrayList(
                    0,
                    1,
                    2,
                    3,
                    4,
                    5,
                    6
            );
    public static HotelOffer currentHotelOfer;
    @FXML
    private DatePicker finDate;
    @FXML
    private DatePicker debutDate;

    public static HotelReservation reservation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        reservation = new HotelReservation();
        nextIV.setImage(new Image(Utility.path + "next.png"));
        backIV.setImage(new Image(Utility.path + "next.png"));
        cb_ad.setItems(options);
        cb_ad.getSelectionModel().select(1);
        cb_enf.setItems(options);
        cb_enf.getSelectionModel().select(0);

        nbtotalF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}")) {
                    nbtotalF.setText(oldValue);
                }
            }
        });
        rechercheF.setText(HotelDetailOfferClientScreenController.currentOffer.getTitre_offre_hotel());

    }

    public void setHotelOfferData(HotelOffer offer) {
        currentHotelOfer = offer;

    }

    @FXML
    private void next(MouseEvent event) {

        if (validate()) {
            reservation.setId_hotel_offre(currentHotelOfer.getId_offre_hotel());
            reservation.setDate_debut_hotel_reservation(debutDate.getValue().toString());
            reservation.setDate_fin_hotel_reservation(finDate.getValue().toString());
            reservation.setAdulte_hotel_reservation(cb_ad.getSelectionModel().getSelectedItem());
            reservation.setEnfant_hotel_reservation(cb_enf.getSelectionModel().getSelectedItem());
            reservation.setNuit_hotel_reservation(Integer.parseInt(nbtotalF.getText()));
            reservation.setId_user(LoginController.result.getId_user());
            goToSecondStep();
        }
    }

    private boolean validate() {

        if (debutDate.getValue() == null) {
            showAlert("verifiez choisir une date de début");
            return false;
        }
        if (!(daysInBetween(LocalDate.parse(currentHotelOfer.getDate_debut_dispo()), debutDate.getValue()) >= 0)) {
            showAlert("verifiez la date de départ");
            return false;
        }
        if (finDate.getValue() == null) {
            showAlert("verifiez choisir une date de l'arrivée");
            return false;
        }
        if (!(daysInBetween(LocalDate.parse(currentHotelOfer.getDate_fin_dispo()), finDate.getValue()) >= 0)) {
            showAlert("verifiez la date de retour");
            return false;
        }
        if (nbtotalF.getText().equals("")) {
            showAlert("verifiez choisir le nombre de nuitée");
            return false;
        }

        return true;
    }

    private void goToSecondStep() {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/reservationHotel/SecondStepReservation.fxml"));
            Scene scene = new Scene(root);
            Scene currentScene = nbtotalF.getScene();
            Stage primStage = (Stage) currentScene.getWindow();
            primStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
        Stage stage = (Stage) nbtotalF.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    public long daysInBetween(java.time.LocalDate startDate, java.time.LocalDate endDate) {
        System.out.println(endDate.toEpochDay() - startDate.toEpochDay());
        return endDate.toEpochDay() - startDate.toEpochDay();
    }

    private void showAlert(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, text, ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
    }

}
