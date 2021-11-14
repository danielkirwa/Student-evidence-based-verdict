/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentverdict;

import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author owner
 */
public class PassVerdict extends javax.swing.JPanel {

    /**
     * Creates new form PassVerdict
     */
    
    
    
    
      
             Statement st;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    String username = "root";
    String password = "";
    String url = "jdbc:mysql://localhost:3306/student_verdict";
    
    String resizedavatar = null;
    int autoverdictid = 1;
    
    public PassVerdict() {
        initComponents();
        loadallstudent ();
        loadalstaff ();
        loadalverdict ();
         loadalviolation ();
    }

    
      //populate the regcombobox
       
        public void  loadallstudent (){
         try{
             con = DriverManager.getConnection(url,username,password);
             st = con.createStatement();
             String selectevidenceid = "SELECT studentREG FROM evidence  ";
            pst = con.prepareStatement(selectevidenceid);
            rs = pst.executeQuery();
                  
            while(rs.next()){
               
              cmbstudentverdictid.addItem(rs.getString("studentREG")); 
              cmbstudentverdictid.setEditable(true);
            
            }
            
           
         }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "error"+ ex,"Student verdict",JOptionPane.INFORMATION_MESSAGE);  
         }
    } 
        
      //populate the verdict
       
        public void  loadalverdict (){
         try{
             con = DriverManager.getConnection(url,username,password);
             st = con.createStatement();
             String selecteverdict = "SELECT verdictID FROM verdict  ";
            pst = con.prepareStatement(selecteverdict);
            rs = pst.executeQuery();
                  
            while(rs.next()){
               
              autoverdictid++;
                txtverdictidverdict.setText(autoverdictid+"");
               // System.out.print(autoverdictid + "inside loop");
            
            }
             //System.out.print(autoverdictid + "outside loop");
             txtverdictidverdict.setText(autoverdictid+"");
           
         }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "error"+ ex,"Student verdict",JOptionPane.INFORMATION_MESSAGE);  
         }
    }
    //populate the violation
       
        public void  loadalviolation (){
         try{
             con = DriverManager.getConnection(url,username,password);
             st = con.createStatement();
             String selecteviolation = "SELECT violationID FROM violation  ";
            pst = con.prepareStatement(selecteviolation);
            rs = pst.executeQuery();
                  
            while(rs.next()){
               
              cmbviolationidverdict.addItem(rs.getString("violationID")); 
              cmbviolationidverdict.setEditable(true);
            
            }
            
           
         }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "error"+ ex,"Student verdict",JOptionPane.INFORMATION_MESSAGE);  
         }
    }
        
          //populate the staff
       
        public void  loadalstaff (){
         try{
             con = DriverManager.getConnection(url,username,password);
             st = con.createStatement();
             String selectestaff = "SELECT staffID FROM staff  ";
            pst = con.prepareStatement(selectestaff);
            rs = pst.executeQuery();
                  
            while(rs.next()){
               
              cmbstaffidverdict.addItem(rs.getString("staffID")); 
              cmbstaffidverdict.setEditable(true);
            
            }
            
           
         }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "error"+ ex,"Student verdict",JOptionPane.INFORMATION_MESSAGE);  
         }
    }
    
         public void resizedimage(String resizedavatar) throws IOException{
        BufferedImage img = ImageIO.read(new File(resizedavatar));
         Image scaled = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaled);
        lbinquestionimage.setIcon(icon);
    }
        
        
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jdverdictverdictDOA = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        lbinquestionimage = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnsubmitevidence = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lbbtnclose = new javax.swing.JLabel();
        cmbstudentverdictid = new javax.swing.JComboBox<>();
        cmbviolationidverdict = new javax.swing.JComboBox<>();
        cmbstaffidverdict = new javax.swing.JComboBox<>();
        txtverdictidverdict = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Student REG :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Verdict ID :");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Violation ID :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Staff ID:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Date Of Add :");

        lbinquestionimage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setText("Reset Form");

        btnsubmitevidence.setText("Pass Verdict");
        btnsubmitevidence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsubmitevidenceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(btnsubmitevidence, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnsubmitevidence, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 11, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Student in Question :");

        lbbtnclose.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbbtnclose.setForeground(new java.awt.Color(204, 0, 0));
        lbbtnclose.setText("X");
        lbbtnclose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbbtnclose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbbtncloseMouseClicked(evt);
            }
        });

        cmbstudentverdictid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Student" }));
        cmbstudentverdictid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbstudentverdictidActionPerformed(evt);
            }
        });

        cmbviolationidverdict.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Violation" }));

        cmbstaffidverdict.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Staff" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(cmbstudentverdictid, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtverdictidverdict, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbviolationidverdict, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbstaffidverdict, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdverdictverdictDOA, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbinquestionimage, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110))))
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 143, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbbtnclose)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbbtnclose, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cmbstudentverdictid, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(txtverdictidverdict, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(cmbviolationidverdict, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(cmbstaffidverdict, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jdverdictverdictDOA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbinquestionimage, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnsubmitevidenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsubmitevidenceActionPerformed
        // TODO add your handling code here:

        try {

            // get gender

            // GET Date
            
               java.util.Date dob;
            java.sql.Date verdictpassdoa;
            dob =  jdverdictverdictDOA.getDate();
            verdictpassdoa = new java.sql.Date(dob.getTime());

           
            // TODO add your handling code here:
            con = DriverManager.getConnection(url,username,password);
            st = con.createStatement();
            // inserting student personal details
            String sqlevidencedetails = "INSERT INTO verdict (verdictID,violationID,studentREG,verdictDOV,staffID) VALUES"
            + " ('"+txtverdictidverdict.getText()+"','"+cmbviolationidverdict.getSelectedItem()+"','"+cmbstudentverdictid.getSelectedItem()+"','"+verdictpassdoa+"',"
            + "'"+cmbstaffidverdict.getSelectedItem()+"')";
            st.execute(sqlevidencedetails);
            JOptionPane.showMessageDialog(null, "<HTML><i style=\"color: green; font-size: 12px;\">New Verdict Passed</i></HTML>","Student verdict",JOptionPane.INFORMATION_MESSAGE);
            
            loadalverdict ();
              String insertsearch = "UPDATE search set searchitem = '"+cmbstudentverdictid.getSelectedItem()+"'  WHERE searchid = '"+1+"'" ;
                   st.execute(insertsearch);
        }catch(SQLIntegrityConstraintViolationException e){
            JOptionPane.showMessageDialog(null, "<HTML><i style=\"color: red; font-size: 12px;\">Verdict Already Exists</i></HTML>","Student verdict",JOptionPane.WARNING_MESSAGE);
        }
        catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, "error"+ ex,"Student verdict",JOptionPane.INFORMATION_MESSAGE);

        }
        catch(NullPointerException npx){
            JOptionPane.showMessageDialog(null,"Please select Date !","Student verdict",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnsubmitevidenceActionPerformed

    private void lbbtncloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbbtncloseMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_lbbtncloseMouseClicked

    private void cmbstudentverdictidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbstudentverdictidActionPerformed
        // TODO add your handling code here:
        
                
         try{
             con = DriverManager.getConnection(url,username,password);
             st = con.createStatement();
             String selectevidenceid = "SELECT studentimage FROM student WHERE studentREG = '"+cmbstudentverdictid.getSelectedItem()+"'  ";
            pst = con.prepareStatement(selectevidenceid);
            rs = pst.executeQuery();
                  
            if(rs.next()){
               
              resizedimage(resizedavatar = rs.getString("studentimage"));
            
            }else{
                lbinquestionimage.setText("");
                lbinquestionimage.setToolTipText("Select student to view image");
            }
            
           
         }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "error"+ ex,"Student verdict",JOptionPane.INFORMATION_MESSAGE);  
         }
        
    }//GEN-LAST:event_cmbstudentverdictidActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsubmitevidence;
    private javax.swing.JComboBox<String> cmbstaffidverdict;
    private javax.swing.JComboBox<String> cmbstudentverdictid;
    private javax.swing.JComboBox<String> cmbviolationidverdict;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser jdverdictverdictDOA;
    private javax.swing.JLabel lbbtnclose;
    private javax.swing.JLabel lbinquestionimage;
    private javax.swing.JTextField txtverdictidverdict;
    // End of variables declaration//GEN-END:variables
}
