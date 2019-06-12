/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.crypto.NullCipher;

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
    private ScatterChart<Number, Number> reservationScatterChart;
    @FXML
    private BarChart<?, ?> barChart;
    @FXML
    private AreaChart<?, ?> AreaChart;
    @FXML
    private LineChart<?, ?> evolutionLineChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        final NumberAxis xAxis = new NumberAxis(0, 10, 1);
        final NumberAxis yAxis = new NumberAxis(-100, 500, 100);
        reservationScatterChart = new ScatterChart<Number, Number>(xAxis, yAxis);
        
        xAxis.setLabel("Age (years)");
        yAxis.setLabel("Returns to date");
        reservationScatterChart.setTitle("Investment Overview");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Equities");
        series1.getData().add(new XYChart.Data(4.2, 193.2));
        series1.getData().add(new XYChart.Data(2.8, 33.6));
        series1.getData().add(new XYChart.Data(6.2, 24.8));
        series1.getData().add(new XYChart.Data(1, 14));
        series1.getData().add(new XYChart.Data(1.2, 26.4));
        series1.getData().add(new XYChart.Data(4.4, 114.4));
        series1.getData().add(new XYChart.Data(8.5, 323));
        series1.getData().add(new XYChart.Data(6.9, 289.8));
        series1.getData().add(new XYChart.Data(9.9, 287.1));
        series1.getData().add(new XYChart.Data(0.9, -9));
        series1.getData().add(new XYChart.Data(3.2, 150.8));
        series1.getData().add(new XYChart.Data(4.8, 20.8));
        series1.getData().add(new XYChart.Data(7.3, -42.3));
        series1.getData().add(new XYChart.Data(1.8, 81.4));
        series1.getData().add(new XYChart.Data(7.3, 110.3));
        series1.getData().add(new XYChart.Data(2.7, 41.2));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Mutual funds");
        series2.getData().add(new XYChart.Data(5.2, 229.2));
        series2.getData().add(new XYChart.Data(2.4, 37.6));
        series2.getData().add(new XYChart.Data(3.2, 49.8));
        series2.getData().add(new XYChart.Data(1.8, 134));
        series2.getData().add(new XYChart.Data(3.2, 236.2));
        series2.getData().add(new XYChart.Data(7.4, 114.1));
        series2.getData().add(new XYChart.Data(3.5, 323));
        series2.getData().add(new XYChart.Data(9.3, 29.9));
        series2.getData().add(new XYChart.Data(8.1, 287.4));

        reservationScatterChart.getData().addAll(series1, series2);
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
    private void exportToPdfAction(ActionEvent event) {
    }

}
