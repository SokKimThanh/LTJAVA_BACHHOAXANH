/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import java.util.ArrayList;
import org.junit.Test;

/**
 *
 * @author Thanh
 */
public class DSSanPhamIT {

    public DSSanPhamIT() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetData() {
        System.out.println("getData");
        DSSanPham instance = new DSSanPham();
        ArrayList<SanPham> expResult = null;
        ArrayList<SanPham> result = instance.getData();

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetData() {
        System.out.println("setData");
        ArrayList<SanPham> data = null;
        DSSanPham instance = new DSSanPham();
        instance.setData(data);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testToString() {
        System.out.println("toString");
        DSSanPham instance = new DSSanPham();
        String expResult = "";
        String result = instance.toString();

    }

    @Test(expected = IllegalArgumentException.class)
    public void testShow() {
        System.out.println("Show");
        DSSanPham instance = new DSSanPham();
        String expResult = "";
        String result = instance.Show();

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdd() {
        System.out.println("add");
        SanPham item = null;
        DSSanPham instance = new DSSanPham();
        instance.add(item);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testThemDL() {
        System.out.println("ThemDL");
        SanPham value = null;
        DSSanPham instance = new DSSanPham();
        int expResult = 0;
        instance.ThemDL(value);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testXoaDL() {
        System.out.println("XoaDL");
        SanPham value = null;
        DSSanPham instance = new DSSanPham();
        int expResult = 0;
        instance.XoaDL(value);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSuaDL() {
        System.out.println("SuaDL");
        SanPham value = null;
        DSSanPham instance = new DSSanPham();
        int expResult = 0;
        instance.SuaDL(value);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testDocDL() {
        System.out.println("DocDL");
        DSSanPham instance = new DSSanPham();
        instance.DocDL();

    }

    @Test(expected = IllegalArgumentException.class)
    public void testTimKiem() {
        System.out.println("TimKiem");
        int tieuChiTimKiem = 0;
        String keySearch = "";
        int cboLoaiSP = 0;
        DSSanPham instance = new DSSanPham();
        instance.TimKiem(tieuChiTimKiem, keySearch, cboLoaiSP);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testGhiFile() {
        System.out.println("GhiFile");
        String file = "";
        DSSanPham instance = new DSSanPham();
        instance.GhiFile(file);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testDocFile() {
        System.out.println("DocFile");
        String file = "";
        DSSanPham instance = new DSSanPham();
        instance.DocFile(file);
    }
    
}
