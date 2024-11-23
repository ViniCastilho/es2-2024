/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import Class.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
    public User select(String email) throws SQLException{
        
        String sql = "SELECT * FROM userdb WHERE useremail = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, email);
        
        ResultSet resultSet = statement.executeQuery();
        
        if(resultSet.next()){
            String username = resultSet.getString("username");
            String useremail = resultSet.getString("useremail");
            String userpassword = resultSet.getString("userpassword");
            
            User user = new User(username,useremail,userpassword);
            return user;
        }
   
        return null;
        
        
    }
    
    public void update(String email, String newName,String newEmail, String newPass) throws SQLException{
        
        StringBuilder sql = new StringBuilder("UPDATE userdb SET ");
        ///verifica quais dos campos passados são validos e adiciona a query
        if(newName != null && !newName.isEmpty()){
            sql.append("username = ?, ");
        }
        
        if(newEmail != null && !newEmail.isEmpty()){
            sql.append("useremail = ?, ");
        }
        
        if(newPass != null && !newPass.isEmpty()){
            sql.append("userpassword = ?, ");
        }
        /// elimina a virgula
        sql.setLength(sql.length() - 2);
        //adiciona o restante da query 
        sql.append("WHERE useremail = ?");
        
        PreparedStatement statement = connection.prepareStatement(sql.toString());
        //Passa os valores a serem mudados para os lugares das virgulas.
        int parameterIndex = 1;
        
        if(newName != null && !newName.isEmpty()){
            statement.setString(parameterIndex++, newName);
        }
        if(newEmail != null && !newEmail.isEmpty()){
            statement.setString(parameterIndex++, newEmail);
        }
        if(newPass != null && !newPass.isEmpty()){
            statement.setString(parameterIndex++, newPass);
        }
        
        statement.setString(parameterIndex,email);
        
        statement.executeUpdate();
        
    }
    
    //trocado para boolean para realizar tratamento de erros no controlador e integrar isso a GUI
    public boolean delete(String email) throws SQLException{
        String sql = "DELETE FROM userdb WHERE useremail = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1,email);

        int rowsAffected = statement.executeUpdate();
        
        
        //tentar return rowsAffected > 0 e ver o que retorna ::::  para nao usar o if
        if(rowsAffected > 0){
            return true;
        }else{
            return false;
        }   

    }
        
        
}

 