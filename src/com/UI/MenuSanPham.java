package com.UI;

import Entity.SanPham;

import java.util.List;
import java.util.Scanner;

public class MenuSanPham {
    public static void hienThiDanhSachSanPham() {
        System.out.println("=== Danh sach san pham ===");
        List<SanPham>  danhSachSanPham = new Dao.SanPhamDao().getAllSanPham();
        System.out.printf("%-5s %-30s %-15s %-12s %-8s %-20s%n",
                "ID", "Ten SP", "Thuong hieu", "Gia", "SL", "Mo ta");
        System.out.println("--------------------------------------------------------------------------------");

        for (SanPham sp : danhSachSanPham) {
            System.out.printf("%-5d %-30s %-15s %-12.2f %-8d %-20s%n",
                    sp.getIdSanPham(),
                    sp.getTenSanPham(),
                    sp.getThuongHieu(),
                    sp.getGia(),
                    sp.getSoLuong(),
                    sp.getMoTa() != null ? sp.getMoTa() : "");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("=== MENU SAN PHAM ===");
            System.out.println("1. Hien thi danh sach san pham");
            System.out.println("2. Them san pham moi");
            System.out.println("3. Cap nhat thong tin san pham");
            System.out.println("4. Xoa san pham");
            System.out.println("5. Tim kiem theo branch");
            System.out.println("6. Tim kiem theo gia");
            System.out.println("7. Tim kiem theo ton kho");
            System.out.println("8. Quay lai");
            System.out.println("Nhap lua chon cua ban: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    hienThiDanhSachSanPham();
                    break;
                case 2:
                    System.out.println("2. Them san pham moi");
                    break;
                case 3:
                    System.out.println("3. Cap nhat thong tin san pham");
                    break;
                case 4:
                    System.out.println("4. Xoa san pham");
                    break;
                case 5:
                    System.out.println("5. Tim kiem theo branch");
                    break;
                case 6:
                    System.out.println("6. Tim kiem theo gia");
                    break;
                case 7:
                    System.out.println("7. Tim kiem theo ton kho");
                    break;
                case 8:
                    MenuNguoiDung menuNguoiDung = new MenuNguoiDung();
                    menuNguoiDung.main(args);
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
            }
        }while (true);
    }
}
