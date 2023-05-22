/**
 * Name : Lê Duy Anh Tú
 * Date: 16/05/2023
 * Model SinhVien
 */
package sokkimthanh.admin.example;

/**
 *
 * @author Administrator
 */
public class SinhVien{

    //Fields
    private String  tenSV;
    private int maSV, tuoi;

    //Contructors
    public SinhVien() {
    }
    public SinhVien(int maSV, String tenSV, int tuoi) {
        this.tenSV = tenSV;
        this.maSV = maSV;
        this.tuoi = tuoi;
    }

    //Getters & Setters
    public String getTenSV() {
        return tenSV;
    }
    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }
    public int getMaSV() {
        return maSV;
    }
    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }
    public int getTuoi() {
        return tuoi;
    }
    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    @Override
    public String toString() {
        return "SinhVien{" + "tenSV=" + tenSV + ", maSV=" + maSV + ", tuoi=" + tuoi + '}';
    }

    
}
