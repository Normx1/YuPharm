package com.yu_pharm.model.drug;

import com.yu_pharm.sql.JDBCConnector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SqlDrugsTest {

	@Test
	public void databaseExists() throws Exception {
		Drugs drugs = new SqlDrugs(JDBCConnector.getConnection());
		assertDoesNotThrow(drugs::all);
	}

	@Test
	public void testCreateDelete() throws Exception {
		Drugs drugs = new SqlDrugs(JDBCConnector.getConnection());
		int initialSize = drugs.all().size();
		Drug drug = drugs.create();
		assertEquals(initialSize + 1, drugs.all().size());
		drug.delete();
		assertEquals(initialSize, drugs.all().size());
	}

	@Test
	public void testUpdate() throws Exception {
		Drugs drugs = new SqlDrugs(JDBCConnector.getConnection());
		Drug.Smart drug = new Drug.Smart(drugs.create());
		try {
			assertEquals("", drug.name());
			String newName = "Test";
			drug.name(newName);
			assertEquals(newName, drug.name());
		} finally {
			drug.delete();
		}
	}
}
