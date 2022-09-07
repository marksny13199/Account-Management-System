package account.management.system;
import java.sql.*;
public class MAIN extends javax.swing.JFrame {
    
    public MAIN() {
        initComponents();
        checkCon();
    }
    
    public void checkCon(){
        String url = "jdbc:mysql://localhost:3306";
        String username = "root";
        String password = "";
        
        System.out.println("Connecting to database...");

        try (Connection con = DriverManager.getConnection(url, username, password)) {
            
            System.out.println("Database connected!");
            
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            new CONERROR().setVisible(true);
            throw new IllegalStateException(e);
        } 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createDB = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        createdbButton = new javax.swing.JButton();
        banner = new javax.swing.JLabel();
        adddbButton = new javax.swing.JButton();

        createDB.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        createDB.setText("Create Database");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        createdbButton.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        createdbButton.setText("Create Database");
        createdbButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createdbButtonMouseClicked(evt);
            }
        });

        banner.setFont(new java.awt.Font("Impact", 1, 48)); // NOI18N
        banner.setText("Account Management System");

        adddbButton.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        adddbButton.setText("Add Database");
        adddbButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adddbButtonMouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(304, 304, 304)
                .add(banner)
                .addContainerGap(311, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(adddbButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 433, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(createdbButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 433, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(412, 412, 412))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(107, 107, 107)
                .add(banner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(131, 131, 131)
                .add(createdbButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 51, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(adddbButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 51, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
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

    private void createdbButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createdbButtonMouseClicked
        new CREATEDB().setVisible(true);
    }//GEN-LAST:event_createdbButtonMouseClicked

    private void adddbButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adddbButtonMouseClicked
        new ADDDB().setVisible(true);
    }//GEN-LAST:event_adddbButtonMouseClicked
    
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
            java.util.logging.Logger.getLogger(MAIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MAIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MAIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MAIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MAIN().setVisible(true);
            }
        }); 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adddbButton;
    private javax.swing.JLabel banner;
    private javax.swing.JButton createDB;
    private javax.swing.JButton createdbButton;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
