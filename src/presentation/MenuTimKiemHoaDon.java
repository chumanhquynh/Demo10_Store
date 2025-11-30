package presentation;

import java.util.Scanner;

public class MenuTimKiemHoaDon {
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n=== MENU TIM KIEM HOA DON ===");
            System.out.println("1. Tim kiem theo ten khach hang");
            System.out.println("2. Tim kiem theo ngay lap");
            System.out.println("3. Quay lai");
            System.out.println("Nhap lua chon cua ban: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Tim kiem theo ten khach hang");
                    break;
                case 2:
                    System.out.println("Tim kiem theo ngay lap");
                    break;
                case 3:
                    MenuHoaDon menuHoaDon = new MenuHoaDon();
                    menuHoaDon.showMenu();
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
            }
        } while (true);
    }
}
