/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.time.LocalDate;

/**
 *
 * @author gerson.lucas_unesp
 */
public class CreditCard {
    private int number;
    private double limit; 
    private LocalDate dueDate;
    private double invoiceValue;
    
    
    public CreditCard(int number, double limit, LocalDate dueDate, double invoiceValue){
        this.number = number;
        this.limit = limit; 
        this.dueDate = dueDate;
        this.invoiceValue = invoiceValue;
    }
    
    public void showInvoice(){
        
    }
    
    public void payInvoice(){
        
    }
    
    
    
    
}
