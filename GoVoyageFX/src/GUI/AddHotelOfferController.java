/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.HotelOffer;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import service.ServiceHotel;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AddHotelOfferController implements Initializable {

    @FXML
    private TextField titreTF;
    @FXML
    private DatePicker startDP;
    @FXML
    private DatePicker endDP;
    @FXML
    private TextField priceTF;
    @FXML
    private TextArea descriptionTA;

    private String imageFile;
    @FXML
    private ImageView picIV;

    private String imageName;

    public static int userId;

    ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        priceTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                      priceTF.setText(oldValue);
                }
            }
        });
    }

    @FXML
    private void submitOffer(ActionEvent event) {

        ServiceHotel service = new ServiceHotel();
        boolean result = false;
        if (validateData()) {

            result = service.addOfferToHotel(new HotelOffer(0, titreTF.getText(), imageName, descriptionTA.getText(), startDP.getValue().toString(), endDP.getValue().toString(), priceTF.getText(), userId));
        }

        if (result) {
            showAlert("offre ajouté avec succès");
        } else {
            showAlert("Erreur dans l'opération");
        }

    }

    private boolean validateData() {

        return true;
    }

    @FXML
    private void choosePicture(MouseEvent event) throws MalformedURLException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files",
                        "*.bmp", "*.png", "*.jpg", "*.gif")); // limit fileChooser options to image files
        File selectedFile = fileChooser.showOpenDialog(titreTF.getScene().getWindow());

        if (selectedFile != null) {

            imageFile = selectedFile.toURI().toURL().toString();
            imageName = selectedFile.getName();
            Image image = new Image(imageFile);
            picIV.setImage(image);
        } else {
            //fileSelected.setText("Image file selection cancelled.");
        }
    }

    public void setUserId(int userID) {
        userId = userID;
    }

    private void showAlert(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, text, ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/HotelHomeScreen.fxml"));
        Scene scene = new Scene(root);
        Scene currentScene = picIV.getScene();
        Stage primStage = (Stage) currentScene.getWindow();
        primStage.setScene(scene);

    }

}
