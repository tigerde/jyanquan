package com.anquan.jy.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class AnquanConfig {
	private static Logger logger=Logger.getLogger(AnquanConfig.class);//
	private static Properties prop;
	
	static {

		InputStream is = null;

		 prop = new Properties();

		try {
			is = AnquanConfig.class
					.getResourceAsStream("/config.properties");
			prop.load(is);
			// host = prop.getProperty("mysql_host");
		} catch (IOException e) {
			logger.error("配置文件流创建失败,确认文件存在", e);
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				logger.error("配置文件读取流关闭失败", e);
			}
		}

	}
	
	//读取配置文件属性
	public static String getValueByKey(String key){
		return prop.getProperty(key);
	}
	
}	
