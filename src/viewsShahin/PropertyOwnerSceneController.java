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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class PropertyOwnerSceneController implements Initializable {

    @FXML
    private Button viewPropertyInfoId;
    @FXML
    private Button verifyOwnershipStatusId;
    @FXML
    private Button uploadPropertyDocumentsId;
    @FXML
    private Button propertyInsuranceId;
    @FXML
    private Button viewAndDownloadTaxInfoId;
    @FXML
    private Button downloadPropertyCertificateId;
    @FXML
    private Button accountSettingId;
    @FXML
    private Button customerSupportId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void viewPropertyInfoOnClick(ActionEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("viewPropertyInfoScene.fxml"));
            Scene someScene = new Scene(root);

            Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            someStage.setScene(someScene);
            someStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void verifyOwnershipStatusOnClick(ActionEvent event) {
    }

    @FXML
    private void UploadPropertyDocumentsOnClick(ActionEvent event) {
    }

    @FXML
    private void uploadPropertyDocumentsOnClick(ActionEvent event) {
    }

    @FXML
    private void propertyInsuranceOnClick(ActionEvent event) {
    }


    @FXML
    private void viewAndDownloadPropertyTaxInformationOnClick(ActionEvent event) {
    }

    @FXML
    private void downloadPropertyCertificateOnClick(ActionEvent event) {
    }

    @FXML
    private void customerSupportOnClick(ActionEvent event) {
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
