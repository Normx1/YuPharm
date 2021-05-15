package com.yu_pharm.model.drug;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
				st.setString(1, key);
				st.setInt(2, id);
				return st.getResultSet().getObject(1, type);
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
				st.setString(1, key);
				st.setObject(2, value);
				st.setInt(3, id);
				st.execute();
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
