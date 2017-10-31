package codespring.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author fxf
 * @create 2017-10-23 14:30
 **/

public class PropertiesUtil {
	private static Properties configProperties = null;
	private static Properties jdbcProperties = null;
	private static Properties ftpProperties = null;

	static {
		try {
			configProperties = PropertiesUtil.load("config.properties");
			jdbcProperties = PropertiesUtil.load("jdbc.properties");
			ftpProperties = PropertiesUtil.load("ftp.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Properties load(String path) throws IOException {
		InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(path);
		Properties properties = new Properties();
		properties.load(in);
		return properties;
	}

	public static String getConfigProperty(String pName) {
		String value = "";
		try {
			value = (String) configProperties.get(pName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public static String getJDBCProperty(String pName) {
		String value = "";
		try {
			value = (String) jdbcProperties.get(pName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public static String getFTPProperty(String pName) {
		String value = "";
		try {
			value = (String) ftpProperties.get(pName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public static void updatePorperties(Properties properties, String path) {

		try {
			properties.store(new FileOutputStream(path), "");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}