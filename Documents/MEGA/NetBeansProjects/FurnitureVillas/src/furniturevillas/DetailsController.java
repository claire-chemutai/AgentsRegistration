    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package furniturevillas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
    import java.io.IOException;
    import java.net.URL;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import java.util.ResourceBundle;
    import javafx.application.Platform;
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import javafx.collections.transformation.FilteredList;
    import javafx.collections.transformation.SortedList;
    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.fxml.Initializable;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
import javafx.scene.control.Alert;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.control.MenuItem;
    import javafx.scene.control.TableColumn;
    import javafx.scene.control.TableView;
    import javafx.scene.control.TextField;
    import javafx.stage.Modality;
    import javafx.stage.Stage;

    /**
     * DetailsController class
     *
     * @author Claire Chemutai Langat
     */
    public class DetailsController implements Initializable {
        ObservableList<ChairsClass> theChairList= FXCollections.observableArrayList();
        ObservableList<TableClass> theTableList= FXCollections.observableArrayList();
        ObservableList<CanopiesClass> theCanopyList= FXCollections.observableArrayList();
        

        private Label lblDetail;
        private Stage detailStage;
        ObservableList<Person> data;

        private EditDetailsController editCustomerController = null;
        private AddingDetailsController addCustomerController=null;

        @FXML
        private TableView<ChairsClass> chairsTable;
        @FXML
        private TableView<TableClass> tablesTable;
        @FXML
        private TableView<CanopiesClass> canopiesTable;
        
        @FXML
        TableView<Person> customerDetailsTable;
        @FXML
        private TextField searchDetailField;
        @FXML
        private Button addDetailBtn;
        @FXML
        private Button editDetailBtn;

        @FXML
        private TableColumn<ChairsClass, String> customerNameChairsCol;
        @FXML
        private TableColumn<ChairsClass, Integer> phoneNoChairsCol;
        @FXML
        private TableColumn<ChairsClass, String> addressChairsCol;
        @FXML
        private TableColumn<ChairsClass, Integer> quantityChairsCol;
        @FXML
        private TableColumn<ChairsClass, String> dateChairsCol;
        @FXML
        private TableColumn<TableClass, String> customerNameTablesCol;
        @FXML
        private TableColumn<TableClass, Integer> phoneNoTablesCol;
        @FXML
        private TableColumn<TableClass, String> addressTableCol;
        @FXML
        private TableColumn<TableClass, Integer> quantityTableCol;
        @FXML
        private TableColumn<TableClass, String> dateTableCol;
        @FXML
        private TableColumn<CanopiesClass, String> customerNameCanopiesCol;
        @FXML
        private TableColumn<CanopiesClass, Integer> phoneNoCanopiesCol;
        @FXML
        private TableColumn<CanopiesClass, String> addressCanopiesCol;
        @FXML
        private TableColumn<CanopiesClass, Integer> quantityCanopiesCol;
        @FXML
        private TableColumn<CanopiesClass, String> dateCanopiesCol;
        @FXML
        private TableColumn<Person, String> customerDetailsCol;
        @FXML
        private TableColumn<Person, Integer> phoneDetailsCol;
        @FXML
        private TableColumn<Person, String> addressDetailCol;
        @FXML
        private TableColumn<Person, String> itemDetailCol;
        @FXML
        private TableColumn<Person, Integer> quantityDetailCol;
        @FXML
        private TableColumn<Person, Float> costDetailCol;
        @FXML
        private TableColumn<Person, String> dateDetailCol;
        @FXML
        private TableColumn<ChairsClass, Float> costChairsCol;
        @FXML
        private TableColumn<TableClass, Float> costTableCol;
        @FXML
        private TableColumn<CanopiesClass, Float> costCanopiesCol;
        @FXML
        private TableColumn<Person, Integer> customerID;

        Person selectedCustomer;
        private int CID;
        private boolean isNew;
        @FXML
        private MenuItem closeMenuBar;
        @FXML
        private MenuItem goHomeID;
        @FXML
        private MenuItem logOutID;
        @FXML
        private Button viewTransactionsID;
        @FXML
        private Button refreshBtn;




        /**
         * Initializes the detailsController class.
         */
        @Override
        public void initialize(URL url, ResourceBundle rb) {
            refresh();

        }     
        /**
         * show the details of an the customer
         * @param selectedCustomer is an a customer
         * @param isNew is a boolean
         */

        private void showDetailStage(Person selectedCustomer, boolean isNew) throws IOException, NullPointerException
        , RuntimeException{
            System.out.println("On detail stage");
            Parent root = FXMLLoader.load(getClass().getResource("addingDetails.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) addDetailBtn.getScene().getWindow();
            stage.setScene(scene);
            System.out.println("finished detail stage");

        }
        
        /**
         * Opens the add details page
         * 
         */

        @FXML
        private void addDetailsAction(ActionEvent event) throws IOException {
            Person selectedCustomer = null;
            boolean isNew = true;
            showDetailStage(selectedCustomer, isNew);


            try {
                Parent root = FXMLLoader.load(getClass().getResource("details.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) addDetailBtn.getScene().getWindow();
                stage.setScene(scene);
            }
            catch(IOException e) {
                System.err.println(e.toString());
            }
        }

          /**
         * Opens the edit details page
         * 
         */

        @FXML
        private void editDetailsAction(ActionEvent event) throws IOException {
            this.selectedCustomer = null;
            this.isNew = true;
            this.CID = -1;
            int selectedIndex = customerDetailsTable.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                selectedCustomer = customerDetailsTable.getItems().get(selectedIndex);
                CID = selectedCustomer.getCustomerID(); 
                
            } 
            
            
            
            if (detailStage == null) {
                 FXMLLoader loader = new FXMLLoader();
                 Parent detailPane = null;
            try {
                loader.setLocation(getClass().getResource("editDetails.fxml"));
                detailPane = loader.load();
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
            
            
            Scene scene = new Scene(detailPane);
            detailStage= new Stage();
            detailStage.setTitle("Customer  Details");
            detailStage.initModality(Modality.APPLICATION_MODAL);
            detailStage.setScene(scene);
            editCustomerController = loader.getController();
            editCustomerController.passHandleOnStage(detailStage);
        }
            
            editCustomerController.showCustomerDetail(selectedCustomer, isNew,CID);
            detailStage.showAndWait();
            

        
        }
        
        /**
         * closes the page
         * 
         */

        @FXML
        private void closePage(ActionEvent event) {
            Platform.exit();
        }
        
         /**
         * takes the user back to home page
         * 
         */

        @FXML
        private void goHomeAction(ActionEvent event) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) addDetailBtn.getScene().getWindow();
                stage.setScene(scene);
            }
            catch(IOException e) {
                System.err.println(e.toString());
            }
        }
        
        /**
         * Allows the user to log in
         * 
         */

        @FXML
        private void logOutAction(ActionEvent event) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("registrationPage.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) addDetailBtn.getScene().getWindow();
                stage.setScene(scene);
            }
            catch(IOException e) {
                System.err.println(e.toString());
            }
        }
        
        /**
         * prints the user details to a text file
         * 
         */

        @FXML
        private void viewTransactionsActions(ActionEvent event) throws IOException {
           this.selectedCustomer = null;
            this.isNew = true;
            
            int selectedIndex = customerDetailsTable.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                selectedCustomer = customerDetailsTable.getItems().get(selectedIndex);
                
            }  
            try{
            File file = new File("CUSTOMERSDETAIL.txt");
               try (BufferedWriter out = new BufferedWriter(new FileWriter(file, true))) {
                   out.write(selectedCustomer.getCustomer()+"\t");
                   
                   out.write(selectedCustomer.getPhone_number().toString()+"\t");
                  
                   out.write(selectedCustomer.getAddress()+"\t");
                   
                   out.write(selectedCustomer.getItem()+"\t");
                   
                   out.write(selectedCustomer.getQuantity().toString()+"\t");
                   
                   out.write(selectedCustomer.getDate().toString()+"\t");
                   
                   out.write(selectedCustomer.getQuantity()*35+"\t");
                   out.newLine();
               }
            } catch (IOException e) {
            }
        }
        
         /**
         * refreshes the page
         * 
         */
        public void refresh(){
            
            data = FXCollections.observableArrayList();
            System.out.println("Getting the customer details into table and database");

                    try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();

              } catch (ClassNotFoundException | IllegalAccessException |
                    InstantiationException  e) {
                System.out.println("Where is your MySQL JDBC Driver?");

                return;
            }

            System.out.println("MySQL JDBC Driver Registered!");

             Connection connection = null;
            try {
                connection = (Connection) DriverManager
                        .getConnection("jdbc:mysql://localhost/furniture?user=root&password=root");
            } catch (SQLException e) {
                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
                return;
            }
            if (connection != null) {
                System.out.println("You made it, take control your database now!");
            } else {
                System.out.println("Failed to make connection!");
            }






            System.out.println("Connection established");
            try {
                java.sql.Statement s = connection.createStatement();
                try (java.sql.ResultSet pr = s.executeQuery("SELECT * FROM person"))


                {
                    System.out.println(" SECOND CUSTOMER DETAILS STILL");
                    while (pr.next()) {
                        data.add(new Person(pr.getString("customer"),
                                pr.getInt("phone_No"),pr.getString("address"),
                                pr.getString("item"),pr.getInt("quantities"),
                                pr.getFloat("cost"),pr.getString("dates"),pr.getInt("person_ID")));
                        customerID.setCellValueFactory(cellData -> cellData.getValue().customerIDProperty().asObject());
                        customerDetailsCol.setCellValueFactory(cellData -> cellData.getValue().customerProperty());
                        phoneDetailsCol.setCellValueFactory(cellData -> cellData.getValue().phone_numberProperty().asObject());
                        addressDetailCol.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
                        itemDetailCol.setCellValueFactory(cellData -> cellData.getValue().itemProperty());
                        quantityDetailCol.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());
                        costDetailCol.setCellValueFactory(cellData -> cellData.getValue().costProperty().asObject());
                        dateDetailCol.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
                        customerDetailsTable.setItems(data);

                        System.out.println("ADDED PERSON");
                     
                    }
                    

            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }

                try (java.sql.ResultSet r = s.executeQuery("SELECT * FROM tables"))


                {

                    while (r.next()) {
                        theTableList.add(new TableClass(r.getString("customer"),
                        r.getInt("phone_No"),r.getString("address"),
                        r.getInt("quantities"), r.getString("dates"),
                        r.getFloat("cost")));
                        customerNameTablesCol.setCellValueFactory(cellData -> cellData.getValue().customerNameTablesColProperty());
                        phoneNoTablesCol.setCellValueFactory(cellData -> cellData.getValue().phoneNoTablesColProperty().asObject());
                        addressTableCol.setCellValueFactory(cellData -> cellData.getValue().addressTableColProperty());
                        quantityTableCol.setCellValueFactory(cellData -> cellData.getValue().quantityTableColProperty().asObject());
                        dateTableCol.setCellValueFactory(cellData -> cellData.getValue().dateTableColProperty());
                        costTableCol.setCellValueFactory(cellData -> cellData.getValue().costTableColProperty().asObject());
                        tablesTable.setItems(theTableList);
                        System.out.println("ADDED TABLE");
                    }

            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }

                try (java.sql.ResultSet m = s.executeQuery("SELECT * FROM chairs"))


                {
                    while (m.next()) {
                        theChairList.add(new ChairsClass(m.getString("customer"),
                        m.getInt("phone_No"),m.getString("address"),
                        m.getInt("quantities"), m.getString("dates"),
                                m.getFloat("cost")));
                        customerNameChairsCol.setCellValueFactory(cellData -> cellData.getValue().customerNameChairsColProperty());
                        phoneNoChairsCol.setCellValueFactory(cellData -> cellData.getValue().phoneNoChairsColProperty().asObject());
                        addressChairsCol.setCellValueFactory(cellData -> cellData.getValue().addressChairsColProperty());
                        quantityChairsCol.setCellValueFactory(cellData -> cellData.getValue().quantityChairsColProperty().asObject());
                        dateChairsCol.setCellValueFactory(cellData -> cellData.getValue().dateChairsColProperty());
                        costChairsCol.setCellValueFactory(cellData -> cellData.getValue().costChairsColProperty().asObject());
                        chairsTable.setItems(theChairList);
                        System.out.println("ADDED CHAIR");
                    }

            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }

                try (java.sql.ResultSet n = s.executeQuery("SELECT * FROM canopies"))


                {
                    while (n.next()) {
                        theCanopyList.add(new CanopiesClass(n.getString("customer"),
                        n.getInt("phone_No"),n.getString("address"),
                        n.getInt("quantities"), n.getString("dates"),
                                n.getFloat("cost")));
                        customerNameCanopiesCol.setCellValueFactory(cellData -> cellData.getValue().customerNameCanopiesColProperty());
                        phoneNoCanopiesCol.setCellValueFactory(cellData -> cellData.getValue().phoneNoCanopiesColProperty().asObject());
                        addressCanopiesCol.setCellValueFactory(cellData -> cellData.getValue().addressCanopiesColProperty());
                        quantityCanopiesCol.setCellValueFactory(cellData -> cellData.getValue().quantityCanopiesColProperty().asObject());
                        dateCanopiesCol.setCellValueFactory(cellData -> cellData.getValue().dateCanopiesColProperty());
                        costCanopiesCol.setCellValueFactory(cellData -> cellData.getValue().costCanopiesColProperty().asObject());
                        canopiesTable.setItems(theCanopyList);

                        System.out.println("ADDED CANOPY");
                    }
                }
                

                connection.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
            
            System.out.println("START SEARCHING");
            FilteredList<Person> filteredData = new FilteredList<>(data, p -> true);

            searchDetailField.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate((Person record) -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();

                     
                    if (record.getCustomer().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    }
                    if (!record.getPhone_number().toString().contains(newValue)) {
                        return false;
                    }
                    return true; 
                });
            });
            System.out.println("DONE SEARCHING");
            SortedList<Person> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(customerDetailsTable.comparatorProperty());
            customerDetailsTable.setItems(sortedData);
            System.out.println("FINISHED SEARCHING");
            

        
        }
        
        /**
         * Allows the user to refresh
         * 
         */

    @FXML
    private void refreshAction(ActionEvent event) {
        chairsTable.getItems().clear();
        tablesTable.getItems().clear();
        canopiesTable.getItems().clear();
        refresh();
    }
        
       

    }




 