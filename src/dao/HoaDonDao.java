package dao;

import dbconnection.DbConnection;
import entity.HoaDon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HoaDonDao {
    public List<HoaDon> getAllHoaDon() {
        List<HoaDon> listHoaDon = new ArrayList<HoaDon>();
        String sql = "select hoadon.*, khachhang.tenkhachhang from hoadon left join khachhang on hoadon.idkhachhang = khachhang.idkhachhang order by hoadon.idhoadon desc";

        try {
            Connection connection = DbConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setIdHoaDon(resultSet.getInt("idhoadon"));
                hoaDon.setIdKhachHang(resultSet.getInt("idkhachhang"));
                hoaDon.setNgay(resultSet.getDate("ngay"));
                hoaDon.setTongTien(resultSet.getBigDecimal("tongtien"));
                hoaDon.setTenKhachHang(resultSet.getString("tenkhachhang"));
                listHoaDon.add(hoaDon);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public boolean addHoaDon(HoaDon hoaDon) {
        String sql = "INSERT INTO hoadon (idkhachhang, ngay, tongtien) VALUES (?, ?, ?)";

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, hoaDon.getIdKhachHang());
            pstmt.setDate(2, (Date) hoaDon.getNgay());
            pstmt.setBigDecimal(3, hoaDon.getTongTien());

            int result = pstmt.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Lỗi khi thêm hóa đơn: " + e.getMessage());
            return false;
        }
    }
}
