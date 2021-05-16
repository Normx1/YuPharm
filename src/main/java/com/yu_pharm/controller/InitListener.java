package com.yu_pharm.controller;

import com.yu_pharm.dao.BasicDao;
import com.yu_pharm.dao.OrderDao;
import com.yu_pharm.dao.OrderDao_Imp;
import com.yu_pharm.model.Order;
import com.yu_pharm.model.drug.Drugs;
import com.yu_pharm.model.drug.SimpleDrugs;
import com.yu_pharm.model.drug.SqlDrugs;
import com.yu_pharm.sql.JDBCConnector;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;
import java.util.Map;

@WebListener
public class InitListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			Drugs.Smart drugs = new Drugs.Smart(new SqlDrugs(JDBCConnector.getConnection()));
			OrderDao<Order> orders = new OrderDao_Imp(drugs);
			//sce.getServletContext().setAttribute("drugs", drugs);
			sce.getServletContext().setAttribute("orders", orders);
			sce.getServletContext().setAttribute("drugs", new Drugs.Smart(
					new SimpleDrugs(List.of(
							Map.of("name", "Test_name",
									"description", "Test_description",
									"cost", 12.5,
									"count", 1.0,
									"recipe", (byte) 12,
									"price", 13.5)
					))
			));
		} catch (Exception ex) {
			throw new RuntimeException("Failed add drugs to servlet context", ex);
		}
	}
}
