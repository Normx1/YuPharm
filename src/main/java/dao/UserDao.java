package dao;

import model.User;
import sql.JDBCConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements BasicDao<User> {

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        try (Connection conn = JDBCConnector.getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from table_name");) {
            //Получем все элементы таблицы
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String mail = resultSet.getString(3);
                User user = new User(id, name, mail);
                userList.add(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return userList;
    }

    @Override
    public User getById(int id) {
        User user = new User();
        try (Connection conn = JDBCConnector.getConnection()) {
            String sql = "select * from users.table_name where id=?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {

                    int prodId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String mail = resultSet.getString(3);
                    String password = resultSet.getString(4);
                    User userById = new User( id, name, mail, password);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return user;
    }

    @Override
    public User deleteById(int id) {
        User user = getById(id);
        try (Connection conn = JDBCConnector.getConnection()) {
            String sql = "DELETE FROM users.table_name WHERE id = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                preparedStatement.execute();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return user;
    }

    @Override
    public User updateById(User user1) {
        User user = getById(user1.getId());
        try (Connection conn = JDBCConnector.getConnection()) {
            String sql = "UPDATE users.table_name SET name = ?, mail = ?, password = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, user1.getName());
                preparedStatement.setString(2, user1.getMail());
                preparedStatement.setString(3, user1.getPassword());
                preparedStatement.setInt(4, user.getId());
                preparedStatement.execute();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return user;
    }

    @Override
    public User create(User model) {
        try (Connection conn = JDBCConnector.getConnection()) {
            String sql = "insert into users.table_name (name, mail, password) values (?, ?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, model.getName());
                preparedStatement.setString(2, model.getMail());
                preparedStatement.setString(3, model.getPassword());
                preparedStatement.execute();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return model;
    }
}
