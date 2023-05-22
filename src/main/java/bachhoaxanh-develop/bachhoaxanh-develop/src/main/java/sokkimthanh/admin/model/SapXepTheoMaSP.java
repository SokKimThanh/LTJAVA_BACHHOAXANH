/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sokkimthanh.admin.model;

import java.util.Comparator;

/**
 *
 * @author thanh 17/5/2023 Cai Dat Lop Sap Xep ma
 */
public class SapXepTheoMaSP implements Comparator<SanPham> {

    @Override
    public int compare(SanPham o1, SanPham o2) {
        if (o1.getMaSP() > o2.getMaSP()) {
            return -1;
        } else if (o1.getGiaSP() < o2.getGiaSP()) {
            return 1;
        }
        return 0;
    }
}
