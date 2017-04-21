/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package furniturevillas;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Claire Chemutai
 */

public class RegisterUser {
    public void addUser(String username,String pass_word){
        
        java.sql.Connection conn = null;
        System.out.println("Connecting to the Database");
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = java.sql.DriverManager.getConnection(
                    "jdbc:mysql://localhost/furniture?user=root&password=root");
        }
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.err.println(e);
            System.exit(0);
        }
        
        try{
            PreparedStatement p;
            p = conn.prepareStatement("Insert Into users set username=?, pass_word=?");
            p.setString(1, username);
            p.setString(2, pass_word);
            
           
            p.execute(); //use execute if no results expected back
            }catch(SQLException e){
                System.err.println("Error "+e.toString());
                return;
            }
    }
    
}
