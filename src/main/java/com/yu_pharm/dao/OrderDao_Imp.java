package com.yu_pharm.dao;

import com.yu_pharm.model.Order;
import com.yu_pharm.model.drug.Drugs;
import com.yu_pharm.sql.JDBCConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDao_Imp implements OrderDao {

	private final Drugs.Smart drugs;


	public OrderDao_Imp(Drugs.Smart drugs) {
		this.drugs = drugs;
	}


	@Override
	public List<Order> getAll() {
		List<Order> orderList = new ArrayList<>();
		try (Connection conn = JDBCConnector.getConnection();
			 Statement statement = conn.createStatement();
			 ResultSet resultSet = statement.executeQuery("select * from orders");) {
			//Получем все элементы таблицы
			while (resultSet.next()) {
				int Order_id = resultSet.getInt(1);
				int drugId = resultSet.getInt(2);
				String name = resultSet.getString(3);
				String mail = resultSet.getString(4);
				String phone = resultSet.getString(5);
				String address = resultSet.getString(6);
				int cost = resultSet.getInt(7);
				int payment = resultSet.getInt(8);

				String drugName = drugs.findById(drugId).name();

				Order<String, String> order = new Order<String, String>(Order_id, drugName, name, mail, phone, address, payment, cost);
				orderList.add(order);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return orderList;
	}

	@Override
	public Order<String, String> getByOrderId(int orderId) {
		Order<String, String> order = new Order<String, String>();

		try (Connection conn = JDBCConnector.getConnection();) {
			String sql = "select * from orders where  id_order=?";
			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
				preparedStatement.setInt(1, orderId);
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					int Order_id = resultSet.getInt(1);
					int drugId = resultSet.getInt(2);
					String userName = resultSet.getString(3);
					String mail = resultSet.getString(4);
					String phone = resultSet.getString(5);
					String address = resultSet.getString(6);
					int cost = resultSet.getInt(7);
					int payment = resultSet.getInt(8);
//					int count = resultSet.getInt(9);
					String drugName = drugs.findById(drugId).name();
					order = new Order<String, String>(Order_id, drugName, userName, mail, phone, address, cost, payment);
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
//		Order<String, String> order = new Order<String, String>();
//		UserDao userDao = new UserDao();
//
//		try (Connection conn = JDBCConnector.getConnection();) {
//			String sql = "select * from orders where id_user=?";
//			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
//				preparedStatement.setInt(1, userId);
//				ResultSet resultSet = preparedStatement.executeQuery();
//				if (resultSet.next()) {
//					order.setId_Order(resultSet.getInt(1));
//
//					int drugId = resultSet.getInt(2);
//					String drugName = drugs.findById(drugId).name();
//
//					String userName = userDao.getById(userId).getName();
//
//					order.setDrug(drugName);
//					order.setUser(userName);
//
//					order.setCount(resultSet.getInt(4));
//					order.setCost(resultSet.getInt(5));
//				}
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			throw new RuntimeException(ex);
//		}
//		return order;
		return null;
	}

	@Override
	public Order<String, String> getByUserName(String userName) {
		Order<String, String> order = new Order<String, String>();

		try (Connection conn = JDBCConnector.getConnection();) {
			String sql = "select * from orders where name=?";
			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
				preparedStatement.setString(1, userName);
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					int Order_id = resultSet.getInt(1);
					int drugId = resultSet.getInt(2);
					String mail = resultSet.getString(4);
					String phone = resultSet.getString(5);
					String address = resultSet.getString(6);
					int cost = resultSet.getInt(7);
					int payment = resultSet.getInt(8);
//					int count = resultSet.getInt(9);
					String drugName = drugs.findById(drugId).name();
					order = new Order<String, String>(Order_id, drugName, userName, mail, phone, address, cost, payment);

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
			String sql = "UPDATE orders SET drug = ?,  name = ?,  mail = ?, phone = ?, address = ?, cost = ?, payment = ?  where id_order = ? ";
			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
				preparedStatement.setInt(1, (int) order.getDrug());
				preparedStatement.setString(2, (String) order.getUser());
				preparedStatement.setString(3, order.getMail());
				preparedStatement.setString(4, order.getPhone());
				preparedStatement.setString(5, order.getAddress());
				preparedStatement.setInt(6, order.getCost());
				preparedStatement.setInt(7, order.getPayment());
				preparedStatement.setInt(8, order.getId_Order());

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
			String sql = "insert into orders (drug, name , mail, phone, address, payment, cost) values (?, ?, ?, ?, ?, ?, ?)";

			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
				preparedStatement.setInt(1, (Integer) order.getDrug());
				preparedStatement.setString(2, (String) order.getUser());
				preparedStatement.setString(3, order.getMail());
				preparedStatement.setString(4, order.getPhone());
				preparedStatement.setString(5, order.getAddress());
				preparedStatement.setInt(6, order.getPayment());
				preparedStatement.setInt(7, order.getCost());
				preparedStatement.execute();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return order;
	}
}



