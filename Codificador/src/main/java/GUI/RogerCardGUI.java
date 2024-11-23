/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Class.User;
import Controllers.UserController;
import Controllers.UserController.RegisterStatus;
import data.FileController;
import data.UserDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Daza_
 */
public class RogerCardGUI extends javax.swing.JFrame {
    

    /**
     * Creates new form RogerCardGUI
     */
    public RogerCardGUI() {
       
        
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cadastroPanel1 = new javax.swing.JPanel();
        nameCadTextField1 = new javax.swing.JTextField();
        emailCadTextField2 = new javax.swing.JTextField();
        passCadTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        erroLabel2 = new javax.swing.JLabel();
        loginPanel1 = new javax.swing.JPanel();
        emailLogTextField1 = new javax.swing.JTextField();
        passLogTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        entrarButton2 = new javax.swing.JButton();

        nameCadTextField1.setText("Nome: ");
        nameCadTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameCadTextField1FocusGained(evt);
            }
        });

        emailCadTextField2.setText("Email: ");
        emailCadTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailCadTextField2FocusGained(evt);
            }
        });

        passCadTextField3.setText("Senha: ");
        passCadTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passCadTextField3FocusGained(evt);
            }
        });

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Cadastrar Usuário");

        javax.swing.GroupLayout cadastroPanel1Layout = new javax.swing.GroupLayout(cadastroPanel1);
        cadastroPanel1.setLayout(cadastroPanel1Layout);
        cadastroPanel1Layout.setHorizontalGroup(
            cadastroPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastroPanel1Layout.createSequentialGroup()
                .addGroup(cadastroPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastroPanel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(erroLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(cadastroPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(cadastroPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailCadTextField2)
                            .addComponent(nameCadTextField1)
                            .addGroup(cadastroPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(passCadTextField3))))
                .addContainerGap())
        );
        cadastroPanel1Layout.setVerticalGroup(
            cadastroPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastroPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nameCadTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(emailCadTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passCadTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(cadastroPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(erroLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        emailLogTextField1.setText("Email:");
        emailLogTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 0, 0)));
        emailLogTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailLogTextField1FocusGained(evt);
            }
        });
        emailLogTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailLogTextField1ActionPerformed(evt);
            }
        });

        passLogTextField2.setText("Senha: ");
        passLogTextField2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 0, 0)));
        passLogTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passLogTextField2FocusGained(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("Login");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 0, 0)));

        entrarButton2.setText("Entrar");
        entrarButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 0, 0)));
        entrarButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginPanel1Layout = new javax.swing.GroupLayout(loginPanel1);
        loginPanel1.setLayout(loginPanel1Layout);
        loginPanel1Layout.setHorizontalGroup(
            loginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanel1Layout.createSequentialGroup()
                .addGroup(loginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(passLogTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(loginPanel1Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(entrarButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(151, 151, 151))
                    .addGroup(loginPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(loginPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(emailLogTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );
        loginPanel1Layout.setVerticalGroup(
            loginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(emailLogTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passLogTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(entrarButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(loginPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(loginPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String name = nameCadTextField1.getText();
        String email = emailCadTextField2.getText();
        String pass = passCadTextField3.getText();
  
 
        UserController userController = new UserController();
        RegisterStatus status = null;
        try {
            status = userController.UserRegister(name, email, pass);
        } catch (SQLException ex) {
            Logger.getLogger(RogerCardGUI.class.getName()).log(Level.SEVERE, null, ex);
             erroLabel2.setText("Erro ao registrar usuário.");
        }
        
 
        switch (status) {
        case EMPTY_FIELDS:
            erroLabel2.setText("Dados Incompletos");
            break;
        case USER_ALREADY_EXISTS:
            erroLabel2.setText("Usuário já cadastrado");
            break;
        case SUCCESS:
            erroLabel2.setText("Usuário registrado com sucesso!");
            break;
        default:
            erroLabel2.setText("Erro desconhecido");
            break;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nameCadTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameCadTextField1FocusGained
        // TODO add your handling code here:
        nameCadTextField1.selectAll();
    }//GEN-LAST:event_nameCadTextField1FocusGained

    private void emailCadTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailCadTextField2FocusGained
        // TODO add your handling code here:
        emailCadTextField2.selectAll();
    }//GEN-LAST:event_emailCadTextField2FocusGained

    private void passCadTextField3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passCadTextField3FocusGained
        // TODO add your handling code here:
        passCadTextField3.selectAll();
    }//GEN-LAST:event_passCadTextField3FocusGained

    private void emailLogTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailLogTextField1FocusGained
        // TODO add your handling code here:
        emailLogTextField1.selectAll();
    }//GEN-LAST:event_emailLogTextField1FocusGained

    private void passLogTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passLogTextField2FocusGained
        // TODO add your handling code here:
        passLogTextField2.selectAll();
    }//GEN-LAST:event_passLogTextField2FocusGained

    private void entrarButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarButton2ActionPerformed
        // TODO add your handling code here:
         String email = emailLogTextField1.getText();
         String pass = passLogTextField2.getText();
         UserController userController = new UserController();
         //realiza a validação do login
         //adicionar um if para decidir o que sera feito na interface
        try {
            userController.UserLogin(email,pass);
        } catch (SQLException ex) {
            Logger.getLogger(RogerCardGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_entrarButton2ActionPerformed

    private void emailLogTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailLogTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailLogTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RogerCardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RogerCardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RogerCardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RogerCardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RogerCardGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cadastroPanel1;
    private javax.swing.JTextField emailCadTextField2;
    private javax.swing.JTextField emailLogTextField1;
    private javax.swing.JButton entrarButton2;
    private javax.swing.JLabel erroLabel2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel loginPanel1;
    private javax.swing.JTextField nameCadTextField1;
    private javax.swing.JTextField passCadTextField3;
    private javax.swing.JTextField passLogTextField2;
    // End of variables declaration//GEN-END:variables
}
