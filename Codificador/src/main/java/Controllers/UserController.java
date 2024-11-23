/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Class.User;
import GUI.RogerCardGUI;
import data.FileController;
import data.UserDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daza_
 */
public class UserController {
    
    public enum RegisterStatus{
        SUCCESS, EMPTY_FIELDS, USER_ALREADY_EXISTS;
    }
 
   public RegisterStatus UserRegister(String name, String email, String pass) throws SQLException{
            ///verifica espaços vazios no cadastro
            if (name.isEmpty() || email.isEmpty() || pass.isEmpty()) {
                return RegisterStatus.EMPTY_FIELDS;
        }
            //realiza conexao banco de dados
            Connection connection = new FileController().getConnection();
            UserDB userDB = new UserDB(connection);
            //verifica seo  usuario já existe
            if (userDB.select(email) != null) {
                return RegisterStatus.USER_ALREADY_EXISTS;
        }
            //cria o usuario e insere no banco de dados
            User user = new User(name, email, pass);
                try {
                    userDB.insert(user);
            }catch (SQLException ex) {
                Logger.getLogger(RogerCardGUI.class.getName()).log(Level.SEVERE, null, ex);   
        }
    
        return RegisterStatus.SUCCESS;
    }
       
}
    
    
    
    
    
    
    
    

