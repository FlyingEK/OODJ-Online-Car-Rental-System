/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package onlinecarrentalsystem;
import com.toedter.calendar.JDateChooser;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author User
 */
public class Customer_ViewCar extends javax.swing.JFrame {
private Booking booking;
private Car car;
private FileHandling fh;

    /**
     * Creates new form Customer_ViewCar
     */
    public Customer_ViewCar() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(204,204,255));
        
        booking = new Booking();
        car = new Car();
        fh = new FileHandling();
        
        noResult.setVisible(false);
        dateRequired.setVisible(false);
        DateNotAvailable.setVisible(false);
        
        pupolateTable();
    }
    
    private void pupolateTable(){
        String columns[] = {"Car ID","Model","Plate No","Seat","Color","Year","Price"};
        
        ArrayList<String> carData = new ArrayList<String>(car.readCar());
        String[][] rows = new String[carData.size()][7];
        
        
        for (int i = 0; i < carData.size();i++){
            String line = carData.get(i);
            String [] carDetail = line.split(";");
            for(int j = 0;j<7;j++){
                rows[i][j] = carDetail[j];
            }
        }
        
        DefaultTableModel model = new DefaultTableModel(rows,columns);
        carTable.setModel(model);
    }
    
    private void setTextField(String[] data){
        carID.setText((String) data[0]);
        model.setText((String) data[1]);
        plateNo.setText((String) data[2]);
        seat.setText((String) data[3]);
        color.setText((String) data[4]);
        year.setText((String) data[5]);
        price.setText((String) data[6]);
    }
    
    private void clearField(){
        carID.setText("");
        model.setText("");
        plateNo.setText("");
        seat.setText("");
        color.setText("");
        year.setText("");
        price.setText("");
        dateOut.setDate(null);
        dateReturn.setDate(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        SearchTxt = new javax.swing.JTextField();
        SearchBtn = new javax.swing.JButton();
        noResult = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        carTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        carID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        plateNo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        seat = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jlab = new javax.swing.JLabel();
        year = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        book = new javax.swing.JButton();
        color = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        model = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        dateOut = new com.toedter.calendar.JDateChooser();
        dateReturn = new com.toedter.calendar.JDateChooser();
        dateRequired = new javax.swing.JLabel();
        DateNotAvailable = new javax.swing.JLabel();
        menuBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setBackground(new java.awt.Color(204, 204, 255));
        jLabel2.setFont(new java.awt.Font("Candara", 1, 36)); // NOI18N
        jLabel2.setText("Book Car");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel1.setText("Search by Car ID:");

        SearchTxt.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        SearchTxt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        SearchTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTxtActionPerformed(evt);
            }
        });

        SearchBtn.setBackground(new java.awt.Color(102, 0, 255));
        SearchBtn.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        SearchBtn.setForeground(new java.awt.Color(255, 255, 255));
        SearchBtn.setText("Search");
        SearchBtn.setBorder(null);
        SearchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtnActionPerformed(evt);
            }
        });

        noResult.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        noResult.setForeground(new java.awt.Color(255, 51, 51));
        noResult.setText("No result found");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(noResult)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SearchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(jLabel1)
                    .addContainerGap(165, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(noResult))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(18, Short.MAX_VALUE)))
        );

        carTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Car ID", "Model", "Plate No", "Seat", "Color", "Year", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        carTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(carTable);

        jPanel2.setBackground(new java.awt.Color(226, 226, 255));

        carID.setEditable(false);
        carID.setBackground(new java.awt.Color(226, 226, 255));
        carID.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        carID.setBorder(null);
        carID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carIDActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel4.setText("Model:");

        plateNo.setEditable(false);
        plateNo.setBackground(new java.awt.Color(226, 226, 255));
        plateNo.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        plateNo.setBorder(null);

        jLabel5.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel5.setText("Number of Seat:");

        seat.setEditable(false);
        seat.setBackground(new java.awt.Color(226, 226, 255));
        seat.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        seat.setBorder(null);
        seat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel8.setText("Color: ");

        jlab.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jlab.setText("Year: ");

        year.setEditable(false);
        year.setBackground(new java.awt.Color(226, 226, 255));
        year.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        year.setBorder(null);
        year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel9.setText("Price Per Day:");

        jLabel6.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel6.setText("Car ID:");

        book.setBackground(new java.awt.Color(102, 0, 255));
        book.setFont(new java.awt.Font("Candara", 1, 15)); // NOI18N
        book.setForeground(new java.awt.Color(255, 255, 255));
        book.setText("Book");
        book.setBorder(null);
        book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookActionPerformed(evt);
            }
        });

        color.setEditable(false);
        color.setBackground(new java.awt.Color(226, 226, 255));
        color.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        color.setBorder(null);
        color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorActionPerformed(evt);
            }
        });

        price.setEditable(false);
        price.setBackground(new java.awt.Color(226, 226, 255));
        price.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        price.setBorder(null);
        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel14.setText("Plate Number:");

        model.setEditable(false);
        model.setBackground(new java.awt.Color(226, 226, 255));
        model.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        model.setBorder(null);

        jLabel3.setBackground(new java.awt.Color(204, 204, 255));
        jLabel3.setFont(new java.awt.Font("Candara", 0, 24)); // NOI18N
        jLabel3.setText("Car Detail");

        jLabel10.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel10.setText("Date Out:");

        jLabel11.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel11.setText("Date Return:");

        dateOut.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                dateOutComponentAdded(evt);
            }
        });
        dateOut.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateOutPropertyChange(evt);
            }
        });

        dateRequired.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        dateRequired.setForeground(new java.awt.Color(255, 51, 51));
        dateRequired.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dateRequired.setText("Please  select car, set Date Out and Date Return");
        dateRequired.setToolTipText("");

        DateNotAvailable.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        DateNotAvailable.setForeground(new java.awt.Color(255, 51, 51));
        DateNotAvailable.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        DateNotAvailable.setText("Car not available for this date.");
        DateNotAvailable.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(103, 103, 103)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(color, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(carID)
                                    .addComponent(plateNo)
                                    .addComponent(seat, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(model)))
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(book, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dateRequired)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(dateOut, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlab)
                                            .addComponent(jLabel9))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(8, 8, 8))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(dateReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(DateNotAvailable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(13, 13, 13))
                    .addComponent(jLabel3)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(carID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jlab)
                            .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(model, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(plateNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(seat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(DateNotAvailable)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(dateReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(dateRequired)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(book, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        menuBtn.setBackground(new java.awt.Color(255, 102, 153));
        menuBtn.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        menuBtn.setForeground(new java.awt.Color(255, 255, 255));
        menuBtn.setText("Menu");
        menuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(460, 460, 460)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(menuBtn)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(menuBtn)
                        .addGap(54, 54, 54)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchTxtActionPerformed

    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed
        // TODO add your handling code here:
        boolean found = false;
        String[] foundCar = {};
        
        DefaultTableModel tableModel = (DefaultTableModel)carTable.getModel();
        tableModel.setRowCount(0);  
        ArrayList<String> carData = new ArrayList<String>(car.readCar());
        String car_id = SearchTxt.getText();
        
        for (String line:carData){
            String[] carDetail = line.split(";");
            
            if (carDetail[0].equals(car_id)){
                found = true;
                foundCar = carDetail;
            }
        }
        
        if(found){
            tableModel.insertRow(tableModel.getRowCount(), 
                        new Object[]{foundCar[0],foundCar[1],foundCar[2],foundCar[3],foundCar[4],foundCar[5]});
            setTextField(foundCar);
            noResult.setVisible(false);
        }else{
            noResult.setVisible(true);
            pupolateTable();
        }
        
    }//GEN-LAST:event_SearchBtnActionPerformed

    private void carIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carIDActionPerformed

    private void seatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seatActionPerformed

    private void yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearActionPerformed

    private void bookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookActionPerformed

        Date date_out = dateOut.getDate();
        Date date_return = dateReturn.getDate();
        String car_id = carID.getText();

        if (date_out == null || date_return == null || car_id.equals("")){
            dateRequired.setVisible(true);
        }else{
            dateRequired.setVisible(false);

            String custID = fh.getCurrentCustomer();

            if(date_out.before(date_return) && !date_out.equals(date_return)){
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
                String strDateOut = dateFormat.format(date_out);  
                String strDateReturn = dateFormat.format(date_return);  

                if(booking.checkCarAvailability(car_id,date_out,date_return)){
                    System.out.println("Enter");
                    ArrayList<String> newBooking = new ArrayList<String>();
                    newBooking.add("B"+fh.incrementID("booking.txt")+";"+car_id+";"+custID+";"+strDateOut+";"+strDateReturn+";"+"processing");

                    booking.addBooking(newBooking);
                    clearField();
                    JOptionPane.showMessageDialog(null, "Booking Success");
                }else{
                    JOptionPane.showMessageDialog(null, "Car Not Available.","Error Message",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Cannot book and return a car at the same day. \n Cannot set Date Return before Date Out ",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_bookActionPerformed

    private void colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_colorActionPerformed

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    private void carTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carTableMouseClicked
        // TODO add your handling code here:
        //get data from selected row
        DefaultTableModel tableModel = (DefaultTableModel) carTable.getModel();
        Vector table = tableModel.getDataVector().elementAt(carTable.convertRowIndexToModel(carTable.getSelectedRow()));
        Object[] dataTable = table.toArray();
        String[] data = Arrays.copyOf(dataTable, dataTable.length, String[].class);
        
        //put them in data fields
        setTextField(data);
        DateNotAvailable.setVisible(false);
        dateOut.setDate(null);
        dateReturn.setDate(null);
        
        
        
    }//GEN-LAST:event_carTableMouseClicked

    private void dateOutComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_dateOutComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_dateOutComponentAdded

    private void dateOutPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateOutPropertyChange
        // TODO add your handling code here:
        Date date_out = dateOut.getDate();
        String car_id = carID.getText();

        if (!(date_out == null  || car_id.equals(""))){
            
            String custID = fh.getCurrentCustomer();

            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
            String strDateOut = dateFormat.format(date_out);    

            if(!booking.checkCarAvailability(car_id,date_out)){
                DateNotAvailable.setVisible(true);
            }else{
                DateNotAvailable.setVisible(false);
            }
        }
        
        
    }//GEN-LAST:event_dateOutPropertyChange

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
            java.util.logging.Logger.getLogger(Customer_ViewCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer_ViewCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer_ViewCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer_ViewCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer_ViewCar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DateNotAvailable;
    private javax.swing.JButton SearchBtn;
    private javax.swing.JTextField SearchTxt;
    private javax.swing.JButton book;
    private javax.swing.JTextField carID;
    private javax.swing.JTable carTable;
    private javax.swing.JTextField color;
    private com.toedter.calendar.JDateChooser dateOut;
    private javax.swing.JLabel dateRequired;
    private com.toedter.calendar.JDateChooser dateReturn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlab;
    private javax.swing.JButton menuBtn;
    private javax.swing.JTextField model;
    private javax.swing.JLabel noResult;
    private javax.swing.JTextField plateNo;
    private javax.swing.JTextField price;
    private javax.swing.JTextField seat;
    private javax.swing.JTextField year;
    // End of variables declaration//GEN-END:variables
}
