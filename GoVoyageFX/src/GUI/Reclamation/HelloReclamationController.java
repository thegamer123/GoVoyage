/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Reclamation;

import GUI.LoginController;
import service.ReclamationService;
import entite.Reclamation;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    private ToggleGroup groupe = new ToggleGroup();
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
    private static ImageView imageview;
    static String selectedRadioButton;
    @FXML
    private Button pr;
    @FXML
    private Button log;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    //Ajout reclamation user
    private void addRec(ActionEvent event) throws IOException {
        prixBR.setToggleGroup(groupe);
        qualiteBR.setToggleGroup(groupe);
        autresBR.setToggleGroup(groupe);

        RadioButton radio = (RadioButton) groupe.getSelectedToggle();
        Reclamation r = new Reclamation(radio.getText(), referenceTF.getText(), descriptionTA.getText(), LoginController.id, sujetTF.getText(), imageURL.getText());

        ReclamationService rc = new ReclamationService();
        rc.addRec(r);

    }

    @FXML
    //telecharger une image user 
    private void parcourirAction(ActionEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();

            //Set extension filter
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
//        FileChooser.ExtensionFilter extFilterTout = new FileChooser.ExtensionFilter("All files (*.*)", "*.*");
            FileChooser.ExtensionFilter extFilterJPEG = new FileChooser.ExtensionFilter("GPEG files (*.jpeg)", "*.JPEG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG, extFilterJPEG);
            //Show open file dialog
            File file = fileChooser.showOpenDialog(null);
            String x = file.toPath().toAbsolutePath().toString();
            System.out.println(x);
            imageURL.setText(x.toString());

            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                Image image1 = SwingFXUtils.toFXImage(bufferedImage, null);
                imageview.setImage(image1);

            } catch (IOException ex) {
                Logger.getLogger(HelloReclamationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception e) {
            System.out.println("");
        }
    }

    @FXML
    public void annulerAction(ActionEvent event) {

        referenceTF.setText("");
        sujetTF.setText("");
        descriptionTA.setText("");
    }

    public void setSelectedValue(String value) {

        selectedRadioButton = value;
    }

    @FXML
    private void FindIMG(KeyEvent event) {
    }

    @FXML
    //Se rediriger vers le home 
    private void previousAction(ActionEvent event) {
        try {

            Parent page1;
            page1 = FXMLLoader.load(getClass().getResource("/GUI/AgenceHomeScreen.fxml"));
            Scene scene1 = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene1);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(HelloReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }

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
