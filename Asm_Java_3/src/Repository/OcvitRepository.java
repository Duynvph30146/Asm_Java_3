/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Helper1.DbConnector;
import Model.DanhMuc;
import Model.OcVit;
import Model.OcvitTable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ttuan
 */
public class OcvitRepository {

    public List<OcVit> getAll() throws Exception {
        List<OcVit> danhSach = new ArrayList<>();
        Connection connection = DbConnector.getConnection();
        String query = "SELECT ProductId,CategoryId,ProductName,CurrenPrice,Quantity,Origin,Uses from Product";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Integer id = rs.getInt("ProductId");
            Integer CategoryId = rs.getInt("CategoryId");
            String ProductName = rs.getString("ProductName");
            BigDecimal CurrenPrice = rs.getBigDecimal("CurrenPrice");
            double Quantity = rs.getDouble("Quantity");
            String origin = rs.getString("Origin");
            String uses = rs.getString("Uses");

            OcVit oc = new OcVit();

            oc.setId(id);
            oc.setCategoryId(CategoryId);
            oc.setProductName(ProductName);
            oc.setCurrenPrice(CurrenPrice);
            oc.setQuantity(Math.round(Quantity));
            oc.setOrigin(origin);
            oc.setUses(uses);
            danhSach.add(oc);

        }
        rs.close();
        statement.close();
        connection.close();
        return danhSach;
    }

    public Integer Them(OcVit ocvit) throws Exception {
        Integer kqua = -1;
        Connection connection = DbConnector.getConnection();
        String query = "insert into Product values (?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, ocvit.getCategoryId());
        ps.setString(2, ocvit.getProductName());
        ps.setBigDecimal(3, ocvit.getCurrenPrice());
        ps.setDouble(4, ocvit.getQuantity());
        ps.setString(5, ocvit.getOrigin());
        ps.setString(6, ocvit.getUses());

        kqua = ps.executeUpdate();

        ps.close();
        connection.close();

        return kqua;

    }

    public boolean checkNull(JTextField a) {
        if (a.getText().equals("")) {
            a.requestFocus();
            return false;
        }
        return true;

    }

    public boolean checkMaDM(JTextField a) {
        try {
            Connection connection = DbConnector.getConnection();
            String query = "SELECT CategoryId from Category where CategoryId like ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, a.getText());
            return ps.executeQuery().next();
        } catch (Exception ex) {
        }
        return false;

    }

    public boolean checkGia(JTextField a) {
        try {
            new BigDecimal(a.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Giá sản phẩm phải là số", "LỖI", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        BigDecimal gia = new BigDecimal(a.getText());
        BigDecimal khong = new BigDecimal(0);
        int kq = gia.compareTo(khong);
        if (kq == -1) {
            JOptionPane.showMessageDialog(null, "Giá sản phẩm phải lớn hơn hoặc bằng 0", "LỖI", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean checkSL(JTextField a) {
        try {
            Double.parseDouble(a.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Số lượng sản phẩm phải là số nguyên", "LỖI", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (Math.ceil(Double.parseDouble(a.getText())) != Math.floor(Double.parseDouble(a.getText()))) {
            JOptionPane.showMessageDialog(null, "Số lượng sản phẩm phải là số nguyên", "LỖI", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (Double.parseDouble(a.getText()) < 0) {
            JOptionPane.showMessageDialog(null, "Số lượng sản phẩm phải lớn hơn hoặc bằng 0", "LỖI", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    public Integer Xoa(Integer id) throws Exception {
        Integer kqua = -1;
        Connection connection = DbConnector.getConnection();
        String query1 = "DELETE InventoryLog where ProductId=?";
        String query = "DELETE Product where ProductId=?";
        PreparedStatement ps1 = connection.prepareStatement(query1);
        PreparedStatement ps = connection.prepareStatement(query);
        ps1.setInt(1, id);
        ps.setInt(1, id);
        kqua = ps1.executeUpdate();
        kqua = ps.executeUpdate();
        ps1.close();
        ps.close();
        connection.close();
        return kqua;
    }

    public List<OcVit> TimKiem(String a) throws Exception {
        List<OcVit> dsocvit = new ArrayList<>();
        Connection connection = DbConnector.getConnection();
        String query = "SELECT ProductId,CategoryId,ProductName,CurrenPrice,Quantity,Origin,Uses from Product where CategoryId like ? or ProductName like ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, a);
        ps.setString(2, a);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Integer ID = rs.getInt("ProductId");
            Integer CategoryId = rs.getInt("CategoryId");
            String ProductName = rs.getString("ProductName");
            BigDecimal CurrenPrice = rs.getBigDecimal("CurrenPrice");
            double Quantity = rs.getDouble("Quantity");
            String origin = rs.getString("Origin");
            String uses = rs.getString("Uses");

            OcVit ocvit = new OcVit();

            ocvit.setId(ID);
            ocvit.setCategoryId(CategoryId);
            ocvit.setProductName(ProductName);
            ocvit.setCurrenPrice(CurrenPrice);
            ocvit.setQuantity(Quantity);
            ocvit.setOrigin(origin);
            ocvit.setUses(uses);
            dsocvit.add(ocvit);

        }
        rs.close();
        ps.close();
        connection.close();
       
        return dsocvit;

    }

    public Integer CapNhat(OcVit ocvit) throws Exception {
        Integer kqua = -1;
        Connection connection = DbConnector.getConnection();
        String query = "Update Product set CategoryId=?,ProductName=?,Origin=?,Uses=? where ProductId=?";
        PreparedStatement ps = connection.prepareStatement(query);

        
        ps.setInt(1, ocvit.getCategoryId());
        ps.setString(2, ocvit.getProductName());
        ps.setString(3, ocvit.getOrigin());
        ps.setString(4, ocvit.getUses());
        ps.setInt(5, ocvit.getId());
        kqua = ps.executeUpdate();
        ps.close();
        connection.close();
        return kqua;
    }

    public boolean checkIdCapNhat(JTextField a,Integer b) {
        if(a.getText().equalsIgnoreCase(a.getText())){
        JOptionPane.showMessageDialog(null, "Mã ko dc sua");
        return false;
    }
        return true;

    }

    

    public boolean checkGiaCapNhat(JTextField a, Integer b) {
        try {
            Connection connection = DbConnector.getConnection();
            String query = "SELECT CurrenPrice from Product where ProductId like ? and CurrenPrice like ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, b);
            ps.setString(2, a.getText());
            return ps.executeQuery().next();
        } catch (Exception ex) {
        }
        return false;
    }

    public boolean checkSLCapNhap(JTextField a, Integer b) {
        try {
            Connection connection = DbConnector.getConnection();
            String query = "SELECT Quantity from Product where ProductId like ? and Quantity like ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, b);
            ps.setString(2, a.getText());
            return ps.executeQuery().next();
        } catch (Exception ex) {
        }
        return false;
    }
}
