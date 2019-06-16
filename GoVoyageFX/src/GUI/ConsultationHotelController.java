/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;



import entite.Hotel;
import entite.Renseignement;

import service.Cell;




import service.ServiceHotel;
import service.ServiceRenseigtHotel;
import utils.ConersionDate;
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
import service.CellHotel;


/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ConsultationHotelController implements Initializable {
  ObservableList<String> listStars= FXCollections.observableArrayList("1","2","3","4","5");
    ObservableList<String> listRomms= FXCollections.observableArrayList("1 Room","2 Rooms","3 Rooms","4 Rooms","5 Rooms");
  private ObservableList<Renseignement> listHotel=FXCollections.observableArrayList();

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
    private ListView<Renseignement> listViewHotel;
    @FXML
    private Pane PaneHotel;
    @FXML
    private MenuButton ButStars;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       box_Stars.setValue("Stars");
      box_Stars.setItems(listStars);
      
      box_Room.setValue("Rooms");
      box_Room.setItems(listRomms);
 //     ServiceHotel serviceHotel= new ServiceHotel();
        ServiceRenseigtHotel service=new ServiceRenseigtHotel();
    List<Renseignement> listR=service.readAll();
   for(Renseignement h:listR){
    Renseignement r = new Renseignement();
            int id_hotel= h.getId_hotel();
            String nom_hotel=h.getNom_hotel();
            String adr=h.getAdr_hotel();
            System.out.println("nom_hotel = "+ nom_hotel);
            String img=h.getImg_hotel();
            System.out.println("img = "+ img);
            int nbr_etoile_class=h.getNbr_etoile_class();
            Float prix=h.getPrix();
            String descrip_categorie=h.getDescrip_categorie();
             r.setId_hotel(id_hotel);
             r.setNom_hotel(nom_hotel);
             r.setImg_hotel(img);
             r.setAdr_hotel(adr);
             r.setNbr_etoile_class(nbr_etoile_class);
             r.setPrix(prix);
             r.setDescrip_categorie(descrip_categorie);
            listHotel.add(r);
    
   }
           listViewHotel.setItems(listHotel);
listViewHotel.setCellFactory(new javafx.util.Callback<ListView<Renseignement>, ListCell<Renseignement>>() { 
 
    public ListCell<Renseignement> call(ListView<Renseignement> lv) { 
        return new CellHotel(); 
    } 
});

}
    public void controleSearch(){
    if(fldDestination.getText().equals("") ){
        List<Alert> list=new ArrayList<>();
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("No Selection");
        alert.setHeaderText("No Destination Selected");
        alert.setContentText("Please select a destination in the TextField.");
        list.add(alert);
        alert.showAndWait();
    }   
           else if((date_checkIn.getValue() == null || date_checkIn.getValue().toString().isEmpty())  ){
                       Alert alert1 = new Alert(AlertType.INFORMATION);

            // alert.setTitle("No Selection");
            //alert1.setHeaderText("No city Selected");
            alert1.setContentText(" Please enter a valid date.");
            // list.add( alert1);

            alert1.showAndWait();
       }
           else if((date_checkout.getValue() == null || date_checkout.getValue().toString().isEmpty())  ){
                       Alert alert1 = new Alert(AlertType.INFORMATION);

            // alert.setTitle("No Selection");
            //alert1.setHeaderText("No city Selected");
            alert1.setContentText(" Please enter a valid date.");
            // list.add( alert1);

            alert1.showAndWait();
       }

} 
    @FXML
    public void lireParCritereRecherche(){
                controleSearch(); 
    ConersionDate sr=new ConersionDate();
    int dateIn=sr.convertirDateToInt(date_checkIn);
    int dateOut=sr.convertirDateToInt(date_checkout);
  
     ObservableList<Renseignement> volList=FXCollections .observableArrayList();
                ServiceRenseigtHotel service=new ServiceRenseigtHotel();
    List<Renseignement> listR=service.lireParCritereRecherche(fldDestination.getText(), dateIn, dateOut);
   for(Renseignement h:listR){
    Renseignement r = new Renseignement();
            int id_hotel= h.getId_hotel();
            String nom_hotel=h.getNom_hotel();
            String adr=h.getAdr_hotel();
            System.out.println("nom_hotel = "+ nom_hotel);
            String img=h.getImg_hotel();
            System.out.println("img = "+ img);
            int nbr_etoile_class=h.getNbr_etoile_class();
            Float prix=h.getPrix();
            String descrip_categorie=h.getDescrip_categorie();
             r.setId_hotel(id_hotel);
             r.setNom_hotel(nom_hotel);
             r.setImg_hotel(img);
             r.setAdr_hotel(adr);
             r.setNbr_etoile_class(nbr_etoile_class);
             r.setPrix(prix);
             r.setDescrip_categorie(descrip_categorie);
            volList.add(r);
    
   }
           listViewHotel.setItems(volList);
listViewHotel.setCellFactory(new javafx.util.Callback<ListView<Renseignement>, ListCell<Renseignement>>() { 
 
    public ListCell<Renseignement> call(ListView<Renseignement> lv) { 
        return new CellHotel(); 
    } 
});
}
   @FXML
    public void lireParStars(){
 
     ObservableList<Renseignement> hotlList=FXCollections .observableArrayList();
                ServiceRenseigtHotel service=new ServiceRenseigtHotel();
    List<Renseignement> listR=service.lireParNbStars(Integer.valueOf(box_Stars.getSelectionModel().getSelectedItem()));
   for(Renseignement h:listR){
    Renseignement r = new Renseignement();
            int id_hotel= h.getId_hotel();
            String nom_hotel=h.getNom_hotel();
            String adr=h.getAdr_hotel();
            System.out.println("nom_hotel = "+ nom_hotel);
            String img=h.getImg_hotel();
            System.out.println("img = "+ img);
            int nbr_etoile_class=h.getNbr_etoile_class();
            Float prix=h.getPrix();
            String descrip_categorie=h.getDescrip_categorie();
             r.setId_hotel(id_hotel);
             r.setNom_hotel(nom_hotel);
             r.setImg_hotel(img);
             r.setAdr_hotel(adr);
             r.setNbr_etoile_class(nbr_etoile_class);
             r.setPrix(prix);
             r.setDescrip_categorie(descrip_categorie);
            hotlList.add(r);
    
   }
           listViewHotel.setItems(hotlList);
listViewHotel.setCellFactory(new javafx.util.Callback<ListView<Renseignement>, ListCell<Renseignement>>() { 
 
    public ListCell<Renseignement> call(ListView<Renseignement> lv) { 
        return new CellHotel(); 
    } 
});
}    
    }
