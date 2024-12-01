/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;


import Class.Invoice;
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
public class InvoiceDB {
    private final Connection connection;
    
    public InvoiceDB(Connection connection){
        this.connection = connection;
    }
    
     public void insert(Invoice invoice, String creditCardNumber) throws SQLException{
        
         
         
        try (connection) {
            String sq1 = "insert into invoicedb(invoicenumber,invoicevalue,invoiceduedate,invoicestatus,creditnumberfk)"
                    + "values('"+invoice.getInvoiceNumber()+"','"+invoice.getValue()+"','"+invoice.getDueDate()+"','"+invoice.getStatus()+"','"+creditCardNumber+"');";
            
            PreparedStatement statement = connection.prepareStatement(sq1);
            statement.execute();
        }
  
        }
    ///tratar a mudança de status no invoice futuramente.
    public Invoice select(String number) throws SQLException {
        String sql = "SELECT * FROM invoicedb WHERE invoicenumber = ?";
        
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, number);
            
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    String invoiceNumber = resultSet.getString("invoicenumber");
                    Double invoiceValue = resultSet.getDouble("invoicevalue");
                    
                    // Verificando se a data é null antes de tentar converter
                    Date sqlDate = resultSet.getDate("invoiceduedate");
                    LocalDate invoiceDueDate = null;
                    if (sqlDate != null) {
                        //de DATE para LOCALDATE
                        invoiceDueDate = sqlDate.toLocalDate();
                    }
                    
                    // Verificando se a data de pagamento é null antes de tentar converter
                    Date sqlDate2 = resultSet.getDate("invoicepayment");
                    LocalDate invoicePayment = null;
                    String status = "ABERTA";  // Definido como "ABERTA" por padrão

                    if (sqlDate2 != null) {
                        invoicePayment = sqlDate2.toLocalDate();
                        status = "FECHADA";  // Se a data de pagamento não for null, status é "Pago"
                    }
                    
                    Invoice invoice = new Invoice(invoiceNumber, invoiceValue, invoiceDueDate,invoicePayment,status);
                    return invoice;
                }
            }
        
        
        return null; // Se não encontrar o cartão de crédito
    }
    
   
    
    //trocado para boolean para realizar tratamento de erros no controlador e integrar isso a GUI
    public boolean delete(String number) throws SQLException{
        String sql = "DELETE FROM invoicedb WHERE number = ?";
        
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
    
    public List<Invoice> selectAllinvoice(String cardNumber) throws SQLException {
    Connection connection = null;
    connection = new FileController().getConnection();
    List<Invoice> invoiceList = new ArrayList<>();

    String sql = "SELECT invoicenumber, invoicevalue, invoiceduedate, invoicepayment, invoicestatus " +
            "FROM invoicedb WHERE creditnumberfk = ?";

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, cardNumber);

        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String invoiceNumber = resultSet.getString("invoicenumber");
                double invoiceValue = resultSet.getDouble("invoicevalue");
                LocalDate invoiceDueDate = resultSet.getDate("invoiceduedate").toLocalDate();
                
                // Verifica se a data de pagamento é nula
                LocalDate invoicePayment = null;
                Date paymentDate = resultSet.getDate("invoicepayment");
                if (paymentDate != null) {
                    invoicePayment = paymentDate.toLocalDate();
                }
                
                String invoiceStatus = resultSet.getString("invoicestatus");

                // Cria a fatura com o tratamento para o pagamento nulo
                Invoice invoiceClass = new Invoice(invoiceNumber, invoiceValue, invoiceDueDate, invoicePayment, invoiceStatus);
                invoiceList.add(invoiceClass);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return invoiceList;
}

    
}
