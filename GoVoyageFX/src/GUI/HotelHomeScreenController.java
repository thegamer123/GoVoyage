/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Hotel;
import entite.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.ServiceUser;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class HotelHomeScreenController implements Initializable {

    @FXML
    private TextField hotelNameTF;

    public static int idHotel;

    public static String hotelTitle;
    @FXML
    private Button rec;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hotelNameTF.setText(hotelTitle);
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/login.fxml"));
        Scene scene = new Scene(root);
        Scene currentScene = hotelNameTF.getScene();
        Stage primStage = (Stage) currentScene.getWindow();
        primStage.setScene(scene);

    }

    @FXML
    private void myOffers(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/HotelOfferListScreen.fxml"));
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root);
        Scene currentScene = hotelNameTF.getScene();
        Stage primStage = (Stage) currentScene.getWindow();
        primStage.setScene(scene);
    }

    @FXML
    private void AddOffer(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/AddHotelOffer.fxml"));
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root);
        AddHotelOfferController controller = loader.getController();
        controller.setUserId(idHotel);
        Scene currentScene = hotelNameTF.getScene();
        Stage primStage = (Stage) currentScene.getWindow();
        primStage.setScene(scene);

    }

    public void setUser(User user) {
        Hotel hotel = new ServiceUser().getHotelData(user.getId_user());
        String hotelName = hotel.getNom_hotel();
        hotelTitle = hotelName;
        idHotel = hotel.getId_hotel();
        hotelNameTF.setText(hotelName);
    }

    @FXML
    private void ReclamationAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/Reclamation/HelloReclamation.fxml"));
        Scene scene = new Scene(root);
        Scene currentScene = hotelNameTF.getScene();
        Stage primStage = (Stage) currentScene.getWindow();
        primStage.setScene(scene);
    }

}
