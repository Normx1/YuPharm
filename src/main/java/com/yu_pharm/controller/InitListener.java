package com.yu_pharm.controller;

import com.yu_pharm.dao.OrderDao;
import com.yu_pharm.dao.OrderDao_Imp;
import com.yu_pharm.model.Order;
import com.yu_pharm.model.drug.Drug;
import com.yu_pharm.model.drug.Drugs;
import com.yu_pharm.model.drug.SimpleDrugs;
import com.yu_pharm.model.drug.SqlDrugs;
import com.yu_pharm.sql.ConnectionSource;
import com.yu_pharm.util.Config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitListener implements ServletContextListener {

	private final ConnectionSource connection = new ConnectionSource();


	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			Drugs.Smart drugs = new Drugs.Smart(getDrugs());
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

	private Drugs<Drug> getDrugs() {
		return switch (Config.get("data.drugs")) {
			case "sql" -> new SqlDrugs(connection);
			case "in_memory" -> new SimpleDrugs();
			default -> throw new RuntimeException();
		};
	}
}
