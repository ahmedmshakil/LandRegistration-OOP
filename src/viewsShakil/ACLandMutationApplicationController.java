/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package viewsShakil;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Shakil
 */
public class ACLandMutationApplicationController implements Initializable {

    @FXML
    private TableView<?> mutationApplicationTableView;
    @FXML
    private TableColumn<?, ?> userIdColumn;
    @FXML
    private TableColumn<?, ?> plotNoColumn;
    @FXML
    private TableColumn<?, ?> khatianNocolumn;
    @FXML
    private TableColumn<?, ?> presentPossessorColumn;
    @FXML
    private TableColumn<?, ?> districtColumn;
    @FXML
    private TableColumn<?, ?> upazillaColumn;
    @FXML
    private TableColumn<?, ?> mouzaColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void declineButtonOnClick(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Information Alert");
        a.setHeaderText("Information isn't Correct");
        a.setContentText("Request declined...");
        a.showAndWait();
        
        
        System.out.println("Your request hase been declined");
    }

    @FXML
    private void approveButtonOnClick(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText("Registration Approved");
        a.setContentText("");
        a.showAndWait();
        
        System.out.println("Congratulation! Your request have been approved ");
    }
    
}
