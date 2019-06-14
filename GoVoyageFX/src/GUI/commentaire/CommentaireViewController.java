/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Commentaire;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import service.ServiceCommentaire;

/**
 * FXML Controller class
 *
 * @author aessegh
 */
public class CommentaireViewController implements Initializable {

    @FXML
    private Label commentLabel;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;
    @FXML
    private HBox globalHBox;

    private ServiceCommentaire serviceCommentaire;
    private Commentaire commentaire;
    @FXML
    private TextField commentaireTextField;
    @FXML
    private Button saveButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        serviceCommentaire = new ServiceCommentaire();
        commentaireTextField.setPrefWidth(0);
        commentLabel.setPrefWidth(350);
    }

    public void setInView() {
        commentLabel.setText(commentaire.getCorps());
    }

    public void setCommentaire(Commentaire commentaire) {
        this.commentaire = commentaire;
    }

    @FXML
    private void editAction(ActionEvent event) {
        saveButton.setVisible(true);
        commentaireTextField.setVisible(true);
        commentaireTextField.setText(commentLabel.getText());
        commentLabel.setVisible(false);
        editButton.setVisible(false);
        deleteButton.setVisible(false);
        commentaireTextField.requestFocus();
        commentaireTextField.setPrefWidth(350);
        commentLabel.setPrefWidth(0);
    }

    @FXML
    private void deleteAction(ActionEvent event) {
        serviceCommentaire.SuppressionCommentaire(commentaire.getId_commentaire());
    }

    @FXML
    private void saveAction(ActionEvent event) {
        commentaire.setCorps(commentaireTextField.getText());
        serviceCommentaire.ModifierCommentaire(commentaire);
        saveButton.setVisible(false);
        commentaireTextField.setVisible(false);
        commentLabel.setText(commentaireTextField.getText());
        commentLabel.setVisible(true);
        editButton.setVisible(true);
        deleteButton.setVisible(true);
        commentaireTextField.setPrefWidth(0);
        commentLabel.setPrefWidth(350);
    }

}
