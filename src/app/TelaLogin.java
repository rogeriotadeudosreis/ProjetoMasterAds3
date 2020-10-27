
package app;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 * @author  Aires Ribeiro
 */
public class TelaLogin extends javax.swing.JFrame {

    public TelaLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jButtonEntrar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setText("Usuário:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(290, 90, 40, 25);

        jLabel2.setText("Senha:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(290, 130, 34, 25);
        getContentPane().add(jTextFieldUsuario);
        jTextFieldUsuario.setBounds(339, 90, 110, 25);

        jPasswordFieldSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldSenhaKeyPressed(evt);
            }
        });
        getContentPane().add(jPasswordFieldSenha);
        jPasswordFieldSenha.setBounds(340, 130, 110, 25);

        jButtonEntrar.setText("Entrar");
        jButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEntrar);
        jButtonEntrar.setBounds(290, 220, 70, 30);

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair);
        jButtonSair.setBounds(380, 220, 70, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ImagemLogin.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 70, 250, 170);

        jLabel4.setFont(new java.awt.Font("Edwardian Script ITC", 0, 36)); // NOI18N
        jLabel4.setText("Projeto Master ADS");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(90, 30, 280, 40);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel5.setText("Autenticação de Usuário");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(100, 0, 290, 30);

        jLabelFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Fundo azul - Matis 133, vermelho 237, sat 240, verde 249, lum 232, azul 255 - 1000x690.png"))); // NOI18N
        getContentPane().add(jLabelFundo);
        jLabelFundo.setBounds(0, 0, 470, 270);

        setSize(new java.awt.Dimension(482, 306));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarActionPerformed
        // TODO add your handling code here:
        try {
            if(jTextFieldUsuario.getText().equals("Admin")&& jPasswordFieldSenha.getText().equals("Admin")){
                ViewPrincipal tela = new ViewPrincipal();   //Chamar a tela
                              tela.setVisible(true);        //Tornar a tela visivel
                dispose();                                  //Fechar a tela de login e abrir apenas a tela principal
            }else{
                JOptionPane.showMessageDialog(rootPane, "Acesso Negado!");
            }
        } catch (Exception erro) {
            throw erro;
        }
    }//GEN-LAST:event_jButtonEntrarActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
   
        System.exit(0);                                 //Sai do sistema fechando a tela
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jPasswordFieldSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldSenhaKeyPressed
        // TODO add your handling code here:
     try {
         if(evt.getKeyCode()==KeyEvent.VK_ENTER)   
         if(jTextFieldUsuario.getText().equals("Admin")&& jPasswordFieldSenha.getText().equals("Admin")){
                ViewPrincipal tela = new ViewPrincipal();   //Chamar a tela
                              tela.setVisible(true);        //Tornar a tela visivel
                dispose();                                  //Fechar a tela de login e abrir apenas a tela principal
            }else{
                JOptionPane.showMessageDialog(rootPane, "Acesso Negado!");
            }
        } catch (Exception erro) {
            throw erro;
        }
    }//GEN-LAST:event_jPasswordFieldSenhaKeyPressed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
