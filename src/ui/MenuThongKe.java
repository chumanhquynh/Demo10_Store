package ui;

import java.util.Scanner;

public class MenuThongKe {
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n=== MENU THONG KE ===");
            System.out.println("1. Doanh thu theo ngay");
            System.out.println("2. Doanh thu theo thang");
            System.out.println("3. Doanh thu theo nam");
            System.out.println("4. Quay lai");
            System.out.println("Nhap lua chon cua ban: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Doanh thu theo ngay");
                    break;
                case 2:
                    System.out.println("Doanh thu theo thang");
                    break;
                case 3:
                    System.out.println("Doanh thu theo nam");
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
}
