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


import java.sql.SQLException;
import java.time.LocalDate;

import java.util.List;


/**
 *
 * @author Daza_
 */
public class InvoiceController {
   
    
    public void createInvoice(String invoiceNumber, double invoiceValue, LocalDate invoiceDueDate, LocalDate invoicePayment, String status) throws SQLException{
        Connection connection = null;
        connection = new FileController().getConnection();
        
        UserSession session = new UserSession();
        String loggedEmail = session.getUserEmail();
     
       
        CreditDB creditDB = new CreditDB(connection);
        CreditCard card = creditDB.selectCardByUserEmail(loggedEmail);
        String cardNumber = card.getNumber();
        
        if (card == null) {
        // Se não encontrar o cartão de crédito, exibe mensagem de erro ou retorna
        System.out.println("Cartão de crédito não encontrado para o usuário.");
        return;
    }
        
        
        Invoice invoice = new Invoice(invoiceNumber,invoiceValue,invoiceDueDate,invoicePayment,status);
        
        card.addInvoice(invoice);
        
        InvoiceDB invoiceDB = new InvoiceDB(connection);
        
        invoiceDB.insert(invoice, cardNumber);
  
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
    
}
