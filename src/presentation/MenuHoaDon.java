package presentation;

import dao.HoaDonDao;
import dao.KhachHangDao;
import model.HoaDon;
import model.KhachHang;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class MenuHoaDon {
    private static Scanner sc = new Scanner(System.in);
    public void showMenu() {
        do {
            System.out.println("\n=== MENU QUAN LY HOA DON ===");
            System.out.println("1. Hien thi danh sach hoa don");
            System.out.println("2. Them hoa don");
            System.out.println("3. Tim kiem hoa don");
            System.out.println("4. Quay lai");
            System.out.println("Nhap lua chon cua ban: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    danhSachHoaDon();
                    break;
                case 2:
                    themHoaDon();
                    break;
                case 3:
                    MenuTimKiemHoaDon menuTimKiemHoaDon = new MenuTimKiemHoaDon();
                    break;
                case 4:
                    MenuNguoiDung menuNguoiDung = new MenuNguoiDung();
                    menuNguoiDung.showMenu();
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
            }
        } while (true);
    }

    private static void danhSachHoaDon() {
        System.out.println("\n=== DANH SACH HOA DON ===");
        List<HoaDon> danhSach = new HoaDonDao().getAllHoaDon();

        if (danhSach.isEmpty()) {
            System.out.println("Khong co hoa don nao!");
        }

        System.out.printf("%-10s %-12s %-20s %-15s %-15s%n", "Id hoa don", "Id khach hang", "Ten khach hang", "Ngay", "Tong tien");
        System.out.println("-------------------------------------------------------------------");

        for (HoaDon hoaDon : danhSach) {
            System.out.printf("%-10d %-12s %-20s %-15s %-15s%n",
                    hoaDon.getIdHoaDon(),
                    hoaDon.getIdKhachHang(),
                    hoaDon.getTenKhachHang(),
                    hoaDon.getNgay(),
                    hoaDon.getTongTien());
        }
    }

    private void themHoaDon() {
        System.out.println("\n=== THEM HOA DON MOI ===");

        System.out.println("\n--- DANH SACH KHACH HANG ---");
        List<KhachHang> danhSachKH = new KhachHangDao().getAllKhachHang();

        if (danhSachKH.isEmpty()) {
            System.out.println("Khong co khach hang nao!");
            return;
        }

        System.out.printf("%-5s %-20s %-15s%n", "ID", "TEN KHACH HANG", "SO DIEN THOAI");
        System.out.println("----------------------------------------");
        for (KhachHang kh : danhSachKH) {
            System.out.printf("%-5d %-20s %-15s%n",
                    kh.getIdKhachHang(),
                    kh.getTenKhachHang(),
                    kh.getSoDienThoai() != null ? kh.getSoDienThoai() : "N/A");
        }

        System.out.print("\nChọn ID khach hang them hoa don: ");
        int idKhachHang = sc.nextInt();
        sc.nextLine();

        KhachHang khachHang =  new KhachHangDao().getAllKhachHang().get(idKhachHang);
        if (khachHang == null) {
            System.out.println("Khong tim thay khach hang voi id: " + idKhachHang);
            return;
        }

        System.out.println("Da chon khach hang: " + khachHang.getTenKhachHang());
        System.out.println("Id: " + khachHang.getIdKhachHang());

        System.out.print("Nhap ngay hoa don moi(yyyy-mm-dd): ");
        String ngayStr = sc.nextLine();
        Date ngay;
        try {
            ngay = Date.valueOf(ngayStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Ngay vua nhap khong hop le!");
            return;
        }

        System.out.print("Nhap tong tien: ");
        BigDecimal tongTien = sc.nextBigDecimal();
        sc.nextLine();

        HoaDon hoaDonMoi = new HoaDon(idKhachHang, ngay, tongTien);
        boolean success = new HoaDonDao().addHoaDon(hoaDonMoi);

        if (success) {
            System.out.println("Them hoa don thanh cong!");
            System.out.println("Khach hang: " + khachHang.getTenKhachHang());
            System.out.println("Ngay: " + ngay);
            System.out.println("Tong tien: " + tongTien);
        } else {
            System.out.println("Them hoa don that bai!");
        }
    }

    private static void timKiemHoaDon() {

    }
}
