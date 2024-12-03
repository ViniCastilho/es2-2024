/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author gerson.lucas_unesp
 */
public class CreditCard {
    private String number;
    private double limit; 
    private LocalDate dueDate;
    private double invoiceValue;
    private List<Invoice> invoice;
    
    public CreditCard(String number, double limit, LocalDate dueDate, double invoiceValue){
        this.number = number;
        this.limit = limit; 
        this.dueDate = dueDate;
        this.invoiceValue = invoiceValue;
        this.invoice = new ArrayList<>();
    }
    


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public double getInvoiceValue() {
        return invoiceValue;
    }

    public void setInvoiceValue(double invoiceValue) {
        this.invoiceValue = invoiceValue;
    }

    public List<Invoice> getInvoice() {
        return invoice;
    }

    public void setInvoice(List<Invoice> invoice) {
        this.invoice = invoice;
    }
    
    public void addInvoice(Invoice invoice){
        this.invoice.add(invoice);
    }
    

    
    

}
