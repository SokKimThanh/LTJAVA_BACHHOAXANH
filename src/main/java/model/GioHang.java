/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
 
/**
 *
 * @author Admin
 */
public class GioHang {
    private DSSanPham data;

    public DSSanPham getData() {
        return data;
    }

    public void setData(DSSanPham data) {
        this.data = data;
    }
    private int soLuong;
    private SanPham item;

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public SanPham getItem() {
        return item;
    }

    public void setItem(SanPham item) {
        this.item = item;
    }

    public GioHang(SanPham item, int soLuong) {
        this.soLuong = soLuong;
        this.item = item;
    }
    
}
