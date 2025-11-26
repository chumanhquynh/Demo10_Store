package entity;

import java.math.BigDecimal;
import java.util.Date;

public class HoaDon {
    private int idHoaDon;
    private int idKhachHang;
    private Date ngay;
    private BigDecimal tongTien;
    private String tenKhachHang;

    public HoaDon() {
    }

    public HoaDon(int idHoaDon, int idKhachHang, Date ngay, BigDecimal tongTien) {
        this.idHoaDon = idHoaDon;
        this.idKhachHang = idKhachHang;
        this.ngay = ngay;
        this.tongTien = tongTien;
    }

    public HoaDon(int idHoaDon, int idKhachHang, Date ngay, BigDecimal tongTien, String tenKhachHang) {
        this.idHoaDon = idHoaDon;
        this.idKhachHang = idKhachHang;
        this.ngay = ngay;
        this.tongTien = tongTien;
        this.tenKhachHang = tenKhachHang;
    }

    public HoaDon(int idKhachHang, Date ngay, BigDecimal tongTien) {
        this.idKhachHang = idKhachHang;
        this.ngay = ngay;
        this.tongTien = tongTien;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }
}
