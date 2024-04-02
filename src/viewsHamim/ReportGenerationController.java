/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package viewsHamim;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ReportGenerationController implements Initializable {

    @FXML
    private TableView<TaxReport> tableView;
    @FXML
    private TableColumn<TaxReport, String> taxcCodeTableColumn;
    @FXML
    private TableColumn<TaxReport, String> amountTableColumn;
    @FXML
    private TableColumn<TaxReport, LocalDate> dateTableColumn;

    /**
     * Initializes the controller class.
     */
    private ObservableList<TaxReport> ReportList;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ReportList = FXCollections.observableArrayList();
        
        taxcCodeTableColumn.setCellValueFactory(
                new PropertyValueFactory<TaxReport, String>("taxCode")
        );
        amountTableColumn.setCellValueFactory(
                new PropertyValueFactory<TaxReport, String>("amount")
        );
           dateTableColumn.setCellValueFactory(
                new PropertyValueFactory<TaxReport, LocalDate>("date")
                   
        );
           tableView.setItems(ReportList);
    }    

    @FXML
    private void loadBinFileOnClick(ActionEvent event) {
        
         try {
        FileInputStream fileIn = new FileInputStream("TaxReport.bin");
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        
        
        
        while (true) {
            try {
                TaxReport showfrombinfile = (TaxReport) objectIn.readObject();
                ReportList.add(showfrombinfile);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                break; // 
            }
        }
            objectIn.close();
        fileIn.close();
        
        System.out.println("Tax info showing into the Table");
    } catch (IOException e) {
        e.printStackTrace();
            }
         Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText("Loaded Successfully");
        a.setContentText("All Data Showed from the Bin File");
        a.showAndWait();
    }

    @FXML
    private void backToTaxcollectorCopysistDashboard(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("TaxCollectorCopyistDashboard.fxml"));
            Scene someScene = new Scene(root);

            Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            someStage.setScene(someScene);
            someStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void generatepdfOnClick(ActionEvent event) {
    }
    
}
