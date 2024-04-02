/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package viewsShakil;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ACLandEditRecordsController implements Initializable {
    private ACLandAddRecords selectedRow;

    @FXML
    private TextField presentPossessorTextField;
    @FXML
    private TextField sizeTextField;
    @FXML
    private TextField valueTextField;
    @FXML
    private Label khatianNoLabel;
    @FXML
    private Label districtLabel;
    @FXML
    private Label upazillaLabel;
    @FXML
    private Label mouzaLabel;
    @FXML
    private Label recordingDateLabel;
    @FXML
    private TextField plotIdTextField;

    /**
     * Initializes the controller class.
     */
    public void initData(ACLandAddRecords p){
        selectedRow = p;
        plotIdTextField.setText(selectedRow.getPlotNo());
        khatianNoLabel.setText(selectedRow.getKhatianNo());
       presentPossessorTextField.setText(selectedRow.getPresentPossessor());
        districtLabel.setText(selectedRow.getDistrict());
        upazillaLabel.setText(selectedRow.getUpazilla());
        mouzaLabel.setText(selectedRow.getMouza());
        sizeTextField.setText(selectedRow.getSize());
        valueTextField.setText(selectedRow.getValue());
        recordingDateLabel.setText(selectedRow.getRecordingDate().toString());
        
    }
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backToLandRecordsButtonOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ACLandViewOrEditRecords.fxml"));
            Scene someScene = new Scene(root);

            Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            someStage.setScene(someScene);
            someStage.show();
    }

    @FXML
    private void saveEditInformationButtonOnClick(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText("Edited successfully");
        a.setContentText("Record Saved to the Land Registration database");
        a.showAndWait();
        
        System.out.println("Edit Information has been recored successfully");
    }
    
}
