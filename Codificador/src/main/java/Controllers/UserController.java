/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Class.User;
import Session.UserSession;
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
        ERROR,SUCCESS, EMPTY_FIELDS, USER_ALREADY_EXISTS;
    }
    
 
public RegisterStatus UserRegister(String name, String email, String pass) throws SQLException {
    
    if (name.isEmpty() || email.isEmpty() || pass.isEmpty()) {
        return RegisterStatus.EMPTY_FIELDS;
    }

    Connection connection = null;
    try {
        connection = new FileController().getConnection();
        System.out.println("Conexão estabelecida com sucesso!");

        UserDB userDB = new UserDB(connection);
        if (userDB.select(email) != null) {
            return RegisterStatus.USER_ALREADY_EXISTS;
        }

        User user = new User(name, email, pass);
        userDB.insert(user);

        User sqlUser = userDB.select(email);
        

        CreditCardController creditController = new CreditCardController();
        creditController.CreateCardRegister(sqlUser.getEmail());

        return RegisterStatus.SUCCESS;

    } catch (SQLException ex) {
        Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        return RegisterStatus.ERROR;

    } finally {
        if (connection != null && !connection.isClosed()) {
            try {
                connection.close();
                System.out.println("Conexão fechada com sucesso.");
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}
   
   
   public boolean UserLogin(String email, String pass) throws SQLException{
      Connection connection = new FileController().getConnection();
      UserDB userDB = new UserDB(connection);
      //o objeto usuário recebe o resultada consulta select no banco 
      //verifica se a senha é valida e retorna false or true;
      User user;
      user = userDB.select(email);
      if(user.getPassword().equals(pass)){
          UserSession userSession = new UserSession();
          userSession.setUserEmail(email);
          return true;
      }else{
          return false;
      }

   }
   
   
   public boolean alterarEmail(String emailNovo, String emailAntigo) throws SQLException{
      Connection connection = new FileController().getConnection();
      UserDB userDB = new UserDB(connection);
      if(userDB.select(emailAntigo) != null){
          userDB.update(emailAntigo, null, emailNovo,null);
          UserSession userSession = new UserSession();
          userSession.setUserEmail(emailNovo);
      }else{
          return false;
        }
      return true;
   }
   
   
   public boolean alterarSenha(String senhaNova, String senhaAntiga) throws SQLException{
      
       Connection connection = new FileController().getConnection();
       UserDB userDB = new UserDB(connection);
       
       UserSession userSession = new UserSession();
       String loggedEmail = userSession.getUserEmail();
       
       User user = userDB.select(loggedEmail);
       if(user.getPassword().equals(senhaAntiga)){
            userDB.update(loggedEmail, null, null, senhaNova);
            return true;
        }else{
           return false;
       }
   }
   
   
   public boolean excluirConta() throws SQLException{
       UserSession userSession = new UserSession();
       String loggedEmail = userSession.getUserEmail();
       Connection connection = new FileController().getConnection();
       UserDB userDB = new UserDB(connection);
       
       if(userDB.delete(loggedEmail)){
           return true;
       }
       return false;
   }
   
   
   
   public boolean isValidPassword(String password) {
    if (password.length() < 8 || password.length() > 12) {
        return false;
    }

    boolean hasUpperCase = false;
    boolean hasLowerCase = false;
    boolean hasDigit = false;
    boolean hasSpecialChar = false;

    for (char c : password.toCharArray()) {
        if (Character.isUpperCase(c)) hasUpperCase = true;
        if (Character.isLowerCase(c)) hasLowerCase = true;
        if (Character.isDigit(c)) hasDigit = true;
        if (!Character.isLetterOrDigit(c)) hasSpecialChar = true;
    }

    return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
}
   
       
}
    
    
    
    
    
    
    
    

