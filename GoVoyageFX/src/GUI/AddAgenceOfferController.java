/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.AgenceOffer;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import service.ServiceAgence;
import service.ServiceHotel;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AddAgenceOfferController implements Initializable {

    @FXML
    private TextField titreTF;
    @FXML
    private ImageView picIV;
    @FXML
    private DatePicker startDP;
    @FXML
    private DatePicker endDP;
    @FXML
    private TextField priceTF;
    @FXML
    private TextArea descriptionTA;

    private String imageFile;
    private String imageName;

    private static int userId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void choosePic(MouseEvent event) throws MalformedURLException {
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

    @FXML
    private void submit(ActionEvent event) {

        ServiceAgence service = new ServiceAgence();
        boolean result = false;
        if (validateData()) {

            result = service.addOfferToHotel(new AgenceOffer(0, titreTF.getText(), imageName, descriptionTA.getText(), startDP.getValue().toString(), endDP.getValue().toString(), priceTF.getText(), userId));
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

    public void setUserId(int userID) {
        userId = userID;
    }

    private void showAlert(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, text, ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
    }

}
