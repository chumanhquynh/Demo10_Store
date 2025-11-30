package presentation;

import dao.AdminDao;
import model.Admin;

import java.util.Scanner;

public class AdminLogin {
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=== DANG NHAP ===");
        System.out.print("Nhap ten dang nhap: ");
        String username = sc.nextLine();
        System.out.print("Nhap mat khau: ");
        String password = sc.nextLine();

        if (authenticate(username, password)) {
            System.out.println("Dang nhap thanh cong");
            MenuNguoiDung menuNguoiDung = new MenuNguoiDung();
            menuNguoiDung.showMenu();
        }
        else {
            System.out.println("Sai ten dang nhap hoac mat khau!");
        }
    }

    private static boolean authenticate(String username, String password) {
        AdminDao adminDao = new AdminDao();
        Admin admin = adminDao.login(username, password);
        return admin != null;
    }
}
