package com.yu_pharm.controller;

import com.yu_pharm.dao.OrderDao;
import com.yu_pharm.dao.OrderDao_Imp;
import com.yu_pharm.model.Order;
import com.yu_pharm.model.drug.Drugs;
import com.yu_pharm.model.drug.SqlDrugs;
import com.yu_pharm.sql.JDBCConnector;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.function.Supplier;

@WebListener
public class InitListener implements ServletContextListener {

	private final ConnectionSource connection = new ConnectionSource();


	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			Drugs.Smart drugs = new Drugs.Smart(new SqlDrugs(connection));
			OrderDao<Order> orders = new OrderDao_Imp(drugs);
			sce.getServletContext().setAttribute("drugs", drugs);
			sce.getServletContext().setAttribute("orders", orders);
		} catch (Exception ex) {
			throw new RuntimeException("Failed to setup application", ex);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		connection.close();
	}
}

class ConnectionSource implements Supplier<Connection>, AutoCloseable {

	private Connection connection;


	@Override
	public synchronized Connection get() {
		try {
			if (connection == null) {
				connection = JDBCConnector.getConnection();
			}
			return connection;
		} catch (SQLException ex) {
			throw new RuntimeException("Failed to get connection to db", ex);
		}
	}

	@Override
	public synchronized void close() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException ex) {
				throw new RuntimeException("Failed to close connection to db", ex);
			} finally {
				connection = null;
			}
		}
	}
}
