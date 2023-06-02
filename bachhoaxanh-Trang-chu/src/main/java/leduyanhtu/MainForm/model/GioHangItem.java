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
    //Fields
    private int soLuong;
    private SanPham sanpham;
    private double ThanhTien;
    
    //Contructor
    public GioHangItem(SanPham sanpham, int soLuong) {
        if(soLuong > sanpham.getTonKho()){
            throw new ArithmeticException("Không đủ số lượng yêu cầu");
        }
        this.soLuong = soLuong;
        this.sanpham = sanpham;
        this.ThanhTien = sanpham.getGiaSP() * soLuong;
    }
    
    public int getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(int soLuong) {
        if(soLuong > sanpham.getTonKho()){
            throw new ArithmeticException("Không đủ số lượng để mua");
        }
        this.soLuong = soLuong;
        ThanhTien = sanpham.getGiaSP() * this.soLuong;
    }
    public SanPham getItem() {
        return sanpham;
    }
    public void setItem(SanPham item) {
        this.sanpham = item;
    }
    public double getThanhTien() {
        return ThanhTien;
    }
    
    
}