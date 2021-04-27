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
                byte recipe =  resultSet.getByte(5);
                Drug drug = new Drug(id, name, cost, count,recipe);
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

                    drug.setId(resultSet.getInt(1));
                    drug.setName(resultSet.getString(2));
                    drug.setCount(resultSet.getInt(3));
                    drug.setCost(resultSet.getInt(4));
                    drug.setRecipe(resultSet.getByte(5));
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
    public Drug updateById(Drug cure) {
        Drug drug = getById(cure.getId());
        try (Connection conn = JDBCConnector.getConnection()) {
            String sql = "UPDATE drugs SET name = ?,  count = ?, cost = ?, recipe = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(2, cure.getName());
                preparedStatement.setInt(3, cure.getCount());
                preparedStatement.setInt(4, cure.getCost());
                preparedStatement.setByte(5, cure.getRecipe());
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
