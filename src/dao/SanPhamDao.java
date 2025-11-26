package dao;

import dbconnection.DbConnection;
import entity.SanPham;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class SanPhamDao {
    public List<SanPham>getAllSanPham(){
        List<SanPham> listSanPham = new ArrayList<SanPham>();
        String sql = "select * from sanpham";

        try {
            Connection connection = dbconnection.DbConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setIdSanPham(resultSet.getInt("idsanpham"));
                sanPham.setTenSanPham(resultSet.getString("tensanpham"));
                sanPham.setThuongHieu(resultSet.getString("thuonghieu"));
                sanPham.setGia(resultSet.getBigDecimal("gia"));
                sanPham.setSoLuong(resultSet.getInt("soluong"));
                sanPham.setMoTa(resultSet.getString("mota"));
                listSanPham.add(sanPham);
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listSanPham;
    }

    public static boolean add(SanPham sanPham) {
        String sql = "insert into sanpham (tensanpham, thuonghieu, gia, soluong, mota) values (?, ?, ?, ?, ?)";
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, sanPham.getTenSanPham());
            preparedStatement.setString(2, sanPham.getThuongHieu());
            preparedStatement.setBigDecimal(3, sanPham.getGia());
            preparedStatement.setInt(4, sanPham.getSoLuong());
            preparedStatement.setString(5, sanPham.getMoTa());

            return preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean update(SanPham sanPham) {
        String sql = "update sanpham set tensanpham = ?, thuonghieu = ?, gia = ?, soluong = ?, mota = ? where idsanpham = ?";
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, sanPham.getTenSanPham());
            preparedStatement.setString(2, sanPham.getThuongHieu());
            preparedStatement.setBigDecimal(3, sanPham.getGia());
            preparedStatement.setInt(4, sanPham.getSoLuong());
            preparedStatement.setString(5, sanPham.getMoTa());
            preparedStatement.setInt(6, sanPham.getIdSanPham());

            return preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean delete(int id) {

        String sql = "delete from sanpham where idsanpham = ? ";
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }
        catch(SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public List<SanPham> searchThuongHieu(String thuongHieu) {
        List<SanPham> arraySanPham = new ArrayList<SanPham>();
        String sql = "select * from sanpham where thuonghieu like ?";
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, thuongHieu);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setIdSanPham(resultSet.getInt("idsanpham"));
                sanPham.setTenSanPham(resultSet.getString("tensanpham"));
                sanPham.setThuongHieu(resultSet.getString("thuonghieu"));
                sanPham.setGia(resultSet.getBigDecimal("gia"));
                sanPham.setSoLuong(resultSet.getInt("gia"));
                sanPham.setMoTa(resultSet.getString("mota"));
                arraySanPham.add(sanPham);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return arraySanPham;
    }

    public List<SanPham> searchGia(BigDecimal minGia, BigDecimal maxGia) {
        List<SanPham> arraySanPham = new ArrayList<SanPham>();
        String sql = "select * from sanpham where gia between ? and ?";
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setBigDecimal(1, minGia);
            preparedStatement.setBigDecimal(2, maxGia);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setIdSanPham(resultSet.getInt("idsanpham"));
                sanPham.setTenSanPham(resultSet.getString("tensanpham"));
                sanPham.setThuongHieu(resultSet.getString("thuonghieu"));
                sanPham.setGia(resultSet.getBigDecimal("gia"));
                sanPham.setSoLuong(resultSet.getInt("soluong"));
                sanPham.setMoTa(resultSet.getString("mota"));
                arraySanPham.add(sanPham);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return arraySanPham;
    }

//    public List<SanPham> searchSoLuong (int minSoLuong, int maxSoLuong) {
//        List<SanPham> arraySanPham = new ArrayList<SanPham>();
//        String sql = "select * from sanpham where soluong between ? and ?";
//        try {
//            Connection connection = DbConnection.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
//            preparedStatement.setInt(1, minSoLuong);
//            preparedStatement.setInt(2, maxSoLuong);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while(resultSet.next()) {
//                SanPham sanPham = new SanPham();
//                sanPham.setIdSanPham(resultSet.getInt("idsanpham"));
//                sanPham.setTenSanPham(resultSet.getString("tensanpham"));
//                sanPham.setThuongHieu(resultSet.getString("thuonghieu"));
//                sanPham.setGia(resultSet.getBigDecimal("gia"));
//                sanPham.setSoLuong(resultSet.getInt("soluong"));
//                sanPham.setMoTa(resultSet.getString("mota"));
//                arraySanPham.add(sanPham);
//            }
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return arraySanPham;
//    }

}
