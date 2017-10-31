package codeexcel.impl;

import codeexcel.util.CreatAndReadExcel;

import java.io.IOException;
import java.util.List;

/**
 * 去年同期数功能
 *
 * @author fxf
 * @create 2017-10-31 14:16
 **/

public class LastYearNumberImpl {

	/**
	 * excel 工具类 读取or写入
	 */
	private CreatAndReadExcel creatAndReadExcel = new CreatAndReadExcel();

	/**
	 * 读取excel表格
	 *
	 * @return
	 */
	public List<List<Object>> readExcel(String fileNamePath, int index) {
		List<List<Object>> listExcel = null;
		try {
			listExcel = creatAndReadExcel.readExcel(fileNamePath, index);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listExcel;
	}


}