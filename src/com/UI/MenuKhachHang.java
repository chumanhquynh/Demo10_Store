package com.UI;

import java.util.Scanner;

public class MenuKhachHang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("=== MENU QUAN LY KHACH HANG ===");
            System.out.println("1. Hien thi danh sach khach hang");
            System.out.println("2. Them khach hang moi");
            System.out.println("3. Cap nhat thong tin khach hang");
            System.out.println("4. Xoa khach hang");
            System.out.println("5. Quay lai");
            System.out.println("Nhap lua chon cua ban: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Hien thi danh sach khach hang");
                    break;
                case 2:
                    System.out.println("Them khach hang moi");
                    break;
                case 3:
                    System.out.println("Cap nhat thong tin khach hang");
                    break;
                case 4:
                    System.out.println("Xoa khach hang");
                    break;
                case 5:
                    MenuNguoiDung menuNguoiDung = new MenuNguoiDung();
                    menuNguoiDung.main(args);
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
            }
        } while (true);
    }
}
