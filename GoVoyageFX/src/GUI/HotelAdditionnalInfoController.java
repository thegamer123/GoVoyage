/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.Reclamation.HelloReclamationController;
import entite.Hotel;
import entite.User;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import service.ServiceHotel;
import service.ServiceUser;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class HotelAdditionnalInfoController implements Initializable {

    @FXML
    private TextField nameTF;
    @FXML
    private TextField adrTF;
    @FXML
    private TextField startTF;
    @FXML
    private TextField roomTF;
    @FXML
    private TextField prixTF;

    public static int id_user;
    @FXML
    private Button parcourirBT;
    @FXML
    private ImageView imageH;
    @FXML
    private TextField imageURLTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void submitBtn(ActionEvent event) throws IOException {

        ServiceHotel service = new ServiceHotel();
        int result = -1;
        if (validateData()) {
            result = service.addHotel(new Hotel(0, nameTF.getText(), id_user, 0, adrTF.getText(), startTF.getText(), Integer.parseInt(roomTF.getText()),prixTF.getText(), imageURLTF.getText()));
            if (result > -1) {
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/login.fxml"));
                Scene scene = new Scene(root);
                Scene currentScene = nameTF.getScene();
                Stage primStage = (Stage) currentScene.getWindow();
                primStage.setScene(scene);
            } else {
                showAlert("Problème de connexion");
            }
        }

    }

    private boolean validateData() {

        if (nameTF.getText().equals((""))) {
            showAlert("le champ Nom est obligatoire");
            return false;
        } else if (adrTF.getText().equals((""))) {
            showAlert("le champ Adresse est obligatoire");
            return false;
        } else if (startTF.getText().equals((""))) {
            showAlert("le champ étoile est obligatoire");
            return false;
        } else if (roomTF.getText().equals((""))) {
            showAlert("le champ chambre est obligatoire");
            return false;
        } else if (prixTF.getText().equals((""))) {
            showAlert("le champ prix est obligatoire");
            return false;
        }

        return true;
    }

    private void showAlert(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, text, ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
    }

    public void setIdUser(int id) {
        id_user = id;
    }

    @FXML
   
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
            imageURLTF.setText(x.toString());

            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                // Image image1 = SwingFXUtils.toFXImage(bufferedImage, null);
                Image image1 = new Image(file.toURI().toURL().toString());
                imageH.setImage(image1);

            } catch (IOException ex) {
                Logger.getLogger(HelloReclamationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception e) {
            System.out.println("");
        }
    
    }

}
