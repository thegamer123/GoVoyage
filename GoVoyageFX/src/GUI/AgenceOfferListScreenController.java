/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Interface.IRefreshList;
import entite.AgenceOffer;
import entite.CellHotelOffer;
import entite.HotelOffer;
import entite.Vol;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.CellAgenceOffer;
import service.ServiceHotel;
import service.ServiceVol;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AgenceOfferListScreenController implements Initializable, IRefreshList {

    @FXML
    private ListView<Vol> lsitViewHotel;
    @FXML
    private TextField searchTF;
    ObservableList<Vol> listR;
    ObservableList<Vol> filteredList;
    ServiceVol service;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        service = new ServiceVol();
        listR = FXCollections.observableArrayList(service.readAllByAgenceId(String.valueOf(AgenceHomeScreenController.idAgence)));
        filteredList = listR;

        bindView();

        searchTF.textProperty().addListener((observable, oldValue, newValue) -> {

            if (!newValue.equals("")) {
                filteredList.clear();
                listR.stream().filter(it -> it.getOrigine().contains(newValue)).forEach(it -> {
                    filteredList.add(it);
                });

            } else {
                filteredList.clear();
                listR = FXCollections.observableArrayList(service.readAllByAgenceId(String.valueOf(AgenceHomeScreenController.idAgence)));
                filteredList.addAll(listR);
            }
            bindView();
        });
    }

    public void bindView() {

        System.out.println(AgenceHomeScreenController.idAgence);
        lsitViewHotel.setItems(filteredList);
        lsitViewHotel.setOnMouseClicked((MouseEvent event) -> {
            System.out.println("clicked on " + lsitViewHotel.getSelectionModel().getSelectedItem());
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/AgenceOfferDetailScreen.fxml"));
            Parent root = null;
            try {
                root = (Parent) loader.load();
            } catch (IOException ex) {
                Logger.getLogger(ConsultationOffreController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Scene scene = new Scene(root);
            AgenceOfferDetailScreenController controller = loader.getController();
            controller.setAgenceOffer(lsitViewHotel.getSelectionModel().getSelectedItem(), this);
            Stage primStage = new Stage();
            primStage.setScene(scene);
            primStage.show();
        });
        lsitViewHotel.setCellFactory(new javafx.util.Callback<ListView<Vol>, ListCell<Vol>>() {

            public ListCell<Vol> call(ListView<Vol> lv) {
                return new CellAgenceOffer();
            }
        });

    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/AgenceHomeScreen.fxml"));
        Scene scene = new Scene(root);
        Scene currentScene = lsitViewHotel.getScene();
        Stage primStage = (Stage) currentScene.getWindow();
        primStage.setScene(scene);
    }

    @Override
    public void refreshListOnBack() {
        bindView();
    }

}
