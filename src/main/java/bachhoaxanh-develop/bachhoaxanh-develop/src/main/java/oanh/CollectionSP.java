/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oanh;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author oanh
 * 14/5/2023
 * Cai Dat Lop CollectionSP
 */
public class CollectionSP {
    public void minGiaSP(ArrayList<SanPham> arr) {
        Collections.min(arr, new SapXepTheoGiaSP()) ;
    }
    
}
    

