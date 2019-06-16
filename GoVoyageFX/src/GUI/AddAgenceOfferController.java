/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.AgenceOffer;
import entite.Vol;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import service.ServiceAgence;
import service.ServiceHotel;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import utils.CountriesList;
import utils.Time24HoursValidator;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AddAgenceOfferController implements Initializable {

    @FXML
    private DatePicker startDP;
    @FXML
    private TextField priceTF;

    @FXML
    private DatePicker startDP1;
    @FXML
    private TextField houreStartTF;
    @FXML
    private TextField houreEndTF1;
    @FXML
    private TextField fromTF;
    @FXML
    private TextField toTF;
    @FXML
    private TextField nbEscTF;
    private static int userId;

    private final ExecutorService executorService = Executors.newCachedThreadPool();
    private ObservableList<Map<String, String>> listOfPeople;

    Time24HoursValidator hoursValidator;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        hoursValidator = new Time24HoursValidator();

        priceTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    priceTF.setText(oldValue);
                }
            }
        });

        nbEscTF.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    nbEscTF.setText(oldValue);
                }
            }
        });

    }

    /* private void choosePic(MouseEvent event) throws MalformedURLException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files",
                        "*.bmp", "*.png", "*.jpg", "*.gif")); // limit fileChooser options to image files
        File selectedFile = fileChooser.showOpenDialog(startDP.getScene().getWindow());

        if (selectedFile != null) {

            imageFile = selectedFile.toURI().toURL().toString();
            imageName = selectedFile.getName();
            Image image = new Image(imageFile);
            picIV.setImage(image);
        } else {
            //fileSelected.setText("Image file selection cancelled.");
        }
    }*/
    @FXML
    private void submit(ActionEvent event) {

        ServiceAgence service = new ServiceAgence();
        boolean result = false;
        if (validateData()) {

            result = service.addVolToAgency(new Vol(0,
                    Integer.parseInt(nbEscTF.getText()),
                    priceTF.getText(),
                    fromTF.getText(),
                    toTF.getText(),
                    houreStartTF.getText(),
                    houreEndTF1.getText(),
                    startDP.getValue().toString(),
                    startDP1.getValue().toString(),
                    userId));

            if (result) {
                showAlert("offre ajouté avec succès");
                closeScreen();

            } else {
                showAlert("Erreur dans l'opération");
            }
        }

    }

    private boolean validateData() {

        if (fromTF.getText().equals("")) {
            showAlert("De : champs obligatoire");
            return false;
        }
        if (toTF.getText().equals("")) {
            showAlert("A : champs obligatoire");
            return false;
        }

        if (nbEscTF.getText().equals("")) {
            showAlert("nombre d'escale est obligatoire");
            return false;
        }
        if (priceTF.getText().equals("")) {
            showAlert("le prix est obligatoire");
            return false;
        }
        if (!hoursValidator.validate(houreStartTF.getText())) {
            showAlert("Validé l'heure de départ");
            return false;
        }
        if (!hoursValidator.validate(houreEndTF1.getText())) {
            showAlert("Validé l'heure de l'arrivée");
            return false;
        }
        return true;
    }

    public void setUserId(int userID) {
        userId = userID;
    }

    private void closeScreen() {
        TrayNotification tn = new TrayNotification("Offre", "Votre Offre a été ajouté avec succèes", NotificationType.SUCCESS);
        tn.showAndWait();
        Stage stage = (Stage) priceTF.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String text) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION, text, ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
    }

    @FXML
    private void back(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/AgenceHomeScreen.fxml"));
        Scene scene = new Scene(root);
        Scene currentScene = priceTF.getScene();
        Stage primStage = (Stage) currentScene.getWindow();
        primStage.setScene(scene);
    }

}
