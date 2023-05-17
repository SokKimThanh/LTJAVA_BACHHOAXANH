/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oanh;

import java.util.ArrayList;

/**
 *
 * @author oanh 14/5/2023 Cai Dat Lop DSSanPham
 */
public class DSSanPham {

    private ArrayList<SanPham> data;

    public DSSanPham() {
        data = new ArrayList<>();
    }

    public DSSanPham(ArrayList<SanPham> data) {
        this.data = data;
    }

    public ArrayList<SanPham> getData() {
        return data;
    }

    public void setData(ArrayList<SanPham> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DSSanPham{" + "data=" + data + '}';
    }

    public void add(SanPham item) {
        data.add(item);
    }

    public int remove(SanPham item) {
        for (SanPham o2 : data) {
            if (o2.getMaSP().compareTo(item.getMaSP()) == 0) {
                data.remove(o2);
                return 1;
            }
        }
        return -1;
    }

    public int edit(SanPham item, String tieuChi) {
        switch (tieuChi) {
            case "tenSP": {
                for (SanPham o2 : data) {
                    if (o2.getMaSP().compareTo(item.getMaSP()) == 0) {
                        o2.setTenSP(item.getTenSP());
                        return 1;
                    }
                    break;
                }
            }
            case "giaSP": {
                for (SanPham o2 : data) {
                    if (o2.getMaSP().compareTo(item.getMaSP()) == 0) {
                        o2.setTenSP(item.getTenSP());
                        return 1;
                    }
                    break;
                }
            }

            default: {
                break;
            }
        }
        return -1;
    }

}
