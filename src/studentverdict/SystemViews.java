/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentverdict;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author owner
 */
public class SystemViews extends javax.swing.JPanel {

    /**
     * Creates new form SystemViews
     */
    
             Statement st;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    String username = "root";
    String password = "";
    String url = "jdbc:mysql://localhost:3306/student_verdict";
    public SystemViews() {
        initComponents();
        loademptytable();
      //hidesearchtextedict();
    }
    
    
     final public void loademptytable(){
    DefaultTableModel stm = new DefaultTableModel();
    stm.addColumn("Loading...");
    stm.addColumn("Loading...");
    stm.addColumn("Loading...");
    stm.addColumn("Loading...");
    jtmytable.setModel(stm);
    }
     public void hidesearchtextedict(){
         txtsearchid.setVisible(false);
     }
     
     public void updatestudent(){
          String reg = null;
       int updatekey =  jtmytable.getRowCount();
       if(updatekey >= 1){
        
            try{

                         int rows=jtmytable.getRowCount();
                           
                           con = DriverManager.getConnection(url,username,password);
                           st = con.createStatement();
                          

                     String updatestudent = "UPDATE student set studentsurname = ? ,  studentothername = ?,   studentIDnumber = ?,  studentemail = ?, studentphone = ? WHERE studentREG = ? ";
                           pst = con.prepareStatement(updatestudent);
                     for(int row = 0; row<rows; row++)
                 { 
                             reg = (String)jtmytable.getValueAt(row, 0);
                              String surname = (String)jtmytable.getValueAt(row, 1);
                              String othername = (String)jtmytable.getValueAt(row, 2);
                              String idnumber = (String)jtmytable.getValueAt(row, 3);
                              String phone = (String)jtmytable.getValueAt(row, 4);
                              String email = (String)jtmytable.getValueAt(row, 5);
                            
                             
                              // bind pst 
                               pst.setString(1, surname);
                        pst.setString(2, othername);
                        pst.setString(3, idnumber);
                        pst.setString(4, email);
                        pst.setString(5, phone);
                        pst.setString(6, reg);
                        pst.addBatch();
                               }
           pst.executeUpdate();
         
          lbsystemviewaction.setText("<HTML><i style=\"color: green;\">'"+reg+"'  Details updated</i></HTML> ");
            }catch(SQLException ex ){
               // lbsystemviewaction.setText(ex.getMessage());
                JOptionPane.showMessageDialog(null, ex );
            }catch( NumberFormatException ex){
                lbsystemviewaction.setText("<HTML><i style=\"color: red;\">Press esc key first</i></HTML> "); 
            }
       }else{
           lbsystemviewaction.setText("<HTML><i style=\"color: red;\">Select categoty to update</i></HTML> ");
       }
     }
     
      public void updateviolation(){
          String idtoupdate = null;
       int updatekey =  jtmytable.getRowCount();
       if(updatekey >= 1){
        
            try{

                         int rows=jtmytable.getRowCount();
                           
                           con = DriverManager.getConnection(url,username,password);
                           st = con.createStatement();
                          

                     String updatestudent = "UPDATE violation set violationtype = ? ,  violationdescription = ?,   judgementID = ?,  violationname = ? WHERE violationID = ? ";
                           pst = con.prepareStatement(updatestudent);
                     for(int row = 0; row<rows; row++)
                 { 
                             idtoupdate = (String)jtmytable.getValueAt(row, 0);
                              String type = (String)jtmytable.getValueAt(row, 1);
                              String description = (String)jtmytable.getValueAt(row, 2);
                              String name = (String)jtmytable.getValueAt(row, 3);
                              String judgementid = (String)jtmytable.getValueAt(row, 4);
                              
                            
                             
                              // bind pst 
                               pst.setString(1, type);
                        pst.setString(2, description);
                        pst.setString(4, name);
                        pst.setString(3, judgementid);
                        pst.setString(5, idtoupdate);
                        
                        pst.addBatch();
                               }
           pst.executeUpdate();
         
          lbsystemviewaction.setText("<HTML><i style=\"color: green;\">'"+idtoupdate+"'  Details updated</i></HTML> ");
            }catch(SQLException ex ){
               // lbsystemviewaction.setText(ex.getMessage());
                JOptionPane.showMessageDialog(null, ex );
            }catch( NumberFormatException ex){
                lbsystemviewaction.setText("<HTML><i style=\"color: red;\">Press esc key first</i></HTML> "); 
            }
       }else{
           lbsystemviewaction.setText("<HTML><i style=\"color: red;\">Select categoty to update</i></HTML> ");
       }
     }
      
      
       public void updatejudgement(){
          String idtoupdate = null;
       int updatekey =  jtmytable.getRowCount();
       if(updatekey >= 1){
        
            try{

                         int rows=jtmytable.getRowCount();
                           
                           con = DriverManager.getConnection(url,username,password);
                           st = con.createStatement();
                          

                     String updatestudent = "UPDATE judgement set judgementtype = ? ,  judgementdescription = ?  WHERE judgementID = ? ";
                           pst = con.prepareStatement(updatestudent);
                     for(int row = 0; row<rows; row++)
                 { 
                             idtoupdate = (String)jtmytable.getValueAt(row, 0);
                              String type = (String)jtmytable.getValueAt(row, 1);
                              String description = (String)jtmytable.getValueAt(row, 2);
                           
                              
                            
                             
                              // bind pst 
                               pst.setString(1, type);
                        pst.setString(2, description);
                        pst.setString(3, idtoupdate);

                        
                        pst.addBatch();
                               }
           pst.executeUpdate();
         
          lbsystemviewaction.setText("<HTML><i style=\"color: green;\">'"+idtoupdate+"'  Details updated</i></HTML> ");
            }catch(SQLException ex ){
               // lbsystemviewaction.setText(ex.getMessage());
                JOptionPane.showMessageDialog(null, ex );
            }catch( NumberFormatException ex){
                lbsystemviewaction.setText("<HTML><i style=\"color: red;\">Press esc key first</i></HTML> "); 
            }
       }else{
           lbsystemviewaction.setText("<HTML><i style=\"color: red;\">Select categoty to update</i></HTML> ");
       }
     }
       
       
        public void updatestaff(){
          String idtoupdate = null;
       int updatekey =  jtmytable.getRowCount();
       if(updatekey >= 1){
        
            try{

                         int rows=jtmytable.getRowCount();
                           
                           con = DriverManager.getConnection(url,username,password);
                           st = con.createStatement();
                          

                     String updatestudent = "UPDATE staff set staffsurname = ? ,  staffothername = ? ,staffIDnumber = ? ,staffphone= ?,"
                             + " staffemail = ? WHERE staffID = ? ";
                           pst = con.prepareStatement(updatestudent);
                     for(int row = 0; row<rows; row++)
                 { 
                             idtoupdate = (String)jtmytable.getValueAt(row, 0);
                              String surname = (String)jtmytable.getValueAt(row, 1);
                              String othername = (String)jtmytable.getValueAt(row, 2);
                           String idnumber = (String)jtmytable.getValueAt(row, 3);
                              String phone = (String)jtmytable.getValueAt(row, 5);
                               String email = (String)jtmytable.getValueAt(row, 6);
                              
                            
                             
                              // bind pst 
                               pst.setString(1, surname);
                        pst.setString(2, othername);
                        pst.setString(3, idnumber);
                         pst.setString(4, phone);
                        pst.setString(5, email);
                        pst.setString(6, idtoupdate);

                        
                        pst.addBatch();
                               }
           pst.executeUpdate();
         
          lbsystemviewaction.setText("<HTML><i style=\"color: green;\">'"+idtoupdate+"'  Details updated</i></HTML> ");
            }catch(SQLException ex ){
               // lbsystemviewaction.setText(ex.getMessage());
                JOptionPane.showMessageDialog(null, ex );
            }catch( NumberFormatException ex){
                lbsystemviewaction.setText("<HTML><i style=\"color: red;\">Press esc key first</i></HTML> "); 
            }
       }else{
           lbsystemviewaction.setText("<HTML><i style=\"color: red;\">Select categoty to update</i></HTML> ");
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
        cmbcategory = new javax.swing.JComboBox<>();
        cmbselectrange = new javax.swing.JComboBox<>();
        txtsearchid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnupdatedetails = new javax.swing.JButton();
        btnrefreshtable = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnmastersearch = new javax.swing.JButton();
        lbsystemviewaction = new javax.swing.JLabel();
        lbbtnclose = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtmytable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setToolTipText("");
        jPanel1.setMinimumSize(new java.awt.Dimension(885, 157));

        cmbcategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category", "Evidence", "Violation", "Judgement", "Verdict", "Students", "Staff" }));
        cmbcategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbcategoryActionPerformed(evt);
            }
        });

        cmbselectrange.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select all", "Select Specific" }));
        cmbselectrange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbselectrangeMouseClicked(evt);
            }
        });
        cmbselectrange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbselectrangeActionPerformed(evt);
            }
        });

        txtsearchid.setToolTipText("Enter ID to search");
        txtsearchid.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("View and make any changes ");

        btnupdatedetails.setBackground(new java.awt.Color(0, 153, 153));
        btnupdatedetails.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnupdatedetails.setText("UPDATE");
        btnupdatedetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdatedetailsActionPerformed(evt);
            }
        });

        btnrefreshtable.setBackground(new java.awt.Color(255, 255, 255));
        btnrefreshtable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentverdict/Refresh-icon.png"))); // NOI18N
        btnrefreshtable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefreshtableActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 0, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("DELETE");

        btnmastersearch.setBackground(new java.awt.Color(0, 204, 102));
        btnmastersearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnmastersearch.setText("SEARCH");
        btnmastersearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmastersearchActionPerformed(evt);
            }
        });

        lbsystemviewaction.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lbsystemviewaction.setForeground(new java.awt.Color(0, 102, 204));
        lbsystemviewaction.setText("action");

        lbbtnclose.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbbtnclose.setForeground(new java.awt.Color(204, 0, 0));
        lbbtnclose.setText("X");
        lbbtnclose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbbtnclose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbbtncloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cmbcategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbselectrange, 0, 186, Short.MAX_VALUE))
                    .addComponent(txtsearchid, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnrefreshtable, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnmastersearch, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(btnupdatedetails, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(280, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbsystemviewaction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(234, 234, 234))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbbtnclose)
                        .addGap(18, 18, 18))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnrefreshtable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbbtnclose, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnmastersearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbselectrange, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnupdatedetails, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtsearchid, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbsystemviewaction, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)))))
                .addContainerGap())
        );

        jtmytable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtmytable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnupdatedetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdatedetailsActionPerformed
        // TODO add your handling code here:
    
      
       String tablname = cmbcategory.getSelectedItem().toString();
        if(      null == tablname){
            JOptionPane.showMessageDialog(null, "Select Category First");
        }else    switch (tablname) {
                     case "Students":
                          if(cmbselectrange.getSelectedIndex() == 0){
                              JOptionPane.showMessageDialog(null, "<HTML><i style=\"color: red; font-size: 12px;\">Select Specific option</i></HTML>","Student verdict",JOptionPane.WARNING_MESSAGE); 
                          }else{
                              updatestudent();
                          }
                         break;
                     case "Staff" :
                         if(cmbselectrange.getSelectedIndex() == 0){
                              JOptionPane.showMessageDialog(null, "<HTML><i style=\"color: red; font-size: 12px;\">Select Specific option</i></HTML>","Student verdict",JOptionPane.WARNING_MESSAGE); 
                          }else{
                            updatestaff();  
                          }
                         break;
                     case "Judgement" :
                         if(cmbselectrange.getSelectedIndex() == 0){
                              JOptionPane.showMessageDialog(null, "<HTML><i style=\"color: red; font-size: 12px;\">Select Specific option</i></HTML>","Student verdict",JOptionPane.WARNING_MESSAGE); 
                          }else{
                             updatejudgement(); 
                          }
                         break;
                     case "Violation" :
                         if(cmbselectrange.getSelectedIndex() == 0){
                              JOptionPane.showMessageDialog(null, "<HTML><i style=\"color: red; font-size: 12px;\">Select Specific option</i></HTML>","Student verdict",JOptionPane.WARNING_MESSAGE); 
                          }else{
                             updateviolation(); 
                          }
                         break;
                     default:
                         lbsystemviewaction.setText("<HTML><i style=\"color: blue;\">Please select category to update</i></HTML> ");
                          JOptionPane.showMessageDialog(null, "<HTML><i style=\"color: red; font-size: 12px;\">Please select category to update</i></HTML>","Student verdict",JOptionPane.WARNING_MESSAGE); 
                         break;
        }
         
    }//GEN-LAST:event_btnupdatedetailsActionPerformed

    private void cmbselectrangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbselectrangeActionPerformed
        // TODO add your handling code here:
        if(cmbselectrange.getSelectedIndex() == 1){
             txtsearchid.setEnabled(true);
             
        }else{
             txtsearchid.setEnabled(false);
        }
    }//GEN-LAST:event_cmbselectrangeActionPerformed

    private void cmbselectrangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbselectrangeMouseClicked
        // TODO add your handling code here:
        if(cmbselectrange.getSelectedIndex() == 1){
             txtsearchid.setEnabled(true);
             
        }else{
             txtsearchid.setEnabled(false);
        }
    }//GEN-LAST:event_cmbselectrangeMouseClicked

    private void btnmastersearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmastersearchActionPerformed
        // TODO add your handling code here:
        try{
             con = DriverManager.getConnection(url,username,password);
            st = con.createStatement();
        
        //System.out.print(cmbcategory.getSelectedItem());
        String tablname = cmbcategory.getSelectedItem().toString();
        if(      null == tablname){
            JOptionPane.showMessageDialog(null, "Select Category First");
        }else    switch (tablname) {
                     case "Evidence":
                         JOptionPane.showMessageDialog(null, "Select : " + cmbcategory.getSelectedItem());
                         // modify table
                         
                         DefaultTableModel stmevidence = new DefaultTableModel();
    
    stmevidence.addColumn("ID/serial");
    stmevidence.addColumn("Evidence Type");
    stmevidence.addColumn("Evidence Description");
    stmevidence.addColumn("Evidence Link");
    stmevidence.addColumn("Evidence Note");
    stmevidence.addColumn("Violation ID");
    stmevidence.addColumn("Student REG");
    stmevidence.addColumn("Date Added");
    jtmytable.setModel(stmevidence);
                         if(cmbselectrange.getSelectedIndex() == 0){
                            // JOptionPane.showMessageDialog(null, "Select all");
                             
                             String selecteevidence = "SELECT * FROM evidence  ";
            pst = con.prepareStatement(selecteevidence);
            rs = pst.executeQuery();
                  
            while(rs.next()){
               
               String id = rs.getString("evidenceID");
               String type = rs.getString("evidencetype");
               String description = rs.getString("evidencedescription");
               String link = rs.getString("evidencemedia");
               String note = rs.getString("evidencedocument");
               String violationid = rs.getString("violationID");
               String studentreg = rs.getString("studentREG");
               String dateadded = rs.getString("evidenceDOA");
      
               
               //ARRAY DATA TO DISPLAY
               String tbldata []= {id, type,description,link,note,violationid,studentreg,dateadded};
               DefaultTableModel dtmdata = (DefaultTableModel)jtmytable.getModel();
               dtmdata.addRow(tbldata);
               
              lbsystemviewaction.setText("<HTML><i style=\"color: red;\">Can not edit evidence only view</i></HTML> ");   
            }
                         }else{
                             //JOptionPane.showMessageDialog(null, "Enter id");
                              
                               String selectecar = "SELECT * FROM evidence WHERE evidenceID = ? ";
                               
            pst = con.prepareStatement(selectecar);
            pst.setString(1, (String) txtsearchid.getText());
            rs = pst.executeQuery();
                  
            if(rs.next()){
               
               String id = rs.getString("evidenceID");
               String type = rs.getString("evidencetype");
               String description = rs.getString("evidencedescription");
               String link = rs.getString("evidencemedia");
               String note = rs.getString("evidencedocument");
               String violationid = rs.getString("violationID");
               String studentreg = rs.getString("studentREG");
               String dateadded = rs.getString("evidenceDOA");
      
               
               //ARRAY DATA TO DISPLAY
               String tbldata []= {id, type,description,link,note,violationid,studentreg,dateadded};
               DefaultTableModel dtmdata = (DefaultTableModel)jtmytable.getModel();
               dtmdata.addRow(tbldata);
               
             lbsystemviewaction.setText("<HTML><i style=\"color: red;\">Can not edit evidence only view</i></HTML> "); 
            }else{
                 lbsystemviewaction.setText("<HTML><i style=\"color: red;\">EVidence ID not found</i></HTML> ");
                  JOptionPane.showMessageDialog(null, "<HTML><i style=\"color: red; font-size: 12px;\">Evidence ID not found</i></HTML>","Student verdict",JOptionPane.WARNING_MESSAGE);
            }
                  
                         }
                         break;
                     case "Staff":
                         JOptionPane.showMessageDialog(null, "Select : " + cmbcategory.getSelectedItem());
                         
                         DefaultTableModel stmstaff = new DefaultTableModel();
    
    stmstaff.addColumn("Number");
    stmstaff.addColumn("Surname");
    stmstaff.addColumn("Other Name");
    stmstaff.addColumn("ID Number");
    stmstaff.addColumn("Gender");
    stmstaff.addColumn("Phone");
    stmstaff.addColumn("Email addres");
    stmstaff.addColumn("Date of birth");
    stmstaff.addColumn("Staff Role");
    stmstaff.addColumn("Media Link");
    jtmytable.setModel(stmstaff);
    
    if(cmbselectrange.getSelectedIndex() == 0){
                            // JOptionPane.showMessageDialog(null, "Select all");
                             
                             String selectstaff = "SELECT * FROM staff  ";
            pst = con.prepareStatement(selectstaff);
            rs = pst.executeQuery();
                  
            while(rs.next()){
               
               String id = rs.getString("staffID");
               String surname = rs.getString("staffsurname");
               String othername = rs.getString("staffothername");
               String idnumber = rs.getString("staffIDnumber");
               String gender = rs.getString("staffgender");
               String phone = rs.getString("staffphone");
               String email = rs.getString("staffemail");
               String dob = rs.getString("staffDOB");
               String role = rs.getString("staffrole");
               String link = rs.getString("staffimage");
      
               
               //ARRAY DATA TO DISPLAY
               String tbldata []= {id, surname,othername,idnumber,gender,phone,email,dob,role,link};
               DefaultTableModel dtmdata = (DefaultTableModel)jtmytable.getModel();
               dtmdata.addRow(tbldata);
               
           lbsystemviewaction.setText("Select specific staff for editting");     
            }
                         }else{
        String selectstaff = "SELECT * FROM staff  WHERE staffID = '"+txtsearchid.getText()+"'";
            pst = con.prepareStatement(selectstaff);
            rs = pst.executeQuery();
                  
           if(rs.next()){
               
               String id = rs.getString("staffID");
               String surname = rs.getString("staffsurname");
               String othername = rs.getString("staffothername");
               String idnumber = rs.getString("staffIDnumber");
               String gender = rs.getString("staffgender");
               String phone = rs.getString("staffphone");
               String email = rs.getString("staffemail");
               String dob = rs.getString("staffDOB");
               String role = rs.getString("staffrole");
               String link = rs.getString("staffimage");
      
               
               //ARRAY DATA TO DISPLAY
               String tbldata []= {id, surname,othername,idnumber,gender,phone,email,dob,role,link};
               DefaultTableModel dtmdata = (DefaultTableModel)jtmytable.getModel();
               dtmdata.addRow(tbldata);
               
           lbsystemviewaction.setText("Staff Edit for updates");     
            }else{
               lbsystemviewaction.setText("<HTML><i style=\"color: red;\">Staff ID not found</i></HTML> "); 
                JOptionPane.showMessageDialog(null, "<HTML><i style=\"color: red; font-size: 12px;\">Staff ID not found</i></HTML>","Student verdict",JOptionPane.WARNING_MESSAGE);
           }
                 
        
    }
    
    
    
    
    
    
    // end of staff selection 
                         break;
                     case "Students":
                         JOptionPane.showMessageDialog(null, "Select : " + cmbcategory.getSelectedItem());
                         
                         DefaultTableModel stmstudent = new DefaultTableModel();
    
    stmstudent.addColumn("REG Number");
    stmstudent.addColumn("Surname");
    stmstudent.addColumn("Other Name");
    stmstudent.addColumn("ID Number");
    stmstudent.addColumn("Phone");
    stmstudent.addColumn("Email address");
    stmstudent.addColumn("Gender");
    stmstudent.addColumn("Date of birth");
    stmstudent.addColumn("Media Link");
    jtmytable.setModel(stmstudent);
    
    
     if(cmbselectrange.getSelectedIndex() == 0){
                            //JOptionPane.showMessageDialog(null, "Select all");
                             
                             String selectstudent = "SELECT * FROM student  ";
            pst = con.prepareStatement(selectstudent);
            rs = pst.executeQuery();
                  
            while(rs.next()){
               
               String reg = rs.getString("studentREG");
               String surname = rs.getString("studentsurname");
               String othername = rs.getString("studentothername");
               String idnumber = rs.getString("studentIDnumber");
               String phone = rs.getString("studentphone");
               String email = rs.getString("studentemail");
               String gender = rs.getString("studentgender");
               String dob = rs.getString("studentDOB");
               String link = rs.getString("studentimage");
              
      
               
               //ARRAY DATA TO DISPLAY
               String tbldata []= {reg, surname,othername,idnumber,phone,email,gender,dob,link};
               DefaultTableModel dtmdata = (DefaultTableModel)jtmytable.getModel();
               dtmdata.addRow(tbldata);
               
               lbsystemviewaction.setText("Student Edit for updates");
                
            }
                         }else{
         
                           String selectstudent = "SELECT * FROM student  WHERE studentREG = '"+txtsearchid.getText()+"'";
            pst = con.prepareStatement(selectstudent);
            rs = pst.executeQuery();
                  
            if(rs.next()){
               
               String reg = rs.getString("studentREG");
               String surname = rs.getString("studentsurname");
               String othername = rs.getString("studentothername");
               String idnumber = rs.getString("studentIDnumber");
               String phone = rs.getString("studentphone");
               String email = rs.getString("studentemail");
               String gender = rs.getString("studentgender");
               String dob = rs.getString("studentDOB");
               String link = rs.getString("studentimage");
              
      
               
               //ARRAY DATA TO DISPLAY
               String tbldata []= {reg, surname,othername,idnumber,phone,email,gender,dob,link};
               DefaultTableModel dtmdata = (DefaultTableModel)jtmytable.getModel();
               dtmdata.addRow(tbldata);
               
               lbsystemviewaction.setText("Student Edit for updates");
                
            }else{
                 lbsystemviewaction.setText("<HTML><i style=\"color: red;\">Student ID not found</i></HTML> ");
                  JOptionPane.showMessageDialog(null, "<HTML><i style=\"color: red; font-size: 12px;\">Student ID not found</i></HTML>","Student verdict",JOptionPane.WARNING_MESSAGE);
            }
         
         
     }
    
    
                         break;
                     case "Judgement":
                         JOptionPane.showMessageDialog(null, "Select : " + cmbcategory.getSelectedItem());
                         
                                  DefaultTableModel stmjudgment = new DefaultTableModel();
    
    stmjudgment.addColumn("ID/Serial");
    stmjudgment.addColumn("Type");
    stmjudgment.addColumn("Description");
    stmjudgment.addColumn("Date Added");
  
    jtmytable.setModel(stmjudgment);
    
      if(cmbselectrange.getSelectedIndex() == 0){
                             //JOptionPane.showMessageDialog(null, "Select all");
                             
                             String selectjudgement = "SELECT * FROM judgement  ";
            pst = con.prepareStatement(selectjudgement);
            rs = pst.executeQuery();
                  
            while(rs.next()){
               
               String id = rs.getString("judgementID");
               String type = rs.getString("judgementtype");
               String description = rs.getString("judgementdescription");
               String dateadded = rs.getString("addeddate");
              
              
      
               
               //ARRAY DATA TO DISPLAY
               String tbldata []= {id, type,description,dateadded};
               DefaultTableModel dtmdata = (DefaultTableModel)jtmytable.getModel();
               dtmdata.addRow(tbldata);
               
              lbsystemviewaction.setText("Judgements Edit for updates"); 
                
            }
                         }else{
          String selectjudgement = "SELECT * FROM judgement  WHERE judgementID = '"+txtsearchid.getText()+"'";
            pst = con.prepareStatement(selectjudgement);
            rs = pst.executeQuery();
                  
            if(rs.next()){
               
               String id = rs.getString("judgementID");
               String type = rs.getString("judgementtype");
               String description = rs.getString("judgementdescription");
               String dateadded = rs.getString("addeddate");
              
              
      
               
               //ARRAY DATA TO DISPLAY
               String tbldata []= {id, type,description,dateadded};
               DefaultTableModel dtmdata = (DefaultTableModel)jtmytable.getModel();
               dtmdata.addRow(tbldata);
               
              lbsystemviewaction.setText("Judgements Edit for updates"); 
                
            }else{
                 lbsystemviewaction.setText("<HTML><i style=\"color: red;\">Judgement ID not found</i></HTML> ");
                  JOptionPane.showMessageDialog(null, "<HTML><i style=\"color: red; font-size: 12px;\">Judgement ID not found</i></HTML>","Student verdict",JOptionPane.WARNING_MESSAGE);
            }
          
      }
    
                         break;
                     case "Violation":
                         JOptionPane.showMessageDialog(null, "Select : " + cmbcategory.getSelectedItem());
                         
                          DefaultTableModel stmviolation = new DefaultTableModel();
    
    stmviolation.addColumn("ID/Serial");
    stmviolation.addColumn("Type");
    stmviolation.addColumn("Violantion Name");
    stmviolation.addColumn("Description");
    stmviolation.addColumn("Judgement ID");
    stmviolation.addColumn("Date Added");
  
    jtmytable.setModel(stmviolation);
    
      if(cmbselectrange.getSelectedIndex() == 0){
                             //JOptionPane.showMessageDialog(null, "Select all");
                             
                             String selectjudgement = "SELECT * FROM violation  ";
            pst = con.prepareStatement(selectjudgement);
            rs = pst.executeQuery();
                  
            while(rs.next()){
               
               String id = rs.getString("violationID");
               String type = rs.getString("violationtype");
               String description = rs.getString("violationdescription");
               String judmentid = rs.getString("judgementID");
               String name = rs.getString("violationname");
               String dateadded = rs.getString("violationDOA");
              
              
      
               
               //ARRAY DATA TO DISPLAY
               String tbldata []= {id, type,name,description,judmentid,dateadded};
               DefaultTableModel dtmdata = (DefaultTableModel)jtmytable.getModel();
               dtmdata.addRow(tbldata);
               
                lbsystemviewaction.setText("Violation Edit for updates");
            }
                         }else{
            String selectjudgement = "SELECT * FROM violation  WHERE violationID = '"+txtsearchid.getText()+"'";
            pst = con.prepareStatement(selectjudgement);
            rs = pst.executeQuery();
                  
            if(rs.next()){
               
               String id = rs.getString("violationID");
               String type = rs.getString("violationtype");
               String description = rs.getString("violationdescription");
               String judmentid = rs.getString("judgementID");
               String name = rs.getString("violationname");
               String dateadded = rs.getString("violationDOA");
              
              
      
               
               //ARRAY DATA TO DISPLAY
               String tbldata []= {id, type,name,description,judmentid,dateadded};
               DefaultTableModel dtmdata = (DefaultTableModel)jtmytable.getModel();
               dtmdata.addRow(tbldata);
               
                lbsystemviewaction.setText("Violation Edit for updates");
            }else{
                 JOptionPane.showMessageDialog(null, "<HTML><i style=\"color: red; font-size: 12px;\">Violation ID not found</i></HTML>","Student verdict",JOptionPane.WARNING_MESSAGE);
            }
      }
      
      
                         
                         
                         break;
                     case "Verdict":
                         JOptionPane.showMessageDialog(null, "Select : " + cmbcategory.getSelectedItem());
                         
                          DefaultTableModel stmverdict = new DefaultTableModel();
    
    stmverdict.addColumn("ID/Serial");
    stmverdict.addColumn("Violation ID");
    stmverdict.addColumn("Student Registration");
    stmverdict.addColumn("Coviction Date");
    stmverdict.addColumn("Staff Number");

  
    jtmytable.setModel(stmverdict);
    
      if(cmbselectrange.getSelectedIndex() == 0){
                            // JOptionPane.showMessageDialog(null, "Select all");
                             
                             String selectjudgement = "SELECT * FROM verdict  ";
            pst = con.prepareStatement(selectjudgement);
            rs = pst.executeQuery();
                  
            while(rs.next()){
               
               String id = rs.getString("verdictID");
               String violationid = rs.getString("violationID");
               String studentreg = rs.getString("studentREG");
               String dateDOV = rs.getString("verdictDOV");
               String staffid = rs.getString("staffID");
              
              
      
               
               //ARRAY DATA TO DISPLAY
               String tbldata []= {id, violationid,studentreg,dateDOV,staffid};
               DefaultTableModel dtmdata = (DefaultTableModel)jtmytable.getModel();
               dtmdata.addRow(tbldata);
               
            lbsystemviewaction.setText("<HTML><i style=\"color: red;\">Can not edit verdict only view</i></HTML> ");  
            }
                         }else{
          
          String selectjudgement = "SELECT * FROM verdict WHERE verdictID = '"+txtsearchid.getText()+"' ";
            pst = con.prepareStatement(selectjudgement);
            rs = pst.executeQuery();
                  
            if(rs.next()){
               
               String id = rs.getString("verdictID");
               String violationid = rs.getString("violationID");
               String studentreg = rs.getString("studentREG");
               String dateDOV = rs.getString("verdictDOV");
               String staffid = rs.getString("staffID");
              
              
      
               
               //ARRAY DATA TO DISPLAY
               String tbldata []= {id, violationid,studentreg,dateDOV,staffid};
               DefaultTableModel dtmdata = (DefaultTableModel)jtmytable.getModel();
               dtmdata.addRow(tbldata);
               
            lbsystemviewaction.setText("<HTML><i style=\"color: red;\">Can not edit verdict only view</i></HTML> ");  
            }else{
                 JOptionPane.showMessageDialog(null, "<HTML><i style=\"color: red; font-size: 12px;\">Verdict ID not found</i></HTML>","Student verdict",JOptionPane.WARNING_MESSAGE);
            }
      }
                         break;
                     default:
                         lbsystemviewaction.setText("<HTML><i style=\"color: blue;\">Please select category</i></HTML> ");
                         break;
                 }
        }
        catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        

        
    }//GEN-LAST:event_btnmastersearchActionPerformed

    private void btnrefreshtableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefreshtableActionPerformed
        // TODO add your handling code here:
         loademptytable();
         txtsearchid.setText("");
         txtsearchid.setEnabled(false);
    }//GEN-LAST:event_btnrefreshtableActionPerformed

    private void cmbcategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbcategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbcategoryActionPerformed

    private void lbbtncloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbbtncloseMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_lbbtncloseMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnmastersearch;
    private javax.swing.JButton btnrefreshtable;
    private javax.swing.JButton btnupdatedetails;
    private javax.swing.JComboBox<String> cmbcategory;
    private javax.swing.JComboBox<String> cmbselectrange;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtmytable;
    private javax.swing.JLabel lbbtnclose;
    private javax.swing.JLabel lbsystemviewaction;
    private javax.swing.JTextField txtsearchid;
    // End of variables declaration//GEN-END:variables
}
