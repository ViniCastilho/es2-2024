/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import Class.CreditCard;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daza_
 */
public class CreditDB {
    private final Connection connection;
    
    public CreditDB(Connection connection){
        this.connection = connection;
    }
    
    public void insert(CreditCard creditCard,String useremail) throws SQLException{
        
      
            String sq1 = "insert into creditcarddb(creditcardnumber,creditcardlimit,creditcardduedate,creditcardinvoicevalue,useremailfk) "
                    + "values('"+creditCard.getNumber()+"','"+creditCard.getLimit()+"','"+creditCard.getDueDate()+"','"+creditCard.getInvoiceValue()+"','"+useremail+"');";
            
            PreparedStatement statement = connection.prepareStatement(sq1);
            statement.execute();
        
  
        }
    
    public CreditCard select(String number) throws SQLException {
        String sql = "SELECT * FROM creditcarddb WHERE creditcardnumber = ?";
        
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, number);
            
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    String creditCardNumber = resultSet.getString("creditcardnumber");
                    Double creditCardLimit = resultSet.getDouble("creditcardlimit");
                    
                    // Verificando se a data é null antes de tentar converter
                    Date sqlDate = resultSet.getDate("creditcardduedate");
                    LocalDate creditCardDueDate = null;
                    if (sqlDate != null) {
                        //de DATE para LOCALDATE
                        creditCardDueDate = sqlDate.toLocalDate();
                    }
                    
                    Double creditCardInvoiceValue = resultSet.getDouble("creditcardinvoicevalue");
                   
                    
                    
                    
                    CreditCard creditCard = new CreditCard(creditCardNumber, creditCardLimit, creditCardDueDate, creditCardInvoiceValue);
                    return creditCard;
                }
            }
        
        
        return null; // Se não encontrar o cartão de crédito
    }
    
    
    

    
    public void update(String number, String newLimit,String newDueDate, String newInvoiceValue) throws SQLException{
        
        StringBuilder sql = new StringBuilder("UPDATE creditcarddb SET ");
        ///verifica quais dos campos passados são validos e adiciona a query
        if(newLimit != null && !newLimit.isEmpty()){
            sql.append("creditcardlimit = ?, ");
        }
        
        if(newDueDate != null && !newDueDate.isEmpty()){
            sql.append("creditcardduedate = ?, ");
        }
        
        if(newInvoiceValue != null && !newInvoiceValue.isEmpty()){
            sql.append("creditcardinvoicevalue = ?, ");
        }
        /// elimina a virgula
        sql.setLength(sql.length() - 2);
        //adiciona o restante da query 
        sql.append("WHERE creditcardnumber = ?");
        
        PreparedStatement statement = connection.prepareStatement(sql.toString());
        //Passa os valores a serem mudados para os lugares das virgulas.
        int parameterIndex = 1;
        
        if(newLimit != null && !newLimit.isEmpty()){
            statement.setString(parameterIndex++, newLimit);
        }
        if(newDueDate != null && !newDueDate.isEmpty()){
            statement.setString(parameterIndex++, newDueDate);
        }
        if(newInvoiceValue != null && !newInvoiceValue.isEmpty()){
            statement.setString(parameterIndex++, newInvoiceValue);
        }
        
        statement.setString(parameterIndex,number);
        
        statement.executeUpdate();
        
    }
    
    //trocado para boolean para realizar tratamento de erros no controlador e integrar isso a GUI
    public boolean delete(String number) throws SQLException{
        String sql = "DELETE FROM creditcarddb WHERE creditcardnumber = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1,number);

        int rowsAffected = statement.executeUpdate();
        
        
        //tentar return rowsAffected > 0 e ver o que retorna ::::  para nao usar o if
        if(rowsAffected > 0){
            return true;
        }else{
            return false;
        }   
        
    }
    
    public CreditCard selectCardByUserEmail(String useremail) throws SQLException {
    CreditCard creditCard = null; // Inicializa como null caso não encontre um cartão

    String sql = "SELECT creditcardnumber, creditcardlimit, creditcardduedate, creditcardinvoicevalue " + 
                 "FROM creditcarddb WHERE useremailfk = ? LIMIT 1"; // LIMIT 1 garante que você pega apenas um cartão

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, useremail);

        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) { // Verifica se há pelo menos um cartão
                // Cria o objeto CreditCard com os dados retornados
                creditCard = new CreditCard(
                        resultSet.getString("creditcardnumber"),
                        resultSet.getDouble("creditcardlimit"),
                        resultSet.getDate("creditcardduedate").toLocalDate(),
                        resultSet.getDouble("creditcardinvoicevalue")
                );
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return creditCard; // Retorna o cartão encontrado ou null
}
    
}
