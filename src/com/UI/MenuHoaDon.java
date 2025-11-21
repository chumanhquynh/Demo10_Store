package com.UI;

import java.util.Scanner;

public class MenuHoaDon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("=== MENU QUAN LY HOA DON ===");
            System.out.println("1. Hien thi danh sach hoa don");
            System.out.println("2. Them hoa don");
            System.out.println("3. Tim kiem hoa don");
            System.out.println("4. Quay lai");
            System.out.println("Nhap lua chon cua ban: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Hien thi danh sach hoa don");
                    break;
                case 2:
                    System.out.println("Them hoa don");
                    break;
                case 3:
                    System.out.println("Tim kiem hoa don");
                    break;
                case 4:
                    MenuNguoiDung menuNguoiDung = new MenuNguoiDung();
                    menuNguoiDung.main(args);
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
            }
        } while (true);
    }
}
