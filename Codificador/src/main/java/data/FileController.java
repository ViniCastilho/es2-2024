/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import Static.Static;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Daza_
 */
public class FileController {
       Static dbprofile = new Static();
       String pass  = dbprofile.Pass();
       
    public Connection getConnection() throws SQLException{
        
        Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/RogerCard","postgres","root");
        return connect;
      
    }
    
}
