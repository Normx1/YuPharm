package dao;

import model.Drug;
import model.Order;
import sql.JDBCConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDao_Imp implements OrderDao {
    @Override
    public List<Drug> getAll() {

        List<Order> orderList = new ArrayList<>();
        try (
                Connection conn = JDBCConnector.getConnection();
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from orders");) {
            //Получем все элементы таблицы
            while (resultSet.next()) {
                int id_order = resultSet.getInt(1);
                int id_user = resultSet.getInt(1);
                int id_drug = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int cost = resultSet.getInt(4);
                int count = resultSet.getInt(3);
                byte recipe = resultSet.getByte(5);
                Drug drug = new Drug(id, name, cost, count, recipe);
                orderList.add(drug);
            }
        } catch (
                Exception ex) {
            System.out.println(ex);
        }
        return orderList;
    }

    @Override
    public Object getById(int id) {
        return null;
    }

    @Override
    public Object deleteById(int id) {
        return null;
    }

    @Override
    public Object updateById(Object model) {
        return null;
    }

    @Override
    public Object create(Object model) {
        return null;
    }
}
