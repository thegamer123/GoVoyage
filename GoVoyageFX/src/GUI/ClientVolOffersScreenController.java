/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Interface.IRefreshList;
import entite.Vol;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.CellAgenceOffer;
import service.ServiceVol;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ClientVolOffersScreenController implements Initializable, IRefreshList {

    @FXML
    private ListView<Vol> lsitViewHotel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bindView();
    }

    public void bindView() {
        ServiceVol service = new ServiceVol();
        System.out.println(AgenceHomeScreenController.idAgence);
        ObservableList<Vol> listR = FXCollections.observableArrayList(service.readAll());

        lsitViewHotel.setItems(listR);
        lsitViewHotel.setOnMouseClicked((MouseEvent event) -> {
            System.out.println("clicked on " + lsitViewHotel.getSelectionModel().getSelectedItem());
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/ClientVolOfferDetailScreen.fxml"));
            Parent root = null;
            try {
                root = (Parent) loader.load();
            } catch (IOException ex) {
                Logger.getLogger(ConsultationOffreController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Scene scene = new Scene(root);
            ClientVolOfferDetailScreenController controller = loader.getController();
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
    private void back(ActionEvent event) {
        closeScreen();
    }

    @Override
    public void refreshListOnBack() {
        bindView();
    }

    private void closeScreen() {

        Stage stage = (Stage) lsitViewHotel.getScene().getWindow();
        stage.close();
    }

}
