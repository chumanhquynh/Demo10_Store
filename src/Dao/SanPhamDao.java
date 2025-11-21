package Dao;

import Entity.SanPham;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class SanPhamDao {
    public List<SanPham>getAllSanPham(){
        List<SanPham> listSanPham = new ArrayList<SanPham>();
        String sql = "SELECT * FROM sanpham";

        try {
            Connection connection = DbConnection.DbConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setIdSanPham(resultSet.getInt("idsanpham"));
                sanPham.setTenSanPham(resultSet.getString("tensanpham"));
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
}
