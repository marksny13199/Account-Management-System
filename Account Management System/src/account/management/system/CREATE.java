/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account.management.system;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class CREATE extends javax.swing.JFrame {
    String url = "jdbc:mysql://localhost:3306";
    String username = "root";
    String password = "";
    String TBname;
    /**
     * Creates new form CREATE
     */
    public CREATE() {
        initComponents();
    }
    
    public CREATE(String dbname) {
        initComponents();
        checkCon();
        TBname = dbname;
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
    
    private String[] GetColumn(){
        
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            Statement db = null;
            Statement stmt = null;
            ResultSet resultset = null;
            String initdbquery = "USE account_management_system;";
            String describe = "DESCRIBE " + TBname + ";";
            String[] fields = new String[9];
           

            try {
                int a = 0;
                db = con.createStatement();
                stmt = con.createStatement();
                db.execute(initdbquery);
                resultset = stmt.executeQuery(describe);

                if (stmt.execute(describe)) {
                    resultset = stmt.getResultSet();
                }   

                while (resultset.next()) {
                    fields[a] = (resultset.getString("Field"));
                    a++;
                }
                return fields;
            }
            catch (SQLException ex){
                JOptionPane.showMessageDialog(null,ex);
                JOptionPane.showMessageDialog(null,"Database name must only consist of one word");
                JOptionPane.showMessageDialog(null,"Please create another database with one-word name");
                ex.printStackTrace();
            }
            finally {
                // release resources
                if (resultset != null) {
                    try {
                        resultset.close();
                    } 
                    catch (SQLException sqlEx) { }
                
                    resultset = null;
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
                }
            }
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Can't connect to the database");
            throw new IllegalStateException(e);
        }
        
        return null;
    }
    
    private void CreateAcc(String[] col, String tbname, String d1, String d2, String d3, String d4, String d5, String d6, String d7, String d8){
        
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            
            String UpdateQuery = "INSERT INTO `"+ tbname +"` (`Entry number`, `"+ col[1] +"`, `"+ col[2] +"`, `"+ col[3] +"`, `"+ col[4] +"`, `"+ col[5] +"`, `"+ col[6] +"`, `"+ col[7] +"`, `"+ col[8] +"`) VALUES (NULL, '"+ d1 +"', '"+ d2 +"', '"+ d3 +"', '"+ d4 +"', '"+ d5 +"', '"+ d6 +"', '"+ d7 +"', '"+ d8 +"');";
            String initdbquery = "USE account_management_system;";
            Statement stmt = null;
            Statement db = null;
            
            try {
                stmt = con.createStatement();
                db = con.createStatement();
                db.execute(initdbquery);
                stmt.execute(UpdateQuery);

                JOptionPane.showMessageDialog(null,"Account has been created.");
            }
            catch (SQLException ex){
                JOptionPane.showMessageDialog(null,ex);
                JOptionPane.showMessageDialog(null,"Please create or add another database");
                ex.printStackTrace();
            }
           
            finally {
                
                if (stmt != null) {
                    try {
                        stmt.close();
                    } 
                    catch (SQLException sqlEx) { 
                        sqlEx.printStackTrace();
                    }
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
        banner = new javax.swing.JLabel();
        f1 = new javax.swing.JLabel();
        f4 = new javax.swing.JLabel();
        f5 = new javax.swing.JLabel();
        f3 = new javax.swing.JLabel();
        f7 = new javax.swing.JLabel();
        f6 = new javax.swing.JLabel();
        f8 = new javax.swing.JLabel();
        f2 = new javax.swing.JLabel();
        textfieldF1 = new javax.swing.JTextField();
        textfieldF2 = new javax.swing.JTextField();
        textfieldF3 = new javax.swing.JTextField();
        textfieldF4 = new javax.swing.JTextField();
        textfieldF5 = new javax.swing.JTextField();
        textfieldF6 = new javax.swing.JTextField();
        textfieldF7 = new javax.swing.JTextField();
        textfieldF8 = new javax.swing.JTextField();
        regButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        banner.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        banner.setText("Register New Account");

        f1.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        f1.setText("field 1");

        f4.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        f4.setText("field 4");

        f5.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        f5.setText("field 5");

        f3.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        f3.setText("field 3");

        f7.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        f7.setText("field 7");

        f6.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        f6.setText("field 6");

        f8.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        f8.setText("field 8");

        f2.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        f2.setText("field 2");

        textfieldF1.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N

        textfieldF2.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N

        textfieldF3.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N

        textfieldF4.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N

        textfieldF5.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N

        textfieldF6.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N

        textfieldF7.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N

        textfieldF8.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N

        regButton.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        regButton.setText("Register");
        regButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regButtonMouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(140, 140, 140)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(banner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 518, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(regButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 198, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(f8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(textfieldF8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 345, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(f7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 167, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(textfieldF7))
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(f6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 167, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(textfieldF6))
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(f5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 167, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(textfieldF5))
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(f4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 167, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(textfieldF4))
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(f3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 167, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(textfieldF3))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                                .add(f2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(textfieldF2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 345, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(f1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 167, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(textfieldF1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 345, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .add(banner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(textfieldF1)
                            .add(f1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(18, 18, 18)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(textfieldF2)
                            .add(f2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(16, 16, 16)
                        .add(f3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(142, 142, 142)
                        .add(textfieldF3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 51, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(textfieldF4)
                    .add(f4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(textfieldF5)
                    .add(f5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(textfieldF6)
                    .add(f6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(textfieldF7)
                    .add(f7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(textfieldF8)
                    .add(f8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(regButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(44, 44, 44))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void regButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regButtonMouseClicked
        String data1, data2, data3, data4, data5, data6, data7, data8;
        String[] columnNames =  GetColumn();
        
        data1 = textfieldF1.getText();
        data2 = textfieldF2.getText();
        data3 = textfieldF3.getText();
        data4 = textfieldF4.getText();
        data5 = textfieldF5.getText();
        data6 = textfieldF6.getText();
        data7 = textfieldF7.getText();
        data8 = textfieldF8.getText();
        
        if(data1.equals("") || data2.equals("") || data3.equals("") || data4.equals("") || data5.equals("") || data6.equals("") || data7.equals("") || data8.equals("")){
            JOptionPane.showMessageDialog(null,"Some fields are missing.");
        }
        else{
            CreateAcc(columnNames, TBname, data1, data2, data3, data4, data5, data6, data7, data8);
        }
    }//GEN-LAST:event_regButtonMouseClicked

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
            java.util.logging.Logger.getLogger(CREATE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CREATE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CREATE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CREATE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CREATE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel banner;
    private javax.swing.JLabel f1;
    private javax.swing.JLabel f2;
    private javax.swing.JLabel f3;
    private javax.swing.JLabel f4;
    private javax.swing.JLabel f5;
    private javax.swing.JLabel f6;
    private javax.swing.JLabel f7;
    private javax.swing.JLabel f8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton regButton;
    private javax.swing.JTextField textfieldF1;
    private javax.swing.JTextField textfieldF2;
    private javax.swing.JTextField textfieldF3;
    private javax.swing.JTextField textfieldF4;
    private javax.swing.JTextField textfieldF5;
    private javax.swing.JTextField textfieldF6;
    private javax.swing.JTextField textfieldF7;
    private javax.swing.JTextField textfieldF8;
    // End of variables declaration//GEN-END:variables
}
