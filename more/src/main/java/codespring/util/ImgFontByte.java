package codespring.util;

import com.google.common.io.Resources;

import java.awt.*;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * 设置图片验证码的字体
 *
 * @author fxf
 * @create 2017-12-01 13:32
 **/

public class ImgFontByte {

	/**
	 * 转换字体
	 */
	public Font getFont(int fontHeight) {
		try {
			Font baseFont = Font.createFont(Font.TRUETYPE_FONT, new ByteArrayInputStream(hex2byte(getFontByteStr())));
			return baseFont.deriveFont(Font.PLAIN, fontHeight);
		} catch (Exception e) {
			return new Font("Arial", Font.PLAIN, fontHeight);
		}
	}

	/**
	 *处理字体
	 * @param str
	 * @return
	 */
	private byte[] hex2byte(String str) {
		if (str == null)
			return null;
		str = str.trim();
		int len = str.length();
		if (len == 0 || len % 2 == 1)
			return null;

		byte[] b = new byte[len / 2];
		try {
			for (int i = 0; i < str.length(); i += 2) {
				b[i / 2] = (byte) Integer
						.decode("0x" + str.substring(i, i + 2)).intValue();
			}
			return b;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * ttf字体文件的十六进制字符串
	 *	读取otf字体
	 * @return
	 */
	private String getFontByteStr() {

		BufferedInputStream bufferedInputStream = null;
		try {
			bufferedInputStream = (BufferedInputStream) Resources.getResource("Azedo-Light.otf").getContent();
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] bs = new byte[1024];
		try {
			while (bufferedInputStream.read(bs) != -1) {
				return new String(bs);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static void main(String[] args) {
		ImgFontByte imgFontByte = new ImgFontByte();
		System.out.printf(imgFontByte.getFont(100).toString());
	}
}