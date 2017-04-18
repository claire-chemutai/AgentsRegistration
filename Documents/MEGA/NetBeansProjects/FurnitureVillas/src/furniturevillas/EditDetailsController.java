/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package furniturevillas;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author study
 */
public class EditDetailsController implements Initializable {

    @FXML
    private AnchorPane addNEditAnchor;
    @FXML
    private Pane addNeditPane;
    @FXML
    private Button DoneEditDetailBtn;
    @FXML
    private Button cancelEditBtn;
    @FXML
    private TextField editDurationField;
    @FXML
    private Button doneEditBtn;
    @FXML
    private TextField editNameID;
    @FXML
    private TextField editPhoneID;
    @FXML
    private TextField editAdressID;
    @FXML
    private TextField editQuantityID;
    @FXML
    private ComboBox<String> editItemID;
    
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDate localDate = LocalDate.now();
    
    java.sql.Connection conn = null;
    
    TableClass tableDetails ;
    
    ChairsClass chairDetails;
    CanopiesClass canopyDetails;
    
    private Person personDetails;
    private Stage thisStage;
    private boolean isNew;
    
    float chairCost=25;
    float tableCost=40;
    float canopyCost=100;
    float cost;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("I WANT TO EDIT USER INFO NOW!!");
        editItemID.getItems().removeAll(editItemID.getItems());
        editItemID.getItems().addAll("CHAIRS", "TABLES", "CANOPIES");
        
        java.sql.Connection conn = null;
        System.out.println("Connecting...");
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = java.sql.DriverManager.getConnection(
                    "jdbc:mysql://localhost/furniture?user=root&password=root");
        }
        catch (ClassNotFoundException | IllegalAccessException |
                InstantiationException | SQLException e) {
            System.err.println(e);
            System.exit(0);
        }
        System.out.println("Connection established");
        System.out.println(dtf.format(localDate)); 
       
     
    }    

    @FXML
    private Person doneEditDetailsAction(ActionEvent event) {
                int days=Integer.parseInt(editDurationField.getText());
        
        System.out.println("STARTED ADDING USER INFO NOW!!");
        
     
      try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = java.sql.DriverManager.getConnection(
                    "jdbc:mysql://localhost/furniture?user=root&password=root");
        }
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.err.println(e);
            System.exit(0);
        }

       
       
        System.out.println("CREATING A PERSON!!");
        
        try{
            if (editItemID.getValue().equalsIgnoreCase("TABLES")){
                cost=tableCost;
            }
            else if (editItemID.getValue().equalsIgnoreCase("CHAIRS")){
                cost=chairCost;
            }
            else if (editItemID.getValue().equalsIgnoreCase("CANOPIES")){
                cost=canopyCost;
            
            }
            else System.out.println("No item selected");
            
            personDetails=new Person(editNameID.getText(), Integer.parseInt(editPhoneID.getText())
            ,editAdressID.getText(),editItemID.getValue(),
                    Integer.valueOf(editQuantityID.getText()), 
                    Float.parseFloat(editQuantityID.getText())*cost*days,
                    dtf.format(localDate));
       
        }
        catch(NumberFormatException ex){
            System.out.println("Not a number");
        }
        
        System.out.println("PERSON CREATED");
        
            String customer= personDetails.getCustomer();
            Integer phone=personDetails.getPhone_number();
            String address=personDetails.getAddress();
            String item= personDetails.getItem();
            Integer quantity=personDetails.getQuantity();
            Float cost=personDetails.getCost();
            
        System.out.println("UPDATING A PERSON!!");
        try {
            PreparedStatement p = conn.prepareStatement("Insert Into person set  customer=?, phone_No=?"
                    + " ,address=?,item=?, quantities=? , cost=?,dates=?");
            System.out.println("INSERTING PERSON.....");
            
            p.setString(1, editNameID.getText());
            p.setInt(2, Integer.valueOf(editPhoneID.getText()));
            p.setString(3, editAdressID.getText());
            p.setString(4, editItemID.getValue());
            p.setInt(5, Integer.valueOf(editQuantityID.getText()));
            p.setFloat(6, (Float.parseFloat(editQuantityID.getText())*40));
            p.setString(7, dtf.format(localDate));
            p.execute(); //use execute if no results expected back
            System.out.println(p);
            
           
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
            
        }
        if (editItemID.getValue().equalsIgnoreCase("TABLES")){
            tableDetails=new TableClass(editNameID.getText(), Integer.parseInt(editPhoneID.getText())
            ,editAdressID.getText(),Integer.parseInt(editQuantityID.getText()),
            dtf.format(localDate),(Float.parseFloat(editQuantityID.getText())*tableCost*days));
        
        System.out.println("UPDATING A TABLE!!");
        try {
            PreparedStatement t = conn.prepareStatement("Insert Into tables set  customer=?, phone_No=?"
                    + " ,address=?, quantities=?,dates=? , cost=?");
            System.out.println("INSERTING TABLE.....");
            t.setString(1, editNameID.getText());
            t.setInt(2, Integer.valueOf(editPhoneID.getText()));
            t.setString(3, editAdressID.getText());
            t.setInt(4, Integer.valueOf(editQuantityID.getText()));
            t.setString(5, dtf.format(localDate));
            t.setFloat(6, (Float.parseFloat(editQuantityID.getText())*tableCost*days));
            t.execute(); //use execute if no results expected back
            System.out.println(t);
            
           
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
            
        }
            }
           else if (editItemID.getValue().equalsIgnoreCase("CHAIRS")){
            chairDetails=new ChairsClass(editNameID.getText(), Integer.parseInt(editPhoneID.getText())
            ,editAdressID.getText(),Integer.parseInt(editQuantityID.getText()),
             dtf.format(localDate),(Float.parseFloat(editQuantityID.getText())*chairCost*days));
                    
        System.out.println("UPDATING A CHAIR!!");
        try {
            PreparedStatement h = conn.prepareStatement("Insert Into chairs set  customer=?, phone_No=?"
                    + " ,address=?, quantities=? ,dates=?, cost=?");
            System.out.println("UPDATING CHAIR.....");
            h.setString(1, editNameID.getText());
            h.setInt(2, Integer.valueOf(editPhoneID.getText()));
            h.setString(3, editAdressID.getText());
            h.setInt(4,Integer.valueOf(editQuantityID.getText()));
            h.setString(5, dtf.format(localDate));
            h.setFloat(6, (Float.parseFloat(editQuantityID.getText())*chairCost*days));
            h.execute(); //use execute if no results expected back
            System.out.println(h);
            
           
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
            
        }
            }
            else if (editItemID.getValue().equalsIgnoreCase("CANOPIES")){
            canopyDetails=new CanopiesClass(editNameID.getText(), Integer.parseInt(editPhoneID.getText())
            ,editAdressID.getText(),Integer.parseInt(editQuantityID.getText()),
             dtf.format(localDate),(Float.parseFloat(editQuantityID.getText())*canopyCost));
        System.out.println("INSERTING A CANOPY!!");
        try {
            PreparedStatement c = conn.prepareStatement("Insert Into canopies set  customer=?, phone_No=?"
                    + " ,address=?, quantities=? ,dates=?, cost=?");
            
            System.out.println("UPDATING CANOPY.....");
            
            c.setString(1, editNameID.getText());
            c.setInt(2, Integer.valueOf(editPhoneID.getText()));
            c.setString(3, editAdressID.getText());
            c.setInt(4, Integer.valueOf(editQuantityID.getText()));
            c.setString(5, dtf.format(localDate));
            c.setFloat(6, (Float.parseFloat(editQuantityID.getText())*canopyCost*days));
            c.execute(); //use execute if no results expected back
            System.out.println(c);
            
           
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
            
        }
                   }
            else System.out.println("No item Selected");
        
  
        return personDetails;
    }
    
     public void passHandleOnStage(Stage s){
        System.out.println("On pass handle");
        thisStage=s;
    }
    
    public void showCustomerDetail(Person p,boolean isNew) {
        System.out.println("On show customer details handle");
        this.personDetails = p;
        this.isNew = isNew;
        if (p != null) {
            editNameID.setText(p.getCustomer());
            editPhoneID.setText(p.getPhone_number().toString());
            editAdressID.setText(p.getAddress());
            editItemID.setValue(p.getItem());
            editQuantityID.setText(p.getQuantity().toString());
            
            
        } else {
            editNameID.setText(" ");
            editPhoneID.setText(" ");
            editAdressID.setText(" " );
            editItemID.setValue(" ");
            editQuantityID.setText(" ");
        }
        System.out.println("DONE TAKING DETAILS OF THE CUSTOMER");
    }

    @FXML
    private void cancelEditAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("details.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) DoneEditDetailBtn.getScene().getWindow();
            stage.setScene(scene);
        }
        catch(IOException e) {
            System.err.println(e.toString());
        }
    }

    @FXML
    private void buttonDoneEditing(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("details.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) DoneEditDetailBtn.getScene().getWindow();
            stage.setScene(scene);
        }
        catch(IOException e) {
            System.err.println(e.toString());
        }
    }
    
}
