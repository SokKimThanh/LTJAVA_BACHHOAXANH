/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ABC
 */
public class DanhSachAccount {

    private ArrayList<Account> data = new ArrayList<>();
    Connection conn = null;
    String tenTable = "account";
    String tenDatabase = "bachhoaxanh";

    public DanhSachAccount() {
        getConnection();
    }

    public ArrayList<Account> getData() {
        return data;
    }

    public void setData(ArrayList<Account> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DanhSachAccount{" + "data=" + data + '}';
    }

    public String Show() {
        String msg = "";
        for (Account user : data) {
            msg += user.toString() + "\n";
        }
        return msg;
    }

    public void add(Account item) {
        data.add(item);
    }

    //Lấy liên kết đến sql (phpAdmin)
    private void getConnection() {
        String url = "jdbc:mysql://localhost:3306/" + tenDatabase;
        String user = "root";
        String password = "vertrigo";
        try {
            conn = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Ket noi thanh cong");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //CRUD
    public int ThemDL(Account value) {

        String sql = "INSERT INTO " + tenTable + "(email, password) VALUES(?, ?)";
        int status = 0;

        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, value.getUser().getEmail());
            stmt.setString(2, value.getPassword());

            status = stmt.executeUpdate();
            if (status > 0) {
                System.out.println("Them thanh cong " + status + " mau tin");
            } else {
                System.out.println("Them khong thanh cong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhSachAccount.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public int XoaDL(Account value) {
        String sql = "Delete from " + tenTable + " where accountId = ?";
        int status = 0;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, value.getAccountId());

            status = stmt.executeUpdate();
            if (status > 0) {
                System.out.println("Xoa thanh cong " + status + " mau tin");
            } else {
                System.out.println("Xoa khong thanh cong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhSachAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public int SuaDL(User value) {
        String sql = "update " + tenTable + " set hoUser = ?, tenUser = ?, gioiTinh=?, email=? where userId = ?";
        int status = 0;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(5, value.getUserId());
            stmt.setString(1, value.getHoUser());
            stmt.setString(2, value.getTenUser());
            stmt.setString(3, value.getGioiTinh());
            stmt.setString(4, value.getEmail());

            status = stmt.executeUpdate();
            if (status > 0) {
                System.out.println("Sua thanh cong " + status + " mau tin");
            } else {
                System.out.println("Sua khong thanh cong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhSachAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public void DocDL() throws PasswordException {
        data.clear();
        String sqlAccountUser = "select user.email as username, password from " + tenTable + ", user where user.email = account.email";// account

        try {
            PreparedStatement stmt = conn.prepareStatement(sqlAccountUser);
            ResultSet result = stmt.executeQuery();
            // di chuyển con trỏ của resultSet đến hàng mong muốn bằng các phương thức như next()
            while (result.next()) {
                Account value = new Account();
                User user = new User(/**/result.getString("user"));
                value.setUser(user);
                value.setPassword(result.getString("password"));
                data.add(value);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhSachAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
