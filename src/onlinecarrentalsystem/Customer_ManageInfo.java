/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package onlinecarrentalsystem;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class Customer_ManageInfo extends javax.swing.JFrame {
    private Customer customer;
    private FileHandling fh;
    /**
     * Creates new form Customer_ManageInfo
     */
    public Customer_ManageInfo() {
        initComponents();
        customer = new Customer();
        fh = new FileHandling();
        getContentPane().setBackground(new java.awt.Color(204,204,255));
        
        setTextField();
    }
    
    public void setTextField(){
        customer.setCustomerID(fh.getCurrentCustomer());
        if(customer.searchCustomer()){
            cusRegistUN.setText(customer.getCustomerUsername());
            cusRegistPassword.setText(customer.getCustomerPassword());
            cusRegistName.setText(customer.getCustomerName());
            cusRegistContact.setText(customer.getCustomerContact());
            cusRegistEmail.setText(customer.getCustomerEmail());
            cusRegistIC.setText(customer.getCustomerIC());
            Address.setText(customer.getCustomerAddress());
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

        editBtn = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        menuBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Address = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        cusRegistIC = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cusRegistEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cusRegistContact = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cusRegistName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cusRegistPassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        cusRegistUN = new javax.swing.JTextField();
        cusUsername = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        editBtn.setBackground(new java.awt.Color(102, 0, 255));
        editBtn.setFont(new java.awt.Font("Candara", 0, 24)); // NOI18N
        editBtn.setForeground(new java.awt.Color(255, 255, 255));
        editBtn.setText("Edit");
        editBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(204, 204, 255));
        jTextField1.setFont(new java.awt.Font("Candara", 1, 36)); // NOI18N
        jTextField1.setText("Personal Information");
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        menuBtn.setBackground(new java.awt.Color(255, 102, 153));
        menuBtn.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        menuBtn.setForeground(new java.awt.Color(255, 255, 255));
        menuBtn.setText("Menu");
        menuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBtnActionPerformed(evt);
            }
        });

        Address.setColumns(20);
        Address.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        Address.setLineWrap(true);
        Address.setRows(5);
        jScrollPane1.setViewportView(Address);

        jLabel7.setBackground(new java.awt.Color(204, 204, 255));
        jLabel7.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel7.setText("Address");

        cusRegistIC.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N

        jLabel8.setBackground(new java.awt.Color(204, 204, 255));
        jLabel8.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel8.setText("IC / Passport");

        cusRegistEmail.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N

        jLabel5.setBackground(new java.awt.Color(204, 204, 255));
        jLabel5.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel5.setText("Email");

        cusRegistContact.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel1.setText("Contact Number");

        cusRegistName.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N

        jLabel4.setBackground(new java.awt.Color(204, 204, 255));
        jLabel4.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel4.setText("Name");

        cusRegistPassword.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N

        jLabel6.setBackground(new java.awt.Color(204, 204, 255));
        jLabel6.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel6.setText("Password");

        cusRegistUN.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N

        cusUsername.setBackground(new java.awt.Color(204, 204, 255));
        cusUsername.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        cusUsername.setText("Username");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(menuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cusUsername)
                        .addComponent(cusRegistUN)
                        .addComponent(cusRegistPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cusRegistName, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cusRegistContact, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cusRegistEmail, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cusRegistIC, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(editBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cusUsername)
                .addGap(3, 3, 3)
                .addComponent(cusRegistUN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cusRegistPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cusRegistName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cusRegistContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cusRegistEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cusRegistIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editBtn)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        // TODO add your handling code here:
        FileHandling fh = new FileHandling();
        String custID = fh.getCurrentCustomer();
        ArrayList<String> custArray = new ArrayList<String>();
        custArray.add(custID);
        custArray.add(cusRegistUN.getText());
        custArray.add(cusRegistPassword.getText());
        custArray.add(cusRegistName.getText());
        custArray.add(cusRegistContact.getText());
        custArray.add(cusRegistEmail.getText());
        custArray.add(cusRegistIC.getText());
        custArray.add(Address.getText());
        if (!cusRegistUN.getText().equals("")&& 
                !cusRegistPassword.getText().equals("") &&
                !cusRegistName.getText().equals("") &&
                !cusRegistContact.getText().equals("") &&
                !cusRegistEmail.getText().equals("") &&
                !cusRegistIC.getText().equals("") &&
                !Address.getText().equals("")
            ){
            customer.modifyCustomer(custArray);
        }else{
            JOptionPane.showMessageDialog(null, "Please fill up all the information.");
        }
        
        
    }//GEN-LAST:event_editBtnActionPerformed

    private void menuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBtnActionPerformed
        // TODO add your handling code here:
        Customer_HomePage menu = new Customer_HomePage();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Customer_ManageInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer_ManageInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer_ManageInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer_ManageInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer_ManageInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Address;
    private javax.swing.JTextField cusRegistContact;
    private javax.swing.JTextField cusRegistEmail;
    private javax.swing.JTextField cusRegistIC;
    private javax.swing.JTextField cusRegistName;
    private javax.swing.JPasswordField cusRegistPassword;
    private javax.swing.JTextField cusRegistUN;
    private javax.swing.JLabel cusUsername;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton menuBtn;
    // End of variables declaration//GEN-END:variables
}
