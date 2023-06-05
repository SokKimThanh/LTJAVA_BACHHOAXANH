/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ABC
 */
public class ThuNghiemDangKy {

    public static void main(String[] args) {
        try {
            User user001 = new User("user001", "Nguyen van", "A", "nam", "nguyenvana@tdc.edu.vn");
            User user002 = new User("user002", "Tran thi", "B", "nu", "tranthib@tdc.edu.vn");

            Account acc01 = new Account(user001, "Hello ban nho", "Hello ban nho");
            Account acc02 = new Account(user002, "123", "421");

            String rs1 = acc01.toString();
            String rs2 = acc02.toString();

            System.out.printf("%s\n%s", rs1, rs2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
