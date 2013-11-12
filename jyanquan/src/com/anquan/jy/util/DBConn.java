package com.anquan.jy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

public class DBConn {
	private static Logger logger=Logger.getLogger(DBConn.class);

	private static String host;
	private static String port;
	private static String dbname;
	private static String url;
	private static String username;
	private static String password;

	static {
		host = AnquanConfig.getValueByKey("mysql_host");
		port = AnquanConfig.getValueByKey("mysql_port");
		dbname = AnquanConfig.getValueByKey("mysql_dbname");
		url = "jdbc:mysql://" + host + ":" + port + "/" + dbname
				+ "?useUnicode=true&characterEncoding=utf-8";
		username = AnquanConfig.getValueByKey("mysql_username");
		password = AnquanConfig.getValueByKey("mysql_password");

	}

	/**
	 * 获取数据库连接
	 * 
	 * @throws SQLException
	 */

	public static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

		} catch (IllegalAccessException e) {
			logger.error("安全权限异常", e);

		} catch (InstantiationException e) {
			logger.error("初始化失败", e);

		} catch (ClassNotFoundException e) {
			logger.error("找不到类", e);
		}

		try {
			// DriverManager.setLoginTimeout(10);
			conn = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			logger.error("数据库连接失败！", e);
		}
		return conn;

	}

	/**
	 * 关闭结果集、访问对象、连接对象；
	 */

	public static void close(ResultSet rs, PreparedStatement ps, Connection conn) {

		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			logger.error("对象关闭失败", e);
		}
	}
}
