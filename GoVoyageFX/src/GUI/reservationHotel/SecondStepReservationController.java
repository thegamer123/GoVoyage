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
import javafx.scene.control.TextField;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void next(ActionEvent event) {
    }
    
}
