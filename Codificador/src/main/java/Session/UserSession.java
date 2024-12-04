/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Session;

import Class.CreditCard;
import data.CreditDB;
import data.FileController;
import java.sql.Connection;
import java.sql.SQLException;


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

    public static String getUserCreditCard() throws SQLException{
        Connection connection = new FileController().getConnection();
        CreditDB creditDB = new CreditDB(connection);
        return creditDB.select(userEmail).getNumber();
        
    }
 
    
}
