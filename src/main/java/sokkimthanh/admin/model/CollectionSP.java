/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sokkimthanh.admin.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author thanh 17/5/2023 Cai Dat Lop CollectionSP
 */
public class CollectionSP {

    public static void minGiaSP(ArrayList<SanPham> arr) {
        Collections.min(arr, new SapXepTheoGiaSP());
    }

    public static void maxGiaSP(ArrayList<SanPham> arr) {
        Collections.max(arr, new SapXepTheoGiaSP());
    }

    public static void reverseGiaSP(ArrayList<SanPham> arr) {
        Collections.reverse(arr);
    }
}
