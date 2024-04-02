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
import java.time.Month;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class BalamBookController implements Initializable {

    @FXML
    private TableColumn<BalamBook, String> pageNoTableColumn;
    @FXML
    private TableColumn<BalamBook, String> areaTypeTableColumn;
    @FXML
    private TableColumn<BalamBook, String> detailsTableColumn;
    @FXML
    private TableColumn<BalamBook, LocalDate> dateBalamBookTableColumn;
    @FXML
    private DatePicker balamBookDatePicker;
    @FXML
    private TextField pageNoTextFieldId;
    @FXML
    private TextArea detailsTextAreaId;
    @FXML
    private TextField areaTypeTextFieldId;
    @FXML
    private TableView<BalamBook> tableView;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    private ObservableList<BalamBook> BalamBookList;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BalamBookList = FXCollections.observableArrayList();
        
        pageNoTableColumn.setCellValueFactory(
                new PropertyValueFactory<BalamBook, String>("pageNo")
        );
         areaTypeTableColumn.setCellValueFactory(
                new PropertyValueFactory<BalamBook, String>("areaType")
        );
          detailsTableColumn.setCellValueFactory(
                new PropertyValueFactory<BalamBook, String>("details")
        );
           dateBalamBookTableColumn.setCellValueFactory(
                new PropertyValueFactory<BalamBook, LocalDate>("balamBookDate")
                   
        );
           tableView.setItems(BalamBookList);
        
    }    


    @FXML
    private void backToCopuistDashboardOnClick(ActionEvent event) {
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
        String pageNo = pageNoTextFieldId.getText();
        String areaType = areaTypeTextFieldId.getText();
        String details = detailsTextAreaId.getText();
        
        LocalDate balamBookDate = balamBookDatePicker.getValue();
        
        
        BalamBook newBalamBookList = new BalamBook(pageNo, areaType, details, balamBookDate);
        
        BalamBookList.add(newBalamBookList);
        
        
        
        //For clear after put the value
        pageNoTextFieldId.clear();
        areaTypeTextFieldId.clear();
        detailsTextAreaId.clear();
        balamBookDatePicker.setValue(null);
        
        
    }

    @FXML
    private void saveTableInfoOnClick(ActionEvent event) {
        
        try {
        FileOutputStream fileOut = new FileOutputStream("BalamBookFile.bin");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        
        
        for (BalamBook savetobinfile : BalamBookList) {
            objectOut.writeObject(savetobinfile);
        }
        
        objectOut.close();
        fileOut.close();
        
        System.out.println("Balam Book File Saved Successfully");
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
        FileInputStream fileIn = new FileInputStream("BalamBookFile.bin");
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        
        //landRecordList.clear();  //for clearing all save data together
        
        while (true) {
            try {
                BalamBook showfrombinfile = (BalamBook) objectIn.readObject();
                BalamBookList.add(showfrombinfile);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                break; // 
            }
        }
            objectIn.close();
        fileIn.close();
        
        System.out.println("Land Record showing into the Table");
    } catch (IOException e) {
        e.printStackTrace();
            }
         Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText("Load Successfully");
        a.setContentText("All Data Showed from the Bin File");
        a.showAndWait();
    }

    @FXML
    private void goToBalamBookPageOnClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("BalamBookPage.fxml"));
            Scene someScene = new Scene(root);

            Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            someStage.setScene(someScene);
            someStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
