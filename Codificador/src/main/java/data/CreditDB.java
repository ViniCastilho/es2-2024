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

/**
 *
 * @author Daza_
 */
public class CreditDB {
    private final Connection connection;
    
    public CreditDB(Connection connection){
        this.connection = connection;
    }
    
    public void insert(CreditCard creditCard) throws SQLException{

        try (connection) {
            String sq1 = "insert into creditcarddb(creditcardnumber,creditcardlimit,creditcardduedate,creditcardinvoicevalue,userid) "
                    + "values('"+creditCard.getNumber()+"','"+creditCard.getLimit()+"','"+creditCard.getDueDate()+"','"+creditCard.getInvoiceValue()+"','"+creditCard.getUserid()+"');";
            
            PreparedStatement statement = connection.prepareStatement(sq1);
            statement.execute();
        }
  
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
                    
                    int userid = resultSet.getInt("userid");
                    
                    CreditCard creditCard = new CreditCard(creditCardNumber, creditCardLimit, creditCardDueDate, creditCardInvoiceValue,userid);
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
        connection.close();
    }
    
    //trocado para boolean para realizar tratamento de erros no controlador e integrar isso a GUI
    public boolean delete(String number) throws SQLException{
        String sql = "DELETE FROM creditcarddb WHERE number = ?";
        
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
}
