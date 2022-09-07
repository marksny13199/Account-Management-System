package account.management.system;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class VEIW extends javax.swing.JFrame {
    String url = "jdbc:mysql://localhost:3306";
    String username = "root";
    String password = "";
    String TBname;
    String data1, data2, data3, data4, data5, data6, data7, data8, data9;
    
    /**
     * Creates new form VEIW
     */
    
    public VEIW() {
        initComponents();
        
    }
    
    public VEIW(String dbname) {
        initComponents();
        checkCon();
        TBname = dbname;
        initTable();   
    }
    
    public VEIW(String d1, String d2, String d3, String d4, String d5, String d6, String d7, String d8, String d9) {
       data1 = d1;
       data2 = d2;
       data3 = d3;
       data4 = d4;
       data5 = d5;
       data6 = d6;
       data7 = d7;
       data8 = d8;
       data9 = d9;
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
    
    private void initTable(){
        
        
        DefaultTableModel model = (DefaultTableModel) accTable.getModel();
        String[] colName = GetColumn();
        
        model.setRowCount(0);
        
        model.addColumn("Account number");
        model.addColumn(colName[1]);
        model.addColumn(colName[2]);
        model.addColumn(colName[3]);
        model.addColumn(colName[4]);
        model.addColumn(colName[5]);
        model.addColumn(colName[6]);
        model.addColumn(colName[7]);
        model.addColumn(colName[8]);
        
        Object[] rowData = new Object[9];
        
        for(int a = 0; a < getData(colName).size(); a++){
            rowData[0] = getData(colName).get(a).data1;
            rowData[1] = getData(colName).get(a).data2;
            rowData[2] = getData(colName).get(a).data3;
            rowData[3] = getData(colName).get(a).data4;
            rowData[4] = getData(colName).get(a).data5;
            rowData[5] = getData(colName).get(a).data6;
            rowData[6] = getData(colName).get(a).data7;
            rowData[7] = getData(colName).get(a).data8;
            rowData[8] = getData(colName).get(a).data9;
            
            model.addRow(rowData);
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
    
    private ArrayList<VEIW> getData(String[] colname){
        ArrayList<VEIW> data = new ArrayList<VEIW>();
        
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            Statement db;
            Statement stmt = null;
            ResultSet resultset = null;
            String initdbquery = "USE account_management_system;";
            String statement = "SELECT * FROM `" + TBname + ";";
            VEIW fields;
           

            try {
                db = con.createStatement();
                stmt = con.createStatement();
                db.execute(initdbquery);
                resultset = stmt.executeQuery(statement);

                if (stmt.execute(statement)) {
                    resultset = stmt.getResultSet();
                }   

                while (resultset.next()) {
                    fields = new VEIW(
                            resultset.getString(colname[0]), resultset.getString(colname[1]), resultset.getString(colname[2]), resultset.getString(colname[3]), 
                            resultset.getString(colname[4]), resultset.getString(colname[5]), resultset.getString(colname[6]), resultset.getString(colname[7]), 
                            resultset.getString(colname[8])
                    );
                    data.add(fields);
                }
                
                return data;
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
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        accTable = new javax.swing.JTable();
        accnumField = new javax.swing.JTextField();
        editButton = new javax.swing.JButton();
        delButton = new javax.swing.JButton();
        banner = new javax.swing.JLabel();
        fieldBanner = new javax.swing.JLabel();
        RefreshTable = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        accTable.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        accTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        accTable.setMinimumSize(new java.awt.Dimension(15, 1080));
        accTable.setRowHeight(48);
        accTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(accTable);
        accTable.getAccessibleContext().setAccessibleDescription("");

        accnumField.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N

        editButton.setText("Manage");
        editButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editButtonMouseClicked(evt);
            }
        });

        delButton.setText("Delete");
        delButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delButtonMouseClicked(evt);
            }
        });

        banner.setFont(new java.awt.Font("Impact", 1, 48)); // NOI18N
        banner.setText("Account List");

        fieldBanner.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        fieldBanner.setText("Account number:");

        RefreshTable.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        RefreshTable.setText("Refresh Table");
        RefreshTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RefreshTableMouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(26, 26, 26)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(RefreshTable, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 135, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 407, Short.MAX_VALUE)
                                .add(fieldBanner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 155, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(accnumField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 232, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(editButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 121, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(delButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 121, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(banner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 296, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(0, 18, Short.MAX_VALUE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPane1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(37, 37, 37)
                .add(banner, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(accnumField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(editButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(delButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(fieldBanner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(RefreshTable, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(25, 25, 25)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 601, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void editButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editButtonMouseClicked
         String searchData = accnumField.getText();
        
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            Statement db = null;
            Statement stmt = null;
            ResultSet resultset = null;
            String initdbquery = "USE account_management_system;";
            String query = "SELECT * FROM `" + TBname + "` WHERE `Entry number` = " + searchData + ";";

            try {
                db = con.createStatement();
                stmt = con.createStatement();
                db.execute(initdbquery);
                resultset = stmt.executeQuery(query);
                
                if(stmt.execute(query)){
                    resultset = stmt.getResultSet();
                }
                
                if(resultset.next()){
                   new EDIT(TBname, searchData).setVisible(true);  
                }
                else{
                   JOptionPane.showMessageDialog(null,"Entry " + searchData + " not found."); 
                }
                
            }
            catch (SQLException ex){
                // handle any errors
                JOptionPane.showMessageDialog(null,"Entry " + searchData + " not found.");
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
    }//GEN-LAST:event_editButtonMouseClicked

    private void RefreshTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RefreshTableMouseClicked
        new VEIW(TBname).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RefreshTableMouseClicked

    private void delButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delButtonMouseClicked
        String searchData = accnumField.getText();
        
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            Statement db = null;
            Statement stmt = null;
            String initdbquery = "USE account_management_system;";
            String query = "DELETE FROM `" + TBname + "` WHERE `" + TBname + "`.`Entry number` = " + searchData + ";";

            try {
                db = con.createStatement();
                stmt = con.createStatement();
                db.execute(initdbquery);
                stmt.execute(query);
                
                JOptionPane.showMessageDialog(null,"Entry '" + searchData + "' data has deleted .");
            }
            catch (SQLException ex){
                // handle any errors
                JOptionPane.showMessageDialog(null,"Entry " + searchData + " not found.");
                ex.printStackTrace();
            }
            finally {
                if (db != null) {
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
                    }
                }
            } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Can't connect to the database");
            throw new IllegalStateException(e);
        }
    }//GEN-LAST:event_delButtonMouseClicked

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
            java.util.logging.Logger.getLogger(VEIW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VEIW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VEIW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VEIW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VEIW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RefreshTable;
    private javax.swing.JTable accTable;
    private javax.swing.JTextField accnumField;
    private javax.swing.JLabel banner;
    private javax.swing.JButton delButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel fieldBanner;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
