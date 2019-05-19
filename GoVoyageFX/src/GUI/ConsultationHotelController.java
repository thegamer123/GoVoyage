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
import java.util.stream.Collectors;
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
import javafx.stage.WindowEvent;
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
    List<HotelOffer> list;
    List<HotelOffer> filtered;
    ServiceHotel serviceHotel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        serviceHotel = new ServiceHotel();
        list = serviceHotel.readAllOffers();
        listViewHotel.setCellFactory(lv -> new HotelListCell());
        listViewHotel.getItems().addAll(list);
        listViewHotel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("clicked on " + listViewHotel.getSelectionModel().getSelectedItem());
                openInNewWindow(listViewHotel.getSelectionModel().getSelectedItem());
            }
        });
    }

    @FXML
    public void controleSearch() {
        if (titleTF.getText().equals("")) {
            listViewHotel.getItems().clear();
            listViewHotel.getItems().addAll(list);
        } else {
            filtered = list.stream().filter(item -> item.getTitre_offre_hotel().contains(titleTF.getText())).collect(Collectors.toList());
            listViewHotel.getItems().clear();
            listViewHotel.getItems().addAll(filtered);
        }

    }

    @FXML
    private void backButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/HotelHomeScreen.fxml"));
        Scene scene = new Scene(root);
        Scene currentScene = butSearch.getScene();
        Stage primStage = (Stage) currentScene.getWindow();
        primStage.setScene(scene);

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

    private void openInNewWindow(HotelOffer offer) {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("GUI/HotelOfferDetailScreen.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            HotelOfferDetailScreenController controller = loader.getController();
            controller.setHotelOfferData(offer);
            Stage primStage = new Stage();
            primStage.setTitle("Détail offre");
            primStage.setScene(scene);
            primStage.show();
            primStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                public void handle(WindowEvent we) {
                    System.out.println("Stage is closing");
                    list = serviceHotel.readAllOffers();
                    if (titleTF.getText().equals("")) {
                        listViewHotel.getItems().clear();
                        listViewHotel.getItems().addAll(list);
                    } else {
                        filtered = list.stream().filter(item -> item.getTitre_offre_hotel().contains(titleTF.getText())).collect(Collectors.toList());
                        listViewHotel.getItems().clear();
                        listViewHotel.getItems().addAll(filtered);
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
