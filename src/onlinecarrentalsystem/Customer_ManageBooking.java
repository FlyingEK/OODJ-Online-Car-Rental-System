/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package onlinecarrentalsystem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Customer_ManageBooking extends javax.swing.JFrame {
    private Booking booking;
    private Car car;
    private FileHandling fh;
    
    /**
     * Creates new form Customer_ManageBooking
     */
    public Customer_ManageBooking() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(204,204,255));
        
        booking = new Booking();
        car = new Car();
        fh = new FileHandling();
        
        noResult.setVisible(false);
        noResult1.setVisible(false);
        dateRequired.setVisible(false);
        DateNotAvailable.setVisible(false);
        
        pupolateTable();
        pupolateHistory();
    }
    
    private void pupolateTable(){
        int count = 0;
        String columns[] = {"Booking ID","Car ID","Date Out","Date Return","Approval"};
        
        ArrayList<String> bookData = new ArrayList<String>(booking.checkCurrentBooking());
        ArrayList<String> custBook = new ArrayList<String>();
        
        for (int i = 0; i < bookData.size();i++){
            String line = bookData.get(i);
            String [] carDetail = line.split(";");
            
            if(carDetail[2].equals(fh.getCurrentCustomer())){
                count++;
                custBook.add(line);
            }
        }
        
        String[][] rows = new String[count][5];
        
        for (int i = 0; i < custBook.size();i++){
            String line = custBook.get(i);
            String [] carDetail = line.split(";");
            
            if(carDetail[2].equals(fh.getCurrentCustomer())){
                int index = 0;
                for(int j = 0;j<6;j++){
                    if (j!=2){
                        rows[i][index] = carDetail[j];
                        index++;
                    }
                }
            }
        }
        
        DefaultTableModel model = new DefaultTableModel(rows,columns);
        cBookTable.setModel(model);
    }
    
    private void pupolateHistory(){
        int count = 0;
        String columns[] = {"Booking ID","Car ID","Date Out","Date Return","Approval"};
        
        ArrayList<String> bookData = new ArrayList<String>(booking.checkBookingHistory());
        ArrayList<String> custBook = new ArrayList<String>();
        
        for (int i = 0; i < bookData.size();i++){
            String line = bookData.get(i);
            String [] carDetail = line.split(";");
            
            if(carDetail[2].equals(fh.getCurrentCustomer())){
                count++;
                custBook.add(line);
            }
        }
        
        String[][] rows = new String[count][5];
        
        for (int i = 0; i < custBook.size();i++){
            String line = custBook.get(i);
            String [] carDetail = line.split(";");
            
            if(carDetail[2].equals(fh.getCurrentCustomer())){
                int index = 0;
                for(int j = 0;j<6;j++){
                    if (j!=2){
                        rows[i][index] = carDetail[j];
                        index++;
                    }
                }
            }
        }
        
        DefaultTableModel model = new DefaultTableModel(rows,columns);
        hBookTable.setModel(model);
    }
    
    private void setTextField(String bookId,String CarId){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        car.setCarID(CarId);
        booking.setBookingID(bookId);
        
        if(booking.searchBooking()){
            if(car.searchCar()){
                String date_Out = booking.getOutDate();
                String date_Return = booking.getReturnDate();
                Date date_out;
                try {
                    date_out = dateFormat.parse(date_Out);
                    Date date_return = dateFormat.parse(date_Return);
                    bookID.setText(booking.getBookingID());
                    carID.setText(car.getCarID());
                    model.setText(car.getModel());
                    plateNo.setText(car.getPlateNo());
                    seat.setText(car.getSeat());
                    color.setText(car.getColor());
                    year.setText(car.getYear());
                    price.setText(car.getPrice());
                    dateOut.setDate(date_out);
                    dateReturn.setDate(date_return);
                } catch (ParseException ex) {
                    Logger.getLogger(Customer_ManageBooking.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    private void setHistoryField(String bookId,String CarId){
        car.setCarID(CarId);
        booking.setBookingID(bookId);
        
        if(booking.searchBooking()){
            if(car.searchCar()){
                bookID1.setText(booking.getBookingID());
                carID1.setText(car.getCarID());
                model1.setText(car.getModel());
                plateNo1.setText(car.getPlateNo());
                seat1.setText(car.getSeat());
                color1.setText(car.getColor());
                year1.setText(car.getYear());
                price1.setText(car.getPrice());
                dateOut1.setText(booking.getOutDate());
                dateReturn1.setText(booking.getReturnDate());
            }
        }
    }
    
    private void clearTextField(){
        bookID.setText("");
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
    
    private void clearHistoryField(){
        bookID1.setText("");
        carID1.setText("");
        model1.setText("");
        plateNo1.setText("");
        seat1.setText("");
        color1.setText("");
        year1.setText("");
        price1.setText("");
        dateOut1.setText("");
        dateReturn1.setText("");
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cBookTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        noResult = new javax.swing.JLabel();
        SearchTxt = new javax.swing.JTextField();
        SearchBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        bookID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        plateNo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        seat = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jlab = new javax.swing.JLabel();
        year = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        edit = new javax.swing.JButton();
        color = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        model = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        dateOut = new com.toedter.calendar.JDateChooser();
        dateReturn = new com.toedter.calendar.JDateChooser();
        DateNotAvailable = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        carID = new javax.swing.JTextField();
        dateRequired = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        hBookTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        SearchTxt1 = new javax.swing.JTextField();
        SearchBtn1 = new javax.swing.JButton();
        noResult1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        bookID1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        plateNo1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        seat1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jlab1 = new javax.swing.JLabel();
        year1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        color1 = new javax.swing.JTextField();
        price1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        model1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        carID1 = new javax.swing.JTextField();
        dateOut1 = new javax.swing.JTextField();
        dateReturn1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setBackground(new java.awt.Color(204, 204, 255));
        jLabel2.setFont(new java.awt.Font("Candara", 1, 36)); // NOI18N
        jLabel2.setText("Booking");

        jTabbedPane1.setBackground(new java.awt.Color(153, 153, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        cBookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Booking ID", "Car ID", "Date Out", "Date Return", "Approval"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cBookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cBookTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cBookTable);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel1.setText("Search by Booking ID or Car ID:");

        noResult.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        noResult.setForeground(new java.awt.Color(255, 51, 51));
        noResult.setText("No result found");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(216, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(noResult)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(SearchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(101, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(noResult))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE)))
        );

        jPanel3.setBackground(new java.awt.Color(226, 226, 255));

        bookID.setEditable(false);
        bookID.setBackground(new java.awt.Color(226, 226, 255));
        bookID.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        bookID.setBorder(null);
        bookID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookIDActionPerformed(evt);
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
        jLabel6.setText("Booking ID:");

        edit.setBackground(new java.awt.Color(102, 0, 255));
        edit.setFont(new java.awt.Font("Candara", 1, 15)); // NOI18N
        edit.setForeground(new java.awt.Color(255, 255, 255));
        edit.setText("Edit");
        edit.setBorder(null);
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
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
        jLabel3.setText("Booking Detail");

        jLabel10.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel10.setText("Date Out:");

        jLabel11.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel11.setText("Date Return:");

        dateOut.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateOutPropertyChange(evt);
            }
        });

        DateNotAvailable.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        DateNotAvailable.setForeground(new java.awt.Color(255, 51, 51));
        DateNotAvailable.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        DateNotAvailable.setText("Car not available for this date.");
        DateNotAvailable.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel7.setText("Car ID:");

        carID.setEditable(false);
        carID.setBackground(new java.awt.Color(226, 226, 255));
        carID.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        carID.setBorder(null);
        carID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carIDActionPerformed(evt);
            }
        });

        dateRequired.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        dateRequired.setForeground(new java.awt.Color(255, 51, 51));
        dateRequired.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dateRequired.setText("Please  select booking, set Date Out and Date Return");
        dateRequired.setToolTipText("");

        delete.setBackground(new java.awt.Color(255, 51, 51));
        delete.setFont(new java.awt.Font("Candara", 1, 15)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Delete");
        delete.setBorder(null);
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateRequired))
                                .addGap(29, 29, 29)
                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(seat))
                                    .addComponent(jLabel14)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel4))
                                                .addGap(103, 103, 103))
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(bookID, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(plateNo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                                .addComponent(model, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(carID, javax.swing.GroupLayout.Alignment.LEADING)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(40, 40, 40)
                                        .addComponent(dateReturn, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jlab)
                                                    .addComponent(jLabel9)
                                                    .addComponent(jLabel8))
                                                .addGap(35, 35, 35))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(60, 60, 60)))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(DateNotAvailable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(year)
                                            .addComponent(price)
                                            .addComponent(dateOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(color, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))))
                        .addContainerGap(18, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(bookID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(dateOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(carID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(model, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(plateNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14)))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(seat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlab)
                            .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DateNotAvailable)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(dateRequired)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Current Booking", jPanel1);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        hBookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Booking ID", "Car ID", "Date Out", "Date Return", "Approval"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        hBookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hBookTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(hBookTable);

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));

        jLabel12.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel12.setText("Search by Booking ID or Car ID:");

        SearchTxt1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        SearchTxt1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        SearchTxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTxt1ActionPerformed(evt);
            }
        });

        SearchBtn1.setBackground(new java.awt.Color(102, 0, 255));
        SearchBtn1.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        SearchBtn1.setForeground(new java.awt.Color(255, 255, 255));
        SearchBtn1.setText("Search");
        SearchBtn1.setBorder(null);
        SearchBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SearchBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtn1ActionPerformed(evt);
            }
        });

        noResult1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        noResult1.setForeground(new java.awt.Color(255, 51, 51));
        noResult1.setText("No result found");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(210, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(noResult1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(SearchTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(jLabel12)
                    .addContainerGap(165, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(noResult1))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(18, Short.MAX_VALUE)))
        );

        jPanel6.setBackground(new java.awt.Color(226, 226, 255));

        bookID1.setEditable(false);
        bookID1.setBackground(new java.awt.Color(226, 226, 255));
        bookID1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        bookID1.setBorder(null);
        bookID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookID1ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel13.setText("Model:");

        plateNo1.setEditable(false);
        plateNo1.setBackground(new java.awt.Color(226, 226, 255));
        plateNo1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        plateNo1.setBorder(null);

        jLabel15.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel15.setText("Number of Seat:");

        seat1.setEditable(false);
        seat1.setBackground(new java.awt.Color(226, 226, 255));
        seat1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        seat1.setBorder(null);
        seat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat1ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel16.setText("Color: ");

        jlab1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jlab1.setText("Year: ");

        year1.setEditable(false);
        year1.setBackground(new java.awt.Color(226, 226, 255));
        year1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        year1.setBorder(null);
        year1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                year1ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel17.setText("Price Per Day:");

        jLabel18.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel18.setText("Booking ID:");

        color1.setEditable(false);
        color1.setBackground(new java.awt.Color(226, 226, 255));
        color1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        color1.setBorder(null);
        color1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                color1ActionPerformed(evt);
            }
        });

        price1.setEditable(false);
        price1.setBackground(new java.awt.Color(226, 226, 255));
        price1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        price1.setBorder(null);
        price1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                price1ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel19.setText("Plate Number:");

        model1.setEditable(false);
        model1.setBackground(new java.awt.Color(226, 226, 255));
        model1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        model1.setBorder(null);

        jLabel20.setBackground(new java.awt.Color(204, 204, 255));
        jLabel20.setFont(new java.awt.Font("Candara", 0, 24)); // NOI18N
        jLabel20.setText("Booking Detail");

        jLabel21.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel21.setText("Date Out:");

        jLabel22.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel22.setText("Date Return:");

        jLabel23.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel23.setText("Car ID:");

        carID1.setEditable(false);
        carID1.setBackground(new java.awt.Color(226, 226, 255));
        carID1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        carID1.setBorder(null);
        carID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carID1ActionPerformed(evt);
            }
        });

        dateOut1.setEditable(false);
        dateOut1.setBackground(new java.awt.Color(226, 226, 255));
        dateOut1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        dateOut1.setBorder(null);
        dateOut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateOut1ActionPerformed(evt);
            }
        });

        dateReturn1.setEditable(false);
        dateReturn1.setBackground(new java.awt.Color(226, 226, 255));
        dateReturn1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        dateReturn1.setBorder(null);
        dateReturn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateReturn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bookID1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel19)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel23)
                                                .addComponent(jLabel13))
                                            .addGap(103, 103, 103)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(seat1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                        .addComponent(plateNo1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(model1, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addComponent(carID1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jlab1)
                                                .addComponent(jLabel17))
                                            .addGap(35, 35, 35))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                            .addComponent(jLabel22)
                                            .addGap(40, 40, 40)))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(79, 79, 79)))
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(price1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(year1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(color1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateOut1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                    .addComponent(dateReturn1))))
                        .addContainerGap(23, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel20)
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(color1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(bookID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlab1)
                            .addComponent(year1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(price1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(dateOut1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(dateReturn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(model1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(plateNo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(seat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Booking History", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(464, 464, 464))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchTxtActionPerformed

    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed
        // TODO add your handling code here:
        boolean found = false;
        String id = SearchTxt.getText();
        ArrayList<String> dataFound = new ArrayList<String>();
        DefaultTableModel tableModel = (DefaultTableModel)cBookTable.getModel();
        boolean current = false;
        
        ArrayList<String> bookData = new ArrayList<String>(booking.checkCurrentBooking());
        for (String line:bookData){
            String[] bookDetail = line.split(";");
            if(bookDetail[0].equals(id)){
                current = true;
            }
        }
        
        if(!id.equals("")){ 
            if (id.substring(0, 1).toUpperCase().equals("B")){
                booking.setBookingID(id);
                if(booking.searchBooking()){
                    if(booking.getCustomerID().equals(fh.getCurrentCustomer())){
                        if(current){
                            found = true; 
                        }
                    }
                }
            }else if(id.substring(0,1).toUpperCase().equals("C")){
                for (String line:bookData){
                    String[] bookDetail = line.split(";");
                    if (bookDetail[1].equals(id)){
                        if(bookDetail[2].equals(fh.getCurrentCustomer())){
                            found = true;
                        dataFound.add(line);
                        }
                    }
                }
            }else{
                found = false;
            }
        }
        
        if(found){
            if(id.substring(0, 1).toUpperCase().equals("B")){
                tableModel.setRowCount(0);
                tableModel.insertRow(tableModel.getRowCount(),
                new Object[]{booking.getBookingID(),booking.getCarID(),booking.getOutDate(),booking.getReturnDate(),booking.getStatus()});
                setTextField(booking.getBookingID(),booking.getCarID());
                noResult.setVisible(false);
                DateNotAvailable.setVisible(false);
            }
            
            if(id.substring(0,1).toUpperCase().equals("C")){
                tableModel.setRowCount(0);
                for (String line : dataFound){
                    String detail[] = line.split(";");
                    tableModel.insertRow(tableModel.getRowCount(), new Object[]{detail[0],detail[1],detail[3],detail[4],detail[5]});
                }
                clearTextField();
                noResult.setVisible(false);
                DateNotAvailable.setVisible(false);
            }
        }else{
            noResult.setVisible(true);
            pupolateTable();
            clearTextField();
        }

    }//GEN-LAST:event_SearchBtnActionPerformed

    private void bookIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookIDActionPerformed

    private void seatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seatActionPerformed

    private void yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed

        Date date_out = dateOut.getDate();
        Date date_return = dateReturn.getDate();
        String car_id = carID.getText();
        String booking_id = bookID.getText();

        if (date_out == null || date_return == null || car_id.equals("")){
            dateRequired.setVisible(true);
        }else{
            dateRequired.setVisible(false);

            String custID = fh.getCurrentCustomer();

            if(date_out.before(date_return) && !date_out.equals(date_return)){
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
                String strDateOut = dateFormat.format(date_out);  
                String strDateReturn = dateFormat.format(date_return);  

                if(booking.checkCarAvailability(booking_id,car_id,date_out,date_return)){
                    ArrayList<String> newBooking = new ArrayList<String>();
                    newBooking.add(booking_id);
                    newBooking.add(car_id);
                    newBooking.add(custID);
                    newBooking.add(strDateOut);
                    newBooking.add(strDateReturn);
                    newBooking.add("processing");

                    booking.modifyBooking(newBooking);
                    clearTextField();
                    pupolateTable();
                }else{
                    JOptionPane.showMessageDialog(null, "Car not available for the booking date.","Error Message",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Cannot book and return a car at the same day. \n Cannot set Date Return before Date Out ",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_editActionPerformed

    private void colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_colorActionPerformed

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    private void carIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carIDActionPerformed

    private void SearchTxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchTxt1ActionPerformed

    private void SearchBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtn1ActionPerformed
        // TODO add your handling code here:
        boolean found = false;
        String id = SearchTxt1.getText();
        ArrayList<String> dataFound = new ArrayList<String>();
        DefaultTableModel tableModel = (DefaultTableModel)hBookTable.getModel();
        ArrayList<String> bookData = new ArrayList<String>(booking.checkBookingHistory());
        boolean history = false;
        
        for (String line:bookData){
            String[] bookDetail = line.split(";");
            if(bookDetail[0].equals(id)){
                history = true;
            }
        }
        
        if(!id.equals("")){ 
            if (id.substring(0, 1).toUpperCase().equals("B")){
                booking.setBookingID(id);
                if(booking.searchBooking()){
                    if(booking.getCustomerID().equals(fh.getCurrentCustomer())){
                        if(history){
                            found = true; 
                        }
                    }
                }
            }else if(id.substring(0,1).toUpperCase().equals("C")){

                for (String line:bookData){
                    String[] bookDetail = line.split(";");
                    if (bookDetail[1].equals(id)){
                        if(bookDetail[2].equals(fh.getCurrentCustomer())){
                            found = true;
                        dataFound.add(line);
                        }
                    }
                }
            }else{
                found = false;
            }
        }
        
        if(found){
            if(id.substring(0, 1).toUpperCase().equals("B")){
                tableModel.setRowCount(0);
                tableModel.insertRow(tableModel.getRowCount(),
                new Object[]{booking.getBookingID(),booking.getCarID(),booking.getOutDate(),booking.getReturnDate(),booking.getStatus()});
                setHistoryField(booking.getBookingID(),booking.getCarID());
                noResult1.setVisible(false);
            }
            
            if(id.substring(0,1).toUpperCase().equals("C")){
                tableModel.setRowCount(0);
                for (String line : dataFound){
                    String detail[] = line.split(";");
                    tableModel.insertRow(tableModel.getRowCount(), new Object[]{detail[0],detail[1],detail[3],detail[4],detail[5]});
                }
                clearHistoryField();
                noResult1.setVisible(false);
            }
        }else{
            noResult1.setVisible(true);
            pupolateHistory();
            clearHistoryField();
        }
    }//GEN-LAST:event_SearchBtn1ActionPerformed

    private void bookID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookID1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookID1ActionPerformed

    private void seat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seat1ActionPerformed

    private void year1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_year1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_year1ActionPerformed

    private void color1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_color1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_color1ActionPerformed

    private void price1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_price1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_price1ActionPerformed

    private void carID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carID1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carID1ActionPerformed

    private void dateOut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateOut1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateOut1ActionPerformed

    private void dateReturn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateReturn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateReturn1ActionPerformed

    private void cBookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cBookTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel tableModel = (DefaultTableModel) cBookTable.getModel();
        Vector table = tableModel.getDataVector().elementAt(cBookTable.convertRowIndexToModel(cBookTable.getSelectedRow()));
        Object[] dataTable = table.toArray();
        String[] data = Arrays.copyOf(dataTable, dataTable.length, String[].class);
        
        //put them in data fields
        setTextField(data[0],data[1]);
        DateNotAvailable.setVisible(false);
        
    }//GEN-LAST:event_cBookTableMouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        String booking_id = bookID.getText();
        booking.setBookingID(booking_id);
        booking.deleteBooking();
        pupolateTable();
        clearTextField();
    }//GEN-LAST:event_deleteActionPerformed

    private void dateOutPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateOutPropertyChange
        // TODO add your handling code here:
        Date date_out = dateOut.getDate();
        String car_id = carID.getText();
        String booking_id = bookID.getText();

        if (!(date_out == null  || car_id.equals(""))){
            
            String custID = fh.getCurrentCustomer();

            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
            String strDateOut = dateFormat.format(date_out);    

            if(!booking.checkCarAvailability(booking_id,car_id,date_out)){
                DateNotAvailable.setVisible(true);
            }else{
                DateNotAvailable.setVisible(false);
            }
        }
    }//GEN-LAST:event_dateOutPropertyChange

    private void hBookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hBookTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel tableModel = (DefaultTableModel) hBookTable.getModel();
        Vector table = tableModel.getDataVector().elementAt(hBookTable.convertRowIndexToModel(hBookTable.getSelectedRow()));
        Object[] dataTable = table.toArray();
        String[] data = Arrays.copyOf(dataTable, dataTable.length, String[].class);
        
        //put them in data fields
        setHistoryField(data[0],data[1]);
    }//GEN-LAST:event_hBookTableMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer_ManageBooking().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DateNotAvailable;
    private javax.swing.JButton SearchBtn;
    private javax.swing.JButton SearchBtn1;
    private javax.swing.JTextField SearchTxt;
    private javax.swing.JTextField SearchTxt1;
    private javax.swing.JTextField bookID;
    private javax.swing.JTextField bookID1;
    private javax.swing.JTable cBookTable;
    private javax.swing.JTextField carID;
    private javax.swing.JTextField carID1;
    private javax.swing.JTextField color;
    private javax.swing.JTextField color1;
    private com.toedter.calendar.JDateChooser dateOut;
    private javax.swing.JTextField dateOut1;
    private javax.swing.JLabel dateRequired;
    private com.toedter.calendar.JDateChooser dateReturn;
    private javax.swing.JTextField dateReturn1;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JTable hBookTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jlab;
    private javax.swing.JLabel jlab1;
    private javax.swing.JTextField model;
    private javax.swing.JTextField model1;
    private javax.swing.JLabel noResult;
    private javax.swing.JLabel noResult1;
    private javax.swing.JTextField plateNo;
    private javax.swing.JTextField plateNo1;
    private javax.swing.JTextField price;
    private javax.swing.JTextField price1;
    private javax.swing.JTextField seat;
    private javax.swing.JTextField seat1;
    private javax.swing.JTextField year;
    private javax.swing.JTextField year1;
    // End of variables declaration//GEN-END:variables
}
