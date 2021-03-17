package org.example;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Connection_test {
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "123456";
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/pharm_shema?useSSL=false";
    public static Statement statement;

    private Connection connection;

    public Connection getConnection() {
        if (connection == null) {
            try {
                return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD)) {
                System.out.println("Alles gud");
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM medicine");
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name_ru = resultSet.getString(2);
                    String name_en = resultSet.getString(3);
                    Boolean recipe =resultSet.getBoolean(4);
                    System.out.println(name_ru);
                    System.out.println(name_en);
                    System.out.println(id);
                    System.out.println(recipe);
                    System.out.printf("%s", id );
                }
            }
        } catch (Exception e){
            System.out.println("Connection failed");
            System.out.println(e);
        }
    }
}

