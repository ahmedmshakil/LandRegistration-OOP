/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package viewsModification;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author Asus
 */
public class RegistryOfficerController implements Initializable {


    @FXML
    private TextField plotIDTextField;
    @FXML
    private TextField sizeTextField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TableView<Modification> tableView;
    @FXML
    private TableColumn<Modification, String> idTableColumn;
    @FXML
    private TableColumn<Modification,String> sizeTableColumn;
    @FXML
    private TableColumn<Modification, LocalDate> dateTableColumn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void addButtonOnClick(ActionEvent event) {
        
        
        
    }

}
