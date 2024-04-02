/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package viewsShakil;

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
public class SurveyorConductSurveyController implements Initializable {

    @FXML private TableView<ACLandRequestSurveyOperation> requestTableView;
    
    @FXML private TableColumn<ACLandRequestSurveyOperation, String> plotNoColumn;
    @FXML private TableColumn<ACLandRequestSurveyOperation, String> khatianNoColumn;
    @FXML private TableColumn<ACLandRequestSurveyOperation, LocalDate> submissionDateColumn;

    
    private ObservableList<ACLandRequestSurveyOperation> requestSurveyList;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        requestSurveyList = FXCollections.observableArrayList();
        // TODO
        
        plotNoColumn.setCellValueFactory(new PropertyValueFactory<ACLandRequestSurveyOperation, String>("plotNo"));
        khatianNoColumn.setCellValueFactory(new PropertyValueFactory<ACLandRequestSurveyOperation, String>("khatianNo"));
        submissionDateColumn.setCellValueFactory(new PropertyValueFactory<ACLandRequestSurveyOperation, LocalDate>("submissionDate"));
        
        requestTableView.setItems(requestSurveyList);
        
        
        
        
        try {
        FileInputStream fileIn = new FileInputStream("SurveyRequest.bin");
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        
        //landRecordList.clear();  //for clearing all save data together
        
        while (true) {
            try {
                ACLandRequestSurveyOperation showfrombinfile = (ACLandRequestSurveyOperation) objectIn.readObject();
                requestSurveyList.add(showfrombinfile);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                break; // 
            }
        System.out.println("Successfully Load the Request Form");
        }
        
        objectIn.close();
        fileIn.close();
        
        
    } catch (IOException e) {
        e.printStackTrace();
    }
        
        
  
        
        
    }  
    
    
    
    
    
    
    
    
    

    @FXML
    private void returnToDashboardOnClick(ActionEvent event) {
      try {
            Parent root = FXMLLoader.load(getClass().getResource("SurveyorDashboard.fxml"));
            Scene someScene = new Scene(root);

            Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            someStage.setScene(someScene);
            someStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }  
        
    }
    
}
