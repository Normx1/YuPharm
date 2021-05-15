package com.yu_pharm.model.drug;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SqlDrugs implements Drugs {

	private final Connection connection;


	public SqlDrugs(Connection connection) {
		this.connection = connection;
	}


	@Override
	public Drug create() {
		try (PreparedStatement st = connection.prepareStatement("insert into drugs output id values ('')")) {
			ResultSet resultSet = st.executeQuery();
			return new SqlDrug(resultSet.getInt(1), connection);
		} catch (Exception ex) {
			throw new RuntimeException("Failed to create new drug", ex);
		}
	}

	@Override
	public List<Drug> all() {
		try (PreparedStatement st = connection.prepareStatement("select id from drugs")) {
			ResultSet resultSet = st.executeQuery();
			List<Drug> result = new ArrayList<>();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				result.add(new SqlDrug(id, connection));
			}
			return result;
		} catch (Exception ex) {
			throw new RuntimeException("Failed to fetch drugs", ex);
		}
	}
}
