package com.android.ccny.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.description.AxisService;
import org.apache.axis2.engine.ServiceLifeCycle;

/**
 * @author qingjiezhao.
 * @email zhaoqingjie@gmail.com
 */
public class DBServiceLifeCycle implements ServiceLifeCycle {
	public static final String DB_CONNECTION = "dbconnection";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.axis2.engine.ServiceLifeCycle#startUp(org.apache.axis2.context
	 * .ConfigurationContext, org.apache.axis2.description.AxisService)
	 */
	public void startUp(ConfigurationContext configctx, AxisService service) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			// Creating the DB connection for the sample DB
			Connection conn = DriverManager.getConnection(
					//"jdbc:mysql://localhost:3306/mobapp1_cc", "mobapp1_mobapp1", "mobapp1_mobapp1");
					"jdbc:mysql://localhost:3306/ccny", "root", "");
			// Storing the DB in the ConfigurationContext
			configctx.setProperty(DB_CONNECTION, conn);
		} catch (Exception e) {
			System.out.println("Error while opening the DB connection");
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.axis2.engine.ServiceLifeCycle#shutDown(org.apache.axis2.context
	 * .ConfigurationContext, org.apache.axis2.description.AxisService)
	 */
	public void shutDown(ConfigurationContext configctx, AxisService service) {
		Connection conn = (Connection) configctx.getProperty(DB_CONNECTION);
		if (conn != null) {
			try {
				// closing the DB
				conn.close();
			} catch (SQLException e) {
				System.out.println("Error while closing the DB connection");
				e.printStackTrace();
			}
		}
	}
}
