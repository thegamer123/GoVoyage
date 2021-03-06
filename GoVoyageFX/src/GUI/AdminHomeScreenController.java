/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.crypto.NullCipher;
import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import service.ServiceHotel;
import service.ServiceVol;
import utils.CreatePDF;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AdminHomeScreenController implements Initializable {

    @FXML
    private Button hotelBtn;
    @FXML
    private Button volBtn;
    @FXML
    private Button reclamation;
    @FXML
    private Pane pdfPane;

    @FXML
    private PieChart pieChartAdmin;
    private final ObservableList<PieChart.Data> user = FXCollections.observableArrayList();
    private final ObservableList<PieChart.Data> user2 = FXCollections.observableArrayList();

    @FXML
    private PieChart pieChartVol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        final NumberAxis xAxis = new NumberAxis(0, 10, 1);
        final NumberAxis yAxis = new NumberAxis(-100, 500, 100);
        ServiceHotel service = new ServiceHotel();
        ServiceVol serviceVol = new ServiceVol();
        user.addAll(new PieChart.Data("Offre hotel", service.getHotelCount()),
                new PieChart.Data("Réservation hotel", service.getHotelReservationCount())
        );

        pieChartAdmin.setData(user);

        pieChartAdmin.setLegendSide(Side.BOTTOM);
        pieChartAdmin.setLabelsVisible(true);

        user2.addAll(new PieChart.Data("Offre vol", serviceVol.getVolCount()),
                new PieChart.Data("Réservation vol", serviceVol.getVolReservationCount())
        );

        pieChartVol.setData(user2);
        pieChartVol.setStyle("CHART_COLOR_1: #ff0000 ; CHART_COLOR_2: #0000FF ;");
        pieChartVol.setLegendSide(Side.BOTTOM);
        pieChartVol.setLabelsVisible(true);

    }

    @FXML
    private void hotelCheck(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/MenuConsultation.fxml"));
        Scene scene = new Scene(root);
//        Scene currentScene = volBtn.getScene();
//        Stage primStage = (Stage) currentScene.getWindow();
//        primStage.setScene(scene);
        Stage primStage = new Stage();
        primStage.setScene(scene);
        primStage.show();
    }

    @FXML
    private void volCheck(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/MenuConsultation.fxml"));
        Scene scene = new Scene(root);
//        Scene currentScene = volBtn.getScene();
//        Stage primStage = (Stage) currentScene.getWindow();
//        primStage.setScene(scene);
        Stage primStage = new Stage();
        primStage.setScene(scene);
        primStage.show();
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/login.fxml"));
        Scene scene = new Scene(root);
        Scene currentScene = hotelBtn.getScene();
        Stage primStage = (Stage) currentScene.getWindow();
        primStage.setScene(scene);

    }

    @FXML
    private void reclamation(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/Reclamation/ConsulterReclamation.fxml"));
        Scene scene = new Scene(root);
//        Scene currentScene = volBtn.getScene();
//        Stage primStage = (Stage) currentScene.getWindow();
//        primStage.setScene(scene);
        Stage primStage = new Stage();
        primStage.setScene(scene);
        primStage.show();
    }

    @FXML
    private void exportToPdfAction(ActionEvent event) throws IOException {

        WritableImage nodeshot = pdfPane.snapshot(new SnapshotParameters(), null);
        File file = new File("chart.png");

        try {
            ImageIO.write(SwingFXUtils.fromFXImage(nodeshot, null), "png", file);
        } catch (IOException e) {

        }

        CreatePDF.viewToPdf("C:\\Users\\Lenovo\\Desktop\\", "chart", "", file.getAbsolutePath(), "C:/Users/Lenovo/Desktop/logo_transparent.png");

        try {

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
            attachmentBodyPart.attachFile(new File("C:/Users/Lenovo/Desktop/chart.pdf"));
            multipart.addBodyPart(attachmentBodyPart);

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("govoyage2020@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(LoginController.result.getEmail_user()));
            message.setSubject("Chart Pdf(statistiques)");
            message.setText("GoVoyage service mail");

            message.setContent(multipart);

            Transport.send(message);

            System.out.println("Done");
        } catch (Exception e) {

        }

    }

}
