/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package viewsShahin;

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ViewLandRegistrationApplySceneController implements Initializable {

    @FXML
    private TextField mouzaTextField;
    @FXML
    private TextField plotNoTextField;
    @FXML
    private TextField districtTextField;
 
   
    @FXML
    private TextField khatianNoTextField;
    @FXML
    private TextField valueTextField;
    @FXML
    private TextField sizeTextField;
    @FXML
    private TextField presentPossessorTextField;
    @FXML
    private TextField upazillaTextField;
    @FXML
    private DatePicker recordingDatePicker;
    
    private ObservableList<applyLandRegistration> landRecordList;
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        landRecordList = FXCollections.observableArrayList();
    }    

    @FXML
    private void backToProperyBuyerDashboardOnClick(ActionEvent event) {
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
    private void applyForLandRegistrationOnClick(ActionEvent event) {
        String plotNo = plotNoTextField.getText();
        String khatianNo = khatianNoTextField.getText();
        String presentPossessor = presentPossessorTextField.getText();
        String district = districtTextField.getText();
        String upazilla = upazillaTextField.getText();
        String mouza = mouzaTextField.getText();
        String size = sizeTextField.getText();
        String value = valueTextField.getText();
        LocalDate recordingDate = recordingDatePicker.getValue();
        
        
        applyLandRegistration newlandRecordList = new applyLandRegistration(plotNo, khatianNo, presentPossessor, district, upazilla, mouza, size, value, recordingDate);
        
        landRecordList.add(newlandRecordList);
        System.out.println("newlandRecordList");
        
        
        
        
        
        
        
        // code for save application records to the bin file
        
          try {
        FileOutputStream fileOut = new FileOutputStream("applyLandRecords.bin");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        
        
        for (applyLandRegistration savetobinfile : landRecordList) {
            objectOut.writeObject(savetobinfile);
        }
        
        objectOut.close();
        fileOut.close();
        
        System.out.println("Land Record Registered Successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
          
        
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
    }
    
}
