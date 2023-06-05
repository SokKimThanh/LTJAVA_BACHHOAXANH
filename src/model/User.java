/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ABC
 */
public class User {

    //fields
    private String userId;
    private String tenUser, hoUser;
    private String gioiTinh;
    private String email;

    User() {

    }

    public User(String userId, String hoUser, String tenUser, String gioiTinh, String email) {
        this.userId = userId;
        this.tenUser = tenUser;
        this.hoUser = hoUser;
        this.gioiTinh = gioiTinh;
        this.email = email;
    }

    //constructors
    // delete
    public User(String userId) {
        this.userId = userId;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTenUser() {
        return tenUser;
    }

    public void setTenUser(String tenUser) {
        this.tenUser = tenUser;
    }

    public String getHoUser() {
        return hoUser;
    }

    public void setHoUser(String hoUser) {
        this.hoUser = hoUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", tenUser=" + tenUser + ", hoUser=" + hoUser + ", gioiTinh=" + gioiTinh + ", email=" + email + '}';
    }

}
