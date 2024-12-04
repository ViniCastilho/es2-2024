/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import Class.CreditCard;
import Class.Invoice;
import Class.Points;
import Session.UserSession;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daza_
 */
public class PointsDB {
    private final Connection connection;
    
    public PointsDB(Connection connection){
        this.connection = connection;
    }
    
    public void insert(Points points,String useremail) throws SQLException{
        
      
            String sq1 = "insert into pointsdb(pointsbalance,pointsdate,pointsstatus,useremailfk) "
                    + "values('"+points.getBalance()+"','"+points.getPointsDate()+"','"+points.getStatus()+"','"+useremail+"');";
            
            PreparedStatement statement = connection.prepareStatement(sq1);
            statement.execute();
        
  
        }
    
    public Points select() throws SQLException {
        
        UserSession userSession = new UserSession();
        String loggedEmail = userSession.getUserEmail();
        
        String sql = "SELECT * FROM creditcarddb WHERE useremailfk = ?";
        
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, loggedEmail);
            
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    Double pointsBalance = resultSet.getDouble("pointsbalance");
                  
                    
                    // Verificando se a data é null antes de tentar converter
                    Date sqlDate = resultSet.getDate("pointsdate");
                    LocalDate pointsDate = null;
                    if (sqlDate != null) {
                        //de DATE para LOCALDATE
                        pointsDate = sqlDate.toLocalDate();
                    }
                    
                    String pointsStatus = resultSet.getString("pointsstatus");
                  
                   
                    
                    
                    
                    Points points = new Points(pointsBalance, pointsDate, pointsStatus);
                    return points;
                }
            }
        
        
        return null; // Se não encontrar o cartão de crédito
    }
    
    
    
    public List<Points> selectAllPoints() throws SQLException {
        Connection connection = null;
        connection = new FileController().getConnection();
        
        UserSession userSession = new UserSession();
        String loggedEmail = userSession.getUserEmail();
        
        List<Points> pointsList = new ArrayList<>();

        String sql = "SELECT pointsbalance, pointsdate, pointsstatus " +
                "FROM pointsdb WHERE useremailfk = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, loggedEmail);

        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                
                Double pointsBalance = resultSet.getDouble("pointsbalance");
                LocalDate pointsDate = resultSet.getDate("pointsdate").toLocalDate();
                String pointsStatus = resultSet.getString("pointsstatus");

                // Cria a fatura com o tratamento para o pagamento nulo
                Points points = new Points(pointsBalance, pointsDate, pointsStatus);
                pointsList.add(points);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return pointsList;
}
    
    
    

    
    public void update() throws SQLException{
        
        UserSession userSession = new UserSession();
        String loggedEmail = userSession.getUserEmail();
        
        String sql = "UPDATE pointsdb SET pointsstatus = 'usado' WHERE useremailfk = ?";
        
 
        PreparedStatement statement = connection.prepareStatement(sql);


        statement.setString(1,loggedEmail);
        
        statement.executeUpdate();
        
    }
    
    
    
}
