/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package library_system;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;

/**
 *
 * @author carli
 */
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class ReturnBook extends javax.swing.JFrame {

    /**
     * Creates new form Category
     */
    public ReturnBook() {
        initComponents();
        Connect();
        DisplayReturnBookData();
        
    }
    

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    //CONNECTION
    public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/library_system","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    
    // DISPLAY DATA TO JTABLE
    public void DisplayReturnBookData(){
        int c;
        try {
            // PLOT
            //JOIN TABLE BOOK-AUTHOR-CATEGORY-PUBLISHER
            pst = con.prepareStatement("select * from returnbook");
            rs = pst.executeQuery();
            
            //COLUMN
            ResultSetMetaData rsmd = rs.getMetaData();
            c = rsmd.getColumnCount();
            
            //ROW
            DefaultTableModel d = (DefaultTableModel)returnTable.getModel();
            d.setRowCount(0);
            
            while(rs.next())
            {
                Vector v = new Vector();
                
                for(int i = 1; i <= c; i++){
                    v.add(rs.getString("id"));
                    v.add(rs.getString("member_id"));
                    v.add(rs.getString("member_name"));
                    v.add(rs.getString("book_name"));
                    v.add(rs.getString("return_date"));
                    v.add(rs.getString("days"));
                    v.add(rs.getString("fine"));
                }
                d.addRow(v);
            } 
            
        } catch (SQLException ex) {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        returnTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtFine = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        returnBookBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        cancelCategory = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtRDate = new javax.swing.JLabel();
        txtMName = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDays = new javax.swing.JTextField();
        txtMemberId = new javax.swing.JTextField();
        txtBook = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Return Book");

        returnTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Member ID", "Member Name", "Book Name", "Return Date", "Days", "Fine"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        returnTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(returnTable);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 0));
        jLabel2.setText("Member ID:");

        txtFine.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFineKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 0));
        jLabel3.setText("Member Name:");

        returnBookBtn.setBackground(new java.awt.Color(204, 204, 204));
        returnBookBtn.setText("RETURN BOOK");
        returnBookBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        returnBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBookBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(204, 204, 204));
        deleteBtn.setText("DELETE");
        deleteBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        cancelCategory.setBackground(new java.awt.Color(204, 204, 204));
        cancelCategory.setText("CANCEL");
        cancelCategory.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cancelCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelCategoryActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 255, 0));
        jLabel4.setText("Book:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 255, 0));
        jLabel6.setText("Return Date:");

        txtRDate.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtRDate.setForeground(new java.awt.Color(255, 102, 255));
        txtRDate.setText("Return Date");

        txtMName.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtMName.setForeground(new java.awt.Color(255, 102, 255));
        txtMName.setText("Member Name");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 255, 0));
        jLabel9.setText("Fine:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 255, 0));
        jLabel10.setText("Days:");

        txtDays.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDaysKeyPressed(evt);
            }
        });

        txtMemberId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMemberIdKeyPressed(evt);
            }
        });

        txtBook.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        txtBook.setForeground(new java.awt.Color(255, 102, 255));
        txtBook.setText("Book Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(343, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(268, 268, 268))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(returnBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFine, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                    .addComponent(txtDays, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                    .addComponent(txtMemberId, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                                .addGap(0, 48, Short.MAX_VALUE))
                            .addComponent(txtBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtRDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMemberId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtMName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtBook, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtRDate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtDays, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtFine, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(returnBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // BORROW BOOK BUTTON
    private void returnBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBookBtnActionPerformed
        // TODO add your handling code here:
        String memberId = txtMemberId.getText();
        String memberName = txtMName.getText();
        String bookName = txtBook.getText();
        String returnDate = txtRDate.getText();
        String days = txtDays.getText();
        String fine = txtFine.getText();
        
        
        
        
        try {
            pst = con.prepareStatement("insert into returnbook(member_id,member_name,book_name,return_date, days, fine)values(?,?,?,?,?,?)");
            pst.setString(1,memberId);
            pst.setString(2,memberName);
            pst.setString(3,bookName);
            pst.setString(4, returnDate);
            pst.setString(5, days);
            pst.setString(6,fine);
           
            //PRIMARY KEY
            int k = pst.executeUpdate();
            
            // DELETE DATA FROM BORROW BOOK TABLE AFTER BOOK RETURN
            pst = con.prepareStatement("delete from borrowbook where member_id = ?");
            pst.setString(1,memberId);
            pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this,"Book Returned Succesfully");
                txtMemberId.setText("");
                txtMName.setText("");
                txtBook.setText("");
                txtRDate.setText("");
                txtDays.setText("");
                txtFine.setText("");
                txtMemberId.requestFocus();
                
                DisplayReturnBookData();
            }else
            {
                JOptionPane.showMessageDialog(this,"Error");
            }      
        } catch (SQLException ex)
        {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_returnBookBtnActionPerformed

    // TABLE
    private void returnTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)returnTable.getModel();
        int selectIndex = returnTable.getSelectedRow();
        
        //GET BY ID
        int id = Integer.parseInt(model.getValueAt(selectIndex,0).toString());
        
        txtMemberId.setText(model.getValueAt(selectIndex,1).toString());
        txtMName.setText(model.getValueAt(selectIndex,2).toString());
        txtBook.setText(model.getValueAt(selectIndex,3).toString());
        txtRDate.setText(model.getValueAt(selectIndex,4).toString());
        txtDays.setText(model.getValueAt(selectIndex,5).toString());
        txtFine.setText(model.getValueAt(selectIndex,6).toString());     
        
        
        // RESTRIC ADD BUTTON
        returnBookBtn.setEnabled(false);
        
    }//GEN-LAST:event_returnTableMouseClicked

    // DELETE AUTHOR
    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)returnTable.getModel();
        int selectIndex = returnTable.getSelectedRow();
        
        //GET BY ID
        int id = Integer.parseInt(model.getValueAt(selectIndex,0).toString());
       
        
        try {
            pst = con.prepareStatement("delete from returnbook where id = ?");
            pst.setInt(1,id);
            
            //PRIMARY KEY
            int k = pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this,"Return Book Deleted Succesfully");
                txtMemberId.setText("");
                txtMName.setText("");
                txtBook.setText("");
                txtRDate.setText("");
                txtDays.setText("");
                txtFine.setText("");
                txtMemberId.requestFocus();
                DisplayReturnBookData();
                // RESTRICT ADD BUTTON
                returnBookBtn.setEnabled(true);
            }else
            {
                JOptionPane.showMessageDialog(this,"Error");
            }      
        } catch (SQLException ex)
        {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void cancelCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelCategoryActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_cancelCategoryActionPerformed

    private void txtFineKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFineKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtFineKeyPressed

    private void txtDaysKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDaysKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDaysKeyPressed

    private void txtMemberIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMemberIdKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            String memberId = txtMemberId.getText();
            try {
                pst = con.prepareStatement("select CONCAT(m.first_name,' ', m.last_name) as member_name, b.book_name, bb.return_date, DATEDIFF(now(),bb.return_date) as days from borrowbook bb JOIN member m ON bb.member_id = m.id JOIN book b ON bb.book_id = b.id and bb.member_id = ?");
                pst.setString(1, memberId);
                rs = pst.executeQuery();
                
                if(rs.next() == false)
                {
                    JOptionPane.showMessageDialog(this,"Member not found");
                }
                else
                {
                    String memberFullName = rs.getString("member_name");
                    String bookName = rs.getString("b.book_name");
                    String returnDate = rs.getString("bb.return_date");
                    txtMName.setText(memberFullName.trim());
                    txtBook.setText(bookName.trim());
                    txtRDate.setText(returnDate.trim());
                    // CALCULATED DAYS
                    String days = rs.getString("days");
                    int numberOfDays = Integer.parseInt(days);
                    if(numberOfDays > 0){
                        txtDays.setText(days);
                        int fine = numberOfDays * 100;
                        txtFine.setText(String.valueOf(fine));
                    }
                    else
                    {
                        txtDays.setText("0");
                        txtFine.setText("0");
                    }
                    
                    
                }
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }//GEN-LAST:event_txtMemberIdKeyPressed

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
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelCategory;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton returnBookBtn;
    private javax.swing.JTable returnTable;
    private javax.swing.JLabel txtBook;
    private javax.swing.JTextField txtDays;
    private javax.swing.JTextField txtFine;
    private javax.swing.JLabel txtMName;
    private javax.swing.JTextField txtMemberId;
    private javax.swing.JLabel txtRDate;
    // End of variables declaration//GEN-END:variables
}
