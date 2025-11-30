package dao;

import config.DbConnection;
import model.KhachHang;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDao {
    public List<KhachHang> getAllKhachHang() {
        List<KhachHang> listKhachHang = new ArrayList<KhachHang>();
        String sql = "select * from khachhang";

        try{
            Connection connection = DbConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setIdKhachHang(resultSet.getInt("idkhachhang"));
                khachHang.setTenKhachHang(resultSet.getString("tenkhachhang"));
                khachHang.setSoDienThoai(resultSet.getString("sodienthoai"));
                khachHang.setDiaChi(resultSet.getString("diachi"));
                listKhachHang.add(khachHang);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listKhachHang;
    }

    public static boolean add(KhachHang khachHang) {
        String sql = "insert into khachhang (tenkhachhang, sodienthoai, diachi) values (?, ? , ?)";
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, khachHang.getTenKhachHang());
            preparedStatement.setString(2, khachHang.getSoDienThoai());
            preparedStatement.setString(3, khachHang.getDiaChi());

            return preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean update(KhachHang khachHang) {
        String sql = "update khachhang set tenkhachhang = ?, sodienthoai = ?, diachi = ? where idkhachhang = ?";
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, khachHang.getTenKhachHang());
            preparedStatement.setString(2, khachHang.getSoDienThoai());
            preparedStatement.setString(3, khachHang.getDiaChi());
            preparedStatement.setInt(4, khachHang.getIdKhachHang());

            return preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean delete(int id) {
        String sql = "delete from khachhang where idkhachhang = ?";

        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
