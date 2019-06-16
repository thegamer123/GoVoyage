/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Vol;
import java.io.IOException;
import service.Cell;
import service.ServiceVol;
import utils.ConersionDate;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ConsultationVolController implements Initializable {

    private ObservableList<Vol> volList = FXCollections.observableArrayList();

    @FXML
    private TextField FieldFrom;
    @FXML
    private TextField FieldDestination;
    @FXML
    private DatePicker DateDeparture;
//    @FXML
//    private DatePicker DateReturn;
    @FXML
    private Button buttonSerch;
    @FXML
    private Label labelFrom;
    @FXML
    private Label labelTo;
    @FXML
    private Label labelDep;
    @FXML
    private ListView<Vol> listViewVol;
    Image profile = new Image(Utility.path + "vol.png");
    @FXML
    private Button btnbest;
    @FXML
    private Button btncheap;
    @FXML
    private Button btnBack;
    @FXML
    private Button btndecon;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        ServiceVol vol = new ServiceVol();
        List<Vol> list = vol.readAll();
        for (Vol v : list) {
            Vol vol1 = new Vol();
            int id_vol = v.getId_vol();
            // id_vol=v.getId_vol();  
            String origine = v.getOrigine();
            vol1.setId_vol(id_vol);
            vol1.setOrigine(origine);
            String destination = v.getDestination();
            vol1.setDestination(destination);
            String heureDepart = v.getHeureDepart();
            vol1.setHeureDepart(heureDepart);
            String heureArrive = v.getHeureArrive();
            vol1.setHeureArrive(heureArrive);
            String prix = v.getPrix();
            vol1.setPrix(prix);
            int nbEscales = v.getNb_escale();
            vol1.setNb_escale(nbEscales);
            String heureDep = v.getHeureDepart();
            vol1.setHeureDepart(heureDepart);
            String heureArr = v.getHeureArrive();
            vol1.setHeureArrive(heureArrive);
            volList.add(vol1);

        }
        listViewVol.setItems(volList);
        //  listViewVol.setCellFactory(volList -> new Cell<Vol>());
        listViewVol.setCellFactory(new Callback<ListView<Vol>, ListCell<Vol>>() {

            public ListCell<Vol> call(ListView<Vol> lv) {
                return new Cell();
            }
        });
    }

    public void controleSearch() {
        List<Alert> list = new ArrayList<Alert>();
        if (FieldFrom.getText().equals("")) {
            Alert alert = new Alert(AlertType.INFORMATION);

            alert.setTitle("No Selection");
            alert.setHeaderText("No city Selected");
            alert.setContentText(" Please enter a valid city.");
            // list.add( alert);
            alert.showAndWait();
        } else if (FieldDestination.getText().equals("")) {
            labelFrom.textProperty().bind(FieldFrom.textProperty());
            Alert alert1 = new Alert(AlertType.INFORMATION);

            // alert.setTitle("No Selection");
            //alert1.setHeaderText("No city Selected");
            alert1.setContentText(" Please enter a valid city.");
            // list.add( alert1);

            alert1.showAndWait();
        } else if ((DateDeparture.getValue() == null || DateDeparture.getValue().toString().isEmpty())) {
            Alert alert1 = new Alert(AlertType.INFORMATION);

            // alert.setTitle("No Selection");
            //alert1.setHeaderText("No city Selected");
            alert1.setContentText(" Please enter a valid date.");
            // list.add( alert1);

            alert1.showAndWait();
        }

    }

    @FXML
    public void trierParPrix() {

        ObservableList<Vol> volList = FXCollections.observableArrayList();
        ServiceVol vol = new ServiceVol();
        List<Vol> list = vol.readOrderByPriceAsc();
        for (Vol v : list) {
            Vol vol1 = new Vol();
            int id_vol = v.getId_vol();
            // id_vol=v.getId_vol();  
            String origine = v.getOrigine();
            vol1.setId_vol(id_vol);
            vol1.setOrigine(origine);
            String destination = v.getDestination();
            vol1.setDestination(destination);
            String heureDepart = v.getHeureDepart();
            vol1.setHeureDepart(heureDepart);
            String heureArrive = v.getHeureArrive();
            vol1.setHeureArrive(heureArrive);
            String prix = v.getPrix();
            vol1.setPrix(prix);
            int nbEscales = v.getNb_escale();
            vol1.setNb_escale(nbEscales);
            String heureDep = v.getHeureDepart();
            vol1.setHeureDepart(heureDepart);
            String heureArr = v.getHeureArrive();
            vol1.setHeureArrive(heureArrive);
            volList.add(vol1);

        }

        listViewVol.setItems(volList);
        //  listViewVol.setCellFactory(volList -> new Cell<Vol>());
        listViewVol.setCellFactory(new Callback<ListView<Vol>, ListCell<Vol>>() {

            public ListCell<Vol> call(ListView<Vol> lv) {
                return new Cell();
            }
        });
    }

    @FXML
    public void trierParPrixDsc() {

        ObservableList<Vol> volList = FXCollections.observableArrayList();
        ServiceVol vol = new ServiceVol();
        List<Vol> list = vol.readOrderByPriceDsc();
        for (Vol v : list) {
            Vol vol1 = new Vol();
            int id_vol = v.getId_vol();
            // id_vol=v.getId_vol();  
            String origine = v.getOrigine();
            vol1.setId_vol(id_vol);
            vol1.setOrigine(origine);
            String destination = v.getDestination();
            vol1.setDestination(destination);
            String heureDepart = v.getHeureDepart();
            vol1.setHeureDepart(heureDepart);
            String heureArrive = v.getHeureArrive();
            vol1.setHeureArrive(heureArrive);
            String prix = v.getPrix();
            vol1.setPrix(prix);
            int nbEscales = v.getNb_escale();
            vol1.setNb_escale(nbEscales);
            String heureDep = v.getHeureDepart();
            vol1.setHeureDepart(heureDepart);
            String heureArr = v.getHeureArrive();
            vol1.setHeureArrive(heureArrive);
            volList.add(vol1);

        }

        listViewVol.setItems(volList);
        //  listViewVol.setCellFactory(volList -> new Cell<Vol>());
        listViewVol.setCellFactory(new Callback<ListView<Vol>, ListCell<Vol>>() {

            public ListCell<Vol> call(ListView<Vol> lv) {
                return new Cell();
            }
        });
    }

    @FXML
    public void lireParCritereRecherche() {
        controleSearch();
        ConersionDate sr = new ConersionDate();
        // int date = sr.convertirDateToString(DateDeparture);
        String date = sr.convertirDateToString(DateDeparture);
        System.out.println("FieldFrom.getText() = " + FieldFrom.getText());
        System.out.println("FieldDestination.getText() = " + FieldDestination.getText());
        System.out.println("Le résultat est = " + date);

        ObservableList<Vol> volList = FXCollections.observableArrayList();
        ServiceVol vol = new ServiceVol();
        List<Vol> list = vol.lireParCritereRecherche(FieldFrom.getText(), FieldDestination.getText(), date);
        for (Vol v : list) {
            Vol vol1 = new Vol();
            int id_vol = v.getId_vol();
            // id_vol=v.getId_vol();  
            String origine = v.getOrigine();
            vol1.setId_vol(id_vol);

            vol1.setOrigine(origine);
            String destination = v.getDestination();
            vol1.setDestination(destination);
            String heureDepart = v.getHeureDepart();
            vol1.setHeureDepart(heureDepart);
            String heureArrive = v.getHeureArrive();
            vol1.setHeureArrive(heureArrive);
            String prix = v.getPrix();
            vol1.setPrix(prix);
            int nbEscales = v.getNb_escale();
            vol1.setNb_escale(nbEscales);
            String heureDep = v.getHeureDepart();
            vol1.setHeureDepart(heureDepart);
            String heureArr = v.getHeureArrive();
            vol1.setHeureArrive(heureArrive);
            volList.add(vol1);

        }

        listViewVol.setItems(volList);
        //  listViewVol.setCellFactory(volList -> new Cell<Vol>());
        listViewVol.setCellFactory(new Callback<ListView<Vol>, ListCell<Vol>>() {

            public ListCell<Vol> call(ListView<Vol> lv) {
                return new Cell();
            }
        });
    }

    @FXML
    private void rollBack(ActionEvent event) throws IOException {
        // Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/MenuConsultation.fxml"));
        // Scene scene = new Scene(root);
        //Scene currentScene = butSearch.getScene();
        // Stage primStage = (Stage) currentScene.getWindow();
        //primStage.setScene(scene);

        //Stage primStage = new Stage();
        //primStage.setScene(scene);
        //primStage.show();
        closeScreen();

    }

    private void closeScreen() {

        Stage stage = (Stage) listViewVol.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void deconnecter(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/login.fxml"));
        Scene scene = new Scene(root);
        //Scene currentScene = butSearch.getScene();
        // Stage primStage = (Stage) currentScene.getWindow();
        //primStage.setScene(scene);

        Stage primStage = new Stage();
        primStage.setScene(scene);
        primStage.show();
    }
}
