package model;

/**
 * Name: Lê Duy Anh Tú Date: 22/05/2023
 * modified: Sok Kim Thanh: 28/05/2023
 */
public class SanPham {

    //Fields
    private String maSP;
    private String tenSP;
    private int tonKho, loaiSP;
    private double giaBan;

    //Contructors
    public SanPham(String maSP, String tenSP, int loaiSP, double giaBan, int tonKho) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.tonKho = tonKho;
        this.loaiSP = loaiSP;
    }

    public SanPham() {
        this.maSP = "";
        this.tenSP = "";
        this.giaBan = 0;
        this.tonKho = 0;
        this.loaiSP = 0;
    }

    public SanPham(String maSP) {
        this.maSP = maSP;
    }

    public SanPham(String tenSP, int loaiSP, double giaSP) {
        this.tenSP = tenSP;
        this.loaiSP = loaiSP;
        this.giaBan = giaSP;
    }

    public SanPham(String maSP, String tenSP, int loaiSP, double giaSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.loaiSP = loaiSP;
        this.giaBan = giaSP;
    }

    //Getters & Setters
    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getGiaSP() {
        return giaBan;
    }

    public void setGiaSP(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getTonKho() {
        return tonKho;
    }

    public void setTonKho(int tonKho) {
        if (tonKho <= 0) {
            throw new ArithmeticException("Số lượng tồn kho > 0");
        } else {
            this.tonKho = tonKho;
        }
    }

    public int getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(int loaiSP) {
        this.loaiSP = loaiSP;
    }

    //Methods
    public String ToString() {
        String msg = "";
        msg += maSP + "-";
        msg += tenSP + "-";
        msg += loaiSP + "-";
        msg += giaBan + "-";
        msg += tonKho;
        return msg;
    }

}
