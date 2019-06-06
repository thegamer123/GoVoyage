/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Renseignement;
import entite.Vol;
import service.Cell;
import service.CellHotel;

import service.ServiceRenseigtHotel;
import com.GoVoyage.utiles.ConersionDate;
import entite.Hotel;
import entite.HotelOffer;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javax.security.auth.callback.Callback;
import service.ServiceHotel;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ConsultationHotelController implements Initializable {

    ObservableList<String> listStars = FXCollections.observableArrayList("1", "2", "3", "4", "5");
    ObservableList<String> listRomms = FXCollections.observableArrayList("1 Room", "2 Rooms", "3 Rooms", "4 Rooms", "5 Rooms");
    ObservableList<Hotel> listHotel = FXCollections.observableArrayList();
    @FXML
    public TextField fldDestination;
    @FXML
    private ComboBox<String> box_Room;
    @FXML
    private DatePicker date_checkIn;
    @FXML
    private DatePicker date_checkout;
    @FXML
    private ComboBox<String> box_Stars;
    @FXML
    private Button butSearch;

    @FXML
    private ListView<Hotel> listViewHotel;
    @FXML
    private Pane PaneHotel;
    @FXML
    private MenuButton ButStars;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // box_Stars.setValue("Stars");
        // box_Stars.setItems(listStars);

        //  box_Room.setValue("Rooms");
        //  box_Room.setItems(listRomms);
        ServiceHotel service = new ServiceHotel();
        List<Hotel> listR = service.readAll();

        /*  for (Hotel h : listR) {
            Hotel r = new Hotel();
            int id_hotel = h.getId_hotel();
            String nom_hotel = h.getNom_hotel();
            String adr = h.getAdresse_hotel();
            System.out.println("nom_hotel = " + nom_hotel);
            String img = h.getImg_hotel();
            System.out.println("img = " + img);
            int nbr_etoile_class = Integer.valueOf(h.getStars_hotel());
            String prix = h.getPrix_hotel();
            //String descrip_categorie = h.getDescrip_categorie();
            r.setId_hotel(id_hotel);
            r.setNom_hotel(nom_hotel);
            r.setImg_hotel(img);
            r.setAdresse_hotel(adr);
            r.setStars_hotel(String.valueOf(nbr_etoile_class));
            r.setPrix_hotel(prix);
            //r.setDescrip_categorie(descrip_categorie);
            listHotel.add(r);

        }
        listViewHotel.setItems(listHotel);
        listViewHotel.setCellFactory(new javafx.util.Callback<ListView<Hotel>, ListCell<Hotel>>() {

            public ListCell<Hotel> call(ListView<Hotel> lv) {
                return new CellHotel();
            }
        });/*

    }

    public void controleSearch() {
        if (fldDestination.getText().equals("")) {
            List<Alert> list = new ArrayList<>();
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Destination Selected");
            alert.setContentText("Please select a destination in the TextField.");
            list.add(alert);
            alert.showAndWait();
        }

    }

    @FXML
    public void lireParCritereRecherche() {
        ConersionDate sr = new ConersionDate();
        int dateIn = sr.convertirDateToString(date_checkIn);
        int dateOut = sr.convertirDateToString(date_checkout);

        controleSearch();
        ObservableList<Hotel> volList = FXCollections.observableArrayList();
        ServiceRenseigtHotel service = new ServiceRenseigtHotel();
        // List<Hotel> listR = service.lireParCritereRecherche(fldDestination.getText(), dateIn, dateOut);
        /*for (Hotel h : listR) {
            Hotel r = new Hotel();
            int id_hotel = h.getId_hotel();
            String nom_hotel = h.getNom_hotel();
            String adr = h.getAdresse_hotel();
            System.out.println("nom_hotel = " + nom_hotel);
            String img = h.getImg_hotel();
            System.out.println("img = " + img);
            int nbr_etoile_class = Integer.valueOf(h.getStars_hotel());
            String prix = h.getPrix_hotel();
            //String descrip_categorie = h.getDescrip_categorie();
            r.setId_hotel(id_hotel);
            r.setNom_hotel(nom_hotel);
            r.setImg_hotel(img);
            r.setAdresse_hotel(adr);
            r.setStars_hotel(String.valueOf(nbr_etoile_class));
            r.setPrix_hotel(prix);
            //r.setDescrip_categorie(descrip_categorie);
            listHotel.add(r);

        }*/
 /*  listViewHotel.setItems(volList);
        listViewHotel.setCellFactory(new javafx.util.Callback<ListView<Hotel>, ListCell<Hotel>>() {

            public ListCell<Hotel> call(ListView<Hotel> lv) {
                return new CellHotel();
            }
        });/*
    }

    @FXML
    public void lireParStars() {

        ObservableList<Hotel> hotlList = FXCollections.observableArrayList();
        ServiceRenseigtHotel service = new ServiceRenseigtHotel();
        List<Hotel> listR = service.lireParNbStars(Integer.valueOf(box_Stars.getSelectionModel().getSelectedItem()));
        for (Hotel h : listR) {
            Hotel r = new Hotel();
            int id_hotel = h.getId_hotel();
            String nom_hotel = h.getNom_hotel();
            String adr = h.getAdresse_hotel();
            System.out.println("nom_hotel = " + nom_hotel);
            String img = h.getImg_hotel();
            System.out.println("img = " + img);
            int nbr_etoile_class = Integer.valueOf(h.getStars_hotel());
            String prix = h.getPrix_hotel();
            //String descrip_categorie = h.getDescrip_categorie();
            r.setId_hotel(id_hotel);
            r.setNom_hotel(nom_hotel);
            r.setImg_hotel(img);
            r.setAdresse_hotel(adr);
            r.setStars_hotel(String.valueOf(nbr_etoile_class));
            r.setPrix_hotel(prix);
            //r.setDescrip_categorie(descrip_categorie);
            listHotel.add(r);

        }
       /* listViewHotel.setItems(hotlList);
        listViewHotel.setCellFactory(new javafx.util.Callback<ListView<Hotel>, ListCell<Hotel>>() {

            public ListCell<Hotel> call(ListView<Hotel> lv) {
                return new CellHotel();
            }
        });*/
    }
}
