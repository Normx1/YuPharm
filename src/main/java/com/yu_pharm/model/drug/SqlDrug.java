package com.yu_pharm.model.drug;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlDrug implements Drug {

	private final int id;
	private final Connection connection;


	public SqlDrug(int id, Connection connection) {
		this.id = id;
		this.connection = connection;
	}


	@Override
	public int id() {
		return id;
	}

	@Override
	public <T> T get(String key, Class<T> type) {
		try {
			assertNoBacktick(key);
			try (PreparedStatement st = connection.prepareStatement("select `" + key + "` from drugs where id=?")) {
				st.setInt(1, id);
				ResultSet result = st.executeQuery();
				result.next();
				return result.getObject(1, type);
			}
		} catch (Exception ex) {
			throw new RuntimeException("Failed to request info about " + this, ex);
		}
	}

	private void assertNoBacktick(String columnName) {
		if (columnName.contains("`")) {
			throw new IllegalArgumentException("Key '" + columnName + "' contains escape backtick (`) char");
		}
	}

	@Override
	public <T> void set(String key, T value) {
		try {
			assertNoBacktick(key);
			try (PreparedStatement st = connection.prepareStatement("update drugs set `" + key + "` = ? where id = ? ")) {
				st.setObject(1, value);
				st.setInt(2, id);
				st.executeUpdate();
			}
		} catch (Exception ex) {
			throw new RuntimeException("Failed to update info about " + this, ex);
		}
	}

	@Override
	public void delete() {
		try (PreparedStatement st = connection.prepareStatement("delete from drugs where id = ?")) {
			st.setInt(1, id);
			st.execute();
		} catch (Exception ex) {
			throw new RuntimeException("Failed to delete " + this, ex);
		}
	}

	@Override
	public String toString() {
		return "SqlDrug{id=" + id + '}';
	}
}
