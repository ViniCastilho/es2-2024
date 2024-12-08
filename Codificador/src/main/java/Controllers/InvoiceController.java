/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Class.CreditCard;
import Class.Invoice;
import Session.UserSession;
import data.CreditDB;
import data.FileController;
import data.InvoiceDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.sql.SQLException;
import java.time.LocalDate;

import java.util.List;


/**
 *
 * @author Daza_
 */
public class InvoiceController {
   
    
    public boolean createInvoice(String invoiceNumber, double invoiceValue, LocalDate invoiceDueDate, LocalDate invoicePayment, String status) throws SQLException{
        Connection connection = null;
        connection = new FileController().getConnection();
        
        UserSession session = new UserSession();
        String loggedEmail = session.getUserEmail();
     
        InvoiceDB invoiceDB = new InvoiceDB(connection);
       
        if(invoiceDB.select(invoiceNumber) != null){
            return false;
        }
        
        
        CreditDB creditDB = new CreditDB(connection);
        CreditCard card = creditDB.selectCardByUserEmail(loggedEmail);
        String cardNumber = card.getNumber();

        
        
        
        
        Invoice invoice = new Invoice(invoiceNumber,invoiceValue,invoiceDueDate,invoicePayment,status);
        
        card.addInvoice(invoice);
        
       
        
        invoiceDB.insert(invoice, cardNumber);
        return true;
  
    }
    
    
    
    
    
     public List<Invoice> OpenInvoiceView() throws SQLException{
        UserSession userSession = new UserSession();
        String loggedEmail = userSession.getUserEmail();
        
       Connection connection = new FileController().getConnection();
       CreditDB creditCardDB = new CreditDB(connection);
        
       String cardNumber = creditCardDB.selectCardByUserEmail(loggedEmail).getNumber();
       
       InvoiceDB invoiceDB = new InvoiceDB(connection);
      
       
       return invoiceDB.selectAllinvoice(cardNumber);
        
    }
    
    
    
    public String printOpenInvoice() throws SQLException{
        StringBuilder  invoices = new StringBuilder();
        List<Invoice> invoiceList = OpenInvoiceView();
        double totalValue = 0.0;
       
          for (Invoice i : invoiceList) {
              if("ABERTA".equalsIgnoreCase(i.getStatus())){
        invoices.append("Conta: ").append(i.getInvoiceNumber())
                .append("\nValor: ").append(i.getValue())
                .append("\nData de Vencimento: ").append(i.getDueDate())
                .append("\nStatus: ").append(i.getStatus())
                .append("\n\n");  // Adiciona uma linha em branco entre faturas
                totalValue += i.getValue();
        }
    }
    
        if (invoices.length() == 0) {
            invoices.append("Nenhuma fatura encontrada.");
    }else{
            invoices.append("Valor total da Fatura em Aberto: ").append(totalValue);
        }
    
        return invoices.toString();
    }
    
     public String printCloseInvoice() throws SQLException{
        StringBuilder  invoices = new StringBuilder();
        List<Invoice> invoiceList = OpenInvoiceView();
        double totalValue = 0.0;
        
          for (Invoice i : invoiceList) {
              if("FECHADA".equalsIgnoreCase(i.getStatus())){
        invoices.append("Conta: ").append(i.getInvoiceNumber())
                .append("\nValor: ").append(i.getValue())
                .append("\nData de Vencimento: ").append(i.getDueDate())
                .append("\nStatus: ").append(i.getStatus())
                .append("\nPontos Ganhos: ").append(i.getValue() * 10)
                .append("\n\n");  // Adiciona uma linha em branco entre faturas
                totalValue += i.getValue();
        }
    }
    
        if (invoices.length() == 0) {
            invoices.append("Nenhuma fatura encontrada.");
    }else{
         invoices.append("Valor total das Fatura já pagas: ").append(totalValue);
     }
    
        return invoices.toString();
    }
    
    
     
     public Double invoiceValue() throws SQLException{
        
        List<Invoice> invoiceList = OpenInvoiceView();
        double totalValue = 0.0;
        
        for (Invoice i : invoiceList) {
            if("ABERTA".equalsIgnoreCase(i.getStatus())){
           
                totalValue += i.getValue();
        }
    }
        return totalValue;
    }
    

     
     
      public enum RegisterPayment{
        NOFUNDS,SUCCESS, INSUFICIENTMONEY;
    }
     
    public RegisterPayment payInvoice(String numberCard, Double points) throws SQLException {
    Connection connection = null;
    PreparedStatement fetchStatement = null;
    ResultSet resultSet = null;

    try {
        connection = new FileController().getConnection();

        // Obtém as faturas pendentes do usuário ordenadas pela data
        String fetchInvoicesSql = "SELECT invoicenumber, invoicevalue FROM invoicedb WHERE creditnumberfk = ? AND invoicestatus = 'ABERTA' ORDER BY invoiceduedate ASC";
        fetchStatement = connection.prepareStatement(fetchInvoicesSql);
        fetchStatement.setString(1, numberCard);
        resultSet = fetchStatement.executeQuery();

        CreditDB creditDB = new CreditDB(connection);
        double currentLimit = creditDB.select(numberCard).getLimit();

        PromotionController promotionController = new PromotionController();
        double promotion = promotionController.calculatePromotion(points);

        // Valor total disponível para pagamento
        double remainingPayment = currentLimit + promotion;

        PointsController pointsController = new PointsController();
        pointsController.usePoints(points); // Deduz os pontos usados para obter a promoção

        double totalPaid = 0;

        while (resultSet.next() && remainingPayment > 0) {
            String invoiceNumber = resultSet.getString("invoicenumber");
            double invoiceValue = resultSet.getDouble("invoicevalue");

            if (remainingPayment >= invoiceValue) {
                // Marca a fatura como paga
                String updateInvoiceSql = "UPDATE invoicedb SET invoicestatus = 'FECHADA' WHERE invoicenumber = ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateInvoiceSql);
                updateStatement.setString(1, invoiceNumber);
                updateStatement.executeUpdate();

                remainingPayment -= invoiceValue;
                totalPaid += invoiceValue;
            } else {
                // Atualiza a fatura com o valor restante
                double updatedValue = invoiceValue - remainingPayment;
                String partialUpdateSql = "UPDATE invoicedb SET invoicevalue = ?, invoicestatus = 'ABERTA' WHERE invoicenumber = ?";
                PreparedStatement partialUpdateStatement = connection.prepareStatement(partialUpdateSql);
                partialUpdateStatement.setDouble(1, updatedValue);
                partialUpdateStatement.setString(2, invoiceNumber);
                partialUpdateStatement.executeUpdate();

                totalPaid += remainingPayment;
                remainingPayment = 0;
            }
        }

        // Atualiza o limite restante
        double updatedLimit = currentLimit - totalPaid + promotion;
        if (updatedLimit < 0) {
            updatedLimit = 0; // Garante que o limite não fique negativo
        }
        creditDB.update(numberCard, updatedLimit, null, null);

        // Adiciona pontos com base no valor pago
        pointsController.addPoints(totalPaid);

        // Retornos com base no saldo restante
        if (remainingPayment > 0) {
            return RegisterPayment.NOFUNDS;
        } else if (totalPaid == 0) {
            return RegisterPayment.INSUFICIENTMONEY;
        } else {
            return RegisterPayment.SUCCESS;
        }
    } finally {
        }
    }

     
     
}
