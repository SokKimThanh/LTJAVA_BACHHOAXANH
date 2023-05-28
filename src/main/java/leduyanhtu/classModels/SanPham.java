/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classModels;

/**
 *
 * @author Imac
 */
public class SanPham {
    //Fields
    private String MaSP, TenSP;
    private int Loai, SoLuong;
    private double GiaBan;

    //Contructors
    public SanPham(String MaSP, String TenSP, int Loai, int SoLuong, double GiaBan) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.Loai = Loai;
        this.SoLuong = SoLuong;
        this.GiaBan = GiaBan;
    }
    public SanPham() {
        
    }

    //Getters & Setters
    public String getMaSP() {
        return MaSP;
    }
    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }
    public String getTenSP() {
        return TenSP;
    }
    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }
    public int getLoai() {
        return Loai;
    }
    public void setLoai(int Loai) {
        this.Loai = Loai;
    }
    public int getSoLuong() {
        return SoLuong;
    }
    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    public double getGiaBan() {
        return GiaBan;
    }
    public void setGiaBan(double GiaBan) {
        this.GiaBan = GiaBan;
    }
    
    //Methods
    public String ToString(){
        return String.format("%s-%s-%d-%f-%d", MaSP, TenSP, Loai, GiaBan, SoLuong);
    }
}
