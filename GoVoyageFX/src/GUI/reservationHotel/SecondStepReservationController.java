/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.reservationHotel;

import GUI.HotelDetailOfferClientScreenController;
import GUI.LoginController;
import GUI.Utility;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class SecondStepReservationController implements Initializable {

    @FXML
    private TextField prenomTF;
    @FXML
    private TextField telTF;
    @FXML
    private TextField nomTF;
    @FXML
    private TextField hotelTF;
    @FXML
    private TextField dateDepartTF;
    @FXML
    private TextField dateArriveTF;
    @FXML
    private TextField nuitTF;
    @FXML
    private TextField adulteTF;
    @FXML
    private TextField enfantTF;
    @FXML
    private TextField emailTF;
    @FXML
    private ImageView nextIV;
    @FXML
    private ImageView backIV;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nextIV.setImage(new Image(Utility.path + "next.png"));
        backIV.setImage(new Image(Utility.path + "next.png"));
        nomTF.setText(LoginController.result.getNom_user());
        prenomTF.setText(LoginController.result.getPrenom_user());
        emailTF.setText(LoginController.result.getEmail_user());
        telTF.setText(String.valueOf(LoginController.result.getTel_user()));
        hotelTF.setText(HotelDetailOfferClientScreenController.currentOffer.getTitre_offre_hotel());
        dateDepartTF.setText(FirstStepReservationHotelController.reservation.getDate_debut_hotel_reservation());
        dateArriveTF.setText(FirstStepReservationHotelController.reservation.getDate_fin_hotel_reservation());
        nuitTF.setText(String.valueOf(FirstStepReservationHotelController.reservation.getNuit_hotel_reservation()));
        adulteTF.setText(String.valueOf(FirstStepReservationHotelController.reservation.getAdulte_hotel_reservation()));
        enfantTF.setText(String.valueOf(FirstStepReservationHotelController.reservation.getEnfant_hotel_reservation()));
    }

    @FXML
    private void next(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/reservationHotel/TarifScreen.fxml"));
        Scene scene = new Scene(root);
        Scene currentScene = telTF.getScene();
        Stage primStage = (Stage) currentScene.getWindow();
        primStage.setScene(scene);
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/reservationHotel/firstStepReservationHotel.fxml"));
        Scene scene = new Scene(root);
        Scene currentScene = telTF.getScene();
        Stage primStage = (Stage) currentScene.getWindow();
        primStage.setScene(scene);
    }

}
