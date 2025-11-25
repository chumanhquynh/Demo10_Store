package entity;

import java.math.BigDecimal;

public class SanPham {
    private int idSanPham;
    private String tenSanPham;
    private String thuongHieu;
    private BigDecimal gia;
    private int soLuong;
    private String moTa;

    public SanPham() {
    }

    public SanPham(int idSanPham, String tenSanPham, String thuongHieu, BigDecimal gia, int soLuong, String moTa) {
        this.idSanPham = idSanPham;
        this.tenSanPham = tenSanPham;
        this.thuongHieu = thuongHieu;
        this.gia = gia;
        this.soLuong = soLuong;
        this.moTa = moTa;
    }

    public SanPham(String tenSanPham, String thuongHieu, BigDecimal gia, int soLuong, String moTa) {
        this.tenSanPham = tenSanPham;
        this.thuongHieu = thuongHieu;
        this.gia = gia;
        this.soLuong = soLuong;
        this.moTa = moTa;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

}
