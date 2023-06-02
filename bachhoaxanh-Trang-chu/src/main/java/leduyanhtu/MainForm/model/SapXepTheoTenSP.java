/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Comparator;

/**
 *
 * @author thanh 14/5/2023 Cai Dat Lop Sap Xep ten
 */
public class SapXepTheoTenSP implements Comparator<SanPham> {

    @Override
    public int compare(SanPham o1, SanPham o2) {
        return o1.getTenSP().compareTo(o2.getTenSP());
    }
}
