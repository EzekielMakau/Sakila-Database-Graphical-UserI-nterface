/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GUI_Database_Application extends javax.swing.JFrame {

    /**
     * Creates new form GUI_Database_Application
     */
    public GUI_Database_Application() {
        initComponents();
        Connect();
        notificationTable.setVisible(false);
    }
    
    Connection connection;
    PreparedStatement stmt;
    
    public void Connect(){
        String url = "jdbc:mariadb://localhost:3306/sakila";
        String user = "root";
        String password = "Pogba29614";
        
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            
            try{
                if(connection.isValid(5)){
                    System.out.println("Connected to the database!");
                    showTable();
                    showFilmTable();
                    showNotificationTable();
                }
                else{
                    System.out.println("Failed to connect to the database.");
                }
            }catch(SQLException e){
                System.out.println("An error occurred while checking the connection: "+e.getMessage());
            }

//            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_Database_Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void showTable() {
        int CC;
        try{
            stmt = connection.prepareStatement("SELECT staff.first_name,staff.last_name,address.address,address.address2,"
                    + "address.district,city.city,address.postal_code,address.phone,staff.active,sales_by_store.store "
                    + "FROM staff LEFT JOIN address ON staff.address_id=address.address_id LEFT JOIN city ON address.city_id=city.city_id "
                    + "LEFT JOIN sales_by_store ON CONCAT(staff.first_name, ' ', staff.last_name)=sales_by_store.manager;");
            ResultSet Rs = stmt.executeQuery();
            
            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) jTable1.getModel();
            DFT.setRowCount(0);
            
            while(Rs.next()) {
                Vector v2 = new Vector();
                
                for(int i = 1; i <= CC; i++){
                    v2.add(Rs.getString("first_name"));
                    v2.add(Rs.getString("last_name"));
                    v2.add(Rs.getString("address"));
                    v2.add(Rs.getString("address2"));
                    v2.add(Rs.getString("district"));
                    v2.add(Rs.getString("city"));
                    v2.add(Rs.getString("postal_code"));
                    v2.add(Rs.getString("phone"));
                    v2.add(Rs.getString("active"));
                    v2.add(Rs.getString("store"));
                }
                DFT.addRow(v2);
            }
        }
        catch(Exception e){
            
        }
    }
    private void showNotificationTable() {
        int CC;
        try{
            stmt = connection.prepareStatement("SELECT * FROM customer");
            ResultSet Rs = stmt.executeQuery();
            
            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) notificationTable.getModel();
            DFT.setRowCount(0);
            
            while(Rs.next()) {
                Vector v2 = new Vector();
                
                for(int i = 1; i <= CC; i++){
                    v2.add(Rs.getString("customer_id"));
                    v2.add(Rs.getString("store_id"));
                    v2.add(Rs.getString("first_name"));
                    v2.add(Rs.getString("last_name"));
                    v2.add(Rs.getString("email"));
                    v2.add(Rs.getString("address_id"));
                    v2.add(Rs.getString("active"));
                    v2.add(Rs.getString("create_date"));
                    v2.add(Rs.getString("last_update"));                }
                DFT.addRow(v2);
            }
        }
        catch(Exception e){
            
        }
    }
    private void showFilmTable() {
        int CC;
        try{
            stmt = connection.prepareStatement("SELECT * FROM film");
            ResultSet Rs = stmt.executeQuery();
            
            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) jTable5.getModel();
            DFT.setRowCount(0);
            
            while(Rs.next()) {
                Vector v2 = new Vector();
                
                for(int i = 1; i <= CC; i++){
                    v2.add(Rs.getString("film_id"));
                    v2.add(Rs.getString("title"));
                    v2.add(Rs.getString("description"));
                    v2.add(Rs.getString("release_year"));
                    v2.add(Rs.getString("language_id"));
                    v2.add(Rs.getString("original_language_id"));
                    v2.add(Rs.getString("rental_duration"));
                    v2.add(Rs.getString("rental_rate"));
                    v2.add(Rs.getString("length"));
                    v2.add(Rs.getString("replacement_cost"));
                    v2.add(Rs.getString("rating"));
                    v2.add(Rs.getString("special_features"));
                    v2.add(Rs.getString("last_update"));
                }
                DFT.addRow(v2);
            }
        }
        catch(Exception e){
            
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        staffPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        filmPanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        filmId_field = new javax.swing.JTextField();
        title_field = new javax.swing.JTextField();
        description_field = new javax.swing.JTextField();
        release_year_field = new javax.swing.JTextField();
        languageID_field = new javax.swing.JTextField();
        original_languageId_field = new javax.swing.JTextField();
        rating_field = new javax.swing.JTextField();
        rental_duration_field = new javax.swing.JTextField();
        filmId_label = new javax.swing.JLabel();
        title_label = new javax.swing.JLabel();
        description_label = new javax.swing.JLabel();
        rating_label = new javax.swing.JLabel();
        release_year_label = new javax.swing.JLabel();
        languageId_label = new javax.swing.JLabel();
        original_label = new javax.swing.JLabel();
        rental_duration_label = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        rental_rate_label = new javax.swing.JLabel();
        length_label = new javax.swing.JLabel();
        replace_cost_label = new javax.swing.JLabel();
        special_features_label = new javax.swing.JLabel();
        rental_rate_field = new javax.swing.JTextField();
        length_field = new javax.swing.JTextField();
        replacement_cost_field = new javax.swing.JTextField();
        special_features_field = new javax.swing.JTextField();
        reportPanel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        reportTable1 = new javax.swing.JTable();
        notificationPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        storeIdField = new javax.swing.JTextField();
        firstNameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        addressIdField = new javax.swing.JTextField();
        activeField = new javax.swing.JTextField();
        createDateField = new javax.swing.JTextField();
        createButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        notificationTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        customerIdField = new javax.swing.JTextField();
        listAllClients = new javax.swing.JButton();
        hideAllClients = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
            }
        });

        staffPanel.setBackground(new java.awt.Color(42, 47, 59));
        staffPanel.setPreferredSize(new java.awt.Dimension(1178, 900));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "first name", "last name", "address", "address2", "district", "city", "postal code", "phone", "active", "store"
            }
        ));
        jScrollPane4.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(2).setHeaderValue("address");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("address2");
            jTable1.getColumnModel().getColumn(4).setHeaderValue("district");
            jTable1.getColumnModel().getColumn(5).setHeaderValue("city");
            jTable1.getColumnModel().getColumn(6).setHeaderValue("postal code");
            jTable1.getColumnModel().getColumn(7).setHeaderValue("phone");
            jTable1.getColumnModel().getColumn(8).setHeaderValue("active");
            jTable1.getColumnModel().getColumn(9).setHeaderValue("store");
        }

        javax.swing.GroupLayout staffPanelLayout = new javax.swing.GroupLayout(staffPanel);
        staffPanel.setLayout(staffPanelLayout);
        staffPanelLayout.setHorizontalGroup(
            staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(209, Short.MAX_VALUE))
        );
        staffPanelLayout.setVerticalGroup(
            staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(843, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab1", staffPanel);

        filmPanel.setBackground(new java.awt.Color(42, 47, 59));

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "film_id", "title", "description", "release_year", "language_id", "original_language_id", "rental_duration", "rental_rate", "length", "replacement_cost", "rating", "special_features", "last_update"
            }
        ));
        jScrollPane6.setViewportView(jTable5);

        filmId_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filmId_fieldActionPerformed(evt);
            }
        });

        title_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                title_fieldActionPerformed(evt);
            }
        });

        release_year_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                release_year_fieldActionPerformed(evt);
            }
        });

        original_languageId_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                original_languageId_fieldActionPerformed(evt);
            }
        });

        rating_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rating_fieldActionPerformed(evt);
            }
        });

        rental_duration_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rental_duration_fieldActionPerformed(evt);
            }
        });

        filmId_label.setBackground(new java.awt.Color(255, 102, 0));
        filmId_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        filmId_label.setForeground(new java.awt.Color(255, 102, 0));
        filmId_label.setText("film_id");

        title_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        title_label.setForeground(new java.awt.Color(255, 102, 0));
        title_label.setText("Title");

        description_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        description_label.setForeground(new java.awt.Color(255, 102, 0));
        description_label.setText("Description");

        rating_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rating_label.setForeground(new java.awt.Color(255, 102, 0));
        rating_label.setText("Rating");

        release_year_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        release_year_label.setForeground(new java.awt.Color(255, 102, 0));
        release_year_label.setText("Release Year");

        languageId_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        languageId_label.setForeground(new java.awt.Color(255, 102, 0));
        languageId_label.setText("Language");

        original_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        original_label.setForeground(new java.awt.Color(255, 102, 0));
        original_label.setText("Original Language");

        rental_duration_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rental_duration_label.setForeground(new java.awt.Color(255, 102, 0));
        rental_duration_label.setText("Rental duration");

        jButton4.setText("Add new data");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("ADD");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        jButton6.setText("CLOSE");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });

        rental_rate_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rental_rate_label.setForeground(new java.awt.Color(255, 102, 0));
        rental_rate_label.setText("Rental rate");

        length_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        length_label.setForeground(new java.awt.Color(255, 102, 0));
        length_label.setText("length");

        replace_cost_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        replace_cost_label.setForeground(new java.awt.Color(255, 102, 0));
        replace_cost_label.setText("Replacement fee");

        special_features_label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        special_features_label.setForeground(new java.awt.Color(255, 102, 0));
        special_features_label.setText("special features");

        rental_rate_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rental_rate_fieldActionPerformed(evt);
            }
        });

        length_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                length_fieldActionPerformed(evt);
            }
        });

        replacement_cost_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replacement_cost_fieldActionPerformed(evt);
            }
        });

        special_features_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                special_features_fieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout filmPanelLayout = new javax.swing.GroupLayout(filmPanel);
        filmPanel.setLayout(filmPanelLayout);
        filmPanelLayout.setHorizontalGroup(
            filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filmPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(filmPanelLayout.createSequentialGroup()
                        .addGroup(filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filmId_label, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rating_label, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(description_label, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(filmPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(filmId_field, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(title_field, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(63, 63, 63)
                                .addGroup(filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(filmPanelLayout.createSequentialGroup()
                                        .addComponent(release_year_label, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(release_year_field, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(filmPanelLayout.createSequentialGroup()
                                        .addComponent(rental_duration_label, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rental_duration_field, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(filmPanelLayout.createSequentialGroup()
                                        .addComponent(languageId_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(languageID_field, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(filmPanelLayout.createSequentialGroup()
                                        .addComponent(original_label, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(original_languageId_field, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(filmPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rating_field, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(description_field, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(71, 71, 71)
                        .addGroup(filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(length_label, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(replace_cost_label, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rental_rate_label)
                            .addComponent(special_features_label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(special_features_field, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(filmPanelLayout.createSequentialGroup()
                                .addComponent(replacement_cost_field, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(filmPanelLayout.createSequentialGroup()
                                .addComponent(length_field, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(filmPanelLayout.createSequentialGroup()
                                .addComponent(rental_rate_field, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        filmPanelLayout.setVerticalGroup(
            filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filmPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filmId_field, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(release_year_label)
                    .addComponent(release_year_field, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filmId_label)
                    .addComponent(rental_rate_label)
                    .addComponent(rental_rate_field, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(length_label)
                        .addComponent(length_field, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(title_label)
                        .addComponent(title_field, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(languageId_label)
                        .addComponent(languageID_field, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(description_label, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                    .addGroup(filmPanelLayout.createSequentialGroup()
                        .addGroup(filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(description_field, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(original_label)
                                .addComponent(replace_cost_label)
                                .addComponent(replacement_cost_field, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(original_languageId_field, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rating_field, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rental_duration_field, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rating_label)
                        .addComponent(rental_duration_label))
                    .addGroup(filmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(special_features_field, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(special_features_label)))
                .addGap(244, 244, 244))
        );

        jTabbedPane2.addTab("tab2", filmPanel);

        reportPanel.setBackground(new java.awt.Color(42, 47, 59));
        reportPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportPanelMouseClicked(evt);
            }
        });

        reportTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Genre", "Number of Movies"
            }
        ));
        jScrollPane7.setViewportView(reportTable1);

        javax.swing.GroupLayout reportPanelLayout = new javax.swing.GroupLayout(reportPanel);
        reportPanel.setLayout(reportPanelLayout);
        reportPanelLayout.setHorizontalGroup(
            reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        reportPanelLayout.setVerticalGroup(
            reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab3", reportPanel);

        notificationPanel.setBackground(new java.awt.Color(42, 47, 59));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("store_id");

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 0));
        jLabel2.setText("first name");

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 0));
        jLabel3.setText("last name");

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 0));
        jLabel4.setText("email");

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 0));
        jLabel5.setText("address_id");

        jLabel6.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 0));
        jLabel6.setText("active");

        jLabel7.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 0));
        jLabel7.setText("create date");

        storeIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storeIdFieldActionPerformed(evt);
            }
        });

        firstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameFieldActionPerformed(evt);
            }
        });

        lastNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameFieldActionPerformed(evt);
            }
        });

        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });

        addressIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressIdFieldActionPerformed(evt);
            }
        });

        activeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activeFieldActionPerformed(evt);
            }
        });

        createDateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createDateFieldActionPerformed(evt);
            }
        });

        createButton.setBackground(new java.awt.Color(3, 233, 244));
        createButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        createButton.setForeground(new java.awt.Color(42, 47, 59));
        createButton.setText("Create");
        createButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createButtonMouseClicked(evt);
            }
        });

        updateButton.setBackground(new java.awt.Color(3, 233, 244));
        updateButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        updateButton.setForeground(new java.awt.Color(42, 47, 59));
        updateButton.setText("Update");
        updateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateButtonMouseClicked(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(3, 233, 244));
        deleteButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(42, 47, 59));
        deleteButton.setText("Delete");
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButtonMouseClicked(evt);
            }
        });

        notificationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "customer_id", "store_id", "first name", "last name", "email", "address id", "active", "create date", "last update"
            }
        ));
        jScrollPane1.setViewportView(notificationTable);

        jLabel8.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 0));
        jLabel8.setText("customer id");

        customerIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerIdFieldActionPerformed(evt);
            }
        });

        listAllClients.setBackground(new java.awt.Color(3, 233, 244));
        listAllClients.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        listAllClients.setForeground(new java.awt.Color(42, 47, 59));
        listAllClients.setText("List All Clients");
        listAllClients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listAllClientsMouseClicked(evt);
            }
        });

        hideAllClients.setBackground(new java.awt.Color(3, 233, 244));
        hideAllClients.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        hideAllClients.setForeground(new java.awt.Color(42, 47, 59));
        hideAllClients.setText("Hide All Clients");
        hideAllClients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hideAllClientsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout notificationPanelLayout = new javax.swing.GroupLayout(notificationPanel);
        notificationPanel.setLayout(notificationPanelLayout);
        notificationPanelLayout.setHorizontalGroup(
            notificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notificationPanelLayout.createSequentialGroup()
                .addGroup(notificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(notificationPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(notificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(notificationPanelLayout.createSequentialGroup()
                                .addGroup(notificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(notificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(customerIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(createDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(activeField, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addressIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(storeIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, notificationPanelLayout.createSequentialGroup()
                                .addGap(0, 5, Short.MAX_VALUE)
                                .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, notificationPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(notificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(hideAllClients, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(listAllClients, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1011, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        notificationPanelLayout.setVerticalGroup(
            notificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notificationPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(notificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(storeIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(notificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(notificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(notificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(notificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(notificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(activeField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(notificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(notificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(notificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(listAllClients, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hideAllClients, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(642, Short.MAX_VALUE))
            .addGroup(notificationPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab4", notificationPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1370, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1257, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filmId_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filmId_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filmId_fieldActionPerformed

    private void title_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_title_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_title_fieldActionPerformed

    private void release_year_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_release_year_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_release_year_fieldActionPerformed

    private void original_languageId_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_original_languageId_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_original_languageId_fieldActionPerformed

    private void rating_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rating_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rating_fieldActionPerformed

    private void rental_duration_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rental_duration_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rental_duration_fieldActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        jButton4.setVisible(false);
        filmId_label.setVisible(true);
        filmId_field.setVisible(true);
        title_label.setVisible(true);
        title_field.setVisible(true);
        description_label.setVisible(true);
        description_field.setVisible(true);
        rating_label.setVisible(true);
        rating_field.setVisible(true);
        release_year_label.setVisible(true);
        release_year_field.setVisible(true);
        languageId_label.setVisible(true);
        languageID_field.setVisible(true);
        length_label.setVisible(true);
        length_field.setVisible(true);
        rental_duration_label.setVisible(true);
        rental_duration_field.setVisible(true);
        rental_rate_label.setVisible(true);
        rental_rate_field.setVisible(true);
        replace_cost_label.setVisible(true);
        replacement_cost_field.setVisible(true);
        special_features_label.setVisible(true);
        special_features_field.setVisible(true);
        original_label.setVisible(true);
        original_languageId_field.setVisible(true);
        jButton5.setVisible(true);
        jButton6.setVisible(true);
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
        String film_id_text = filmId_field.getText();
        String title= title_field.getText();
        String description = description_field.getText();
        String rating = rating_field.getText();
        String release_year = release_year_field.getText();
        String languageID_text = languageID_field.getText();
        String orginal_languageId_text = original_languageId_field.getText();
        String rental_duration_text = rental_duration_field.getText();
        String rental_rate_text = rental_rate_field.getText();
        String replacement_cost_text = replacement_cost_field.getText();
        String special_features = special_features_field.getText();
        String length_text = length_field.getText(); 
        int film_id =Integer.parseInt(film_id_text );
        int length =Integer.parseInt(length_text );
        int languageID =Integer.parseInt(languageID_text );
        int orginal_languageId =Integer.parseInt(orginal_languageId_text );
        int rental_duration =Integer.parseInt(rental_duration_text );
        double rental_rate =Double.parseDouble(rental_rate_text );
        double replacement_cost =Double.parseDouble(replacement_cost_text );
        
//        Connect();
        
        try {
            stmt = connection.prepareStatement("INSERT INTO film (film_id, title, description, release_year, language_id, original_language_id, "
                    + "rental_duration, rental_rate, length, replacement_cost, rating, special_features) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, film_id);
            stmt.setString(2, title);
            stmt.setString(3, description);
            stmt.setString(4, release_year);
            stmt.setInt(5, languageID);
            stmt.setInt(6, orginal_languageId);
            stmt.setInt(7, rental_duration);
            stmt.setDouble(8, rental_rate);
            stmt.setInt(9, length);
            stmt.setDouble(10, replacement_cost);
            stmt.setString(11, rating);
            stmt.setString(12, special_features);
            
            
            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "New data added successfully");
            showFilmTable();
            
            filmId_field.setText("");
            title_field.setText("");
            description_field.setText("");
            rating_field.setText("");
            release_year_field.setText("");
            languageID_field.setText("");
            original_languageId_field.setText("");
            rental_duration_field.setText(""); 
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Database_Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
        staffPanel.setVisible(false);
        filmPanel.setVisible(true);
        reportPanel.setVisible(false);
        notificationPanel.setVisible(false);
        filmId_label.setVisible(false);
        filmId_field.setVisible(false);
        title_label.setVisible(false);
        title_field.setVisible(false);
        description_label.setVisible(false);
        description_field.setVisible(false);
        rating_label.setVisible(false);
        rating_field.setVisible(false);
        release_year_label.setVisible(false);
        release_year_field.setVisible(false);
        languageId_label.setVisible(false);
        languageID_field.setVisible(false);
        length_label.setVisible(false);
        length_field.setVisible(false);
        rental_duration_label.setVisible(false);
        rental_duration_field.setVisible(false);
        rental_rate_label.setVisible(false);
        rental_rate_field.setVisible(false);
        replace_cost_label.setVisible(false);
        replacement_cost_field.setVisible(false);
        special_features_label.setVisible(false);
        special_features_field.setVisible(false);
        original_label.setVisible(false);
        original_languageId_field.setVisible(false);
        jButton4.setVisible(true);
        jButton6.setVisible(false);
        jButton5.setVisible(false);
        showFilmTable();
    }//GEN-LAST:event_jButton6MouseClicked

    private void rental_rate_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rental_rate_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rental_rate_fieldActionPerformed

    private void length_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_length_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_length_fieldActionPerformed

    private void replacement_cost_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_replacement_cost_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_replacement_cost_fieldActionPerformed

    private void special_features_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_special_features_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_special_features_fieldActionPerformed

    private void reportPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportPanelMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "New data added successfully");
    }//GEN-LAST:event_reportPanelMouseClicked

    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked
        // TODO add your handling code here:
        int CC;
        try{
            stmt = connection.prepareStatement(" select s.store_id,c.name AS genre,COUNT(*) AS num_movies FROM store AS s "
                    + "JOIN inventory AS i ON s.store_id=i.store_id JOIN film AS f ON i.film_id=f.film_id JOIN film_category AS fc ON f.film_id=fc.film_id "
                    + "JOIN category AS c ON fc.category_id=c.category_id GROUP BY s.store_id,c.name ORDER BY s.store_id,c.name;");
            ResultSet Rs = stmt.executeQuery();
            
            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) reportTable1.getModel();
            DFT.setRowCount(0);
            
            while(Rs.next()) {
                Vector v2 = new Vector();
                
                for(int i = 1; i <= CC; i++){
                    v2.add(Rs.getString("genre"));
                    v2.add(Rs.getString("num_movies"));
                }
                DFT.addRow(v2);
            }
        }
        catch(Exception e){
            
        }
    }//GEN-LAST:event_jTabbedPane2MouseClicked

    private void storeIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storeIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_storeIdFieldActionPerformed

    private void firstNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameFieldActionPerformed

    private void lastNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameFieldActionPerformed

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void addressIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressIdFieldActionPerformed

    private void activeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_activeFieldActionPerformed

    private void createDateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createDateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createDateFieldActionPerformed

    private void createButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createButtonMouseClicked
        // TODO add your handling code here:
        String store_id_text = storeIdField.getText();
        String first_name_text= firstNameField.getText();
        String last_name_text = lastNameField.getText();
        String email_text = emailField.getText();
        String address_id_text = addressIdField.getText();
        String active_text = activeField.getText();
        String create_date_text = createDateField.getText();
        int store_id =Integer.parseInt(store_id_text );
        int address_id =Integer.parseInt(address_id_text );
        int active =Integer.parseInt(active_text );
                
        try {
            stmt = connection.prepareStatement("INSERT INTO customer (store_id, first_name, last_name, email, address_id, active, "
                    + "create_date) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, store_id);
            stmt.setString(2, first_name_text);
            stmt.setString(3, last_name_text);
            stmt.setString(4, email_text);
            stmt.setInt(5, address_id);
            stmt.setInt(6, active);
            stmt.setString(7, create_date_text);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "New data added successfully");
            showNotificationTable();
            
            storeIdField.setText("");
            firstNameField.setText("");
            lastNameField.setText("");
            emailField.setText("");
            addressIdField.setText("");
            activeField.setText("");
            createDateField.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Database_Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_createButtonMouseClicked

    private void customerIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerIdFieldActionPerformed

    private void updateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseClicked
        // TODO add your handling code here:
        String customer_id_text = customerIdField.getText();
        String store_id_text = storeIdField.getText();
        String first_name_text= firstNameField.getText();
        String last_name_text = lastNameField.getText();
        String email_text = emailField.getText();
        String address_id_text = addressIdField.getText();
        String active_text = activeField.getText();
        String create_date_text = createDateField.getText();
        int store_id =Integer.parseInt(store_id_text );
        int address_id =Integer.parseInt(address_id_text );
        int active =Integer.parseInt(active_text );
        int customer_id =Integer.parseInt(customer_id_text );
                
        try {
            stmt = connection.prepareStatement("UPDATE customer set store_id=?, first_name=?, last_name=?, email=?, address_id=?, active=?, "
                    + "create_date=? WHERE customer_id=?");
            stmt.setInt(1, store_id);
            stmt.setString(2, first_name_text);
            stmt.setString(3, last_name_text);
            stmt.setString(4, email_text);
            stmt.setInt(5, address_id);
            stmt.setInt(6, active);
            stmt.setString(7, create_date_text);
            stmt.setInt(8, customer_id);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Updated successfully");
            showNotificationTable();
            
            storeIdField.setText("");
            firstNameField.setText("");
            lastNameField.setText("");
            emailField.setText("");
            addressIdField.setText("");
            activeField.setText("");
            createDateField.setText("");
            customerIdField.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Database_Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateButtonMouseClicked

    private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseClicked
        // TODO add your handling code here:
        String customer_id_text = customerIdField.getText();
        int customer_id =Integer.parseInt(customer_id_text );
                
        try {
            stmt = connection.prepareStatement("DELETE FROM customer WHERE customer_id=?");
            
            stmt.setInt(1, customer_id);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Deleted successfully");
            showNotificationTable();
            
            storeIdField.setText("");
            firstNameField.setText("");
            lastNameField.setText("");
            emailField.setText("");
            addressIdField.setText("");
            activeField.setText("");
            createDateField.setText("");
            customerIdField.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Database_Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteButtonMouseClicked

    private void listAllClientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listAllClientsMouseClicked
        // TODO add your handling code here:
        notificationTable.setVisible(true);
    }//GEN-LAST:event_listAllClientsMouseClicked

    private void hideAllClientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideAllClientsMouseClicked
        // TODO add your handling code here:
        notificationTable.setVisible(false);
    }//GEN-LAST:event_hideAllClientsMouseClicked

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
            java.util.logging.Logger.getLogger(GUI_Database_Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Database_Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Database_Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Database_Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Database_Application().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField activeField;
    private javax.swing.JTextField addressIdField;
    private javax.swing.JButton createButton;
    private javax.swing.JTextField createDateField;
    private javax.swing.JTextField customerIdField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField description_field;
    private javax.swing.JLabel description_label;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField filmId_field;
    private javax.swing.JLabel filmId_label;
    private javax.swing.JPanel filmPanel;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JButton hideAllClients;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField languageID_field;
    private javax.swing.JLabel languageId_label;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JTextField length_field;
    private javax.swing.JLabel length_label;
    private javax.swing.JButton listAllClients;
    private javax.swing.JPanel notificationPanel;
    private javax.swing.JTable notificationTable;
    private javax.swing.JLabel original_label;
    private javax.swing.JTextField original_languageId_field;
    private javax.swing.JTextField rating_field;
    private javax.swing.JLabel rating_label;
    private javax.swing.JTextField release_year_field;
    private javax.swing.JLabel release_year_label;
    private javax.swing.JTextField rental_duration_field;
    private javax.swing.JLabel rental_duration_label;
    private javax.swing.JTextField rental_rate_field;
    private javax.swing.JLabel rental_rate_label;
    private javax.swing.JLabel replace_cost_label;
    private javax.swing.JTextField replacement_cost_field;
    private javax.swing.JPanel reportPanel;
    private javax.swing.JTable reportTable1;
    private javax.swing.JTextField special_features_field;
    private javax.swing.JLabel special_features_label;
    private javax.swing.JPanel staffPanel;
    private javax.swing.JTextField storeIdField;
    private javax.swing.JTextField title_field;
    private javax.swing.JLabel title_label;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
