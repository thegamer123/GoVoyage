/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Reclamation;

import GUI.HotelOfferDetailScreenController;
import GUI.LoginController;
import entite.ControleSaisie;
import service.ReclamationService;
import entite.Reclamation;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class HelloReclamationController implements Initializable {

    @FXML
    private RadioButton prixBR;
    @FXML
    private RadioButton qualiteBR;
    @FXML
    private RadioButton autresBR;
    private final ToggleGroup groupe = new ToggleGroup();
    @FXML
    private TextField referenceTF;
    @FXML
    private TextField sujetTF;
    @FXML
    private TextArea descriptionTA;
    @FXML
    private Button imgeBT;
    @FXML
    private Button ann;
    @FXML
    private TextField imageURL;
    @FXML
    private ImageView imageview;
    static String selectedRadioButton;
    @FXML
    private Button pr;
    @FXML
    private Button log;

    RadioButton radio;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        referenceTF.setText(String.valueOf(HotelOfferDetailScreenController.offerId));
        prixBR.setToggleGroup(groupe);
        qualiteBR.setToggleGroup(groupe);
        autresBR.setToggleGroup(groupe);

    }

    @FXML
    private void addRec(ActionEvent event) throws IOException, SQLException {

        if (ControleSaisie.isString(referenceTF.getText()) == false || ControleSaisie.isString(sujetTF.getText()) == false
                || ControleSaisie.isString(descriptionTA.getText()) == false) {
            Alert a1 = new Alert(Alert.AlertType.ERROR);
            a1.setTitle("Erreur Réclamtion");
            if (ControleSaisie.isString(referenceTF.getText()) == false && ControleSaisie.isString(sujetTF.getText()) == false
                    && ControleSaisie.isString(descriptionTA.getText()) == false) {
                a1.setContentText("verifier les troix champs");
            } else if (!ControleSaisie.isString(referenceTF.getText())) {
                a1.setContentText("Vérifier champ référence");
            }
            if (!ControleSaisie.isString(sujetTF.getText())) {
                a1.setContentText("Vérifier champ sujet");
            } else {
                a1.setContentText("Vérifier champ description");
            }
            a1.show();

        } else { 
            radio = (RadioButton) groupe.getSelectedToggle();

            ReclamationService rc = new ReclamationService();
            Reclamation r = new Reclamation(radio.getText(), referenceTF.getText(), descriptionTA.getText(), LoginController.result.getId_user(), sujetTF.getText(), imageURL.getText());
            rc.addRec(r);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("message informatif");
            alert.setContentText("Votre réclamation a été ajouté avec succès");
            alert.showAndWait();
            viderChamps();

        }

    }


    @FXML
    //telecharger une image user 
    private void parcourirAction(ActionEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();

            //Set extension filter
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            FileChooser.ExtensionFilter extFilterJPEG = new FileChooser.ExtensionFilter("GPEG files (*.jpeg)", "*.JPEG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG, extFilterJPEG);
            //Show open file dialog
            File file = fileChooser.showOpenDialog(null);
            String x = file.toPath().toAbsolutePath().toString();
            System.out.println(x);
            imageURL.setText(x.toString());

            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                // Image image1 = SwingFXUtils.toFXImage(bufferedImage, null);
                Image image1 = new Image(file.toURI().toURL().toString());
                imageview.setImage(image1);

            } catch (IOException ex) {
                Logger.getLogger(HelloReclamationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception e) {
            System.out.println("");
        }
    }

    @FXML
    //Mettre les champs à blanc  aprés chaque ajout
    public void annulerAction(ActionEvent event) {
viderChamps();
 
    }
    
    public void viderChamps(){
        referenceTF.setText("");
        sujetTF.setText("");
        descriptionTA.setText("");
        imageview.setImage(null);
        prixBR.setSelected(false);
        qualiteBR.setSelected(false);
        autresBR.setSelected(false);
    }

    public void setSelectedValue(String value) {

        selectedRadioButton = value;
    }

    @FXML
    //Se rediriger vers le home 
    private void previousAction(ActionEvent event) {
//        try {
//
//            Parent page1;
//            page1 = FXMLLoader.load(getClass().getResource("/GUI/HotelDetailOfferClientScreen.fxml"));
//            Scene scene1 = new Scene(page1);
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            stage.setScene(scene1);
//            stage.show();
//
//        } catch (IOException ex) {
//            Logger.getLogger(HelloReclamationController.class.getName()).log(Level.SEVERE, null, ex);
//        }

        closeScreen();

    }

    private void closeScreen() {

        Stage stage = (Stage) referenceTF.getScene().getWindow();
        stage.close();
    }

    @FXML
    //Se déconnecter 
    private void logoutActionR(ActionEvent event) {
        try {

            Parent page1;
            page1 = FXMLLoader.load(getClass().getResource("/GUI/login.fxml"));

            Scene scene1 = new Scene(page1);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene1);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(HelloReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
