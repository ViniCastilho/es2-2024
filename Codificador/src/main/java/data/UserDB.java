/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import Class.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Daza_
 */
public class UserDB {
    private final Connection connection;
    
    public UserDB(Connection connection){
        this.connection = connection;
    }
    
    public void insert(User user) throws SQLException{

            String sq1 = "insert into userdb(username,useremail,userpassword) values('"+user.getName()+"','"+user.getEmail()+"','"+user.getPassword()+"');";
            
            PreparedStatement statement = connection.prepareStatement(sq1);
            statement.execute();    
            connection.close();
  
      }     
    
    }

