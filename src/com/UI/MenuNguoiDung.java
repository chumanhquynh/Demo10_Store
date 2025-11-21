package com.UI;

import java.util.Scanner;

public class MenuNguoiDung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("=== MENU CHINH ===");
            System.out.println("1. Quan ly san pham");
            System.out.println("2. Quan ly khach hang");
            System.out.println("3. Quan ly hoa don");
            System.out.println("4. Thong ke doanh thu");
            System.out.println("5. Dang xuat");
            System.out.println("Nhap lua chon cua ban: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    MenuSanPham menuSanPham = new MenuSanPham();
                    menuSanPham.main(args);
                    break;
                case 2:
                    MenuKhachHang menuKhachHang = new MenuKhachHang();
                    menuKhachHang.main(args);
                    break;
                case 3:
                    MenuHoaDon menuHoaDon = new MenuHoaDon();
                    menuHoaDon.main(args);
                    break;
                case 4:
                    MenuThongKe menuThongKe = new MenuThongKe();
                    menuThongKe.main(args);
                    break;
                case 5:
                    System.out.println("Dang xuat thanh cong!");
                    StartMenu startMenu = new StartMenu();
                    startMenu.main(args);
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
            }
        } while (true);
    }


}
