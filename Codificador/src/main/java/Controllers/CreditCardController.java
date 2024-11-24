/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Class.CreditCard;
import Class.User;
import data.CreditDB;
import data.FileController;
import data.UserDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Random;

/**
 *
 * @author Daza_
 */
public class CreditCardController {
    
    public String generateCardNumber() throws SQLException{
        Random random = new Random();
        
        StringBuilder number = new StringBuilder();
        for(int i = 0; i < 15; i++){
            number.append(random.nextInt(10));
        }
        
        //algoritmo para geracao do 16@ numero
        
        int sum = 0;
        boolean alternate = false;
        
        for(int i = 14; i >= 0; i--){
            int digit = number.charAt(i) - '0';
            if(alternate){
                digit *= 2;
                if(digit > 9){
                    digit -= 9;
                }
            }
            sum += digit;
            alternate = !alternate;
        }
        int verificadeDigit = (10 - (sum % 10)) %10;
        
        number.append(verificadeDigit);
        
        String creditNumber = number.toString();
        //se conecta ao banco para verificar se esse cartao ja existe
        try(Connection connection = new FileController().getConnection()){
           CreditDB creditDB = new CreditDB(connection);
        ///caso ja existe repete a função e gera um novo numero de cartao;
        if(creditDB.select(creditNumber) != null){
            return generateCardNumber();
            }       
        }

            return creditNumber;
            
    }
    
    public LocalDate generateDueDate(){
        LocalDate today = LocalDate.now();
        LocalDate dueDate = today.plusYears(5);
        
        return dueDate;
    }
    
    public void CreateCardRegister(String email) throws SQLException{
       Connection connection = new FileController().getConnection();
       UserDB userDB = new UserDB(connection);
       User user = userDB.select(email);
       
       int userID = user.getId();
       
       
       
       String cardNumber = generateCardNumber();
       Double cardLimit = 500.00;
       LocalDate cardDueDate = generateDueDate();
       Double cardInvoiceValue = 0.00;
       
       CreditCard creditCard = new CreditCard(cardNumber,cardLimit,cardDueDate,cardInvoiceValue,userID);
       
       CreditDB creditDB = new CreditDB(connection);
       creditDB.insert(creditCard);
        
        
    }
    
 
    
}
