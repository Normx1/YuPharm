package com.yu_pharm.model.drug;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		try (PreparedStatement st = connection.prepareStatement("select ? from drugs where id=?")) {
			st.setString(1, key);
			st.setInt(2, id);
			return st.getResultSet().getObject(0, type);
		} catch (SQLException ex) {
			throw new RuntimeException("Failed to request info about " + this, ex);
		}
	}

	@Override
	public <T> void set(String key, T value) {
		try (PreparedStatement st = connection.prepareStatement("update drugs set ? = ? where id = ? ")) {
			st.setString(1, key);
			st.setObject(2, value);
			st.setInt(3, id);
		} catch (SQLException ex) {
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
