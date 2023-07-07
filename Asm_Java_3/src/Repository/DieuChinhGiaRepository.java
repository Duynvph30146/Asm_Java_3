/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Helper1.DbConnector;
import Model.DieuChinhGia;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ttuan
 */
public class DieuChinhGiaRepository {
    List<DieuChinhGia> danhSach= new ArrayList<>();
    public List<DieuChinhGia> findByDanhMuc(Integer Id) throws Exception{
        danhSach.removeAll(danhSach);
        Connection con= DbConnector.getConnection();
        String query="select ProductId,CategoryId,ProductName,CurrenPrice from Product where CategoryId=? ";
        PreparedStatement ps= con.prepareStatement(query);
        ps.setInt(1, Id);
        ResultSet rs= ps.executeQuery();
        while(rs.next()){
            int productId= rs.getInt("ProductId");
            int categoryId= rs.getInt("CategoryId");
            String productName= rs.getString("ProductName");
            BigDecimal price= rs.getBigDecimal("CurrenPrice");
            
            DieuChinhGia dcg= new DieuChinhGia();
            
            dcg.setProductId(productId);
            dcg.setCategoryId(categoryId);
            dcg.setProductName(productName);
            dcg.setCurrenPrice(price);
            
            danhSach.add(dcg);
        }
        rs.close();
        ps.close();
        con.close();
        return danhSach;
    }
    public Integer DieuChinhGia(BigDecimal gia,Integer Id) throws Exception{
        Integer kqua=-1;
        Connection con= DbConnector.getConnection();
        String query="update Product set CurrenPrice = ? where ProductId = ?";
        PreparedStatement ps= con.prepareStatement(query);
        ps.setBigDecimal(1, gia);
        ps.setInt(2, Id);
        kqua=ps.executeUpdate();
        return kqua;
    }
    public boolean check(String a){
        if(a.equals("")){
            JOptionPane.showMessageDialog(null,"Giá sản phẩm không được để rỗng", "LỖI", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        try {
            new BigDecimal(a);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Giá sản phẩm phải là số", "LỖI", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        BigDecimal gia= new BigDecimal(a);
        BigDecimal khong= new BigDecimal(0);
        int kq=gia.compareTo(khong);
        if(kq == -1){
            JOptionPane.showMessageDialog(null,"Giá sản phẩm phải lớn hơn hoặc bằng 0", "LỖI", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
   
            
}
