/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Controllers.UserController;
import Controllers.UserController.RegisterStatus;
import Session.UserSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


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
        this.setLocationRelativeTo(null);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPanel1 = new javax.swing.JPanel();
        emailLogTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        entrarButton2 = new javax.swing.JButton();
        voltar2Button2 = new javax.swing.JButton();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        cadastroPanel1 = new javax.swing.JPanel();
        nameCadTextField1 = new javax.swing.JTextField();
        emailCadTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        erroLabel2 = new javax.swing.JLabel();
        voltarButton2 = new javax.swing.JButton();
        PasswordField1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        menuPanel1 = new javax.swing.JPanel();
        cadastrarButton2 = new javax.swing.JButton();
        logarButton2 = new javax.swing.JButton();
        sairButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        loginPanel1.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                loginPanel1HierarchyChanged(evt);
            }
        });

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

        jLabel2.setBackground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("Login");

        entrarButton2.setText("Entrar");
        entrarButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarButton2ActionPerformed(evt);
            }
        });

        voltar2Button2.setText("Voltar");
        voltar2Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltar2Button2ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Mostrar Senha");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Email");

        jLabel8.setText("Senha");

        javax.swing.GroupLayout loginPanel1Layout = new javax.swing.GroupLayout(loginPanel1);
        loginPanel1.setLayout(loginPanel1Layout);
        loginPanel1Layout.setHorizontalGroup(
            loginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanel1Layout.createSequentialGroup()
                        .addComponent(voltar2Button2)
                        .addGap(71, 71, 71)
                        .addComponent(entrarButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(151, 151, 151))
                    .addGroup(loginPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox2)
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(loginPanel1Layout.createSequentialGroup()
                        .addGroup(loginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(loginPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(loginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emailLogTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        loginPanel1Layout.setVerticalGroup(
            loginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailLogTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox2)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(loginPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(entrarButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(23, 23, 23))
                    .addGroup(loginPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(voltar2Button2)
                        .addContainerGap())))
        );

        nameCadTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameCadTextField1FocusGained(evt);
            }
        });

        emailCadTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailCadTextField2FocusGained(evt);
            }
        });

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Cadastrar Usuário");

        voltarButton2.setText("Voltar");
        voltarButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButton2ActionPerformed(evt);
            }
        });

        PasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordField1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Nome:");

        jLabel5.setText("Email");

        jLabel6.setText("Senha");

        jCheckBox1.setText("Mostrar Senha");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cadastroPanel1Layout = new javax.swing.GroupLayout(cadastroPanel1);
        cadastroPanel1.setLayout(cadastroPanel1Layout);
        cadastroPanel1Layout.setHorizontalGroup(
            cadastroPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastroPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cadastroPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastroPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(voltarButton2)
                        .addGap(59, 59, 59)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(erroLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cadastroPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(cadastroPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameCadTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addComponent(emailCadTextField2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(PasswordField1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cadastroPanel1Layout.setVerticalGroup(
            cadastroPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastroPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameCadTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailCadTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cadastroPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(cadastroPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastroPanel1Layout.createSequentialGroup()
                        .addGroup(cadastroPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(erroLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastroPanel1Layout.createSequentialGroup()
                        .addComponent(voltarButton2)
                        .addContainerGap())))
        );

        menuPanel1.setEnabled(false);
        menuPanel1.setName("Início"); // NOI18N

        cadastrarButton2.setText("Cadastrar");
        cadastrarButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarButton2ActionPerformed(evt);
            }
        });

        logarButton2.setText("Logar");
        logarButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logarButton2ActionPerformed(evt);
            }
        });

        sairButton2.setText("Sair");
        sairButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Bem vindo a RogerCard, o que deseja fazer?");

        javax.swing.GroupLayout menuPanel1Layout = new javax.swing.GroupLayout(menuPanel1);
        menuPanel1.setLayout(menuPanel1Layout);
        menuPanel1Layout.setHorizontalGroup(
            menuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(cadastrarButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logarButton2)
                .addGap(50, 50, 50))
            .addGroup(menuPanel1Layout.createSequentialGroup()
                .addGroup(menuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanel1Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(sairButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(70, 70, 70))
                    .addGroup(menuPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel3)))
                .addGap(111, 111, 111))
        );
        menuPanel1Layout.setVerticalGroup(
            menuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel3)
                .addGap(72, 72, 72)
                .addGroup(menuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logarButton2)
                    .addComponent(cadastrarButton2))
                .addGap(89, 89, 89)
                .addComponent(sairButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(menuPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cadastroPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addComponent(loginPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(346, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(menuPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cadastroPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(loginPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(15, 15, 15)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String name = nameCadTextField1.getText();
        String email = emailCadTextField2.getText();
        char[] passChar = PasswordField1.getPassword();
        
        String pass = new String(passChar);
        UserController userController = new UserController();
        if (!userController.isValidPassword(pass)) {
            JOptionPane.showMessageDialog(
            this,
            "A senha deve ter entre 8 e 12 caracteres, incluindo ao menos uma letra maiúscula, uma minúscula, um número e um símbolo.",
            "Erro na senha",
            JOptionPane.ERROR_MESSAGE
    );
    return; // Interrompe o fluxo se a senha for inválida
}

 
        
        RegisterStatus status = null;
        try {
            status = userController.UserRegister(name, email, pass);
        } catch (SQLException ex) {
            Logger.getLogger(RogerCardGUI.class.getName()).log(Level.SEVERE, null, ex);
             erroLabel2.setText("Erro ao registrar usuário.");
        }
        
 
        switch (status) {
    case EMPTY_FIELDS:
        JOptionPane.showMessageDialog(this, "Preencha Todos os Campos em Branco", "Erro", JOptionPane.ERROR_MESSAGE);
        break;

    case USER_ALREADY_EXISTS:
        erroLabel2.setText("Email já cadastrado");
        break;

    case SUCCESS:
              JOptionPane.showMessageDialog(
  this, 
        "Usuário Cadastrado com Sucesso!", 
        "Sucesso", 
    JOptionPane.INFORMATION_MESSAGE
);

        cadastroPanel1.setVisible(false);
        loginPanel1.setVisible(true);
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

    private void emailLogTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailLogTextField1FocusGained
        // TODO add your handling code here:
        emailLogTextField1.selectAll();
    }//GEN-LAST:event_emailLogTextField1FocusGained

    private void entrarButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarButton2ActionPerformed
        // TODO add your handling code here:
        String email = emailLogTextField1.getText();
        char[] passChar = jPasswordField1.getPassword();
         
        String pass = new String(passChar);
         
         UserController userController = new UserController();
         //realiza a validação do login
         //adicionar um if para decidir o que sera feito na interface
        try {
            if(userController.UserLogin(email,pass)){
            RogerCardLogged rogerCardGUI = null;
                try {
                    
                    rogerCardGUI = new RogerCardLogged();
                } catch (ParseException ex) {
                    Logger.getLogger(RogerCardGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            rogerCardGUI.setVisible(true);
            
            UserSession userSession = new UserSession();
            userSession.AlertLogin();
            userSession.UpdateCardLimit();
            
            this.dispose();
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(RogerCardGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_entrarButton2ActionPerformed

    private void emailLogTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailLogTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailLogTextField1ActionPerformed

    private void cadastrarButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarButton2ActionPerformed
        // TODO add your handling code here:
       cadastroPanel1.setVisible(true);
        menuPanel1.setVisible(false);
        loginPanel1.setVisible(false);
        
    }//GEN-LAST:event_cadastrarButton2ActionPerformed

    private void loginPanel1HierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_loginPanel1HierarchyChanged
    }//GEN-LAST:event_loginPanel1HierarchyChanged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        cadastroPanel1.setVisible(false);
        loginPanel1.setVisible(false);
        menuPanel1.setVisible(true);
    }//GEN-LAST:event_formWindowOpened

    private void logarButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logarButton2ActionPerformed
        // TODO add your handling code here:
        menuPanel1.setVisible(false);
        cadastroPanel1.setVisible(false);
        loginPanel1.setVisible(true);
    }//GEN-LAST:event_logarButton2ActionPerformed

    private void voltarButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButton2ActionPerformed
        // TODO add your handling code here:
        cadastroPanel1.setVisible(false);
        loginPanel1.setVisible(false);
        menuPanel1.setVisible(true);
    }//GEN-LAST:event_voltarButton2ActionPerformed

    private void voltar2Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltar2Button2ActionPerformed
        // TODO add your handling code here:
        cadastroPanel1.setVisible(false);
        loginPanel1.setVisible(false);
        menuPanel1.setVisible(true);
    }//GEN-LAST:event_voltar2Button2ActionPerformed

    private void sairButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_sairButton2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if(jCheckBox1.isSelected()){
            PasswordField1.setEchoChar((char)0);
        }else{
           PasswordField1.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void PasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordField1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
         if(jCheckBox2.isSelected()){
            jPasswordField1.setEchoChar((char)0);
        }else{
           jPasswordField1.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

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
    private javax.swing.JPasswordField PasswordField1;
    private javax.swing.JButton cadastrarButton2;
    private javax.swing.JPanel cadastroPanel1;
    private javax.swing.JTextField emailCadTextField2;
    private javax.swing.JTextField emailLogTextField1;
    private javax.swing.JButton entrarButton2;
    private javax.swing.JLabel erroLabel2;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JButton logarButton2;
    private javax.swing.JPanel loginPanel1;
    private javax.swing.JPanel menuPanel1;
    private javax.swing.JTextField nameCadTextField1;
    private javax.swing.JButton sairButton2;
    private javax.swing.JButton voltar2Button2;
    private javax.swing.JButton voltarButton2;
    // End of variables declaration//GEN-END:variables
}
