package ui;

import dao.KhachHangDao;
import entity.KhachHang;

import java.util.List;
import java.util.Scanner;

public class MenuKhachHang {
    private static Scanner sc = new Scanner(System.in);

    public void showMenu() {
        do {
            System.out.println("\n=== MENU QUAN LY KHACH HANG ===");
            System.out.println("1. Hien thi danh sach khach hang");
            System.out.println("2. Them khach hang moi");
            System.out.println("3. Cap nhat thong tin khach hang");
            System.out.println("4. Xoa khach hang");
            System.out.println("5. Quay lai");
            System.out.println("Nhap lua chon cua ban: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    hienThiDanhSachKhachHang();
                    break;
                case 2:
                    themKhachHang();
                    break;
                case 3:
                    capNhatKhachHang();
                    break;
                case 4:
                    xoaKhachHang();
                    break;
                case 5:
                    MenuNguoiDung menuNguoiDung = new MenuNguoiDung();
                    menuNguoiDung.showMenu();
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
            }
        } while (true);
    }

    private static void hienThiDanhSachKhachHang() {
        System.out.println("\n === DANH SACH KHACH HANG ===");
        List<KhachHang> danhSach = new KhachHangDao().getAllKhachHang();

        if (danhSach.isEmpty()) {
            System.out.println("Khong co khach hang nao!");
            return;
        }

        System.out.printf("%-5s %-20s %-15s %-30s%n",
                "ID", "Ten KH", "So DT", "Dia chi");
        System.out.println("-------------------------------------------------------------------");

        for (KhachHang kh : danhSach) {
            System.out.printf("%-5d %-20s %-15s %-30s%n",
                    kh.getIdKhachHang(),
                    kh.getTenKhachHang(),
                    kh.getSoDienThoai() != null ? kh.getSoDienThoai() : "N/A",
                    kh.getDiaChi() != null ? kh.getDiaChi() : "N/A");
        }
    }

    private static void themKhachHang() {
        System.out.println("\n=== THEM KHACH HANG MOI ===");
        System.out.println("Nhap ten khach hang: ");
        String tenKhachHang = sc.nextLine();

        System.out.println("Nhap so dien thoai khach hang: ");
        String soDienThoai = sc.nextLine();
        System.out.println("Nhap dia chi khach hang: ");
        String diaChi = sc.nextLine();

        KhachHang khachHang = new KhachHang(tenKhachHang, soDienThoai, diaChi);
        boolean success = new KhachHangDao().add(khachHang);

        if (success) {
            System.out.println("Them khach hang thanh cong!");
        }
        else {
            System.out.println("Them khach hang that bai!");
        }
    }

    private static KhachHang capNhatKhachHang() {
        System.out.println("\n=== CAP NHAT THONG TIN KHACH HANG ===");
        System.out.println("Nhap id khach hang can chinh sua: ");
        int id = sc.nextInt();
        sc.nextLine();

        List<KhachHang> danhSach = new KhachHangDao().getAllKhachHang();
        KhachHang khachHang = null;
        for (KhachHang kh : danhSach) {
            if (kh.getIdKhachHang() == id) {
                khachHang = kh;
                break;
            }
        }
        if (khachHang == null) {
            System.out.println("Khong tim thay khach hang id: " + id);
            return khachHang;
        }

        System.out.println("Thong tin hien tai: ");
        System.out.println("Id khach hang: " + khachHang.getIdKhachHang());
        System.out.println("Ten khach hang: " + khachHang.getTenKhachHang());
        System.out.println("So dien thoai: " + khachHang.getSoDienThoai());
        System.out.println("Dia chi: " + khachHang.getDiaChi());

        System.out.println("Nhap thong tin moi: ");
        System.out.println("Nhap ten khach hang moi: ");
        String tenMoi = sc.nextLine();
        khachHang.setTenKhachHang(tenMoi);

        System.out.println("Nhap so dien thoai moi: ");
        String soDienThoaiMoi = sc.nextLine();
        khachHang.setSoDienThoai(soDienThoaiMoi);

        System.out.println("Nhap dia chi moi: ");
        String diaChiMoi = sc.nextLine();
        khachHang.setDiaChi(diaChiMoi);

        boolean success = KhachHangDao.update(khachHang);
        if (success) {
            System.out.println("Cap nhat khach hang thanh cong!");
        }
        else {
            System.out.println("Cap nhat khach hang that bai!");
        }

        return khachHang;
    }

    private static void xoaKhachHang() {
        System.out.println("\n=== XOA KHACH HANG ===");
        System.out.println("Nhap id khach hang can xoa");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Ban chac chan muon xoa khach hang (yes/no)?");
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("yes")) {
            boolean success = KhachHangDao.delete(id);
            if (success) {
                System.out.println("Xoa khach hang thanh cong!");
            }
            else {
                System.out.println("Xoa khach hang that bai!");
            }
        }
        else {
            System.out.println("Da huy thao tac!");
        }
    }
}
