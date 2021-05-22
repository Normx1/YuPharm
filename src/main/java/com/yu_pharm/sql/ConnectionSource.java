package com.yu_pharm.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.function.Supplier;

public class ConnectionSource implements Supplier<Connection>, AutoCloseable {

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
