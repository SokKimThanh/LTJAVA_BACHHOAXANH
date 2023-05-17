/**
 * Name : Lê Duy Anh Tú
 * Date : 16/05/2023
 * Danh sách SinhVien liên kết với sql.
 */
package sokkimthanh.admin.example;

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
 * @author Administrator
 */
public class DSSinhVien {
    //Fields
    private ArrayList<SinhVien> data = new ArrayList<>();
    Connection conn = null;
    
    //Contructor
    public DSSinhVien() {
        getConnection();
    }

    //Getter & Setter
    public ArrayList<SinhVien> getData() {
        return data;
    }
    public void setData(ArrayList<SinhVien> data) {
        this.data = data;
    }
    
    //Method
    public void ThemDS(SinhVien value){
        data.add(value);
    }
    public String HienThi(){
        String msg = "";
        for (SinhVien sinhVien : data) {
            msg += sinhVien.toString() + "\n";
        }
        return msg;
    }
    
    //Lấy liên kết đến sql (phpAdmin)
    public void getConnection(){
        String url = "jdbc:mysql://localhost:3306/DBSinhVien";
        String user = "root";
        String password = "vertrigo";
        try{
            conn = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Ket noi thanh cong");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    //CRUD
    public int ThemDL(SinhVien value){
        String sql = "insert into tbSinhVien values (?,?,?)";
        int status = 0;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, value.getMaSV());
            stmt.setString(2, value.getTenSV());
            stmt.setInt(3, value.getTuoi());
            
            status = stmt.executeUpdate();
            if(status > 0)
                System.out.println("Them thanh cong " + status + " mau tin");
            else
                System.out.println("Them khong thanh cong");
        } catch (SQLException ex) {
            Logger.getLogger(DSSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    public int XoaDL(SinhVien value){
        String sql = "Delete from tbSinhVien where masv = ?";
        int status = 0;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, value.getMaSV());
            
            status = stmt.executeUpdate();
            if(status > 0)
                System.out.println("Xoa thanh cong " + status + " mau tin");
            else
                System.out.println("Xoa khong thanh cong");
        } catch (SQLException ex) {
            Logger.getLogger(DSSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;   
    }
    public int SuaDL(SinhVien value){
        String sql = "update tbSinhVien set tensv = ?, tuoi = ? where masv = ?";
        int status = 0;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(3, value.getMaSV());
            stmt.setString(1, value.getTenSV());
            stmt.setInt(2, value.getTuoi());
            
            status = stmt.executeUpdate();
            if(status > 0)
                System.out.println("Sua thanh cong " + status + " mau tin");
            else
                System.out.println("Sua khong thanh cong");
        } catch (SQLException ex) {
            Logger.getLogger(DSSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    
    public void DocDL(){
        data.clear();
        String sql = "select * from tbSinhVien";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                SinhVien value = new SinhVien();
                value.setMaSV(result.getInt("masv"));
                value.setTenSV(result.getString("tensv"));
                value.setTuoi(result.getInt("tuoi"));
                data.add(value);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DSSinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
