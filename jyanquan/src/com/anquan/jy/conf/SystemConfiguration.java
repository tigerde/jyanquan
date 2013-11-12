package com.anquan.jy.conf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 读取配置文件
 * 
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhaotj
 * 
 */
public class SystemConfiguration {
	private static Logger logging = Logger.getLogger(SystemConfiguration.class);
	private static String mysql_host;// 数据库服务器地址
	private static String mysql_dbname;// 数据库名
	private static String mysql_port;// 数据库主机端口号
	private static String mysql_username;// 数据库用户名
	private static String mysql_password;// 数据库密码
	static {
		InputStream is = null;
		try {
			File f = new File("config.properties");
			Properties prop = new Properties();
			if (f.exists()) {
				is = SystemConfiguration.class
						.getResourceAsStream("/config.properties");
				;
				prop.load(is);
				SystemConfiguration.mysql_host = prop.getProperty("mysql_host");
				SystemConfiguration.mysql_dbname = prop
						.getProperty("mysql_dbname");
				SystemConfiguration.mysql_port = prop.getProperty("mysql_port");
				SystemConfiguration.mysql_username = prop
						.getProperty("mysql_username");
				SystemConfiguration.mysql_password = prop
						.getProperty("mysql_password");

			} else {
				OutputStream os = new FileOutputStream(f);
				prop.setProperty("mysql_host", "192.168.0.4");
				prop.setProperty("mysql_dbname", "spider");
				prop.setProperty("mysql_port", "3306");
				prop.setProperty("mysql_username", "xx");
				prop.setProperty("mysql_password", "xx");
				logging.error("确认配置文件");
				System.exit(0);
			}
		} catch (IOException e) {
			logging.error("io异常");
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				logging.error("io异常");
			}
		}
	}

	public static String getMysql_host() {
		return mysql_host;
	}

	public static void setMysql_host(String mysqlHost) {
		mysql_host = mysqlHost;
	}

	public static String getMysql_dbname() {
		return mysql_dbname;
	}

	public static void setMysql_dbname(String mysqlDbname) {
		mysql_dbname = mysqlDbname;
	}

	public static String getMysql_port() {
		return mysql_port;
	}

	public static void setMysql_port(String mysqlPort) {
		mysql_port = mysqlPort;
	}

	public static String getMysql_username() {
		return mysql_username;
	}

	public static void setMysql_username(String mysqlUsername) {
		mysql_username = mysqlUsername;
	}

	public static String getMysql_password() {
		return mysql_password;
	}

	public static void setMysql_password(String mysqlPassword) {
		mysql_password = mysqlPassword;
	}

}
