package dao;

import model.Drug;
import sql.JDBCConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DrugDao implements BasicDao<Drug> {
     @Override
    public List<Drug> getAll() {
        List<Drug> drugList = new ArrayList<>();
        try (Connection conn = JDBCConnector.getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from drugs");) {
            //Получем все элементы таблицы
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int cost = resultSet.getInt(4);
                int count = resultSet.getInt(3);
                byte recipe = resultSet.getByte(5);
                Drug drug = new Drug(id, name, cost, count, recipe);
                drugList.add(drug);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return drugList;
    }

    @Override
    public Drug getById(int id) {
        Drug drug = new Drug();
        try (Connection conn = JDBCConnector.getConnection()) {
            String sql = "select * from drugs where id=?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {

                    drug.setName(resultSet.getString(2));
                    drug.setCount(resultSet.getInt(3));
                    drug.setCost(resultSet.getInt(4));
                    drug.setRecipe(resultSet.getByte(5));
                    drug = new Drug(id, drug.getName(), drug.getCost(), drug.getCount(), drug.getRecipe());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return drug;
    }

    @Override
    public Drug deleteById(int id) {
        Drug drug = getById(id);
        try (Connection conn = JDBCConnector.getConnection()) {
            String sql = "DELETE FROM drugs WHERE id = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                preparedStatement.execute();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return drug;
    }


    @Override
    public Drug updateById(Drug drug) {
        System.out.println(99);
         try (Connection conn = JDBCConnector.getConnection()) {
            String sql = "UPDATE drugs SET name = ?,  count = ?, cost = ?, recipe = ? where id = ? ";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, drug.getName());
                preparedStatement.setInt(2, drug.getCount());
                preparedStatement.setInt(3, drug.getCost());
                preparedStatement.setByte(4, drug.getRecipe());
                preparedStatement.setInt(5, drug.getId());
                preparedStatement.execute();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return drug;
    }

    @Override
    public Drug create(Drug cure) {
        try (Connection conn = JDBCConnector.getConnection()) {
            String sql = "insert into drugs (name, count, cost," +
                    "recipe) values (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, cure.getName());
                preparedStatement.setInt(2, cure.getCost());
                preparedStatement.setInt(3, cure.getCount());
                preparedStatement.setByte(4, cure.getRecipe());
                preparedStatement.execute();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return cure;
    }

}
