/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thanh
 */
public class ThuNghiemKetNoiSQLServer {

    public static void main(String[] args) {
        try {
            MyConnection conn = new MyConnection();
            Connection sql = conn.ConnectSQLServer();

            try {
                Statement st = sql.createStatement();
                String Sql = "select * from nhanvien";
                ResultSet rs = st.executeQuery(Sql);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThuNghiemKetNoiSQLServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
