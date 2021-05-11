package com.yu_pharm.dao;

 import com.yu_pharm.model.Drug;
import com.yu_pharm.model.Order;
import com.yu_pharm.model.Recipe;
import com.yu_pharm.model.User;
import com.yu_pharm.sql.JDBCConnector;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecipeDaoImpl implements RecipeDao {
	@Override
	public List<Recipe> getAll() {
		List<Recipe> recipeList = new ArrayList<>();
		try (Connection conn = JDBCConnector.getConnection();
			 Statement statement = conn.createStatement();
			 ResultSet resultSet = statement.executeQuery("select * from recipies");) {
			//Получем все элементы таблицы
			while (resultSet.next()) {
				int recId = resultSet.getInt(1);
				int drugId = resultSet.getInt(2);
				int userId = resultSet.getInt(3);
				Date expDate = resultSet.getDate(4);
				int cost = resultSet.getInt(5);
				Recipe recipe = new Recipe(recId, drugId, userId, expDate);
				recipeList.add(recipe);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return recipeList;
	}

	@Override
	public Recipe getById(int id) {
		Recipe recipe = new Recipe();
		try (Connection conn = JDBCConnector.getConnection();) {
			String sql = "select * from recipies where  recId=?";
			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
				preparedStatement.setInt(1, id);
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					int drugId = resultSet.getInt(2);
					int userId = resultSet.getInt(3);
					Date expDate = resultSet.getDate(4);
					recipe = new Recipe(id, drugId, userId, expDate);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return recipe;
	}

	@Override
	public Object deleteById(int id) {
		Recipe recipe = getById(id);

		try (Connection conn = JDBCConnector.getConnection()) {
			String sql = "DELETE FROM recipies WHERE recId = ?";
			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
				preparedStatement.setInt(1, id);
				preparedStatement.execute();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return recipe;
	}

	@Override
	public Recipe updateById(Recipe recipe) {
		try (Connection conn = JDBCConnector.getConnection()) {
			String sql = "UPDATE recipies SET drugId = ?,  userId = ?, expDate = ? where recId = ? ";
			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

				preparedStatement.setInt(1, recipe.getDrugId());
				preparedStatement.setInt(2, recipe.getUserId());
				preparedStatement.setDate(3, (java.sql.Date) recipe.getExpDate());
				preparedStatement.setInt(4, recipe.getRecId());
				preparedStatement.execute();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return recipe;
	}

	@Override
	public Recipe create(Recipe recipe) {
		try (Connection conn = JDBCConnector.getConnection()) {
			String sql = "insert into recipies (drugId, userId, expDate) values (?, ?, ?)";
			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
				preparedStatement.setInt(1, recipe.getDrugId());
				preparedStatement.setInt(2, recipe.getUserId());
				preparedStatement.setDate(3, (java.sql.Date) recipe.getExpDate());
				preparedStatement.execute();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return recipe;
	}

	@Override
	public Object getByUserName(String name) {
		List<Recipe> recipeList = new ArrayList<>();
		BasicDao<User> userDao = new UserDao();
		int userId = (userDao.getByName(name)).getId();
		try (Connection conn = JDBCConnector.getConnection()) {
			String sql = "select * from recipies where drugId=?";
			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
				preparedStatement.setInt(1, userId);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					int recId = resultSet.getInt(1);
					int drugId = resultSet.getInt(2);
					Date expDate = resultSet.getDate(4);
					Recipe recipe = new Recipe(recId, drugId, userId, expDate);
					recipeList.add(recipe);
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return recipeList;
	}


	@Override
	public Object getByDrugName(String name) {
		List<Recipe> recipeList = new ArrayList<>();
		BasicDao<Drug> drugBasicDao = new DrugDao();
		int drugId = (drugBasicDao.getByName(name)).getId();
		try (Connection conn = JDBCConnector.getConnection()) {
			String sql = "select * from recipies where userId=?";
			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
				preparedStatement.setInt(1, drugId);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					int recId = resultSet.getInt(1);
					int userId = resultSet.getInt(3);
					Date expDate = resultSet.getDate(4);
					Recipe recipe = new Recipe(recId, drugId, userId, expDate);
					recipeList.add(recipe);
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return recipeList;
	}
}
