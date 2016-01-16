/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.AccountControl;
import Core.UserSession;
import Models.UserModel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author programmer
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
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

        wrapper = new javax.swing.JPanel();
        panelKonten = new javax.swing.JPanel();
        lblNIP = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        txtNIP = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        lblMasuk = new javax.swing.JButton();
        PanelHeading = new javax.swing.JPanel();
        lblHeading = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Informasi Login");
        setResizable(false);

        wrapper.setLayout(new java.awt.BorderLayout());

        lblNIP.setText("NIP :");

        lblPass.setText("Kata Sandi :");

        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        lblMasuk.setText("Masuk");
        lblMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblMasukActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelKontenLayout = new javax.swing.GroupLayout(panelKonten);
        panelKonten.setLayout(panelKontenLayout);
        panelKontenLayout.setHorizontalGroup(
            panelKontenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKontenLayout.createSequentialGroup()
                .addGroup(panelKontenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelKontenLayout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(lblMasuk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelKontenLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(panelKontenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPass)
                            .addComponent(lblNIP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelKontenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNIP)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(103, 103, 103))
        );
        panelKontenLayout.setVerticalGroup(
            panelKontenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKontenLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panelKontenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNIP)
                    .addComponent(txtNIP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelKontenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPass)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblMasuk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(37, 37, 37))
        );

        wrapper.add(panelKonten, java.awt.BorderLayout.CENTER);

        lblHeading.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblHeading.setText("MASUK");

        javax.swing.GroupLayout PanelHeadingLayout = new javax.swing.GroupLayout(PanelHeading);
        PanelHeading.setLayout(PanelHeadingLayout);
        PanelHeadingLayout.setHorizontalGroup(
            PanelHeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeadingLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(lblHeading)
                .addContainerGap(130, Short.MAX_VALUE))
        );
        PanelHeadingLayout.setVerticalGroup(
            PanelHeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeadingLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lblHeading)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        wrapper.add(PanelHeading, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(wrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(wrapper, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(310, 316));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblMasukActionPerformed
        AccountControl akun = new AccountControl(txtNIP.getText(), txtPass.getPassword());
        akun.checkEmpty();
        tryLogin(akun.getUsername(), akun.getPassword());
    }//GEN-LAST:event_lblMasukActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        AccountControl akun = new AccountControl(txtNIP.getText(), txtPass.getPassword());
        akun.checkEmpty();
        tryLogin(akun.getUsername(), akun.getPassword());
    }//GEN-LAST:event_txtPassActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    private void tryLogin(String getNIP, String getPass) {
        try {

            if (UserModel.checkLogin(getNIP, getPass) == true) {
                dispose();
                switch (UserSession.getLevel()) {
                    case "Admin":
                        new MenuAdmin().setVisible(true);
                        break;
                    case "Pengajar":
                        new MenuPengajar().setVisible(true);
                        break;
                    case "Staf Umum":
                        new MenuStaf().setVisible(true);
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Gagal Login!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Sistem Error : " + ex.getMessage());
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelHeading;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JButton lblMasuk;
    private javax.swing.JLabel lblNIP;
    private javax.swing.JLabel lblPass;
    private javax.swing.JPanel panelKonten;
    private javax.swing.JTextField txtNIP;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPanel wrapper;
    // End of variables declaration//GEN-END:variables
}