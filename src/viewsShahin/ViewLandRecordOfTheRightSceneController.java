/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package viewsShahin;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ViewLandRecordOfTheRightSceneController implements Initializable {

    @FXML
    private TextField khatianNoTextField;
    @FXML
    private TextField mouzaTextField;
    @FXML
    private TableView<?> recordRightsTableView;
    @FXML
    private TableColumn<?, ?> khatianNoColumn;
    @FXML
    private TableColumn<?, ?> plotNoColumn;
    @FXML
    private TableColumn<?, ?> districtColumn;
    @FXML
    private TableColumn<?, ?> upazillaColumn;
    @FXML
    private TableColumn<?, ?> mouzaColumn;
    @FXML
    private TableColumn<?, ?> sizeColumn;
    @FXML
    private TableColumn<?, ?> valueColumn;
    @FXML
    private TableColumn<?, ?> presentPossessorColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitOnClick(ActionEvent event) {
        try {
        FileInputStream fileIn = new FileInputStream("LandRecords.bin");
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        
        //landRecordList.clear();  //for clearing all save data together
        
        while (true) {
            try {
                ACLandAddRecords showfrombinfile = (ACLandAddRecords) objectIn.readObject();
                //landRecordList.add(showfrombinfile);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                break; // 
            }
        }
        
        objectIn.close();
        fileIn.close();
        
        
    } catch (IOException e) {
        e.printStackTrace();
    }
        
        
    }

    }
    

