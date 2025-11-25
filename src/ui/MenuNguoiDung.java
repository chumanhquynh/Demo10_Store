package ui;

import java.util.Scanner;

public class MenuNguoiDung {
    public void showMenu() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n=== MENU CHINH ===");
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
                    menuSanPham.showMenu();
                    break;
                case 2:
                    MenuKhachHang menuKhachHang = new MenuKhachHang();
                    menuKhachHang.showMenu();
                    break;
                case 3:
                    MenuHoaDon menuHoaDon = new MenuHoaDon();
                    menuHoaDon.showMenu();
                    break;
                case 4:
                    MenuThongKe menuThongKe = new MenuThongKe();
                    menuThongKe.showMenu();
                    break;
                case 5:
                    System.out.println("Dang xuat thanh cong!");
                    StartMenu startMenu = new StartMenu();
                    startMenu.startMenu();
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
            }
        } while (true);
    }


}
