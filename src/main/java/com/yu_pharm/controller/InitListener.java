package com.yu_pharm.controller;

import com.yu_pharm.model.drug.Drugs;
import com.yu_pharm.model.drug.SqlDrugs;
import com.yu_pharm.sql.JDBCConnector;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			sce.getServletContext().setAttribute("drugs", new Drugs.Smart(new SqlDrugs(JDBCConnector.getConnection())));
		} catch (Exception ex) {
			throw new RuntimeException("Failed add drugs to servlet context", ex);
		}
	}
}
