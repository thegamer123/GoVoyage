/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Reclamation;

import GUI.HotelOfferDetailScreenController;
import GUI.LoginController;
import service.HistoriqueService;
import service.ReclamationService;
import service.RepondReclamationService;
import entite.ControleSaisie;
import entite.Historique;
import entite.Reclamation;
import entite.RepondReclamation;
import entite.User;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import service.ServiceUser;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import utils.CreatePDF;

/**
 * FXML Controller class
 *
 * @author Omar
 */
public class ConsulterReclamationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<?> listR;
    @FXML
    private Button supp;
    @FXML
    private TextField rechbtn;
    @FXML
    private TextField email;
    @FXML
    private TextField sujet;
    @FXML
    private TextArea description;
    private ToggleGroup groupe = new ToggleGroup();
    @FXML
    private RadioButton ntr;
    @FXML
    private RadioButton tr;
    @FXML
    private Button repondR;
    @FXML
    private AnchorPane admin;
    @FXML
    private AnchorPane details;
    @FXML
    private AnchorPane re;
    @FXML
    private Button btnRefresh;

    @FXML
    private Button supp2;
    @FXML
    private Button ref2;
    @FXML
    private TableView<?> mesList;
    @FXML
    private TextField rechMe;
    private final ObservableList<PieChart.Data> user = FXCollections.observableArrayList();
    @FXML
    private PieChart pieChart;
    @FXML
    private Tab histo;
    @FXML
    private TableView<?> his;
    @FXML
    private TextField serchhis;
    @FXML
    private Button supphi;
    @FXML
    private Button refhis;
    @FXML
    private ImageView imgVw;
    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private Label email2;
    @FXML
    private Label tel;
    @FXML
    private Label sujet2;
    @FXML
    private TextArea description2;
    @FXML
    private TextField txt_img_name;
    @FXML
    private Label type2;
    @FXML
    private Label sujetM;
    @FXML
    private Label dateM;
    @FXML
    private Label emailM;
    @FXML
    private Label etatM;
    @FXML
    private Label descriptionM;
    @FXML
    private AnchorPane detailsM;
    @FXML
    private PieChart typerec;
    private final ObservableList<PieChart.Data> user2 = FXCollections.observableArrayList();
    @FXML
    private Button log;
    @FXML
    private AnchorPane hi;
    @FXML
    private Label loghis;
    @FXML
    private Label actionhis;
    @FXML
    private Label typehis;
    @FXML
    private Label datehis;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // rafraichir l'écran des reclamation coté admin

        listR.getColumns().clear();
        listR.getItems().clear();
        ReclamationService rs = new ReclamationService();
        ObservableList data = FXCollections.observableArrayList();
        List<Reclamation> liste = rs.getAll();
        data.addAll(liste);
        initialiser(data);

        //      ------------------mes reponses---------------------
        RepondReclamationService rp = new RepondReclamationService();
        ObservableList data1 = FXCollections.observableArrayList();
        List<RepondReclamation> liste2 = rp.getAll();
        data1.addAll(liste2);
        initialiser2(data1);

        stat();
        stat2();

        //        --------------------------------------------Historique----------------------
        HistoriqueService hs = new HistoriqueService();
        ObservableList data2 = FXCollections.observableArrayList();

        List<Historique> liste3 = hs.getAll();
        data2.addAll(liste3);
        initialiser3(data2);

        //     ----------------------------------------------------email--------------------------   
        repondR.setOnAction(event -> {

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

            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("govoyage2020@gmail.com"));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(email.getText()));
                message.setSubject(sujet.getText());
                message.setText(description.getText());

                if (!ControleSaisie.isValidEmailAddress(email.getText())) {
                    Alert a1 = new Alert(Alert.AlertType.ERROR);
                    a1.setTitle("Erreur dans le champ To (email) ");
                    a1.setContentText("le mail n'est pas valide");
                    a1.show();
                    email.setText("");
                } else {

                    Transport.send(message);

                    System.out.println("Done");

                }
            } catch (MessagingException e) {

            }

            tr.setToggleGroup(groupe);
            ntr.setToggleGroup(groupe);

            RadioButton radio = (RadioButton) groupe.getSelectedToggle();

            if (!ControleSaisie.isValidEmailAddress(email.getText())) {
                Alert a1 = new Alert(Alert.AlertType.ERROR);
                a1.setTitle("Erreur dans le champ To (email) ");
                a1.setContentText("le mail n'est pas valide");
                a1.show();
                email.setText("");
            } else if (ControleSaisie.isString(sujet.getText()) == false || ControleSaisie.isString(description.getText()) == false) {
                Alert a1 = new Alert(Alert.AlertType.ERROR);
                a1.setTitle("Erreur Réclamtion");
                if (ControleSaisie.isString(sujet.getText()) == false && ControleSaisie.isString(description.getText()) == false) {
                    a1.setContentText("verifier les deux champs sujet et description");
                } else if (!ControleSaisie.isString(sujet.getText())) {
                    a1.setContentText("Vérifier champ sujet");
                } else {
                    a1.setContentText("Vérifier champ description");
                }
                a1.show();
                sujet.setText("");
                description.setText("");
                email.setText("");
                ntr.setToggleGroup(groupe);
            } else {
                RepondReclamation rp1 = new RepondReclamation(description.getText(), sujet.getText(), email.getText(), radio.getText());
                RepondReclamationService rs1 = new RepondReclamationService();

                rs1.addRec(rp1);
                stat();
                email.setText("");
                sujet.setText("");
                description.setText("");
                tr.setToggleGroup(groupe);
                ntr.setToggleGroup(groupe);
                refrech2Action(event);

                Historique h = new Historique("reponse réclamation", LoginController.result.getId_user());
                hs.add(h);
                refrech3Action(event);

                TrayNotification tn = new TrayNotification("Réponse Réclamation", "Réponse Réclamation avec succés", NotificationType.SUCCESS);
                tn.showAndWait();

            }

        }
        );

    }
//affichage des données du user 

    public void initialiser(ObservableList data) {
        details.setVisible(false);

        TableColumn reference = new TableColumn("reference");
        reference.setCellValueFactory(new PropertyValueFactory("reference"));
        reference.setMinWidth(120);

        TableColumn type = new TableColumn("type");
        type.setCellValueFactory(new PropertyValueFactory("type"));
        type.setMinWidth(250);

        TableColumn sujet = new TableColumn("sujet");
        //Définition des cellules
        sujet.setCellValueFactory(new PropertyValueFactory("sujet"));
        sujet.setMinWidth(130);

        TableColumn description = new TableColumn("description");
        description.setCellValueFactory(new PropertyValueFactory("description"));
        description.setMinWidth(150);

        TableColumn date = new TableColumn("date");
        date.setCellValueFactory(new PropertyValueFactory("date"));
        date.setMinWidth(200);

        listR.setItems(null);
        listR.getColumns().clear();
        listR.setItems(data);
        listR.getColumns().addAll(reference, type, sujet, description, date);
//Séléctione d'une ligne de la listView
        listR.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {

                details.setVisible(true);

                Reclamation r = (Reclamation) listR.getSelectionModel().getSelectedItem();
                ServiceUser us = new ServiceUser();
                User u = us.get(r.getId_user());

                nom.setText(u.getNom_user());
                prenom.setText(u.getPrenom_user());
                tel.setText(String.valueOf(u.getTel_user()));
                email2.setText(u.getEmail_user());
                email.setText(u.getEmail_user());
                if (u.getIs_agency() == 1) {
                    type2.setText("Agence");

                } else if (u.getIs_client() == 1) {
                    type2.setText("Client");
                } else if (u.getIs_admin_user() == 1) {
                    type2.setText("Admin");
                } else {
                    type2.setText("Hotel");
                }
                sujet2.setText(r.getSujet());
                description2.setText(r.getDescription());
                txt_img_name.setText(r.getImage());

                String url = r.getImage();
                File file = new File(url);
                Image image = new Image(file.toURI().toString());
                imgVw.setImage(image);
            }
        });

    }
//---------Statistique des réclamations traités et non traités-----------//

    public void stat() {
        user.clear();
        RepondReclamationService rp = new RepondReclamationService();

        try {
            user.addAll(new PieChart.Data("Traiter", (rp.Calculer("Traiter") * 100) / rp.Calculertotal()));
        } catch (Exception e) {
            user.addAll(new PieChart.Data("Traiter", 0));
        }

        try {
            user.addAll(new PieChart.Data("Non Traiter", (rp.Calculer("Non Traiter") * 100) / rp.Calculertotal()));
        } catch (Exception e) {
            user.addAll(new PieChart.Data("Non Traiter", 0));
        }
//        user.addAll(new PieChart.Data("Traiter", (rp.Calculer("Traiter") * 100) / rp.Calculertotal()),
//                new PieChart.Data("Non Traiter", (rp.Calculer("Non Traiter") * 100) / rp.Calculertotal())
//        );

        pieChart.setData(user);
        pieChart.setTitle("Les statistiques des mes réponses selon etats");
        pieChart.setLegendSide(Side.BOTTOM);
        pieChart.setLabelsVisible(true);

    }
//---------Statistique par type de réclamations-----------//

    public void stat2() {
        user2.clear();
        ReclamationService rs = new ReclamationService();


        
                
        try {
            new PieChart.Data("Prix", (rs.Calculer2("Réclamation sur prix des services") * 100) / rs.Calculertotal2());
        } catch (Exception e) {
            new PieChart.Data("Prix", 0);
        }

        try {
            new PieChart.Data("Qualite", (rs.Calculer2("Réclamation sur qualité de services") * 100) / rs.Calculertotal2());
        } catch (Exception e) {
            new PieChart.Data("Qualite", 0);
        }
        
         try {
           new PieChart.Data("Autre", (rs.Calculer2("Autres réclamations") * 100) / rs.Calculertotal2());
        } catch (Exception e) {
            new PieChart.Data("Autre", 0);
        }
        typerec.setData(user2);
        typerec.setTitle("Statistiques sur les types des réclamation ");
        typerec.setLegendSide(Side.BOTTOM);
        typerec.setLabelsVisible(true);

    }

    public void initialiser2(ObservableList data1) {
//     det.setVisible(false);
//      del3.setVisible(false);
        detailsM.setVisible(false);
        TableColumn Sujet_D = new TableColumn("sujet");
        Sujet_D.setCellValueFactory(new PropertyValueFactory("sujet"));
        Sujet_D.setMinWidth(150);

        TableColumn Description_D = new TableColumn("description");
        Description_D.setCellValueFactory(new PropertyValueFactory("description"));
        Description_D.setMinWidth(300);

        TableColumn emailD = new TableColumn("email");
        emailD.setCellValueFactory(new PropertyValueFactory("emailD"));
        emailD.setMinWidth(200);

        TableColumn date = new TableColumn("date");
        date.setCellValueFactory(new PropertyValueFactory("date"));
        date.setMinWidth(150);

        TableColumn etatD = new TableColumn("etat");
        etatD.setCellValueFactory(new PropertyValueFactory("etat"));
        etatD.setMinWidth(130);

//       etatD.setStyle("-fx-background-color:yellow");
        mesList.setItems(null);
        mesList.getColumns().clear();
        mesList.setItems(data1);
        mesList.getColumns().addAll(Sujet_D, Description_D, emailD, date, etatD);

        mesList.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {//!!!!!!!!!!!!!!!!
            if (newSelection != null) {
                detailsM.setVisible(true);

                RepondReclamation r = (RepondReclamation) mesList.getSelectionModel().getSelectedItem();
                sujetM.setText(r.getSujet());
                descriptionM.setText(r.getDescription());
                dateM.setText(r.getDate().toString());

                emailM.setText(r.getEmailD());
                etatM.setText(r.getEtat());

            }
        });

    }

    public void initialiser3(ObservableList data2) {
        hi.setVisible(false);
        TableColumn action = new TableColumn("action");
        action.setCellValueFactory(new PropertyValueFactory("action"));
        action.setMinWidth(300);

        TableColumn date = new TableColumn("date");
        date.setCellValueFactory(new PropertyValueFactory("date"));
        date.setMinWidth(300);

        his.setItems(null);
        his.getColumns().clear();
        his.setItems(data2);
        his.getColumns().addAll(action, date);
        his.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                hi.setVisible(true);
                Historique h = (Historique) his.getSelectionModel().getSelectedItem();
                ServiceUser us = new ServiceUser();
                User u = us.get(h.getId_user());

                loghis.setText(u.getLogin_user());
                if (u.getIs_agency() == 1) {
                    typehis.setText("Agence");

                } else if (u.getIs_client() == 1) {
                    typehis.setText("Client");
                } else if (u.getIs_admin_user() == 1) {
                    typehis.setText("Admin");
                } else {
                    typehis.setText("Hotel");
                }

                datehis.setText(h.getDate().toString());
                actionhis.setText(h.getAction());

            }
        });

    }

    @FXML
    private void supprimerAction(ActionEvent event) {
        ReclamationService rs = new ReclamationService();
        Reclamation r = (Reclamation) listR.getSelectionModel().selectedItemProperty().getValue();
        rs.deleteRec(r.getId_reclamation());
        HistoriqueService hs = new HistoriqueService();
        Historique h = new Historique("supprimer réclamation", LoginController.id);
        hs.add(h);

        listR.getColumns().clear();
        listR.getItems().clear();
        ObservableList data = FXCollections.observableArrayList();
        List<Reclamation> liste = rs.getAll();
        data.addAll(liste);
        initialiser(data);
        stat2();

    }

    @FXML
    private void rechercheReclamation(KeyEvent event) {
        ReclamationService rs = new ReclamationService();
        ObservableList data = FXCollections.observableArrayList();
        List<Reclamation> liste = rs.getSome(rechbtn.getText());
        data.addAll(liste);
        initialiser(data);
    }

    @FXML
    private void repondAction(ActionEvent event) {
    }

    @FXML
    private void refreshAction(ActionEvent event) {
        listR.getColumns().clear();
        listR.getItems().clear();
        ReclamationService rs = new ReclamationService();
        ObservableList data = FXCollections.observableArrayList();
        List<Reclamation> liste = rs.getAll();
        data.addAll(liste);
        initialiser(data);
    }

    @FXML
    private void supprimer2Action(ActionEvent event) {
        RepondReclamationService rs = new RepondReclamationService();
        RepondReclamation rp = (RepondReclamation) mesList.getSelectionModel().selectedItemProperty().getValue();
        rs.deleteRec(rp.getId());
        HistoriqueService hs = new HistoriqueService();
        Historique h = new Historique("supprimer réponse réclamation", LoginController.result.getId_user());
        hs.add(h);
        mesList.getColumns().clear();
        mesList.getItems().clear();
        ObservableList data = FXCollections.observableArrayList();
        List<RepondReclamation> liste = rs.getAll();
        data.addAll(liste);
        initialiser2(data);
        refrech2Action(event);
        stat();

    }

    @FXML
    private void refrech2Action(ActionEvent event) {

        mesList.getColumns().clear();
        mesList.getItems().clear();
        RepondReclamationService rs = new RepondReclamationService();
        ObservableList data = FXCollections.observableArrayList();
        List<RepondReclamation> liste = rs.getAll();
        data.addAll(liste);
        initialiser2(data);
    }

    @FXML
    private void rechercheRep(KeyEvent event) {
        RepondReclamationService rs = new RepondReclamationService();
        ObservableList data = FXCollections.observableArrayList();
        List<RepondReclamation> liste = rs.getSome(rechMe.getText());
        data.addAll(liste);
        initialiser2(data);
    }

    @FXML
    private void supprimer3Action(ActionEvent event) {
        HistoriqueService rs = new HistoriqueService();
        Historique rp = (Historique) his.getSelectionModel().selectedItemProperty().getValue();
        rs.remove(rp.getId());

        his.getColumns().clear();
        his.getItems().clear();
        ObservableList data = FXCollections.observableArrayList();
        List<Historique> liste = rs.getAll();
        data.addAll(liste);
        initialiser3(data);

    }

    @FXML
    private void refrech3Action(ActionEvent event) {
        his.getColumns().clear();
        his.getItems().clear();
        HistoriqueService rs = new HistoriqueService();
        ObservableList data = FXCollections.observableArrayList();
        List<Historique> liste = rs.getAll();
        data.addAll(liste);
        initialiser3(data);
    }

    @FXML
    private void logoutActionR(ActionEvent event) {

      
        closeScreen();

    }

    private void closeScreen() {

        Stage stage = (Stage) email.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void rechercheHit(KeyEvent event) {
        HistoriqueService rs = new HistoriqueService();
        ObservableList data = FXCollections.observableArrayList();
        List<Historique> liste = rs.getSome(serchhis.getText());
        data.addAll(liste);
        initialiser3(data);
    }

//    @FXML
//    private void refrech3Action(KeyEvent event) {
//    }

}
