package model;

import java.math.BigDecimal;

public class ChiTietHoaDon {
    private int idChiTietHoaDon;
    private int idHoaDon;
    private int idSanPham;
    private int soLuong;
    private BigDecimal gia;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int idChiTietHoaDon, int idHoaDon, int idSanPham, int soLuong, BigDecimal gia) {
        this.idChiTietHoaDon = idChiTietHoaDon;
        this.idHoaDon = idHoaDon;
        this.idSanPham = idSanPham;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public int getIdChiTietHoaDon() {
        return idChiTietHoaDon;
    }

    public void setIdChiTietHoaDon(int idChiTietHoaDon) {
        this.idChiTietHoaDon = idChiTietHoaDon;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }
}
