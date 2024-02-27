


import java.sql.Connection;
import java.sql.*;
import javax.swing.JOptionPane;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author User
 */
public class ReturnBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public ReturnBook() {
        initComponents();
    }
//to fetch the issue book details from database and display it to panel
    public  void getIssueBookDetails(){
        
        int bookId=Integer.parseInt(txt_bookId.getText());
        int studentId=Integer.parseInt(txt_studentId.getText());
        try{
            Connection con=dbconnection.con();
            String sql=("select * from issue_book_details where book_id=? and student_id=? and status=?");
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,bookId);
            pst.setInt(2,studentId);
            pst.setString(3,"pending");
        ResultSet rs=pst.executeQuery();
                if(rs.next()){
                      
                      lbl_issueId.setText(rs.getString("id"));
                      lbl_bookName.setText(rs.getString("book_name"));
                      lbl_studentName.setText(rs.getString("student_name"));
                      lbl_issueDate.setText(rs.getString("issue_date"));
                      lbl_dueDate.setText(rs.getString("due_date"));
                      lbl_bookError.setText("");
                  }
                  else{
                    lbl_bookError.setText("No Record Found");
                      lbl_issueId.setText("");
                      lbl_bookName.setText("");
                      lbl_studentName.setText("");
                      lbl_issueDate.setText("");
                      lbl_dueDate.setText("");
                      
                  }     
                   
               
               
         }
         catch(Exception e){
             e.printStackTrace();
             
         }
         
    }
    //return the book
    public boolean returnBook(){
        boolean isReturned=false;
         
        int bookId=Integer.parseInt(txt_bookId.getText());
        int studentId=Integer.parseInt(txt_studentId.getText());
          
         try{
             Connection con=dbconnection.con();
               String sql="update issue_book_details set status=? where student_id=? and book_id=? and status=?";
               PreparedStatement pst=con.prepareStatement(sql);
               
                pst.setString(1,"returned");
                 pst.setInt(2,studentId);
                  pst.setInt(3,bookId);
                   
                pst.setString(4,"pending");
                int rowCount=pst.executeUpdate();
                if(rowCount>0){
                      isReturned=true;
                  }
                  else{
                      isReturned=false;
                  }     
                   
               
               
         }
         catch(Exception e){
             e.printStackTrace();
             
         }
         return isReturned;
        
        
        
    }
    
    //updating book count
    public void updateBookCount(){
    
        int bookId=Integer.parseInt(txt_bookId.getText());
        try{
            Connection con=dbconnection.con();
            String sql=("update book_details set quantity=quantity+1 where book_id=?");
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,bookId);
            int rowCount=pst.executeUpdate();
                if(rowCount>0){
                      JOptionPane.showMessageDialog(this,"Book Count Updated");
                      
                  }
                  else{
                      JOptionPane.showMessageDialog(this,"Can't Update Book Count");
                  }     
            
    }
        catch(Exception e){
            e.printStackTrace();
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

        panel_main = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbl_bookError = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_issueId = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        lbl_issueDate = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_dueDate = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
        txt_studentId = new app.bolivia.swing.JCTextField();
        jLabel26 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        jPanel10 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(new java.awt.Color(255, 255, 255));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Downloads\\AddNewBookIcons\\icons8_Literature_100px_1.png")); // NOI18N
        jLabel13.setText("  Book Details");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 280, 110));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 340, 5));

        lbl_bookError.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(204, 204, 0));
        jPanel4.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 550, 230, 30));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Issue Id :");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 90, 30));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Book Name :");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 120, 30));

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Student Name :");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 140, 30));

        lbl_issueId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_issueId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_issueId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 160, 30));
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 180, 30));

        lbl_bookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 160, 30));

        lbl_studentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 160, 30));

        lbl_issueDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, 150, 30));

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Due Date :");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 110, 30));

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Issue Date :");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 110, 30));

        lbl_dueDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 516, 160, 30));

        panel_main.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 350, 650));

        jPanel7.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        panel_main.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 170, 290, 5));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Downloads\\AddNewBookIcons\\icons8_Books_52px_1.png")); // NOI18N
        jLabel7.setText("  Return Book");
        panel_main.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 100, 230, 50));

        jPanel8.setBackground(new java.awt.Color(255, 51, 51));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        panel_main.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 0, 50, 40));

        jLabel24.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 51, 51));
        jLabel24.setText("Book Id :");
        panel_main.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 280, 100, 40));

        jPanel9.setBackground(new java.awt.Color(0, 51, 255));

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("X");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        panel_main.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1880, 140, 50, -1));

        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 1, new java.awt.Color(255, 51, 51)));
        txt_bookId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_bookId.setPlaceholder("Enter Book Id");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        panel_main.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 280, 230, -1));

        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 1, new java.awt.Color(255, 51, 51)));
        txt_studentId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_studentId.setPlaceholder("Enter Student Id");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        panel_main.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 340, 230, -1));

        jLabel26.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 51, 51));
        jLabel26.setText("Student Id :");
        panel_main.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 340, 100, 40));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle1.setText("Return Book");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        panel_main.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 470, 280, 50));

        jPanel10.setBackground(new java.awt.Color(102, 102, 255));

        jLabel14.setBackground(new java.awt.Color(102, 102, 255));
        jLabel14.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Downloads\\AddNewBookIcons\\icons8_Rewind_48px.png")); // NOI18N
        jLabel14.setText("Back");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addGap(0, 7, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        panel_main.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(102, 102, 255));
        rSMaterialButtonCircle2.setText("FIND");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        panel_main.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 410, 290, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Downloads\\icons\\library-2.png")); // NOI18N
        panel_main.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 70, 700, 530));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 650));

        setSize(new java.awt.Dimension(1400, 650));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost

    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
 
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
if(returnBook()==true){
            JOptionPane.showMessageDialog(this,"Book Returned Successfully");
            updateBookCount();
        }
        else{
            JOptionPane.showMessageDialog(this,"Failed To Return Book");
        }
              
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
         HomePage home=new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        getIssueBookDetails();
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_dueDate;
    private javax.swing.JLabel lbl_issueDate;
    private javax.swing.JLabel lbl_issueId;
    private javax.swing.JLabel lbl_studentName;
    private javax.swing.JPanel panel_main;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}