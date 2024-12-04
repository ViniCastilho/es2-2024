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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
   public void usePoints(Double points) throws SQLException {
    Connection connection = new FileController().getConnection();
    UserSession userSession = new UserSession();
    String loggedEmail = userSession.getUserEmail();

    
        // Seleciona os pontos disponíveis do usuário, ordenados pela data
        String selectSql = "SELECT pointsbalance, pointsdate FROM pointsdb WHERE useremailfk = ? AND pointsstatus = 'disponível' ORDER BY pointsdate ASC";
        PreparedStatement selectStatement = connection.prepareStatement(selectSql);
        selectStatement.setString(1, loggedEmail);
        ResultSet resultSet = selectStatement.executeQuery();

        double remainingPoints = points;

        while (resultSet.next() && remainingPoints > 0) {
            int id = resultSet.getInt("id");
            double availablePoints = resultSet.getDouble("points");

            if (remainingPoints >= availablePoints) {
                // Marca os pontos como usados
                String updateSql = "UPDATE pointsdb SET pointsstatus = 'usado', points = 0 WHERE id = ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateSql);
                updateStatement.setInt(1, id);
                updateStatement.executeUpdate();

                remainingPoints -= availablePoints;
            } else {
                // Atualiza os pontos restantes na linha atual
                double updatedPoints = availablePoints - remainingPoints;
                String partialUpdateSql = "UPDATE pointsdb SET points = ?, pointsstatus = 'disponível' WHERE id = ?";
                PreparedStatement partialUpdateStatement = connection.prepareStatement(partialUpdateSql);
                partialUpdateStatement.setDouble(1, updatedPoints);
                partialUpdateStatement.setInt(2, id);
                partialUpdateStatement.executeUpdate();

                // Atualiza os pontos consumidos na linha atual
                String markUsedSql = "UPDATE pointsdb SET pointsstatus = 'usado' WHERE id = ?";
                PreparedStatement markUsedStatement = connection.prepareStatement(markUsedSql);
                markUsedStatement.setInt(1, id);
                markUsedStatement.executeUpdate();

                remainingPoints = 0;
            }
        }

       
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