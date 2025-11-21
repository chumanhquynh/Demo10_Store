package Dao;

import java.sql.*;

import DbConnection.DbConnection;
import Entity.Admin;

public class AdminDao {
    public Admin login(String username, String password) {
        String sql = "select * from admin where username = ? and password = ? ";
        Admin admin = null;

        try  {
            Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                admin = new Admin();
                admin.setIdAdmin(resultSet.getInt("id_admin"));
                admin.setUsername(resultSet.getString("username"));
                admin.setPassword(resultSet.getString("password"));
            }

        }
        catch (SQLException e){
            throw new RuntimeException("Loi dang nhap", e);
        }
        return admin;
    }
}
