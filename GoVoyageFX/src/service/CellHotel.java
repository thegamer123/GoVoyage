/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import entite.Hotel;
import entite.Renseignement;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;

/**
 *
 * @author ASUS
 */
public class CellHotel extends ListCell<Hotel>{
    private final GridPane gridPane = new GridPane(); 
    private final ImageView brandIcon = new ImageView(); 
    private final Label brandLabel = new Label(); 
    private final Label modelLabel = new Label(); 
    private final Label idhotel = new Label(); 

    private final Label descriptionLabel = new Label(); 
    private final ImageView volIcon = new ImageView(); 
    private final Hyperlink carte= new Hyperlink();
    private final AnchorPane content = new AnchorPane(); 
     private final Label classe = new Label(); 
     private final Label prix = new Label(); 
     private final Label room= new Label();
  
     public CellHotel() { 
        volIcon.setFitWidth(150); 
        volIcon.setPreserveRatio(true); 
        GridPane.setConstraints(volIcon, 0, 0, 1, 3); 
        GridPane.setValignment(volIcon, VPos.TOP); 
        // 
        modelLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 1.5em;"); 
        GridPane.setConstraints(modelLabel, 1, 0); 
        

        
        idhotel.setStyle(" -fx-font-size: 1.5em;"); 
        idhotel.setVisible(false);
        GridPane.setConstraints(idhotel, 2, 0); 
        
        
        
        // 
        brandLabel.setStyle("-fx-font-size: 0.9em; -fx-font-style: italic; -fx-opacity: 0.5;"); 
        GridPane.setConstraints(brandLabel, 3, 0); 
        
        carte.setStyle("-fx-font-size: 0.9em; -fx-font-style: italic; -fx-opacity: 0.5;"); 
        GridPane.setConstraints(carte, 3, 0); 
        // 
        brandIcon.setFitWidth(22); 
        brandIcon.setPreserveRatio(true); 
        GridPane.setConstraints(brandIcon, 3, 0); 
        GridPane.setValignment(brandIcon, VPos.CENTER); 
 
        GridPane.setConstraints(carte, 3, 0); 
        GridPane.setValignment(carte, VPos.CENTER);  
        
        // 
        //colorRect.setStroke(Color.BLACK); 
        descriptionLabel.setStyle("-fx-opacity: 0.75;"); 
       // descriptionLabel.setGraphic(colorRect); 
        GridPane.setConstraints(descriptionLabel, 1, 1); 
        GridPane.setColumnSpan(descriptionLabel, Integer.MAX_VALUE); 
        
                        
        classe.setStyle(" -fx-opacity: 0.75;"); 
        GridPane.setConstraints(classe, 1, 2); 
        GridPane.setColumnSpan(classe, Integer.MAX_VALUE); 
         prix.setStyle("-fx-font-size: 0.9em; -fx-font-style: italic; -fx-opacity: 0.75;"); 
        GridPane.setConstraints(prix, 2, 2); 
        GridPane.setValignment(prix, VPos.CENTER); 
        
        room.setStyle("-fx-font-size: 0.9em; -fx-font-style: italic; -fx-opacity: 0.5;"); 
        GridPane.setConstraints(room, 3, 1); 
        GridPane.setValignment(room, VPos.CENTER); 
        //         
        gridPane.getColumnConstraints().add(new ColumnConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, HPos.LEFT, true)); 
        gridPane.getColumnConstraints().add(new ColumnConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.ALWAYS, HPos.LEFT, true)); 
        gridPane.getColumnConstraints().add(new ColumnConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, HPos.LEFT, true)); 
        gridPane.getColumnConstraints().add(new ColumnConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, HPos.LEFT, true)); 
        gridPane.getRowConstraints().add(new RowConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, VPos.CENTER, true)); 
        gridPane.getRowConstraints().add(new RowConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, VPos.CENTER, true)); 
        gridPane.getRowConstraints().add(new RowConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.ALWAYS, VPos.CENTER, true)); 
        gridPane.setHgap(6); 
        gridPane.setVgap(6); 
        gridPane.getChildren().setAll(volIcon, modelLabel, brandLabel, brandIcon, descriptionLabel,idhotel,carte,classe,prix,room); 
        AnchorPane.setTopAnchor(gridPane, 0d); 
        AnchorPane.setLeftAnchor(gridPane, 0d); 
        AnchorPane.setBottomAnchor(gridPane, 0d); 
        AnchorPane.setRightAnchor(gridPane, 0d); 
        content.getChildren().add(gridPane); 
    } 


  
  
    protected void updateItem(Hotel item, boolean empty) { 
        super.updateItem(item, empty); 
        setGraphic(null); 
        setText(null); 
        setContentDisplay(ContentDisplay.LEFT); 
       
        if (!empty && item != null) { 
            //brandLabel.setText(String.valueOf(item.getPrix()+"Euro")); 
            idhotel.setText(String.valueOf(item.getId_hotel())); 
            modelLabel.setText("Hotel "+item.getNom_hotel()); 
            String image=item.getNom_hotel();
            System.out.println("image"+image);
            Image img=new Image("/png/"+item.getImg_hotel());
            carte.setText("Show on Map");
            classe.setText(String.format("%d Stars", item.getStars_hotel()));
            prix.setText("Price/night: "+String.valueOf(item.getPrix_hotel())+"€");
         //  brandIcon.setImage(img); 
            volIcon.setImage(img); 
           descriptionLabel.setText(item.getAdresse_hotel()); 
           room.setText(item.getChambre_hotel()+" Room");
 
            setText(null); 
            setGraphic(content); 
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY); 
        } 
    } 
    
}
