/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package kasirpro;

import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author M. Aziz Ridwan
 */
public class Kasir extends javax.swing.JPanel {

    String Tanggal;
    private DefaultTableModel model;

    public void totalBiaya() {
        int jumlahBaris = TabelKasir.getRowCount();
        int totalBiaya = 0;
        int jumlahBarang, hargaBarang;
        for (int i = 0; i < jumlahBaris; i++) {
            jumlahBarang = Integer.parseInt(TabelKasir.getValueAt(i, 3).toString());
            hargaBarang = Integer.parseInt(TabelKasir.getValueAt(i, 4).toString());
            totalBiaya = totalBiaya + (jumlahBarang * hargaBarang);
        }
        txTotalBayar.setText(String.valueOf(totalBiaya));
        txTampil.setText("Rp " + totalBiaya + ",00");
    }

    private void autonumber() {
        try {
            Connection c = Koneksi.ConfigDB();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM penjualan ORDER BY NoFaktur DESC";
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                String NoFaktur = r.getString("NoFaktur").substring(2);
                String TR = "" + (Integer.parseInt(NoFaktur) + 1);
                String Nol = "";

                if (TR.length() == 1) {
                    Nol = "000";
                } else if (TR.length() == 2) {
                    Nol = "000";
                } else if (TR.length() == 3) {
                    Nol = "0";
                } else if (TR.length() == 4) {
                    Nol = "";
                }
                txNoTransaksi.setText("TR" + Nol + TR);
            } else {
                txNoTransaksi.setText("TR0001");
            }
            r.close();
            s.close();
        } catch (Exception e) {
            System.out.println("autonumber error");
        }
    }

    private void autoCustomerID() {
        try {
            Connection c = Koneksi.ConfigDB();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM penjualan ORDER BY ID_Customer DESC";
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                String idCustomer = r.getString("ID_Customer").substring(2);
                String CS = "" + (Integer.parseInt(idCustomer) + 1);
                String Nol = "";

                if (CS.length() == 1) {
                    Nol = "000";
                } else if (CS.length() == 2) {
                    Nol = "00";
                } else if (CS.length() == 3) {
                    Nol = "0";
                } else if (CS.length() == 4) {
                    Nol = "";
                }
                txIDCustomer.setText("CS" + Nol + CS);
            } else {
                txIDCustomer.setText("CS0001");
            }
            r.close();
            s.close();
        } catch (Exception e) {
            System.out.println("autoCustomerID error");
        }
    }

    public void loadData() {
        DefaultTableModel model = (DefaultTableModel) TabelKasir.getModel();
        model.addRow(new Object[]{
            txNoTransaksi.getText(),
            txIDBarang.getText(),
            txNamaBarang.getText(),
            txJumlah.getText(),
            txHarga.getText(),
            txTotalBayar.getText()
        });
    }

    public void kosong() {
        DefaultTableModel model = (DefaultTableModel) TabelKasir.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    public void utama() {
        txNoTransaksi.setText("");
        txIDBarang.setText("");
        txNamaBarang.setText("");
        txHarga.setText("");
        txJumlah.setText("");

        autonumber();

    }

    public void clear() {
        txIDCustomer.setText("");
        txNamaCustomer.setText("");
        txTotalBayar.setText("0");
        TxBayar.setText("0");
        TxKembalian.setText("0");
        txTampil.setText("0");

    }

    public void clear2() {
        txIDBarang.setText("");
        txNamaBarang.setText("");
        txHarga.setText("");
        txJumlah.setText("");
    }

    public void tambahTransaksi() {
        Integer jumlah, harga, total;

        jumlah = Integer.valueOf(txJumlah.getText());
        harga = Integer.valueOf(txHarga.getText());
        total = jumlah * harga;

        txTotalBayar.setText(String.valueOf(total));

        loadData();
        totalBiaya();
        clear2();
        txIDBarang.requestFocus();
    }

    /**
     * Creates new form Kasir
     */
    public Kasir() {
        initComponents();
        

        //membuat tabel
        reset();
        model = new DefaultTableModel();

        TabelKasir.setModel(model);

        model.addColumn("No Transaksi");
        model.addColumn("ID Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Jumlah");
        model.addColumn("Harga");
        model.addColumn("Total");

        utama();
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");

        txTanggal.setText(s.format(date));
        txTotalBayar.setText("0");
        TxBayar.setText("0");
        TxKembalian.setText("0");
        txIDCustomer.requestFocus();
        autoCustomerID();

    }

    void reset() {

        txNamaCustomer.setText(null);
        txIDBarang.setText(null);
        txNamaBarang.setText(null);
        txHarga.setText(null);
        txJumlah.setText(null);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txNamaCustomer = new javax.swing.JTextField();
        txNoTransaksi = new javax.swing.JTextField();
        txIDCustomer = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txIDBarang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txNamaBarang = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txHarga = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txJumlah = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txTanggal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelKasir = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnCariMakanan = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        txTampil = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txTotalBayar = new javax.swing.JTextField();
        TxBayar = new javax.swing.JTextField();
        TxKembalian = new javax.swing.JTextField();
        bCetak = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tanggal");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("No Transaksi");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID Customer");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));
        add(txNamaCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 200, 30));

        txNoTransaksi.setEnabled(false);
        add(txNoTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 200, 30));

        txIDCustomer.setEditable(false);
        add(txIDCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 200, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nama Customer");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));
        add(txIDBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 120, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ID Pesanan");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));
        add(txNamaBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 220, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nama Pesanan");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, -1, -1));
        add(txHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 100, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Harga");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, -1, -1));

        txJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txJumlahActionPerformed(evt);
            }
        });
        add(txJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 80, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Kembalian");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 580, -1, -1));

        txTanggal.setEnabled(false);
        add(txTanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 110, 160, -1));

        TabelKasir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TabelKasir.setForeground(new java.awt.Color(255, 51, 255));
        TabelKasir.setModel(new javax.swing.table.DefaultTableModel(
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
        TabelKasir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelKasirMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelKasir);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 880, 180));

        btnTambah.setBackground(new java.awt.Color(255, 102, 255));
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 310, -1, 50));

        btnHapus.setBackground(new java.awt.Color(255, 51, 51));
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 370, -1, 60));

        btnCariMakanan.setBackground(new java.awt.Color(255, 255, 102));
        btnCariMakanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/bibimbap (1).png"))); // NOI18N
        btnCariMakanan.setText("Menu Makanan");
        btnCariMakanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariMakananActionPerformed(evt);
            }
        });
        add(btnCariMakanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, -1, -1));

        jButton4.setBackground(new java.awt.Color(255, 255, 102));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/drink (1).png"))); // NOI18N
        jButton4.setText("Menu Minuman");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, -1, -1));

        jButton5.setBackground(new java.awt.Color(255, 255, 102));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/fast-food (1).png"))); // NOI18N
        jButton5.setText("Menu Paket Hemat");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 160, -1, -1));

        jLabel10.setFont(new java.awt.Font("Pristina", 3, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 51));
        jLabel10.setText("Cari menu disini");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 150, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/KK-removebg-preview (1).png"))); // NOI18N
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 490, 230, 130));

        btnSimpan.setBackground(new java.awt.Color(204, 204, 255));
        btnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/checklist.png"))); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 510, -1, 50));

        txTampil.setBackground(new java.awt.Color(0, 204, 102));
        txTampil.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txTampil.setText("Rp. 0");
        add(txTampil, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 510, 230, 50));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Jumlah");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Total Bayar");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 520, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Bayar");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 550, -1, -1));

        txTotalBayar.setEnabled(false);
        add(txTotalBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 520, 110, -1));

        TxBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxBayarActionPerformed(evt);
            }
        });
        add(TxBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 550, 110, -1));

        TxKembalian.setEnabled(false);
        add(TxKembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 580, 110, -1));

        bCetak.setBackground(new java.awt.Color(0, 204, 204));
        bCetak.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bCetak.setForeground(new java.awt.Color(255, 255, 255));
        bCetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/printer.png"))); // NOI18N
        bCetak.setText("CETAK TRANSAKI ");
        bCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCetakActionPerformed(evt);
            }
        });
        add(bCetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 230, 50));

        btnReset.setBackground(new java.awt.Color(255, 255, 153));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 440, -1, 50));

        jButton1.setBackground(new java.awt.Color(255, 153, 153));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("LAPORAN PENJUALAN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 270, 160, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/kas (1).png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 640));
    }// </editor-fold>//GEN-END:initComponents

    private void txJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txJumlahActionPerformed
        tambahTransaksi();
    }//GEN-LAST:event_txJumlahActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        tambahTransaksi();
       
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        DefaultTableModel model = (DefaultTableModel) TabelKasir.getModel();
        int row = TabelKasir.getSelectedRow();
        model.removeRow(row);
        totalBiaya();
        TxBayar.setText("0");
        TxKembalian.setText("0");
    }//GEN-LAST:event_btnHapusActionPerformed

    private void TxBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxBayarActionPerformed
        int total, bayar, kembalian;

        total = Integer.valueOf(txTotalBayar.getText());
        bayar = Integer.valueOf(TxBayar.getText());

        if (total > bayar) {
            JOptionPane.showMessageDialog(null, "Uang tidak cukup untuk melakukan pembayaran");
        } else {
            kembalian = bayar - total;
            TxKembalian.setText(String.valueOf(kembalian));
        }
    }//GEN-LAST:event_TxBayarActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        DefaultTableModel model = (DefaultTableModel) TabelKasir.getModel();

        String noTransaksi = txNoTransaksi.getText();
        String tanggal = txTanggal.getText();
        String idCustomer = txIDCustomer.getText();
        String total = txTotalBayar.getText();

        try {
            Connection c = Koneksi.ConfigDB();

            String barang = txIDBarang.getText();

            String sqlPaket = "SELECT ID_Paket FROM paket WHERE ID_Paket = ?";
            PreparedStatement stmtPaket = c.prepareStatement(sqlPaket);
            stmtPaket.setString(1, barang);
            ResultSet rsPaket = stmtPaket.executeQuery();

            String idPaket = null;
            if (rsPaket.next()) {
                idPaket = rsPaket.getString("ID_Paket");
            }

            if (idPaket == null) {
                String sqlMinuman = "SELECT ID_Minuman FROM minuman WHERE ID_Minuman = ?";
                PreparedStatement stmtMinuman = c.prepareStatement(sqlMinuman);
                stmtMinuman.setString(1, barang);
                ResultSet rsMinuman = stmtMinuman.executeQuery();

                if (rsMinuman.next()) {
                    idPaket = null;
                    String idMinuman = rsMinuman.getString("ID_Minuman");
                }

                stmtMinuman.close();
            }

            if (idPaket == null) {
                String sqlMakanan = "SELECT ID_Makanan FROM makanan WHERE ID_Makanan = ?";
                PreparedStatement stmtMakanan = c.prepareStatement(sqlMakanan);
                stmtMakanan.setString(1, barang);
                ResultSet rsMakanan = stmtMakanan.executeQuery();

                if (rsMakanan.next()) {
                    idPaket = null;
                    String idMakanan = rsMakanan.getString("ID_Makanan");
                }

                stmtMakanan.close();
            }

            stmtPaket.close();

            String sqlPenjualan = "INSERT INTO penjualan (NoFaktur, Tanggal, ID_Customer, TotalBeli, ID_Paket, ID_Minuman, ID_Makanan) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmtPenjualan = c.prepareStatement(sqlPenjualan);
            stmtPenjualan.setString(1, noTransaksi);
            stmtPenjualan.setString(2, tanggal);
            stmtPenjualan.setString(3, idCustomer);
            stmtPenjualan.setString(4, total);
            stmtPenjualan.setString(5, idPaket);

            stmtPenjualan.setString(6, null);
            stmtPenjualan.setString(7, null);
            stmtPenjualan.executeUpdate();
            stmtPenjualan.close();

            int baris = TabelKasir.getRowCount();
            String sqlPenjualanRinci = "INSERT INTO penjualan_rinci (nof, ID_Barang, Nama_Barang, Jumlah, Harga, Total) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmtPenjualanRinci = c.prepareStatement(sqlPenjualanRinci);
            for (int i = 0; i < baris; i++) {
                stmtPenjualanRinci.setString(1, noTransaksi);
                stmtPenjualanRinci.setString(2, TabelKasir.getValueAt(i, 1).toString());
                stmtPenjualanRinci.setString(3, TabelKasir.getValueAt(i, 2).toString());  // Nama_Barang
                stmtPenjualanRinci.setInt(4, Integer.parseInt(TabelKasir.getValueAt(i, 3).toString()));  // Jumlah
                stmtPenjualanRinci.setInt(5, Integer.parseInt(TabelKasir.getValueAt(i, 4).toString()));  // Harga
                stmtPenjualanRinci.setInt(6, Integer.parseInt(TabelKasir.getValueAt(i, 5).toString()));  // Total
                stmtPenjualanRinci.executeUpdate();
            }
            stmtPenjualanRinci.close();

            clear();
            utama();
            autonumber();

            kosong();
            txTampil.setText("Rp. 0");

        } catch (Exception e) {
            System.out.println("Simpan kasir error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnCariMakananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariMakananActionPerformed
        ListMakanan a = new ListMakanan();
        a.setVisible(true);


    }//GEN-LAST:event_btnCariMakananActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ListMinuman a = new ListMinuman();
        a.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ListPaketHemat a = new ListPaketHemat();
        a.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void bCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCetakActionPerformed
        Print p = new Print();
        p.setVisible(true);
    }//GEN-LAST:event_bCetakActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void TabelKasirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelKasirMouseClicked


    }//GEN-LAST:event_TabelKasirMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        laporan l = new laporan();
        l.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelKasir;
    private javax.swing.JTextField TxBayar;
    private javax.swing.JTextField TxKembalian;
    private javax.swing.JButton bCetak;
    private javax.swing.JButton btnCariMakanan;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField txHarga;
    public static javax.swing.JTextField txIDBarang;
    private javax.swing.JTextField txIDCustomer;
    private javax.swing.JTextField txJumlah;
    public static javax.swing.JTextField txNamaBarang;
    private javax.swing.JTextField txNamaCustomer;
    private javax.swing.JTextField txNoTransaksi;
    private javax.swing.JTextField txTampil;
    private javax.swing.JTextField txTanggal;
    private javax.swing.JTextField txTotalBayar;
    // End of variables declaration//GEN-END:variables
}
