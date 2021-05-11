package com.yu_pharm.dao;

import com.yu_pharm.model.Drug;
import com.yu_pharm.model.Order;
import com.yu_pharm.model.User;
import com.yu_pharm.sql.JDBCConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDao_Imp implements OrderDao {
	@Override
	public List<Order> getAll() {
		List<Order> orderList = new ArrayList<>();
		DrugDao drugDao = new DrugDao();
		UserDao userDao = new UserDao();
		try (Connection conn = JDBCConnector.getConnection();
			 Statement statement = conn.createStatement();
			 ResultSet resultSet = statement.executeQuery("select * from orders");) {
			//Получем все элементы таблицы
			while (resultSet.next()) {
				int Order_id = resultSet.getInt(1);
				int drugId = resultSet.getInt(2);
				int userId = resultSet.getInt(3);
				String drugName = drugDao.getById(drugId).getName();
				String userName = userDao.getById(userId).getName();

				int count = resultSet.getInt(4);
				int cost = resultSet.getInt(5);
				Order<String, String> order = new Order<String, String>(Order_id, drugName, userName, count, cost);
				orderList.add(order);
				orderList.stream().forEach(order1 -> System.out.println(order1.getUser()));
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return orderList;
	}

	@Override
	public Order<String, String> getByOrderId(int orderId) {
		Order<String, String> order = new Order<String, String>();
		DrugDao drugDao = new DrugDao();
		UserDao userDao = new UserDao();

		try (Connection conn = JDBCConnector.getConnection();) {
			String sql = "select * from orders where  id_order=?";
			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
				preparedStatement.setInt(1, orderId);
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					order.setId_Order(resultSet.getInt(1));

					int drugId = resultSet.getInt(2);
					int userId = resultSet.getInt(3);
					String drugName = drugDao.getById(drugId).getName();
					String userName = userDao.getById(userId).getName();
					System.out.println(userId);
					order.setDrug(drugName);
					order.setUser(userName);

					order.setCount(resultSet.getInt(4));
					order.setCost(resultSet.getInt(5));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return order;
	}

	@Override
	public Order<String, String> getByUserId(int userId) {
		Order<String, String> order = new Order<String, String>();
		DrugDao drugDao = new DrugDao();
		UserDao userDao = new UserDao();

		try (Connection conn = JDBCConnector.getConnection();) {
			String sql = "select * from orders where id_user=?";
			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
				preparedStatement.setInt(1, userId);
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					order.setId_Order(resultSet.getInt(1));

					int drugId = resultSet.getInt(2);
					String drugName = drugDao.getById(drugId).getName();

					String userName = userDao.getById(userId).getName();

					order.setDrug(drugName);
					order.setUser(userName);

					order.setCount(resultSet.getInt(4));
					order.setCost(resultSet.getInt(5));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return order;
	}

	@Override
	public Order<String, String> getByUserName(String userName) {
		Order<String, String> order = new Order<String, String>();
		DrugDao drugDao = new DrugDao();
		UserDao userDao = new UserDao();
		int userId = (userDao.getByName(userName)).getId();
		try (Connection conn = JDBCConnector.getConnection();) {
			String sql = "select * from orders where id_user=?";
			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
				preparedStatement.setInt(1, userId);
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					order.setId_Order(resultSet.getInt(1));
					int drugId = resultSet.getInt(3);
					String drugName = drugDao.getById(drugId).getName();

					order.setDrug(drugName);
					order.setUser(userName);

					order.setCount(resultSet.getInt(4));
					order.setCost(resultSet.getInt(5));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return order;
	}

	@Override
	public Order<String, String> getByDrugName(String drugName) {
		Order<String, String> order = new Order<String, String>();
		DrugDao drugDao = new DrugDao();
		UserDao userDao = new UserDao();
		int drugId = (drugDao.getByName(drugName)).getId(); //не риализованыый метод поиска лекарства по имени
		try (Connection conn = JDBCConnector.getConnection();) {
			String sql = "select * from orders where id_drug=?";
			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
				preparedStatement.setInt(1, drugId);
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					order.setId_Order(resultSet.getInt(1));
					int userId = resultSet.getInt(2);
					String userName = userDao.getById(userId).getName();

					order.setDrug(drugName);
					order.setUser(userName);

					order.setCount(resultSet.getInt(4));
					order.setCost(resultSet.getInt(5));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return order;
	}

	@Override
	public Order deleteById(int id) {
		Order order = getByOrderId(id);
		try (Connection conn = JDBCConnector.getConnection()) {
			String sql = "DELETE FROM orders WHERE id_order = ?";
			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
				preparedStatement.setInt(1, id);
				preparedStatement.execute();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return order;
	}

	@Override
	public Object updateById(Order order) {
		try (Connection conn = JDBCConnector.getConnection()) {
			String sql = "UPDATE orders SET id_drug = ?,  id_user = ?,  count = ?, cost = ? where id_order = ? ";
			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
				preparedStatement.setInt(1, (int) order.getDrug());
				preparedStatement.setInt(2, (int) order.getUser());
				preparedStatement.setInt(3, order.getCount());
				preparedStatement.setInt(4, order.getCost());
				preparedStatement.setInt(5, order.getId_Order());

				preparedStatement.execute();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return order;
	}

	@Override
	public Object create(Order order) {
		try (Connection conn = JDBCConnector.getConnection()) {
			String sql = "insert into orders (id_drug, id_user,  count," +
					"cost) values (?, ?, ?, ?)";
			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
				preparedStatement.setInt(1, (Integer) order.getUser());
				preparedStatement.setInt(2, (Integer) order.getDrug());
				preparedStatement.setInt(3, order.getCount());
				preparedStatement.setInt(4, order.getCost());
				preparedStatement.execute();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return order;
	}
}



