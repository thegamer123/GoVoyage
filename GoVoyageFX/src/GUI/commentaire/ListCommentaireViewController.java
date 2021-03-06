/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.commentaire;

import GUI.HotelDetailOfferClientScreenController;
import GUI.LoginController;
import entite.Commentaire;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import service.ServiceCommentaire;

/**
 * FXML Controller class
 *
 * @author aessegh
 */
public class ListCommentaireViewController implements Initializable {

    @FXML
    private ListView<Pane> commentListView;
    @FXML
    private TextArea commentTextArea;
    ServiceCommentaire serviceCommentaire;
    @FXML
    private Button sendButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        serviceCommentaire = new ServiceCommentaire();
        getAllCommentaire();
    }

    private void getAllCommentaire() {
        
        List<Commentaire> commentaires = serviceCommentaire.findMyCommentairesByOffre(HotelDetailOfferClientScreenController.currentOffer.getId_offre_hotel(), LoginController.result.getId_user());
        List<Pane> panes = new ArrayList<>();
        commentaires.forEach(commentaire -> {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.load(getClass().getResource("CommentaireView.fxml").openStream());
                CommentaireViewController controller = (CommentaireViewController) loader.getController();
                controller.setCommentaire(commentaire);
                controller.setInView();
                panes.add(loader.getRoot());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        commentListView.setItems( FXCollections.observableArrayList(panes));
    }

    @FXML
    private void insertCommentAction(ActionEvent event) {
        Commentaire commentaire = new Commentaire(0, commentTextArea.getText(), HotelDetailOfferClientScreenController.currentOffer.getId_offre_hotel(), LoginController.result.getId_user());
        serviceCommentaire.ajouterCommentaire(commentaire);
        getAllCommentaire();
    }

}
