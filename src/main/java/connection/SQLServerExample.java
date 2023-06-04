/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

/**
 *
 * @author Thanh
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerExample {

    public static void main(String[] args) {
        // Thay đổi thông tin kết nối của bạn

        String username = "22211tt0063";
        String password = "22211tt0063";
        
        String url = String.format("jdbc:sqlserver://DESKTOP-FJE0RF8;databaseName=QLBHX;encrypt=true;trustServerCertificate=true;user=%s;password=%s", username, password);

        try {
            // Tải trình điều khiển JDBC
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Kết nối đến cơ sở dữ liệu
            Connection connection = DriverManager.getConnection(url);

            // Sử dụng kết nối ở đây
            // Đóng kết nối
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy trình điều khiển JDBC");
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("Ket noi that bai");
            System.out.println(e.getMessage());
        }
    }
}
