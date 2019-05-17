/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import javafx.event.EventHandler;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

    ObservableList<String> listStars = FXCollections.observableArrayList("1 Star", "2 Stars", "3 Stars", "4 Stars", "5 Stars");
    ObservableList<String> listRomms = FXCollections.observableArrayList("1 Room", "2 Rooms", "3 Rooms", "4 Rooms", "5 Rooms");
//  private ObservableList<String> list=FXCollections.observableArrayList();
    private static final ListView<HotelOffer> leftListView = new ListView<HotelOffer>();

    private static final ObservableList<HotelOffer> leftList = FXCollections
            .observableArrayList();
    private static final ObservableList<HotelOffer> rightList = FXCollections
            .observableArrayList();
    private static final ListView<HotelOffer> rightListView = new ListView<HotelOffer>();

    private static final GridPane rootPane = new GridPane();
    
    private ComboBox<String> box_Room;
    @FXML
    private DatePicker date_checkIn;
    @FXML
    private DatePicker date_checkout;

    @FXML
    private Button butSearch;
    @FXML
    private ListView<HotelOffer> listViewHotel;
    @FXML
    private TextField titleTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceHotel serviceHotel = new ServiceHotel();
        List<HotelOffer> list = serviceHotel.readAllOffers();
        listViewHotel.setCellFactory(lv -> new HotelListCell());
        listViewHotel.getItems().addAll(list);
         listViewHotel.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            System.out.println("clicked on " + listViewHotel.getSelectionModel().getSelectedItem());
        }
    });
    }

    @FXML
    public void controleSearch() {
        if (titleTF.getText().equals("")) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Destination Selected");
            alert.setContentText("Please select a destination in the TextField.");
            alert.showAndWait();
        }

    }

    public class HotelListCell extends ListCell<HotelOffer> {

        HBox hbox = new HBox();
        Button btn = new Button("Coding");
        Label label = new Label("");
        Pane pane = new Pane();
        //Image profile = new Image("/image/movenpick.jpg");
        //ImageView img = new ImageView(profile);

        public HotelListCell() {
            super();
            //hbox.getChildren().addAll(btn, label, pane, img);
            hbox.getChildren().addAll(btn, label, pane);
            hbox.setHgrow(pane, Priority.ALWAYS);
        }

        public void updateItem(HotelOffer item, boolean empty) {
            super.updateItem(item, empty);
            setText(null);
            if (!empty && item != null) {
                final String text = String.format("%s", item.getTitre_offre_hotel());
                setText(text);
            }
        }
    }

}
