/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.GarbageCollectorRole;

import Business.Enterprise.Enterprise;
import Business.Organization.BioTransportationOrganization;
import Business.Organization.GarbageCollectorOrganization;
import Business.Organization.MetalTransportationOrganization;
import Business.Organization.Organization;
import Business.Organization.PlasticTransportationOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BioTransportationWorkRequest;
import Business.WorkQueue.GarbageCollectorWorkRequest;
import Business.WorkQueue.MetalTransportationWorkRequest;
import Business.WorkQueue.PlasticTransportationWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author pranalinarkar
 */
public class GarbageCollectorWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private GarbageCollectorOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;

    /**
     * Creates new form GarbageCollectorWorkAreaJPanel
     */
    public GarbageCollectorWorkAreaJPanel(JPanel userProcessContainer, UserAccount userAccount, GarbageCollectorOrganization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        populateRequestTable();
        populateMetalTransportation();
        populateBioDegradableTransportation();
        populatePlasticTransportation();
    }

    
    
    
    public void refresh(){
    
    jBiodegradableCollected.setText("");
        jBioDegradableSegregated.setText("");
        jMetalCollected.setText("");
        jMetalSegregated.setText("");
        jRefresh.setEnabled(true);
        jMessageToMD.setText("");
        jMessageToBD.setText("");
        jPlasticCollected.setText("");
        jPlasticSegregated.setText("");
         jTypeOfGarbage.setEnabled(false);
        jMessageToPD.setText("");
        jG.setEnabled(false);
        jBiodegradableCollected.setEnabled(false);
        jBioDegradableSegregated.setEnabled(false);
        jMetalCollected.setEnabled(false);
        jMetalSegregated.setEnabled(false);
        jSendToMT.setEnabled(false);
        jSendToBT.setEnabled(false);
        jMessageToMD.setEnabled(false);
        jMessageToBD.setEnabled(false);
        jPlasticCollected.setEnabled(false);
        jPlasticSegregated.setEnabled(false);
        jSendToPT.setEnabled(false);
        jMessageToPD.setEnabled(false);
        jBTMT.setEnabled(false);
        jMTPT.setEnabled(false);
        jMTPTBT.setEnabled(false);
        jPTBT.setEnabled(false);
        
    
    
    
    }
    public void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) jGarbageCollector.getModel();

        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            Object[] row = new Object[7];
            row[0] = request;
            String area = ((GarbageCollectorWorkRequest) request).getArea();
            row[1] = area;
            String metal = ((GarbageCollectorWorkRequest) request).getMetalGarbageStatus();
            row[2] = metal;
            row[3] = ((GarbageCollectorWorkRequest) request).getBiodegradableStatus();
            row[4] = ((GarbageCollectorWorkRequest) request).getPlasticStatus();
            row[5] = ((GarbageCollectorWorkRequest) request).getStatus();
            row[6] = ((GarbageCollectorWorkRequest) request).getSender();

            model.addRow(row);
        }
    }
    
    
     public int getSumMCollected(){
         int rowcount=jGarbageCollector.getRowCount();
         int sumMC=0;
         for(int i=0;i<rowcount;i++){
         sumMC=sumMC+Integer.parseInt(jGarbageCollector.getValueAt(i, 7).toString());
                 
         
         }
         
         return sumMC;
         
         }
     
      public int getSumpCollected(){
         int rowcount=jGarbageCollector.getRowCount();
         int sumPC=0;
         for(int i=0;i<rowcount;i++){
         sumPC=sumPC+Integer.parseInt(jGarbageCollector.getValueAt(i, 8).toString());
                 
         
         }
         
         return sumPC;
         
         }
      public int getSumbCollected(){
         int rowcount=jGarbageCollector.getRowCount();
         int sumBC=0;
         for(int i=0;i<rowcount;i++){
         sumBC=sumBC+Integer.parseInt(jGarbageCollector.getValueAt(i, 9).toString());
                 
         
         }
         
         return sumBC;
         
         }
      
      
      public int getSumMSegregated(){
         int rowcount=jGarbageCollector.getRowCount();
         int sumMS=0;
         for(int i=0;i<rowcount;i++){
         sumMS=sumMS+Integer.parseInt(jGarbageCollector.getValueAt(i, 10).toString());
                 
         
         }
         
         return sumMS;
         
         }
     
      public int getSumpSegregated(){
         int rowcount=jGarbageCollector.getRowCount();
         int sumPS=0;
         for(int i=0;i<rowcount;i++){
         sumPS=sumPS+Integer.parseInt(jGarbageCollector.getValueAt(i, 11).toString());
                 
         
         }
         
         return sumPS;
         
         }
      public int getSumbSegregated(){
         int rowcount=jGarbageCollector.getRowCount();
         int sumBS=0;
         for(int i=0;i<rowcount;i++){
         sumBS=sumBS+Integer.parseInt(jGarbageCollector.getValueAt(i, 12).toString());
                 
         
         }
         
         return sumBS;
         
         }

     public static BufferedImage getScreenShot(Component component){
        BufferedImage image= new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_RGB);
        component.paint(image.getGraphics());
        return image;
    }
    
    public static void SaveScreenShot(Component component, String filename)throws Exception{
        BufferedImage img= getScreenShot(component);
        ImageIO.write(img, "png", new File(filename));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jGarbageCollector = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMetalCollected = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPlasticCollected = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jBiodegradableCollected = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jMetalSegregated = new javax.swing.JTextField();
        jPlasticSegregated = new javax.swing.JTextField();
        jBioDegradableSegregated = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jMetalTransportation = new javax.swing.JComboBox();
        jPlasticTransportation = new javax.swing.JComboBox();
        jBiodegradableTransportation = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSendToMT = new javax.swing.JButton();
        jSendToPT = new javax.swing.JButton();
        jSendToBT = new javax.swing.JButton();
        jRefresh = new javax.swing.JButton();
        jTypeOfGarbage = new javax.swing.JButton();
        jMessageToMD = new javax.swing.JTextField();
        jMessageToPD = new javax.swing.JTextField();
        jMessageToBD = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jRefreshFields = new javax.swing.JButton();
        jMTPT = new javax.swing.JButton();
        jPTBT = new javax.swing.JButton();
        jBTMT = new javax.swing.JButton();
        jMTPTBT = new javax.swing.JButton();
        jG = new javax.swing.JToggleButton();
        jAWMR = new javax.swing.JButton();
        jMaxArea = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jGarbageCollector.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Message", "Area", "Metal", "Biodegradable", "Plastic", "Status", "Sender", "MCollected(kgs)", "PCollected(Kgs)", "BCollected(Kgs)", "MSegregated(kgs)", "PSegregated(Kgs)", "BSegregated(Kgs)", "ToMD", "ToPD", "ToBD", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jGarbageCollector);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 910, 90));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setText("Garbage Collector Work Area");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 250, 50));

        jMetalCollected.setEnabled(false);
        add(jMetalCollected, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 92, 30));

        jLabel2.setText("Metal Collected");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 96, 20));

        jPlasticCollected.setEnabled(false);
        add(jPlasticCollected, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 92, 30));

        jLabel3.setText("Plastic Collected");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 115, 20));

        jBiodegradableCollected.setEnabled(false);
        add(jBiodegradableCollected, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 92, 30));

        jLabel4.setText("Biodegradable Collected");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, -1, 20));

        jMetalSegregated.setEnabled(false);
        jMetalSegregated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMetalSegregatedActionPerformed(evt);
            }
        });
        add(jMetalSegregated, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 190, 90, 30));

        jPlasticSegregated.setEnabled(false);
        jPlasticSegregated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPlasticSegregatedActionPerformed(evt);
            }
        });
        add(jPlasticSegregated, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 220, 90, 30));

        jBioDegradableSegregated.setEnabled(false);
        jBioDegradableSegregated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBioDegradableSegregatedActionPerformed(evt);
            }
        });
        add(jBioDegradableSegregated, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 250, 90, 30));

        jLabel5.setText("Metal segregated");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 96, 20));

        jLabel6.setText("Biodegradable segregated");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 130, 20));

        jLabel7.setText("Plastic segregated");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 96, 20));

        jMetalTransportation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jMetalTransportation, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 83, -1));

        jPlasticTransportation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jPlasticTransportation, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 83, -1));

        jBiodegradableTransportation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jBiodegradableTransportation, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, 83, -1));

        jLabel8.setText("Metal Transportation");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 110, 20));

        jLabel9.setText("Plastic Transportation");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, -1, 20));

        jLabel10.setText("Biodegradable Transportation");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 300, -1, 20));

        jSendToMT.setText("SendToMT");
        jSendToMT.setEnabled(false);
        jSendToMT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSendToMTActionPerformed(evt);
            }
        });
        add(jSendToMT, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, -1, -1));

        jSendToPT.setText("SendToPT");
        jSendToPT.setEnabled(false);
        jSendToPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSendToPTActionPerformed(evt);
            }
        });
        add(jSendToPT, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, -1, -1));

        jSendToBT.setText("SendToBT");
        jSendToBT.setEnabled(false);
        jSendToBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSendToBTActionPerformed(evt);
            }
        });
        add(jSendToBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, -1, -1));

        jRefresh.setText("Refresh Table");
        jRefresh.setEnabled(false);
        jRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRefreshActionPerformed(evt);
            }
        });
        add(jRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 110, -1));

        jTypeOfGarbage.setText("TypeOfGarbage");
        jTypeOfGarbage.setEnabled(false);
        jTypeOfGarbage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTypeOfGarbageActionPerformed(evt);
            }
        });
        add(jTypeOfGarbage, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, -1, -1));

        jMessageToMD.setEnabled(false);
        add(jMessageToMD, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, 90, 30));

        jMessageToPD.setEnabled(false);
        jMessageToPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMessageToPDActionPerformed(evt);
            }
        });
        add(jMessageToPD, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 220, 90, 30));

        jMessageToBD.setEnabled(false);
        add(jMessageToBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 250, 90, 30));

        jLabel11.setText("MessageToMD");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 190, -1, -1));

        jLabel12.setText("MessageToPD");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 230, -1, -1));

        jLabel13.setText("MessageToBD");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 260, -1, -1));

        jRefreshFields.setText("Refresh Fields");
        jRefreshFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRefreshFieldsActionPerformed(evt);
            }
        });
        add(jRefreshFields, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, -1, -1));

        jMTPT.setText("MT & PT");
        jMTPT.setEnabled(false);
        jMTPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMTPTActionPerformed(evt);
            }
        });
        add(jMTPT, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, -1, -1));

        jPTBT.setText("PT & BT");
        jPTBT.setEnabled(false);
        jPTBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPTBTActionPerformed(evt);
            }
        });
        add(jPTBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, -1, -1));

        jBTMT.setText("BT & MT");
        jBTMT.setEnabled(false);
        jBTMT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTMTActionPerformed(evt);
            }
        });
        add(jBTMT, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, -1, -1));

        jMTPTBT.setText("MT&PT&BT");
        jMTPTBT.setEnabled(false);
        jMTPTBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMTPTBTActionPerformed(evt);
            }
        });
        add(jMTPTBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 340, -1, -1));

        jG.setText("TypeOfGarbage");
        jG.setEnabled(false);
        jG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGActionPerformed(evt);
            }
        });
        add(jG, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, -1, -1));

        jAWMR.setText("Area with most Request");
        jAWMR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAWMRActionPerformed(evt);
            }
        });
        add(jAWMR, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, -1, 40));

        jMaxArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMaxAreaActionPerformed(evt);
            }
        });
        add(jMaxArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 70, 40));

        jButton1.setText("Most garbage Collected ");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, 160, 40));

        jButton2.setText("Most Useful Garbage");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 390, 160, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void jMetalSegregatedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMetalSegregatedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMetalSegregatedActionPerformed

    private void jPlasticSegregatedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPlasticSegregatedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPlasticSegregatedActionPerformed

    private void jRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRefreshActionPerformed

        DefaultTableModel model = (DefaultTableModel) jGarbageCollector.getModel();

        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            Object[] row = new Object[17];
            row[0] = request;
            String area = ((GarbageCollectorWorkRequest) request).getArea();
            row[1] = area;
            String metal = ((GarbageCollectorWorkRequest) request).getMetalGarbageStatus();
            row[2] = metal;
            row[3] = ((GarbageCollectorWorkRequest) request).getBiodegradableStatus();
            row[4] = ((GarbageCollectorWorkRequest) request).getPlasticStatus();
            row[5] = ((GarbageCollectorWorkRequest) request).getStatus();
            row[6] = ((GarbageCollectorWorkRequest) request).getSender();
            row[7] = ((GarbageCollectorWorkRequest) request).getCollectedMetal();
            row[8] = ((GarbageCollectorWorkRequest) request).getCollectedPlastic();
            row[9] = ((GarbageCollectorWorkRequest) request).getCollectedDegradable();
            row[10] = ((GarbageCollectorWorkRequest) request).getSegregatedMetal();
            row[11] = ((GarbageCollectorWorkRequest) request).getSegregatedPlastic();
            row[12] = ((GarbageCollectorWorkRequest) request).getSegregatedDegradable();
           
            row[13] = ((GarbageCollectorWorkRequest) request).getSentToMD();
            row[14] = ((GarbageCollectorWorkRequest) request).getSentToPD();
            row[15] = ((GarbageCollectorWorkRequest) request).getSentToBD();
            
            row[16] = ((GarbageCollectorWorkRequest) request).getType();

            model.addRow(row);
        }
           jTypeOfGarbage.setEnabled(true);
           jRefresh.setEnabled(false);
            jButton1.setEnabled(true);
        jButton2.setEnabled(true);
    }//GEN-LAST:event_jRefreshActionPerformed

    private void jSendToMTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSendToMTActionPerformed
        int selectedRow = jGarbageCollector.getSelectedRow();
        GarbageCollectorWorkRequest gcwr = (GarbageCollectorWorkRequest) jGarbageCollector.getValueAt(selectedRow, 0);
        if(gcwr.getMessage().equalsIgnoreCase("Allocated")){
        JOptionPane.showMessageDialog(null, "Already Assigned");
            return;
        
        
        }
        int metalCollected;
        int metalSegregated;
        String message = jMessageToMD.getText();

        if (message.trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "MessageToMD cannot be null");
            return;

        }
        try {
            metalCollected = Integer.parseInt(jMetalCollected.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter correct Metal Collected  value in Kgs",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            metalSegregated = Integer.parseInt(jMetalSegregated.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter correct Metal Segregated value in Kgs",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (metalCollected < metalSegregated) {

            JOptionPane.showMessageDialog(null, "Collected metal value cannot be less than Segregated value",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        if (metalCollected <= 0 || metalSegregated < 0) {

            JOptionPane.showMessageDialog(null, "Incorrect Metal values",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }

        UserAccount ua = (UserAccount) jMetalTransportation.getSelectedItem();

        if (ua.equals("")) {
            JOptionPane.showMessageDialog(null, "Please select a Metal Transporter");
            return;
        }

        if (jMetalCollected.equals("") || jMetalSegregated.equals("")) {
            JOptionPane.showMessageDialog(null, "Please insert metal garbage details");
            return;

        }
        
        gcwr.setSentToMD(ua);
        gcwr.setMessage("Allocated");
        gcwr.setStatus("Sent");
        gcwr.setCollectedMetal(metalCollected);
        gcwr.setSegregatedMetal(metalSegregated);
        gcwr.setMessageToMetalDept(message);
        gcwr.setReceiver(userAccount);
        gcwr.setType("Done");
//        gcwr.setCollectedDegradable(0);
//        gcwr.setCollectedPlastic(0);
//        gcwr.setMessageToBioDept("");
//        gcwr.setMessageToPlasticDept("");
//        gcwr.setSegregatedDegradable(0);
//        gcwr.setSegregatedPlastic(0);
        MetalTransportationWorkRequest request = new MetalTransportationWorkRequest();
        request.setMessage("To be Transported");
        request.setMessageToMetalDept(message);
        request.setCollectedMetal(metalCollected);
        request.setSegregatedMetal(metalSegregated);
        request.setReceiver(gcwr.getSentToMD());
        request.setRequestDate(gcwr.getRequestDate());

        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof MetalTransportationOrganization) {
                org = organization;
                break;
            }
        }
        if (org != null) {

            ua.getWorkQueue().getWorkRequestList().add(request);

            JOptionPane.showMessageDialog(null, "Work request added.");
            
        }
        
        refresh(); 
       
    }//GEN-LAST:event_jSendToMTActionPerformed

    private void jTypeOfGarbageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTypeOfGarbageActionPerformed
        int selectedRow = jGarbageCollector.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        
        if(userAccount!=null){
        for(WorkRequest w:userAccount.getWorkQueue().getWorkRequestList()){
        
        if(w.getType().equalsIgnoreCase("Suspected")){
        JOptionPane.showMessageDialog(null, "Please Finish with Suspected Work");
        jG.setEnabled(true);
        jTypeOfGarbage.setEnabled(false);
         return;
        }
        }}
        GarbageCollectorWorkRequest gmwr = (GarbageCollectorWorkRequest) jGarbageCollector.getValueAt(selectedRow, 0);
       if(gmwr.getMessage().equalsIgnoreCase("Allocated")){
        JOptionPane.showMessageDialog(null, "Already Assigned");
       return;
       }
        String metal = gmwr.getMetalGarbageStatus();

        String plastic = gmwr.getPlasticStatus();
        String bio = gmwr.getBiodegradableStatus();
        if (bio.equalsIgnoreCase("No BioGarbage") && metal.equalsIgnoreCase("No Metal") && (!plastic.equalsIgnoreCase("No Plastic"))) {
            jPlasticCollected.setEnabled(true);
            jPlasticSegregated.setEnabled(true);
            jSendToPT.setEnabled(true);
            jMessageToPD.setEnabled(true);
        }
      else  if ((bio.equalsIgnoreCase("No BioGarbage")) && (plastic.equalsIgnoreCase("No Plastic")) && (!metal.equalsIgnoreCase("No Metal"))) {
            jMetalCollected.setEnabled(true);
            jMetalSegregated.setEnabled(true);
            jSendToMT.setEnabled(true);
            jMessageToMD.setEnabled(true);
        }
      else  if ((plastic.equalsIgnoreCase("No Plastic")) && (metal.equalsIgnoreCase("No Metal")) && (!bio.equalsIgnoreCase("No BioGarbage"))) {

            jBiodegradableCollected.setEnabled(true);
            jBioDegradableSegregated.setEnabled(true);
            jSendToBT.setEnabled(true);
            jMessageToBD.setEnabled(true);
        }

       else if ((!plastic.equalsIgnoreCase("No Plastic")) && (!metal.equalsIgnoreCase("No Metal")) && (!bio.equalsIgnoreCase("No BioGarbage"))) {

            jBiodegradableCollected.setEnabled(true);
            jBioDegradableSegregated.setEnabled(true);
            jMTPTBT.setEnabled(true);
            jMessageToBD.setEnabled(true);
            jPlasticCollected.setEnabled(true);
            jPlasticSegregated.setEnabled(true);
            jMetalCollected.setEnabled(true);
            jMetalSegregated.setEnabled(true);
            
            
            jMessageToMD.setEnabled(true);
            jMessageToPD.setEnabled(true);
        }
      else  if (metal.equalsIgnoreCase("No Metal")&&(!plastic.equalsIgnoreCase("No Plastic"))&&(!bio.equalsIgnoreCase("No BioGarbage"))) {
            jBiodegradableCollected.setEnabled(true);
            jBioDegradableSegregated.setEnabled(true);
            jPlasticCollected.setEnabled(true);
            jPlasticSegregated.setEnabled(true);
            jPTBT.setEnabled(true);
            
            jMessageToBD.setEnabled(true);
            jMessageToPD.setEnabled(true);

        }
      else  if (plastic.equalsIgnoreCase("No Plastic")&& (!bio.equalsIgnoreCase("No BioGarbage"))&& (!metal.equalsIgnoreCase("No Metal"))) {
            jBiodegradableCollected.setEnabled(true);
            jBioDegradableSegregated.setEnabled(true);
            jMetalCollected.setEnabled(true);
            jMetalSegregated.setEnabled(true);
            jBTMT.setEnabled(true);
           
            jMessageToMD.setEnabled(true);
            jMessageToBD.setEnabled(true);

        }
      else  if (bio.equalsIgnoreCase("No BioGarbage") && (!metal.equalsIgnoreCase("No Metal")) && (!plastic.equalsIgnoreCase("No Plastic"))) {
            jPlasticCollected.setEnabled(true);
            jPlasticSegregated.setEnabled(true);
            jMetalCollected.setEnabled(true);
            jMetalSegregated.setEnabled(true);
            jMTPT.setEnabled(true);
           
            jMessageToMD.setEnabled(true);
            jMessageToPD.setEnabled(true);

        }
        JOptionPane.showMessageDialog(null, "Done");


    }//GEN-LAST:event_jTypeOfGarbageActionPerformed

    private void jMessageToPDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMessageToPDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMessageToPDActionPerformed

    private void jBioDegradableSegregatedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBioDegradableSegregatedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBioDegradableSegregatedActionPerformed
  
    
    private void jRefreshFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRefreshFieldsActionPerformed
        jBiodegradableCollected.setText("");
        jBioDegradableSegregated.setText("");
        jMetalCollected.setText("");
        jMetalSegregated.setText("");
        jRefresh.setEnabled(true);
        jMessageToMD.setText("");
        jMessageToBD.setText("");
        jPlasticCollected.setText("");
        jPlasticSegregated.setText("");
         jTypeOfGarbage.setEnabled(false);
        jMessageToPD.setText("");
        jG.setEnabled(false);
        jBiodegradableCollected.setEnabled(false);
        jBioDegradableSegregated.setEnabled(false);
        jMetalCollected.setEnabled(false);
        jMetalSegregated.setEnabled(false);
        jSendToMT.setEnabled(false);
        jSendToBT.setEnabled(false);
        jMessageToMD.setEnabled(false);
        jMessageToBD.setEnabled(false);
        jPlasticCollected.setEnabled(false);
        jPlasticSegregated.setEnabled(false);
        jSendToPT.setEnabled(false);
        jMessageToPD.setEnabled(false);
        jBTMT.setEnabled(false);
        jMTPT.setEnabled(false);
        jMTPTBT.setEnabled(false);
        jPTBT.setEnabled(false);
       
    }//GEN-LAST:event_jRefreshFieldsActionPerformed

    private void jSendToPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSendToPTActionPerformed
        int selectedRow = jGarbageCollector.getSelectedRow();
        GarbageCollectorWorkRequest gcwr = (GarbageCollectorWorkRequest) jGarbageCollector.getValueAt(selectedRow, 0);
        if(gcwr.getMessage().equalsIgnoreCase("Allocated")){
        JOptionPane.showMessageDialog(null, "Already Assigned");
            return;
        
        
        }
        int plasticCollected;
        int plasticSegregated;
        String message = jMessageToPD.getText();

        if (message.trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "MessageToPD cannot be null");
            return;

        }
        try {
            plasticCollected = Integer.parseInt(jPlasticCollected.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter correct Plastic Collected  value in Kgs",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            plasticSegregated = Integer.parseInt(jPlasticSegregated.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter correct plastic Segregated value in Kgs",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (plasticCollected < plasticSegregated) {

            JOptionPane.showMessageDialog(null, "Collected Plastic value cannot be less than Segregated value",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        if (plasticCollected <= 0 || plasticSegregated < 0) {

            JOptionPane.showMessageDialog(null, "Incorrect Plastic values",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }

        UserAccount ua = (UserAccount) jPlasticTransportation.getSelectedItem();

        if (ua.equals("")) {
            JOptionPane.showMessageDialog(null, "Please select a Plastic Transporter");
            return;
        }

        if (jPlasticCollected.equals("") || jPlasticSegregated.equals("")) {
            JOptionPane.showMessageDialog(null, "Please insert Plastic garbage details");
            return;

        }
        gcwr.setReceiver(userAccount);
        gcwr.setMessage("Allocated");
        gcwr.setStatus("Sent");
        gcwr.setCollectedPlastic(plasticCollected);
        gcwr.setSegregatedPlastic(plasticSegregated);
        gcwr.setMessageToPlasticDept(message);
        gcwr.setSentToPD(ua);
         gcwr.setType("Done");
//        gcwr.setCollectedDegradable(0);
//        gcwr.setCollectedPlastic(0);
//        gcwr.setMessageToBioDept("");
//        gcwr.setMessageToPlasticDept("");
//        gcwr.setSegregatedDegradable(0);
//        gcwr.setSegregatedPlastic(0);

        PlasticTransportationWorkRequest request = new PlasticTransportationWorkRequest();
        request.setMessage("To be Transported");
        request.setMessageToPlasticDept(message);
        request.setCollectedPlastic(plasticCollected);
        request.setSegregatedPlastic(plasticSegregated);
        request.setReceiver(ua);
        request.setRequestDate(gcwr.getRequestDate());

        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof PlasticTransportationOrganization) {
                org = organization;
                break;
            }
        }
        if (org != null) {

            ua.getWorkQueue().getWorkRequestList().add(request);

            JOptionPane.showMessageDialog(null, "Work request added.");
             
        }
        refresh();
    }//GEN-LAST:event_jSendToPTActionPerformed

    private void jSendToBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSendToBTActionPerformed
        int selectedRow = jGarbageCollector.getSelectedRow();
        GarbageCollectorWorkRequest gcwr = (GarbageCollectorWorkRequest) jGarbageCollector.getValueAt(selectedRow, 0);
        if(gcwr.getMessage().equalsIgnoreCase("Allocated")){
        JOptionPane.showMessageDialog(null, "Already Assigned");
            return;
        
        
        }
        int bioCollected;
        int bioSegregated;
        String message = jMessageToBD.getText();

        if (message.trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "MessageToBD cannot be null");
            return;

        }
        try {
            bioCollected = Integer.parseInt(jBiodegradableCollected.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter correct BioDegradable Collected  value in Kgs",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            bioSegregated = Integer.parseInt(jBioDegradableSegregated.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter correct BioDegradable Segregated value in Kgs",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (bioCollected < bioSegregated) {

            JOptionPane.showMessageDialog(null, "Collected BioDegradable value cannot be less than Segregated value",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        if (bioCollected <= 0 || bioSegregated < 0) {

            JOptionPane.showMessageDialog(null, "Incorrect BioDegradable values",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }

        UserAccount ua = (UserAccount) jBiodegradableTransportation.getSelectedItem();

        if (ua.equals("")) {
            JOptionPane.showMessageDialog(null, "Please select a BioDegradable Transporter");
            return;
        }

        if (jBiodegradableCollected.equals("") || jPlasticSegregated.equals("")) {
            JOptionPane.showMessageDialog(null, "Please insert BioDegradable garbage details");
            return;

        }
        
        
        
        
        gcwr.setReceiver(userAccount);
        gcwr.setMessage("Allocated");
        gcwr.setStatus("Sent");
        gcwr.setCollectedDegradable(bioCollected);
        gcwr.setSegregatedDegradable(bioSegregated);
        gcwr.setMessageToBioDept(message);
        gcwr.setSentToBD(ua);
         gcwr.setType("Done");
//        gcwr.setCollectedDegradable(0);
//        gcwr.setCollectedPlastic(0);
//        gcwr.setMessageToBioDept("");
//        gcwr.setMessageToPlasticDept("");
//        gcwr.setSegregatedDegradable(0);
//        gcwr.setSegregatedPlastic(0);

        BioTransportationWorkRequest request = new BioTransportationWorkRequest();
        request.setMessage("To be Transported");
        request.setMessageToBioDept(message);
        request.setCollectedDegradable(bioCollected);
        request.setSegregatedDegradable(bioSegregated);
        request.setReceiver(ua);
        request.setRequestDate(gcwr.getRequestDate());

        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof BioTransportationOrganization) {
                org = organization;
                break;
            }
        }
        if (org != null) {

            ua.getWorkQueue().getWorkRequestList().add(request);

            JOptionPane.showMessageDialog(null, "Work request added.");
        }
        
        refresh();
    }//GEN-LAST:event_jSendToBTActionPerformed

    private void jMTPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMTPTActionPerformed
        int selectedRow = jGarbageCollector.getSelectedRow();
        GarbageCollectorWorkRequest gcwr = (GarbageCollectorWorkRequest) jGarbageCollector.getValueAt(selectedRow, 0);
        if(gcwr.getMessage().equalsIgnoreCase("Allocated")){
        JOptionPane.showMessageDialog(null, "Already Assigned");
            return;
        
        
        }
        int metalCollected;
        int metalSegregated;
        String message = jMessageToMD.getText();

        if (message.trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "MessageToMD cannot be null");
            return;

        }
        try {
            metalCollected = Integer.parseInt(jMetalCollected.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter correct Metal Collected  value in Kgs",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            metalSegregated = Integer.parseInt(jMetalSegregated.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter correct Metal Segregated value in Kgs",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (metalCollected < metalSegregated) {

            JOptionPane.showMessageDialog(null, "Collected metal value cannot be less than Segregated value",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        if (metalCollected <= 0 || metalSegregated < 0) {

            JOptionPane.showMessageDialog(null, "Incorrect Metal values",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
         
        
        
        
         int plasticCollected;
        int plasticSegregated;
        String message1 = jMessageToPD.getText();

        if (message1.trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "MessageToPD cannot be null");
            return;

        }
        try {
            plasticCollected = Integer.parseInt(jPlasticCollected.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter correct Plastic Collected  value in Kgs",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            plasticSegregated = Integer.parseInt(jPlasticSegregated.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter correct plastic Segregated value in Kgs",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (plasticCollected < plasticSegregated) {

            JOptionPane.showMessageDialog(null, "Collected Plastic value cannot be less than Segregated value",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        if (plasticCollected <= 0 || plasticSegregated < 0) {

            JOptionPane.showMessageDialog(null, "Incorrect Plastic values",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        

        UserAccount ua = (UserAccount) jMetalTransportation.getSelectedItem();

        if (ua.equals("")) {
            JOptionPane.showMessageDialog(null, "Please select a Metal Transporter");
            return;
        }

        if (jMetalCollected.equals("") || jMetalSegregated.equals("")) {
            JOptionPane.showMessageDialog(null, "Please insert metal garbage details");
            return;

        }
        gcwr.setSentToMD(ua);
        gcwr.setMessage("Allocated");
        gcwr.setStatus("Sent");
        gcwr.setCollectedMetal(metalCollected);
        gcwr.setSegregatedMetal(metalSegregated);
        gcwr.setMessageToMetalDept(message);
        gcwr.setReceiver(userAccount);
         gcwr.setType("Done");
//        gcwr.setCollectedDegradable(0);
//        gcwr.setCollectedPlastic(0);
//        gcwr.setMessageToBioDept("");
//        gcwr.setMessageToPlasticDept("");
//        gcwr.setSegregatedDegradable(0);
//        gcwr.setSegregatedPlastic(0);
        MetalTransportationWorkRequest request = new MetalTransportationWorkRequest();
        request.setMessage("To be Transported");
        request.setMessageToMetalDept(message);
        request.setCollectedMetal(metalCollected);
        request.setSegregatedMetal(metalSegregated);
        request.setReceiver(gcwr.getSentToMD());
        request.setRequestDate(gcwr.getRequestDate());

        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof MetalTransportationOrganization) {
                org = organization;
                break;
            }
        }
        if (org != null) {

            ua.getWorkQueue().getWorkRequestList().add(request);

            JOptionPane.showMessageDialog(null, "Work request added.");
        }
        
       
        UserAccount ua1 = (UserAccount) jPlasticTransportation.getSelectedItem();

        if (ua1.equals("")) {
            JOptionPane.showMessageDialog(null, "Please select a Plastic Transporter");
            return;
        }

        if (jPlasticCollected.equals("") || jPlasticSegregated.equals("")) {
            JOptionPane.showMessageDialog(null, "Please insert Plastic garbage details");
            return;

        }
        
        gcwr.setCollectedPlastic(plasticCollected);
        gcwr.setSegregatedPlastic(plasticSegregated);
        gcwr.setMessageToPlasticDept(message1);
        gcwr.setSentToPD(ua1);
         gcwr.setType("Done");
//        gcwr.setCollectedDegradable(0);
//        gcwr.setCollectedPlastic(0);
//        gcwr.setMessageToBioDept("");
//        gcwr.setMessageToPlasticDept("");
//        gcwr.setSegregatedDegradable(0);
//        gcwr.setSegregatedPlastic(0);

        PlasticTransportationWorkRequest request1 = new PlasticTransportationWorkRequest();
        request1.setMessage("To be Transported");
        request1.setMessageToMetalDept(message1);
        request1.setCollectedPlastic(plasticCollected);
        request1.setSegregatedPlastic(plasticSegregated);
        request1.setReceiver(ua1);
        request1.setRequestDate(gcwr.getRequestDate());

        Organization org1 = null;
        for (Organization organization1 : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization1 instanceof PlasticTransportationOrganization) {
                org1 = organization1;
                break;
            }
        }
        if (org1 != null) {

            ua1.getWorkQueue().getWorkRequestList().add(request1);

            JOptionPane.showMessageDialog(null, "Work request1 added.");
             
        }
        refresh();
        
    }//GEN-LAST:event_jMTPTActionPerformed

    private void jPTBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPTBTActionPerformed
         int selectedRow = jGarbageCollector.getSelectedRow();
         GarbageCollectorWorkRequest gcwr = (GarbageCollectorWorkRequest) jGarbageCollector.getValueAt(selectedRow, 0);
        if(gcwr.getMessage().equalsIgnoreCase("Allocated")){
        JOptionPane.showMessageDialog(null, "Already Assigned");
            return;
        
        
        }
        int bioCollected;
        int bioSegregated;
        String message = jMessageToBD.getText();

        if (message.trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "MessageToBD cannot be null");
            return;

        }
        try {
            bioCollected = Integer.parseInt(jBiodegradableCollected.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter correct BioDegradable Collected  value in Kgs",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            bioSegregated = Integer.parseInt(jBioDegradableSegregated.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter correct BioDegradable Segregated value in Kgs",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (bioCollected < bioSegregated) {

            JOptionPane.showMessageDialog(null, "Collected BioDegradable value cannot be less than Segregated value",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        if (bioCollected <= 0 || bioSegregated < 0) {

            JOptionPane.showMessageDialog(null, "Incorrect BioDegradable values",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }

        UserAccount ua = (UserAccount) jBiodegradableTransportation.getSelectedItem();

        if (ua.equals("")) {
            JOptionPane.showMessageDialog(null, "Please select a BioDegradable Transporter");
            return;
        }

        if (jBiodegradableCollected.equals("") || jPlasticSegregated.equals("")) {
            JOptionPane.showMessageDialog(null, "Please insert BioDegradable garbage details");
            return;

        }
        
        
        int plasticCollected;
        int plasticSegregated;
        String message1 = jMessageToPD.getText();

        if (message1.trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "MessageToPD cannot be null");
            return;

        }
        try {
            plasticCollected = Integer.parseInt(jPlasticCollected.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter correct Plastic Collected  value in Kgs",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            plasticSegregated = Integer.parseInt(jPlasticSegregated.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter correct plastic Segregated value in Kgs",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (plasticCollected < plasticSegregated) {

            JOptionPane.showMessageDialog(null, "Collected Plastic value cannot be less than Segregated value",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        if (plasticCollected <= 0 || plasticSegregated < 0) {

            JOptionPane.showMessageDialog(null, "Incorrect Plastic values",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        
        gcwr.setReceiver(userAccount);
        gcwr.setMessage("Allocated");
        gcwr.setStatus("Sent");
        gcwr.setCollectedDegradable(bioCollected);
        gcwr.setSegregatedDegradable(bioSegregated);
        gcwr.setMessageToBioDept(message);
        gcwr.setSentToBD(ua);
         gcwr.setType("Done");
//        gcwr.setCollectedDegradable(0);
//        gcwr.setCollectedPlastic(0);
//        gcwr.setMessageToBioDept("");
//        gcwr.setMessageToPlasticDept("");
//        gcwr.setSegregatedDegradable(0);
//        gcwr.setSegregatedPlastic(0);

        BioTransportationWorkRequest request = new BioTransportationWorkRequest();
        request.setMessage("To be Transported");
        request.setMessageToBioDept(message);
        request.setCollectedDegradable(bioCollected);
        request.setSegregatedDegradable(bioSegregated);
        request.setReceiver(ua);
        request.setRequestDate(gcwr.getRequestDate());

        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof BioTransportationOrganization) {
                org = organization;
                break;
            }
        }
        if (org != null) {

            ua.getWorkQueue().getWorkRequestList().add(request);

            JOptionPane.showMessageDialog(null, "Work request added.");
        }
         
        

        UserAccount ua1 = (UserAccount) jPlasticTransportation.getSelectedItem();

        if (ua1.equals("")) {
            JOptionPane.showMessageDialog(null, "Please select a Plastic Transporter");
            return;
        }

        if (jPlasticCollected.equals("") || jPlasticSegregated.equals("")) {
            JOptionPane.showMessageDialog(null, "Please insert Plastic garbage details");
            return;

        }
        
        gcwr.setCollectedPlastic(plasticCollected);
        gcwr.setSegregatedPlastic(plasticSegregated);
        gcwr.setMessageToPlasticDept(message1);
        gcwr.setSentToPD(ua1);
         gcwr.setType("Done");
//        gcwr.setCollectedDegradable(0);
//        gcwr.setCollectedPlastic(0);
//        gcwr.setMessageToBioDept("");
//        gcwr.setMessageToPlasticDept("");
//        gcwr.setSegregatedDegradable(0);
//        gcwr.setSegregatedPlastic(0);

        PlasticTransportationWorkRequest request1 = new PlasticTransportationWorkRequest();
        request1.setMessage("To be Transported");
        request1.setMessageToPlasticDept(message1);
        request1.setCollectedPlastic(plasticCollected);
        request1.setSegregatedPlastic(plasticSegregated);
        request1.setReceiver(ua1);
        request1.setRequestDate(gcwr.getRequestDate());

        Organization org1 = null;
        for (Organization organization1 : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization1 instanceof PlasticTransportationOrganization) {
                org1 = organization1;
                break;
            }
        }
        if (org1 != null) {

            ua1.getWorkQueue().getWorkRequestList().add(request1);

            JOptionPane.showMessageDialog(null, "Work request1 added.");
             
        }
        
        
        refresh();
        
        
        
    }//GEN-LAST:event_jPTBTActionPerformed

    private void jBTMTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTMTActionPerformed
       int selectedRow = jGarbageCollector.getSelectedRow();
       GarbageCollectorWorkRequest gcwr = (GarbageCollectorWorkRequest) jGarbageCollector.getValueAt(selectedRow, 0);
        if(gcwr.getMessage().equalsIgnoreCase("Allocated")){
        JOptionPane.showMessageDialog(null, "Already Assigned");
            return;
        
        
        }
        int metalCollected;
        int metalSegregated;
        String message = jMessageToMD.getText();

        if (message.trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "MessageToMD cannot be null");
            return;

        }
        try {
            metalCollected = Integer.parseInt(jMetalCollected.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter correct Metal Collected  value in Kgs",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            metalSegregated = Integer.parseInt(jMetalSegregated.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter correct Metal Segregated value in Kgs",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (metalCollected < metalSegregated) {

            JOptionPane.showMessageDialog(null, "Collected metal value cannot be less than Segregated value",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        if (metalCollected <= 0 || metalSegregated < 0) {

            JOptionPane.showMessageDialog(null, "Incorrect Metal values",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }

        UserAccount ua = (UserAccount) jMetalTransportation.getSelectedItem();

        if (ua.equals("")) {
            JOptionPane.showMessageDialog(null, "Please select a Metal Transporter");
            return;
        }

        if (jMetalCollected.equals("") || jMetalSegregated.equals("")) {
            JOptionPane.showMessageDialog(null, "Please insert metal garbage details");
            return;

        }
        
          
         int bioCollected;
        int bioSegregated;
        String message2 = jMessageToBD.getText();

        if (message2.trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "MessageToBD cannot be null");
            return;

        }
        try {
            bioCollected = Integer.parseInt(jBiodegradableCollected.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter correct BioDegradable Collected  value in Kgs",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            bioSegregated = Integer.parseInt(jBioDegradableSegregated.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter correct BioDegradable Segregated value in Kgs",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (bioCollected < bioSegregated) {

            JOptionPane.showMessageDialog(null, "Collected BioDegradable value cannot be less than Segregated value",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        if (bioCollected <= 0 || bioSegregated < 0) {

            JOptionPane.showMessageDialog(null, "Incorrect BioDegradable values",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        
        gcwr.setSentToMD(ua);
        gcwr.setMessage("Allocated");
        gcwr.setStatus("Sent");
        gcwr.setCollectedMetal(metalCollected);
        gcwr.setSegregatedMetal(metalSegregated);
        gcwr.setMessageToMetalDept(message);
        gcwr.setReceiver(userAccount);
         gcwr.setType("Done");
//        gcwr.setCollectedDegradable(0);
//        gcwr.setCollectedPlastic(0);
//        gcwr.setMessageToBioDept("");
//        gcwr.setMessageToPlasticDept("");
//        gcwr.setSegregatedDegradable(0);
//        gcwr.setSegregatedPlastic(0);
        MetalTransportationWorkRequest request = new MetalTransportationWorkRequest();
        request.setMessage("To be Transported");
        request.setMessageToMetalDept(message);
        request.setCollectedMetal(metalCollected);
        request.setSegregatedMetal(metalSegregated);
        request.setReceiver(gcwr.getSentToMD());
        request.setRequestDate(gcwr.getRequestDate());

        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof MetalTransportationOrganization) {
                org = organization;
                break;
            }
        }
        if (org != null) {

            ua.getWorkQueue().getWorkRequestList().add(request);

            JOptionPane.showMessageDialog(null, "Work request added.");
        }
        
      

        UserAccount ua2 = (UserAccount) jBiodegradableTransportation.getSelectedItem();

        if (ua2.equals("")) {
            JOptionPane.showMessageDialog(null, "Please select a BioDegradable Transporter");
            return;
        }

        if (jBiodegradableCollected.equals("") || jPlasticSegregated.equals("")) {
            JOptionPane.showMessageDialog(null, "Please insert BioDegradable garbage details");
            return;

        }
        
        gcwr.setCollectedDegradable(bioCollected);
        gcwr.setSegregatedDegradable(bioSegregated);
        gcwr.setMessageToBioDept(message2);
        gcwr.setSentToBD(ua2);
         gcwr.setType("Done");
//        gcwr.setCollectedDegradable(0);
//        gcwr.setCollectedPlastic(0);
//        gcwr.setMessageToBioDept("");
//        gcwr.setMessageToPlasticDept("");
//        gcwr.setSegregatedDegradable(0);
//        gcwr.setSegregatedPlastic(0);

        BioTransportationWorkRequest request2 = new BioTransportationWorkRequest();
        request2.setMessage("To be Transported");
        request2.setMessageToBioDept(message2);
        request2.setCollectedDegradable(bioCollected);
        request2.setSegregatedDegradable(bioSegregated);
        request2.setReceiver(ua2);
        request2.setRequestDate(gcwr.getRequestDate());

        Organization org2 = null;
        for (Organization organization2 : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization2 instanceof BioTransportationOrganization) {
                org2 = organization2;
                break;
            }
        }
        if (org2 != null) {

            ua2.getWorkQueue().getWorkRequestList().add(request2);

            JOptionPane.showMessageDialog(null, "Work request2 added.");
             
        }
        refresh();
    }//GEN-LAST:event_jBTMTActionPerformed

    private void jMTPTBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMTPTBTActionPerformed
        int selectedRow = jGarbageCollector.getSelectedRow();
        GarbageCollectorWorkRequest gcwr = (GarbageCollectorWorkRequest) jGarbageCollector.getValueAt(selectedRow, 0);
        if(gcwr.getMessage().equalsIgnoreCase("Allocated")){
        JOptionPane.showMessageDialog(null, "Already Assigned");
            return;
        
        
        }
        int metalCollected;
        int metalSegregated;
        String message = jMessageToMD.getText();

        if (message.trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "MessageToMD cannot be null");
            return;

        }
        try {
            metalCollected = Integer.parseInt(jMetalCollected.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter correct Metal Collected  value in Kgs",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            metalSegregated = Integer.parseInt(jMetalSegregated.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter correct Metal Segregated value in Kgs",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (metalCollected < metalSegregated) {

            JOptionPane.showMessageDialog(null, "Collected metal value cannot be less than Segregated value",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        if (metalCollected <= 0 || metalSegregated < 0) {

            JOptionPane.showMessageDialog(null, "Incorrect Metal values",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }

        UserAccount ua = (UserAccount) jMetalTransportation.getSelectedItem();

        if (ua.equals("")) {
            JOptionPane.showMessageDialog(null, "Please select a Metal Transporter");
            return;
        }

        if (jMetalCollected.equals("") || jMetalSegregated.equals("")) {
            JOptionPane.showMessageDialog(null, "Please insert metal garbage details");
            return;

        }
        
        
           int bioCollected;
        int bioSegregated;
        String message2 = jMessageToBD.getText();

        if (message2.trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "MessageToBD cannot be null");
            return;

        }
        try {
            bioCollected = Integer.parseInt(jBiodegradableCollected.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter correct BioDegradable Collected  value in Kgs",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            bioSegregated = Integer.parseInt(jBioDegradableSegregated.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter correct BioDegradable Segregated value in Kgs",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (bioCollected < bioSegregated) {

            JOptionPane.showMessageDialog(null, "Collected BioDegradable value cannot be less than Segregated value",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        if (bioCollected <= 0 || bioSegregated < 0) {

            JOptionPane.showMessageDialog(null, "Incorrect BioDegradable values",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
         int plasticCollected;
        int plasticSegregated;
        String message1 = jMessageToPD.getText();

        if (message1.trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "MessageToPD cannot be null");
            return;

        }
        try {
            plasticCollected = Integer.parseInt(jPlasticCollected.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter correct Plastic Collected  value in Kgs",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            plasticSegregated = Integer.parseInt(jPlasticSegregated.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter correct plastic Segregated value in Kgs",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (plasticCollected < plasticSegregated) {

            JOptionPane.showMessageDialog(null, "Collected Plastic value cannot be less than Segregated value",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        if (plasticCollected <= 0 || plasticSegregated < 0) {

            JOptionPane.showMessageDialog(null, "Incorrect Plastic values",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;

        }
        

        gcwr.setSentToMD(ua);
        gcwr.setMessage("Allocated");
        gcwr.setStatus("Sent");
        gcwr.setCollectedMetal(metalCollected);
        gcwr.setSegregatedMetal(metalSegregated);
        gcwr.setMessageToMetalDept(message);
        gcwr.setReceiver(userAccount);
         gcwr.setType("Done");
//     
        MetalTransportationWorkRequest request = new MetalTransportationWorkRequest();
        request.setMessage("To be transported");
        request.setMessageToMetalDept(message);
        request.setCollectedMetal(metalCollected);
        request.setSegregatedMetal(metalSegregated);
        request.setReceiver(gcwr.getSentToMD());
        request.setRequestDate(gcwr.getRequestDate());

        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof MetalTransportationOrganization) {
                org = organization;
                break;
            }
        }
        if (org != null) {

            ua.getWorkQueue().getWorkRequestList().add(request);

            JOptionPane.showMessageDialog(null, "Work request added.");
        }
        
        
      

        UserAccount ua2 = (UserAccount) jBiodegradableTransportation.getSelectedItem();

        if (ua2.equals("")) {
            JOptionPane.showMessageDialog(null, "Please select a BioDegradable Transporter");
            return;
        }

        if (jBiodegradableCollected.equals("") || jPlasticSegregated.equals("")) {
            JOptionPane.showMessageDialog(null, "Please insert BioDegradable garbage details");
            return;

        }
        
        gcwr.setCollectedDegradable(bioCollected);
        gcwr.setSegregatedDegradable(bioSegregated);
        gcwr.setMessageToBioDept(message2);
        gcwr.setSentToBD(ua2);
//        gcwr.setCollectedDegradable(0);
//        gcwr.setCollectedPlastic(0);
//        gcwr.setMessageToBioDept("");
//        gcwr.setMessageToPlasticDept("");
//        gcwr.setSegregatedDegradable(0);
//        gcwr.setSegregatedPlastic(0);

        BioTransportationWorkRequest request2 = new BioTransportationWorkRequest();
        request2.setMessage("To be Transported");
        request2.setMessageToBioDept(message2);
        request2.setCollectedDegradable(bioCollected);
        request2.setSegregatedDegradable(bioSegregated);
        request2.setReceiver(ua2);
        request2.setRequestDate(gcwr.getRequestDate());

        Organization org2 = null;
        for (Organization organization2 : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization2 instanceof BioTransportationOrganization) {
                org2 = organization2;
                break;
            }
        }
        if (org2 != null) {

            ua2.getWorkQueue().getWorkRequestList().add(request2);

            JOptionPane.showMessageDialog(null, "Work request2 added.");
        }
        
       
        UserAccount ua1 = (UserAccount) jPlasticTransportation.getSelectedItem();

        if (ua1.equals("")) {
            JOptionPane.showMessageDialog(null, "Please select a Plastic Transporter");
            return;
        }

        if (jPlasticCollected.equals("") || jPlasticSegregated.equals("")) {
            JOptionPane.showMessageDialog(null, "Please insert Plastic garbage details");
            return;

        }
        
        gcwr.setCollectedPlastic(plasticCollected);
        gcwr.setSegregatedPlastic(plasticSegregated);
        gcwr.setMessageToPlasticDept(message1);
        gcwr.setSentToPD(ua1);
//        gcwr.setCollectedDegradable(0);
//        gcwr.setCollectedPlastic(0);
//        gcwr.setMessageToBioDept("");
//        gcwr.setMessageToPlasticDept("");
//        gcwr.setSegregatedDegradable(0);
//        gcwr.setSegregatedPlastic(0);

        PlasticTransportationWorkRequest request1 = new PlasticTransportationWorkRequest();
        request1.setMessage("To be Transported");
        request1.setMessageToPlasticDept(message1);
        request1.setCollectedPlastic(plasticCollected);
        request1.setSegregatedPlastic(plasticSegregated);
        request1.setReceiver(ua1);
        request1.setRequestDate(gcwr.getRequestDate());

        Organization org1 = null;
        for (Organization organization1 : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization1 instanceof PlasticTransportationOrganization) {
                org1 = organization1;
                break;
            }
        }
        if (org1 != null) {

            ua1.getWorkQueue().getWorkRequestList().add(request1);

            JOptionPane.showMessageDialog(null, "Work request1 added.");
        }
        
         refresh();
    }//GEN-LAST:event_jMTPTBTActionPerformed

    private void jGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGActionPerformed
       int selectedRow = jGarbageCollector.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        
        
      
        GarbageCollectorWorkRequest gmwr = (GarbageCollectorWorkRequest) jGarbageCollector.getValueAt(selectedRow, 0);
        
        
        if(gmwr.getMessage().equalsIgnoreCase("Allocated")){
        JOptionPane.showMessageDialog(null, "Already Assigned");
       return;}
      if(gmwr.getType().equalsIgnoreCase("Suspected")){
        String metal = gmwr.getMetalGarbageStatus();

        String plastic = gmwr.getPlasticStatus();
        String bio = gmwr.getBiodegradableStatus();
        if (bio.equalsIgnoreCase("No BioGarbage") && metal.equalsIgnoreCase("No Metal") && (!plastic.equalsIgnoreCase("No Plastic"))) {
            jPlasticCollected.setEnabled(true);
            jPlasticSegregated.setEnabled(true);
            jSendToPT.setEnabled(true);
            jMessageToPD.setEnabled(true);
        }
      else  if ((bio.equalsIgnoreCase("No BioGarbage")) && (plastic.equalsIgnoreCase("No Plastic")) && (!metal.equalsIgnoreCase("No Metal"))) {
            jMetalCollected.setEnabled(true);
            jMetalSegregated.setEnabled(true);
            jSendToMT.setEnabled(true);
            jMessageToMD.setEnabled(true);
        }
      else  if ((plastic.equalsIgnoreCase("No Plastic")) && (metal.equalsIgnoreCase("No Metal")) && (!bio.equalsIgnoreCase("No BioGarbage"))) {

            jBiodegradableCollected.setEnabled(true);
            jBioDegradableSegregated.setEnabled(true);
            jSendToBT.setEnabled(true);
            jMessageToBD.setEnabled(true);
        }

       else if ((!plastic.equalsIgnoreCase("No Plastic")) && (!metal.equalsIgnoreCase("No Metal")) && (!bio.equalsIgnoreCase("No BioGarbage"))) {

            jBiodegradableCollected.setEnabled(true);
            jBioDegradableSegregated.setEnabled(true);
            jMTPTBT.setEnabled(true);
            jMessageToBD.setEnabled(true);
            jPlasticCollected.setEnabled(true);
            jPlasticSegregated.setEnabled(true);
            jMetalCollected.setEnabled(true);
            jMetalSegregated.setEnabled(true);
            
            
            jMessageToMD.setEnabled(true);
            jMessageToPD.setEnabled(true);
        }
      else  if (metal.equalsIgnoreCase("No Metal")&&(!plastic.equalsIgnoreCase("No Plastic"))&&(!bio.equalsIgnoreCase("No BioGarbage"))) {
            jBiodegradableCollected.setEnabled(true);
            jBioDegradableSegregated.setEnabled(true);
            jPlasticCollected.setEnabled(true);
            jPlasticSegregated.setEnabled(true);
            jPTBT.setEnabled(true);
            
            jMessageToBD.setEnabled(true);
            jMessageToPD.setEnabled(true);

        }
      else  if (plastic.equalsIgnoreCase("No Plastic")&& (!bio.equalsIgnoreCase("No BioGarbage"))&& (!metal.equalsIgnoreCase("No Metal"))) {
            jBiodegradableCollected.setEnabled(true);
            jBioDegradableSegregated.setEnabled(true);
            jMetalCollected.setEnabled(true);
            jMetalSegregated.setEnabled(true);
            jBTMT.setEnabled(true);
           
            jMessageToMD.setEnabled(true);
            jMessageToBD.setEnabled(true);

        }
      else  if (bio.equalsIgnoreCase("No BioGarbage") && (!metal.equalsIgnoreCase("No Metal")) && (!plastic.equalsIgnoreCase("No Plastic"))) {
            jPlasticCollected.setEnabled(true);
            jPlasticSegregated.setEnabled(true);
            jMetalCollected.setEnabled(true);
            jMetalSegregated.setEnabled(true);
            jMTPT.setEnabled(true);
           
            jMessageToMD.setEnabled(true);
            jMessageToPD.setEnabled(true);

        }
        JOptionPane.showMessageDialog(null, "Done");
        jG.setEnabled(false);
       
      }
      
      
      else{
      
      JOptionPane.showMessageDialog(null, "Please complete Suspected Workrequest");
      
      return;
      }
    }//GEN-LAST:event_jGActionPerformed

    private void jAWMRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAWMRActionPerformed
//        String occurrance;
//        String smax=null;
//        int rowcnt=jGarbageCollector.getRowCount();
//       int count=0;
//       int max=0;
//               
//                for(int row = 0; row < jGarbageCollector.getRowCount(); row++) {
//                    occurrance= jGarbageCollector.getValueAt(row, 1).toString();
//                        if (jGarbageCollector.getValueAt(row, 1).equals(occurrance) )
//                            count++;
//                    
//                 if (count > max)
//                 {
//                 max = count;
//
//               smax=occurrance;}
//                
//                
//                }
//               jMaxArea.setText(smax);
               
               String occ;
               String Smax=null;
               int max=0;
               int counti=0;
               int countj=0;
               int rowcount=jGarbageCollector.getRowCount();
               
               for(int i=0;i<rowcount;i++){
               occ= jGarbageCollector.getValueAt(i, 1).toString();
               for(int j=0;j<rowcount;j++){
               if(jGarbageCollector.getValueAt(j, 1).toString().equalsIgnoreCase(occ))
               {countj++;
                
               
               
               
               }
               
               
               }
               if(countj>max){
               max=countj;
               Smax=occ;
               
               }
               countj=0;
                
               }
               
               jMaxArea.setText(Smax);
               
                
    }//GEN-LAST:event_jAWMRActionPerformed

    private void jMaxAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMaxAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMaxAreaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
         int mCollected= getSumMCollected();
         int pCollected=getSumpCollected();
         int bcollected=getSumbCollected();
       
            dataset.setValue(mCollected, "Metal collected", "" +"Metal collected");
            dataset.setValue(pCollected, "Plastic collected", "" + "Plastic collected");
            dataset.setValue(bcollected, "BioDegradable Collected", "" + "BioDegradable Collected");
        
        JFreeChart chart = ChartFactory.createBarChart("Bar Chart Demo", "Category", "Value", dataset, PlotOrientation.VERTICAL.VERTICAL, true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart, false);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        ChartFrame cFrame = new ChartFrame("Name", chart);
        cFrame.pack();
        cFrame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          DefaultCategoryDataset dataset = new DefaultCategoryDataset();
         int mCollected= getSumMSegregated();
         int pCollected=getSumpSegregated();
         int bcollected=getSumbSegregated();
       
            dataset.setValue(mCollected, "Metal Segregated", "" +"Metal Segregated");
            dataset.setValue(pCollected, "Plastic Segregated", "" + "Plastic Segregated");
            dataset.setValue(bcollected, "BioDegradable Segregated", "" + "BioDegradable Segregated");
        
        JFreeChart chart = ChartFactory.createBarChart("Bar Chart Demo", "Category", "Value", dataset, PlotOrientation.VERTICAL.VERTICAL, true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart, false);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        ChartFrame cFrame = new ChartFrame("Name", chart);
        cFrame.pack();
        cFrame.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
     
       public void populateMetalTransportation() {

        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof MetalTransportationOrganization) {

                org = organization;
                break;
            }
        }
        if (org != null) {
            jMetalTransportation.removeAllItems();
            for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {
                jMetalTransportation.addItem(ua);
            }
        }
    }

    public void populatePlasticTransportation() {

        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof PlasticTransportationOrganization) {

                org = organization;
                break;
            }
        }
        if (org != null) {
            jPlasticTransportation.removeAllItems();
            for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {
                jPlasticTransportation.addItem(ua);
            }
        }
        
        
        
        
    }

    public void populateBioDegradableTransportation() {

        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof BioTransportationOrganization) {

                org = organization;
                break;
            }
        }
        if (org != null) {
            jBiodegradableTransportation.removeAllItems();
            for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {
                jBiodegradableTransportation.addItem(ua);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAWMR;
    private javax.swing.JButton jBTMT;
    private javax.swing.JTextField jBioDegradableSegregated;
    private javax.swing.JTextField jBiodegradableCollected;
    private javax.swing.JComboBox jBiodegradableTransportation;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JToggleButton jG;
    private javax.swing.JTable jGarbageCollector;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jMTPT;
    private javax.swing.JButton jMTPTBT;
    private javax.swing.JTextField jMaxArea;
    private javax.swing.JTextField jMessageToBD;
    private javax.swing.JTextField jMessageToMD;
    private javax.swing.JTextField jMessageToPD;
    private javax.swing.JTextField jMetalCollected;
    private javax.swing.JTextField jMetalSegregated;
    private javax.swing.JComboBox jMetalTransportation;
    private javax.swing.JButton jPTBT;
    private javax.swing.JTextField jPlasticCollected;
    private javax.swing.JTextField jPlasticSegregated;
    private javax.swing.JComboBox jPlasticTransportation;
    private javax.swing.JButton jRefresh;
    private javax.swing.JButton jRefreshFields;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jSendToBT;
    private javax.swing.JButton jSendToMT;
    private javax.swing.JButton jSendToPT;
    private javax.swing.JButton jTypeOfGarbage;
    // End of variables declaration//GEN-END:variables
}
