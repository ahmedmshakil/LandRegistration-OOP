/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package viewsHamim;

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
 * @author ASUS
 */
public class BalamBookPageController implements Initializable {

    @FXML
    private TableView<BalamBook> tableView;
 @FXML
    private TableColumn<BalamBook, String> pageNoTableColumn;
    @FXML
    private TableColumn<BalamBook, String> areaTypeTableColumn;
    @FXML
    private TableColumn<BalamBook, String> detailsTableColumn;
    @FXML
    private TableColumn<BalamBook, LocalDate> dateBalamBookTableColumn;

    /**
     * Initializes the controller class.
     */
    private ObservableList<BalamBook> BalamBookList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        BalamBookList = FXCollections.observableArrayList();
        
        pageNoTableColumn.setCellValueFactory(
                new PropertyValueFactory<BalamBook, String>("pageNo")
        );
         areaTypeTableColumn.setCellValueFactory(
                new PropertyValueFactory<BalamBook, String>("areaType")
        );
          detailsTableColumn.setCellValueFactory(
                new PropertyValueFactory<BalamBook, String>("details")
        );
           dateBalamBookTableColumn.setCellValueFactory(
                new PropertyValueFactory<BalamBook, LocalDate>("balamBookDate")
                   
        );
           tableView.setItems(BalamBookList);
        
        // TODO
    }    

    @FXML
    private void backToBalamBook(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("BalamBook.fxml"));
            Scene someScene = new Scene(root);

            Stage someStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            someStage.setScene(someScene);
            someStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteButtonOnClick(ActionEvent event) {
        
        BalamBook selectedLandRecord = tableView.getSelectionModel().getSelectedItem();
        if (selectedLandRecord != null){
            BalamBookList.remove(selectedLandRecord);
        }
    }

    @FXML
    private void editButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void ShowSavedTableInfoOnClick(ActionEvent event) {
        
        
         try {
        FileInputStream fileIn = new FileInputStream("BalamBookFile.bin");
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        
        //landRecordList.clear();  //for clearing all save data together
        
        while (true) {
            try {
                BalamBook showfrombinfile = (BalamBook) objectIn.readObject();
                BalamBookList.add(showfrombinfile);
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
    
}
