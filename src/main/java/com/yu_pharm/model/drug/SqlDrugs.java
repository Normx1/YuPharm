package com.yu_pharm.model.drug;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SqlDrugs implements Drugs<Drug> {

	private final Supplier<Connection> connection;


	public SqlDrugs(Connection connection) {
		this(() -> connection);
	}

	public SqlDrugs(Supplier<Connection> connection) {
		this.connection = connection;
	}


	@Override
	public Drug create() {
		String sql = "insert into drugs (name, count, cost) values ('', 0, 0)";
		try (PreparedStatement st = connection.get().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			st.executeUpdate();
			ResultSet keys = st.getGeneratedKeys();
			keys.next();
			return new SqlDrug(keys.getInt(1), connection.get());
		} catch (Exception ex) {
			throw new RuntimeException("Failed to create new drug", ex);
		}
	}

	@Override
	public List<Drug> all() {
		try (PreparedStatement st = connection.get().prepareStatement("select id from drugs")) {
			ResultSet resultSet = st.executeQuery();
			List<Drug> result = new ArrayList<>();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				result.add(new SqlDrug(id, connection.get()));
			}
			return result;
		} catch (Exception ex) {
			throw new RuntimeException("Failed to fetch drugs", ex);
		}
	}


}
