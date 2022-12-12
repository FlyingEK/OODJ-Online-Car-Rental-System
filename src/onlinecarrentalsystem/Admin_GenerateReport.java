/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package onlinecarrentalsystem;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author User
 */
public class Admin_GenerateReport extends javax.swing.JFrame{

    private Booking booking;
    private Car car;
    private FileHandling fh;
    private Report rp;
    private Payment pay;
    
    /**
     * Creates new form Admin_GenerateReport
     */
    public Admin_GenerateReport() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(204,204,255));
        
        booking = new Booking();
        car = new Car();
        fh = new FileHandling();
        rp = new Report();
        pay = new Payment();
        
        
        //booking report
        pupolateTable();
        totalBook.setText(rp.totalBooking());
        totalBookCust.setText(rp.totalBookingCustomer());
        highestBook.setText(rp.highestBooking());
        AverageRent.setText(rp.averageDate());
        rejected.setText(rp.rejectedBooking());
        
        //payment report
        pupolatePaymentTable();
        totalPayment.setText(rp.totalPayment());
        totalPayCust.setText(rp.totalPayCustomer());
        
        String[] highestPayData = rp.highestPayData();
        highestPay.setText(highestPayData[0]);
        custPaid.setText(highestPayData[1]);
        AveragePay.setText(rp.AveragePayment());
        totalProfit.setText(rp.totalProfit());
    }
    
    private void pupolateTable(){
        String columns[] = {"Booking ID","Car ID","Cust ID","Date Out","Date Return","Approval"};
        
        ArrayList<String> bookData = new ArrayList<String>(booking.readBooking());
        String[][] rows = new String[bookData.size()][6];
        
        
        for (int i = 0; i < bookData.size();i++){
            String line = bookData.get(i);
            String [] bookDetail = line.split(";");
            for(int j = 0;j<6;j++){
                rows[i][j] = bookDetail[j];
            }
        }
        
        DefaultTableModel model = new DefaultTableModel(rows,columns);
        bookReportTable.setModel(model);
    }
    
    private void pupolatePaymentTable(){
        String columns[] = {"Payment ID","Booking ID","Amount","Date"};
        
        ArrayList<String> payData = new ArrayList<String>(pay.readPayment());
        String[][] rows = new String[payData.size()][4];
        
        for (int i = 0; i < payData.size();i++){
            String line = payData.get(i);
            String [] payDetail = line.split(";");
            for(int j = 0;j<4;j++){
                rows[i][j] = payDetail[j];
            }
        }
        
        System.out.println(rows);
        
        DefaultTableModel model = new DefaultTableModel(rows,columns);
        payReportTable.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        payReportTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        totalPayment = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        totalPayCust = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        custPaid = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        AveragePay = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        totalProfit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        highestPay = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookReportTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        highestBook = new javax.swing.JTextField();
        totalBook = new javax.swing.JTextField();
        totalBookCust = new javax.swing.JTextField();
        rejected = new javax.swing.JTextField();
        AverageRent = new javax.swing.JTextField();
        pieButton = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        menuBtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        payReportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Payment ID", "Booking ID", "Amount", "Date"
            }
        ));
        payReportTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                payReportTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(payReportTable);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabel4.setText("Total Payment:");

        totalPayment.setEditable(false);
        totalPayment.setBackground(new java.awt.Color(204, 204, 255));
        totalPayment.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        totalPayment.setBorder(null);
        totalPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalPaymentActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabel10.setText("Total Customer:");

        totalPayCust.setEditable(false);
        totalPayCust.setBackground(new java.awt.Color(204, 204, 255));
        totalPayCust.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        totalPayCust.setBorder(null);
        totalPayCust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalPayCustActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabel11.setText("Highest Paying Customer:");

        custPaid.setEditable(false);
        custPaid.setBackground(new java.awt.Color(204, 204, 255));
        custPaid.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        custPaid.setBorder(null);
        custPaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custPaidActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabel12.setText("Amount the Customer Paid:");

        AveragePay.setEditable(false);
        AveragePay.setBackground(new java.awt.Color(204, 204, 255));
        AveragePay.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        AveragePay.setBorder(null);
        AveragePay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AveragePayActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabel14.setText("Total Profit:");

        totalProfit.setEditable(false);
        totalProfit.setBackground(new java.awt.Color(204, 204, 255));
        totalProfit.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        totalProfit.setBorder(null);
        totalProfit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalProfitActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLabel2.setText("Payment Report");

        jLabel15.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabel15.setText("Average Payment Amount:");

        highestPay.setEditable(false);
        highestPay.setBackground(new java.awt.Color(204, 204, 255));
        highestPay.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        highestPay.setBorder(null);
        highestPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highestPayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalProfit, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalPayCust, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AveragePay, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(highestPay, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(custPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(totalPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(totalPayCust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(highestPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(custPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AveragePay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(totalProfit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(108, 108, 108))
        );

        jTabbedPane1.addTab("Payment Report", jPanel4);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        bookReportTable.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        bookReportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Booking ID", "Car ID", "Customer ID", "Date Out", "Date Return"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(bookReportTable);

        jLabel1.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLabel1.setText("Booking Report");

        jLabel3.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabel3.setText("Total Booking:");

        jLabel5.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabel5.setText("Highest Booking Customer:");

        jLabel6.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabel6.setText("Average Rental Days:");

        jLabel7.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabel7.setText("Total Customer:");

        jLabel8.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabel8.setText("Rejected Booking: ");

        jLabel9.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabel9.setText("Booked Car Ratio:");

        highestBook.setEditable(false);
        highestBook.setBackground(new java.awt.Color(204, 204, 255));
        highestBook.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        highestBook.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        highestBook.setBorder(null);
        highestBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highestBookActionPerformed(evt);
            }
        });

        totalBook.setEditable(false);
        totalBook.setBackground(new java.awt.Color(204, 204, 255));
        totalBook.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        totalBook.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalBook.setBorder(null);
        totalBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalBookActionPerformed(evt);
            }
        });

        totalBookCust.setEditable(false);
        totalBookCust.setBackground(new java.awt.Color(204, 204, 255));
        totalBookCust.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        totalBookCust.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalBookCust.setBorder(null);
        totalBookCust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalBookCustActionPerformed(evt);
            }
        });

        rejected.setEditable(false);
        rejected.setBackground(new java.awt.Color(204, 204, 255));
        rejected.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        rejected.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rejected.setBorder(null);
        rejected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectedActionPerformed(evt);
            }
        });

        AverageRent.setEditable(false);
        AverageRent.setBackground(new java.awt.Color(204, 204, 255));
        AverageRent.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        AverageRent.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        AverageRent.setBorder(null);
        AverageRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AverageRentActionPerformed(evt);
            }
        });

        pieButton.setBackground(new java.awt.Color(102, 0, 255));
        pieButton.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        pieButton.setForeground(new java.awt.Color(255, 255, 255));
        pieButton.setText("View Pie Chart");
        pieButton.setBorder(null);
        pieButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pieButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pieButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(98, 98, 98)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rejected)
                            .addComponent(pieButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AverageRent, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(highestBook, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(totalBook, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(totalBookCust))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(totalBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(totalBookCust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(highestBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(AverageRent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(rejected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(pieButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(107, 107, 107))
        );

        jTabbedPane1.addTab("Booking Report", jPanel1);

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(204, 204, 255));
        jTextField2.setFont(new java.awt.Font("Candara", 1, 36)); // NOI18N
        jTextField2.setText("Generate Report");
        jTextField2.setBorder(null);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        menuBtn1.setBackground(new java.awt.Color(255, 102, 153));
        menuBtn1.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        menuBtn1.setForeground(new java.awt.Color(255, 255, 255));
        menuBtn1.setText("Menu");
        menuBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(276, 276, 276)
                        .addComponent(menuBtn1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuBtn1))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void highestBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highestBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_highestBookActionPerformed

    private void totalBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalBookActionPerformed

    private void totalBookCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalBookCustActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalBookCustActionPerformed

    private void rejectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rejectedActionPerformed

    private void AverageRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AverageRentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AverageRentActionPerformed

    private void totalPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalPaymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalPaymentActionPerformed

    private void totalPayCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalPayCustActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalPayCustActionPerformed

    private void custPaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custPaidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_custPaidActionPerformed

    private void AveragePayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AveragePayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AveragePayActionPerformed

    private void pieButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pieButtonActionPerformed
        // TODO add your handling code here:       
        Report rp = new Report();

        //ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(data);
        //PieChart pie = new PieChart(pieData);
        
        
        DefaultPieDataset pie = new DefaultPieDataset();
        for (Map.Entry<String, Long> e : rp.carRatio().entrySet()){
            pie.setValue(e.getKey(),Math.toIntExact(e.getValue()));
        }
        
        JFreeChart chart = ChartFactory.createPieChart("Car Rented Ratio",pie,true,true,false);
        
        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(  
        "{0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));  
        ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);  
        
        ChartFrame frame = new ChartFrame("Pie Chart",chart);
        frame.setVisible(true);
        frame.setSize(600,500);
    }//GEN-LAST:event_pieButtonActionPerformed

    private void payReportTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_payReportTableMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_payReportTableMouseClicked

    private void totalProfitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalProfitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalProfitActionPerformed

    private void highestPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highestPayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_highestPayActionPerformed

    private void menuBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBtn1ActionPerformed
        // TODO add your handling code here:
        Admin_HomePage menu = new Admin_HomePage();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuBtn1ActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_GenerateReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_GenerateReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_GenerateReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_GenerateReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_GenerateReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AveragePay;
    private javax.swing.JTextField AverageRent;
    private javax.swing.JTable bookReportTable;
    private javax.swing.JTextField custPaid;
    private javax.swing.JTextField highestBook;
    private javax.swing.JTextField highestPay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton menuBtn1;
    private javax.swing.JTable payReportTable;
    private javax.swing.JButton pieButton;
    private javax.swing.JTextField rejected;
    private javax.swing.JTextField totalBook;
    private javax.swing.JTextField totalBookCust;
    private javax.swing.JTextField totalPayCust;
    private javax.swing.JTextField totalPayment;
    private javax.swing.JTextField totalProfit;
    // End of variables declaration//GEN-END:variables
}
