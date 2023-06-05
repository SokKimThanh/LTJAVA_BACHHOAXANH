/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    //Fields
    private ArrayList<SanPham> data = new ArrayList<>();
    Connection conn = null;
    String tenTable = "tbsanpham";
    String tenDatabase = "bachhoaxanh";

    //Contructor
    public DSSanPham() {
        getConnection();
    }

    //Getter & Setter
    public ArrayList<SanPham> getData() {
        return data;
    }

    public void setData(ArrayList<SanPham> data) {
        this.data = data;
    }

    //Methods
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
        String password = "";
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Ket noi thanh cong");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //CRUD
    public int ThemDL(SanPham value) {

        String sql = "INSERT INTO " + tenTable + " VALUES(?, ?, ?, ?, ?)";
        int status = 0;

        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, value.getMaSP());
            stmt.setString(2, value.getTenSP());
            stmt.setInt(3, value.getLoaiSP());
            stmt.setDouble(4, value.getGiaSP());
            stmt.setString(5, value.getTenSP());
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

    //Đọc cơ sở dữ liệu
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
                value.setTonKho(result.getInt("tonKho"));
                data.add(value);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Tìm kiếm
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
                sql = "SELECT * from " + tenTable + " WHERE " + tenTable + ".loaiSP=" + cboLoaiSP;
                break;
            case 2:
                sql = "SELECT * from " + tenTable + " WHERE " + tenTable + ".tenSP LIKE N'" + keySearch + "%'";
                break;
            case 3:
                sql = "select * from " + tenTable + " WHERE " + tenTable + ".giaSP < " + Double.valueOf(keySearch);
                break;
            default:
                sql = "select * from " + tenTable;
                break;
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

    // ======================================= Methods: Tab Mua Hàng ======================================= 
    //Tìm kiếm theo mã sản  phẩm
    public void TimKiem_MaSP(String MaSP) {
        data.clear();
        // khai bao
        String sql = "select * from " + tenTable + " where maSP like '%" + MaSP + "%'";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                SanPham value = new SanPham();
                value.setMaSP(result.getString("maSP"));
                value.setTenSP(result.getString("tenSP"));
                value.setLoaiSP(result.getInt("loaiSP"));
                value.setGiaSP(result.getDouble("giaSP"));
                value.setTonKho(result.getInt("tonKho"));
                data.add(value);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Tìm kiếm theo tên sản  phẩm
    public void TimKiem_TenSP(String TenSP) {
        data.clear();
        // khai bao
        String sql = "select * from " + tenTable + " where tenSP like '%" + TenSP + "%'";
        System.out.println(sql);
        try {

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                SanPham value = new SanPham();
                value.setMaSP(result.getString("maSP"));
                value.setTenSP(result.getString("tenSP"));
                value.setLoaiSP(result.getInt("loaiSP"));
                value.setGiaSP(result.getDouble("giaSP"));
                value.setTonKho(result.getInt("tonKho"));
                data.add(value);
            }
            System.out.println("Doc du lieu xong!");
        } catch (SQLException ex) {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Tìm kiếm theo loại sản  phẩm
    public void TimKiem_LoaiSP(int LoaiSP) {
        data.clear();
        // khai bao
        String sql = "select * from " + tenTable + " where loaiSP = ?";
        try {

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, LoaiSP);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                SanPham value = new SanPham();
                value.setMaSP(result.getString("maSP"));
                value.setTenSP(result.getString("tenSP"));
                value.setLoaiSP(result.getInt("loaiSP"));
                value.setGiaSP(result.getDouble("giaSP"));
                value.setTonKho(result.getInt("tonKho"));
                data.add(value);
            }
            System.out.println("Doc du lieu xong!");
        } catch (SQLException ex) {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Tìm kiếm theo giá bán của sản  phẩm
    public void TimKiem_GiaSP(double GiaBan) {
        data.clear();
        // khai bao
        String sql = "select * from " + tenTable + " where giaSP <= ?";
        try {

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, GiaBan);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                SanPham value = new SanPham();
                value.setMaSP(result.getString("maSP"));
                value.setTenSP(result.getString("tenSP"));
                value.setLoaiSP(result.getInt("loaiSP"));
                value.setGiaSP(result.getDouble("giaSP"));
                value.setTonKho(result.getInt("tonKho"));
                data.add(value);
            }
            System.out.println("Doc du lieu xong!");
        } catch (SQLException ex) {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Tìm kiếm theo số lượng tồn kho
    public void TimKiem_TonKho(int TonKho) {
        data.clear();
        // khai bao
        String sql = "select * from " + tenTable + " where tonKho <= ?";
        try {

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, TonKho);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                SanPham value = new SanPham();
                value.setMaSP(result.getString("maSP"));
                value.setTenSP(result.getString("tenSP"));
                value.setLoaiSP(result.getInt("loaiSP"));
                value.setGiaSP(result.getDouble("giaSP"));
                value.setTonKho(result.getInt("tonKho"));
                data.add(value);
            }
            System.out.println("Doc du lieu xong!");
        } catch (SQLException ex) {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Ghi dữ liệu ở danh sách sản phẩm hiện hành lên file theo đường dẫn filePath
    public void GhiFile(String filePath) {

        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(data);
            System.out.println("Ghi Thanh cong");
        } catch (FileNotFoundException ex) {
            System.out.println("Khong tim thay file");
        } catch (IOException ex) {
            System.out.println("Khong tim thay file");
        }
    }

    public void DocFile(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream oos = new ObjectInputStream(fis);
            data = (ArrayList<SanPham>) oos.readObject();
            System.out.println("Doc Thanh cong");
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException: Khong tim thay file" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IOException: Khong doc duoc file");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void XuatDS() {
        for (SanPham sanPham : data) {
            System.out.println(sanPham.ToString());
        }
    }
}
//end of class
