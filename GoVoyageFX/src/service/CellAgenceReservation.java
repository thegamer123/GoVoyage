/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import GUI.Utility;
import Interface.DeleteInterface;
import entite.AgenceReservationFullModel;
import entite.VolReservation;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
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
 * @author Lenovo
 */
public class CellAgenceReservation extends ListCell<AgenceReservationFullModel> {

    private final GridPane gridPane = new GridPane();
    private final ImageView brandIcon = new ImageView();
    private final Label brandLabel = new Label();
    private final Label modelLabel = new Label();
    private final Label idhotel = new Label();

    private final Label descriptionLabel = new Label();
    private final ImageView volIcon = new ImageView();
    private final Hyperlink carte = new Hyperlink();
    private final AnchorPane content = new AnchorPane();
    private final Label classe = new Label();
    private final Label prix = new Label();
    private final Label room = new Label();
    private final Label dateDebut = new Label();
    private final Label dateFin = new Label();
    DeleteInterface callback;

    public CellAgenceReservation(DeleteInterface callback) {

        this.callback = callback;
        volIcon.setFitWidth(150);
        volIcon.setPreserveRatio(true);
        GridPane.setConstraints(volIcon, 0, 0, 1, 3);
        GridPane.setValignment(volIcon, VPos.CENTER);
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

        dateDebut.setStyle("-fx-font-size: 0.9em; -fx-font-style: italic; -fx-opacity: 0.5;");
        GridPane.setConstraints(dateDebut, 1, 3);
        GridPane.setValignment(dateDebut, VPos.CENTER);

        dateFin.setStyle("-fx-font-size: 0.9em; -fx-font-style: italic; -fx-opacity: 0.5;");
        GridPane.setConstraints(dateFin, 2, 3);
        GridPane.setValignment(dateFin, VPos.CENTER);
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
        gridPane.getChildren().setAll(volIcon, modelLabel, brandLabel, brandIcon, descriptionLabel, idhotel, carte, classe, prix, room, dateDebut, dateFin);
        AnchorPane.setTopAnchor(gridPane, 0d);
        AnchorPane.setLeftAnchor(gridPane, 0d);
        AnchorPane.setBottomAnchor(gridPane, 0d);
        AnchorPane.setRightAnchor(gridPane, 0d);
        content.getChildren().add(gridPane);
    }

    protected void updateItem(AgenceReservationFullModel item, boolean empty) {
        super.updateItem(item, empty);
        setGraphic(null);
        setText(null);
        setContentDisplay(ContentDisplay.LEFT);

        if (!empty && item != null) {
            //brandLabel.setText(String.valueOf(item.getPrix()+"Euro")); 
            idhotel.setText(String.valueOf(item.getId_vol()));
            modelLabel.setText("de : " + item.getOrigine() + " à :" + item.getDestination());
            Image img = new Image(Utility.path + "Vol.png");
            carte.setText("Annuler");
            carte.setOnAction(e -> {
                callback.Supprimer(String.valueOf(item.getId_vol_reservation()));
            });

            prix.setText("Prix: " + String.valueOf(item.getPrix()) + "€");
            //  brandIcon.setImage(img); 
            volIcon.setImage(img);
            descriptionLabel.setText("Prénom :" + item.getPrenom_user()
                    + "\n Nom :" + item.getNom_user()
                    + "\n Email :" + item.getEmail_user());
            room.setText("Nombre d'escale: " + item.getNb_escale());
            dateDebut.setText("Heure départ : " + item.getHeure_dapart_hotel_reservation());
            dateFin.setText("Heure arrivée: " + item.getHeure_arrivee_hotel_reservation());

            setText(null);
            setGraphic(content);
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        }
    }

}
