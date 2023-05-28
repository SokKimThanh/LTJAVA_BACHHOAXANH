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
 * @author Thanh 17/05/2023 Cai Dat Lop DSSanPham moving to model package Sok
 * Kim Thanh 28/05/2023
 */
public class DSSanPham {

    private ArrayList<SanPham> data = new ArrayList<>();
    Connection conn = null;
    String tenTable = "sanpham";
    String tenDatabase = "bachhoaxanh";

    public DSSanPham() {
        getConnection();
    }

    public ArrayList<SanPham> getData() {
        return data;
    }

    public void setData(ArrayList<SanPham> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DSSanPham{" + "data=" + data + '}';
    }

    public String Show() {
        String msg = "";
        for (SanPham sanpham : data) {
            msg += sanpham.toString() + "\n";
        }
        return msg;
    }

    public void add(SanPham item) {
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
    public int ThemDL(SanPham value) {

        String sql = "INSERT INTO " + tenTable + "(tenSP, loaiSP, giaSP) VALUES(?, ?, ?)";
        int status = 0;

        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, value.getTenSP());
            stmt.setInt(2, value.getLoaiSP());
            stmt.setDouble(3, value.getGiaSP());
            status = stmt.executeUpdate();
            if (status > 0) {
                System.out.println("Them thanh cong " + status + " mau tin");
            } else {
                System.out.println("Them khong thanh cong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public int XoaDL(SanPham value) {
        String sql = "Delete from " + tenTable + " where maSP = ?";
        int status = 0;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, value.getMaSP());

            status = stmt.executeUpdate();
            if (status > 0) {
                System.out.println("Xoa thanh cong " + status + " mau tin");
            } else {
                System.out.println("Xoa khong thanh cong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public int SuaDL(SanPham value) {
        String sql = "update " + tenTable + " set tenSP = ?, loaiSP = ?, giaSP=? where maSP = ?";
        int status = 0;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(4, value.getMaSP());
            stmt.setString(1, value.getTenSP());
            stmt.setInt(2, value.getLoaiSP());
            stmt.setDouble(3, value.getGiaSP());

            status = stmt.executeUpdate();
            if (status > 0) {
                System.out.println("Sua thanh cong " + status + " mau tin");
            } else {
                System.out.println("Sua khong thanh cong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
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
                SanPham value = new SanPham();
                value.setMaSP(result.getString("maSP"));
                value.setTenSP(result.getString("tenSP"));
                value.setLoaiSP(result.getInt("loaiSP"));
                value.setGiaSP(result.getDouble("giaSP"));
                data.add(value);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
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
            case 1 -> {
                sql = "SELECT * from " + tenTable + " WHERE " + tenTable + ".loaiSP=" + cboLoaiSP;

            }
            case 2 -> {

                sql = "SELECT * from " + tenTable + " WHERE " + tenTable + ".tenSP LIKE N'" + keySearch + "%'";

            }
            case 3 -> {

                sql = "select * from " + tenTable + " WHERE " + tenTable + ".giaSP < " + Double.valueOf(keySearch);
            }
            default ->
                sql = "select * from " + tenTable;
        }

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                SanPham value = new SanPham();
                value.setMaSP(result.getString("maSP"));
                value.setTenSP(result.getString("tenSP"));
                value.setLoaiSP(result.getInt("loaiSP"));
                value.setGiaSP(result.getDouble("giaSP"));
                data.add(value);
            }
            System.out.println("Doc du lieu xong!");
        } catch (SQLException ex) {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
//end of class
