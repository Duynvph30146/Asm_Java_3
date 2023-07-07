/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Helper1.DbConnector;
import Model.NhatKyNhapXuat;
import Model.XuatNhap;
import java.math.BigDecimal;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ttuan
 */
public class XuatNhapRepository {

    List<XuatNhap> danhSach = new ArrayList<>();

    public List<XuatNhap> findByDanhMuc(Integer id) throws Exception {
        danhSach.removeAll(danhSach);
        Connection connection = DbConnector.getConnection();
        String query = "select CategoryId,ProductId,ProductName,Quantity,CurrenPrice from Product where CategoryId=? ";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Integer categoryId = rs.getInt("CategoryId");
            Integer productId = rs.getInt("ProductId");
            String productname = rs.getString("ProductName");
            Integer quantity = rs.getInt("Quantity");
            BigDecimal currenPrice = rs.getBigDecimal("CurrenPrice");

            XuatNhap xn = new XuatNhap();
            xn.setCategoryId(categoryId);
            xn.setProductId(productId);
            xn.setProductName(productname);
            xn.setQuantity(quantity);
            xn.setCurrenPrice(currenPrice);

            danhSach.add(xn);
        }
        rs.close();
        ps.close();
        connection.close();
        return danhSach;
    }

    public Integer Nhap(double Sluong, Integer id) throws Exception {
        Integer kqua = -1;
        Connection con = DbConnector.getConnection();
        String query = "update Product set Quantity=(Quantity+?)where ProductId=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setDouble(1, Sluong);
        ps.setInt(2, id);
        kqua = ps.executeUpdate();
        ps.close();
        con.close();
        return kqua;
    }

    public Integer Xuat(double Sluong, Integer id) throws Exception {
        Integer kqua = -1;
        Connection con = DbConnector.getConnection();
        String query = "update Product set Quantity=(Quantity-?)where ProductId=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setDouble(1, Sluong);
        ps.setInt(2, id);
        kqua = ps.executeUpdate();
        ps.close();
        con.close();
        return kqua;
    }
    
    public Integer NhatKyNhap(NhatKyNhapXuat nk) throws Exception{
        Integer kqua=-1;
        Connection con=DbConnector.getConnection();
        String query="Insert into InventoryLog(ProductId,IoE,Quantity,Price) values(?,?,?,?)";
        PreparedStatement ps= con.prepareStatement(query);
        ps.setInt(1, nk.getProductId());
        ps.setInt(2, nk.getIoE());
        ps.setDouble(3, nk.getQuantity());
        ps.setBigDecimal(4, nk.getPrice());
        kqua=ps.executeUpdate();
        
        return kqua;
    }
    
    public Integer NhatKyXuat(NhatKyNhapXuat nk) throws Exception{
        Integer kqua=-1;
        Connection con=DbConnector.getConnection();
        String query="Insert into InventoryLog(ProductId,IoE,Quantity,Price) values(?,?,?,?)";
        PreparedStatement ps= con.prepareStatement(query);
        ps.setInt(1, nk.getProductId());
        ps.setInt(2, nk.getIoE());
        ps.setDouble(3, nk.getQuantity());
        ps.setBigDecimal(4, nk.getPrice());
        kqua=ps.executeUpdate();
        
        return kqua;
    }

    public boolean checkNullName(String a) {
        if (a.equals("")) {
            JOptionPane.showMessageDialog(null, "Số lượng sản phẩm không được trống", "LỖI", JOptionPane.WARNING_MESSAGE);
            return false;

        }
        return true;

    }
    public boolean checkSo(String a) {
        try {
            Double.parseDouble(a);
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Số lượng sản phẩm phải là số nguyên", "LỖI", JOptionPane.WARNING_MESSAGE);
            return false;
        }

    }
    public boolean checkSoTN(String a) {

        if (Math.ceil(Double.parseDouble(a)) != Math.floor(Double.parseDouble(a))) {
            JOptionPane.showMessageDialog(null, "Số lượng sản phẩm phải là số nguyên", "LỖI", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;
        }

    }
    public boolean checkSL(String a) {
        if (Double.parseDouble(a) <= 0) {
            JOptionPane.showMessageDialog(null, "Số lượng sản phẩm phải lớn hơn 0", "LỖI", JOptionPane.WARNING_MESSAGE);
            return false;
        }else{
            return true;
        }  
    }
    public boolean checkQuaSL(String a, Integer SL){
        if(Double.parseDouble(a)> SL){
            JOptionPane.showMessageDialog(null, "Số lượng sản phẩm không đủ ", "LỖI", JOptionPane.WARNING_MESSAGE);
            return false;
        }else{
            return true;
        }
    }

}
