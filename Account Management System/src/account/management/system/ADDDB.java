/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.management.system;

import java.sql.*;
import javax.swing.JOptionPane;

public class ADDDB extends javax.swing.JFrame {
    String url = "jdbc:mysql://localhost:3306";
    String username = "root";
    String password = "";

    /**
     * Creates new form ADDDB
     */
    public ADDDB() {
        initComponents();
        checkCon();
    }

    private void checkCon() {
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            if (con != null) {
                con.close();
            }  
        } catch (SQLException e) {
            new CONERROR().setVisible(true); 
            throw new IllegalStateException(e);
        } 
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nameDbfield = new javax.swing.JTextField();
        banner = new javax.swing.JLabel();
        selectdbButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        nameDbfield.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        nameDbfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameDbfieldActionPerformed(evt);
            }
        });

        banner.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        banner.setText("Database name:");

        selectdbButton.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        selectdbButton.setText("Add Database");
        selectdbButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectdbButtonMouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(34, 34, 34)
                .add(banner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 144, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(selectdbButton)
                    .add(nameDbfield, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 276, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(banner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(nameDbfield, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(selectdbButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 57, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(56, 56, 56))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nameDbfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameDbfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameDbfieldActionPerformed

    private void selectdbButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectdbButtonMouseClicked
        String tbName;
        
        tbName = nameDbfield.getText();
        
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            Statement db = null;
            Statement stmt = null;
            String initdbquery = "USE account_management_system;";
            String query = "SELECT * FROM `" + tbName + "`";

            try {
                db = con.createStatement();
                stmt = con.createStatement();
                boolean dbinit = db.execute(initdbquery);
                boolean result = stmt.execute(query);
                new DBMANAGEMENT(tbName).setVisible(true);
            }
            catch (SQLException ex){
                // handle any errors
                JOptionPane.showMessageDialog(null,tbName + " Not found.");
                ex.printStackTrace();
            }
            finally {
                if (stmt != null) {
                    try {
                        db.close();
                    } 
                    catch (SQLException sqlEx) { }
                    db = null;
                }
                    
                if (stmt != null) {
                    try {
                        stmt.close();
                    } 
                    catch (SQLException sqlEx) { }
                        stmt = null;
                    }

                    if (con != null) {
                        con.close();
                        this.dispose();
                    }
                }
            } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Can't connect to the database");
            throw new IllegalStateException(e);
        } 
    }//GEN-LAST:event_selectdbButtonMouseClicked

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
            java.util.logging.Logger.getLogger(ADDDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADDDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADDDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADDDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ADDDB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel banner;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameDbfield;
    private javax.swing.JToggleButton selectdbButton;
    // End of variables declaration//GEN-END:variables
}