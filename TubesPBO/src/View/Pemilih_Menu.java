/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Aldy
 */
import Controller.Controller_Input_Pemilih;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
public class Pemilih_Menu extends javax.swing.JFrame {

    /**
     * Creates new form Input_Pemilih
     */
    DefaultTableModel model;
    String hasil= null;
    public Pemilih_Menu() {
        initComponents();
        String [] judul = {"Nama Ketua","No.Urut","Visi","Misi"};
        model = new DefaultTableModel(judul,0);
        tabelKandidat.setModel(model);
        TampilTabel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelKandidat = new javax.swing.JTable();
        pilihBtn = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxPemilih = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(729, 443));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelKandidat.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabelKandidat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelKandidat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama Ketua", "No.Urut", "Visi", "Misi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelKandidat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelKandidatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelKandidat);
        if (tabelKandidat.getColumnModel().getColumnCount() > 0) {
            tabelKandidat.getColumnModel().getColumn(0).setResizable(false);
            tabelKandidat.getColumnModel().getColumn(1).setResizable(false);
            tabelKandidat.getColumnModel().getColumn(2).setResizable(false);
            tabelKandidat.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 121, 705, 92));

        pilihBtn.setBackground(new java.awt.Color(51, 51, 51));
        pilihBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pilihBtn.setForeground(new java.awt.Color(255, 255, 255));
        pilihBtn.setText("PILIH");
        jPanel1.add(pilihBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(621, 402, 86, 34));

        btnMenu.setBackground(new java.awt.Color(51, 51, 51));
        btnMenu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnMenu.setText("Back");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        jPanel1.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 90, 40));

        TxPemilih.setColumns(20);
        TxPemilih.setRows(5);
        jScrollPane2.setViewportView(TxPemilih);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 260, 243, 135));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DATA PEMILIH");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 236, -1, 14));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pilihan anda : ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jPanel2.setBackground(new java.awt.Color(102, 0, 0));

        jLabel1.setFont(new java.awt.Font("Myanmar Text", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PEMILIHAN UMUM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 729, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Maskot Pemilu 2019_1.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 200, 140));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void tabelKandidatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKandidatMouseClicked
        // TODO add your handling code here:
        int i= tabelKandidat.getSelectedRow();
        if (i>=0){
           this.hasil = model.getValueAt(i,1).toString();
        }  
    }//GEN-LAST:event_tabelKandidatMouseClicked

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenuActionPerformed

    public void TampilTabel(){
        int row = tabelKandidat.getRowCount();
        for (int a = 0; a < row; a++) {
           model.removeRow(0);
        }
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_pemilu","root","");
            ResultSet rs = cn.createStatement().executeQuery("SELECT * from Kandidat");
            while(rs.next()){
                String data[]= {
                    rs.getString(1),rs.getString(2),rs.getString(4),rs.getString(5)
                };
                model.addRow(data);
            }
        }catch (SQLException ex) {
            Logger.getLogger(Pemilih_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public JButton inputBtn(){
        return pilihBtn;
    }
    
    public JButton MenuBtn() {
        return btnMenu;
    }
    
    public String getSelectedKandidat(){
        return hasil;
    }

    public void setTextPemilih(String Data) {
        TxPemilih.setText(Data);
    }
    
    public void ResetView(String Nama)
    {
        jLabel3.setText(Nama);
    }

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TxPemilih;
    private javax.swing.JButton btnMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton pilihBtn;
    private javax.swing.JTable tabelKandidat;
    // End of variables declaration//GEN-END:variables

    public void Listener(ActionListener ae) {
        pilihBtn.addActionListener(ae);
        btnMenu.addActionListener(ae);
    }
    
    public void Adapter(MouseAdapter ME)
    {
        tabelKandidat.addMouseListener(ME);
    }
}
