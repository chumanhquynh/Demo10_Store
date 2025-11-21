package DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static String URL = "jdbc:mysql://localhost:3306/qlystore?createDatabaseIfNotExists=true";
    private static String USERNAME = "root";
    private static String PASSWORD = "123456";

    private static Connection connection = null;
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Ket noi thanh cong");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
