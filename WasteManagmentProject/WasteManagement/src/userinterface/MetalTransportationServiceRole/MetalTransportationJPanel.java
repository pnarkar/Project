/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.MetalTransportationServiceRole;

import Business.Enterprise.Enterprise;
import Business.Organization.MetalRecyclingOrganization;
import Business.Organization.MetalTransportationOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.GarbageCollectorWorkRequest;
import Business.WorkQueue.MetalRecyclingWorkRequest;
import Business.WorkQueue.MetalTransportationWorkRequest;
import Business.WorkQueue.WorkRequest;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pranalinarkar
 */
public class MetalTransportationJPanel extends javax.swing.JPanel {
  private JPanel userProcessContainer;
    private MetalTransportationOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    /**
     * Creates new form MetalTransportationJPanel
     */
   

    public MetalTransportationJPanel(JPanel userProcessContainer, UserAccount userAccount, MetalTransportationOrganization metalTransportationOrganization, Enterprise enterprise) {
       initComponents();
       this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        populateMetalRecycler();
        populateRequestTable();
    }

    
    
    
     public void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) jMetalTransortation.getModel();

        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            Object[] row = new Object[4];
            row[0] = request;
           
            row[1] = ((MetalTransportationWorkRequest) request).getSegregatedMetal();
           
            row[2] = ((MetalTransportationWorkRequest) request).getReceiver();
            
            row[3] = ((MetalTransportationWorkRequest) request).getSentToMD();
            

            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jMetalTransortation = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMetalRecycling = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jRefresh = new javax.swing.JButton();
        jSent = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jMetalTransortation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Message", "Metal Transported(Kgs)", "Sender", "Receiver", "Charges"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jMetalTransortation);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 188, 586, 90));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Metal Transportation WorkArea");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 20, -1, 25));

        jMetalRecycling.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jMetalRecycling, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 297, -1, -1));

        jLabel2.setText("Metal Recycler");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 325, -1, -1));

        jRefresh.setText("Refresh");
        jRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRefreshActionPerformed(evt);
            }
        });
        add(jRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 296, -1, -1));

        jSent.setText("Sent");
        jSent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSentActionPerformed(evt);
            }
        });
        add(jSent, new org.netbeans.lib.awtextra.AbsoluteConstraints(662, 296, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/transportationicon.jpg"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    
    
    public void populateMetalRecycler() {

        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof MetalRecyclingOrganization) {

                org = organization;
                break;
            }
        }
        if (org != null) {
            jMetalRecycling.removeAllItems();
            for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {
                jMetalRecycling.addItem(ua);
            }
        }
    }
    private void jSentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSentActionPerformed
    int selectedRow = jMetalTransortation.getSelectedRow();
    if(selectedRow<0){JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
     UserAccount ua = (UserAccount) jMetalRecycling.getSelectedItem();
        MetalTransportationWorkRequest gcwr = (MetalTransportationWorkRequest) jMetalTransortation.getValueAt(selectedRow, 0);
         if(gcwr.getMessage().equalsIgnoreCase("Sent To Recycling")){
        JOptionPane.showMessageDialog(null, "Already Assigned");
            return;
        
        }
        String Message="Sent To Recycling";
                gcwr.setMessage(Message);
                gcwr.setSentToMD(ua);
                int dis= gcwr.getDistanceTravelled();
        int moneyPerKm=1;
        int total= dis*moneyPerKm;
        gcwr.setMoneyEarned(total);
        gcwr.setDistanceTravelled(dis);
        
        MetalRecyclingWorkRequest mrwk = new MetalRecyclingWorkRequest();
        mrwk.setMessage("New recycling Batch");
        mrwk.setSegregatedMetal(gcwr.getSegregatedMetal());
        mrwk.setSender(mrwk.getReceiver());
        mrwk.setReceiver(ua);
        mrwk.setRequestDate(gcwr.getRequestDate());
         Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof MetalRecyclingOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
          
          ua.getWorkQueue().getWorkRequestList().add(mrwk);
            
            
             JOptionPane.showMessageDialog(null,"Work request added.");
        }
    }//GEN-LAST:event_jSentActionPerformed

    private void jRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRefreshActionPerformed
       DefaultTableModel model = (DefaultTableModel) jMetalTransortation.getModel();

        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            Object[] row = new Object[5];
            row[0] = request;
           
            row[1] = ((MetalTransportationWorkRequest) request).getSegregatedMetal();
           
            row[2] = ((MetalTransportationWorkRequest) request).getReceiver();
            
            row[3] = ((MetalTransportationWorkRequest) request).getSentToMD();
            
            row[4] = ((MetalTransportationWorkRequest) request).getMoneyEarned();

            model.addRow(row);
        }
    }//GEN-LAST:event_jRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox jMetalRecycling;
    private javax.swing.JTable jMetalTransortation;
    private javax.swing.JButton jRefresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jSent;
    // End of variables declaration//GEN-END:variables
}
