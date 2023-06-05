/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class GioHang {

    //Fields
    private ArrayList<GioHangItem> data = new ArrayList<>();
    private double ThanhTien;
    
    //Contructor
    public GioHang() {
        ThanhTien = 0;
    }

    public ArrayList<GioHangItem> getData() {
        return data;
    }
    public void setData(ArrayList<GioHangItem> data) {
        this.data = data;
    }
    public double getThanhTien() {
        return ThanhTien;
    }
    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
    public void add(GioHangItem value){
        data.add(value);
        ThanhTien += value.getThanhTien();
    }
    public void SuaSL(String maSP, int sl) throws Exception{
        boolean check = false;
        for (GioHangItem gioHangItem : data) {
            if(gioHangItem.getItem().getMaSP().toLowerCase().compareTo(maSP.toLowerCase()) == 0){
                if(sl > gioHangItem.getItem().getTonKho()){
                    throw new ArithmeticException("Không đủ số lượng yêu cầu");
                }else{
                    ThanhTien -= gioHangItem.getThanhTien();
                    gioHangItem.setSoLuong(sl);
                    ThanhTien += gioHangItem.getThanhTien();
                }
            }
        }
        if(!check){
            throw new Exception("Mã sản phẩm không hợp lệ");
        }
    }
}
