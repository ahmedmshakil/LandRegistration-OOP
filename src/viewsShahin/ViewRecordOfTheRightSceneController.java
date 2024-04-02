/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package viewsShahin;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ViewRecordOfTheRightSceneController implements Initializable {
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
    }    

    @FXML
    private void backToDashboardOnClick(ActionEvent event) {
          try {
            Parent root = FXMLLoader.load(getClass().getResource("propertyBuyerDashboardScene.fxml"));
            Scene someScene = new Scene(root);

            Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            someStage.setScene(someScene);
            someStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @FXML
    private void showRecordOfTheLandsRightOnClick(ActionEvent event) {
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
    
}
