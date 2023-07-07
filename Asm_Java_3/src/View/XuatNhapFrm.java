/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Service.DanhMucService;
import Model.DanhMuc;
import Model.NhatKyNhapXuat;
import Model.XuatNhap;
import Service.XuatNhapService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ttuan
 */
public class XuatNhapFrm extends javax.swing.JFrame {

    DanhMucService danhMucService = new DanhMucService();
    XuatNhapService xuatNhapService = new XuatNhapService();
    int index;
    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form XuatNhapFrm
     */
    public XuatNhapFrm() {
        initComponents();
        setLocationRelativeTo(null);
        LoadDanhMuc();

    }

    public void LoadDanhMuc() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cbnDanhMuc.getModel();
            //XÓa dữ liệu cũ
            model.removeAllElements();
            List<DanhMuc> danhMuc = danhMucService.findAll();
            model.addAll(danhMuc);
            cbnDanhMuc.setModel(model);
            cbnDanhMuc.setSelectedIndex(0);

        } catch (Exception ex) {
            Logger.getLogger(XuatNhapFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fillToTable() {
        try {
            DanhMuc selectedDM = (DanhMuc) cbnDanhMuc.getSelectedItem();
            Integer selectedDMId = selectedDM.getCategoryId();
            
            
            
            
            List<XuatNhap> danhSach = xuatNhapService.findByDanhMuc(selectedDMId);
            DefaultTableModel model = (DefaultTableModel) tblTable.getModel();
            model.setRowCount(0);
            for (XuatNhap xn : danhSach) {
                model.addRow(new Object[]{xn.getProductId(), xn.getProductName(), xn.getQuantity(), xn.getCurrenPrice()});
            }
        } catch (Exception ex) {
            Logger.getLogger(XuatNhapFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean checkNhap(String a) {
        if (xuatNhapService.CheckNull(a) == false) {
            return false;
        }
        if (xuatNhapService.checkSo(a) == false) {
            return false;
        }
        if (xuatNhapService.checkSoTN(a) == false) {
            return false;
        }
        if (xuatNhapService.checkSL(a) == false) {
            return false;
        }

        return true;
    }

    public boolean checkXuat(String a) {
        if (xuatNhapService.CheckNull(a) == false) {
            return false;
        }
        if (xuatNhapService.checkSo(a) == false) {
            return false;
        }
        if (xuatNhapService.checkSoTN(a) == false) {
            return false;
        }
        if (xuatNhapService.checkSL(a) == false) {
            return false;
        }
        int chon = tblTable.getSelectedRow();
        int SL = (int) tblTable.getValueAt(chon, 2);
        if (xuatNhapService.checkQuaSL(a, SL) == false) {
            return false;
        }

        return true;
    }

    public void nhap() {
        String Sluong = JOptionPane.showInputDialog(this, "Mời nhập số lượng muốn nhập:");
        index = tblTable.getSelectedRow();
        int id = (int) tblTable.getValueAt(index, 0);
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Mời chọn sản phẩm muốn nhập thêm", "LỖI", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (checkNhap(Sluong)) {

            Integer kqua = xuatNhapService.Nhap(Double.parseDouble(Sluong), id);
            if (kqua > -1) {
                JOptionPane.showMessageDialog(this, "Nhập thành công");
                
                Integer nhap = 1;
                LocalDateTime tg = null;
                double sl = Double.parseDouble(Sluong);
                BigDecimal sl2 = new BigDecimal(sl);
                BigDecimal gia1SP = (BigDecimal) tblTable.getValueAt(index, 3);
                BigDecimal gia2 = sl2.multiply(gia1SP);
                NhatKyNhapXuat nk = new NhatKyNhapXuat(id, tg, nhap, sl, gia2);

                Integer kqua1 = xuatNhapService.NhatkyNhap(nk);
                if (kqua1 > -1) {
                    JOptionPane.showMessageDialog(this, "Lưu thành công vào nhật ký xuất nhập");
                } else {
                    JOptionPane.showMessageDialog(this, "Lưu thất bại vào nhật ký xuất nhập");
                }

            } else {
                JOptionPane.showMessageDialog(this, "Nhập thất bại");
            }
            fillToTable();

        }

    }

    public void xuat() {
        String Sluong = JOptionPane.showInputDialog(this, "Mời nhập số lượng muốn xuất:");
        index = tblTable.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Mời chọn sản phẩm muốn xuất", "LỖI", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (checkXuat(Sluong)) {
            int id = (int) tblTable.getValueAt(index, 0);
            Integer kqua = xuatNhapService.Xuat(Double.parseDouble(Sluong), id);
            if (kqua > -1) {
                JOptionPane.showMessageDialog(this, "Xuất thành công");
                
                Integer xuat = 0;
                LocalDateTime tg = null;
                double sl = Double.parseDouble(Sluong);
                BigDecimal sl2 = new BigDecimal(sl);
                BigDecimal gia1SP = (BigDecimal) tblTable.getValueAt(index, 3);
                BigDecimal gia2 = sl2.multiply(gia1SP);
                NhatKyNhapXuat nk = new NhatKyNhapXuat(id, tg, xuat, sl, gia2);

                Integer kqua1 = xuatNhapService.NhatkyNhap(nk);
                if (kqua1 > -1) {
                    JOptionPane.showMessageDialog(this, "Lưu thành công vào nhật ký xuất nhập");
                } else {
                    JOptionPane.showMessageDialog(this, "Lưu thất bại vào nhật ký xuất nhập");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Xuất thất bại");
            }
            fillToTable();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbnDanhMuc = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTable = new javax.swing.JTable();
        btnNhap = new javax.swing.JButton();
        btnXuat = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        btnXem = new javax.swing.JButton();
        btnQuayLai = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("NHẬP XUẤT");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Danh sách danh mục:");

        tblTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá hiện tại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTable);

        btnNhap.setText("Nhập");
        btnNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapActionPerformed(evt);
            }
        });

        btnXuat.setText("Xuất");
        btnXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnXem.setText("Xem");
        btnXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemActionPerformed(evt);
            }
        });

        btnQuayLai.setText("Quay lại");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbnDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXem))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(btnNhap)
                        .addGap(85, 85, 85)
                        .addComponent(btnXuat)
                        .addGap(95, 95, 95)
                        .addComponent(btnThoat))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnQuayLai)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnNhap, btnThoat, btnXuat});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnQuayLai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbnDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNhap)
                    .addComponent(btnXuat)
                    .addComponent(btnThoat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemActionPerformed
        fillToTable();

    }//GEN-LAST:event_btnXemActionPerformed

    private void btnNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapActionPerformed
        // TODO add your handling code here:
        nhap();
    }//GEN-LAST:event_btnNhapActionPerformed

    private void btnXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatActionPerformed
        xuat();
    }//GEN-LAST:event_btnXuatActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        int chon= JOptionPane.showConfirmDialog(this, "Bạn muốn thoát ?","THOÁT", JOptionPane.YES_NO_OPTION);
        if(chon==JOptionPane.YES_OPTION){
            this.dispose();
        }else{
            return;
        }
        
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        new DangNhapFrm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnQuayLaiActionPerformed

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
            java.util.logging.Logger.getLogger(XuatNhapFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XuatNhapFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XuatNhapFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XuatNhapFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new XuatNhapFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNhap;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXem;
    private javax.swing.JButton btnXuat;
    private javax.swing.JComboBox cbnDanhMuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTable;
    // End of variables declaration//GEN-END:variables
}
