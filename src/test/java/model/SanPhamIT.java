/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thanh
 */
public class SanPhamIT {
    
    public SanPhamIT() {
    }

    @Test
    public void testGetMaSP() {
        System.out.println("getMaSP");
        SanPham instance = new SanPham();
        String expResult = "";
        String result = instance.getMaSP();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetMaSP() {
        System.out.println("setMaSP");
        String maSP = "";
        SanPham instance = new SanPham();
        instance.setMaSP(maSP);
        
    }

    @Test
    public void testGetTenSP() {
        System.out.println("getTenSP");
        SanPham instance = new SanPham();
        String expResult = "";
        String result = instance.getTenSP();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetTenSP() {
        System.out.println("setTenSP");
        String tenSP = "";
        SanPham instance = new SanPham();
        instance.setTenSP(tenSP);
        
    }

    @Test
    public void testGetGiaSP() {
        System.out.println("getGiaSP");
        SanPham instance = new SanPham();
        double expResult = 0.0;
        double result = instance.getGiaSP();
        assertEquals(expResult, result, 0);
        
    }

    @Test
    public void testSetGiaSP() {
        System.out.println("setGiaSP");
        double giaBan = 0.0;
        SanPham instance = new SanPham();
        instance.setGiaSP(giaBan);
        
    }

    @Test
    public void testGetTonKho() {
        System.out.println("getTonKho");
        SanPham instance = new SanPham();
        int expResult = 0;
        int result = instance.getTonKho();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetTonKho() {
        System.out.println("setTonKho");
        int tonKho = 0;
        SanPham instance = new SanPham();
        instance.setTonKho(tonKho);
        
    }

    @Test
    public void testGetLoaiSP() {
        System.out.println("getLoaiSP");
        SanPham instance = new SanPham();
        int expResult = 0;
        int result = instance.getLoaiSP();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetLoaiSP() {
        System.out.println("setLoaiSP");
        int loaiSP = 0;
        SanPham instance = new SanPham();
        instance.setLoaiSP(loaiSP);
        
    }

    @Test
    public void testToString() {
        System.out.println("ToString");
        SanPham instance = new SanPham();
        String expResult = "";
        String result = instance.ToString();
        assertEquals(expResult, result);
        
    }
    
}
