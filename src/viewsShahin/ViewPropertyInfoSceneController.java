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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ViewPropertyInfoSceneController implements Initializable {

    @FXML
    private TableView<?> viewPropertyInfoTableView;
    @FXML
    private TableColumn<?, ?> khatiyanNumberColumnId;
    @FXML
    private TableColumn<?, ?> propertyOwnerNameColumnId;
    @FXML
    private TableColumn<?, ?> landAreaColumnId;
    @FXML
    private TableColumn<?, ?> districtColumnId;
    @FXML
    private TableColumn<?, ?> propertySellerNameColumnId;
    @FXML
    private TextField RegionToViewPropertyInfoId;
    @FXML
    private TextField khatiyanIdToViewPropertyInfoId;
    @FXML
    private Button submitButttonToViewPropertyInfoId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backtoDashboradFromViewPropery(ActionEvent event) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("propertyOwnerScene.fxml"));
            Scene someScene = new Scene(root);

            Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            someStage.setScene(someScene);
            someStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
