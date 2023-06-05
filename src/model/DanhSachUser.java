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
public class DanhSachUser {

    private ArrayList<User> data = new ArrayList<>();
    Connection conn = null;
    String tenTable = "user";
    String tenDatabase = "bachhoaxanh";

    public DanhSachUser() {
        getConnection();
    }

    public ArrayList<User> getData() {
        return data;
    }

    public void setData(ArrayList<User> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DanhSachUser{" + "data=" + data + '}';
    }

    public String Show() {
        String msg = "";
        for (User user : data) {
            msg += user.toString() + "\n";
        }
        return msg;
    }

    public void add(User item) {
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
    public int ThemDL(User value) {

        String sql = "INSERT INTO " + tenTable + "(tenUser, hoUser, gioiTinh, email) VALUES(?, ?, ?, ?)";
        int status = 0;

        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, value.getTenUser());
            stmt.setString(2, value.getHoUser());
            stmt.setString(3, value.getGioiTinh());
            stmt.setString(3, value.getEmail());
            status = stmt.executeUpdate();
            if (status > 0) {
                System.out.println("Them thanh cong " + status + " mau tin");
            } else {
                System.out.println("Them khong thanh cong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhSachUser.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public int XoaDL(User value) {
        String sql = "Delete from " + tenTable + " where userId = ?";
        int status = 0;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, value.getUserId());

            status = stmt.executeUpdate();
            if (status > 0) {
                System.out.println("Xoa thanh cong " + status + " mau tin");
            } else {
                System.out.println("Xoa khong thanh cong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhSachUser.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DanhSachUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public void DocDL() {
        data.clear();
        String sql = "select * from " + tenTable;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                User value = new User();
                value.setHoUser(result.getString("hoUser"));
                value.setTenUser(result.getString("tenUser"));
                value.setGioiTinh(result.getString("gioiTinh"));
                value.setEmail(result.getString("email"));
                data.add(value);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhSachUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void TimKiem(int tieuChiTimKiem, String keySearch, int cboLoaiSP) {
        data.clear();
        if (keySearch == null || "".equals(keySearch)) {
            System.out.println("Chua nhap tu khoa tim kiem");
            return;
        }
        // khai bao
        String sql;

        switch (tieuChiTimKiem) {
            case 1:
                sql = "SELECT * from " + tenTable + " WHERE " + tenTable + ".hoUser LIKE N'" + keySearch + "%'";
                break;
            case 2:

                sql = "SELECT * from " + tenTable + " WHERE " + tenTable + ".tenUser LIKE N'" + keySearch + "%'";
                break;
            case 3:

                sql = "SELECT * from " + tenTable + " WHERE " + tenTable + ".gioiTinh LIKE N'" + keySearch + "%'";
                break;
            default:
                sql = "SELECT * from " + tenTable + " WHERE " + tenTable + ".email LIKE N'" + keySearch + "%'";
                break;
        }

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                User value = new User();
                value.setHoUser(result.getString("hoUser"));
                value.setTenUser(result.getString("tenUser"));
                value.setGioiTinh(result.getString("gioiTinh"));
                value.setEmail(result.getString("email"));
                data.add(value);
            }
            System.out.println("Doc du lieu xong!");
        } catch (SQLException ex) {
            Logger.getLogger(DanhSachUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
