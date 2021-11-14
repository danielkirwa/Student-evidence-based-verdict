/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentverdict;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author owner
 */
public class PrinGoodConduct extends javax.swing.JFrame {

    /**
     * Creates new form PrinGoodConduct
     */
        Statement st;
    Connection con;
    PreparedStatement pst;
    ResultSet rs,rsverdict,reviolation;
    
    String username = "root";
    String password = "";
    String url = "jdbc:mysql://localhost:3306/student_verdict";
    
    
    
    String resizedlogo = "images/logo.jpg";
    String resizedimage = null;
    public PrinGoodConduct() {
        initComponents();
        showdate();
        
        try {
            resizedlogo(resizedlogo);
        } catch (IOException ex) {
            Logger.getLogger(PrinGoodConduct.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
     public void resizedlogo(String resizedlogo) throws IOException{
        BufferedImage img = ImageIO.read(new File(resizedlogo));
Image scaled = img.getScaledInstance(150, 140, Image.SCALE_SMOOTH);
ImageIcon icon = new ImageIcon(scaled);
lbinstitutionlogo.setIcon(icon);
    }
       public void resizedstudentimage(String resizedimage) throws IOException{
        BufferedImage img = ImageIO.read(new File(resizedimage));
Image scaled = img.getScaledInstance(230, 215, Image.SCALE_SMOOTH);
ImageIcon icon = new ImageIcon(scaled);
lbstudentcertificateavatar.setIcon(icon);
    }
        void showdate(){
    Date d = new Date();
    SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
    
    lbcertificatedate.setText("Date :"+s.format(d));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpquerywizard = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtsearchstudent = new javax.swing.JTextField();
        btngeneratecertificate = new javax.swing.JButton();
        btnprintgoodconductcertificate = new javax.swing.JButton();
        lbstudentcertificateavatar = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jpcertpane = new javax.swing.JPanel();
        jpgoodconductcertificate = new javax.swing.JPanel();
        lbinstitutionlogo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbcondidatename = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbcandidatereg = new javax.swing.JLabel();
        lbcandidateidnumber = new javax.swing.JLabel();
        lbcertificatedate = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("jrprinter"); // NOI18N

        jpquerywizard.setBackground(new java.awt.Color(255, 255, 255));
        jpquerywizard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("  .              QUERY WIZARD               . ");

        jLabel13.setText("Enter student registration number");

        txtsearchstudent.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtsearchstudent.setToolTipText("Search Student REG");
        txtsearchstudent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchstudentKeyReleased(evt);
            }
        });

        btngeneratecertificate.setBackground(new java.awt.Color(0, 204, 102));
        btngeneratecertificate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btngeneratecertificate.setText("Generate Certificate");
        btngeneratecertificate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngeneratecertificateActionPerformed(evt);
            }
        });

        btnprintgoodconductcertificate.setBackground(new java.awt.Color(0, 153, 153));
        btnprintgoodconductcertificate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnprintgoodconductcertificate.setText("Print Certificate");
        btnprintgoodconductcertificate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprintgoodconductcertificateActionPerformed(evt);
            }
        });

        lbstudentcertificateavatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setText("Student image :");

        javax.swing.GroupLayout jpquerywizardLayout = new javax.swing.GroupLayout(jpquerywizard);
        jpquerywizard.setLayout(jpquerywizardLayout);
        jpquerywizardLayout.setHorizontalGroup(
            jpquerywizardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtsearchstudent, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(btngeneratecertificate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnprintgoodconductcertificate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpquerywizardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbstudentcertificateavatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpquerywizardLayout.setVerticalGroup(
            jpquerywizardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpquerywizardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(txtsearchstudent, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btngeneratecertificate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnprintgoodconductcertificate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(lbstudentcertificateavatar, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jScrollPane1.setMinimumSize(new java.awt.Dimension(888, 904));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1200, 1500));

        jpcertpane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpcertpane.setMinimumSize(new java.awt.Dimension(888, 904));

        jpgoodconductcertificate.setBackground(new java.awt.Color(255, 255, 255));

        lbinstitutionlogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("KIBABII UNIVERSITY");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PO BOX 1699 - 5200 BUNGOMA");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Email : enquiries@kibu.ac.ke");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("web: www.kibu.ac.ke");

        jLabel6.setText("SNo: ASH34MFL55K");

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 5));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CERTIFICATE OF GOOD CONDUCT");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("<html>\n <p>\n\nThis is to certisfy that the above named have conducted self with high degree of dignity and have \n oparated up to the standards of the university.  Above have no any criminal record nor any kind of michief act. \n<br><br>\nThis certificate has been aworded to proof one good conduct in regaurd to kibabii university codes. \n<br><br>\n This certificate only acertain ones's conduct upto the date of generation any act after words  will be captured.\n</p>\n<html>");

        lbcondidatename.setText("null");

        jLabel9.setText("of registration number ");

        lbcandidatereg.setText("null");

        lbcandidateidnumber.setText("ID Number : null");

        lbcertificatedate.setText("Date printed");

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(771, 3));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("University Authorities");

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(267, 3));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 267, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("© Kibabii University 2021. All Rights Reserved   KIBABII UNIVERSITY ISO : 9001 - 2015 Certified");

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(272, 2));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setPreferredSize(new java.awt.Dimension(192, 2));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 192, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpgoodconductcertificateLayout = new javax.swing.GroupLayout(jpgoodconductcertificate);
        jpgoodconductcertificate.setLayout(jpgoodconductcertificateLayout);
        jpgoodconductcertificateLayout.setHorizontalGroup(
            jpgoodconductcertificateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbinstitutionlogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpgoodconductcertificateLayout.createSequentialGroup()
                .addGap(0, 46, Short.MAX_VALUE)
                .addGroup(jpgoodconductcertificateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpgoodconductcertificateLayout.createSequentialGroup()
                        .addComponent(lbcertificatedate, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpgoodconductcertificateLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpgoodconductcertificateLayout.createSequentialGroup()
                        .addGroup(jpgoodconductcertificateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))))
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpgoodconductcertificateLayout.createSequentialGroup()
                .addGroup(jpgoodconductcertificateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpgoodconductcertificateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpgoodconductcertificateLayout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addGroup(jpgoodconductcertificateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbcandidateidnumber)
                                .addGroup(jpgoodconductcertificateLayout.createSequentialGroup()
                                    .addComponent(lbcondidatename, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(49, 49, 49)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(36, 36, 36)
                                    .addComponent(lbcandidatereg, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpgoodconductcertificateLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(199, 199, 199)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpgoodconductcertificateLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpgoodconductcertificateLayout.setVerticalGroup(
            jpgoodconductcertificateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpgoodconductcertificateLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel6)
                .addGap(26, 26, 26)
                .addComponent(lbinstitutionlogo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(24, 24, 24)
                .addComponent(lbcertificatedate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lbcandidateidnumber)
                .addGap(53, 53, 53)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(jpgoodconductcertificateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbcondidatename)
                    .addComponent(jLabel9)
                    .addComponent(lbcandidatereg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpgoodconductcertificateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(31, 31, 31)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout jpcertpaneLayout = new javax.swing.GroupLayout(jpcertpane);
        jpcertpane.setLayout(jpcertpaneLayout);
        jpcertpaneLayout.setHorizontalGroup(
            jpcertpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpcertpaneLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jpgoodconductcertificate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jpcertpaneLayout.setVerticalGroup(
            jpcertpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpcertpaneLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jpgoodconductcertificate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jpcertpane);

        jMenu1.setText("MAIN MENU");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, 0));
        jMenuItem1.setText("DASHBOARD");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("LOGOUT");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpquerywizard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 894, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpquerywizard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
         JFrame dash = new Dashboard();
                dash.setVisible(true);
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                int w = dim.width;
                int h = dim.height;
                dash.setSize(w, h);
                dash.setLocation(0,0);
                 dash.setExtendedState(JFrame.MAXIMIZED_BOTH);
                dash.setLayout(new GridBagLayout());
                //this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btngeneratecertificateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngeneratecertificateActionPerformed
        // TODO add your handling code here:
         String reg = null; String surname = null;String othername = null;String link = null;String idnumber = null;
 
         try{
            con = DriverManager.getConnection(url,username,password);
            st = con.createStatement();
            
            
         String selectverdict = "SELECT * FROM verdict WHERE studentREG = ?  ";
            pst = con.prepareStatement(selectverdict);
            pst.setString(1, (String) txtsearchstudent.getText());
            rs = pst.executeQuery();
                  
            if(rs.next()){
              
             int option =JOptionPane.showConfirmDialog(null, "<HTML><i style=\"color: blue; font-size: 12px;\">Student Convicted view verdict</i></HTML>","Student verdict",JOptionPane.YES_NO_OPTION);
             if(option == JOptionPane.YES_OPTION ){
                   this.dispose();
                   String insertsearch = "UPDATE search set searchitem = '"+txtsearchstudent.getText()+"'  WHERE searchid = '"+1+"'" ;
                   st.execute(insertsearch);
       JFrame verdictprinter = new PrinVerdictCertificate();
                verdictprinter.setVisible(true);
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                int w = dim.width;
                int h = dim.height;
                verdictprinter.setSize(w, h);
                verdictprinter.setLocation(0,0);
                 verdictprinter.setExtendedState(JFrame.MAXIMIZED_BOTH);
                verdictprinter.setLayout(new GridBagLayout());
             }else{
                 txtsearchstudent.setText("");
                 txtsearchstudent.requestFocus();
             }
            }else{
                
                String selectstudent = "SELECT * FROM verdict WHERE studentREG = ?  ";
            pst = con.prepareStatement(selectstudent);
            pst.setString(1, (String) txtsearchstudent.getText());
            rs = pst.executeQuery();
                  
            if(rs.next()){
               
               reg = rs.getString("studentREG");
               surname = rs.getString("studentsurname");
               othername = rs.getString("studentothername");
               idnumber = rs.getString("studentIDnumber");
               link = rs.getString("studentimage");
               
               resizedstudentimage(link);
               lbcandidateidnumber.setText("ID Number : " + idnumber);
               lbcondidatename.setText(surname + "  " + othername);
               lbcandidatereg.setText(reg);
            }
                JOptionPane.showMessageDialog(null, "<HTML><i style=\"color: blue; font-size: 12px;\">Student not found</i></HTML>","Student verdict",JOptionPane.WARNING_MESSAGE);
            }
         }
            catch( SQLException | IOException ex){
                    JOptionPane.showMessageDialog(null, ex ,"Student verdict",JOptionPane.WARNING_MESSAGE);
                    }
         
    }//GEN-LAST:event_btngeneratecertificateActionPerformed

    private void btnprintgoodconductcertificateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintgoodconductcertificateActionPerformed
        // TODO add your handling code here:
        
            PrinterJob pjob = PrinterJob.getPrinterJob();
            pjob.setJobName("SALE RECEIPT");
            pjob.setPrintable(new Printable(){ 
            public int print(Graphics pg ,PageFormat pf, int pagenum){
            pf.setOrientation(PageFormat.LANDSCAPE);
            if(pagenum > 0){
            return Printable.NO_SUCH_PAGE;
            }
            java.awt.Graphics2D g2 = (java.awt.Graphics2D)pg;
            g2.translate(pf.getImageableX(), pf.getImageableY());
            g2.scale(0.72, 0.8);
            jpgoodconductcertificate.paint(g2);
            return Printable.PAGE_EXISTS;
            }
            });
            boolean  ok = pjob.printDialog();
            if(ok){
            try{
            pjob.print();
            }catch(PrinterException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
            }
    }//GEN-LAST:event_btnprintgoodconductcertificateActionPerformed

    private void txtsearchstudentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchstudentKeyReleased
        // TODO add your handling code here:
        
          int pos = txtsearchstudent.getCaretPosition();
        txtsearchstudent.setText(txtsearchstudent.getText().toUpperCase());
        txtsearchstudent.setCaretPosition(pos);
    }//GEN-LAST:event_txtsearchstudentKeyReleased

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
            java.util.logging.Logger.getLogger(PrinGoodConduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrinGoodConduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrinGoodConduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrinGoodConduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new PrinGoodConduct().setVisible(true);
                
                JFrame printer = new PrinGoodConduct();

                printer.setVisible(true);

                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

                int w = dim.width;

                int h = dim.height;

                printer.setSize(w, h);

                printer.setLayout(new GridBagLayout());
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btngeneratecertificate;
    private javax.swing.JButton btnprintgoodconductcertificate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpcertpane;
    private javax.swing.JPanel jpgoodconductcertificate;
    private javax.swing.JPanel jpquerywizard;
    private javax.swing.JLabel lbcandidateidnumber;
    private javax.swing.JLabel lbcandidatereg;
    private javax.swing.JLabel lbcertificatedate;
    private javax.swing.JLabel lbcondidatename;
    private javax.swing.JLabel lbinstitutionlogo;
    private javax.swing.JLabel lbstudentcertificateavatar;
    private javax.swing.JTextField txtsearchstudent;
    // End of variables declaration//GEN-END:variables
}
