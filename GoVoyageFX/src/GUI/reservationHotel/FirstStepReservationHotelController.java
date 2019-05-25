/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.reservationHotel;

import entite.HotelOffer;
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
import javafx.fxml.Initializable;
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
    private ComboBox<String> cb_enf;
    @FXML
    private ComboBox<String> cb_ad;
    @FXML
    private ImageView nextIV;
    @FXML
    private ImageView backIV;
    private String path = "file:///C:/Users/Lenovo/Desktop/Bob/Esprit 1ere/GoVoyage/GoVoyage/GoVoyageFX/png/";
    ObservableList<String> options
            = FXCollections.observableArrayList(
                    "0",
                    "1",
                    "2",
                    "3",
                    "4",
                    "5",
                    "6"
            );
    static HotelOffer currentHotelOfer;
    @FXML
    private DatePicker finDate;
    @FXML
    private DatePicker debutDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nextIV.setImage(new Image(path + "next.png"));
        backIV.setImage(new Image(path + "next.png"));
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

    }

    public void setHotelOfferData(HotelOffer offer) {
        currentHotelOfer = offer;
        rechercheF.setText(currentHotelOfer.getTitre_offre_hotel());
    }

    @FXML
    private void next(MouseEvent event) {

        if (daysInBetween(LocalDate.parse(currentHotelOfer.getDate_debut_dispo()), debutDate.getValue()) >= 0) {

        } else {
            showAlert("verifiez la date de début");
        }
        
        if (daysInBetween(LocalDate.parse(currentHotelOfer.getDate_fin_dispo()), finDate.getValue()) >= 0) {

        } else {
            showAlert("verifiez la date de début");
        }
    }
    
    
    

    @FXML
    private void back(MouseEvent event) {
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
