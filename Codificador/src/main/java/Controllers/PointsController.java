/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;


import Class.Points;
import Session.UserSession;
import data.FileController;
import data.PointsDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Daza_
 */
public class PointsController {
    
    public Double calculatePoints(double amountSpent){
        return  (amountSpent * 10);
        
    }
    
    
    public void addPoints(Double payment) throws SQLException{
        
        Connection connection = new FileController().getConnection();    
        Double pointValue =  payment * 10;
        LocalDate pointDate = LocalDate.now();
        String pointsStatus = "disponivel";
        Points pointsEarned = new Points(pointValue,pointDate,pointsStatus);
       
        
        UserSession userSession = new UserSession();
        String loggedEmail = userSession.getUserEmail();
        
        PointsDB pointsDB = new PointsDB(connection);
        pointsDB.insert(pointsEarned, loggedEmail);
   
    }
    
    //atualizar para lidar com quantidades especificas de pontos
    public void usePoints(Double points) throws SQLException{
        Connection connection = new FileController().getConnection();    
        PointsDB pointsDB = new PointsDB(connection);
        
        pointsDB.update();
        
    }
    
    
    
    
    public List<Points> OpenPointsView() throws SQLException{
   
       Connection connection = new FileController().getConnection();
       PointsDB pointsDB = new PointsDB(connection);
    
       return pointsDB.selectAllPoints();
        
    }
    


  public String printOpenPoints() throws SQLException{
        StringBuilder  points = new StringBuilder();
        List<Points> pointsList = OpenPointsView();
        int totalPoints = 0;
       
          for (Points i : pointsList) {
              if("disponivel".equalsIgnoreCase(i.getStatus())){
        points.append("Pontos Gerados: ").append(i.getBalance())
                .append("\nData da Geração: ").append(i.getPointsDate())
                .append("\nStatus:  ").append(i.getStatus())
                .append("\n\n");  // Adiciona uma linha em branco entre os pontos
                totalPoints += i.getBalance();
        }
    }
    
        if (points.length() == 0) {
            points.append("Nenhum Ponto encontrado.");
    }else{
            points.append("Total de Pontos Disponiveis: ").append(totalPoints);
        }
    
        return points.toString();
    }
    
     public String printClosePoints() throws SQLException{
        StringBuilder  invoices = new StringBuilder();
        List<Points> pointsList = OpenPointsView();
        int totalPoints = 0;
        
          for (Points i : pointsList) {
              if("usado".equalsIgnoreCase(i.getStatus())){
        invoices.append("Pontos Gerados: ").append(i.getBalance())
                .append("\nData da Geração: ").append(i.getPointsDate())
                .append("\nStatus: ").append(i.getStatus())
                .append("\n\n");  // Adiciona uma linha em branco entre faturas
                totalPoints += i.getBalance();
        }
    }
    
        if (invoices.length() == 0) {
            invoices.append("Nenhum Ponto encontrado.");
    }else{
         invoices.append("Total de Pontos usados: ").append(totalPoints);
     }
    
        return invoices.toString();
    }
     
    public double pointsTotal() throws SQLException{
        
        List<Points> pointsList = OpenPointsView();
        double totalPoints = 0.0;
        
        for (Points i : pointsList) {
            if("disponivel".equalsIgnoreCase(i.getStatus())){
           
                totalPoints += i.getBalance();
        }
    }
        return totalPoints;
    }
    
    

     
}