/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package furniturevillas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * mainPagecontroller
 * @author Claire Chemutai Langat
 */
public class mainPageController implements Initializable {
    
    private Label label;
    @FXML
    private AnchorPane mainPageAnchor;
    @FXML
    private Button startBtn;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void startPageAction(ActionEvent event) {
         try{
            Parent root= FXMLLoader.load(getClass().getResource("registrationPage.fxml"));
            Scene scene = new Scene (root);
            Stage stage= (Stage) startBtn.getScene().getWindow();
            stage.setScene(scene);
        }
        catch (IOException e){
        System.out.println(e.toString());
    }
    }
    
}
