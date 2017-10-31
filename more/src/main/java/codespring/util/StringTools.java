package codespring.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

/**
 * <p>
 * 常用工具组件
 * </p>
 *
 * <p>
 * 系统中用到的各种小程序，如字符串ISO转换到国标，字符串国标转换为ISO，字符串分割，文件拷贝、移动、删除。
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 *
 * @dgh 2017.04.28
 * @version 1.0
 */
public class StringTools {

	public StringTools() {
	}

	/**
	 * 字符串数据判空
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean checkIsNull(String str) {
		if (str == null)
			return false;
		else
			return true;
	}

	/**
	 * 字符串是否由数字组成
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean checkIsNum(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!((str.charAt(i) >= 48 && str.charAt(i) <= 57))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 字符串是否由字母组成
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean checkIsChar(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!((str.charAt(i) >= 65 && str.charAt(i) <= 90) || (str.charAt(i) >= 97 && str.charAt(i) <= 122))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 字符串是否由大写字母组成
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean checkIsUpperChar(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!((str.charAt(i) >= 65 && str.charAt(i) <= 90))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 字符串是否由字母、数字组成
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean checkIsNumChar(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!((str.charAt(i) >= 48 && str.charAt(i) <= 57) || (str.charAt(i) >= 65 && str.charAt(i) <= 90)
					|| (str.charAt(i) >= 97 && str.charAt(i) <= 122))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 字符串是否由大写字母、数字组成
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean checkIsNumUpperChar(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!((str.charAt(i) >= 48 && str.charAt(i) <= 57) || (str.charAt(i) >= 65 && str.charAt(i) <= 90))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 由字符串数组得到字符串
	 * 
	 * @param str
	 *            String[]
	 * @return String
	 */
	public static String getArryToString(String[] str) {
		int i = 0;
		String strArry = "";
		strArry = str[0];
		for (i = 1; i < str.length; i++) {
			strArry = strArry + "," + str[i];
		}
		return strArry;
	}

	/**
	 * 由字符串数组得到字符串
	 * 
	 * @param str
	 *            String[]
	 * @return String
	 */
	public static String getArryToString(String[] str, String strstr) {
		int i = 0;
		String strArry = "";
		strArry = str[0];
		for (i = 1; i < str.length; i++) {
			strArry = strArry + strstr + str[i];
		}
		return strArry;
	}

	/**
	 * 字符串的字节长度
	 * 
	 * @param str
	 * @return
	 */
	public static int trueLength(String str) {
		int lenTotal = 0;
		int n = str.length();
		String strWord = "";
		int asc;
		for (int i = 0; i < n; i++) {
			asc = str.charAt(i);
			if (asc < 0 || asc > 127)
				lenTotal = lenTotal + 2;
			else
				lenTotal = lenTotal + 1;
		}
		return lenTotal;
	}

	/**
	 * 由数字得到指定长度的字符串，用char前填充
	 * 
	 * @param number
	 *            int
	 * @param len
	 *            int
	 * @param pos
	 *            boolean
	 * @param cValue
	 *            char
	 * @return String
	 */
	public synchronized static String getStringFromNumber(int number, int len, boolean pos, char cValue) {
		String str = "";
		String strtp = "";
		str = String.valueOf(number);

		if (str.length() >= len) {
			return str;
		} else {
			for (int i = 0; i < len - str.length(); i++)
				strtp = strtp + String.valueOf(cValue);

		}
		if (pos == true) // ǰ��
		{
			return strtp + str;
		} else // ����
		{
			return str + strtp;
		}
	}

	/**
	 * 由数字得到3位逗号分割的字符串
	 * 
	 * @param number
	 *            int
	 * @return String
	 */
	public static String getNumberTo3String(String str) {
		String strRtn = "";
		if (str.length() > 3) {
			strRtn = str.substring(str.length() - 3, str.length());
			for (int i = str.length() - 3; i > 0; i = i - 3) {
				if (i > 3)
					strRtn = str.substring(i - 3, i) + "," + strRtn;
				else
					strRtn = str.substring(0, i) + "," + strRtn;
			}
		} else
			strRtn = str;
		return strRtn;
	}

	/**
	 * 字符串截取，strSource是要分割的字符串，strSeparator为分割符
	 * 
	 * @param strSource
	 *            String
	 * @param strSeparator
	 *            String
	 * @return String[]
	 */
	public static String[] parseString(String strSource, String strSeparator) {
		int i, npos, nLen, nSpLen;
		String source;
		String[] strArr = new String[1];
		if (strSource == null || strSeparator == null) {
			strArr[0] = "";
			return strArr;
		}
		if ((nLen = (source = strSource.trim()).length()) < 1) {
			strArr[0] = "";
			return strArr;
		}
		if ((nSpLen = strSeparator.length()) < 1) {
			strArr[0] = source;
			return strArr;
		}

		ArrayList list = new ArrayList();
		i = 0;
		while (i < nLen) {
			if ((npos = source.indexOf(strSeparator, i)) < 0) {
				list.add(source.substring(i).trim());
				break;
			}
			if (npos == i) {
				i += nSpLen;
				continue;
			}
			list.add(source.substring(i, npos).trim());
			i = npos + nSpLen;
		}
		if (list.size() > 0)
			return (String[]) list.toArray(new String[0]);
		else {
			strArr[0] = "";
			return strArr;
		}
	}

	/**
	 * 字符串数据判断长度
	 * 
	 * @param str
	 *            String
	 * @param type
	 *            String
	 * @param len
	 *            int
	 * @return boolean
	 */
	public static boolean checkLength(String str, String type, int len) {
		if (type.equals("<")) {
			if (str.length() > len) {
				return false;
			} else {
				return true;
			}
		} else if (type.equals(">")) {
			if (str.length() < len) {
				return false;
			} else {
				return true;
			}

		} else if (type.equals("=")) {
			if (str.length() != len) {
				return false;
			} else {
				return true;
			}
		} else
			return false;
	}

	/**
	 * Java文件操作 获取不带扩展名的文件名
	 * 
	 * Created on: 2017-04-28 by: fxf
	 */
	public static String getFileNameNoEx(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int dot = filename.lastIndexOf('.');
			if ((dot > -1) && (dot < (filename.length()))) {
				return filename.substring(0, dot);
			}
		}
		return filename;
	}

	/**
	 * Java文件操作 获取文件扩展名
	 * 
	 * Created on: 2017-04-28 by: fxf
	 */
	public static String getExtensionName(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int dot = filename.lastIndexOf('.');
			if ((dot > -1) && (dot < (filename.length() - 1))) {
				return filename.substring(dot + 1);
			}
		}
		return filename;
	}
	
	/**
	 * 转码
	 * 
	 * @param str
	 * @return
	 */
	public static String URLDecoderToUtf8(String str) {
		if (StringUtils.isEmpty(str))
			return null;
		try {
			str = URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

}
