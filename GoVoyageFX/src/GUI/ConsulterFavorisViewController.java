/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Favoris;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import service.FavorisService;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class ConsulterFavorisViewController implements Initializable {

    @FXML
    private ListView<Pane> favorisesListView;

    private FavorisService favorisService;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        favorisService = new FavorisService();
        getMyFavoris();
    }

    public void getMyFavoris() {
        List<Favoris> favorises = favorisService.findMyFavourites(LoginController.result.getId_user());
        favorises.forEach(favoris -> {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.load(getClass().getResource("FavorisView.fxml").openStream());
                FavorisViewController controller = (FavorisViewController) loader.getController();
                controller.setFavoris(favoris);
                controller.setFavorisInTemplate();
                favorisesListView.getItems().add(loader.getRoot());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    @FXML
    private void retourAction(ActionEvent event) {
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("ConsultationOffre.fxml"));
            ((Button) event.getSource()).getScene().setRoot(pane);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
