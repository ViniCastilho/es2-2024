/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import Static.Static;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Daza_
 */
public class FileController {
       Static dbprofile = new Static();
       String pass  = dbprofile.Pass();
       
    public Connection getConnection() throws SQLException{
        
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/RogerCard","root",pass);
        return connect;
      
    }   


    public void initializeDatabase() {
        String sqlScript = """
            CREATE DATABASE IF NOT EXISTS `rogercard` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
            USE `rogercard`;

            CREATE TABLE IF NOT EXISTS `creditcarddb` (
              `creditcardnumber` varchar(50) NOT NULL,
              `creditcardlimit` double DEFAULT NULL,
              `creditcardduedate` date DEFAULT NULL,
              `creditcardinvoicevalue` double DEFAULT NULL,
              `useremailfk` varchar(50) DEFAULT NULL,
              `last_reset_date` date DEFAULT NULL,
              PRIMARY KEY (`creditcardnumber`),
              KEY `fk_useremail` (`useremailfk`),
              CONSTRAINT `fk_useremail` FOREIGN KEY (`useremailfk`) REFERENCES `userdb` (`useremail`) ON UPDATE CASCADE
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

            CREATE TABLE IF NOT EXISTS `invoicedb` (
              `invoicenumber` varchar(50) DEFAULT NULL,
              `invoicevalue` double DEFAULT NULL,
              `invoiceduedate` date DEFAULT NULL,
              `invoicepayment` date DEFAULT NULL,
              `creditnumberfk` varchar(50) DEFAULT NULL,
              `invoicestatus` varchar(20) DEFAULT NULL,
              KEY `fk_creditnumber` (`creditnumberfk`),
              CONSTRAINT `fk_creditnumber` FOREIGN KEY (`creditnumberfk`) REFERENCES `creditcarddb` (`creditcardnumber`)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

            CREATE TABLE IF NOT EXISTS `pointsdb` (
              `pointsbalance` double NOT NULL,
              `pointsdate` date NOT NULL,
              `useremailfk` varchar(50) DEFAULT NULL,
              `pointsstatus` enum('disponivel','usado') NOT NULL,
              KEY `fk_useremailpoint` (`useremailfk`),
              CONSTRAINT `fk_useremailpoint` FOREIGN KEY (`useremailfk`) REFERENCES `userdb` (`useremail`)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

            CREATE TABLE IF NOT EXISTS `userdb` (
              `username` varchar(50) DEFAULT NULL,
              `useremail` varchar(50) NOT NULL,
              `userpassword` varchar(50) DEFAULT NULL,
              PRIMARY KEY (`useremail`)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
        """;

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            // Executa cada comando SQL
            for (String sql : sqlScript.split(";")) {
                if (!sql.trim().isEmpty()) {
                    statement.execute(sql);
                }
            }
            System.out.println("Banco de dados inicializado com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao inicializar o banco de dados: " + e.getMessage());
        }
    }


}
