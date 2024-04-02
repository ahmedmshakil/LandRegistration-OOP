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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ACLandViewLandRecordInDetailsController implements Initializable {
    
    private ACLandAddRecords selectedRow;

    @FXML
    private Label plotNoTextLabel;
    @FXML
    private Label khatianNoTextLabel;
    @FXML
    private Label presentPossessorTextLabel;
    @FXML
    private Label districtTextLabel;
    @FXML
    private Label upazillaTextLabel;
    @FXML
    private Label mouzaTextLabel;
    @FXML
    private Label sizeTextLabel;
    @FXML
    private Label valueTextLabel;
    @FXML
    private Label recordingDateTextLabel;

    /**
     * Initializes the controller class.
     */
    public void initData(ACLandAddRecords p){
        selectedRow = p;
        plotNoTextLabel.setText(selectedRow.getPlotNo());
        khatianNoTextLabel.setText(selectedRow.getKhatianNo());
        presentPossessorTextLabel.setText(selectedRow.getPresentPossessor());
        districtTextLabel.setText(selectedRow.getDistrict());
        upazillaTextLabel.setText(selectedRow.getUpazilla());
        mouzaTextLabel.setText(selectedRow.getMouza());
        sizeTextLabel.setText(selectedRow.getSize());
        valueTextLabel.setText(selectedRow.getValue());
        recordingDateTextLabel.setText(selectedRow.getRecordingDate().toString());
        
        
       
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void returnToLandRecordsButtonOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ACLandViewOrEditRecords.fxml"));
            Scene someScene = new Scene(root);

            Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            someStage.setScene(someScene);
            someStage.show();
    }
    
}
