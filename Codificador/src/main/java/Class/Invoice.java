/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.time.LocalDate;

/**
 *
 * @author Daza_
 */
public class Invoice {
    private String invoiceNumber;
    private double value; 
    private LocalDate dueDate;
    private LocalDate paymentDate;
    private String status;    
    
    
    public Invoice (String invoiceNumber, double value, LocalDate dueDate, LocalDate paymentDate, String status){
        this.invoiceNumber = invoiceNumber;
        this.value = value;
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
        this.status = status;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
    

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    public void pay(LocalDate paymentDate){
        this.paymentDate = paymentDate;
        this.status = "Paid";
    }
    
    
}
