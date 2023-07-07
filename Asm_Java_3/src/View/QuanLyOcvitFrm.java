/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.OcVit;
import Model.OcvitTable;
import Service.OcvitService;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ttuan
 */
public class QuanLyOcvitFrm extends javax.swing.JFrame {

    OcvitService ocvitService = new OcvitService();
    DefaultTableModel model = new DefaultTableModel();
    int index;

    /**
     * Creates new form QuanLyOcvitFrm
     */
    public QuanLyOcvitFrm() {
        initComponents();
        setLocationRelativeTo(null);
        model = (DefaultTableModel) tblTable.getModel();
        fillToTable();

    }

    public void fillToTable() {
        try {
            List<OcVit> dsOcVit = ocvitService.layDanhSach();
            model.setRowCount(0);
            for (OcVit oc : dsOcVit) {
                model.addRow(new Object[]{oc.getId(), oc.getCategoryId(),
                    oc.getProductName(), oc.getCurrenPrice(), Math.round(oc.getQuantity()),
                    oc.getOrigin(), oc.getUses()});
            }
        } catch (Exception ex) {
            Logger.getLogger(QuanLyOcvitFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public void showDetail() throws Exception {
//        OcvitTable ocvit = ocvitService.layDanhSach().get(index);
//        txtId.setText(ocvit.getId() + "");
//        txtMaDM.setText(ocvit.getCategoryId() + "");
//        txtTen.setText(ocvit.getProductName());
//        txtGia.setText(ocvit.getCurrenPrice() + "");
//        txtSoLuong.setText(ocvit.getQuantity() + "");
//        txtXXu.setText(ocvit.getOrigin());
//        txtTDung.setText(ocvit.getUses());
//    }
//
//    public void Clear() {
//        txtId.setText("");
//        txtMaDM.setText("");
//        txtTen.setText("");
//        txtGia.setText("");
//        txtSoLuong.setText("");
//        txtXXu.setText("");
//        txtTDung.setText("");
//    }

//    public boolean checkAllThem() {
//        if (ocvitService.checkNull(txtMaDM) == false) {
//            JOptionPane.showMessageDialog(this, "Mã danh mục không được bỏ trống", "LỖI", JOptionPane.WARNING_MESSAGE);
//            return false;
//        }
//        if (ocvitService.checkMaDM(txtMaDM) == false) {
//            JOptionPane.showMessageDialog(this, "Mã danh mục không tồn tại", "LỖI", JOptionPane.WARNING_MESSAGE);
//            return false;
//        }
//        if (ocvitService.checkNull(txtTen) == false) {
//            JOptionPane.showMessageDialog(this, "Tên sản phẩm không được bỏ trống", "LỖI", JOptionPane.WARNING_MESSAGE);
//            return false;
//        }
//        if (ocvitService.checkNull(txtGia) == false) {
//            JOptionPane.showMessageDialog(this, "Giá sản phẩm không được bỏ trống", "LỖI", JOptionPane.WARNING_MESSAGE);
//            return false;
//        }
//        if (ocvitService.checkGia(txtGia) == false) {
//            return false;
//        }
//
//        if (ocvitService.checkNull(txtSoLuong) == false) {
//            JOptionPane.showMessageDialog(this, "Số lượng sản phẩm không được bỏ trống", "LỖI", JOptionPane.WARNING_MESSAGE);
//            return false;
//        }
//        if (ocvitService.checkSL(txtSoLuong) == false) {
//            return false;
//        }
//        if (ocvitService.checkNull(txtXXu) == false) {
//            JOptionPane.showMessageDialog(this, "Xuất xứ sản phẩm không được bỏ trống", "LỖI", JOptionPane.WARNING_MESSAGE);
//            return false;
//        }
//        if (ocvitService.checkNull(txtTDung) == false) {
//            JOptionPane.showMessageDialog(this, "Tác dụng sản phẩm không được bỏ trống", "LỖI", JOptionPane.WARNING_MESSAGE);
//            return false;
//        }
//        return true;
//    }
//    public boolean checkAllCapNhat() {
//
//        int chon = tblTable.getSelectedRow();
//        int id = (int) tblTable.getValueAt(chon, 0);
//
//        if (ocvitService.checkIdCapNhat(txtId) == false) {
//            JOptionPane.showMessageDialog(this, "Mã sản phẩm không thể sửa", "LỖI", JOptionPane.WARNING_MESSAGE);
//            txtId.setText(id + "");
//            return false;
//        }
//
//        if (ocvitService.checkNull(txtMaDM) == false) {
//            JOptionPane.showMessageDialog(this, "Mã danh mục không được bỏ trống", "LỖI", JOptionPane.WARNING_MESSAGE);
//            return false;
//        }
//        if (ocvitService.checkMaDM(txtMaDM) == false) {
//            JOptionPane.showMessageDialog(this, "Mã danh mục không tồn tại", "LỖI", JOptionPane.WARNING_MESSAGE);
//            return false;
//        }
//        if (ocvitService.checkNull(txtTen) == false) {
//            JOptionPane.showMessageDialog(this, "Tên sản phẩm không được bỏ trống", "LỖI", JOptionPane.WARNING_MESSAGE);
//            return false;
//        }
//
//        BigDecimal gia = (BigDecimal) tblTable.getValueAt(chon, 3);
//
//        if (ocvitService.checkGiaCapNhat(txtGia, id) == false) {
//            JOptionPane.showMessageDialog(this, "Giá sản phẩm không được sửa", "LỖI", JOptionPane.WARNING_MESSAGE);
//            txtGia.setText(gia + "");
//            return false;
//        }
//        Integer sl = (Integer) tblTable.getValueAt(chon, 4);
//
//        if (ocvitService.checkSLCapNhat(txtSoLuong, id) == false) {
//            JOptionPane.showMessageDialog(this, "Số lượng sản phẩm không được sửa", "LỖI", JOptionPane.WARNING_MESSAGE);
//            txtSoLuong.setText(sl + "");
//            return false;
//        }
//        if (ocvitService.checkNull(txtXXu) == false) {
//            JOptionPane.showMessageDialog(this, "Xuất xứ sản phẩm không được bỏ trống", "LỖI", JOptionPane.WARNING_MESSAGE);
//            return false;
//        }
//        if (ocvitService.checkNull(txtTDung) == false) {
//            JOptionPane.showMessageDialog(this, "Tác dụng sản phẩm không được bỏ trống", "LỖI", JOptionPane.WARNING_MESSAGE);
//            return false;
//        }
//        return true;
//    }

//    public void them() {
//        if (checkAllThem()) {
//            int lchon = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thêm", "THÊM", JOptionPane.YES_NO_OPTION);
//            if (lchon == JOptionPane.YES_OPTION) {
//
//                Integer id = 1;
//                Integer categoryId = Integer.parseInt(txtMaDM.getText());
//                String productName = txtTen.getText();
//                BigDecimal currenPrice = new BigDecimal(txtGia.getText());
//                double quantity = Double.parseDouble(txtSoLuong.getText());
//                String origin = txtXXu.getText();
//                String uses = txtTDung.getText();
//                OcVit ocvit = new OcVit(id, categoryId, productName, currenPrice, quantity, origin, uses);
//
//                Integer kqua = ocvitService.ThemOcVit(ocvit);
//                if (kqua > -1) {
//                    ocvit.setId(id);
//                    ocvit.setCategoryId(categoryId);
//                    ocvit.setProductName(productName);
//                    ocvit.setCurrenPrice(currenPrice);
//                    ocvit.setQuantity(quantity);
//                    ocvit.setOrigin(origin);
//                    ocvit.setUses(uses);
//
//                    JOptionPane.showMessageDialog(this, "Thêm thành công");
//                    Clear();
//                    fillToTable();
//                } else {
//                    JOptionPane.showMessageDialog(this, "Thêm thất bại");
//                }
//            } else {
//                return;
//            }
//        }
//
//    }
    public void Xoa() throws Exception {
        int lchon = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa", "XÓA", JOptionPane.YES_NO_OPTION);
        if (lchon == JOptionPane.YES_OPTION) {
            int chonHang = tblTable.getSelectedRow();
            if (chonHang == -1) {
                JOptionPane.showMessageDialog(this, "Mời chọn hàng muốn xóa?");
                return;
            }
            int id = (int) tblTable.getValueAt(chonHang, 0);
            Integer kqua = ocvitService.XoaOc(id);
            if (kqua > -1) {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        } else {
            return;
        }
        fillToTable();
    }

    public void LoadTimKiem() {

    }

    public void TimKiem() throws Exception {
        String nhap = JOptionPane.showInputDialog(this, "Mời nhập ốc vít muốn tìm:");

        List<OcVit> dsocvit = ocvitService.TimKiemOcVit(nhap);
        if (dsocvit == null) {
            JOptionPane.showMessageDialog(this, "Lỗi");
        } else if (dsocvit.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sản phẩm không tồn tại");
        } else {
            JOptionPane.showMessageDialog(this, "Tìm thành công");
            model.setRowCount(0);
            for (OcVit oc : dsocvit) {
                model.addRow(new Object[]{oc.getId(), oc.getCategoryId(),
                    oc.getProductName(), oc.getCurrenPrice(), oc.getQuantity(),
                    oc.getOrigin(), oc.getUses()});
            }

        }

    }

//    public void capNhat() throws Exception {
//        if (checkAllCapNhat()) {
//            int lchon = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn cập nhật", "CẬP NHẬT", JOptionPane.YES_NO_OPTION);
//            if (lchon == JOptionPane.YES_OPTION) {
//                Integer id = Integer.parseInt(txtId.getText());
//                Integer maDM = Integer.parseInt(txtMaDM.getText());
//                String ten = txtTen.getText();
//                BigDecimal gia = new BigDecimal(txtGia.getText());
//                Integer sL = Integer.parseInt(txtSoLuong.getText());
//                String xXu = txtXXu.getText();
//                String TDung = txtTDung.getText();
//                OcVit ocvit = new OcVit(id, maDM, ten, gia, sL, xXu, TDung);
//
//                int kqua = ocvitService.CapNhatOc(ocvit);
//                if (kqua > -1) {
//                    JOptionPane.showMessageDialog(this, "Cập nhật thành công");
//                    Clear();
//                    fillToTable();
//                } else {
//                    JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
//                }
//            } else {
//                return;
//            }
//        }
//
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnXem = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        btnQuayLai = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        btnBaoCao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Mã danh mục", "Tên sản phẩm", "Giá hiện tại", "Số lượng", "Xuất xứ", "Tác dụng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTable);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("QUẢN LÝ SẢN PHẨM");

        btnXem.setText("Xem ");
        btnXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnQuayLai.setText("Quay lại");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnBaoCao.setText("Báo cáo");
        btnBaoCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaoCaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(199, 199, 199)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnQuayLai))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(552, 552, 552)
                            .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(67, 67, 67)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnBaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnXem, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnQuayLai)
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnCapNhat)
                    .addComponent(btnXoa)
                    .addComponent(btnTimKiem))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBaoCao)
                    .addComponent(btnXem))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnThoat)
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTableMouseClicked
        try {
            index = tblTable.getSelectedRow();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "LỖI");
        }
    }//GEN-LAST:event_tblTableMouseClicked

    private void btnXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemActionPerformed
        fillToTable();
    }//GEN-LAST:event_btnXemActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        ThemProductFrm them = new ThemProductFrm();
        them.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            Xoa();
        } catch (Exception ex) {
            Logger.getLogger(QuanLyOcvitFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        new CapNhatFrm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        try {
            TimKiem();
        } catch (Exception ex) {
            Logger.getLogger(QuanLyOcvitFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        new DangNhapFrm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        int chon = JOptionPane.showConfirmDialog(this, "Bạn muốn thoát?", "THOÁT", JOptionPane.YES_NO_OPTION);
        if (chon == JOptionPane.YES_OPTION) {
            this.dispose();
        } else {
            return;
        }
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnBaoCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaoCaoActionPerformed
        new BaoCaoFrm().setVisible(true);
    }//GEN-LAST:event_btnBaoCaoActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyOcvitFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyOcvitFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyOcvitFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyOcvitFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyOcvitFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaoCao;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTable;
    // End of variables declaration//GEN-END:variables
}
