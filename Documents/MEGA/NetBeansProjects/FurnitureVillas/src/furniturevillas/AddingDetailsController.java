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
    import javafx.scene.control.TextField;
    import javafx.scene.layout.AnchorPane;
    import javafx.scene.layout.Pane;
    import javafx.stage.Stage;

    /**
     * AddingDetailsController class
     *
     * @author Claire Chemutai Langat
     */
    public class AddingDetailsController implements Initializable {


        @FXML
        private AnchorPane addNEditAnchor;
        @FXML
        private Pane addNeditPane;
        @FXML
        private Button DoneAddDetailBtn;
        @FXML
        private Button cancelAddDetailBtn;
        TableClass tableDetails ;

        ChairsClass chairDetails;
        CanopiesClass canopyDetails;

        private Person personDetails;
        private Stage thisStage;
        private boolean isNew;

        java.sql.Connection conn = null;
        @FXML
        private TextField addNameID;
        @FXML
        private TextField addPhoneID;
        @FXML
        private TextField addAddressID;
        @FXML
        private TextField addQuantityID;

        @FXML
        private ComboBox<String> addItemID;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        @FXML
        private Button doneAddBtn;
        @FXML
        private TextField addDurationField;
        float chairCost=25;
        float tableCost=40;
        float canopyCost=100;
        float cost;




        /**
         * Initializes the adding details controller class.
         */
        @Override
        public void initialize(URL url, ResourceBundle rb) {

            System.out.println("I WANT TO ADD USER INFO NOW!!");
            addItemID.getItems().removeAll(addItemID.getItems());
            addItemID.getItems().addAll("CHAIRS", "TABLES", "CANOPIES");

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


        /**
         * adds the new details to the table and the database
         * @return returns the type person, which is the customer and its details
         */

        @FXML
        public Person DoneAddDetailAction(ActionEvent event) {
            int days=Integer.parseInt(addDurationField.getText());

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
                if (addItemID.getValue().equalsIgnoreCase("TABLES")){
                    cost=tableCost;
                }
                else if (addItemID.getValue().equalsIgnoreCase("CHAIRS")){
                    cost=chairCost;
                }
                else if (addItemID.getValue().equalsIgnoreCase("CANOPIES")){
                    cost=canopyCost;

                }
                else System.out.println("No item selected");

                personDetails=new Person(addNameID.getText(), Integer.parseInt(addPhoneID.getText())
                ,addAddressID.getText(),addItemID.getValue(),
                        Integer.valueOf(addQuantityID.getText()), 
                        Float.parseFloat(addQuantityID.getText())*cost,
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

            System.out.println("INSERTING A PERSON!!");
            try {
                PreparedStatement p = conn.prepareStatement("Insert Into person set  customer=?, phone_No=?"
                        + " ,address=?,item=?, quantities=? , cost=?,dates=?");
                System.out.println("INSERTING PERSON.....");

                p.setString(1, addNameID.getText());
                p.setInt(2, Integer.valueOf(addPhoneID.getText()));
                p.setString(3, addAddressID.getText());
                p.setString(4, addItemID.getValue());
                p.setInt(5, Integer.valueOf(addQuantityID.getText()));
                p.setFloat(6, (Float.parseFloat(addQuantityID.getText())*40));
                p.setString(7, dtf.format(localDate));
                p.execute(); //use execute if no results expected back
                System.out.println(p);


            } catch (Exception e) {
                System.out.println("Error" + e.toString());

            }
            if (addItemID.getValue().equalsIgnoreCase("TABLES")){
                tableDetails=new TableClass(addNameID.getText(), Integer.parseInt(addPhoneID.getText())
                ,addAddressID.getText(),Integer.parseInt(addQuantityID.getText()),
                dtf.format(localDate),(Float.parseFloat(addQuantityID.getText())*tableCost));

            System.out.println("INSERTING A TABLE!!");
            try {
                PreparedStatement t = conn.prepareStatement("Insert Into tables set  customer=?, phone_No=?"
                        + " ,address=?, quantities=?,dates=? , cost=?");
                System.out.println("INSERTING TABLE.....");
                t.setString(1, addNameID.getText());
                t.setInt(2, Integer.valueOf(addPhoneID.getText()));
                t.setString(3, addAddressID.getText());
                t.setInt(4, Integer.valueOf(addQuantityID.getText()));
                t.setString(5, dtf.format(localDate));
                t.setFloat(6, (Float.parseFloat(addQuantityID.getText())*tableCost));
                t.execute(); //use execute if no results expected back
                System.out.println(t);


            } catch (Exception e) {
                System.out.println("Error" + e.toString());

            }
                }
               else if (addItemID.getValue().equalsIgnoreCase("CHAIRS")){
                chairDetails=new ChairsClass(addNameID.getText(), Integer.parseInt(addPhoneID.getText())
                ,addAddressID.getText(),Integer.parseInt(addQuantityID.getText()),
                 dtf.format(localDate),(Float.parseFloat(addQuantityID.getText())*chairCost));

            System.out.println("INSERTING A CHAIR!!");
            try {
                PreparedStatement h = conn.prepareStatement("Insert Into chairs set  customer=?, phone_No=?"
                        + " ,address=?, quantities=? ,dates=?, cost=?");
                System.out.println("INSERTING CHAIR.....");
                h.setString(1, addNameID.getText());
                h.setInt(2, Integer.valueOf(addPhoneID.getText()));
                h.setString(3, addAddressID.getText());
                h.setInt(4,Integer.valueOf(addQuantityID.getText()));
                h.setString(5, dtf.format(localDate));
                h.setFloat(6, (Float.parseFloat(addQuantityID.getText())*chairCost));
                h.execute(); //use execute if no results expected back
                System.out.println(h);


            } catch (Exception e) {
                System.out.println("Error" + e.toString());

            }
                }
                else if (addItemID.getValue().equalsIgnoreCase("CANOPIES")){
                canopyDetails=new CanopiesClass(addNameID.getText(), Integer.parseInt(addPhoneID.getText())
                ,addAddressID.getText(),Integer.parseInt(addQuantityID.getText()),
                 dtf.format(localDate),(Float.parseFloat(addQuantityID.getText())*canopyCost));
            System.out.println("INSERTING A CANOPY!!");
            try {
                PreparedStatement c = conn.prepareStatement("Insert Into canopies set  customer=?, phone_No=?"
                        + " ,address=?, quantities=? ,dates=?, cost=?");

                System.out.println("INSERTING CANOPY.....");

                c.setString(1, addNameID.getText());
                c.setInt(2, Integer.valueOf(addPhoneID.getText()));
                c.setString(3, addAddressID.getText());
                c.setInt(4, Integer.valueOf(addQuantityID.getText()));
                c.setString(5, dtf.format(localDate));
                c.setFloat(6, (Float.parseFloat(addQuantityID.getText())*canopyCost));
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
         /**
         * adds the new details to the table and the database
         * @param p is the customer
         * @param isNew is a boolean indicating whether the customer is present or not
         */

        public void showCustomerDetail(Person p,boolean isNew) {
            System.out.println("On show customer details handle");
            this.personDetails = p;
            this.isNew = isNew;
            if (p != null) {
                addNameID.setText(p.getCustomer());
                addPhoneID.setText(p.getPhone_number().toString());
                addAddressID.setText(p.getAddress());
                addItemID.setValue(p.getItem());
                addQuantityID.setText(p.getQuantity().toString());


            } else {
                addNameID.setText(" ");
                addPhoneID.setText(" ");
                addAddressID.setText(" " );
                addItemID.setValue(" ");
                addQuantityID.setText(" ");
            }
            System.out.println("DONE TAKING DETAILS OF THE CUSTOMER");
        }

        @FXML
        private void cancelAddDetailAction(ActionEvent event) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("details.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) DoneAddDetailBtn.getScene().getWindow();
                stage.setScene(scene);
            }
            catch(IOException e) {
                System.err.println(e.toString());
            }
        }

        @FXML
        private void buttonDoneAdding(ActionEvent event) {
                try {
                Parent root = FXMLLoader.load(getClass().getResource("details.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) DoneAddDetailBtn.getScene().getWindow();
                stage.setScene(scene);
            }
            catch(IOException e) {
                System.err.println(e.toString());
            }
        }


    }

