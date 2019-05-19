/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.sun.prism.PhongMaterial.MapType;
import entite.User;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import service.ServiceUser;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AjouterUserController implements Initializable {

    @FXML
    private Button validerBTN;
    @FXML
    private Label user_name;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField prenomTF;
    @FXML
    private TextField telTF;
    @FXML
    private DatePicker naissanceDP;
    @FXML
    private Label t;
    @FXML
    private Label t1;
    @FXML
    private TextField passTF1;
    @FXML
    private TextField loginTF;
    @FXML
    private Button validerBTN1;
    @FXML
    private Label t21;
    @FXML
    private ImageView gpsIV;

    GoogleMapView mapView;
    GoogleMap map;
    private Spinner<String> compteType;
    @FXML
    private ComboBox<String> compteTypeCB;
    private String selectedType;
    private Scene scene;
    MyBrowser myBrowser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        compteTypeCB.getItems().addAll("Hotel", "Agence", "Voyageur");
        compteTypeCB.getSelectionModel().select(0);
        selectedType = "Hotel";
        compteTypeCB.getSelectionModel()
                .selectedIndexProperty()
                .addListener(observable -> selectedType = compteTypeCB.getValue());

    }

    @FXML
    private void submit(ActionEvent event) throws IOException {

        switch (selectedType) {
            case "Voyageur":
                if (validateData()) {
                    ServiceUser service = new ServiceUser();
                    int result = service.ajouterUser(new User(0,
                            loginTF.getText(),
                            nameTF.getText(),
                            prenomTF.getText(),
                            naissanceDP.getValue().toString(),
                            passTF1.getText(),
                            Integer.parseInt(telTF.getText()), "", "", 0, 0, 0, 0, 1));

                    if (result > -1) {

                        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/login.fxml"));
                        Scene scene = new Scene(root);
                        Scene currentScene = user_name.getScene();
                        Stage primStage = (Stage) currentScene.getWindow();
                        primStage.setScene(scene);

                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION, "problem in the request ", ButtonType.OK);
                        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                        alert.show();
                    }
                }
                break;
            case "Agence":
                if (validateData()) {
                    ServiceUser service = new ServiceUser();
                    int result = service.ajouterUser(new User(0,
                            loginTF.getText(),
                            nameTF.getText(),
                            prenomTF.getText(),
                            naissanceDP.getValue().toString(),
                            passTF1.getText(),
                            Integer.parseInt(telTF.getText()), "", "", 0, 0, 0, 1, 0));

                    if (result > -1) {
                        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/AgenceAdditionalInfo.fxml"));
                        Parent root = (Parent) loader.load();
                        Scene scene = new Scene(root);
                        AgenceAdditionalInfoController controller = loader.getController();
                        controller.setIdUser(result);
                        Scene currentScene = user_name.getScene();
                        Stage primStage = (Stage) currentScene.getWindow();
                        primStage.setScene(scene);

                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION, "problem in the request ", ButtonType.OK);
                        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                        alert.show();
                    }
                }
                break;
            default:
                if (validateData()) {
                    ServiceUser service = new ServiceUser();
                    int result = service.ajouterUser(new User(0,
                            loginTF.getText(),
                            nameTF.getText(),
                            prenomTF.getText(),
                            naissanceDP.getValue().toString(),
                            passTF1.getText(),
                            Integer.parseInt(telTF.getText()), "", "", 0, 0, 1, 0, 0));

                    if (result > -1) {

                        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/HotelAdditionnalInfo.fxml"));
                        Parent root = (Parent) loader.load();
                        Scene scene = new Scene(root);
                        HotelAdditionnalInfoController controller = loader.getController();
                        controller.setIdUser(result);
                        Scene currentScene = user_name.getScene();
                        Stage primStage = (Stage) currentScene.getWindow();
                        primStage.setScene(scene);

                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION, "login déja utilisé", ButtonType.OK);
                        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                        alert.show();
                    }
                }
                break;
        }
    }

    private boolean validateData() {

        if (loginTF.getText().equals((""))) {
            showAlert("le champ login est obligatoire");
            return false;
        } else if (nameTF.getText().equals((""))) {
            showAlert("le champ nom est obligatoire");
            return false;
        } else if (prenomTF.getText().equals((""))) {
            showAlert("le champ prénom est obligatoire");
            return false;
        } else if (naissanceDP.getValue().toString().equals("")) {
            showAlert("le champ date de naissance est obligatoire");
            return false;
        } else if (passTF1.getText().toString().equals("")) {
            showAlert("le champ mot de passe est obligatoire");
            return false;
        } else if (telTF.getText().equals("")) {
            showAlert("le champ telephone est obligatoire");
            return false;
        }

        return true;
    }

    private void showAlert(String text) {
        Alert alert = new Alert(AlertType.INFORMATION, text, ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
    }

    @FXML
    private void goToGps(MouseEvent event) throws IOException {

        myBrowser = new MyBrowser();
        scene = new Scene(myBrowser, 640, 480);
        Scene currentScene = user_name.getScene();
        Stage primStage = new Stage();
        primStage.setScene(scene);
        primStage.show();

    }

    @FXML
    private void back(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/login.fxml"));
        Scene scene = new Scene(root);
        Scene currentScene = loginTF.getScene();
        Stage primStage = (Stage) currentScene.getWindow();
        primStage.setScene(scene);
    }

    class MyBrowser extends Region {

        HBox toolbar;

        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        public MyBrowser() {

            final URL urlGoogleMaps = getClass().getClassLoader().getResource("GUI/map/googlemaps.html");
            webEngine.load(urlGoogleMaps.toExternalForm());

            boolean add = getChildren().add(webView);

        }

    }

}
