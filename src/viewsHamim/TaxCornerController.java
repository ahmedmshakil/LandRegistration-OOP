/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package viewsHamim;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class TaxCornerController implements Initializable {

    @FXML
    private TableColumn<TaxReport, String> taxcCodeTableColumn;
    @FXML
    private TableColumn<TaxReport, String> amountTableColumn;
    @FXML
    private TableColumn<TaxReport, LocalDate> dateTableColumn;
    @FXML
    private TextField taxCodeTextfield;
    @FXML
    private TextField amountTextfield;
    @FXML
    private DatePicker taxCornerDatePicker;

    /**
     * Initializes the controller class.
     */
    private ObservableList<TaxReport> ReportList;
    @FXML
    private TableView<TaxReport> tableView;
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

    private void reportGenerationOnClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ReportGeneration.fxml"));
            Scene someScene = new Scene(root);

            Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            someStage.setScene(someScene);
            someStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
 
}

    @FXML
    private void taxCollectorDashboardOnClick(ActionEvent event) {
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
    private void addTotaxTable(ActionEvent event) {
        String taxCode = taxCodeTextfield.getText();
        String amount = amountTextfield.getText();
        
        
        LocalDate date = taxCornerDatePicker.getValue();
        
        
        TaxReport newReportList = new TaxReport(taxCode, amount , date);
        
        ReportList.add(newReportList);
        
        
        
        //For clear after put the value
        taxCodeTextfield.clear();
        amountTextfield.clear();
        taxCornerDatePicker.setValue(null);
        
    }

    @FXML
    private void saveInfoOnClick(ActionEvent event) {
        
        
        try {
        FileOutputStream fileOut = new FileOutputStream("TaxReport.bin");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        
        
        for (TaxReport savetobinfile : ReportList) {
            objectOut.writeObject(savetobinfile);
        }
        
        objectOut.close();
        fileOut.close();
        
        System.out.println("TaxReport Saved Successfully");
    } catch (IOException e) {
        e.printStackTrace();
    }
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText("Saved Successfully");
        a.setContentText("All Data Saved To The Bin File");
        a.showAndWait();
    }
    
}
