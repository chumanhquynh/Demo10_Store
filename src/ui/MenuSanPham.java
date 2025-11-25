package ui;

//import com.sun.tools.jdeprscan.scan.Scan;
import dao.SanPhamDao;
import entity.SanPham;
//import jdk.swing.interop.SwingInterOpUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuSanPham {
    private static Scanner sc = new Scanner(System.in);
    public void showMenu() {
        do {
            System.out.println("\n=== MENU SAN PHAM ===");
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
            sc.nextLine();

            switch (choice) {
                case 1:
                    hienThiDanhSachSanPham();
                    break;
                case 2:
                    themSanPham();
                    break;
                case 3:
                    capNhatSanPham();
                    break;
                case 4:
                    xoaSanPham();
                    break;
                case 5:
                    timKiemThuongHieu();
                    break;
                case 6:
                    timKiemGia();
                    break;
                case 7:
                    hienThiTonKho();
                    break;
                case 8:
                    MenuNguoiDung menuNguoiDung = new MenuNguoiDung();
                    menuNguoiDung.showMenu();
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
            }
        }while (true);
    }

    private static void hienThiDanhSachSanPham() {
        System.out.println("\n=== DANH SACH SAN PHAM ===");
        List<SanPham> danhSach = new SanPhamDao().getAllSanPham();

        if (danhSach.isEmpty()) {
            System.out.println("Khong co san pham nao!");
        }

        System.out.printf("%-5s %-30s %-15s %-12s %-8s %-20s%n",
                "ID", "Ten SP", "Thuong hieu", "Gia", "SL", "Mo ta");
        System.out.println("--------------------------------------------------------------------------------");

        for (SanPham sanPham : danhSach) {
            System.out.printf("%-5d %-30s %-15s %-12.2f %-8d %-20s%n",
                    sanPham.getIdSanPham(),
                    sanPham.getTenSanPham(),
                    sanPham.getThuongHieu(),
                    sanPham.getGia(),
                    sanPham.getSoLuong(),
                    sanPham.getMoTa());
        }
    }

    private static void themSanPham() {
        System.out.println("\n=== THEM SAN PHAM MOI ===");
        System.out.print("Nhap ten san pham: ");
        String tenSanPham = sc.nextLine();
        System.out.print("Nhap thuong hieu: ");
        String thuongHieu = sc.nextLine();
        System.out.print("Nhap gia: ");
        BigDecimal gia = sc.nextBigDecimal();
        System.out.print("Nhap so luong: ");
        int soLuong = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhap mo ta: ");
        String moTa = sc.nextLine();

        SanPham sanPham = new SanPham(tenSanPham, thuongHieu, gia, soLuong, moTa);
        boolean success = new SanPhamDao().add(sanPham);

        if (success) {
            System.out.println("Them san pham thanh cong!");
        } else {
            System.out.println("Them san pham that bai!");
        }
    }

    private static SanPham capNhatSanPham() {
        System.out.println("\n=== CAP NHAT THONG TIN SAN PHAM ===");
        System.out.println("Nhap id san pham can cap nhat: ");
        int id = sc.nextInt();
        sc.nextLine();

        List<SanPham> danhSach = new SanPhamDao().getAllSanPham();
        SanPham sanPham = null;
        for (SanPham sp : danhSach) {
            if (sp.getIdSanPham() == id) {
                sanPham = sp;
                break;
            }
        }
        if (sanPham == null) {
            System.out.println("Khong tim thay san pham voi id: " + id);
            return sanPham;
        }

        System.out.println("Thong tin hien tai:");
        System.out.println("Ten: " + sanPham.getTenSanPham());
        System.out.println("Thuong hieu: " + sanPham.getThuongHieu());
        System.out.println("Gia: " + sanPham.getGia());
        System.out.println("So luong: " + sanPham.getSoLuong());
        System.out.println("Mo ta: " + sanPham.getMoTa());

        System.out.println("Nhap thong tin moi: ");
        System.out.println("Nhap ten san pham moi: ");
        String tenMoi = sc.nextLine();
        sanPham.setTenSanPham(tenMoi);

        System.out.println("Nhap thuong hieu moi: ");
        String thuongHieuMoi = sc.nextLine();
        sanPham.setThuongHieu(thuongHieuMoi);

        System.out.println("Nhap gia moi: ");
        BigDecimal giaMoi = sc.nextBigDecimal();
        sanPham.setGia(giaMoi);
        sc.nextLine();

        System.out.println("Nhap so luong moi:");
        int soLuongMoi = sc.nextInt();
        sanPham.setSoLuong(soLuongMoi);
        sc.nextLine();

        System.out.println("Nhap mo ta moi: ");
        String moTaMoi = sc.nextLine();
        sanPham.setMoTa(moTaMoi);

        boolean success = SanPhamDao.update(sanPham);
        if (success) {
            System.out.println("Cap nhat san pham thanh cong!");
        } else {
            System.out.println("Cap nhat san pham that bai!");
        }
        return sanPham;
    }

    public static void xoaSanPham() {
        System.out.println("\n=== XOA SAN PHAM ===");
        System.out.println("Nhap id san pham can xoa: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Ban chac chan muon xoa san pham (yes/no)?");
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("yes")) {
            boolean success = SanPhamDao.delete(id);
            if (success) {
                System.out.println("Da xoa san pham thanh cong!");
            }
            else {
                System.out.println("Xoa san pham that bai!");
            }
        }
        else {
            System.out.println("Da huy thao tac!");
        }
    }

    public static void timKiemThuongHieu() {
        System.out.println("\n=== TIM KIEM SAN PHAM THEO THUONG HIEU ===");
        System.out.print("Nhap thuong hieu can tim: ");
        String thuongHieu = sc.nextLine();

        List<SanPham> danhSach = new SanPhamDao().searchThuongHieu(thuongHieu);

        if (danhSach.isEmpty()) {
            System.out.println("Khong tim thay san pham phu hop!");
        }
        System.out.println("=== Ket qua tim kiem ===");
        System.out.printf("%-5s %-30s %-15s %-12s %-8s %-20s%n", "ID", "Ten SP", "Thuong hieu", "Gia", "SL", "Mo ta");
        System.out.println("--------------------------------------------------------------------------------");
        for (SanPham sanPham: danhSach) {
            System.out.println(String.format("%-5s %-30s %-15s %-12s %-8s %-20s %n"
                    ,sanPham.getIdSanPham()
                    ,sanPham.getTenSanPham()
                    ,sanPham.getThuongHieu()
                    ,sanPham.getGia()
                    ,sanPham.getSoLuong()
                    ,sanPham.getMoTa() != null ? sanPham.getMoTa() : ""
            ));
        }
    }

    public static void timKiemGia() {
        System.out.println("\n=== TIM KIEM SAN PHAM THEO GIA===");
        System.out.println("Nhap gia toi thieu: ");
        BigDecimal min = sc.nextBigDecimal();
        sc.nextLine();
        System.out.println("Nhap gia toi da: ");
        BigDecimal max = sc.nextBigDecimal();
        sc.nextLine();

        if (min.compareTo(max) > 0) {
            System.out.println("Gia thoi thieu phai nho hon gia toi da!");
        }

        List<SanPham> danhSach = new SanPhamDao().searchGia(min, max);
        if (danhSach.isEmpty()) {
            System.out.println("Khong tim thay san pham phu hop!");
        }
        System.out.printf("%-5s %-30s %-15s %-12s %-8s %-20s%n",
                "ID", "Ten SP", "Thuong hieu", "Gia", "SL", "Mo ta");
        System.out.println("--------------------------------------------------------------------------------");

        for (SanPham sanPham : danhSach) {
            System.out.printf("%-5d %-30s %-15s %-12.2f %-8d %-20s%n",
                    sanPham.getIdSanPham(),
                    sanPham.getTenSanPham(),
                    sanPham.getThuongHieu(),
                    sanPham.getGia(),
                    sanPham.getSoLuong(),
                    sanPham.getMoTa() != null ? sanPham.getMoTa() : "");
        }
    }

    public static void hienThiTonKho() {
        System.out.println("\n=== DANH SACH TON KHO ===");
        List<SanPham> danhSach = new SanPhamDao().getAllSanPham();

        if (danhSach.isEmpty()) {
            System.out.println("Khong con san pham nao!");
        }
        List<SanPham> listConHang = new ArrayList<SanPham>();
        List<SanPham> listHetHang = new ArrayList<SanPham>();

        for (SanPham sanPham: danhSach) {
            if (sanPham.getSoLuong() > 0) {
                listConHang.add(sanPham);
            }
            else {
                listHetHang.add(sanPham);
            }
        }

        System.out.println("\n=== SAN PHAM CON HANG (" + listConHang.size() + " san pham) ===");
            System.out.printf("%-5s %-20s %-15s %-12s %-8s %-20s%n",
                    "ID", "Ten SP", "Thuong hieu", "Gia", "SL", "Mo ta");
            System.out.println("--------------------------------------------------------------------------------");

            for (SanPham sp : listConHang) {
                System.out.printf("%-5d %-20s %-15s %-12.2f %-8d %-20s%n",
                        sp.getIdSanPham(),
                        sp.getTenSanPham(),
                        sp.getThuongHieu(),
                        sp.getGia(),
                        sp.getSoLuong(),
                        sp.getMoTa() != null ? sp.getMoTa() : "");
            }


        System.out.println("\n=== SAN PHAM HET HANG (" + listHetHang.size() + " san pham) ===");
            System.out.printf("%-5s %-20s %-15s %-12s %-8s %-20s%n",
                    "ID", "Ten SP", "Thuong hieu", "Gia", "SL", "Mo ta");
            System.out.println("--------------------------------------------------------------------------------");

            for (SanPham sp : listHetHang) {
                System.out.printf("%-5d %-20s %-15s %-12.2f %-8d %-20s%n",
                        sp.getIdSanPham(),
                        sp.getTenSanPham(),
                        sp.getThuongHieu(),
                        sp.getGia(),
                        sp.getSoLuong(),
                        sp.getMoTa() != null ? sp.getMoTa() : "");
            }

        System.out.println("\n=== THONG KE TON KHO ===");
        System.out.println("Tong so san pham: " + danhSach.size());
        System.out.println("San pham con hang: " + listConHang.size());
        System.out.println("San pham het hang: " + listHetHang.size());
    }
}
