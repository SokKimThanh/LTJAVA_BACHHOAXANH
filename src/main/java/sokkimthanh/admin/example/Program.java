/**
 * Name : Lê Duy Anh Tú
 * Date : 16/05/2023
 * Testing model
 */
package sokkimthanh.admin.example;


/**
 *
 * @author Administrator
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DSSinhVien lSinhVien = new DSSinhVien();
        //lSinhVien.ThemDL(new SinhVien(3, "An", 18));
        //lSinhVien.XoaDL(3);
        //lSinhVien.SuaDL(new SinhVien(3,"Dung", 23));
        lSinhVien.DocDL();
        System.out.println(lSinhVien.HienThi());
    }

}
