/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frmTimKiem;

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
    //Field
    private ArrayList<SanPham> data;
    private Connection conn;

    //Contructor
    public DSSanPham() {
        data = new ArrayList<>();
        getConnection();
    }

    //Getter & Setter
    public ArrayList<SanPham> getData() {
        return data;
    }
    public void setData(ArrayList<SanPham> data) {
        this.data = data;
    }
    
    //Kết nối với database trên VertrigoServ
    public void getConnection(){
        String url = "jdbc:mysql://localhost:3306/DBBHX";
        String user = "root";
        String pass = "vertrigo";
        try {
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Ket noi thanh cong");
        } catch (SQLException ex) {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //CRUD
    public void ThemDL(SanPham item){
        //Viết câu lệnh sql 
        String sql = "insert into tbSanPham values (?,?,?,?,?)";
        
        //Khai báo biến chứa số lượng mẫu tin bị ảnh hưởng
        int status =0;
        try {
            //Chuẩn bị câu lệnh sql
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            //Thêm các dữ liệu vào các cột tương ứng
            stmt.setString(1, item.getMaSP());
            stmt.setString(2,item.getTenSP());
            stmt.setInt(3, item.getLoaiSP());
            stmt.setInt(4, item.getGiaBan());
            stmt.setInt(5, item.getTonKho());
            
            //Thực thi câu lệnh sql
            status = stmt.executeUpdate();
            
            //Thông báo số mẫu in bị ảnh hưởng
            if(status > 0)
            {
                System.out.println("Thêm thành công " + status + " mẫu tin");
            }else{
                System.out.println("Thêm không thành công");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void XoaDL(SanPham item){
        //Viết câu lệnh sql 
        String sql = "delete from tbSanPham where masp = ?";
        
        //Khai báo biến chứa số lượng mẫu tin bị ảnh hưởng
        int status =0;
        try {
            //Chuẩn bị câu lệnh sql
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            //Thêm các dữ liệu vào các cột tương ứng
            stmt.setString(1, item.getMaSP());
            
            //Thực thi câu lệnh sql
            status = stmt.executeUpdate();
            
            //Thông báo số mẫu in bị ảnh hưởng
            if(status > 0)
            {
                System.out.println("Thêm thành công " + status + " mẫu tin");
            }else{
                System.out.println("Thêm không thành công");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void SuaDL(SanPham item){
        //Viết câu lệnh sql 
        String sql = "update tbSanPham set tensp = ?, loaisp = ?, giaban = ?, tonkho = ? where masp = ?";
        
        //Khai báo biến chứa số lượng mẫu tin bị ảnh hưởng
        int status =0;
        try {
            //Chuẩn bị câu lệnh sql
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            //Thêm các dữ liệu vào các cột tương ứng
            stmt.setString(5, item.getMaSP());
            stmt.setString(1,item.getTenSP());
            stmt.setInt(2, item.getLoaiSP());
            stmt.setInt(3, item.getGiaBan());
            stmt.setInt(4, item.getTonKho());
            
            //Thực thi câu lệnh sql
            status = stmt.executeUpdate();
            
            //Thông báo số mẫu in bị ảnh hưởng
            if(status > 0)
            {
                System.out.println("Thêm thành công " + status + " mẫu tin");
            }else{
                System.out.println("Thêm không thành công");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //Đọc dữ liệu từ sql xuống model hiện hành
    public void DocDL(){
        data.clear();
        String sql = "select * from tbSanPham";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet re = stmt.executeQuery();
            while(re.next())
            {
                SanPham newSP = new SanPham();
                newSP.setMaSP(re.getString("masp"));
                newSP.setTenSP(re.getString("tensp"));
                newSP.setLoaiSP(re.getInt("loaisp"));
                newSP.setGiaBan(re.getInt("giaban"));
                newSP.setTonKho(re.getInt("tonkho"));
                
                data.add(newSP);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
