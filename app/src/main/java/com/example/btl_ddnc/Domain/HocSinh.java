package com.example.btl_ddnc.Domain;

import java.io.Serializable;

public class HocSinh implements Serializable {
    private String Ma;
    private String TenHs;
    private String DiaChi;
    private String NgaySinh;
    private String GioiTinh;
    private String email;
    private String DiemTb;

    public HocSinh(String ma, String tenHs, String diaChi, String ngaySinh, String gioiTinh, String email, String diemTb) {
        Ma = ma;
        TenHs = tenHs;
        DiaChi = diaChi;
        NgaySinh = ngaySinh;
        GioiTinh = gioiTinh;
        this.email = email;
        DiemTb = diemTb;
    }

    public HocSinh() {

    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String ma) {
        Ma = ma;
    }

    public String getTenHs() {
        return TenHs;
    }

    public void setTenHs(String tenHs) {
        TenHs = tenHs;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiemTb() {
        return DiemTb;
    }

    public void setDiemTb(String diemTb) {
        DiemTb = diemTb;
    }
}
