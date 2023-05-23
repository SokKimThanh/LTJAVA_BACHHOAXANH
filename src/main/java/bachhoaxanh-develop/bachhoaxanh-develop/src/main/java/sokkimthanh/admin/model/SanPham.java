package sokkimthanh.admin.model;

/**
 *
 * @author Sok Kim Thanh Date 17/05/2023 Cai dat lop san pham
 */
public class SanPham {

    private int maSP;

    private String tenSP;
    private int loaiSP;
    private double giaSP;
    public static int count;

    //cap nhật
    public SanPham(int maSP, String tenSP, int loaiSP, double giaSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.loaiSP = loaiSP;
        this.giaSP = giaSP;
        this.count++;
    }

    // tạo danh sách để nhập tay
    public SanPham() {
        this.count++;
    }

    // thêm mới
    public SanPham(String tenSP, int loaiSP, double giaSP) {
        this.tenSP = tenSP;
        this.loaiSP = loaiSP;
        this.giaSP = giaSP;
        this.count++;
    }

    // xóa
    public SanPham(int maSP) {
        this.maSP = maSP;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(int loaiSP) {
        this.loaiSP = loaiSP;
    }

    public double getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(double giaSP) {
        this.giaSP = giaSP;
    }

    @Override
    public String toString() {
        return "SanPham{" + "maSP=" + maSP + ", tenSP=" + tenSP + ", loaiSP=" + loaiSP + ", giaSP=" + giaSP + '}';
    }

}
