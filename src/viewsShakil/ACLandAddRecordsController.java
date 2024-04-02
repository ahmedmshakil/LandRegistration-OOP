/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package viewsShakil;

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
 * @author Shakil
 */
public class ACLandAddRecordsController implements Initializable {


    
        //Table Area
    @FXML private TableView<ACLandAddRecords> landTableView;
    
    @FXML private TableColumn<ACLandAddRecords, String> plotNoColumn;
    @FXML private TableColumn<ACLandAddRecords, String> khatianNoColumn;
    @FXML private TableColumn<ACLandAddRecords, String> presentPossessorColumn;
    @FXML private TableColumn<ACLandAddRecords, String> districtColumn;
    @FXML private TableColumn<ACLandAddRecords, String> upazillaColumn;
    @FXML private TableColumn<ACLandAddRecords, String> mouzaColumn;
    @FXML private TableColumn<ACLandAddRecords, String> sizeColumn;
    @FXML private TableColumn<ACLandAddRecords, String> valueColumn;
    @FXML private TableColumn<ACLandAddRecords, LocalDate> recordingDateColumn;
    
    
    
         //input Record Data
    @FXML private TextField plotNoTextField;
    @FXML private TextField khatianNoTextField;
    @FXML private TextField presentPossessorTextField;
    @FXML private TextField districtTextField;
    @FXML private TextField upazillaTextField;
    @FXML private TextField mouzaTextField;
    @FXML private TextField valueTextField;
    @FXML private TextField sizeTextField;
    @FXML private DatePicker recordingDatePicker;
    
    
    private ObservableList<ACLandAddRecords> landRecordList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        landRecordList = FXCollections.observableArrayList();
        // TODO
        
        plotNoColumn.setCellValueFactory(new PropertyValueFactory<ACLandAddRecords, String>("plotNo"));
        khatianNoColumn.setCellValueFactory(new PropertyValueFactory<ACLandAddRecords, String>("khatianNo"));
        presentPossessorColumn.setCellValueFactory(new PropertyValueFactory<ACLandAddRecords, String>("presentPossessor"));
        districtColumn.setCellValueFactory(new PropertyValueFactory<ACLandAddRecords, String>("district"));
        upazillaColumn.setCellValueFactory(new PropertyValueFactory<ACLandAddRecords, String>("upazilla"));
        mouzaColumn.setCellValueFactory(new PropertyValueFactory<ACLandAddRecords, String>("mouza"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<ACLandAddRecords, String>("size"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<ACLandAddRecords, String>("value"));
        recordingDateColumn.setCellValueFactory(new PropertyValueFactory<ACLandAddRecords, LocalDate>("recordingDate"));
        
        
        
        
        landTableView.setItems(landRecordList);
        
        //Load registration data into the TableView
        try {
        FileInputStream fileIn = new FileInputStream("LandRecords.bin");
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        
        //landRecordList.clear();  //for clearing all save data together
        
        while (true) {
            try {
                ACLandAddRecords showfrombinfile = (ACLandAddRecords) objectIn.readObject();
                landRecordList.add(showfrombinfile);
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
  
             
        
    }    

   
    
    //Button Handler Method
    
    
    @FXML
    private void addRecordButtonOnClick(ActionEvent event) {
        String plotNo = plotNoTextField.getText();
        String khatianNo = khatianNoTextField.getText();
        String presentPossessor = presentPossessorTextField.getText();
        String district = districtTextField.getText();
        String upazilla = upazillaTextField.getText();
        String mouza = mouzaTextField.getText();
        String size = sizeTextField.getText();
        String value = valueTextField.getText();
        LocalDate recordingDate = recordingDatePicker.getValue();
        
        
        ACLandAddRecords newlandRecordList = new ACLandAddRecords(plotNo, khatianNo, presentPossessor, district, upazilla, mouza, size, value, recordingDate);
        
        landRecordList.add(newlandRecordList);
        
        
        
        //For clear after put the value
        plotNoTextField.clear();
        khatianNoTextField.clear();
        presentPossessorTextField.clear();
        districtTextField.clear();
        upazillaTextField.clear();
        mouzaTextField.clear();
        sizeTextField.clear();
        valueTextField.clear();
        recordingDatePicker.setValue(null);
        
        
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle("Warning Alert");
        a.setContentText("Must Click **Register Record** Button to Save the data into the Registration Database ");
        a.setHeaderText(null);
        a.showAndWait();
        
        
        
    }

    
    
    
    
    @FXML
    private void returnToDashboardButtonOnClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AssistantCommissionerDashboard.fxml"));
            Scene someScene = new Scene(root);

            Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            someStage.setScene(someScene);
            someStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

 
    
    @FXML
    private void saveRecordButtonOnclick(ActionEvent event) {
        try {
        FileOutputStream fileOut = new FileOutputStream("LandRecords.bin");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        
        
        for (ACLandAddRecords savetobinfile : landRecordList) {
            objectOut.writeObject(savetobinfile);
        }
        
        objectOut.close();
        fileOut.close();
        
        System.out.println("Land Record Registered Successfully");
    } catch (IOException e) {
        e.printStackTrace();
    }
        
        
        
        
        //Alart massege showing
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText("Registration Saved Successfully");
        a.setContentText("its already written into the Land Registration Database, You can see it form the View Land Registration Dashboard");
        a.showAndWait();
        
        System.out.println("Congratulation! Your request have been approved ");
        
         
    }
    
    
    @FXML
    private void deleteRecordButtonOnClick(ActionEvent event) {
        ACLandAddRecords selectedLandRecord = landTableView.getSelectionModel().getSelectedItem();
        if (selectedLandRecord != null){
            landRecordList.remove(selectedLandRecord);
        }
        try {
        FileOutputStream fileOut = new FileOutputStream("LandRecords.bin");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        
        
        for (ACLandAddRecords savetobinfile : landRecordList) {
            objectOut.writeObject(savetobinfile);
        }
        
        objectOut.close();
        fileOut.close();
        
        System.out.println("Land Record Registered Successfully");
    } catch (IOException e) {
        e.printStackTrace();
    }
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText("Don't Worry");
        a.setContentText("Wrong Information deleted and its not written into the Land Registration Database");
        a.showAndWait();
        
        
    }
 
    
    
    
}
