/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.reservationHotel;

import GUI.HotelDetailOfferClientScreenController;
import GUI.Reclamation.ConsulterReclamationController;
import java.io.File;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import service.ReservationHotelService;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import utils.CreatePDF;


public class TarifScreenController implements Initializable {

    @FXML
    private TextField tarif;
    @FXML
    private TextField chmF;
    @FXML
    private TextField jourF;
    @FXML
    private Button btn_confirmer;
    @FXML
    private TextField chmF1;
    private int adultePrice;
    private double enfantPrice;
    @FXML
    private Button btn_confirmer1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tarif.setText(HotelDetailOfferClientScreenController.currentOffer.getPrix());
        chmF.setText(String.valueOf(FirstStepReservationHotelController.reservation.getEnfant_hotel_reservation()));
        chmF1.setText(String.valueOf(FirstStepReservationHotelController.reservation.getAdulte_hotel_reservation()));
        jourF.setText(String.valueOf(FirstStepReservationHotelController.reservation.getNuit_hotel_reservation()));
        adultePrice = FirstStepReservationHotelController.reservation.getAdulte_hotel_reservation() * Integer.parseInt(HotelDetailOfferClientScreenController.currentOffer.getPrix());
        enfantPrice = FirstStepReservationHotelController.reservation.getEnfant_hotel_reservation() * 0.5 * Integer.parseInt(HotelDetailOfferClientScreenController.currentOffer.getPrix());
        tarif.setText(String.valueOf(adultePrice + enfantPrice));

    }

    @FXML
    private void confirmer(ActionEvent event) {

        ReservationHotelService service = new ReservationHotelService();
        boolean result = false;
        result = service.addReservation(FirstStepReservationHotelController.reservation);
    String txt1;
        if (result) 
       
        {
            try {
                txt1  = "Tarif:" + tarif.getText()+ "\n"+ "Chambre adulte:" + chmF1.getText() + "\n" + "Chambre enfant:" +chmF.getText() + "\n"+ "Nuits:" + jourF.getText();
                System.out.println(txt1);

            CreatePDF.create("C:\\Users\\Yosr Hafsi\\Desktop\\hello", "test", txt1 , "C:/Users/Yosr Hafsi/Desktop/logo.png");

            final String username = "govoyage2020@gmail.com";
            final String password = "Go@@voyage2020";

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });


                Multipart multipart = new MimeMultipart();
                MimeBodyPart attachmentBodyPart = new MimeBodyPart();
                attachmentBodyPart.attachFile(new File("C:/Users/Yosr Hafsi/Desktop/hellotest.pdf"));
                multipart.addBodyPart(attachmentBodyPart);

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("govoyage2020@gmail.com"));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse("yosr.hafsi@esprit.tn"));
                message.setSubject("pdf demander");
                message.setText("GoVoyage service mail");
                
                message.setContent(multipart);

                Transport.send(message);

                System.out.println("Done");

            CreatePDF.create("C:\\Users\\Yosr Hafsi\\Desktop\\hello", "hello", txt1 , "C:/Users/Yosr Hafsi/Desktop/logo.png");

//            final String username = "govoyage2020@gmail.com";
//            final String password = "Go@@voyage2020";
//
//            Properties props = new Properties();
//            props.put("mail.smtp.auth", "true");
//            props.put("mail.smtp.starttls.enable", "true");
//            props.put("mail.smtp.host", "smtp.gmail.com");
//            props.put("mail.smtp.port", "587");
//
//            Session session = Session.getInstance(props,
//                    new javax.mail.Authenticator() {
//                protected PasswordAuthentication getPasswordAuthentication() {
//                    return new PasswordAuthentication(username, password);
//                }
//            });
//
//
//                Multipart multipart = new MimeMultipart();
//                MimeBodyPart attachmentBodyPart = new MimeBodyPart();
//                attachmentBodyPart.attachFile(new File("C:/Users/Yosr Hafsi/Desktop/hellotest.pdf"));
//                multipart.addBodyPart(attachmentBodyPart);
//
//                Message message = new MimeMessage(session);
//                message.setFrom(new InternetAddress("govoyage2020@gmail.com"));
//                message.setRecipients(Message.RecipientType.TO,
//                        InternetAddress.parse("hafsi.yoser@gmail.com"));
//                message.setSubject("pdf demander");
//                message.setText("GoVoyage service mail");
//                
//                message.setContent(multipart);
//
//                Transport.send(message);
//
//                System.out.println("Done");


            } catch (Exception ex) {
                Logger.getLogger(ConsulterReclamationController.class.getName()).log(Level.SEVERE, null, ex);
            }
            closeScreen();
        } else {
            showAlert("Erreur dans l'opération");
        }

    }

    private void showAlert(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, text, ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
    }

    @FXML
    private void annuler(ActionEvent event) {
           Stage stage = (Stage) chmF1.getScene().getWindow();
        stage.close();
    }

    void closeScreen() {
        
        TrayNotification tn = new TrayNotification("Réservation", "Réservation envoyée avec succèes", NotificationType.SUCCESS);
        tn.showAndWait();
        Stage stage = (Stage) chmF1.getScene().getWindow();
        stage.close();
    }
    
    

}
