package code.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取配置文件
 */
public class PropertiesUtil {

	private static Properties properties = null;
	static {
		try {
			properties = PropertiesUtil.load("config.properties");
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

	public static String getProperty(String pName) {
		String value = "";
		try {
			value = (String) properties.get(pName);
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
