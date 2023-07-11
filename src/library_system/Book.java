/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package library_system;

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
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class Book extends javax.swing.JFrame {

    /**
     * Creates new form Category
     */
    public Book() {
        initComponents();
        Connect();
        DisplayBookData();
        AuthorBox();
        CategoryBox();
        PublisherBox();
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
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    // AUTHOR ITEM
    public class AuthorItem
    {
        int id;
        String authorFirstName;
        String authorLastName;
        
        public AuthorItem(int id, String authorFirstName, String authorLastName)
        {
            this.id = id;
            this.authorFirstName = authorFirstName;
            this.authorLastName = authorLastName;
        }
        
        public String toString()
        {
            return authorFirstName + ' ' + authorLastName;
        }    
    }
    
  
    // CATEGORY ITEM
    public class CategoryItem
    {
        int id;
        String categoryName;
        
        public CategoryItem(int id, String categoryName)
        {
            this.id = id;
            this.categoryName = categoryName;
        }
        
        public String toString()
        {
            return categoryName;
        }    
    }
    // PUBLISHER ITEM
    public class PublisherItem
    {
        int id;
        String publisherFirstName;
        String publisherLastName;
        
        public PublisherItem(int id, String publisherFirstName, String publisherLastName)
        {
            this.id = id;
            this.publisherFirstName = publisherFirstName;
            this.publisherLastName = publisherLastName;
        }
        
        public String toString()
        {
            return publisherFirstName + ' ' + publisherLastName;
        }    
    }
  
    // AUTHOR COMBO BOX
    public void AuthorBox()
    {
        try {
            pst = con.prepareStatement("select * from author");
            rs = pst.executeQuery();
            //LOAD BOX
            txtAuthor.removeAllItems();
            while(rs.next())
            {
                txtAuthor.addItem(new AuthorItem(rs.getInt(1),rs.getString(2),rs.getString(3)));
            } 
        } catch (SQLException ex) 
        {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // CATEGORY COMBO BOX
    public void CategoryBox()
    {
        try {
            pst = con.prepareStatement("select * from category");
            rs = pst.executeQuery();
            //LOAD BOX
            txtCategory.removeAllItems();
            while(rs.next())
            {
                txtCategory.addItem(new CategoryItem(rs.getInt(1),rs.getString(2)));
            } 
        } catch (SQLException ex) 
        {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // PUBLISHER COMBO BOX
    public void PublisherBox()
    {
        try {
            pst = con.prepareStatement("select * from publisher");
            rs = pst.executeQuery();
            //LOAD BOX
            txtPublisher.removeAllItems();
            while(rs.next())
            {
                txtPublisher.addItem(new PublisherItem(rs.getInt(1),rs.getString(2), rs.getString(3)));
            } 
        } catch (SQLException ex) 
        {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    
    // DISPLAY DATA TO JTABLE
    public void DisplayBookData(){
        int c;
        try {
            // PLOT
            //JOIN TABLE BOOK-AUTHOR-CATEGORY-PUBLISHER
            pst = con.prepareStatement("select b.id, b.book_name, CONCAT(a.first_name,' ',a.last_name ) as author_full_name,c.category_name as category_name, CONCAT(p.first_name,' ',p.last_name) as publisher_full_name,b.edition  from book b JOIN author a ON b.author = a.id JOIN category c ON b.category = c.id JOIN publisher p ON b.publisher = p.id");
            rs = pst.executeQuery();
            
            //COLUMN
            ResultSetMetaData rsmd = rs.getMetaData();
            c = rsmd.getColumnCount();
            
            //ROW
            DefaultTableModel d = (DefaultTableModel)bookTable.getModel();
            d.setRowCount(0);
            
            while(rs.next())
            {
                Vector v = new Vector();
                
                for(int i = 1; i <= c; i++){
                    v.add(rs.getString("b.id"));
                    v.add(rs.getString("b.book_name"));
                    v.add(rs.getString("author_full_name"));
                    v.add(rs.getString("category_name"));
                    v.add(rs.getString("publisher_full_name"));
                    v.add(rs.getString("b.edition"));
                }
                d.addRow(v);
            } 
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
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
        bookTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtBookName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        cancelCategory = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEdition = new javax.swing.JTextField();
        txtPublisher = new javax.swing.JComboBox();
        txtCategory = new javax.swing.JComboBox();
        txtAuthor = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Book");

        bookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "book_name", "author", "category", "publisher", "Edition"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        bookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bookTable);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 0));
        jLabel2.setText("Name:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 0));
        jLabel3.setText("Author:");

        addBtn.setBackground(new java.awt.Color(204, 204, 204));
        addBtn.setText("ADD");
        addBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        updateBtn.setBackground(new java.awt.Color(204, 204, 204));
        updateBtn.setText("UPDATE");
        updateBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
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
        jLabel4.setText("Category:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 255, 0));
        jLabel5.setText("Publisher:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 255, 0));
        jLabel6.setText("Edition:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEdition, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(53, 53, 53)
                                .addComponent(txtBookName, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(132, 132, 132))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(268, 268, 268))
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
                            .addComponent(txtBookName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txtEdition, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
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

    // ADD BOOK BUTTON
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        String bookName = txtBookName.getText();
        AuthorItem authorItem = (AuthorItem)txtAuthor.getSelectedItem();
        CategoryItem categoryItem = (CategoryItem)txtCategory.getSelectedItem();
        PublisherItem publisherItem = (PublisherItem)txtPublisher.getSelectedItem();
        String edition = txtEdition.getText();
        
        if(bookName.isEmpty() || authorItem == null  || categoryItem == null || publisherItem == null || edition.isEmpty() ){
            JOptionPane.showMessageDialog(this,"All fields are required");
        }
        
        
        try {
            pst = con.prepareStatement("insert into Book(book_name,author,category,publisher,edition)values(?,?,?,?,?)");
            pst.setString(1,bookName);
            pst.setInt(2, authorItem.id);
            pst.setInt(3, categoryItem.id);
            pst.setInt(4, publisherItem.id);
            pst.setString(5,edition);
            //PRIMARY KEY
            int k = pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this,"Book Added Succesfully");
                txtBookName.setText("");
                txtAuthor.setSelectedIndex(-1);
                txtCategory.setSelectedIndex(-1);
                txtPublisher.setSelectedIndex(-1);
                txtEdition.setText("");
                DisplayBookData();
            }else
            {
                JOptionPane.showMessageDialog(this,"Error");
            }      
        } catch (SQLException ex)
        {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addBtnActionPerformed

    // TABLE
    private void bookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)bookTable.getModel();
        int selectIndex = bookTable.getSelectedRow();
        
        //GET BY ID
        int id = Integer.parseInt(model.getValueAt(selectIndex,0).toString());
        txtBookName.setText(model.getValueAt(selectIndex,1).toString());
        txtAuthor.setSelectedItem(model.getValueAt(selectIndex,2));
        txtCategory.setSelectedItem(model.getValueAt(selectIndex,3));
        txtPublisher.setSelectedItem(model.getValueAt(selectIndex,4));
        txtEdition.setText(model.getValueAt(selectIndex,5).toString());
        
        // RESTRIC ADD BUTTON
        addBtn.setEnabled(false);
        
    }//GEN-LAST:event_bookTableMouseClicked

    //UPDATE
    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel)bookTable.getModel();
        int selectIndex = bookTable.getSelectedRow();
        
        //GET BY ID
        int id = Integer.parseInt(model.getValueAt(selectIndex,0).toString());
        
         String bookName = txtBookName.getText();
        AuthorItem authorItem = (AuthorItem)txtAuthor.getSelectedItem();
        CategoryItem categoryItem = (CategoryItem)txtCategory.getSelectedItem();
        PublisherItem publisherItem = (PublisherItem)txtPublisher.getSelectedItem();
        String edition = txtEdition.getText();
        
        try {
            pst = con.prepareStatement("update book set book_name = ?, author = ?, category = ?, publisher = ?, edition = ? where id = ?");
            pst.setString(1,bookName);
            pst.setInt(2, authorItem.id);
            pst.setInt(3, categoryItem.id);
            pst.setInt(4, publisherItem.id);
            pst.setString(5,edition);
            pst.setInt(6,id);
            
            //PRIMARY KEY
            int k = pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this,"Book Updated Succesfully");
                txtBookName.setText("");
                txtAuthor.setSelectedIndex(-1);
                txtCategory.setSelectedIndex(-1);
                txtPublisher.setSelectedIndex(-1);
                txtEdition.setText("");
                txtBookName.requestFocus();
                DisplayBookData();
                // RESTRICT ADD BUTTON
                addBtn.setEnabled(true);
            }else
            {
                JOptionPane.showMessageDialog(this,"Error");
            }      
        } catch (SQLException ex)
        {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_updateBtnActionPerformed

    // DELETE AUTHOR
    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)bookTable.getModel();
        int selectIndex = bookTable.getSelectedRow();
        
        //GET BY ID
        int id = Integer.parseInt(model.getValueAt(selectIndex,0).toString());
       
        
        try {
            pst = con.prepareStatement("delete from book where id = ?");
            pst.setInt(1,id);
            
            //PRIMARY KEY
            int k = pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this,"Book Deleted Succesfully");
                txtBookName.setText("");
                txtAuthor.setSelectedIndex(-1);
                txtCategory.setSelectedIndex(-1);
                txtPublisher.setSelectedIndex(-1);
                txtEdition.setText("");
                txtBookName.requestFocus();
                DisplayBookData();
                // RESTRICT ADD BUTTON
                addBtn.setEnabled(true);
            }else
            {
                JOptionPane.showMessageDialog(this,"Error");
            }      
        } catch (SQLException ex)
        {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void cancelCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelCategoryActionPerformed
        // TODO add your handling code here:
        dispose();
        Main m = new Main();
        m.setVisible(true);
    }//GEN-LAST:event_cancelCategoryActionPerformed

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
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Book().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTable bookTable;
    private javax.swing.JButton cancelCategory;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox txtAuthor;
    private javax.swing.JTextField txtBookName;
    private javax.swing.JComboBox txtCategory;
    private javax.swing.JTextField txtEdition;
    private javax.swing.JComboBox txtPublisher;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
