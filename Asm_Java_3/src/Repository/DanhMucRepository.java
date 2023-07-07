/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Helper1.DbConnector;
import Model.Account;
import Model.DanhMuc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ttuan
 */
public class DanhMucRepository {
    List<DanhMuc> danhSachDanhMuc= new ArrayList<DanhMuc>();
    public List<DanhMuc> findAll() throws Exception{
        Connection connection = DbConnector.getConnection();
        String query = "SELECT CategoryId,CategoryName from Category ";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {

            Integer id = rs.getInt("CategoryId");
            String name = rs.getString("CategoryName");
            
            DanhMuc dm= new DanhMuc();

            dm.setCategoryId(id);
            dm.setCategoryName(name);
            danhSachDanhMuc.add(dm);

        }
        rs.close();
        statement.close();
        connection.close();
        return danhSachDanhMuc;
    }
}
