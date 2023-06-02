/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class GioHangItem {

    private int soLuong;
    private SanPham sanpham;

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public SanPham getItem() {
        return sanpham;
    }

    public void setItem(SanPham item) {
        this.sanpham = item;
    }

    public GioHangItem(SanPham sanpham, int soLuong) {
        this.soLuong = soLuong;
        this.sanpham = sanpham;
    }

}
