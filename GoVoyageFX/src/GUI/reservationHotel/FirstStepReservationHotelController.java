/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.reservationHotel;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FirstStepReservationHotelController implements Initializable {

    @FXML
    private TextField rechercheF;
    @FXML
    private DatePicker dt1;
    @FXML
    private DatePicker dt2;
    @FXML
    private TextField nbtotalF;
    @FXML
    private Button btn_rch;
    @FXML
    private ComboBox<?> cb_enf;
    @FXML
    private ComboBox<?> cb_ad;
    @FXML
    private Button btn_rch1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterReservation(ActionEvent event) {
    }
    
}
