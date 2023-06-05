/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQLSERVER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Thanh
 */
public class MyConnection {

    private final String myServerName = "DESKTOP-FJE0RF8";
    private final String myInstanceName = "SQLEXPRESS";
    private final String myDatabaseName = "QLBHX";
    private final String myUserName = "22211tt0063";
    private final String myPassword = "22211tt0063";
    private final String trustServerCertificate = "encrypt=true;trustServerCertificate=true";
    private Connection conn = null;

    /*serverName: name of the host or IP address of the device where SQL Server is currently running.
instanceName: instance name to connect the server.
portNumber: port number of server, the default value is 1433.
property=value: you can include one or more connection properties.*/
 /*jdbc:sqlserver://[serverName[\instanceName][:portNumber]][;property=value[;property=value]]*/
    public void ConnectSQLServer() {
        // Thay đổi thông tin kết nối của bạn

        String url = String.format("jdbc:sqlserver://DESKTOP-FJE0RF8;databaseName=QLBHX;encrypt=true;trustServerCertificate=true;");

        try {
            // Tải trình điều khiển JDBC
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Kết nối đến cơ sở dữ liệu
            conn = DriverManager.getConnection(url, myUserName, myPassword);

            System.out.println("Ket noi thanh cong");

            Statement st = conn.createStatement();
            String Sql = "select * from NHANVIEN";
            ResultSet rs = st.executeQuery(Sql);

            while (rs.next()) {

                System.out.println(rs.getString("MANV"));
            }
            // Đóng kết nối
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy trình điều khiển JDBC");
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("Ket noi that bai");
            System.out.println(e.getMessage());
        }
    }
}
