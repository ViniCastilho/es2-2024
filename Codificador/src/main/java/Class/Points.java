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
    private int balance;
    private LocalDate pointsDate;
    private LocalDate pointsExpire;
    
    
    public Points(int balance, LocalDate pointsDate, LocalDate pointsExpire){
        this.balance = balance;
        this.pointsDate = pointsDate;
        this.pointsExpire = pointsExpire;
    }
    
    public void showBalance(){
        
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public LocalDate getPointsDate() {
        return pointsDate;
    }

    public void setPointsDate(LocalDate pointsDate) {
        this.pointsDate = pointsDate;
    }

    public LocalDate getPointsExpire() {
        return pointsExpire;
    }

    public void setPointsExpire(LocalDate pointsExpire) {
        this.pointsExpire = pointsExpire;
    }
    
    
    
    
    
}
