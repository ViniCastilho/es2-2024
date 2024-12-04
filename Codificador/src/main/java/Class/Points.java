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
public class Points {
    private Double balance;
    private LocalDate pointsDate;
    private String status;

    
    
    public Points(Double balance, LocalDate pointsDate, String status){
        this.balance = balance;
        this.pointsDate = pointsDate;
        this.status = status;

    }
    
    public void showBalance(){
        
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(int Double) {
        this.balance = balance;
    }

    public LocalDate getPointsDate() {
        return pointsDate;
    }

    public void setPointsDate(LocalDate pointsDate) {
        this.pointsDate = pointsDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
    
    
    
}
