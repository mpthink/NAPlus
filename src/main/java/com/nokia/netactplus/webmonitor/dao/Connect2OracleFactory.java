package com.nokia.netactplus.webmonitor.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.nokia.netactplus.common.exception.DAOExceptionOfOracle;

@Repository
public class Connect2OracleFactory {
	private final static Logger LOGGER = LoggerFactory.getLogger(Connect2OracleFactory.class);
	private final static String ORACLE_DIRVER = "oracle.jdbc.driver.OracleDriver";
	private String defaultHost = "localhost";
	private String defaultUser = "omc";
	private String defaultPassword = "omc";

	static {
		try {
			Class.forName(ORACLE_DIRVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getDBConnection() {
		return getDBConnection(defaultHost, defaultUser, defaultPassword);
	}

	@Cacheable(value = "connCache", key = "#host")
	public Connection getDBConnection(String host) {
		return getDBConnection(host, defaultUser, defaultPassword);
	}

	public Connection getDBConnection(String host, String user, String password) {
		String jdbcUrl = "jdbc:oracle:thin:@%s:1521:oss";
		jdbcUrl = String.format(jdbcUrl, host);
		Connection conn = null;
		Properties properties = new Properties();
		properties.put("user", user);
		properties.put("password", password);
		properties.put("oracle.net.CONNECT_TIMEOUT", "5000");

		try {
			conn = DriverManager.getConnection(jdbcUrl, properties);
		} catch (SQLException e) {
			LOGGER.error("Get connection failed on " + host, e);
			throw new DAOExceptionOfOracle("Get oracle connection failed for host: " + host, e);
		}
		return conn;
	}
}
