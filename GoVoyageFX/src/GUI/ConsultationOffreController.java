/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.CellHotelOffer;
import entite.HotelOffer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import service.ServiceHotel;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ConsultationOffreController implements Initializable {

    @FXML
    private ListView<HotelOffer> lsitViewHotel;
    @FXML
    private TextField searchTF;
    ObservableList<HotelOffer> listR;
    ObservableList<HotelOffer> filteredList;
    ServiceHotel service;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        service = new ServiceHotel();

        if (LoginController.result.getIs_client() == 0) {
            listR = FXCollections.observableArrayList(service.readAllOffersByHotelId(String.valueOf(HotelHomeScreenController.idHotel)));
        } else {
            listR = FXCollections.observableArrayList(service.readAllOffers());
        }

        filteredList = listR;

        bindView();
        searchTF.textProperty().addListener((observable, oldValue, newValue) -> {

            if (!newValue.equals("")) {
                filteredList.clear();
                listR.stream().filter(it -> it.getTitre_offre_hotel().contains(newValue)).forEach(it -> {
                    filteredList.add(it);
                });

            } else {
                filteredList.clear();
                listR = FXCollections.observableArrayList(service.readAllOffers());
                filteredList.addAll(listR);
            }
            bindView();
        });

    }

    private void bindView() {
        lsitViewHotel.setItems(filteredList);
        lsitViewHotel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("clicked on " + lsitViewHotel.getSelectionModel().getSelectedItem());
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/HotelDetailOfferClientScreen.fxml"));
                Parent root = null;
                try {
                    root = (Parent) loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(ConsultationOffreController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Scene scene = new Scene(root);
                HotelDetailOfferClientScreenController controller = loader.getController();
                controller.setHotelOfferData(lsitViewHotel.getSelectionModel().getSelectedItem());
                Stage primStage = new Stage();
                primStage.setScene(scene);
                primStage.show();
            }
        });
        lsitViewHotel.setCellFactory(new javafx.util.Callback<ListView<HotelOffer>, ListCell<HotelOffer>>() {

            public ListCell<HotelOffer> call(ListView<HotelOffer> lv) {
                return new CellHotelOffer();
            }
        });
    }

    @FXML
    private void checkMyFavorites(ActionEvent event) {
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("ConsulterFavorisView.fxml"));
            ((Button) event.getSource()).getScene().setRoot(pane);
        } catch (IOException ex) {
        }
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        Stage stage = (Stage) searchTF.getScene().getWindow();
        stage.close();

    }

}
