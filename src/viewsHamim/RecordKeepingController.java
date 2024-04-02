/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package viewsHamim;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
public class RecordKeepingController implements Initializable {

    @FXML
    private TableColumn<Khatiyan, String> khatiyanTableColumn;
    @FXML
    private TableColumn<Khatiyan, String> areaTypeTableColumn;
    @FXML
    private TableColumn<Khatiyan, String> amountInDecimalTableColumn;
    @FXML
    private TableColumn<Khatiyan, LocalDate> dateRecodKeepingTableColumn;
    @FXML
    private DatePicker recordkeepingDatePicker;
    @FXML
    private TextField khatiyanTextFieldId;
    @FXML
    private TextField areaInDecimalTextFieldId;
    @FXML
    private TextField areaTypeTextFieldId;
    @FXML
    private TableView<Khatiyan> tableView;

    /**
     * Initializes the controller class.
     */
    private ObservableList<Khatiyan> KhatiyanList;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     KhatiyanList = FXCollections.observableArrayList();
        
        khatiyanTableColumn.setCellValueFactory(
                new PropertyValueFactory<Khatiyan, String>("Khatiyan")
        );
         areaTypeTableColumn.setCellValueFactory(
                new PropertyValueFactory<Khatiyan, String>("areaType")
        );
          amountInDecimalTableColumn.setCellValueFactory(
                new PropertyValueFactory<Khatiyan, String>("areaAmount")
        );
           dateRecodKeepingTableColumn.setCellValueFactory(
                new PropertyValueFactory<Khatiyan, LocalDate>("khatiyanDate")
                   
        );
           tableView.setItems(KhatiyanList);
        
    }    
   
    



    @FXML
    private void backToCopyistDashboardOnClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("CopyistDashboard.fxml"));
            Scene someScene = new Scene(root);

            Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            someStage.setScene(someScene);
            someStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addInfoToTableOnClick(ActionEvent event) {
String khatiyan = khatiyanTextFieldId.getText();
        String areaType = areaTypeTextFieldId.getText();
        String areaAmount = areaInDecimalTextFieldId.getText();
        
        LocalDate khatiyanDate = recordkeepingDatePicker.getValue();
        
        
        Khatiyan newKhatiyanList = new Khatiyan(khatiyan, areaType, areaAmount, khatiyanDate);
        
        KhatiyanList.add(newKhatiyanList);
        
        
        
        //For clear after put the value
        khatiyanTextFieldId.clear();
        areaTypeTextFieldId.clear();
        areaInDecimalTextFieldId.clear();
        recordkeepingDatePicker.setValue(null);
        
        

    }

    @FXML
    private void saveTableInfoOnClick(ActionEvent event) {

        
        try {
        FileOutputStream fileOut = new FileOutputStream("Khatiyan.bin");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        
        
        for (Khatiyan savetobinfile : KhatiyanList) {
            objectOut.writeObject(savetobinfile);
        }
        
        objectOut.close();
        fileOut.close();
        
        System.out.println("Record File Saved Successfully");
    } catch (IOException e) {
        e.printStackTrace();
    }
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText("Saved Successfully");
        a.setContentText("All Data Saved To The Bin File");
        a.showAndWait();
    }

    @FXML
    private void ShowSavedTableInfoOnClick(ActionEvent event) {

         try {
        FileInputStream fileIn = new FileInputStream("Khatiyan.bin");
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        
        //landRecordList.clear();  //for clearing all save data together
        
        while (true) {
            try {
                Khatiyan showfrombinfile = (Khatiyan) objectIn.readObject();
                KhatiyanList.add(showfrombinfile);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                break; // 
            }
        }
            objectIn.close();
        fileIn.close();
        
        System.out.println("Record showing into the Table");
    } catch (IOException e) {
        e.printStackTrace();
            }
    }
    
}
