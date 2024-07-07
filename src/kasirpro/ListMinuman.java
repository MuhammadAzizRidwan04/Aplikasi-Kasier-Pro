/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package kasirpro;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class ListMinuman extends javax.swing.JFrame {

    private DefaultTableModel model;

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

    public void cari() {
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
                    rs.getString(3),});
            }
            TbListMinuman.setModel(tabel);
            loadData();
        } catch (Exception e) {
            System.out.println("Cari Data Error");
        } finally {
        }
    }

    /**
     * Creates new form ListMinuman
     */
    public ListMinuman() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        model = new DefaultTableModel();

        TbListMinuman.setModel(model);

        model.addColumn("ID Makanan");
        model.addColumn("Nama Makanan");
        model.addColumn("Harga");

        loadData();
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
        txCari = new javax.swing.JTextField();
        btnPilih = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbListMinuman = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cari");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

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
        getContentPane().add(txCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 530, 30));

        btnPilih.setText("Pilih");
        btnPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilihActionPerformed(evt);
            }
        });
        getContentPane().add(btnPilih, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 120, -1, 30));

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        getContentPane().add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, -1, 30));

        TbListMinuman.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TbListMinuman.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        TbListMinuman.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TbListMinuman);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 167, 1000, 450));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/lmn (1).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihActionPerformed
        int i = TbListMinuman.getSelectedRow();

        String id = TbListMinuman.getValueAt(i, 0).toString();
        String nama = TbListMinuman.getValueAt(i, 1).toString();
        String harga = TbListMinuman.getValueAt(i, 2).toString();

        Kasir.txIDBarang.setText(id);
        Kasir.txNamaBarang.setText(nama);
        Kasir.txHarga.setText(harga);

        dispose();

    }//GEN-LAST:event_btnPilihActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
      this.dispose();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void txCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txCariActionPerformed
        cari();
    }//GEN-LAST:event_txCariActionPerformed

    private void txCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCariKeyTyped
       cari();
    }//GEN-LAST:event_txCariKeyTyped

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
            java.util.logging.Logger.getLogger(ListMinuman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListMinuman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListMinuman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListMinuman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListMinuman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TbListMinuman;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnPilih;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txCari;
    // End of variables declaration//GEN-END:variables
}
