/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Helper1.DbConnector;
import Model.Top10Product;
import java.math.BigDecimal;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ttuan
 */
public class Top10ProductRepository {

    public List<Top10Product> findAll() throws Exception {
        List<Top10Product> danhSachTop10=new ArrayList<>();
        Connection con = DbConnector.getConnection();
        String query = "select top (10) InventoryLog.ProductId AS 'ProductId',ProductName,SUM(InventoryLog.Quantity) AS 'Quantity',SUM(Price) AS 'Price'\n"
                + "from InventoryLog join Product on InventoryLog.ProductId=Product.ProductId\n"
                + "WHERE IoE=0\n"
                + "GROUP BY InventoryLog.ProductId,ProductName\n"
                + "ORDER BY SUM(InventoryLog.Quantity) ASC";
        Statement sta=con.createStatement();
        ResultSet rs=sta.executeQuery(query);
        while(rs.next()){
            Integer id=rs.getInt("ProductId");
            String name=rs.getString("ProductName");
            Integer Sl= rs.getInt("Quantity");
            BigDecimal gia=rs.getBigDecimal("Price");
            Top10Product top10= new Top10Product();
            top10.setProductId(id);
            top10.setProductName(name);
            top10.setQuantity(Sl);
            top10.setPrice(gia);
            danhSachTop10.add(top10);
        }
        return danhSachTop10;
    }
}
