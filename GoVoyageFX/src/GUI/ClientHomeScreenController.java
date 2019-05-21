/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ClientHomeScreenController implements Initializable {

    @FXML
    private Button logoutBtn;




    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void hotelCheck(ActionEvent event) {
    }

    @FXML
    private void volCheck(ActionEvent event) {
    }


    @FXML
    private void logout(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/login.fxml"));
        Scene scene = new Scene(root);
        Scene currentScene = logoutBtn.getScene();
        Stage primStage = (Stage) currentScene.getWindow();
        primStage.setScene(scene);
    }
    
}
