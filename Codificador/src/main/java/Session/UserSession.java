/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Session;

import Class.CreditCard;
import data.CreditDB;
import data.FileController;
import data.InvoiceDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;


/**
 *
 * @author Daza_
 */
public class UserSession {
    private static String userEmail;


    public static void setUserEmail(String email) {
        userEmail = email;
    }

    public static String getUserEmail() {
        return userEmail;
    }
    
   public void AlertLogin() throws SQLException {
    Connection connection = new FileController().getConnection();
    InvoiceDB invoiceDB = new InvoiceDB(connection);
    UserSession userSession = new UserSession();
    
    // Obtém o email do usuário logado
    String loggedEmail = userSession.getUserEmail();
    
    // Verifica se o dia atual é o dia 10
    if (LocalDate.now().getDayOfMonth() == 10) {
        // Consulta para verificar se existem faturas pendentes do usuário logado
        String checkInvoicesSql = "SELECT COUNT(*) FROM invoicedb " +
                                  "WHERE useremailfk = ? AND invoicestatus = 'ABERTA'";
        PreparedStatement statement = connection.prepareStatement(checkInvoicesSql);
        statement.setString(1, loggedEmail);
        ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next() && resultSet.getInt(1) > 0) {
            // Exibe alerta de faturas pendentes
            JOptionPane.showMessageDialog(
                null, 
                "Você possui faturas pendentes. Por favor, realize o pagamento.", 
                "Alerta de Pagamento", 
                JOptionPane.WARNING_MESSAGE
            );
        }
    }
}
   
   public void UpdateCardLimit() throws SQLException {
    Connection connection = new FileController().getConnection();
    UserSession userSession = new UserSession();
    
    // Obtém o email do usuário logado
    String loggedEmail = userSession.getUserEmail();
    
    // Verifica se o dia atual é o dia 5
    if (LocalDate.now().getDayOfMonth() == 5) {
        // Atualiza o limite do cartão para 1000
        String updateLimitSql = "UPDATE creditcarddb SET creditcardlimit = 1000 WHERE useremailfk = ?";
        PreparedStatement updateStatement = connection.prepareStatement(updateLimitSql);
        updateStatement.setString(1, loggedEmail);
        int rowsAffected = updateStatement.executeUpdate();
        
        if (rowsAffected > 0) {
            // Exibe alerta ao usuário sobre a atualização
            JOptionPane.showMessageDialog(
                null,
                "O limite do seu cartão foi atualizado para R$ 1000,00!",
                "Limite Atualizado",
                JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            // Caso nenhum cartão seja atualizado, exibe mensagem de aviso
            JOptionPane.showMessageDialog(
                null,
                "Nenhum cartão encontrado para atualizar o limite.",
                "Aviso",
                JOptionPane.WARNING_MESSAGE
            );
        }
    }
}


 
    
}
