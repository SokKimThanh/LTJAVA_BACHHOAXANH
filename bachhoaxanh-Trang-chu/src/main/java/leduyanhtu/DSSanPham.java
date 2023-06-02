/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leduyanhtu;

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
 * @author Imac
 */
public class DSSanPham {

    //Fields
    private ArrayList<SanPham> data = new ArrayList<>();
    private Connection conn;

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

    public boolean getConnection() {
        String url = "jdbc:sqlserver://localhost:3306/DBSanPham";
        String user = "root";
        String pass = "vertrigo";
        boolean flg = false;
        try {
            conn = DriverManager.getConnection(url, user, pass);
            if (conn != null) {
                flg = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flg;
    }

    //Thêm dữ liệu sản phẩm vào database
    public void ThemDL(SanPham value) {
        String sql = "insert into tbSanPham values (?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, value.getMaSP());
            stmt.setString(2, value.getTenSP());
            stmt.setInt(2, value.getLoai());
            stmt.setDouble(2, value.getGiaBan());
            stmt.setInt(2, value.getSoLuong());

            int status = stmt.executeUpdate();
            if (status > 0) {
                System.out.println("Thêm thành công " + status + " dữ liệu");
            } else {
                System.out.println("Thêm không thành công");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Tìm kiếm sản phẩm dựa vào Mã sản phẩm
    public ResultSet TimDLByMaSP(String MaSP) {
        String sql = "select * from tbSanPham where maSP = ?";
        ResultSet re = null;
        try {
            PreparedStatement stmt = conn.prepareCall(sql);
            stmt.setString(1, MaSP);
            re = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return re;
    }

    //Tìm kiếm sản phẩm dựa vào Tên sản phẩm
    public ResultSet TimDLByTenSP(String TenSP) {
        String sql = "select * from tbSanPham where tenSP = ?";
        ResultSet re = null;
        try {
            PreparedStatement stmt = conn.prepareCall(sql);
            stmt.setString(1, TenSP);
            re = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return re;
    }

    //Tìm kiếm sản phẩm dựa vào Loại của sản phẩm
    public ResultSet TimDLByLoai(int Loai) {
        String sql = "select * from tbSanPham where loai = ?";
        ResultSet re = null;
        try {
            PreparedStatement stmt = conn.prepareCall(sql);
            stmt.setInt(1, Loai);
            re = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return re;
    }

    //Tìm kiếm sản phẩm dựa vào Giá bán
    public ResultSet TimDLByGiaBan(double GiaBan) {
        String sql = "select * from tbSanPham where giaban = ?";
        ResultSet re = null;
        try {
            PreparedStatement stmt = conn.prepareCall(sql);
            stmt.setDouble(1, GiaBan);
            re = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return re;
    }

    //Tìm kiếm sản phẩm dựa vào Số lượng sản phẩm
    public ResultSet TimDLBySoLuong(int SoLuong) {
        String sql = "select * from tbSanPham where soLuong = ?";
        ResultSet re = null;
        try {
            PreparedStatement stmt = conn.prepareCall(sql);
            stmt.setDouble(1, SoLuong);
            re = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return re;
    }
}
