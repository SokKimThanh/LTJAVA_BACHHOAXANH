/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oanh;

/**
 *
 * @author oanh
 * 14/5/2023
 * Cai Dat Lop Sap Xep
 */
public class SanPham {
    private String tenSP;
    private String maSP;
    private double giaSP;

    public SanPham() {
    }

    public SanPham(String tenSP, String maSP, double giaSP) {
        this.tenSP = tenSP;
        this.maSP = maSP;
        this.giaSP = giaSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public double getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(double giaSP) {
        this.giaSP = giaSP;
    }

    @Override
    public String toString() {
        return "SanPham{" + "tenSP=" + tenSP + ", maSP=" + maSP + ", giaSP=" + giaSP + '}';
    }
    
    
    
}
