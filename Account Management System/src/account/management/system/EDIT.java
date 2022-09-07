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
public class EDIT extends javax.swing.JFrame {
    String url = "jdbc:mysql://localhost:3306";
    String username = "root";
    String password = "";
    String TBname;
    String EntryNum;
    
    
    
    /**
     * Creates new form EDIT
     */
    public EDIT() {
        initComponents();
    }
    
    public EDIT(String tbname, String entrynum) {
        TBname = tbname;
        EntryNum = entrynum;
        initComponents();
        checkCon();
        initForms();
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
    
    private void initForms(){
        
        String[] Colnames =  GetColumn();
        String[] Accdata = getdata(Colnames);
        
        f1.setText(Colnames[1]);
        textfieldDBf1.setText(Accdata[1]);
        
        f2.setText(Colnames[2]);
        textfieldDBf2.setText(Accdata[2]);
        
        f3.setText(Colnames[3]);
        textfieldDBf3.setText(Accdata[3]);
        
        f4.setText(Colnames[4]);
        textfieldDBf4.setText(Accdata[4]);
        
        f5.setText(Colnames[5]);
        textfieldDBf5.setText(Accdata[5]);
        
        f6.setText(Colnames[6]);
        textfieldDBf6.setText(Accdata[6]);
        
        f7.setText(Colnames[7]);
        textfieldDBf7.setText(Accdata[7]);
        
        f8.setText(Colnames[8]);
        textfieldDBf8.setText(Accdata[8]);
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
                // handle any errors
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
    
    private String[] getdata(String[] arr){
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            Statement db = null;
            Statement stmt = null;
            ResultSet resultset = null;
            String initdbquery = "USE account_management_system;";
            String statement = "SELECT * FROM `" + TBname + "` WHERE `Entry number` = " + EntryNum + ";";
            String[] fields = new String[9];
           

            try {
                db = con.createStatement();
                stmt = con.createStatement();
                db.execute(initdbquery);
                resultset = stmt.executeQuery(statement);

                if (stmt.execute(statement)) {
                    resultset = stmt.getResultSet();
                }   

                if (resultset.next()) {
                    fields[0] = (resultset.getString(arr[0]));
                    fields[1] = (resultset.getString(arr[1]));
                    fields[2] = (resultset.getString(arr[2]));
                    fields[3] = (resultset.getString(arr[3]));
                    fields[4] = (resultset.getString(arr[4]));
                    fields[5] = (resultset.getString(arr[5]));
                    fields[6] = (resultset.getString(arr[6]));
                    fields[7] = (resultset.getString(arr[7]));
                    fields[8] = (resultset.getString(arr[8]));
                }
                
                return fields;
            }
            catch (SQLException ex){
                // handle any errors
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
    
    private void UpdateAcc(String[] col, String d1, String d2, String d3, String d4, String d5, String d6, String d7, String d8){
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            
            String UpdateQuery = "UPDATE `" + TBname + "` SET `" + col[1] + "` = '" + d1 + "', `" + col[2] + "` = '" + d2 + "', `" + col[3] + "` = '" + d3 + "', `" + col[4] + "` = '" + d4 + "', `" + col[5] + "` = '" + d5 + "', `" + col[6] + "` = '" + d6 + "', `" + col[7] + "` = '" + d7 + "', `" + col[8] + "` = '" + d8 + "' WHERE `" + TBname + "`.`Entry number` = "+ EntryNum +";";
            String initdbquery = "USE account_management_system;";
            Statement stmt = null;
            Statement db;
            
            try {
                stmt = con.createStatement();
                db = con.createStatement();
                db.execute(initdbquery);
                stmt.execute(UpdateQuery);

                JOptionPane.showMessageDialog(null,"Account number " + EntryNum + " datas are updated successfully.");
            }
            catch (SQLException ex){
                JOptionPane.showMessageDialog(null,"There's an error occured.");
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
        jPanel2 = new javax.swing.JPanel();
        banner = new javax.swing.JLabel();
        f1 = new javax.swing.JLabel();
        f4 = new javax.swing.JLabel();
        f5 = new javax.swing.JLabel();
        f3 = new javax.swing.JLabel();
        f7 = new javax.swing.JLabel();
        f6 = new javax.swing.JLabel();
        f8 = new javax.swing.JLabel();
        f2 = new javax.swing.JLabel();
        textfieldDBf1 = new javax.swing.JTextField();
        textfieldDBf2 = new javax.swing.JTextField();
        textfieldDBf3 = new javax.swing.JTextField();
        textfieldDBf4 = new javax.swing.JTextField();
        textfieldDBf5 = new javax.swing.JTextField();
        textfieldDBf6 = new javax.swing.JTextField();
        textfieldDBf7 = new javax.swing.JTextField();
        textfieldDBf8 = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        banner.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        banner.setText("Update account information");

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

        textfieldDBf1.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N

        textfieldDBf2.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N

        textfieldDBf3.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N

        textfieldDBf4.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N

        textfieldDBf5.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N

        textfieldDBf6.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N

        textfieldDBf7.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N

        textfieldDBf8.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N

        updateButton.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        updateButton.setText("Update Account");
        updateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateButtonMouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(banner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 642, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(updateButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 198, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jPanel2Layout.createSequentialGroup()
                            .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(f8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 174, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, f7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, f6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, f5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, f4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, f3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, f2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, f1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 174, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                .add(textfieldDBf5)
                                .add(textfieldDBf1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 345, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(textfieldDBf3)
                                .add(textfieldDBf4)
                                .add(textfieldDBf7)
                                .add(textfieldDBf6)
                                .add(textfieldDBf2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 345, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(textfieldDBf8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 345, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                .add(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .add(banner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(textfieldDBf1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(f1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(f2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(textfieldDBf2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(15, 15, 15)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(f3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(textfieldDBf3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 51, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(18, 18, 18)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(f4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(textfieldDBf4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(18, 18, 18)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(f5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(textfieldDBf5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(18, 18, 18)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(f6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(textfieldDBf6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(18, 18, 18)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(f7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(textfieldDBf7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(18, 18, 18)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(f8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(textfieldDBf8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .add(18, 18, 18)
                .add(updateButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(43, 43, 43))
        );

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void updateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseClicked
        String data1, data2, data3, data4, data5, data6, data7, data8;
        String[] columnNames =  GetColumn();
        
        data1 = textfieldDBf1.getText();
        data2 = textfieldDBf2.getText();
        data3 = textfieldDBf3.getText();
        data4 = textfieldDBf4.getText();
        data5 = textfieldDBf5.getText();
        data6 = textfieldDBf6.getText();
        data7 = textfieldDBf7.getText();
        data8 = textfieldDBf8.getText();
        
        if(data1.equals("") || data2.equals("") || data3.equals("") || data4.equals("") || data5.equals("") || data6.equals("") || data7.equals("") || data8.equals("")){
            JOptionPane.showMessageDialog(null,"Some fields are missing.");
        }
        else{
            UpdateAcc(columnNames, data1, data2, data3, data4, data5, data6, data7, data8);
        }
    }//GEN-LAST:event_updateButtonMouseClicked

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
            java.util.logging.Logger.getLogger(EDIT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EDIT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EDIT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EDIT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EDIT().setVisible(true);
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField textfieldDBf1;
    private javax.swing.JTextField textfieldDBf2;
    private javax.swing.JTextField textfieldDBf3;
    private javax.swing.JTextField textfieldDBf4;
    private javax.swing.JTextField textfieldDBf5;
    private javax.swing.JTextField textfieldDBf6;
    private javax.swing.JTextField textfieldDBf7;
    private javax.swing.JTextField textfieldDBf8;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
