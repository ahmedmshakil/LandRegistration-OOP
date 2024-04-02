/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainPackage;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class LoginSceneController implements Initializable {

    @FXML
    private ComboBox<String> loginUserTypeSelectionComboBox;
    @FXML
    private TextField userIdTextField;
    @FXML
    private TextField passwordTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loginUserTypeSelectionComboBox.getItems().addAll(
                "Assistant Commissioner", "Surveyor",
                "Copyist", "Tax Collector",
                "Property Buyer", "Property Owner");
        // TODO
    }    

    @FXML
    private void loginButtonOnClick(ActionEvent event) throws IOException, Exception {
        String userType = loginUserTypeSelectionComboBox.getValue();
        switch(userType){
            case "Assistant Commissioner":
                try {
            Parent scene2Parent = FXMLLoader.load(getClass().getResource("/viewsShakil/AssistantCommissionerDashboard.fxml"));
            Scene someScene = new Scene(scene2Parent);

            Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            someStage.setScene(someScene);
            someStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
            case "Surveyor":
                try {
            Parent scene2Parent = FXMLLoader.load(getClass().getResource("/viewsShakil/SurveyorDashboard.fxml"));
            Scene someScene = new Scene(scene2Parent);

            Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            someStage.setScene(someScene);
            someStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
            case "Copyist":
                try {
            Parent scene2Parent = FXMLLoader.load(getClass().getResource("/viewsHamim/CopyistDashboard.fxml"));
            Scene someScene = new Scene(scene2Parent);

            Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            someStage.setScene(someScene);
            someStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
            case "Tax Collector":
                try {
            Parent scene2Parent = FXMLLoader.load(getClass().getResource("/viewsHamim/TaxCollectorCopyistDashboard.fxml"));
            Scene someScene = new Scene(scene2Parent);

            Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            someStage.setScene(someScene);
            someStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
            case "Property Buyer":
                try {
            Parent scene2Parent = FXMLLoader.load(getClass().getResource("/viewsShahin/propertyBuyerDashboardScene.fxml"));
            Scene someScene = new Scene(scene2Parent);

            Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            someStage.setScene(someScene);
            someStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
            case "Property Owner":
                try {
            Parent scene2Parent = FXMLLoader.load(getClass().getResource("/viewsShahin/propertyOwnerScene.fxml"));
            Scene someScene = new Scene(scene2Parent);

            Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            someStage.setScene(someScene);
            someStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
                
                
                
        
        
        }//UserType
   
    }//Login Button
    
}//MainClass
