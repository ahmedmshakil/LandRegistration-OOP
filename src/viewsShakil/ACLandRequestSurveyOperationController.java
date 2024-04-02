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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ACLandRequestSurveyOperationController implements Initializable {

    
    
      //Table View Area
    @FXML private TableView<ACLandRequestSurveyOperation> requestTableView;
    
    @FXML private TableColumn<ACLandRequestSurveyOperation, String> plotNoColumn;
    @FXML private TableColumn<ACLandRequestSurveyOperation, String> khatianNoColumn;
    @FXML private TableColumn<ACLandRequestSurveyOperation, LocalDate> submissionDateColumn;
    
    
      //input Record Data
    @FXML private TextField plotNoTextField;
    @FXML private TextField khatianNoTextField;
    
    
    
    private ObservableList<ACLandRequestSurveyOperation> requestSurveyList;
    @FXML
    private DatePicker submissionDatePicker;
    

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
        
        
        
        //Load registration data into the TableView
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
        }
        
        objectIn.close();
        fileIn.close();
        
        System.out.println("Land Record showing into the Table");
    } catch (IOException e) {
        e.printStackTrace();
    }
        
        
        
    }    

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
        
        
        String plotNo = plotNoTextField.getText();
        String khatianNo = khatianNoTextField.getText();
        LocalDate submissionDate = submissionDatePicker.getValue();
     
        ACLandRequestSurveyOperation newFormRequestList = new ACLandRequestSurveyOperation(plotNo, khatianNo, submissionDate);
        requestSurveyList.add(newFormRequestList);
        
        
        //For clear after put the value
        plotNoTextField.clear();
        khatianNoTextField.clear();
        submissionDatePicker.setValue(null);
        
        
        //save to the bin
        try {
        FileOutputStream fileOut = new FileOutputStream("SurveyRequest.bin");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        
        
        for (ACLandRequestSurveyOperation savetobinfile : requestSurveyList) {
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
        a.setHeaderText("Request Sent Successfully");
        a.setContentText("Surveyor will get the notification to Start Survey");
        a.showAndWait();
        
        
        
    }

    @FXML
    private void returnToDashboardOnClick(ActionEvent event) {
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
    
}
