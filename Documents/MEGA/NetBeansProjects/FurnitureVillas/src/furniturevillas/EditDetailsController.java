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
     * EditDetailsController class
     *
     * @author Claire Chemutai Langat
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
        private DetailsController details;

        java.sql.Connection conn = null;

        TableClass tableDetails ;

        ChairsClass chairDetails;
        CanopiesClass canopyDetails;

        DetailsController refresh;

        private Person personDetails;
        private Stage thisStage;
        private boolean isNew;

        float chairCost=25;
        float tableCost=40;
        float canopyCost=100;
        float cost;
        private int myClientID;
        int myCID;

        /**
         * Initializes the EditController class.
         */
        @Override
        public void initialize(URL url, ResourceBundle rb) {

            editItemID.getItems().removeAll(editItemID.getItems());
            editItemID.getItems().addAll("CHAIRS", "TABLES", "CANOPIES");

        }    

         public void passHandleOnStage(Stage s){
            System.out.println("On pass handle");
            thisStage=s;
        }

        public void showCustomerDetail(Person p,boolean isNew,int myCID) {
            System.out.println("On show customer details handle");
            this.personDetails = p;
            this.isNew = isNew;
            this.myClientID = myCID;
            int duration=0;
            if (p != null) {
                editNameID.setText(p.getCustomer());
                editPhoneID.setText(p.getPhone_number().toString());
                editAdressID.setText(p.getAddress());
                editItemID.setValue(p.getItem());
                editQuantityID.setText(p.getQuantity().toString());
                //editDurationField.setText(p.getDate().toString());
            } else {
                editNameID.setText(" ");
                editPhoneID.setText(" ");
                editAdressID.setText(" " );
                editItemID.setValue(" ");
                editQuantityID.setText(" ");
                editDurationField.setText(" ");
            }
            System.out.println("DONE TAKING DETAILS OF THE CUSTOMER");
        }


        /**
         * Method  to cancel editing
         */
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

         /**
         * Method  to cancel mark finishing of the editing
         */

        @FXML
        private void buttonDoneEditing(ActionEvent event) {
            updateAction(myClientID);

            thisStage.close();

        }

        /**
         * Method  to update information of the user
         */
        private void updateAction(int customer_ID) {

                java.sql.Connection conn = null;
                System.out.println("Connecting to the Database");
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    conn = java.sql.DriverManager.getConnection(
                            "jdbc:mysql://localhost/furniture?user=root&password=root");
                } catch (Exception e) {
                    System.err.println(e);
                    System.exit(0);
                }
                 try {
                if (editItemID.getValue().equals("TABLES")){
                    PreparedStatement p = conn.prepareStatement("Update person set customer=?, phone_No=?"
                        + " ,address=?,item=?, quantities=? , cost=?,dates=? where person_ID=?");
                        p.setString(1, editNameID.getText());
                        p.setInt(2, Integer.valueOf(editPhoneID.getText()));
                        p.setString(3, editAdressID.getText());
                        p.setString(4, editItemID.getValue());
                        p.setInt(5, Integer.valueOf(editQuantityID.getText()));
                        p.setFloat(6, (Float.parseFloat(editQuantityID.getText())*40));
                        p.setString(7, dtf.format(localDate));
                        p.setInt(8, customer_ID);
                        p.execute();
                    PreparedStatement p1 = conn.prepareStatement("Update tables set customer=?, phone_No=?"
                        + " ,address=?, quantities=? , cost=?,dates=? where person_ID=?");
                        p1.setString(1, editNameID.getText());
                        p1.setInt(2, Integer.valueOf(editPhoneID.getText()));
                        p1.setString(3, editAdressID.getText());
                        p1.setInt(4, Integer.valueOf(editQuantityID.getText()));
                        p1.setFloat(5, (Float.parseFloat(editQuantityID.getText())*40));
                        p1.setString(6, dtf.format(localDate));
                        p1.setInt(7, customer_ID);
                        p1.execute(); 


                } else if (editItemID.getValue().equals("CHAIRS")){
                    PreparedStatement p = conn.prepareStatement("Update person set customer=?, phone_No=?"
                        + " ,address=?,item=?, quantities=? , cost=?,dates=? where person_ID=?");
                        p.setString(1, editNameID.getText());
                        p.setInt(2, Integer.valueOf(editPhoneID.getText()));
                        p.setString(3, editAdressID.getText());
                        p.setString(4, editItemID.getValue());
                        p.setInt(5, Integer.valueOf(editQuantityID.getText()));
                        p.setFloat(6, (Float.parseFloat(editQuantityID.getText())*40));
                        p.setString(7, dtf.format(localDate));
                        p.setInt(8, customer_ID);
                        p.execute();
                    PreparedStatement p1 = conn.prepareStatement("Update chairs set customer=?, phone_No=?"
                        + " ,address=?, quantities=? , cost=?,dates=? where person_ID=?");
                        p1.setString(1, editNameID.getText());
                        p1.setInt(2, Integer.valueOf(editPhoneID.getText()));
                        p1.setString(3, editAdressID.getText());
                        p1.setInt(4, Integer.valueOf(editQuantityID.getText()));
                        p1.setFloat(5, (Float.parseFloat(editQuantityID.getText())*40));
                        p1.setString(6, dtf.format(localDate));
                        p1.setInt(7, customer_ID);
                        p1.execute(); 

                } 
                else{
                    PreparedStatement p = conn.prepareStatement("Update person set customer=?, phone_No=?"
                        + " ,address=?,item=?, quantities=? , cost=?,dates=? where person_ID=?");
                        p.setString(1, editNameID.getText());
                        p.setInt(2, Integer.valueOf(editPhoneID.getText()));
                        p.setString(3, editAdressID.getText());
                        p.setString(4, editItemID.getValue());
                        p.setInt(5, Integer.valueOf(editQuantityID.getText()));
                        p.setFloat(6, (Float.parseFloat(editQuantityID.getText())*40));
                        p.setString(7, dtf.format(localDate));
                        p.setInt(8, customer_ID);
                        p.execute();
                    PreparedStatement p1 = conn.prepareStatement("Update canopies set customer=?, phone_No=?"
                        + " ,address=?, quantities=? , cost=?,dates=? where person_ID=?");
                        p1.setString(1, editNameID.getText());
                        p1.setInt(2, Integer.valueOf(editPhoneID.getText()));
                        p1.setString(3, editAdressID.getText());
                        p1.setInt(4, Integer.valueOf(editQuantityID.getText()));
                        p1.setFloat(5, (Float.parseFloat(editQuantityID.getText())*40));
                        p1.setString(6, dtf.format(localDate));
                        p1.setInt(7, customer_ID);
                        p1.execute(); 
                }

                        } catch (SQLException e) {
                            System.err.println("Error " + e.toString());
                        }



        }
        /**
         * Method  to mark the end of editing
         */

        @FXML
        private void doneEditDetailsAction(ActionEvent event) {

        }
    }

