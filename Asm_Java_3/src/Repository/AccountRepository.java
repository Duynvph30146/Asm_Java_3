/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Helper1.DbConnector;
import Model.Account;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ttuan
 */
public class AccountRepository {

    List<Account> danhSach = new ArrayList<Account>();

    public List<Account> findAll() throws Exception {
        Connection connection = DbConnector.getConnection();
        String query = "SELECT Username,Passwords,Roles from Account ";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {

            String username = rs.getString("Username");
            String password = rs.getString("Passwords");
            String role = rs.getString("Roles");

            Account acc = new Account();

            acc.setUsername(username);
            acc.setPassword(password);
            acc.setRole(role);
            danhSach.add(acc);

        }
        rs.close();
        statement.close();
        connection.close();
        return danhSach;
    }

    public Account findAccount(String username, String password) throws Exception {

        return findAll().stream()
                .filter(account
                        -> (account.getUsername().equals(username))
                && account.getPassword().equals(password))
                .findFirst()
                .orElse(null);

    }

    public boolean checkNullMK(JPasswordField a) {
        if (a.getText().equals("")) {
            a.requestFocus();
            return true;

        } else {
            return false;
        }
    }

    public boolean checkNullName(JTextField a) {
        if (a.getText().equals("")) {
            a.requestFocus();
            return true;

        } else {
            return false;
        }
    }

}
