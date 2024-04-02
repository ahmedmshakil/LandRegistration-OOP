/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package viewsShahin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class PropertyBuyerDashboardSceneController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void viewChangeOwnershipRecordOnClick(ActionEvent event) {
    }

    @FXML
    private void nonIncomeRangeCertificate(ActionEvent event) {
    }

    @FXML
    private void landMutationRecord(ActionEvent event) {
    }

    @FXML
    private void viewLandRecordOfTheRightOnClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("viewRecordOfTheRightScene.fxml"));
            Scene someScene = new Scene(root);

            Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            someStage.setScene(someScene);
            someStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
    }

    @FXML
    private void applyForChangeOwnershipOnClick(ActionEvent event) {
    }

    @FXML
    private void payStampDutyOnClick(ActionEvent event) {
    }

    @FXML
    private void statusOfPaymentOnClick(ActionEvent event) {
    }

    @FXML
    private void landRegistrationOnClick(ActionEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("viewLandRegistrationApplyScene.fxml"));
            Scene someScene = new Scene(root);

            Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            someStage.setScene(someScene);
            someStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void logOutButtonOnClick(ActionEvent event) {
        try {
            Parent scene2Parent = FXMLLoader.load(getClass().getResource("/mainPackage/LoginScene.fxml"));
            Scene someScene = new Scene(scene2Parent);

            Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            someStage.setScene(someScene);
            someStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
