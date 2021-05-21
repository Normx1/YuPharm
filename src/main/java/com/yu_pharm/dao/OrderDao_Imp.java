package com.yu_pharm.dao;

import com.yu_pharm.model.Order;
import com.yu_pharm.model.Payment;
import com.yu_pharm.model.drug.Drugs;
import com.yu_pharm.sql.JDBCConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
				Map<Integer, Integer> drugId = parseDrugs(resultSet.getString(2));
				String name = resultSet.getString(3);
				String mail = resultSet.getString(4);
				String phone = resultSet.getString(5);
				String address = resultSet.getString(6);
				double cost = resultSet.getDouble(7);
				Payment payment = Payment.valueOf(resultSet.getString(8));
				Order order = new Order(Order_id, drugId, name, mail, phone, address, cost, payment);
				orderList.add(order);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return orderList;
	}

	public static String formatDrugs(Map<Integer, Integer> drugs) {
		return drugs.entrySet().stream()
				.map(e -> e.getKey() + "=" + e.getValue())
				.collect(Collectors.joining(",", "{", "}"));
	}

	public static Map<Integer, Integer> parseDrugs(String str) {
		Matcher m = Pattern.compile("(?<key>\\d+)=(?<value>\\d+)").matcher(str);
		Map<Integer, Integer> result = new LinkedHashMap<>();
		while (m.find()) {
			result.put(Integer.parseInt(m.group("key")), Integer.parseInt(m.group("value")));
		}
		return result;
	}

	@Override
	public Order getByOrderId(int orderId) {
		Order order = new Order(orderId);
		try (Connection conn = JDBCConnector.getConnection();) {
			String sql = "select * from orders where  id_order=?";
			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
				preparedStatement.setInt(1, orderId);
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					int Order_id = resultSet.getInt(1);
					Map<Integer, Integer> drugId = parseDrugs(resultSet.getString(2));
					String userName = resultSet.getString(3);
					String mail = resultSet.getString(4);
					String phone = resultSet.getString(5);
					String address = resultSet.getString(6);
					double cost = resultSet.getDouble(7);
					Payment payment = Payment.valueOf(resultSet.getString(8));
					order = new Order(Order_id, drugId, userName, mail, phone, address, cost, payment);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return order;
	}

	@Override
	public Order getByUserId(int userId) {
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
	public Order getByUserName(String userName) {
		Order order = new Order();

		try (Connection conn = JDBCConnector.getConnection();) {
			String sql = "select * from orders where name=?";
			try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
				preparedStatement.setString(1, userName);
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					int Order_id = resultSet.getInt(1);
					Map<Integer, Integer> drugId = parseDrugs(resultSet.getString(2));
					String mail = resultSet.getString(4);
					String phone = resultSet.getString(5);
					String address = resultSet.getString(6);
					double cost = resultSet.getDouble(7);
					Payment payment = Payment.valueOf(resultSet.getString(8));
					order = new Order(Order_id, drugId, userName, mail, phone, address, cost, payment);
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
				preparedStatement.setString(1, formatDrugs(order.getDrugs()));
				preparedStatement.setString(2, (String) order.getUser());
				preparedStatement.setString(3, order.getMail());
				preparedStatement.setString(4, order.getPhone());
				preparedStatement.setString(5, order.getAddress());
				preparedStatement.setDouble(6, order.getCost());
				preparedStatement.setString(7, order.getPayment().name());
				preparedStatement.setInt(8, order.getId());

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
				preparedStatement.setString(1,  formatDrugs(order.getDrugs()));
				preparedStatement.setString(2, (String) order.getUser());
				preparedStatement.setString(3, order.getMail());
				preparedStatement.setString(4, order.getPhone());
				preparedStatement.setString(5, order.getAddress());
				preparedStatement.setString(6, order.getPayment().name());
				preparedStatement.setDouble(7, order.getCost());
				preparedStatement.execute();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		return order;
	}
}



