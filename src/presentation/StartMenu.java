package presentation;

import java.util.Scanner;

public class StartMenu {
    public void startMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=== CHUONG TRINH QUAN LY CUA HANG DIEN THOAI ===");

        do {
            System.out.println("1. Dang nhap Admin ");
            System.out.println("2. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    AdminLogin adminLogin = new AdminLogin();
                    adminLogin.showMenu();
                    break;
                case 2:
                    System.out.println("Thoat chuong trinh");
                    System.exit(0);
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        } while (true);
    }
}
