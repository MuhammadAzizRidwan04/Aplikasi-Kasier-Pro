/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package kasirpro;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author M. Aziz Ridwan
 */
public class Minuman extends javax.swing.JPanel {

    private DefaultTableModel model;

    private void nomorOtomatis() {
        try {
            Connection c = Koneksi.ConfigDB();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM minuman ORDER BY ID_Minuman DESC";
            ResultSet r = s.executeQuery(sql);

            if (r.next()) {
                String NoFaktur = r.getString("ID_Minuman").substring(2);
                String BR = "" + (Integer.parseInt(NoFaktur) + 1);
                String Nol = "";

                if (BR.length() == 1) {
                    Nol = "00";
                } else if (BR.length() == 2) {
                    Nol = "0";
                } else if (BR.length() == 3) {
                    Nol = "";
                }

                txIDMinuman.setText("MN" + Nol + BR);
            } else {
                txIDMinuman.setText("MN001");
            }
            r.close();
            s.close();
        } catch (Exception e) {
            System.out.println("NomorOtoamtis error");
        }
    }

    public void clear() {
        txNamaMinuman.setText("");
        txHarga.setText("");
    }

    public void loadData() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {
            Connection c = Koneksi.ConfigDB();
            Statement s = c.createStatement();

            String sql = "SELECT * FROM minuman";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                Object[] o = new Object[3];
                o[0] = r.getString("ID_Minuman");
                o[1] = r.getString("Nama_Minuman");
                o[2] = r.getString("Harga");

                model.addRow(o);
            }
            r.close();
            s.close();

        } catch (Exception e) {
            System.out.println("Terjadi Kesalahan");
        }
    }

    public void cariData() {
        DefaultTableModel tabel = new DefaultTableModel();

        tabel.addColumn("ID Minuman");
        tabel.addColumn("Nama Minuman");
        tabel.addColumn("Harga");

        try {
            Connection c = Koneksi.ConfigDB();
            String sql = "Select * from minuman where ID_Minuman like '%" + txCari.getText() + "%'"
                    + "or Nama_Minuman like '%" + txCari.getText() + "%'";
            Statement stat = c.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                tabel.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3)
                });
            }
            tbMinuman.setModel(tabel);
        } catch (Exception e) {
            System.out.println("Cari Data Error");
            e.printStackTrace();
        }
    }

    /**
     * Creates new form Minuman
     */
    public Minuman() {
        initComponents();
        model = new DefaultTableModel();
        tbMinuman.setModel(model);

        model.addColumn("ID_Minuman");
        model.addColumn("Nama_Minuman");
        model.addColumn("Harga");

        loadData();
        nomorOtomatis();

        btnEdit.setEnabled(false);
        btnHapus.setEnabled(false);
        btnBatal.setEnabled(false);
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
        txNamaMinuman = new javax.swing.JTextField();
        txIDMinuman = new javax.swing.JTextField();
        txHarga = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txCari = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMinuman = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID Minuman");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama Minuman");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Harga");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));
        add(txNamaMinuman, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 190, 30));
        add(txIDMinuman, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 190, 30));
        add(txHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 190, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cari");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 120, -1, -1));

        txCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txCariActionPerformed(evt);
            }
        });
        txCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txCariKeyTyped(evt);
            }
        });
        add(txCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 120, 210, -1));

        btnSimpan.setBackground(new java.awt.Color(204, 204, 255));
        btnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-save-24 (1).png"))); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, -1, -1));

        btnEdit.setBackground(new java.awt.Color(255, 204, 0));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/edit.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, -1, -1));

        btnBatal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/left-arrow.png"))); // NOI18N
        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 260, -1, -1));

        btnHapus.setBackground(new java.awt.Color(255, 51, 0));
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/delete.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 260, -1, -1));

        tbMinuman.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tbMinuman.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        tbMinuman.setModel(new javax.swing.table.DefaultTableModel(
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
        tbMinuman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMinumanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMinuman);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 990, 280));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/minuman (1).png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int i = tbMinuman.getSelectedRow();

        if (i == -1) {
            return;
        }
        String id = (String) model.getValueAt(i, 0);
        String nama = txNamaMinuman.getText();
        String harga = txHarga.getText();

        try {
            Connection c = Koneksi.ConfigDB();
            String sql = "UPDATE minuman SET Nama_Minuman = ?, Harga = ? WHERE ID_Minuman = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, nama);
            p.setString(2, harga);
            p.setString(3, id);

            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null, "Data Terubah");
            btnSimpan.setEnabled(true);
            btnEdit.setEnabled(false);
            btnHapus.setEnabled(false);
            btnBatal.setEnabled(false);
            clear();
        } catch (Exception e) {
            System.out.println("Update Error");
        } finally {
            loadData();
            nomorOtomatis();
        }

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int i = tbMinuman.getSelectedRow();

        if (i == -1) {
            return;
        }

        String id = (String) model.getValueAt(i, 0);
        int pernyataan = JOptionPane.showConfirmDialog(null, "Yakin Data Akan Dihapus", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (pernyataan == JOptionPane.OK_OPTION) {
            try {
                Connection c = Koneksi.ConfigDB();
                String sql = "DELETE FROM minuman WHERE ID_Minuman = ?";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, id);
                p.executeUpdate();
                p.close();
                JOptionPane.showMessageDialog(null, "Data Terhapus");
            } catch (Exception e) {
                System.out.println("Terjadi Kesalahan");
            } finally {
                btnSimpan.setEnabled(true);
                btnEdit.setEnabled(false);
                btnHapus.setEnabled(false);
                btnBatal.setEnabled(false);
                loadData();
                nomorOtomatis();
                clear();
            }
        }
        if (pernyataan == JOptionPane.CANCEL_OPTION) {

        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String id = txIDMinuman.getText();
        String nama = txNamaMinuman.getText();
        String harga = txHarga.getText();

        try {
            Connection c = Koneksi.ConfigDB();
            String sql = "INSERT INTO MINUMAN VALUES (?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, id);
            p.setString(2, nama);
            p.setString(3, harga);
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null, "Data Tersimpan");
            loadData();

        } catch (Exception e) {
            System.out.println("Terjadi Kesalahan");
        } finally {
            nomorOtomatis();
            clear();
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        clear();
        loadData();
        btnSimpan.setEnabled(true);
        btnEdit.setEnabled(false);
        btnHapus.setEnabled(false);
        btnBatal.setEnabled(false);

        nomorOtomatis();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void txCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txCariActionPerformed
        cariData();
    }//GEN-LAST:event_txCariActionPerformed

    private void txCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCariKeyTyped
        cariData();
    }//GEN-LAST:event_txCariKeyTyped

    private void tbMinumanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMinumanMouseClicked
        btnSimpan.setEnabled(false);
        btnEdit.setEnabled(true);
        btnHapus.setEnabled(true);
        btnBatal.setEnabled(true);

        int i = tbMinuman.getSelectedRow();
        if (i == -1) {
            return;
        }
        String id = (String) tbMinuman.getValueAt(i, 0);
        String nama = (String) tbMinuman.getValueAt(i, 1);
        String harga = (String) tbMinuman.getValueAt(i, 2);

        txIDMinuman.setText(id);
        txNamaMinuman.setText(nama);
        txHarga.setText(harga);
    }//GEN-LAST:event_tbMinumanMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbMinuman;
    private javax.swing.JTextField txCari;
    private javax.swing.JTextField txHarga;
    private javax.swing.JTextField txIDMinuman;
    private javax.swing.JTextField txNamaMinuman;
    // End of variables declaration//GEN-END:variables
}