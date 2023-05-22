package frmTimKiem;

/**
 * Name: Lê Duy Anh Tú
 * Date: 22/05/2023
 */
public class SanPham {
    //Fields
    private String maSP, tenSP;
    private int giaBan, tonKho, loaiSP;

    //Contructors
    public SanPham(String maSP, String tenSP, int loaiSP, int giaBan, int tonKho) {
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
    public int getGiaBan() {
        return giaBan;
    }
    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }
    public int getTonKho() {
        return tonKho;
    }
    public void setTonKho(int tonKho) {
        if(tonKho <= 0)
            throw new ArithmeticException("Số lượng tồn kho > 0");
        else{
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
    public String ToString(){
        String msg = "";
        msg += maSP + "-";
        msg += tenSP + "-";
        msg += loaiSP + "-";
        msg += giaBan + "-";
        msg += tonKho;
        return msg;
    }
    
}
