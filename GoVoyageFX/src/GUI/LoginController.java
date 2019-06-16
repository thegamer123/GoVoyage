/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.Reclamation.ConsulterReclamationController;
import entite.ControleSaisie;
import entite.User;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import service.ServiceUser;
import utils.CreatePDF;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class LoginController implements Initializable {

    @FXML
    private TextField loginTF;
    @FXML
    private PasswordField passTF;
    public static int id;
    public static User result = null;

    ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void login(ActionEvent event) throws IOException {
        ServiceUser service = new ServiceUser();

        if (validateData()) {
            result = service.loginUser(loginTF.getText(), passTF.getText());
            if (result != null) {

                if (result.getIs_admin_user() == 1) {
                    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/AdminHomeScreen.fxml"));
                    Scene scene = new Scene(root);
                    Scene currentScene = loginTF.getScene();
                    Stage primStage = (Stage) currentScene.getWindow();
                    primStage.setScene(scene);

                } else {
                    if (result.getIs_hotel() == 1) {
                        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/HotelHomeScreen.fxml"));
                        Parent root = (Parent) loader.load();
                        Scene scene = new Scene(root);
                        HotelHomeScreenController controller = loader.getController();
                        controller.setUser(result);
                        Scene currentScene = loginTF.getScene();
                        Stage primStage = (Stage) currentScene.getWindow();
                        primStage.setScene(scene);

                    } else if (result.getIs_agency() == 1) {

                        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/AgenceHomeScreen.fxml"));
                        Parent root = (Parent) loader.load();
                        Scene scene = new Scene(root);
                        AgenceHomeScreenController controller = loader.getController();
                        controller.setUser(result);
                        Scene currentScene = loginTF.getScene();
                        Stage primStage = (Stage) currentScene.getWindow();
                        primStage.setScene(scene);

                    } else if (result.getIs_client() == 1) {
                        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/MenuConsultation.fxml"));
                        Scene scene = new Scene(root);
                        Scene currentScene = loginTF.getScene();
                        Stage primStage = (Stage) currentScene.getWindow();
                        primStage.setScene(scene);

                    }
                }
            } else {
                showAlert("Problème de connexion");
            }
        }

    }

    private boolean validateData() {

        if (loginTF.getText().equals((""))) {
            showAlert("le champ login est obligatoire");
            return false;
        } else if (passTF.getText().equals((""))) {
            showAlert("le champ mot de passe est obligatoire");
            return false;
        }

        return true;
    }

    private void showAlert(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, text, ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
    }

    @FXML
    private void signup(ActionEvent event) throws IOException {
//
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/AjouterUser.fxml"));
        Scene scene = new Scene(root);
        Scene currentScene = loginTF.getScene();
        Stage primStage = (Stage) currentScene.getWindow();
        primStage.setScene(scene);

//        try {
//            CreatePDF.create("C:\\Users\\Lenovo\\Desktop\\libMap", "test", "hello", "C:/Users/Lenovo/Desktop/logo_transparent.png");
//
////            final String username = "govoyage2020@gmail.com";
////            final String password = "Go@@voyage2020";
////
////            Properties props = new Prope rties();
////            props.put("mail.smtp.auth", "true");
////            props.put("mail.smtp.starttls.enable", "true");
////            props.put("mail.smtp.host", "smtp.gmail.com");
////            props.put("mail.smtp.port", "587");
////
////            Session session = Session.getInstance(props,
////                    new javax.mail.Authenticator() {
////                protected PasswordAuthentication getPasswordAuthentication() {
////                    return new PasswordAuthentication(username, password);
////                }
////            });
////
////
////                Multipart multipart = new MimeMultipart();
////                MimeBodyPart attachmentBodyPart = new MimeBodyPart();
////                attachmentBodyPart.attachFile(new File("C:/Users/Lenovo/Desktop/libMaptest.pdf"));
////                multipart.addBodyPart(attachmentBodyPart);
////
////                Message message = new MimeMessage(session);
////                message.setFrom(new InternetAddress("govoyage2020@gmail.com"));
////                message.setRecipients(Message.RecipientType.TO,
////                        InternetAddress.parse("bouraoui.mansouri@gmail.com"));
////                message.setSubject("pdf demander");
////                message.setText("GoVoyage service mail");
////                
////                message.setContent(multipart);
////
////                Transport.send(message);
////
////                System.out.println("Done");
//
//            } catch (Exception ex) {
//                Logger.getLogger(ConsulterReclamationController.class.getName()).log(Level.SEVERE, null, ex);
//            }
    }
}
