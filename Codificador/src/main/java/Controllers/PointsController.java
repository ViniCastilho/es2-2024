/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Class.Points;
import java.time.LocalDate;

/**
 *
 * @author Daza_
 */
public class PointsController {
    
    public int calculatePoints(double amountSpent){
        return (int) (amountSpent * 10);
        
    }
    
    
    public Points addPoints(Points currentPoints, double amountSpent){
        int newPoints = calculatePoints(amountSpent);
        int updateBalance = currentPoints.getBalance() + newPoints;
        
        currentPoints.setBalance(updateBalance);
        currentPoints.setPointsDate(LocalDate.now());
        
        return currentPoints;
        
    }
    
}
