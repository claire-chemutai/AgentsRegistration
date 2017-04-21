/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package furniturevillas;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author study
 */
public class RegistrationPageController implements Initializable {

    @FXML
    private AnchorPane registrationAnchorPane;
    @FXML
    private AnchorPane signupLeftPane;
    @FXML
    private Button signinBtn;
    @FXML
    private AnchorPane registerRightPane;
    @FXML
    private Button cancelRgstrnBtn;
    @FXML
    private Button signUpBtn;
    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField passwordRegisterField;
    @FXML
    private PasswordField confPsswrdRegisterField;
    
    RegisterUser register = new RegisterUser();
    @FXML
    private TextField usernameRgstrField;
    @FXML
    private Label registerLabel;
    
    java.sql.Connection conn = null;
    @FXML
    private Label logInDetailsWrong;
   

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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
    } 
    
    

    @FXML
    private void signInAction(ActionEvent event)throws SQLException, IOException, ClassNotFoundException, 
            InstantiationException, IllegalAccessException, NullPointerException {
        String checkUser = userNameField.getText();
        String checkPass = passwordField.getText();
        String sql = "SELECT username, pass_word from users WHERE username = ? AND pass_word = ?";
        
        System.out.println("GOTTEN THE NAMES FROM THE FIELD");

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
        
        
        try{
        
            java.sql.ResultSet rs;
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, userNameField.getText());
                ps.setString(2, passwordField.getText());
               
                rs = ps.executeQuery("SELECT * FROM users");
                
                while (rs.next()) {
                    try {
                        if ((userNameField.getText().equalsIgnoreCase(rs.getString("username")))
                                && (passwordField.getText().equalsIgnoreCase(rs.getString("pass_word")))) {
                            
                                Parent root = FXMLLoader.load(getClass().getResource("details.fxml"));
                                Scene scene = new Scene(root);
                                Stage stage = (Stage) signinBtn.getScene().getWindow();
                                stage.setScene(scene);
                        }
                             
                        
                    } catch (final IOException | SQLException e) {
                        System.out.println(e.toString());
                    }
                    
                } 
                rs.close();
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Message Here...");
                            alert.setHeaderText("Login failure!!Please Register ");
                            alert.setContentText(" ");
                            alert.showAndWait().ifPresent(m -> {
                            if (m == ButtonType.OK) {
                             System.out.println("Pressed OK.");
                                }
                            }); 
            }
        
                            
                            
        //ps.close();
        
        } catch (final SQLException e) {
                }
        
        
    }

    @FXML
    private void cancelRgstrnAction(ActionEvent event) {
    }

    @FXML
    private void signUpAction(ActionEvent event) {
        register.addUser(usernameRgstrField.getText(), passwordRegisterField.getText());
                 
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
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
         try {
             
            try (java.sql.Statement s = connection.createStatement()) {
                
                try (java.sql.ResultSet r = s.executeQuery("SELECT * FROM users")) {
                    
                    while (r.next()) {
                        try {
                            if ((passwordRegisterField.getText().equalsIgnoreCase(confPsswrdRegisterField.getText()))) {
                                registerLabel.setText("Registration succesfull, Sign in now!!");
                                
                            } else {
                                
                               
				
                                
                                registerLabel.setText("Password do not match!!");
                                registerLabel.setStyle("-fx-text-fill:red;");
                            }
                            
                        } catch (final Exception e) {
                        }
                    }
                } catch (final SQLException e) {
                }
            }
            connection.close();
            } catch (final SQLException e) {
                }
        
    }
    }
    
    
